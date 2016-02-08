import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Driver {
    public static void main(String[] s) {

        Channel channel = new Channel(5, 2);
        List<Node> nodeList = channel.getNodeList();   // hold reference for printing state

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("CSMA Simulator");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setLayout(new FlowLayout());

                JTextArea text = new JTextArea(5, 20);
                JButton startButton = new JButton("Start");
                JButton advanceButton = new JButton("Advance Time");
                SimulationPanel panel = new SimulationPanel(5);

                startButton.addActionListener(e -> {
                    frame.add(advanceButton);
                    frame.add(panel);
                    frame.add(text);
                    frame.pack();
                    frame.setVisible(true);
                });

                advanceButton.addActionListener(e -> {
                    int[] tm = channel.advanceTime();

                    for (int i = 0; i < nodeList.size(); i++) {
                        panel.setNodeState(i, nodeList.get(i).getState());
                    }

                    System.out.println(channel.printChannel());
                    text.setText("Time: " + channel.getTime() + "\n");
                    if (tm[5] == Channel.COLLISION) {
                        text.append("Nodes see: Collision!");
                        panel.setColor(Color.RED);
                        panel.resizeNodes(tm);
                        panel.repaint();
                    } else if (tm[5] == Channel.CLEAR_CHANNEL) {
                        text.append("Nodes see: Channel is clear");
                        panel.setColor(Color.blue);
                        panel.resizeNodes(tm);
                        panel.repaint();
                    } else {
                        text.append("Nodes see: Channel seized by " + (tm[5] + 1));
                        panel.setColor(Color.green);
                        panel.resizeNodes(tm);
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
