package com.solvd.app.enums;

public enum VehicleBodyStyle {
    COUPE("Coupe", 2),
    SEDAN("Sedan", 4),
    SUV("SUV", 5);

    private final String style;
    private final int seats;

    VehicleBodyStyle(String vehicleName, int numberOfSeats) {
        style = vehicleName;
        seats = numberOfSeats;
    }

    public String getStyle() {
        return style;
    }

    public int getSeats() {
        return seats;
    }
}
