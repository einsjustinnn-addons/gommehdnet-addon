package de.einsjustinnn.core.listener;

import de.einsjustinnn.core.GommeAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

public class ChatReceiveListener {

  @Subscribe
  public void onChatReceive(ChatReceiveEvent event) {

    String plainText = event.chatMessage().getPlainText();

    if (plainText.equalsIgnoreCase("[BedWars] Die Runde beginnt!")) {

      GommeAddon.bedwars.setRunning(true);
      GommeAddon.bedwars.setStarted(System.currentTimeMillis());
    }

  }
}
