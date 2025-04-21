package pkgComposants.pkgPanelListe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;

public class PokeScrollPane extends JScrollPane {

    public PokeScrollPane(Component comp, int height) {
        this.setViewportView(comp);
        this.setPreferredSize(new Dimension(340, height));

        setLumineux();
    }

    public void setSombre() {
        this.getViewport().setBackground(Color.BLACK);
    }

    public void setLumineux() {
        this.getViewport().setBackground(Color.WHITE);
    }

}
