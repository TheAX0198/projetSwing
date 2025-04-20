package pkgComposants.pkgNavBar;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JMenuBar;

public class NavBar extends JMenuBar {

    public NavBar() {
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setBackground(Color.LIGHT_GRAY);
    }

}
