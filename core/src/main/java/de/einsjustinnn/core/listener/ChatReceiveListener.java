package de.einsjustinnn.core.listener;

import de.einsjustinnn.core.GommeAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

public class ChatReceiveListener {

  private static final String[] gameStarted = new String[] {"The game has started!", "Die Runde beginnt!"};

  @Subscribe
  public void onChatReceive(ChatReceiveEvent event) {

    String plainText = event.chatMessage().getPlainText();

    if (plainText.startsWith("[Bedwars]")) {
      if (plainText.contains("The spawn rate of") || plainText.contains("Die Spawnrate von")) {
        if (plainText.contains("Diamond") || plainText.contains("Diamant")) {
          GommeAddon.bedwars.upgradeDiamondTime();
        }
        if (plainText.contains("Gold")) {
          GommeAddon.bedwars.upgradeGoldTime();
        }
      }
    }

    for (String message : gameStarted) {
      if (plainText.equalsIgnoreCase("[Bedwars] " + message) || plainText.equalsIgnoreCase("[ClassicBW] " + message)) {
        GommeAddon.bedwars.setRunning(true);
        GommeAddon.bedwars.setStarted(System.currentTimeMillis());
        break;
      }
    }
  }
}
