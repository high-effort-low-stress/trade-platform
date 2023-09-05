package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.db.specifications.ApiSpecification;
import com.github.hels.tradeplatform.db.specifications.Input;
import com.github.hels.tradeplatform.db.specifications.Operator;
import com.github.hels.tradeplatform.onboarding.dto.domain.ViaCepDto;
import com.github.hels.tradeplatform.onboarding.exceptions.ApiException;
import com.github.hels.tradeplatform.onboarding.mappers.AddressMapper;
import com.github.hels.tradeplatform.onboarding.models.Address;
import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreateUserService {
    private final IUserRepository repository;
    private final Clock clock;
    private final ViaCepService viaCepService;
    private final AddressMapper addressMapper;

    public User execute(
            String name, String document, String email, String password, String phoneNumber,
            LocalDate birthDate, String zipCode, String complement, String streetNumber
    ) {

        validateLegalAge(birthDate);
        findDuplicates(document, email, phoneNumber);

        if (Objects.isNull(password))
            throw new RuntimeException("Password can't be null.");

        User user = new User();

        user.setName(name);
        user.setDocument(document);
        user.setEmail(email);
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        user.setPhoneNumber(phoneNumber);
        user.setBirthDate(birthDate);

        ViaCepDto viaCepDto = viaCepService.execute(zipCode);
        viaCepDto.setZipCode(zipCodeFormatter(zipCode));
        Address address = addressMapper.toAddress(viaCepDto);

        address.setStreetNumber(streetNumber);
        address.setComplement(complement);

        address.setUser(user);
        user.setAddress(List.of(address));

        return repository.save(user);
    }


    private void findDuplicates(String document, String email, String phoneNumber) {
        List<User> users = repository.findAll(buildSpecification(document, email, phoneNumber));

        if (!users.isEmpty())
            throw new ApiException("User already registered.");
    }

    private void validateLegalAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now(clock);

        if (Objects.isNull(birthDate))
            throw new RuntimeException("Birth date can't be null");

        if (Period.between(birthDate, currentDate).getYears() < 18)
            throw new ApiException("User must be 18+ years old");
    }

    private String zipCodeFormatter(String zipCode) {
        return zipCode.replace("-", "");
    }

    private ApiSpecification<User> buildSpecification(String document, String email, String phoneNumber) {
        Input<User> input = new Input<>();
        input
                .addRootField("document", Operator.EQUAL, document)
                .addRootField("email", Operator.EQUAL, email)
                .addRootField("phoneNumber", Operator.EQUAL, phoneNumber)
                .addRootField("isActive", Operator.EQUAL, true);

        return ApiSpecification.<User>builder()
                .input(input)
                .build();
    }

}
