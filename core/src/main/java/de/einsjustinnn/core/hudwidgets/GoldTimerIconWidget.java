package de.einsjustinnn.core.hudwidgets;

import de.einsjustinnn.core.GommeAddon;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.gui.hud.binding.category.HudWidgetCategory;
import net.labymod.api.client.gui.hud.hudwidget.item.EquipmentWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.item.ItemHudWidget;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.render.font.RenderableComponent;

public class GoldTimerIconWidget extends ItemHudWidget<EquipmentWidgetConfig> {

  public GoldTimerIconWidget(HudWidgetCategory hudWidgetCategory) {
    super("bw_goldIconWidget");
    bindCategory(hudWidgetCategory);
  }

  @Override
  public RenderableComponent getRenderableItemName(boolean isEditorContext) {

    if (!GommeAddon.bedwars.isRunning()) {
      return RenderableComponent.of(Component.text(GommeAddon.bedwars.getGoldTime()));
    }

    long started = GommeAddon.bedwars.getStarted();
    int elapsedTime = (int)((System.currentTimeMillis() - started) / 1000L);
    int timer = GommeAddon.bedwars.getGoldTime() - elapsedTime % GommeAddon.bedwars.getGoldTime();

    return RenderableComponent.of(Component.text(timer));
  }

  @Override
  public Icon createPlaceholderIcon() {
    return Icon.url("resource:minecraft://textures/item/gold_ingot.png");
  }

  @Override
  public boolean isVisibleInGame() {
      return GommeAddon.bedwars.isRunning();
  }
}
