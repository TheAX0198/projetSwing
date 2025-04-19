package pkgComposants.pkgPanelGraphique;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pkgMVC.Pokemon;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class PanelGraphique extends JPanel {

    public BufferedImage canvas; // Sauvegarde l'image du g2d au "repaint()"
    public Color c;
    public int[] coo;

    public PanelGraphique() {
        this.setBackground(new Color(0, 0, 255)); // Pour tester
        this.setPreferredSize(new Dimension(350, 250));
        this.setBorder(BorderFactory.createTitledBorder("Graphique 2D"));

        this.canvas = new BufferedImage(350, 250, BufferedImage.TYPE_INT_ARGB);
        this.c = new Color(0);
        this.coo = new int[]{350, 250};
        initialiserGraphique();
    }

    // Coordonnées max du graphique : (x = 350, y = 250)
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvas, 0, 0, null); // Charge "canvas" 
    }

    // Background
    public void initialiserGraphique() {
        Graphics2D g2d = (Graphics2D) canvas.getGraphics();

        g2d.setColor(new Color(0, 255, 255));
        g2d.setStroke(new BasicStroke(5));
        g2d.drawRect(0, 0, 350, 250);

        g2d.dispose();
    }

    // Nouveau pokemon
    public void updateGraphique(Pokemon poke) {
        Graphics2D g2d = (Graphics2D) canvas.getGraphics(); 

        Image pokeImg = new ImageIcon("res/pokeSprite/" + poke.getNom() + ".png").getImage();
        g2d.drawImage(pokeImg, coo[0], coo[1], null);
        g2d.dispose();

        repaint();
    }

    // Détruire graphique et initialiser nouveau
    public void resetGraphique() {
        this.canvas = new BufferedImage(350, 250, BufferedImage.TYPE_INT_ARGB);
        initialiserGraphique();
        repaint();
    }

}
