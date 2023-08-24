package com.github.hels.tradeplatform.onboarding.repository;

import com.github.hels.tradeplatform.onboarding.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM onboarding.user where is_active is true and (" +
            "document= :document OR email= :email OR phone_number= :phoneNumber )")
    List<User> findDuplicates(
            @Param("document") String document,
            @Param("email") String email,
            @Param("phoneNumber") String phoneNumber);

}
