package com.solvd.app.enums;

public enum CustomerType {

    REGULAR("Regular Customers"),
    VIP("VIP Customers");

    private final String type;

    private CustomerType(String customerType) {
        type = customerType;
    }

    public String getType() {
        return type;
    }
}
