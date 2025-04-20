package pkgMVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

import pkgComposants.MainFrame;
import pkgComposants.MainPanel;
import pkgComposants.pkgNavBar.BoutonApparence;
import pkgComposants.pkgNavBar.MenuApparence;
import pkgComposants.pkgNavBar.NavBar;
import pkgComposants.pkgPanelBoutons.BoutonAction;
import pkgComposants.pkgPanelBoutons.LabelInfo;
import pkgComposants.pkgPanelBoutons.PanelControle;
import pkgComposants.pkgPanelGraphique.PanelGraphique;
import pkgComposants.pkgPanelListe.CheckBoxHeaderRenderer;
import pkgComposants.pkgPanelListe.ListeDefaultModel;
import pkgComposants.pkgPanelListe.PanelListe;
import pkgComposants.pkgPanelListe.PokeListe;
import pkgComposants.pkgPanelListe.PokeScrollPane;

public class Vue {

    MainFrame mainFrame;
    MainPanel mainPanel;

    BoutonApparence apparenceLumineux;
    BoutonApparence apparenceSombre;
    MenuApparence menuApparence;
    NavBar navBar;

    JPanel containerControleGraphique;

    PanelControle panelControle;
    JPanel containerBoutonsActions;
    BoutonAction boutonAjouter;
    BoutonAction boutonReset;
    LabelInfo labelInfo;

    PanelGraphique panelGraphique;

    PanelListe panelListe;
    ListeDefaultModel listeDefaultModel;
    PokeListe liste;
    PokeScrollPane scrollPane;

    public Vue(BoutonApparence aL, BoutonApparence aS, BoutonAction bA, BoutonAction bR) {
        this.apparenceLumineux = aL;
        this.apparenceSombre = aS;

        this.mainFrame = new MainFrame();
        this.mainPanel = new MainPanel();
        this.menuApparence = new MenuApparence("Apparence");
        this.navBar = new NavBar();

        this.containerControleGraphique = new JPanel();

        this.panelControle = new PanelControle();
        this.containerBoutonsActions = new JPanel(new GridLayout(1, 2));
        this.boutonAjouter = bA;
        this.boutonReset = bR;
        this.labelInfo = new LabelInfo();

        this.panelGraphique = new PanelGraphique();

        this.panelListe = new PanelListe();
        this.listeDefaultModel = new ListeDefaultModel();
        this.liste = new PokeListe(listeDefaultModel);

        // renderer personnalisé pour le header de la liste
        for (int i = 0; i < liste.getColumnCount(); i++) {
            String titre = liste.getColumnName(i);//Récupération du titre
            liste.getColumnModel().getColumn(i).setHeaderRenderer(new CheckBoxHeaderRenderer(titre));// rendrerer le header (checkbox + titre)
        }

        //gestion sur le click de la souris sur le header de la liste
        liste.getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
            // Action de la souris sur le header de la liste 
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int col = liste.columnAtPoint(e.getPoint());//trouve la colonne sur laquelle on a cliqué
                liste.sortByColumn(col);//trie la liste selon la colonne cliquée
            }
        });

        this.scrollPane = new PokeScrollPane(liste);

        initialiser();
    }

    public void initialiser() {
        // NavBar
        menuApparence.add(apparenceSombre);
        menuApparence.add(apparenceLumineux);
        navBar.add(menuApparence);
        mainFrame.setJMenuBar(navBar);

        // PanelListe
        panelListe.add(scrollPane);

        // PanelControle
        containerBoutonsActions.add(boutonAjouter);
        containerBoutonsActions.add(boutonReset);
        panelControle.add(containerBoutonsActions);
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

    // Action Vue des boutons Ajouter et Reset //
    public void paintPoke(Pokemon poke, int x, int y) {
        panelGraphique.c = new Color(y);
        panelGraphique.coo = new int[]{x, y};
        panelGraphique.updateGraphique(poke);
    }

    public void ajoutPoke(Pokemon poke) {
        Object[] pokeData = new Object[]{poke.getNom(), poke.getType(), poke.getAtk(), poke.getPv()};
        listeDefaultModel.addRow(pokeData);
    }

    public void resetGraphiqueListe() {
        panelGraphique.resetGraphique();
        listeDefaultModel.setRowCount(0);
    }

    // ####################################### //

    // Action Apparence Sombre et Lumineux //
    public void changerApparence(int numAppar) {
        if(numAppar == 0) { // Sombre
            mainPanel.setBackground(Color.BLACK);
            navBar.setBackground(Color.DARK_GRAY);
            menuApparence.setSombre();
            apparenceLumineux.setSombre();
            apparenceSombre.setSombre();
            panelControle.setSombre();
            panelGraphique.setSombre();
            panelListe.setSombre();
            liste.setSombre();
            scrollPane.setSombre();
            boutonAjouter.setSombre();
            boutonReset.setSombre();
            labelInfo.setSombre();
        }
        else { // Lumineux
            mainPanel.setBackground(Color.WHITE);
            navBar.setBackground(Color.LIGHT_GRAY);
            menuApparence.setLumineux();
            apparenceLumineux.setLumineux();
            apparenceSombre.setLumineux();
            panelControle.setLumineux();
            panelControle.setLumineux();
            panelGraphique.setLumineux();
            panelListe.setLumineux();
            liste.setLumineux();
            scrollPane.setLumineux();
            boutonAjouter.setLumineux();
            boutonReset.setLumineux();
            labelInfo.setLumineux();
        }
    }
    // #################################### //

    public void afficherMainFrame() {
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
