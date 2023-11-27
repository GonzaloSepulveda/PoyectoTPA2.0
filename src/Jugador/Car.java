package Jugador;

public class Car {
    private String model;
    private String color;
    private int topSpeed;
    private double acceleration;
    private double gripPercent;

    /***
     * The constructor for the class Car
     * @param model
     * @param color
     * @param topSpeed
     * @param gripPercent
     */
    public Car(String model, String color, int topSpeed, double gripPercent) {
        this.model = model;
        this.color = color;
        this.topSpeed = topSpeed;
        this.gripPercent = gripPercent;
    }

    /***
     * sets acceleration value
     * @param _acceleration
     */
    public void setAcceleration(double _acceleration) {
        acceleration=_acceleration;
    }

    /**
     * gets the car's model
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * gets the car's colour
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * gets TopSpeed ( not used )
     * @return topSpeed
     */
    public int getTopSpeed() {
        return topSpeed;
    }

    /**
     * gets Grip Percent ( not used )
     * @return GripPercent
     */
    public double getGripPercent() {
        return gripPercent;
    }
}