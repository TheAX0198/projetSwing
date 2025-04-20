package pkgComposants.pkgPanelListe;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class PokeListe extends JTable {

    private JTableHeader headers;

    public PokeListe(ListeDefaultModel ldm) {
        this.setModel(ldm);
        this.setBackground(Color.WHITE);

        headers = this.getTableHeader();
        headers.setBackground(Color.LIGHT_GRAY);

        setLumineux();
    }

    public void setSombre() {
        this.setForeground(Color.WHITE);
        this.setBackground(Color.BLACK);

        headers.setForeground(Color.WHITE);
        headers.setBackground(Color.BLACK);
    }

    public void setLumineux() {
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);

        headers.setForeground(Color.BLACK);
        headers.setBackground(Color.WHITE);
    }



}
