import javax.swing.*;
import java.awt.*;

public class Driver {
    public static void main(String[] s) {

        Channel channel = new Channel(5, 2);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("CSMA Simulator");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setLayout(new FlowLayout());

                JTextArea text = new JTextArea(5, 20);
                JButton startButton = new JButton("Start");
                JButton advanceButton = new JButton("Advance Time");
                SimulationPanel panel = new SimulationPanel();

                startButton.addActionListener(e ->  {
                    frame.add(advanceButton);
                    frame.add(panel);
                    frame.add(text);
                    frame.pack();
                    frame.setVisible(true);
                });

                advanceButton.addActionListener(e -> {
                    int[] tm = channel.advanceTime();
                    System.out.println(channel.printChannel());
                    if (tm[5] == -2) {
                        text.setText("Time: " + channel.getTime() + "\n" +
                                "Collision!");
                        panel.setColor(Color.RED);
                        panel.resizeNodes(tm[0], tm[1], tm[2], tm[3], tm[4]);
                        panel.repaint();
                    } else if (tm[5] >= 0) {
                        text.setText("Time: " + channel.getTime() + "\n" +
                                "Node " + (tm[5] + 1) + " has the channel");
                        panel.setColor(Color.green);
                        panel.resizeNodes(tm[0], tm[1], tm[2], tm[3], tm[4]);
                        panel.repaint();
                    } else if (tm[5] == -1) {
                        text.setText("Time: " + channel.getTime() + "\n" +
                                "Channel is clear");
                        panel.setColor(Color.blue);
                        panel.resizeNodes(tm[1], tm[2], tm[3], tm[4], tm[5]);
                        panel.toDefault();
                        panel.repaint();
                    }
                });

                frame.add(startButton);
                frame.pack();
                frame.setVisible(true);
            }
        });

    }
}
