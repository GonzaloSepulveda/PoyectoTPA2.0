package Jugador;
/***
 * a concrete instance of the abstract class upgradeableCar
 * it is the third car the player receives
 */
public class car3 extends upgradeableCar {
    int moneyReq = 800;

    @Override
        //blue
    /***
     * 0 is the value associated with blue in our code
     * @return 2
     */
    public int calculateColour() {
        return 2;
    }

    @Override
    /***
     * this function is not used at the moment
     * @return moneyReq
     */
    public int removeCash() {
        return moneyReq;
    }

    @Override
    /***
     * The higher the frame counter the slower the car
     * @return 450
     */
    public int frames() {
        return 450;
    }
}
