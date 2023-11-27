package GameEngine;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The {@code Menu} class represents the main menu of the game, providing options for gameplay,
 * accessing the workshop, and quitting the game.
 */

public class Menu {
    /**
     * The main method to start the application and display the main menu.
     *
     * @param args Command line arguments (not used).
     */

    public static void main(String[] args) {
        // Create the main menu JFrame
        JFrame pantalla = new JFrame("Menu");
        // Generate and display the menu
        generarInicio(pantalla);
    }
    /**
     * Generates and displays the initial menu screen with buttons for playing, accessing the workshop,
     * and quitting the game.
     *
     * @param screen The JFrame to display the menu on.
     */
    public static void generarInicio(JFrame screen) {
        // Create an instance of writeJson to money level data
        writeJson guardarDinero = new writeJson();
        // Retrieve the current car level from saved data
        int level = guardarDinero.checkLevel();
        // Create buttons for play, workshop and quit functions
        JButton b1 = new JButton("Play");
        JButton b2 = new JButton("Workshop");
        JButton b3 = new JButton("Quit");
        // set of bounds for buttons
        b1.setBounds(150, 100, 100, 40);
        b2.setBounds(150, 200, 100, 40);
        b3.setBounds(150, 300, 100, 40);
        // b1 button action listener
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //hide screen
                screen.setVisible(false);
                //create a Jframe for level selector
                JFrame nivel = new JFrame();
                nivel.setSize(400, 400); // TamaÃ±o del JFrame principal (puedes ajustarlo)
                nivel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                SwingUtilities.invokeLater(() -> {
                    // Save level for its use in game_p funtion
                    LevelSelect levelSelector = new LevelSelect(nivel);
                    int selectedLevel = levelSelector.getSelectedLevel();
                    System.out.println("Nivel seleccionado: " + selectedLevel);
                    Game_P game = new Game_P();
                    game.Game_P(selectedLevel,level);
                });
            }
        });
        // b2 button action listener
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open workshop, (Class name is SettinsPage)
                new SettingsPage();
            }
        });
        // b3 button action listener
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //exits program
                System.exit(0);
            }

        });
        //Adding buttons to JFrame screen
        screen.add(b1);
        screen.add(b2);
        screen.add(b3);
        //Setting screen details
        screen.setSize(400, 500);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}