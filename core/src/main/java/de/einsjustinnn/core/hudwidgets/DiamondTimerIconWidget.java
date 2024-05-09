package de.einsjustinnn.core.hudwidgets;

import de.einsjustinnn.core.GommeAddon;
import net.labymod.api.Laby;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.gui.hud.binding.category.HudWidgetCategory;
import net.labymod.api.client.gui.hud.hudwidget.item.EquipmentWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.item.ItemHudWidget;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.render.font.RenderableComponent;
import net.labymod.api.client.resources.ResourceLocation;

public class DiamondTimerIconWidget extends ItemHudWidget<EquipmentWidgetConfig> {

  public DiamondTimerIconWidget(HudWidgetCategory hudWidgetCategory) {
    super("bw_diamondIconWidget");
    bindCategory(hudWidgetCategory);

    String icon = "textures/item/diamond.png";
    if (Laby.labyAPI().minecraft().getProtocolVersion() <= 393) icon = "textures/items/diamond.png";
    setIcon(Icon.texture(ResourceLocation.create("minecraft", icon)));
  }

  @Override
  public RenderableComponent getRenderableItemName(boolean isEditorContext) {

    if (!GommeAddon.bedwars.isRunning()) return RenderableComponent.of(Component.text(GommeAddon.bedwars.getDiamondTime()));

    long started = GommeAddon.bedwars.getStarted();
    int elapsedTime = (int)((System.currentTimeMillis() - started) / 1000L);
    int timer = GommeAddon.bedwars.getDiamondTime();
    if (timer != 0) {
      timer = timer - elapsedTime % timer;
    }

    return RenderableComponent.of(Component.text(timer));
  }

  @Override
  public Icon createPlaceholderIcon() {
    String icon = "textures/item/diamond.png";
    if (Laby.labyAPI().minecraft().getProtocolVersion() <= 393) icon = "textures/items/diamond.png";
    return Icon.texture(ResourceLocation.create("minecraft", icon));
  }

  @Override
  public boolean isVisibleInGame() {
    if (GommeAddon.bedwars.isRunning()) {
        return !GommeAddon.bedwars.isClassic();
    } else {
      return false;
    }
  }
}
