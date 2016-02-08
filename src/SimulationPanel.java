import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;

public class SimulationPanel extends JPanel{

    private static final int X_ORIG = 100;
    private static final int X_ADVANCED = 125;

    private Color mColor;
    Rectangle node1 = new Rectangle(X_ORIG, 50, 50, 50);
    Rectangle node2 = new Rectangle(X_ORIG, 120, 50, 50);
    Rectangle node3 = new Rectangle(X_ORIG, 190, 50, 50);
    Rectangle node4 = new Rectangle(X_ORIG, 260, 50, 50);
    Rectangle node5 = new Rectangle(X_ORIG, 340, 50, 50);
    Rectangle chan = new Rectangle(350, 190, 50, 50);
    Line2D.Double line1 = new Line2D.Double(0, 0, 0, 0);
    Line2D.Double line2 = new Line2D.Double(0, 0, 0, 0);
    Line2D.Double line3 = new Line2D.Double(0, 0, 0, 0);
    Line2D.Double line4 = new Line2D.Double(0, 0, 0, 0);
    Line2D.Double line5 = new Line2D.Double(0, 0, 0, 0);


    public SimulationPanel() {
        setBorder(BorderFactory.createLineBorder(Color.blue));
        mColor = Color.blue;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 450);
    }

    public void setColor(Color c) {
        mColor = c;
    }

    public void toDefault() {
        node1 = new Rectangle(100, 50, 50, 50);
        node2 = new Rectangle(100, 120, 50, 50);
        node3 = new Rectangle(100, 190, 50, 50);
        node4 = new Rectangle(100, 260, 50, 50);
        node5 = new Rectangle(100, 340, 50, 50);

    }

    public void resizeNodes(int n1, int n2, int n3, int n4, int n5) {
        if (n1 == 1) {
            node1.setLocation(X_ADVANCED, node1.y);
            line1 = new Line2D.Double(150, 75, 375, 215);

        } else {
            node1.setLocation(X_ORIG, node1.y);
            line1 = new Double(0, 0, 0, 0);
        }

        if (n2 == 1) {
            node2.setLocation(X_ADVANCED, node2.y);
            line2 = new Line2D.Double(150, 145, 375, 215);
        } else {
            node2.setLocation(X_ORIG, node2.y);
            line2 = new Double(0, 0, 0, 0);
        }

        if (n3 == 1) {
            node3.setLocation(X_ADVANCED, node3.y);
            line3 = new Line2D.Double(150, 215, 375, 215);
        } else {
            node3.setLocation(X_ORIG, node3.y);
            line3 = new Double(0, 0, 0, 0);
        }

        if (n4 == 1) {
            node4.setLocation(X_ADVANCED, node4.y);
            line4 = new Line2D.Double(150, 285, 375, 215);
        } else{
            node4.setLocation(X_ORIG, node4.y);
            line4 = new Double(0, 0, 0, 0);
        }

        if (n5 == 1) {
            node5.setLocation(X_ADVANCED, node5.y);
            line5 = new Line2D.Double(150, 365, 375, 215);
        } else {
            node5.setLocation(X_ORIG, node5.y);
            line5 = new Double(0, 0, 0, 0);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(mColor);
        g2d.fill(node1);
        g2d.fill(node2);
        g2d.fill(node3);
        g2d.fill(node4);
        g2d.fill(node5);
        g2d.fill(chan);
        g2d.draw(line1);
        g2d.draw(line2);
        g2d.draw(line3);
        g2d.draw(line4);
        g2d.draw(line5);
    }
}

