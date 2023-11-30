import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is responsible for draw all objects on the Board.
 *
 * @author Igor Quadros Silva (201610519@uesb.edu.br)
 * @version 1.0, 06/12/2021
 */
@SuppressWarnings("serial")
public class Board extends JPanel implements Runnable {
  public static final int CELL_SIZE = 40;

  private static final int BOARD_WIDTH = CELL_SIZE * 19;

  private static final int BOARD_HEIGHT = CELL_SIZE * 10;

  private static final int DELAY = 15;

  private static final int SELECTED_CAR_THICKNESS = 6;

  private static final String SPEED_UNIT_MEASURE = "mph";

  public static final String APP_TITLE = "Use the arrow keys to control the cars";

  private Thread thread;

  private List<Car> cars;

  private List<CriticalSection> criticalSections;

  private int selected;

  private JFrame frame;

  private boolean showCriticalSections;

  public Board(JFrame frame) {
    this.frame = frame;
    initBoard();
  }

  private void refreshFrameTitle() {
    Car car = cars.get(selected);
    frame.setTitle(APP_TITLE + " - " + car.getName() + " (" + car.getSpeed() + " " + SPEED_UNIT_MEASURE + ")");
  }

  private void increaseSpeed() {
    Car car = cars.get(selected);
    car.increaseSpeed();
  }

  private void decreaseSpeed() {
    Car car = cars.get(selected);
    car.decreaseSpeed();
  }

  private void randomizeSpeed() {
    for (Car car : cars) {
      car.randomizeSpeed();
    }
  }

  private void initBoard() {
    addKeyListener(new InputHandler());
    setBackground(Color.DARK_GRAY);
    setFocusable(true);
    setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

    initCars();
    initCriticalSections();
    refreshFrameTitle();

    if (thread == null) {
      thread = new Thread(new Timer(this, DELAY));
      thread.start();
    }
  }

  private void initCars() {
    cars = new ArrayList<>();

    cars.add(Car.GRAY);
    cars.add(Car.BROWN);
    cars.add(Car.PINK);
    cars.add(Car.BLUE);
    cars.add(Car.BLACK);
    cars.add(Car.RED);
    cars.add(Car.YELLOW);
    cars.add(Car.GREEN);
  }

  private void initCriticalSections() {
    criticalSections = new ArrayList<>();

    for (Car car : cars) {
      for (CriticalSection criticalSection : car.getCriticalSections()) {
        if (!criticalSections.contains(criticalSection)) {
          criticalSections.add(criticalSection);
        }
      }
    }
  }

  @Override
  public void run() {
    repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    drawRoads(g);
    drawGarages(g);
    drawCriticalSections(g);
    drawCars(g);

    Toolkit.getDefaultToolkit().sync();
  }

  private void drawRoads(Graphics g) {
    g.setColor(Color.WHITE);
    for (Car car : cars) {
      drawRect(g, car.getPath(), CELL_SIZE);
    }
  }

  private void drawRect(Graphics g, Rectangle rect, int thickness) {
    g.fillRect((int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), thickness);
    g.fillRect((int)rect.getX(), (int)(rect.getY() + rect.getHeight() - thickness), (int)rect.getWidth(), thickness);
    g.fillRect((int)rect.getX(), (int)rect.getY(), thickness, (int)rect.getHeight());
    g.fillRect((int)(rect.getX() + rect.getWidth() - thickness), (int)rect.getY(), thickness, (int)rect.getHeight());
  }

  private void drawGarages(Graphics g) {
    g.setColor(Color.LIGHT_GRAY);
    for (Car car : cars) {
      g.fillRect((int)car.getStart().getX(), (int)car.getStart().getY(), CELL_SIZE, CELL_SIZE);
    }
  }

  private void drawCriticalSections(Graphics g) {
    if (!showCriticalSections) {
      return;
    }

    for (CriticalSection criticalSection : criticalSections) {
      g.setColor(criticalSection.getColor());

      Rectangle bounds = criticalSection.getBounds();
      bounds.grow(-1 * criticalSection.getBorder(), -1 * criticalSection.getBorder());

      drawRect(g, bounds, CriticalSection.THICKNESS);
    }
  }

  private void drawCars(Graphics g) {
    for (int i = 0; i < cars.size(); i++) {
      Car car = cars.get(i);
      g.setColor(car.getColor());
      g.fillRect((int)car.getX(), (int)car.getY(), Car.CAR_SIZE, Car.CAR_SIZE);

      if (i == selected) {
        g.setColor(Color.CYAN);
        drawRect(g, new Rectangle((int)car.getX(), (int)car.getY(), Car.CAR_SIZE, Car.CAR_SIZE), SELECTED_CAR_THICKNESS);
      }
    }
  }

  private class InputHandler extends KeyAdapter {
    @Override
    public void keyReleased(KeyEvent e) {
      int key = e.getKeyCode();

      if (key == KeyEvent.VK_LEFT) {
        if(--selected < 0) {
          selected = cars.size() - 1;
        }
      }

      if (key == KeyEvent.VK_RIGHT) {
        if (++selected >= cars.size()) {
          selected = 0;
        }
      }

      if (key == KeyEvent.VK_UP) {
        increaseSpeed();
      }

      if (key == KeyEvent.VK_DOWN) {
        decreaseSpeed();
      }

      if (key == KeyEvent.VK_I) {
        showCriticalSections = !showCriticalSections;
      }

      if (key == KeyEvent.VK_R) {
        randomizeSpeed();
      }

      refreshFrameTitle();
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
  }
}
