package de.einsjustinnn.core.hudwidgets;

import de.einsjustinnn.core.GommeAddon;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.gui.hud.binding.category.HudWidgetCategory;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidget;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine.State;
import net.labymod.api.client.gui.icon.Icon;

public class GoldTimerWidget extends TextHudWidget<TextHudWidgetConfig> {

  private TextLine line;

  public GoldTimerWidget(HudWidgetCategory hudWidgetCategory) {
    super("bw_goldWidget");
    bindCategory(hudWidgetCategory);
    setIcon(Icon.url("resource:minecraft://textures/item/gold_ingot.png"));
  }

  @Override
  public void load(TextHudWidgetConfig config) {
    super.load(config);
    line = createLine(Component.translatable("gommehdnet.hudWidget.bw_goldWidget.name"), GommeAddon.bedwars.getGoldTime());
  }

  @Override
  public void onTick(boolean isEditorContext) {
    super.onTick(isEditorContext);

    if (GommeAddon.bedwars.isRunning()) {
      long started = GommeAddon.bedwars.getStarted();

      int elapsedTime = (int)((System.currentTimeMillis() - started) / 1000L);
      int timer = GommeAddon.bedwars.getGoldTime() - elapsedTime % GommeAddon.bedwars.getGoldTime();

      line.updateAndFlush(timer);

      line.setState(State.VISIBLE);
    } else {
      line.setState(State.HIDDEN);
    }
  }
}
