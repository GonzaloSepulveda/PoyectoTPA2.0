package GameEngine;
import Jugador.car1;
import Jugador.car2;
import Jugador.car3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * This class defines all the functions related with car personalization, may it be upgrades or paint chages.
 */
public class SettingsPage extends JFrame {
    private JCheckBox checkBoxOption;
    private JTextField textFieldOption;
    private JButton saveButton;
    JPanel panel = new JPanel();

    /***
     * Here we declare the menu as a whole and the buttons it is composed by
     */

    public SettingsPage() {
        super("Workshop");
        int cash = 200;
        JFrame info = new JFrame("Resultado");
        info.setSize(300,100);
        info.setLocation(650,400);
        writeJson guardarDinero = new writeJson();
        setLayout(new GridLayout(0, 1));
        checkBoxOption = new JCheckBox("Enable Option");
        textFieldOption = new JTextField(20);
        saveButton = new JButton("Exit");
        JButton b1=new JButton("Upgrade car");
        JButton b2=new JButton("Change Paint");
        b1.setBounds(250,600,95,30);
        b2.setBounds(250,400,95,30);
        add(b1);
        add(b2);
        info.add(panel);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(guardarDinero.checkCash());
                if(guardarDinero.checkCash()>=200) {
                    guardarDinero.writeJsonToFileCash(-cash);
                    JLabel texto1 = new JLabel("Has mejorado tu coche 1 nivel");
                    JLabel texto2 = new JLabel("Te quedan " + guardarDinero.checkCash()+" monedas");
                    guardarDinero.writeJsonToFilelvl(1);
                    panel.add(texto1);
                    panel.add(texto2);
                    info.setVisible(true);
                }
                else{
                    JLabel texto1 = new JLabel("No tienes suficiente dinero");
                    int cashNeeded = cash - guardarDinero.checkCash();
                    JLabel texto2 = new JLabel("Necesitas "+ cashNeeded +" monedas más" );
                    JLabel texto3 = new JLabel( guardarDinero.checkCash()+" son las monedas que tienes");
                    panel.add(texto1);
                    panel.add(texto2);
                    panel.add(texto3);
                    info.setVisible(true);
                }

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame pantalla = new JFrame("Menu");
                pantalla.setBounds(300,800,200,200);
                JPanel panalBotones = new JPanel();
                panalBotones.setBounds(300,800,200,200);
                JButton b1=new JButton("Red");
                JButton b2=new JButton("Green");
                JButton b3=new JButton("Blue");
                JButton b4=new JButton("Quit");
                b1.setBounds(250,600,95,30);
                b2.setBounds(250,400,95,30);
                b3.setBounds(250,200,95,30);
                //b4.setBounds(250,0,95,30);
                panalBotones.add(b1);
                panalBotones.add(b2);
                panalBotones.add(b3);
                //panalBotones.add(b4);
                pantalla.add(panalBotones);
                pantalla.setVisible(true);
                pantalla.setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                car1 cochelvl1 = new car1();
                car2 cochelvl2 = new car2();
                car3 cochelvl3 = new car3();
                b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int paint = 1;
                        writeJson guardarDinero = new writeJson();
                        paint = cochelvl1.calculateColour();
                        guardarDinero.writeJsonToFileColour(paint);
                    }
                });
                b2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int paint = 1;
                        writeJson guardarDinero = new writeJson();
                        paint = cochelvl2.calculateColour();
                        guardarDinero.writeJsonToFileColour(paint);
                    }
                });
                b3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int paint = 1;
                        writeJson guardarDinero = new writeJson();
                        paint = cochelvl3.calculateColour();
                        guardarDinero.writeJsonToFileColour(paint);
                    }
                });


            }
        });


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu();
            }
        });

        add(saveButton);

        // Set the JFrame properties

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
        info.add(panel);

    }

    /***
     * main function of the program that calls the menu above
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SettingsPage();
            new Menu();
        });
    }
}
