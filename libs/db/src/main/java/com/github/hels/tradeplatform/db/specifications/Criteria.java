package com.github.hels.tradeplatform.db.specifications;

public record Criteria(String field, Operator operator, Object value) {}
