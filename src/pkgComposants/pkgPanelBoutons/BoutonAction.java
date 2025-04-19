package pkgComposants.pkgPanelBoutons;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BoutonAction extends JButton {

    public BoutonAction(String texte, ActionListener aL) {
        this.setText(texte);
        this.addActionListener(aL);
    }

}
