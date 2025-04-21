package pkgComposants.pkgPanelListe;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class CheckBoxHeaderRenderer extends JCheckBox implements TableCellRenderer {

    public CheckBoxHeaderRenderer(String _title) {
        setText(_title);// Texte à côté de la checkbox
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    // Déssiner le header de la colonne par défaut avec une case à cocher
    public Component getTableCellRendererComponent(JTable table, Object _titre, boolean isSelected, boolean hasFocus, int row, int column) {
        return this; // Retourne la checkbox elle-même étant composant d'en-tête
    }

}
