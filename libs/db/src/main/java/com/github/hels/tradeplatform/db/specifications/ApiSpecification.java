package com.github.hels.tradeplatform.db.specifications;

import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@RequiredArgsConstructor
public class ApiSpecification<T> implements Specification<T> {
    private Input<T> input;
    private final Set<Predicate> predicates = new HashSet<>();

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        addPredicates(root, builder);
        return builder.and(predicates.toArray(new Predicate[0]));
    }

    public void addPredicates(From<?, ?> from, CriteriaBuilder builder) {
        input.getRootFields().stream()
                .filter(Objects::nonNull)
                .forEach(c -> {
                    Operator operator = Operator.valueOf(c.operator().name());
                    predicates.add(operator.getPredicate(from, builder, c.field(), c.value()));
                });
    }
}
