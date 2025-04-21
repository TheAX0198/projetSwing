package pkgComposants.pkgPanelBoutons;

import java.awt.Color;

import javax.swing.JLabel;

import pkgMVC.Pokemon;

public class LabelDetailPoke extends JLabel {

    public LabelDetailPoke() {
        setLumineux();
    }

    public void setDetail(Pokemon poke) {
        this.setText("<html><br /><p>Un " + poke.getNom() + " sauvage est apparu!</p><br /><p>" + poke.getDesc().replaceAll("\n", "<br />") + "</p></html>");
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
