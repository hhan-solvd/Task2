package vehicles;

import exceptions.EmptyStringException;
import exceptions.NegativeNumberException;

public class GasVehicle extends Vehicle {
    protected double range;

    public GasVehicle(String vehicleModel, String vehicleColor, int vehicleYear,
                      double vehiclePrice, double vehicleRange) throws EmptyStringException {
        super(vehicleModel, vehicleColor, vehicleYear, vehiclePrice);
        if (vehicleRange < 0) {
            throw new NegativeNumberException("Range must be a non-negative number!");
        }

        range = vehicleRange;
    }

    @Override
    public String getOtherInfo() {
        return "GasVehicle{" +
                "range=" + range +
                '}';
    }
}
