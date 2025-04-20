package pkgComposants.pkgPanelBoutons;

import java.awt.Color;

import javax.swing.JLabel;

public class LabelInfo extends JLabel {

    public LabelInfo() {
        this.setText(
            "<html>Cliquez sur le bouton ajouter pour<br />faire apparaître un pokemon!</html>"
        );
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
