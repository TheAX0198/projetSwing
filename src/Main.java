import javax.swing.SwingUtilities;

import pkgMVC.Controleur;

public class Main {

    static Controleur controleur;

    public static void main(String[] args) throws Exception {

        // Thread pour GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                controleur = new Controleur();
            }
        });
    }
}
