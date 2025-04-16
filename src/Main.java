import javax.swing.SwingUtilities;

import pkgComposants.MainFrame;

public class Main {

    static MainFrame menuPrincipal;

    public static void main(String[] args) throws Exception {

        // Thread pour GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                menuPrincipal = new MainFrame();
                menuPrincipal.afficherMenu();
            }
            
        });

    }
}
