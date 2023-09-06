package com.retailease.product.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

    private Object resourceName;
    private Object value;

    public ResourceNotFoundException(Object resourceName, Object value) {
        super(String.format("%s with barcode no: %s not found", resourceName, value));
        this.resourceName = resourceName;
        this.value = value;
    }
}
