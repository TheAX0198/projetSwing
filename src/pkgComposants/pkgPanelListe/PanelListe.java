package pkgComposants.pkgPanelListe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelListe extends JPanel {

    private TitledBorder bordure;
    private String bgImg;

    public PanelListe() {
        this.bordure = new TitledBorder(null, "Liste et checkboxes", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(Font.SANS_SERIF, Font.BOLD, 13), Color.BLACK);
        this.setPreferredSize(new Dimension(350, 500));
        this.setBorder(bordure);

        setLumineux();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Dessiner l'arrière-plan
        Image bg = new ImageIcon("res/background/" + bgImg + ".png").getImage();
        g2d.drawImage(bg, 0, 0, null);

    }

    public void setSombre() {
        this.setBackground(Color.BLACK);
        bgImg = "bg_dark_liste";
        bordure.setTitleColor(Color.WHITE);
    }

    public void setLumineux() {
        this.setBackground(Color.WHITE);
        bgImg = "bg_bright_liste";
        bordure.setTitleColor(Color.BLACK);
    }

}
