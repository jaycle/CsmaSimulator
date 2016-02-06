import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver {
    public static void main(String[] s) {
        Channel channel = new Channel(5, 5);
        for (int i = 0; i < 100; i++) {
            channel.advanceTime();
            System.out.print(channel.printChannel());
            System.out.println(i);
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("CSMA Simulator");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setLayout(new FlowLayout());

                JTextArea text = new JTextArea(4, 10);
                JButton startButton = new JButton("Start");
                JButton stopButton = new JButton("Stop");
                SimulationPanel panel = new SimulationPanel();

                startButton.addActionListener(e ->  {
                    text.setText("We've Started");
                    panel.setColor(Color.RED);
                    panel.repaint();
                });

                stopButton.addActionListener(e -> {
                    text.setText("We've Stopped");
                    panel.setColor(Color.blue);
                    panel.repaint();

                });

                frame.add(startButton);
                frame.add(text);
                frame.add(stopButton);
                frame.add(panel);

                frame.pack();
                frame.setVisible(true);
            }
        });

    }
}
