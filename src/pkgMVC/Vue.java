package pkgMVC;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTable;

import pkgComposants.MainFrame;
import pkgComposants.MainPanel;
import pkgComposants.pkgNavBar.BoutonApparence;
import pkgComposants.pkgNavBar.MenuApparence;
import pkgComposants.pkgNavBar.NavBar;
import pkgComposants.pkgPanelBoutons.BoutonAction;
import pkgComposants.pkgPanelBoutons.LabelInfo;
import pkgComposants.pkgPanelBoutons.PanelControle;
import pkgComposants.pkgPanelGraphique.PanelGraphique;
import pkgComposants.pkgPanelListe.PanelListe;

public class Vue {

    MainFrame mainFrame;
    MainPanel mainPanel;

    BoutonApparence apparenceLumineux;
    BoutonApparence apparenceSombre;
    MenuApparence menuApparence;
    NavBar navBar;

    JPanel containerControleGraphique;

    PanelControle panelControle;
    BoutonAction boutonAjouter;
    BoutonAction boutonReset;
    LabelInfo labelInfo;

    PanelGraphique panelGraphique;

    PanelListe panelListe;
    JTable liste;

    public Vue(BoutonApparence aL, BoutonApparence aS, BoutonAction bA, BoutonAction bR) {
        this.apparenceLumineux = aL;
        this.apparenceSombre = aS;

        this.mainFrame = new MainFrame();
        this.mainPanel = new MainPanel();
        this.menuApparence = new MenuApparence("Apparence");
        this.navBar = new NavBar();

        this.containerControleGraphique = new JPanel();

        this.panelControle = new PanelControle();
        this.boutonAjouter = bA;
        this.boutonReset = bR;
        this.labelInfo = new LabelInfo();

        this.panelGraphique = new PanelGraphique();

        this.panelListe = new PanelListe();
        

        initialiser();
    }

    public void initialiser() {
        // NavBar
        menuApparence.add(apparenceSombre);
        menuApparence.add(apparenceLumineux);
        navBar.add(menuApparence);
        mainFrame.setJMenuBar(navBar);

        // PanelListe
        

        // PanelControle
        panelControle.setLayout(new GridLayout(2, 2));
        panelControle.add(boutonAjouter);
        panelControle.add(boutonReset);
        panelControle.add(labelInfo);

        // Container Panel (Controle + Graphique)
        containerControleGraphique.setPreferredSize(new Dimension(350, 500));
        containerControleGraphique.setLayout(new GridLayout(2, 1));
        containerControleGraphique.add(panelControle);
        containerControleGraphique.add(panelGraphique);

        // MainPanel
        mainPanel.add(panelListe, BorderLayout.WEST);
        mainPanel.add(containerControleGraphique, BorderLayout.EAST);
        mainFrame.add(mainPanel);

        afficherMainFrame();

    }

    public void paintPoke(Pokemon poke, int x, int y) {
        panelGraphique.c = new Color(y);
        panelGraphique.coo = new int[]{x, y};
        panelGraphique.updateGraphique(poke);
    }

    public void resetGraphique() {
        panelGraphique.resetGraphique();
    }

    public void changerApparence(int numAppar) {
        if(numAppar == 0) { // Sombre
            mainPanel.setBackground(Color.BLACK);
            navBar.setBackground(Color.DARK_GRAY);
            menuApparence.setSombre();
            apparenceLumineux.setSombre();
            apparenceSombre.setSombre();
        }
        else { // Lumineux
            mainPanel.setBackground(Color.WHITE);
            navBar.setBackground(Color.LIGHT_GRAY);
            menuApparence.setLumineux();
            apparenceLumineux.setLumineux();
            apparenceSombre.setLumineux();
        }
    }

    public void afficherMainFrame() {
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

}
