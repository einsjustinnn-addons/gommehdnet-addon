package de.einsjustinnn.core.listener;

import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.scoreboard.ScoreboardObjectiveUpdateEvent;
import net.labymod.api.event.client.scoreboard.ScoreboardScoreUpdateEvent;

public class ScoreboardUpdateListener {

  @Subscribe
  private void on(ScoreboardObjectiveUpdateEvent event) {
  }
}
