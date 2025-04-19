package pkgMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pkgComposants.pkgNavBar.BoutonApparence;
import pkgComposants.pkgPanelBoutons.BoutonAction;
import pkgComposants.pkgPanelListe.Checkbox;

public class Controleur {

    private Modele modele;
    private Vue vue;

    private BoutonApparence apparenceLumineux;
    private BoutonApparence apparenceSombre;

    private BoutonAction boutonAjouter;
    private BoutonAction boutonReset;
    private Checkbox checkbox;

    public Controleur() {
        apparenceSombre = new BoutonApparence("Sombre", modifApparence(0));
        apparenceLumineux = new BoutonApparence("Lumineux", modifApparence(1));

        boutonAjouter = new BoutonAction("Ajouter", ajouterPoke());
        boutonReset = new BoutonAction("Réinitialiser", resetPoke());

        modele = new Modele();
        vue = new Vue(apparenceLumineux, apparenceSombre, boutonAjouter, boutonReset);
    }

    // Fonctions des "EVENTS LISTENERS"

    // Pour apparenceSombre et apparenceLumineux
    private ActionListener modifApparence(int numAppar) {
        ActionListener aL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vue.changerApparence(numAppar);
            }
        };
        return aL;
    }

    // Pour boutonAjouter
    private ActionListener ajouterPoke() {
        ActionListener aL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = modele.randInt(5, 250);
                int y = modele.randInt(5, 150);
                vue.paintPoke(modele.randomPoke(), x, y);
            }
        };
        return aL;
    }

    // Pour boutonReset
    private ActionListener resetPoke() {
        ActionListener aL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vue.resetGraphique();
                //modele.doSmth()
            }
        };
        return aL;
    }

}
