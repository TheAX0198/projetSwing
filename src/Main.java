import javax.swing.SwingUtilities;

public class Main {

    static MainFrame menuPrincipal;

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                menuPrincipal = new MainFrame();
                menuPrincipal.afficherMenu();
            }
            
        });

    }
}
