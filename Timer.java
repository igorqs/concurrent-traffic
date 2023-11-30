/**
 * This class is a facility for executing tasks at specific intervals.
 *
 * @author Igor Quadros Silva (201610519@uesb.edu.br)
 * @version 1.0, 06/12/2021
 */
public class Timer implements Runnable {
  private int delay;

  private Runnable runnable;

  public Timer(Runnable runnable, int delay) {
    this.runnable = runnable;
    this.delay = delay;
  }

  @Override
  public void run() {
    long beforeTime, timeDiff, sleep;

    beforeTime = System.currentTimeMillis();

    while (true) {
      runnable.run();

      timeDiff = System.currentTimeMillis() - beforeTime;
      sleep = delay - timeDiff;

      if (sleep < 0) {
        sleep = 2;
      }

      try {
        Thread.sleep(sleep);
      } catch (InterruptedException e) {
        String message = String.format("Thread interrupted: %s", e.getMessage());

        System.err.println(message);
      }

      beforeTime = System.currentTimeMillis();
    }
  }
}
