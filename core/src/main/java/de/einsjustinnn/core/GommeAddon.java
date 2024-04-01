package de.einsjustinnn.core;

import de.einsjustinnn.core.hudwidgets.DiamondTimerIconWidget;
import de.einsjustinnn.core.hudwidgets.DiamondTimerWidget;
import de.einsjustinnn.core.hudwidgets.GoldTimerIconWidget;
import de.einsjustinnn.core.hudwidgets.GoldTimerWidget;
import de.einsjustinnn.core.hudwidgets.IronTimerIconWidget;
import de.einsjustinnn.core.hudwidgets.IronTimerWidget;
import de.einsjustinnn.core.listener.ChatReceiveListener;
import de.einsjustinnn.core.listener.ScoreboardUpdateListener;
import de.einsjustinnn.core.utils.BedWars;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.client.gui.hud.binding.category.HudWidgetCategory;
import net.labymod.api.models.addon.annotation.AddonMain;
import de.einsjustinnn.core.listener.NetworkPayloadListener;

@AddonMain
public class GommeAddon extends LabyAddon<GommeConfiguration> {

  public static final BedWars bedwars = new BedWars();

  @Override
  protected void enable() {
    this.registerSettingCategory();

    this.registerListener(new NetworkPayloadListener());
    this.registerListener(new ChatReceiveListener());
    this.registerListener(new ScoreboardUpdateListener());

    HudWidgetCategory hudWidgetCategory = new HudWidgetCategory("gm_widgets");

    labyAPI().hudWidgetRegistry().categoryRegistry().register(hudWidgetCategory);

    labyAPI().hudWidgetRegistry().register(new GoldTimerWidget(hudWidgetCategory));
    labyAPI().hudWidgetRegistry().register(new IronTimerWidget(hudWidgetCategory));
    labyAPI().hudWidgetRegistry().register(new DiamondTimerWidget(hudWidgetCategory));

    labyAPI().hudWidgetRegistry().register(new GoldTimerIconWidget(hudWidgetCategory));
    labyAPI().hudWidgetRegistry().register(new IronTimerIconWidget(hudWidgetCategory));
    labyAPI().hudWidgetRegistry().register(new DiamondTimerIconWidget(hudWidgetCategory));

  }

  @Override
  protected Class<GommeConfiguration> configurationClass() {
    return GommeConfiguration.class;
  }
}
