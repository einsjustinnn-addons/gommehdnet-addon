package de.einsjustinnn.core.hudwidgets;

import de.einsjustinnn.core.GommeAddon;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.gui.hud.binding.category.HudWidgetCategory;
import net.labymod.api.client.gui.hud.hudwidget.item.EquipmentWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.item.ItemHudWidget;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.render.font.RenderableComponent;
import net.labymod.api.client.resources.ResourceLocation;

public class IronTimerIconWidget extends ItemHudWidget<EquipmentWidgetConfig> {

  public IronTimerIconWidget(HudWidgetCategory hudWidgetCategory) {
    super("bw_ironIconWidget");
    bindCategory(hudWidgetCategory);
    setIcon(Icon.texture(ResourceLocation.create("minecraft", "textures/item/iron_ingot.png")));
  }

  @Override
  public RenderableComponent getRenderableItemName(boolean isEditorContext) {

    if (!GommeAddon.bedwars.isRunning()) return RenderableComponent.of(Component.text(GommeAddon.bedwars.getIronTime()));

    long started = GommeAddon.bedwars.getStarted();
    int elapsedTime = (int)((System.currentTimeMillis() - started) / 1000L);
    int timer = GommeAddon.bedwars.getIronTime() - elapsedTime % GommeAddon.bedwars.getIronTime();

    return RenderableComponent.of(Component.text(timer));
  }

  @Override
  public Icon createPlaceholderIcon() {
    return Icon.texture(ResourceLocation.create("minecraft", "textures/item/iron_ingot.png"));
  }

  @Override
  public boolean isVisibleInGame() {
      return GommeAddon.bedwars.isRunning();
  }
}
