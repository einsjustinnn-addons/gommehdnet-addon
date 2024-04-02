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

  public int getDiamondTime() {
    /*
    TODO: (non classic)
    - add Diamond II Time
     */
    if (!classic) {
      return 25;
    }
    return -1;
  }

  public int getGoldTime() {
    /*
    TODO: (non classic)
    - add Gold II Time
     */
    if (classic) {
      return 30;
    } else {
      return 40;
    }
  }

  public int getIronTime() {
    if (classic) {
      return 10;
    } else {
      return 8;
    }
  }

  public void reset() {
    started = 0L;
    running = false;
    classic = false;
  }
}
