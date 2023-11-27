package GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * @deprecated Used in past versions of the game, its use is no longer recommended
 */
    public class NPCMessage {
        private JFrame frame;
        private JTextArea chatArea;
        private NPCRacer[] racers;
        private int currentRacerIndex;

    /***
     * class that used to write NPC messages on the console/interface
     */
    public NPCMessage () {
            frame = new JFrame("Different NPC Racers Conversation");
            chatArea = new JTextArea(10, 30);
            chatArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(chatArea);

            racers = new NPCRacer[]{
                    new NPCRacer("Pablo"),
                    new NPCRacer("Victor"),
                    new NPCRacer("Gonzalo")
            };

            currentRacerIndex = 0;

            Timer timer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String npcMessage = racers[currentRacerIndex].generateNPCMessage();
                    chatArea.append(racers[currentRacerIndex].getName() + ": " + npcMessage + "\n");
                    currentRacerIndex = (currentRacerIndex + 1) % racers.length;
                }
            });
            timer.start();

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(200,300);
            frame.pack();
            frame.setVisible(true);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new NPCMessage ();
                }
            });
        }
    }

