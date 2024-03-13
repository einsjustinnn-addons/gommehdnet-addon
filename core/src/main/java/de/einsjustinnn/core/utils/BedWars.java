package de.einsjustinnn.core.utils;

public class BedWars {

  private boolean running;
  private boolean classic;
  private long started;

  public void setClassic(boolean classic) {
    this.classic = classic;
  }

  public boolean isClassic() {
    return classic;
  }

  public void setRunning(boolean running) {
    this.running = running;
  }

  public boolean isRunning() {
    return running;
  }

  public void setStarted(long started) {
    this.started = started;
  }

  public long getStarted() {
    return started;
  }

  public void reset() {
    started = 0L;
    running = false;
    classic = false;
  }
}
