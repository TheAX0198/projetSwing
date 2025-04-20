package pkgComposants.pkgPanelListe;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PokeScrollPane extends JScrollPane {

    public PokeScrollPane(JTable liste) {
        this.setViewportView(liste);
        this.setPreferredSize(new Dimension(340, 200));
        
        setLumineux();
    }

    public void setSombre() {
        this.getViewport().setBackground(Color.BLACK);
    }

    public void setLumineux() {
        this.getViewport().setBackground(Color.WHITE);
    }

}
