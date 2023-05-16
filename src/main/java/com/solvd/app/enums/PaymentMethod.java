package com.solvd.app.enums;

public enum PaymentMethod {

    FINANCE("Finance"),
    PAY_IN_FULL("Pay in Full");

    private final String paymentMethod;

    private PaymentMethod(String method) {
        paymentMethod = method;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
