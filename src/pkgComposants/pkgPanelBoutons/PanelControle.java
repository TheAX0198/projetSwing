package pkgComposants.pkgPanelBoutons;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelControle extends JPanel {

    public PanelControle() {
        this.setBackground(new Color(0, 255, 0)); // Pour tester
        this.setPreferredSize(new Dimension(350, 250));
        this.setBorder(BorderFactory.createTitledBorder("Boutons contrôle"));
    }

}
