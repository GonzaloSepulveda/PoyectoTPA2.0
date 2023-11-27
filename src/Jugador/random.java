package Jugador;

import java.util.Random;
public class random {
    /***
     *This class is used to create the time of the NPC for the user to race against giving a random int to be used in a formula to give the time of set NPC
     * @param level
     * @return
     */
    public double Randomizer(int level) {
        double Empiezo = 0;
        double numeroRanLim = 0;
        double[][] datosRandom = {{0, 6}, {0, 11}, {10, 11}, {20, 11},
                {30, 11}, {40, 11}, {50, 11}, {60, 11}, {70, 11}, {80, 11}, {90, 11}};

        switch (level) {
            case 0:
                Empiezo = datosRandom[0][0];
                numeroRanLim = datosRandom[0][1];
                break;
            case 1:
                Empiezo = datosRandom[1][0];
                numeroRanLim = datosRandom[1][1];
                break;
            case 2:
                Empiezo = datosRandom[2][0];
                numeroRanLim = datosRandom[2][1];
                break;
            case 3:
                Empiezo = datosRandom[3][0];
                numeroRanLim = datosRandom[3][1];
                break;
            case 4:
                Empiezo = datosRandom[4][0];
                numeroRanLim = datosRandom[4][1];
                break;
            case 5:
                Empiezo = datosRandom[5][0];
                numeroRanLim = datosRandom[5][1];
                break;
            case 6:
                Empiezo = datosRandom[6][0];
                numeroRanLim = datosRandom[6][1];
                break;
            case 7:
                Empiezo = datosRandom[7][0];
                numeroRanLim = datosRandom[7][1];
                break;
            case 8:
                Empiezo = datosRandom[8][0];
                numeroRanLim = datosRandom[8][1];
                break;
            case 9:
                Empiezo = datosRandom[9][0];
                numeroRanLim = datosRandom[9][1];
                break;
            case 10:
                Empiezo = datosRandom[10][0];
                numeroRanLim = datosRandom[10][1];
                break;
        }
        Random rand = new Random();
        double rand_dub = rand.nextDouble(numeroRanLim) + Empiezo;
        return rand_dub;
    }

    /***
     *
     * @param args
     */
    public static void main(String[] args) {
        random R1 = new random();
        System.out.println("acceleration " + R1.Randomizer(5));
    }
}