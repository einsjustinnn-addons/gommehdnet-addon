package de.einsjustinnn.core.utils;

public class BedWars {

  private boolean running;
  private boolean classic;
  private long started;

  private int goldTime;
  private int diamondTime;

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

  public void upgradeDiamondTime() {
    switch (diamondTime) {
      case 25:
        diamondTime = 17;
        break;
      case 17:
        diamondTime = 13;
        break;
      default:
        break;
    }
  }

  public int getDiamondTime() {
    if (!classic) {
      return diamondTime;
    }
    return -1;
  }

  public void upgradeGoldTime() {
    switch (goldTime) {
      case 40:
        goldTime = 27;
        break;
      case 27:
        goldTime = 20;
        break;
      default:
        break;
    }
  }

  public int getGoldTime() {
    if (classic) {
      return 30;
    } else {
      return goldTime;
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
    goldTime = 40;
    diamondTime = 25;
  }
}
