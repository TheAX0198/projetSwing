package pkgComposants.pkgPanelListe;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class PokeListe extends JTable  {

    private JTableHeader headers;

    public PokeListe(ListeDefaultModel ldm) {
        this.setModel(ldm);
        this.setBackground(Color.WHITE);
        this.setEnabled(false);

        headers = this.getTableHeader();
        headers.setEnabled(false);

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

    public void sortByColumn(int columnIndex) {
        //classe JTableRowSorter qui permet de trier les lignes d'un tableau
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(this.getModel());

        // valeur numérique pour les colonnes 2 et 3 (Atk et Pv)
        // méthode Comprator.comparingInt qui permet de comparer les valeurs
        sorter.setComparator(2, Comparator.comparingInt(a -> Integer.parseInt(a.toString()))); 
        sorter.setComparator(3, Comparator.comparingInt(a -> Integer.parseInt(a.toString()))); 
        this.setRowSorter(sorter);

        // classe Swing arrayList pour trier les colonnes dans l'ordre croissant ou décroissant
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(columnIndex, SortOrder.ASCENDING));//trier sur la colonne columnIndex en ordre ASCENDANT
        sorter.setSortKeys(sortKeys);
    }
}
