import java.awt.Color;
import java.awt.Rectangle;
import java.util.concurrent.Semaphore;

/**
 * Each CriticalSection object models a critical section on the Board.
 *
 * @author Igor Quadros Silva (201610519@uesb.edu.br)
 * @version 1.0, 06/12/2021
 */
public class CriticalSection {
  public static final int THICKNESS = 2;

  public static final CriticalSection CS1 = new CriticalSection(createRectangle(3, 0, 1, 1), THICKNESS); 

  public static final CriticalSection CS2 = new CriticalSection(createRectangle(4, 0, 1, 1), THICKNESS); 

  public static final CriticalSection CS3 = new CriticalSection(createRectangle(5, 0, 1, 1), THICKNESS); 

  public static final CriticalSection CS4 = new CriticalSection(createRectangle(6, 0, 1, 1), THICKNESS); 

  public static final CriticalSection CS5 = new CriticalSection(createRectangle(7, 0, 1, 1), THICKNESS); 

  public static final CriticalSection CS6 = new CriticalSection(createRectangle(8, 0, 1, 1), THICKNESS); 

  public static final CriticalSection CS7 = new CriticalSection(createRectangle(9, 0, 1, 1), THICKNESS); 

  public static final CriticalSection CS8 = new CriticalSection(createRectangle(9, 1, 1, 1), THICKNESS); 

  public static final CriticalSection CS9 = new CriticalSection(createRectangle(9, 2, 1, 1), THICKNESS); 

  public static final CriticalSection CS10 = new CriticalSection(createRectangle(9, 3, 1, 1), THICKNESS); 

  public static final CriticalSection CS11 = new CriticalSection(createRectangle(9, 0, 7, 1), 3 * THICKNESS); 

  public static final CriticalSection CS12 = new CriticalSection(createRectangle(15, 9, 1, 1), THICKNESS); 

  public static final CriticalSection CS13 = new CriticalSection(createRectangle(14, 9, 1, 1), THICKNESS); 

  public static final CriticalSection CS14 = new CriticalSection(createRectangle(13, 9, 1, 1), THICKNESS); 

  public static final CriticalSection CS15 = new CriticalSection(createRectangle(12, 9, 1, 1), THICKNESS); 

  public static final CriticalSection CS16 = new CriticalSection(createRectangle(11, 9, 1, 1), THICKNESS); 

  public static final CriticalSection CS17 = new CriticalSection(createRectangle(10, 9, 1, 1), THICKNESS); 

  public static final CriticalSection CS18 = new CriticalSection(createRectangle(9, 9, 1, 1), THICKNESS); 

  public static final CriticalSection CS19 = new CriticalSection(createRectangle(9, 8, 1, 1), THICKNESS); 

  public static final CriticalSection CS20 = new CriticalSection(createRectangle(9, 7, 1, 1), THICKNESS); 

  public static final CriticalSection CS21 = new CriticalSection(createRectangle(9, 6, 1, 1), THICKNESS); 

  public static final CriticalSection CS22 = new CriticalSection(createRectangle(3, 9, 7, 1), 3 * THICKNESS); 

  public static final CriticalSection CS23 = new CriticalSection(createRectangle(0, 3, 1, 1), THICKNESS); 

  public static final CriticalSection CS24 = new CriticalSection(createRectangle(0, 4, 1, 1), THICKNESS); 

  public static final CriticalSection CS25 = new CriticalSection(createRectangle(0, 5, 1, 1), THICKNESS); 

  public static final CriticalSection CS26 = new CriticalSection(createRectangle(0, 6, 1, 1), THICKNESS); 

  public static final CriticalSection CS27 = new CriticalSection(createRectangle(3, 3, 4, 1), 3 * THICKNESS); 

  public static final CriticalSection CS28 = new CriticalSection(createRectangle(3, 6, 1, 1), THICKNESS); 

  public static final CriticalSection CS29 = new CriticalSection(createRectangle(4, 6, 1, 1), THICKNESS); 

  public static final CriticalSection CS30 = new CriticalSection(createRectangle(5, 6, 1, 1), THICKNESS); 

  public static final CriticalSection CS31 = new CriticalSection(createRectangle(6, 6, 1, 1), THICKNESS); 

  public static final CriticalSection CS32 = new CriticalSection(createRectangle(18, 3, 1, 1), THICKNESS); 

  public static final CriticalSection CS33 = new CriticalSection(createRectangle(18, 4, 1, 1), THICKNESS); 

  public static final CriticalSection CS34 = new CriticalSection(createRectangle(18, 5, 1, 1), THICKNESS); 

  public static final CriticalSection CS35 = new CriticalSection(createRectangle(18, 6, 1, 1), THICKNESS); 

  public static final CriticalSection CS36 = new CriticalSection(createRectangle(12, 3, 1, 1), THICKNESS); 

  public static final CriticalSection CS37 = new CriticalSection(createRectangle(13, 3, 1, 1), THICKNESS); 

  public static final CriticalSection CS38 = new CriticalSection(createRectangle(14, 3, 1, 1), THICKNESS); 

  public static final CriticalSection CS39 = new CriticalSection(createRectangle(15, 3, 1, 1), THICKNESS); 

  public static final CriticalSection CS40 = new CriticalSection(createRectangle(12, 6, 4, 1), 3 * THICKNESS); 

  public static final CriticalSection CS41 = new CriticalSection(createRectangle(6, 3, 1, 1), THICKNESS); 

  public static final CriticalSection CS42 = new CriticalSection(createRectangle(7, 3, 1, 1), THICKNESS); 

  public static final CriticalSection CS43 = new CriticalSection(createRectangle(8, 3, 1, 1), THICKNESS); 

  public static final CriticalSection CS44 = new CriticalSection(createRectangle(9, 3, 4, 1), 3 * THICKNESS); 

  public static final CriticalSection CS45 = new CriticalSection(createRectangle(12, 4, 1, 1), THICKNESS); 

  public static final CriticalSection CS46 = new CriticalSection(createRectangle(12, 5, 1, 1), THICKNESS); 

  public static final CriticalSection CS47 = new CriticalSection(createRectangle(12, 6, 1, 1), THICKNESS); 

  public static final CriticalSection CS48 = new CriticalSection(createRectangle(10, 6, 1, 1), THICKNESS); 

  public static final CriticalSection CS49 = new CriticalSection(createRectangle(11, 6, 1, 1), THICKNESS); 

  public static final CriticalSection CS50 = new CriticalSection(createRectangle(6, 6, 4, 1), 3 * THICKNESS); 

  public static final CriticalSection CS51 = new CriticalSection(createRectangle(6, 4, 1, 1), THICKNESS); 

  public static final CriticalSection CS52 = new CriticalSection(createRectangle(6, 5, 1, 1), THICKNESS); 

  private static final int PERMITS = 1;

  private Rectangle bounds;

  private int border;

  private Semaphore semaphore;

  public CriticalSection(Rectangle bounds, int border) {
    this.bounds = bounds;
    this.border = border;
    this.semaphore = new Semaphore(PERMITS);
  }

  public void acquire() {
    try {
      semaphore.acquire();
    } catch (InterruptedException e) {
        String message = String.format("Thread interrupted: %s", e.getMessage());

        System.err.println(message);
    }
  }

  public void release() {
    semaphore.release();
  }

  public Rectangle getBounds() {
    return new Rectangle(bounds);
  }

  public int getBorder() {
    return this.border;
  }

  public Color getColor() {
    if (semaphore.availablePermits() > 0) {
      return Color.GREEN;
    }
    return Color.RED;
  }

  private static Rectangle createRectangle(int x, int y, int width, int height) {
    return new Rectangle(x * Board.CELL_SIZE, y * Board.CELL_SIZE, width * Board.CELL_SIZE, height * Board.CELL_SIZE);
  }
}
