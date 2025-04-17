package pkgComposants.pkgNavBar;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;

public class NavBar extends JMenuBar {

    public NavBar() {
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setBackground(Color.LIGHT_GRAY);
    }

}
