package de.einsjustinnn.core.listener;

import de.einsjustinnn.core.GommeAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

public class ChatReceiveListener {

  private static final String[] gameStarted = new String[] {"The game has started!", "Die Runde beginnt!"};

  @Subscribe
  public void onChatReceive(ChatReceiveEvent event) {

    // 1-2
    // Gold Diamond
    // Gold Diamant
    // [BedWars] The spawn rate of Diamond was increased to level 2
    // [BedWars] Die Spawnrate von Diamant wurde auf Stufe 2 erhöht

    String plainText = event.chatMessage().getPlainText();

    for (String message : gameStarted) {
      if (plainText.equalsIgnoreCase("[Bedwars] " + message) || plainText.equalsIgnoreCase("[ClassicBW] " + message)) {
        GommeAddon.bedwars.setRunning(true);
        GommeAddon.bedwars.setStarted(System.currentTimeMillis());
        break;
      }
    }
  }
}
