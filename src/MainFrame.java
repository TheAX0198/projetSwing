
import java.awt.Dimension;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

    //ImageIcon imgIco;

    MainFrame() {

        //imgIco = new ImageIcon();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Projet Java Swing");
        this.setSize(800, 600);
        this.setPreferredSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        //this.getContentPane().setBackground(Color.BLACK);
        //this.setIconImage(imgIco.getImage());

        // Ajout des composants //

    }

    public void afficherMenu() {
        this.setVisible(true);
    }

}
