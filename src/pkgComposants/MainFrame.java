package pkgComposants;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

    private ImageIcon imgIco;

    public MainFrame() {

        imgIco = new ImageIcon("res/logo/ball_tea.png");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Projet Java Swing");
        this.setSize(800, 600);
        this.setPreferredSize(new Dimension(800, 600));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(imgIco.getImage());

    }

}
