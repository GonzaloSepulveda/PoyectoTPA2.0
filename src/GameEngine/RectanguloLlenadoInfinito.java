package GameEngine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The {@code RectanguloLlenadoInfinito} class represents a JPanel with a progressive filling rectangle animation
 * and an image displayed in the background. The animation is triggered by pressing the spacebar.
 */

public class RectanguloLlenadoInfinito extends JPanel {
    writeJson guardarDinero = new writeJson();
    private int width = 0;
    private int maxWidth;
    private Timer timer;
    private int acceleration = 0;
    private double acceleracionD;
    int NumAMeter = guardarDinero.checkPaint();
    public BufferedImage[] CarColour;
    private BufferedImage image;

    /**
     * Constructs a new RectanguloLlenadoInfinito panel with a specified maximum width for the filling rectangle.
     *
     * @param maxWidth The maximum width of the filling rectangle.
     */

    public RectanguloLlenadoInfinito(int maxWidth) {
        this.maxWidth = maxWidth;
        setFocusable(true);
        CarColour = new BufferedImage[3];
        //This loads the images of cars, there are 3, 1 for each car colour
        try{
            CarColour[0]=ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/CarRed.png"));
            CarColour[1]=ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/CarGreen.png"));
            CarColour[2]=ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/CarBlue.png"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Error loading image: " + ex.getMessage());
        }
        //Loads the background image
        try {
            image = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Frame 1 Initial Light tamaño.png")); // Reemplaza "ruta_de_tu_imagen.jpg" con la ruta real de tu imagen


        } catch (IOException e) {
            e.printStackTrace();
        }
        //Adds a key listener to spacebar key to start and stop the rectangle animation
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    startAnimation();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    stopAnimation();
                    width = 0;
                    //JOptionPane.showMessageDialog(null, "Su aceleracion es de " + acceleration, "Acceleracion", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * Starts the filling rectangle animation.
     */

    private void startAnimation() {
        if (timer == null || !timer.isRunning()) {
            timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //it will fill a little each time timer triggers
                    if (width < maxWidth) {
                        width += 5;
                        repaint();
                        acceleration = (width * 100) / maxWidth;
                        //if it reaches max width, it will start again
                    } else {
                        width = 0;
                    }
                }
            });
            timer.start();
        }
    }

    /***
     * Stops the filling rectangle animation.
     */
    private void stopAnimation() {
        if (timer != null) {
            timer.stop();
        }
    }

    /**
     * Overrides the paintComponent method to draw the background image, the filled rectangle, and the borders.
     *
     * @param g The <code>Graphics</code> object to protect.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draws the background image
        if (image != null) {
            g.drawImage(image, 0, 0, this);
            BufferedImage carcolor=CarColour[NumAMeter];
            g.drawImage(carcolor, 0, 0, 1100, 700, 0, 0, 1900, 1900, this);

        }
        // Draws the filled rectangle
        g.setColor(Color.BLACK);
        g.fillRect(320, 75, width, 100);
        // Draws the rectangle borders
        g.setColor(Color.RED);
        g.drawRect(320, 75, maxWidth + 1, 100);
        g.drawRect(319, 74, maxWidth + 1, 101);
    }

    /**
     * Gets the current acceleration value.
     *
     * @return The current acceleration value.
     */

    public double getAcceleration() {
        acceleracionD=acceleration;
        return acceleracionD;
    }

    /**
     * Overrides the getPreferredSize method to set the preferred size of the panel.
     *
     * @return A <code>Dimension</code> object representing the preferred size.
     */

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1100, 700);
    }

    /**
     * The main method to demonstrate the usage of the RectanguloLlenadoInfinito panel.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Rectángulo Llenado Progresivo con Imagen");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                RectanguloLlenadoInfinito panel = new RectanguloLlenadoInfinito(500);
                frame.add(panel);
                frame.setLocation(150, 100);
                frame.setSize(1100, 700); // Ajusta el tamaño según tus necesidades
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
    }
}