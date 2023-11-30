import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class starts the application.
 *
 * @author Igor Quadros Silva (201610519@uesb.edu.br)
 * @version 1.0, 06/12/2021
 */
@SuppressWarnings("serial")
public class Principal extends JFrame {
  private static final String TUTORIAL_MESSAGE = "Use the keys <left> and <right> to change the selected car.\n"
    + "Use the keys <up> and <down> to change the speed of the selected car.\n"
    + "Press the key <i> to hide/show the critical sections.\n"
    + "Press the key <r> to randomize all cars speed.";

  private static final String TUTORIAL_TITLE = "Tutorial";

  public Principal() {
    initUI();
  }

  private void initUI() {
    add(new Board(this));

    setResizable(false);
    pack();

    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void showTutorial() {
    JOptionPane.showMessageDialog(this, TUTORIAL_MESSAGE, TUTORIAL_TITLE, JOptionPane.INFORMATION_MESSAGE);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      Principal app = new Principal();
      app.setVisible(true);
      app.showTutorial();
    });
  }
}

