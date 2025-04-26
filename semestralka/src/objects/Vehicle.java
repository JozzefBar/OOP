package objects;

public class Vehicle {
    private final String licensePlate;
    private final int originalValue;

    public Vehicle(String licensePlate, int originalValue){
        if(licensePlate == null || licensePlate.length() != 7 || originalValue <= 0)
            throw new IllegalArgumentException("Failure to fulfill the condition");

        for (char c : licensePlate.toCharArray()) {
            if (!(Character.isUpperCase(c) || Character.isDigit(c))) {
                throw new IllegalArgumentException("Failure to fulfill the condition");
            }
        }

        this.licensePlate = licensePlate;
        this.originalValue = originalValue;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getOriginalValue() {
        return originalValue;
    }
}
