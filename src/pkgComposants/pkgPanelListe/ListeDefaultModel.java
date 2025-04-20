package pkgComposants.pkgPanelListe;

import javax.swing.table.DefaultTableModel;

public class ListeDefaultModel extends DefaultTableModel {
    
    public ListeDefaultModel() {
        this.addColumn("Nom");
        this.addColumn("Type");
        this.addColumn("Atk");
        this.addColumn("Pv");
    }
}
