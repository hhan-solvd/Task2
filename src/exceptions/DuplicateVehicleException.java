package exceptions;

public class DuplicateVehicleException extends RuntimeException {
    public DuplicateVehicleException(String message) {
        super(message);
    }
}
