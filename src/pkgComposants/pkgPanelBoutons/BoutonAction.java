package pkgComposants.pkgPanelBoutons;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BoutonAction extends JButton {

    public BoutonAction(String texte, ActionListener aL) {
        this.setText(texte);
        this.addActionListener(aL);
        
        setLumineux();
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
