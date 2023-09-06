package com.retailease.product.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidQuantityException extends RuntimeException {

    private final Object id;
    private final Object barcodeNo;
    private final Object actualQuantity;
    private final Object expectedQuantity;


    public InvalidQuantityException(Object id, Object barcodeNo, Object actualQuantity, Object expectedQuantity) {
        super(String.format("product with id: %s and %s is having: %s quantity but requested: %s", id, barcodeNo, expectedQuantity, actualQuantity));
        this.barcodeNo = barcodeNo;
        this.id = id;
        this.actualQuantity = actualQuantity;
        this.expectedQuantity = expectedQuantity;
    }
}
