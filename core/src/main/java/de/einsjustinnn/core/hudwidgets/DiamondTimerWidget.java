package de.einsjustinnn.core.hudwidgets;

import de.einsjustinnn.core.GommeAddon;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.gui.hud.binding.category.HudWidgetCategory;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidget;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine.State;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.resources.ResourceLocation;

public class DiamondTimerWidget extends TextHudWidget<TextHudWidgetConfig> {

  private TextLine line;

  public DiamondTimerWidget(HudWidgetCategory hudWidgetCategory) {
    super("bw_diamondWidget");
    bindCategory(hudWidgetCategory);
    setIcon(Icon.texture(ResourceLocation.create("minecraft", "textures/gold_ingot.png")));
  }

  @Override
  public void load(TextHudWidgetConfig config) {
    super.load(config);
    line = createLine(Component.translatable("gommehdnet.hudWidget.bw_diamondWidget.name"), 25);
  }

  @Override
  public void onTick(boolean isEditorContext) {
    super.onTick(isEditorContext);

    if (GommeAddon.bedwars.isRunning()) {

      if (GommeAddon.bedwars.isClassic()) {
        line.setState(State.HIDDEN);
        return;
      }

      long started = GommeAddon.bedwars.getStarted();

      int elapsedTime = (int)((System.currentTimeMillis() - started) / 1000L);
      int timer = 25 - elapsedTime % 25;

      line.updateAndFlush(timer);

      line.setState(State.VISIBLE);
    } else {
      line.setState(State.HIDDEN);
    }
  }
}
