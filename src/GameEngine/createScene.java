package GameEngine;
import Jugador.car1;
import Jugador.car2;
import Jugador.car3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import static GameEngine.Menu.generarInicio;
import java.util.concurrent.TimeUnit;
/***
 *Create Scene as the name indicates is used to output certain frames during the game loop. First we store all images/Frames in their respective group to be accessed later.We then create a timer for the Frame Timing. Then we use the frames stored beforehand to output to the user First we output a base frame and then we add on top the wheels and clouds to give the effect of the car moving.After the time is up from the formula used we display the Finish line and outputing results.
 */
public class createScene {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                JFrame frame = new JFrame("Image Timer");
                frame.add(new ImagePanel(1100.43,12,12));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }


    public static class ImagePanel extends JPanel {
        writeJson guardarDinero = new writeJson();
        int cash = 50;
        BufferedImage[] images;
        BufferedImage[] startImages;
        BufferedImage[] EndImages;

        BufferedImage[] WheelsSpin;
        BufferedImage[] Sky;
        BufferedImage[] CarColour;
        int frameCounter = 0;
        int NumAMeter = guardarDinero.checkPaint();
        Timer timer;


        String tiempoPLM;
        double tiempoP;

        int frameint;

        double tiempoRival;

        int contaux=1;
        double tiempoPl;

        /***
         *We store all images/Frames in their respective group to be accessed later
         * @param frames
         * @param tiempoNPC
         */
        public ImagePanel(double frames,double tiempoNPC,double tiempoP) {
            car1 cochelvl1 = new car1();
            car2 cochelvl2 = new car2();
            car3 cochelvl3 = new car3();
            tiempoPLM = String.format("%.2f",tiempoP);


            images = new BufferedImage[10];
            frameint = (int) frames;
            tiempoRival = tiempoNPC;
            tiempoPl = tiempoP;
            System.out.println(tiempoPl);
            try {
                images[0] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Fr4ame 1.png"));
                images[1] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Fram 4.png"));
                images[2] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/CAr moving Frame 2.png"));
                images[3] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Frame 3.png"));
                images[4] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Frame 5.png"));
                images[5] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Fr4ame 1.png"));
                images[6] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Fram 4.png"));
                images[7] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/CAr moving Frame 2.png"));
                images[8] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Frame 3.png"));
                images[9] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Car Moving Frame 5.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Error loading image: " + ex.getMessage());
            }

            startImages = new BufferedImage[3];
            try {
                startImages[0] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Frame 1 Initial Light.png"));
                startImages[1] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Frame 2 Second Light.png"));
                startImages[2] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Frame 3 Go Light.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Error loading image: " + ex.getMessage());
            }
            EndImages = new BufferedImage[1];
            try {
                EndImages[0] = ImageIO.read(new File("PNG Car Frames - Copy/Car Frames/Frame Finish With Car.png"));

            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Error loading image: " + ex.getMessage());
            }
            WheelsSpin= new BufferedImage[6];
            try{
                WheelsSpin[0] = ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/pixil-frame-0.png"));
                WheelsSpin[1] = ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/pixil-frame-1 - Copy.png"));
                WheelsSpin[2] = ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/pixil-frame-2 - Copy.png"));
                WheelsSpin[3] = ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/pixil-frame-3- Copy.png"));
                WheelsSpin[4] = ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/pixil-frame-0.png"));
                WheelsSpin[5] = ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/pixil-frame-1 - Copy.png"));
            }
            catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Error loading image: " + ex.getMessage());
            }
            Sky = new BufferedImage[3];
            try{
                Sky[0]=ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/Sky 1.png"));
                Sky[1]=ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/Sky 2.png"));
                Sky[2]=ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/Sky 3.png"));
            }
            catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Error loading image: " + ex.getMessage());
            }
            CarColour = new BufferedImage[3];
            try{
                CarColour[0]=ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/CarRed.png"));
                CarColour[1]=ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/CarGreen.png"));
                CarColour[2]=ImageIO.read(new File("PNG Car Frames - Copy/Empty Frames/CarBlue.png"));
            }
            catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Error loading image: " + ex.getMessage());
            }



            setBackground(Color.BLACK);
/***
 *
 * @param frameint
 */
            timer = new Timer(1200, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                    contaux++;
                    if (contaux == 3) {
                        timer.stop(); // Detener el temporizador actual
                        timer = new Timer(frameint, this); // Crear uno nuevo con una duraciÃ³n diferente (500 ms en este caso)
                        timer.start(); // Iniciar el nuevo temporizador
                    }
                }
            });
            timer.start();
        }
        int WheelsSpinCont = 0 ;

        int Skycont = 0 ;

        public static void wait(int ms)
        {
            try
            {
                Thread.sleep(ms);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        /***
         * We ouptut set Frames to the user
         * @param g the <code>Graphics</code> object to protect
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //These frames are the starting frames which they have to hold always the same order and timing to give the feeling of a stoplight
            if (frameCounter < startImages.length) {
                BufferedImage img = startImages[frameCounter];
                g.drawImage(img, 0, 0, 1100, 700, 0, 0, img.getWidth(), img.getHeight(), this);
                BufferedImage carcolor=CarColour[NumAMeter];
                g.drawImage(carcolor, 0, 0, 1100, 700, 0, 0, img.getWidth(), img.getHeight(), this);
                BufferedImage imgg=WheelsSpin[3];
                g.drawImage(imgg, 0, 0, 1100, 700, 0, 0, img.getWidth(), img.getHeight(), this);
            }

            //Here we output the Frames going through each frame one by one and looping back if we have not reached the timer and are still in the gameloop
            else if (frameCounter < startImages.length + images.length) {
                BufferedImage img = images[frameCounter - startImages.length];
                g.drawImage(img, 0, 0, 1100, 700, 0, 0, img.getWidth(), img.getHeight(), this);
                BufferedImage imgg=WheelsSpin[WheelsSpinCont ];
                g.drawImage(imgg, 0, 0, 1100, 700, 0, 0, img.getWidth(), img.getHeight(), this);
                WheelsSpinCont ++;
                //With these if statements we make sure the WheelSpin and Sky keep looping within their Buffered Images giving the feeling of movement
                if(WheelsSpinCont >5){
                    WheelsSpinCont =0;
                }
                BufferedImage imggg=Sky[Skycont];
                g.drawImage(imggg, 0, 0, 1100, 700, 0, 0, img.getWidth(), img.getHeight(), this);
                Skycont++;
                if(Skycont>2){
                    Skycont=0;
                }
                BufferedImage carcolor=CarColour[NumAMeter];
                g.drawImage(carcolor, 0, 0, 1100, 700, 0, 0, img.getWidth(), img.getHeight(), this);


            }
            //This else makes sure that after the timer is up and all frames have been outputed outputs the end frame also known as the finish line showing the user the race has finished
            else {
                BufferedImage img = EndImages[0];
                g.drawImage(img, 0, 0, 1100, 700, 0, 0, img.getWidth(), img.getHeight(), this);
                BufferedImage carcolor=CarColour[NumAMeter];
                g.drawImage(carcolor, 0, 0, 1100, 700, 0, 0, img.getWidth(), img.getHeight(), this);
                BufferedImage imgg=WheelsSpin[1];
                g.drawImage(imgg, 0, 0, 1100, 700, 0, 0, img.getWidth(), img.getHeight(), this);
                timer.stop();
            }
            // This is used to give the user feedback of the race if he lost won and the time in which he completed it.Changing set results in the jason.
            frameCounter = (frameCounter + 1) % (startImages.length + images.length + EndImages.length);
            if(contaux==14){
                JFrame info = new JFrame("Resultado");
                info.setSize(300,100);
                info.setLocation(650,500);
                info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel panel = new JPanel();
                if(tiempoPl >60){
                    JLabel texto = new JLabel("Has completado la carrera en mas de 1 minuto");
                    panel.add(texto);
                }
                else {
                    JLabel texto = new JLabel("Has completado la carrera en " + tiempoPLM + " segundos");
                    panel.add(texto);
                }
                if(tiempoPl<tiempoRival){
                    JLabel texto2 = new JLabel("Has Ganado! Recibiste 50 monedas");
                    panel.add(texto2);
                    guardarDinero.writeJsonToFileCash(cash);
                }
                else if(tiempoPl>tiempoRival){
                    JLabel texto2 = new JLabel("Has perdido 50 monedas");
                    panel.add(texto2);
                    guardarDinero.writeJsonToFileCash(-cash);
                }
                else{
                    JLabel texto2 = new JLabel("Has quedado empate, recibiste 25 monedas");
                    panel.add(texto2);
                    guardarDinero.writeJsonToFileCash(cash/2);
                }
                info.add(panel);
                info.setVisible(true);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1100, 700);
        }

        /***
         *
         * @param frame
         * @return
         */
        public double calcularTiempo(double frame){
            return ((frame/1000)*10);
        }
    }
}