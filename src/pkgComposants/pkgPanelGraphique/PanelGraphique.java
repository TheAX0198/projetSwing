package pkgComposants.pkgPanelGraphique;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pkgMVC.Pokemon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class PanelGraphique extends JPanel {

    public BufferedImage canvasPoke; // Sauvegarde l'image du g2d au "repaint()"
    public BufferedImage canvasBg;
    public Color c;
    public int[] coo;

    private String nomBackground;

    public PanelGraphique() {
        this.setPreferredSize(new Dimension(350, 250));
        
        setLumineux();

        this.canvasPoke = new BufferedImage(350, 250, BufferedImage.TYPE_INT_ARGB);
        this.c = new Color(0);
        this.coo = new int[]{350, 250};
        initialiserGraphique();
    }

    // Coordonnées max du graphique : (x = 350, y = 250)
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvasBg, 0, 0, null); // Charge "background"
        g.drawImage(canvasPoke, 0, 0, null); // Charge pokémon 
    }

    // Background
    public void initialiserGraphique() {
        this.canvasBg = new BufferedImage(350, 250, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) canvasBg.getGraphics();

        Image bg = new ImageIcon("res/background/" + nomBackground + ".png").getImage();
        g2d.drawImage(bg, 0, 0, null);

        g2d.dispose();
    }

    // Nouveau pokemon
    public void updateGraphique(Pokemon poke) {
        Graphics2D g2d = (Graphics2D) canvasPoke.getGraphics(); 

        Image pokeImg = new ImageIcon("res/pokeSprite/" + poke.getNom() + ".png").getImage();
        g2d.drawImage(pokeImg, coo[0], coo[1], null);
        g2d.dispose();

        repaint();
    }

    // Détruire graphique et initialiser nouveau
    public void resetGraphique() {
        this.canvasPoke = new BufferedImage(350, 250, BufferedImage.TYPE_INT_ARGB);
        initialiserGraphique();
        repaint();
    }

    public void setSombre() {
        this.setBackground(Color.BLACK);
        this.nomBackground = "dark_field";
        initialiserGraphique();
        repaint();
    }

    public void setLumineux() {
        this.setBackground(Color.WHITE);
        this.nomBackground = "bright_field";
        initialiserGraphique();
        repaint();
    }

}
