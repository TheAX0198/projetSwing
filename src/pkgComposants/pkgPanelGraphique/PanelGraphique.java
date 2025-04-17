package pkgComposants.pkgPanelGraphique;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PanelGraphique extends JPanel {

    public PanelGraphique() {
        this.setBackground(new Color(0, 0, 255)); // Pour tester
        this.setPreferredSize(new Dimension(350, 250));
        this.setBorder(BorderFactory.createTitledBorder("Graphique 2D"));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
    }

}
