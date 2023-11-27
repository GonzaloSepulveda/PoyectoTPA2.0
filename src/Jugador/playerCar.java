package Jugador;
public class playerCar {
    /***
     * @param level
     * @return cochePlayer this is the car the player would use
     */
    public Car playerCarCreation(int level) {
        Car cochePlayer = new Car("Porsche","Rojo",
                130 + (level * 15),4 + (level * 5));
        return cochePlayer;
    }
}