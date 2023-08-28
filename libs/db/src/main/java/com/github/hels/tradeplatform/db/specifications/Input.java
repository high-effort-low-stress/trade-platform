package com.github.hels.tradeplatform.db.specifications;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Input<T> {
    private final List<Criteria> rootFields = new ArrayList<>();

    public Input<T> addRootField(String field, Operator operator, Object value) {
        rootFields.add(new Criteria(field, operator, value));
        return this;
    }
}
