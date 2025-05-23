package pkgComposants.pkgNavBar;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class BoutonApparence extends JMenuItem {

    public BoutonApparence(String texte, ActionListener aL) {
        this.setText(texte);
        this.addActionListener(aL);
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
