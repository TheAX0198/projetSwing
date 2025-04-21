package pkgComposants.pkgPanelListe;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.table.TableModel;

public class LabelInfoListe extends JLabel {

    public LabelInfoListe() {
        setLumineux();
        newStats();
    }

    public void updateInfos(PokeListe pL) {
        int nbrTotalPoke = pL.getRowCount();
        String pokeCommun = getMostPoke(pL);
        String typeCommun = getMostType(pL);
        int maxAtk = getMaxAtk(pL);
        int maxPv = getMaxPv(pL);
        int totalAtk = getTotalAtk(pL);
        int totalPv = getTotalPv(pL);

        this.setText("<html><h1>Statistiques du tableau</h1>" +
                        "<p>Nombre total de pokemon : " + nbrTotalPoke + "</p>" +
                        "<p>Pokemon le plus commun : " + pokeCommun + "</p>" +
                        "<p>Type le plus commun : " + typeCommun + "</p>" +
                        "<p>Attaque maximum : " + maxAtk + "</p>" +
                        "<p>Pv maximum : " + maxPv + "</p>" +
                        "<p>Total puissance d'attaque : " + totalAtk + "</p>" +
                        "<p>Total Pv : " + totalPv + "</p>" +
                    "</html>");
    }

    private String getMostPoke(PokeListe pL) {
        TableModel tm = pL.getModel();
        ArrayList<String> poke = new ArrayList<>();

        String currentPoke = "";
        int nbrCurrentPoke = 0;
        String lastHighPoke = "";
        int nbrLastHighPoke = 0;

        // Création du tableau "sorter" pour manipulation
        for (int i = 0; i < pL.getRowCount(); i++) { poke.add((String) tm.getValueAt(i, 0)); }
        Collections.sort(poke);

        // Trouver le poke le plus commun
        for (int i = 0; i < poke.size(); i++) {

            // Si passe à autre poke
            if (!(poke.get(i).equals(currentPoke))) {

                // Si poke précédant plus commun
                if (nbrCurrentPoke > nbrLastHighPoke) {
                    lastHighPoke = currentPoke;
                    nbrLastHighPoke = nbrCurrentPoke;
                }

                // Si poke précédant même rareté
                else if (nbrCurrentPoke == nbrLastHighPoke && i != 0)
                    lastHighPoke += "<br />╚═" + currentPoke;

                // Reset pour poke suivant
                currentPoke = poke.get(i);
                nbrCurrentPoke = 0;
            }

            nbrCurrentPoke++;
        }

        // Vérif avec dernier poke
        if (nbrCurrentPoke < nbrLastHighPoke)
            currentPoke = lastHighPoke;
        else if (nbrCurrentPoke == nbrLastHighPoke)
            currentPoke += "<br />╚═" + lastHighPoke;

        return currentPoke;
    }

    private String getMostType(PokeListe pL) {
        TableModel tm = pL.getModel();
        ArrayList<String> types = new ArrayList<>();

        String currentType = "";
        int nbrCurrentType = 0;
        String lastHighType = "";
        int nbrLastHighType = 0;

        // Création du tableau "sorter" pour manipulation
        for (int i = 0; i < pL.getRowCount(); i++) { types.add((String) tm.getValueAt(i, 1)); }
        Collections.sort(types);

        // Trouver le type le plus commun
        for (int i = 0; i < types.size(); i++) {

            // Si passe à autre type
            if (!(types.get(i).equals(currentType))) {

                // Si type précédant plus commun
                if (nbrCurrentType > nbrLastHighType) {
                    lastHighType = currentType;
                    nbrLastHighType = nbrCurrentType;
                }

                // Si type précédant même rareté
                else if (nbrCurrentType == nbrLastHighType)
                    lastHighType += "<br />╚═" + currentType;

                // Reset pour type suivant
                currentType = types.get(i);
                nbrCurrentType = 0;
            }

            nbrCurrentType++;
        }

        // Vérif avec dernier type
        if (nbrCurrentType < nbrLastHighType)
            currentType = lastHighType;
        else if (nbrCurrentType == nbrLastHighType)
            currentType += "<br />╚═" + lastHighType;

        return currentType;
    }

    private int getMaxAtk(PokeListe pL) {
        TableModel tm = pL.getModel();
        int maxAtk = 0;

        for (int i = 0; i < pL.getRowCount(); i++) {
            if ((int) tm.getValueAt(i, 2) > maxAtk)
                maxAtk = (int) tm.getValueAt(i, 3);
        }

        return maxAtk;
    }

    private int getMaxPv(PokeListe pL) {
        TableModel tm = pL.getModel();
        int maxPv = 0;

        for (int i = 0; i < pL.getRowCount(); i++) {
            if ((int) tm.getValueAt(i, 3) > maxPv)
                maxPv = (int) tm.getValueAt(i, 3);
        }

        return maxPv;
    }

    private int getTotalAtk(PokeListe pL) {
        TableModel tm = pL.getModel();
        int totalAtk = 0;

        for (int i = 0; i < pL.getRowCount(); i++) { totalAtk += (int) tm.getValueAt(i, 2); }

        return totalAtk;
    }

    private int getTotalPv(PokeListe pL) {
        TableModel tm = pL.getModel();
        int totalPv = 0;

        for (int i = 0; i < pL.getRowCount(); i++) { totalPv += (int) tm.getValueAt(i, 3); }

        return totalPv;
    }

    public void newStats() {
        this.setText("<html><h1>Statistiques du tableau</h1><p>Faite apparaître un pokemon pour actualiser la liste!</p></html>");
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
