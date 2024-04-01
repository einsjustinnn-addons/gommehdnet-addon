package de.einsjustinnn.core.listener;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.einsjustinnn.core.GommeAddon;
import net.labymod.api.client.resources.ResourceLocation;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.network.server.NetworkPayloadEvent;
import net.labymod.serverapi.protocol.payload.io.PayloadReader;

public class NetworkPayloadListener {

  @Subscribe
  public void onNetworkPayload(NetworkPayloadEvent event) {

    ResourceLocation identifier = event.identifier();

    if (identifier.getNamespace().equalsIgnoreCase("minecraft") && identifier.getPath().equalsIgnoreCase("gomod")) {

      PayloadReader payloadReader = new PayloadReader(event.getPayload());
      String payload = payloadReader.readString();

      JsonObject jsonObject = JsonParser.parseString(payload).getAsJsonObject();

      String serverType = jsonObject.get("data").getAsJsonObject().get("cloud_type").getAsString();

      GommeAddon.bedwars.reset();

      if (serverType.equalsIgnoreCase("classicbw")) GommeAddon.bedwars.setClassic(true);
    }
  }
}
