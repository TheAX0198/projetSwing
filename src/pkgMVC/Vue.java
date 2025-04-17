package pkgMVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;

import pkgComposants.MainFrame;
import pkgComposants.MainPanel;
import pkgComposants.pkgNavBar.ApparenceLumineux;
import pkgComposants.pkgNavBar.ApparenceSombre;
import pkgComposants.pkgNavBar.MenuApparence;
import pkgComposants.pkgNavBar.NavBar;
import pkgComposants.pkgPanelBoutons.PanelControle;
import pkgComposants.pkgPanelGraphique.PanelGraphique;
import pkgComposants.pkgPanelListe.PanelListe;

public class Vue {

    MainFrame mainFrame;
    MainPanel mainPanel;

    ApparenceLumineux apparenceLumineux;
    ApparenceSombre apparenceSombre;
    MenuApparence menuApparence;
    NavBar navBar;

    JPanel containerControleGraphique;

    PanelControle panelControle;

    PanelGraphique panelGraphique;

    PanelListe panelListe;

    public Vue(ApparenceLumineux aL, ApparenceSombre aS) {
        this.apparenceLumineux = aL;
        this.apparenceSombre = aS;

        this.mainFrame = new MainFrame();
        this.mainPanel = new MainPanel();
        this.menuApparence = new MenuApparence("Apparence");
        this.navBar = new NavBar();

        this.containerControleGraphique = new JPanel();

        this.panelControle = new PanelControle();

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

        // Container Panel
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

    public void afficherMainFrame() {
        mainFrame.pack();
        mainFrame.setVisible(true);
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


}
