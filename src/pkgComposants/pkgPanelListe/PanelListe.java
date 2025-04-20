package pkgComposants.pkgPanelListe;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelListe extends JPanel {

    public PanelListe() {
        this.setBackground(new Color(255, 0, 0)); // Pour tester
        this.setPreferredSize(new Dimension(350, 500));
        this.setBorder(BorderFactory.createTitledBorder("Liste et checkboxes"));

        setLumineux();
    }

    public void setSombre() {
        this.setForeground(Color.WHITE);
        this.setBackground(Color.BLACK);
    }

    public void setLumineux() {
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);
    }

}
