import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

/**
 * This class is a facility to create Car objects.
 *
 * @author Igor Quadros Silva (201610519@uesb.edu.br)
 * @version 1.0, 06/12/2021
 */
public class CarBuilder {
  private Color color;

  private Point start;

  private Rectangle path;

  private boolean clockwise;

  private String name;

  private List<CriticalSection> criticalSections;

  public Car build() {
    return new Car(color, start, path, clockwise, name, criticalSections);
  }

  public CarBuilder setColor(Color color) {
    this.color = color;
    return this;
  }

  public CarBuilder setStart(Point start) {
    this.start = start;
    return this;
  }

  public CarBuilder setPath(Rectangle path) {
    this.path = path;
    return this;
  }

  public CarBuilder setClockwise(boolean clockwise) {
    this.clockwise = clockwise;
    return this;
  }

  public CarBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CarBuilder setCriticalSections(List<CriticalSection> criticalSections) {
    this.criticalSections = criticalSections;
    return this;
  }
}
