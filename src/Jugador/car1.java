package Jugador;

/***
 * a concrete instance of the abstract class upgradeableCar
 * it is the first car the player receives
 */

public class car1 extends upgradeableCar {
    int moneyReq = 200;

    @Override
        //red
    /***
     * 0 is the value associated with red in our code
     * @return 0
     */
    public int calculateColour() {
        return 0;
    }

    /***
     * this function is not used at the moment
     * @return moneyReq
     */
    @Override
    public int removeCash() {
        return moneyReq;
    }

    @Override
    /***
     * The higher the frame counter the slower the car
     * @return 500
     */
    public int frames() {
        return 500;
    }

}
