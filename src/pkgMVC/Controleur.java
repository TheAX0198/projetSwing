package pkgMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pkgComposants.pkgNavBar.ApparenceLumineux;
import pkgComposants.pkgNavBar.ApparenceSombre;
import pkgComposants.pkgPanelBoutons.BoutonAjouter;
import pkgComposants.pkgPanelBoutons.BoutonReset;
import pkgComposants.pkgPanelListe.Checkbox;

public class Controleur {

    private Modele modele;
    private Vue vue;

    private ApparenceLumineux apparenceLumineux;
    private ApparenceSombre apparenceSombre;

    private BoutonAjouter boutonAjouter;
    private BoutonReset boutonReset;
    private Checkbox checkbox;

    public Controleur() {
        apparenceSombre = new ApparenceSombre("Sombre", modifApparence(0));
        apparenceLumineux = new ApparenceLumineux("Lumineux", modifApparence(1));

        modele = new Modele();
        vue = new Vue(apparenceLumineux, apparenceSombre);
    }

    private ActionListener modifApparence(int numAppar) {
        ActionListener aL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vue.changerApparence(numAppar);
            }
        };
        return aL;
    }

}
