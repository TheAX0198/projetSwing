package pkgComposants.pkgPanelBoutons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelControle extends JPanel {

    private TitledBorder bordure;

    public PanelControle() {
        this.bordure = new TitledBorder(null, "Contrôles", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(Font.SANS_SERIF, Font.BOLD, 13), Color.BLACK);
        this.setPreferredSize(new Dimension(350, 250));
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
