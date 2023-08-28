package com.github.hels.tradeplatform.db.specifications;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.time.LocalDateTime;

public enum Operator {
    EQUAL {
        public Predicate getPredicate(From<?, ?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.equal(root.get(key), value);
        }
    },
    LIKE {
        public Predicate getPredicate(From<?, ?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.like(root.get(key), "%" + value + "%");
        }
    },
    IN {
        public Predicate getPredicate(From<?, ?> root, CriteriaBuilder builder, String key, Object value) {
            return root.get(key).in(value);
        }
    },
    NUMBER_GE {
        public Predicate getPredicate(From<?, ?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.ge(root.get(key), (Number) value);
        }
    },
    NUMBER_LE {
        public Predicate getPredicate(From<?, ?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.le(root.get(key), (Number) value);
        }
    },
    DATE_TIME_GE {
        public Predicate getPredicate(From<?, ?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.greaterThanOrEqualTo(root.get(key), (LocalDateTime) value);
        }
    },
    DATE_TIME_LE {
        public Predicate getPredicate(From<?, ?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.lessThanOrEqualTo(root.get(key), (LocalDateTime) value);
        }
    },
    DATE_GE {
        public Predicate getPredicate(From<?, ?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.greaterThanOrEqualTo(root.get(key), (LocalDate) value);
        }
    },
    DATE_LE {
        public Predicate getPredicate(From<?, ?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.lessThanOrEqualTo(root.get(key), (LocalDate) value);
        }
    };

    Operator() {
    }

    public abstract Predicate getPredicate(From<?, ?> root, CriteriaBuilder builder, String key, Object value);
}
