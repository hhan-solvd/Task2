package com.solvd.app.enums;

public enum VehicleCategory {
    ELECTRIC("Electric Vehicle"),
    HYBRID("Hybrid Vehicle"),
    GASOLINE("Gasoline Vehicle");
    private final String category;

    VehicleCategory(String vehicleCategory) {
        category = vehicleCategory;
    }

    public String getCategory() {
        return category;
    }
}
