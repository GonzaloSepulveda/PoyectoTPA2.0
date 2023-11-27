package Jugador;

/**
 * abstract class that serves as a base for all of our car related classes, 3 concrete instances that inherit this class exist
 * {@code car1, car2, car3}
 */
public abstract class upgradeableCar {
    abstract int calculateColour();
    abstract int removeCash();
    abstract int frames();
}

