package pkgComposants.pkgPanelListe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelListe extends JPanel {

    private TitledBorder bordure;

    public PanelListe() {
        this.bordure = new TitledBorder(null, "Liste et checkboxes", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(Font.SANS_SERIF, Font.BOLD, 13), Color.BLACK);
        this.setPreferredSize(new Dimension(350, 500));
        this.setBorder(bordure);

        setLumineux();
    }

    public void setSombre() {
        this.setBackground(Color.BLACK);
        bordure.setTitleColor(Color.WHITE);
    }

    public void setLumineux() {
        this.setBackground(Color.WHITE);
        bordure.setTitleColor(Color.BLACK);
    }

}
