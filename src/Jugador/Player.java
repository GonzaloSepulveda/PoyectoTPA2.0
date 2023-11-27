package Jugador;

public class Player {
    private String name;
    private Car car;
    public double acceleration;

    /***
     * Setter for PlayerName
     * @param _name
     */
    public void Player(String _name) {
        name = _name;
    }

    /***
     * Setter for player Car
     * @param _car
     */
    public void chooseCar(Car _car) {
        car = _car;
        System.out.println(name + " ha elegido un coche: " + car.getModel());
    }

    /***
     * Setter for car Acceleration
     * @param num
     */
    public void accelerate(double num) {
        acceleration=num;
    }
}