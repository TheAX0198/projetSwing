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
import pkgComposants.pkgPanelBoutons.LabelDetailPoke;
import pkgComposants.pkgPanelBoutons.LabelInfo;
import pkgComposants.pkgPanelBoutons.PanelControle;
import pkgComposants.pkgPanelGraphique.PanelGraphique;
import pkgComposants.pkgPanelListe.CheckBoxHeaderRenderer;
import pkgComposants.pkgPanelListe.LabelInfoListe;
import pkgComposants.pkgPanelListe.ListeDefaultModel;
import pkgComposants.pkgPanelListe.PanelListe;
import pkgComposants.pkgPanelListe.PokeListe;
import pkgComposants.pkgPanelListe.PokeScrollPane;

public class Vue {

    private MainFrame mainFrame;
    private MainPanel mainPanel;

    private BoutonApparence apparenceLumineux;
    private BoutonApparence apparenceSombre;
    private MenuApparence menuApparence;
    private NavBar navBar;

    private JPanel containerControleGraphique;

    private PanelControle panelControle;
    private JPanel containerBoutonsActions;
    private BoutonAction boutonAjouter;
    private BoutonAction boutonReset;
    private LabelInfo labelInfo;
    private LabelDetailPoke labelDetailPoke;

    private PanelGraphique panelGraphique;

    private PanelListe panelListe;
    private ListeDefaultModel listeDefaultModel;
    private PokeListe liste;
    private PokeScrollPane listeScrollPane;
    private LabelInfoListe labelInfoListe;
    private PokeScrollPane labelScrollPane;

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
        this.labelDetailPoke = new LabelDetailPoke();

        this.panelGraphique = new PanelGraphique();

        this.panelListe = new PanelListe();
        this.listeDefaultModel = new ListeDefaultModel();
        this.liste = new PokeListe(listeDefaultModel);
        this.labelInfoListe = new LabelInfoListe();
        this.labelScrollPane = new PokeScrollPane(labelInfoListe, 260);

        // renderer personnalisé pour le header de la liste
        for (int i = 0; i < liste.getColumnCount(); i++) {
            String titre = liste.getColumnName(i);//Récupération du titre
            liste.getColumnModel().getColumn(i).setHeaderRenderer(new CheckBoxHeaderRenderer(titre));// renderer le header (checkbox + titre)
        }

        //gestion sur le click de la souris sur le header de la liste
        liste.getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
            // Action de la souris sur le header de la liste 
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int col = liste.columnAtPoint(e.getPoint());//trouve la colonne sur laquelle on a cliqué
                liste.sortByColumn(col);//trie la liste selon la colonne cliquée
            }
        });

        this.listeScrollPane = new PokeScrollPane(liste, 200);

        initialiser();
    }

    public void initialiser() {
        // NavBar
        menuApparence.add(apparenceSombre);
        menuApparence.add(apparenceLumineux);
        navBar.add(menuApparence);
        mainFrame.setJMenuBar(navBar);

        // PanelListe
        panelListe.add(listeScrollPane);
        panelListe.add(labelScrollPane);

        // PanelControle
        containerBoutonsActions.add(boutonAjouter);
        containerBoutonsActions.add(boutonReset);
        panelControle.add(containerBoutonsActions);
        panelControle.add(labelInfo);
        panelControle.add(labelDetailPoke);

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
        labelDetailPoke.setDetail(poke);
        labelInfoListe.updateInfos(liste);
    }

    public void resetGraphiqueListe() {
        panelGraphique.resetGraphique();
        listeDefaultModel.setRowCount(0);
        labelDetailPoke.setText(null);
        labelInfoListe.newStats();
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
            labelInfoListe.setSombre();
            listeScrollPane.setSombre();
            boutonAjouter.setSombre();
            boutonReset.setSombre();
            labelInfo.setSombre();
            labelDetailPoke.setSombre();
            labelScrollPane.setSombre();
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
            labelInfoListe.setLumineux();
            listeScrollPane.setLumineux();
            boutonAjouter.setLumineux();
            boutonReset.setLumineux();
            labelInfo.setLumineux();
            labelDetailPoke.setLumineux();
            labelScrollPane.setLumineux();
        }
    }
    // #################################### //

    public void afficherMainFrame() {
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
