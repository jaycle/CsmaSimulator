import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends JPanel{

    private Color mColor;

    public SimulationPanel() {
        setBorder(BorderFactory.createLineBorder(Color.blue));
        mColor = Color.RED;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 450);
    }

    public void setColor(Color c) {
        mColor = c;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(mColor);
        g2d.fillRect(100, 50, 50, 50);
        g2d.fillRect(100, 120, 50, 50);
        g2d.fillRect(100, 190, 50, 50);
        g2d.fillRect(100, 260, 50, 50);
        g2d.fillRect(100, 340, 50, 50);
    }
}

