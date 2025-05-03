package objects;

public class Vehicle {
    private final String licensePlate;
    private final int originalValue;

    public Vehicle(String licensePlate, int originalValue){
        if (licensePlate == null)
            throw new IllegalArgumentException("licensePlate must not be null");
        if (licensePlate.length() != 7)
            throw new IllegalArgumentException("licensePlate must have exactly 7 characters");
        if (originalValue <= 0)
            throw new IllegalArgumentException("originalValue must be a positive integer");

        for (char c : licensePlate.toCharArray()) {
            if (!(Character.isUpperCase(c) || Character.isDigit(c))) {
                throw new IllegalArgumentException("licensePlate must contain only uppercase letters A-Z or digits 0-9");
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
