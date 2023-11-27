package Jugador;

/***
 * a concrete instance of the abstract class upgradeableCar
 * it is the second car the player receives
 */
public class car2 extends upgradeableCar{
    int moneyReq = 400;
    @Override
    //green
    /***
     * 0 is the value associated with green in our code
     * @return 1
     */
    public int calculateColour() {
        return 1;
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
     * @return 475
     */
    public int frames() {return 475;}
}
