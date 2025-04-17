package pkgComposants.pkgNavBar;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JMenu;

public class MenuApparence extends JMenu {

    public MenuApparence(String texte) {
        this.setText(texte);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(new Color(128, 0, 0), 2));
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
