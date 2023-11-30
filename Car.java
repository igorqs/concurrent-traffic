import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Each Car object models a car on the Board.
 *
 * @author Igor Quadros Silva (201610519@uesb.edu.br)
 * @version 1.0, 06/12/2021
 */
public class Car implements Runnable {
  public static final Car BLACK = new CarBuilder()
    .setColor(Color.BLACK)
    .setStart(createPoint(7, 4))
    .setPath(createRectangle(6, 3, 7, 4))
    .setClockwise(false)
    .setName("Black")
    .setCriticalSections(Arrays.asList(
          CriticalSection.CS50,
          CriticalSection.CS44,
          CriticalSection.CS10,
          CriticalSection.CS41,
          CriticalSection.CS42,
          CriticalSection.CS43,
          CriticalSection.CS36,
          CriticalSection.CS45,
          CriticalSection.CS46,
          CriticalSection.CS47,
          CriticalSection.CS48,
          CriticalSection.CS49,
          CriticalSection.CS21,
          CriticalSection.CS51,
          CriticalSection.CS52,
          CriticalSection.CS31))
    .build();

  public static final Car BLUE = new CarBuilder()
    .setColor(Color.BLUE)
    .setStart(createPoint(1, 4))
    .setPath(createRectangle(0, 3, 7, 4))
    .setClockwise(true)
    .setName("Blue")
    .setCriticalSections(Arrays.asList(
          CriticalSection.CS27,
          CriticalSection.CS23,
          CriticalSection.CS24,
          CriticalSection.CS25,
          CriticalSection.CS26,
          CriticalSection.CS28,
          CriticalSection.CS29,
          CriticalSection.CS30,
          CriticalSection.CS31,
          CriticalSection.CS51,
          CriticalSection.CS52,
          CriticalSection.CS41))
    .build();

  public static final Car BROWN = new CarBuilder()
    .setColor(new Color(0xab7942))
    .setStart(createPoint(4, 1))
    .setPath(createRectangle(3, 0, 7, 4))
    .setClockwise(true)
    .setName("Brown")
    .setCriticalSections(Arrays.asList(
          CriticalSection.CS27,
          CriticalSection.CS1,
          CriticalSection.CS2,
          CriticalSection.CS3,
          CriticalSection.CS4,
          CriticalSection.CS5,
          CriticalSection.CS6,
          CriticalSection.CS7,
          CriticalSection.CS8,
          CriticalSection.CS9,
          CriticalSection.CS10,
          CriticalSection.CS41,
          CriticalSection.CS42,
          CriticalSection.CS43))
    .build();

  public static final Car GRAY = new CarBuilder()
    .setColor(Color.GRAY)
    .setStart(createPoint(1, 1))
    .setPath(createRectangle(0, 0, 19, 10))
    .setClockwise(true)
    .setName("Gray")
    .setCriticalSections(Arrays.asList(
          CriticalSection.CS22,
          CriticalSection.CS11,
          CriticalSection.CS1,
          CriticalSection.CS2,
          CriticalSection.CS3,
          CriticalSection.CS4,
          CriticalSection.CS5,
          CriticalSection.CS6,
          CriticalSection.CS7,
          CriticalSection.CS12,
          CriticalSection.CS13,
          CriticalSection.CS14,
          CriticalSection.CS15,
          CriticalSection.CS16,
          CriticalSection.CS17,
          CriticalSection.CS18,
          CriticalSection.CS23,
          CriticalSection.CS24,
          CriticalSection.CS25,
          CriticalSection.CS26,
          CriticalSection.CS32,
          CriticalSection.CS33,
          CriticalSection.CS34,
          CriticalSection.CS35))
    .build();

  public static final Car GREEN = new CarBuilder()
    .setColor(new Color(0x006400))
    .setStart(createPoint(10, 7))
    .setPath(createRectangle(9, 6, 7, 4))
    .setClockwise(true)
    .setName("Green")
    .setCriticalSections(Arrays.asList(
          CriticalSection.CS40,
          CriticalSection.CS12,
          CriticalSection.CS13,
          CriticalSection.CS14,
          CriticalSection.CS15,
          CriticalSection.CS16,
          CriticalSection.CS17,
          CriticalSection.CS18,
          CriticalSection.CS19,
          CriticalSection.CS20,
          CriticalSection.CS21,
          CriticalSection.CS47,
          CriticalSection.CS48,
          CriticalSection.CS49))
    .build();

  public static final Car PINK = new CarBuilder()
    .setColor(new Color(0xfc70df))
    .setStart(createPoint(10, 1))
    .setPath(createRectangle(9, 0, 7, 4))
    .setClockwise(false)
    .setName("Pink")
    .setCriticalSections(Arrays.asList(
          CriticalSection.CS11,
          CriticalSection.CS44,
          CriticalSection.CS7,
          CriticalSection.CS8,
          CriticalSection.CS9,
          CriticalSection.CS10,
          CriticalSection.CS36,
          CriticalSection.CS37,
          CriticalSection.CS38,
          CriticalSection.CS39))
    .build();

  public static final Car RED = new CarBuilder()
    .setColor(new Color(0x8b0000))
    .setStart(createPoint(13, 4))
    .setPath(createRectangle(12, 3, 7, 4))
    .setClockwise(true)
    .setName("Red")
    .setCriticalSections(Arrays.asList(
          CriticalSection.CS40,
          CriticalSection.CS32,
          CriticalSection.CS33,
          CriticalSection.CS34,
          CriticalSection.CS35,
          CriticalSection.CS36,
          CriticalSection.CS37,
          CriticalSection.CS38,
          CriticalSection.CS39,
          CriticalSection.CS45,
          CriticalSection.CS46,
          CriticalSection.CS47))
    .build();

  public static final Car YELLOW = new CarBuilder()
    .setColor(Color.YELLOW)
    .setStart(createPoint(4, 7))
    .setPath(createRectangle(3, 6, 7, 4))
    .setClockwise(false)
    .setName("Yellow")
    .setCriticalSections(Arrays.asList(
          CriticalSection.CS22,
          CriticalSection.CS50,
          CriticalSection.CS18,
          CriticalSection.CS19,
          CriticalSection.CS20,
          CriticalSection.CS21,
          CriticalSection.CS28,
          CriticalSection.CS29,
          CriticalSection.CS30,
          CriticalSection.CS31))
    .build();

  public static final int CAR_SIZE = 30;

  private static final int DELAY = 15;

  private static final int OFFSET = (Board.CELL_SIZE - CAR_SIZE) / 2;

  private static final int DX[] = {0, 1, 0, -1};

  private static final int DY[] = {-1, 0, 1, 0};

  private static final int STARTING_DIRECTION = 0;

  private static final int MAX_SPEED = 5;

  private static final int SPEED_INCREMENT = 10;

  private double x;

  private double y;

  private double dx;

  private double dy;

  private int speed;

  private int direction;

  private Thread thread;

  private Color color;

  private Point start;

  private Rectangle path;

  private boolean clockwise;

  private String name;

  private List<CriticalSection> criticalSections;

  private Random random;

  /**
   * Class constructor
   *
   * @param color Car color.
   * @param start Car start point.
   * @param path Car path.
   * @param clockwise True, if the direction is clockwise.
   * @param name Car name.
   * @param criticalSections The order of the critical sections defines the priority of these.
   */
  public Car(Color color, Point start, Rectangle path, boolean clockwise, String name, List<CriticalSection> criticalSections) {
    this.color = color;
    this.start = start;
    this.path = path;
    this.clockwise = clockwise;
    this.name = name;
    this.criticalSections = new ArrayList<CriticalSection>(criticalSections);
    this.random = new Random();

    initCar();
  }

  private void initCar() {
    x = getStart().getX() + OFFSET;
    y = getStart().getY() + OFFSET;
    direction = STARTING_DIRECTION;

    if (thread == null) {
      thread = new Thread(new Timer(this, DELAY));
      thread.start();
    }
  }

  @Override
  public void run() {
    update();
    verifyCriticalSections();
    move();
  }

  private void verifyCriticalSections() {
    Rectangle rect1 = new Rectangle((int)x, (int)y, CAR_SIZE, CAR_SIZE);
    Rectangle rect2 = new Rectangle((int)(x + dx), (int)(y + dy), CAR_SIZE, CAR_SIZE);

    List<CriticalSection> intersectsRect1, intersectsRect2;
    intersectsRect1 = criticalSections.stream().filter(s -> s.getBounds().intersects(rect1)).collect(Collectors.toList());
    intersectsRect2 = criticalSections.stream().filter(s -> s.getBounds().intersects(rect2)).collect(Collectors.toList());

    List<CriticalSection> toRelease = new ArrayList<>(intersectsRect1);
    toRelease.removeAll(intersectsRect2);

    List<CriticalSection> toAcquire = new ArrayList<>(intersectsRect2);
    toAcquire.removeAll(intersectsRect1);

    for (CriticalSection criticalSection: toAcquire) {
      criticalSection.acquire();
    }

    for (CriticalSection criticalSection: toRelease) {
      criticalSection.release();
    }
  }

  private void update() {
    dx = DX[direction] * speed * MAX_SPEED / 100.0;
    dy = DY[direction] * speed * MAX_SPEED / 100.0;
    Rectangle path = getPath();

    if (outOfBounds((int)(x + dx), (int)(y + dy))) {
      if (x + dx > path.getX() + path.getWidth() - CAR_SIZE - OFFSET) {
        dx = path.getX() + path.getWidth() - CAR_SIZE - OFFSET - x;
      } else if (x + dx < path.getX() + OFFSET) {
        dx = path.getX() + OFFSET - x;
      }

      if (y + dy > path.getY() + path.getHeight() - CAR_SIZE - OFFSET) {
        dy = path.getY() + path.getHeight() - CAR_SIZE - OFFSET - y;
      } else if (y + dy < path.getY() + OFFSET) {
        dy = path.getY() + OFFSET - y;
      }

      int mod = Math.min(DX.length, DY.length);
      direction = (direction + (isClockwise() ? 1 : -1) + mod) % mod;
    }
  }

  private void move() {
    x += dx;
    y += dy;
  }

  private boolean outOfBounds(int x, int y) {
    Rectangle path = getPath();
    return !path.contains(x - OFFSET, y - OFFSET, Board.CELL_SIZE, Board.CELL_SIZE);
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public int getSpeed() {
    return this.speed;
  }

  public void increaseSpeed() {
    speed += SPEED_INCREMENT;
    if (speed > 100) {
      speed = 100;
    }
  }

  public void decreaseSpeed() {
    speed -= SPEED_INCREMENT;
    if (speed < 0) {
      speed = 0;
    }
  }

  public void randomizeSpeed() {
    speed = random.nextInt(100);
  }

  public Color getColor() {
    return this.color;
  }

  public Point getStart() {
    return new Point(this.start);
  }

  public Rectangle getPath() {
    return new Rectangle(this.path);
  }

  public boolean isClockwise() {
    return this.clockwise;
  }

  public String getName() {
    return this.name;
  }

  public List<CriticalSection> getCriticalSections() {
    return new ArrayList<CriticalSection>(this.criticalSections);
  }

  private static Point createPoint(int x, int y) {
    return new Point(x * Board.CELL_SIZE, y * Board.CELL_SIZE);
  }

  private static Rectangle createRectangle(int x, int y, int width, int height) {
    return new Rectangle(x * Board.CELL_SIZE, y * Board.CELL_SIZE, width * Board.CELL_SIZE, height * Board.CELL_SIZE);
  }
}
