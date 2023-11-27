package GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The {@code LevelSelect} class represents a dialog for selecting a game level.
 * It extends {@link JDialog} and provides a modal interface with a dropdown menu
 * to choose from available game levels.
 */

public class LevelSelect extends JDialog {

    private Integer selectedLevel;
    private int level;

    /**
     * Constructs a new LevelSelect dialog.
     *
     * @param parent The parent JFrame to which this dialog is attached.
     */
    public LevelSelect(JFrame parent) {
        super(parent, "Seleccionar Nivel", true); // Hacer que el JDialog sea modal

        setSize(300, 200);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //Create a dropdown menu with numbers from 1 to 10
        JPanel panel = new JPanel();
        // "Aceptar" button for confirm the selected level, and then, closing the window
        JButton btnAceptar = new JButton("Aceptar");
        //inicially, "aceptar" button is disabled
        btnAceptar.setEnabled(false);
        Integer[] niveles = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        JComboBox<Integer> opciones = new JComboBox<>(niveles);
        opciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedLevel = (Integer) opciones.getSelectedItem();
                //Button "aceptar" is enabled when an int value of the dropdown menu is selected
                btnAceptar.setEnabled(true);
            }
        });
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level = selectedLevel;
                dispose();
            }
        });
        //add button and dropdown menu to a JPanel
        panel.add(opciones);
        panel.add(btnAceptar);
        //adding panel to JFrame and setting details
        setLayout(new FlowLayout());
        add(panel);

        setLocationRelativeTo(parent);
        setVisible(true);
    }
    /**
     * Gets the selected game level.
     *
     * @return The selected game level.
     */
    public int getSelectedLevel() {
        return level;
    }

    /**
     * The main method to demonstrate the usage of the LevelSelect dialog.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        JFrame parentFrame = new JFrame();
        parentFrame.setSize(400, 300); // TamaÃ±o del JFrame principal (puedes ajustarlo)
        parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingUtilities.invokeLater(() -> {
            LevelSelect levelSelector = new LevelSelect(parentFrame);
            int selectedLevel = levelSelector.getSelectedLevel();
            System.out.println("Nivel seleccionado: " + selectedLevel);
        });
    }
}