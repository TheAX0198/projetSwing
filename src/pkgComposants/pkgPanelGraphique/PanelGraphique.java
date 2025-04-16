package pkgComposants.pkgPanelGraphique;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PanelGraphique extends JPanel {

    public PanelGraphique() {}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(0, 0, 50, 50);
    }

}
