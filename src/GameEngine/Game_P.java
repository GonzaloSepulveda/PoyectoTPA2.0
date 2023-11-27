package GameEngine;

import Jugador.random;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Jugador.car1;
import Jugador.car2;
import Jugador.car3;


import static GameEngine.Menu.generarInicio;

/**
 * The {@code Game_P} class represents the main game interface where the player interacts with the game environment.
 */

public class Game_P {
    /**
     * Initializes and starts the game with the specified level and current level configuration.
     *
     * @param level The level of the game.
     * @param levelC The current car level .
     */
    public void Game_P(int level,int levelC) {
        double aceleracionNPC;
        double tiempoNPC;
        //Calculate the NPC stats for the race depending on the game level
        random R1 = new random();
        aceleracionNPC = R1.Randomizer(level);
        tiempoNPC = CalculoSeg(CalculoFrame(aceleracionNPC));
        //The string shows the NPC time with only 2 decimal
        String tiempoNPCP = String.format("%.2f", tiempoNPC);
        System.out.println("TiempoNPC: " + tiempoNPC);
        //Create the main game window
        JFrame ventana = new JFrame("Game");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Create an instance of RectanguloLlenadoInfinito
        RectanguloLlenadoInfinito rect1 = new RectanguloLlenadoInfinito(500);
        //Create diferent capes for inserting diferentes panels
        JLayeredPane layeredPane = new JLayeredPane();
        //Create 2 panels, one for game image and the other one for information panel
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        Color defaultBackgroundColor = UIManager.getColor("Panel.background");
        //Create the text for the panel2
        JLabel etiqueta = new JLabel("TiempoNPC: " + tiempoNPCP);
        etiqueta.setForeground(Color.BLACK); //Color de las letras
        Font font = new Font("Arial", Font.PLAIN, 20);
        etiqueta.setFont(font);
        //Adding RectanguloLlenadoInfinito(rect1) to panel and setting panel bounds
        panel.add(rect1);
        panel.setBounds(0, 0, 1100, 700);
        //Adding Info text(etiqueta) to panel2 and setting bounds and colours
        panel2.add(etiqueta);
        panel2.setBackground(Color.WHITE); //color del fondo
        panel2.setBorder(new LineBorder(Color.BLACK, 3));
        panel2.setLocation(850, 180);
        panel2.setSize(200, 60);
        //Add the panels to diferent layers
        layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER); //distinstas capas
        layeredPane.add(panel2, JLayeredPane.PALETTE_LAYER); //capa superior
        //Add the layers to the JFrame(ventana) and setting "ventana" details
        ventana.add(layeredPane);
        ventana.setLocation(150, 100);
        ventana.setSize(1100, 700);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        //Add a key listener to "rect1" to detect when Spacebar is released
        rect1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {}
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    double frame;
                    double aceleracionPlayer;
                    double TiempoP;
                    //get players acceleration from rect1
                    aceleracionPlayer = rect1.getAcceleration();
                    System.out.println("Acel jug: " + aceleracionPlayer);
                    car1 cochelvl1 = new car1();
                    car2 cochelvl2 = new car2();
                    car3 cochelvl3 = new car3();
                    //Depending on car level, the max frames for the game will be changed
                    if(levelC ==3){
                        frame = CalculoFramePL(aceleracionPlayer,cochelvl3.frames());


                    }
                    if(levelC==2){
                        frame = CalculoFramePL(aceleracionPlayer,cochelvl2.frames());

                    }
                    else{
                        frame = CalculoFramePL(aceleracionPlayer,cochelvl1.frames());
                    }
                    //Calculate the players time
                    TiempoP = CalculoSeg(frame);
                    System.out.println("tiempo p: "+TiempoP);
                    //if acceleration is too low, the frames follow a fixed value
                    if(aceleracionPlayer<=45){
                        frame = 1100;
                    }
                    System.out.println("Frames" + frame);
                    //Erase panel and panel2 content and from the main JFrame(ventana) and get them ready to draw again
                    panel.removeAll();
                    panel.revalidate();
                    panel.repaint();
                    ventana.remove(panel);
                    panel2.setBackground(defaultBackgroundColor); //set panel colour to the panel defautlt colour
                    panel2.setBorder(new LineBorder(defaultBackgroundColor, 3));
                    panel2.removeAll();
                    panel2.revalidate();
                    panel2.repaint();
                    ventana.remove(panel2);
                    //"panel" is filled again with the animation in createScene
                    panel.add(new createScene.ImagePanel(frame, tiempoNPC,TiempoP));
                    //"panel2 is resized and repainted with new colours and information to display
                    panel2.setLocation(850, 180);
                    panel2.setBackground(Color.WHITE); //color del fondo
                    panel2.setBorder(new LineBorder(Color.BLACK, 3));
                    //Now it will show player acceleration
                    JLabel etiqueta2 = new JLabel("Acel: " + aceleracionPlayer);
                    etiqueta2.setFont(font);
                    //Add new text to "panel2"
                    panel2.add(etiqueta2);
                    //When the game window closes, it will generate a new menu window
                    ventana.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            JFrame pantalla = new JFrame("Menu");
                            generarInicio(pantalla);
                        }
                    });

                }
            }

        });
        rect1.requestFocus();
    }

    /**
     * Calculates the number of frames required based on the given acceleration(Used for NPC acceleration).
     *
     * @param acceleration The acceleration value.
     * @return The calculated number of frames.
     */

    public double CalculoFrame(double acceleration) {
        return ((100 * 500) / acceleration);
    }

    /**
     * Calculates the number of frames required based on the given acceleration and player's level configuration.
     *
     * @param acceleration The player acceleration value.
     * @param frame The frame configuration for the player's level(given by the car level).
     * @return The calculated number of frames.
     */

    public double CalculoFramePL(double acceleration,int frame) {
        return ((100 * frame) / acceleration);
    }

    /**
     * Calculates the time in seconds based on the given frame count.
     *
     * @param Frame The frame count.
     * @return The calculated time in seconds.
     */

    public double CalculoSeg(double Frame) {
        return ((Frame / 1000) * 10);
    }

    /**
     * The main method to demonstrate the usage of the Game_P class.
     *
     * @param args Command line arguments (not used).
     */

    public static void main(String[] args) {
        writeJson guardarDinero = new writeJson();
        int level = guardarDinero.checkLevel();
        // Crear una instancia de Game_P y pasar un nivel (por ejemplo, nivel 5)
        Game_P game = new Game_P();
        game.Game_P(5,level);
    }
}