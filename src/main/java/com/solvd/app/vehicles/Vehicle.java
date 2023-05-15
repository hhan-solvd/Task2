package com.solvd.app.vehicles;

import com.solvd.app.enums.VehicleBodyStyle;
import com.solvd.app.enums.VehicleCategory;
import com.solvd.app.interfaces.ITransportation;
import com.solvd.app.exceptions.EmptyStringException;
import com.solvd.app.exceptions.NegativeNumberException;

import java.util.Objects;

public abstract class Vehicle implements ITransportation {
    protected String model;
    protected String color;
    protected int year;
    protected double price;
    protected VehicleBodyStyle vehicleBodyStyle;
    protected VehicleCategory vehicleCategory;

    public Vehicle(String vehicleModel, String vehicleColor,
                   int vehicleYear, double vehiclePrice) throws EmptyStringException {
        if (vehicleModel.isEmpty()) {
            throw new EmptyStringException("Vehicle's model can not be empty!");
        }

        if (vehicleColor.isEmpty()) {
            throw new EmptyStringException("Vehicle's color can not be empty!");
        }

        if (vehicleYear < 0) {
            throw new NegativeNumberException("Vehicle's year must be a non-negative integer!");
        }

        if (vehiclePrice < 0) {
            throw new NegativeNumberException("Vehicle's price must be a non-negative number!");
        }
        model = vehicleModel;
        color = vehicleColor;
        year = vehicleYear;
        price = vehiclePrice;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    protected abstract String getOtherInfo();

    public VehicleBodyStyle getVehicleBodyStyle() {
        return vehicleBodyStyle;
    }

    public void setVehicleBodyStyle(VehicleBodyStyle type) {
        vehicleBodyStyle = type;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory category) {
        vehicleCategory = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return getYear() == vehicle.getYear() &&
                Double.compare(vehicle.getPrice(), getPrice()) == 0 &&
                Objects.equals(getModel(), vehicle.getModel()) &&
                Objects.equals(getColor(), vehicle.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getColor(), getYear(), getPrice());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", type=" + vehicleBodyStyle +
                ", category=" + vehicleCategory +
                ", " + getOtherInfo() +
                '}';
    }
}
