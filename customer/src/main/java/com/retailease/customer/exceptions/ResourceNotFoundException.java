package com.retailease.customer.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
    private Object resourceName;
    private Object value;
    private Object type;

    public ResourceNotFoundException(Object resourceName, Object type, Object value) {
        super(String.format("%s with %s : %s not found", resourceName, type, value));
        this.resourceName = resourceName;
        this.type = type;
        this.value = value;
    }
}
