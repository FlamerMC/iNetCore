package net.fc.inetcore.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.fc.inetcore.world.inventory.HomeScreenMenu;
import net.fc.inetcore.network.HomeScreenButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class HomeScreenScreen extends AbstractContainerScreen<HomeScreenMenu> {
	private final static HashMap<String, Object> guistate = HomeScreenMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_empty1;
	ImageButton imagebutton_24673072002;

	public HomeScreenScreen(HomeScreenMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 165;
		this.imageHeight = 235;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("inetcore:textures/screens/home_screen.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("inetcore:textures/screens/untitled.png"), this.leftPos + 0, this.topPos + -1, 0, 0, 165, 234, 165, 234);

		guiGraphics.blit(ResourceLocation.parse("inetcore:textures/screens/solid-color-image.png"), this.leftPos + -1, this.topPos + 210, 0, 0, 165, 25, 165, 25);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.inetcore.home_screen.label_cerizon"), 91, 4, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.inetcore.home_screen.label_kphone"), 5, 4, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.inetcore.home_screen.button_empty"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HomeScreenButtonMessage(0, x, y, z));
				HomeScreenButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 61, this.topPos + 212, 40, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.inetcore.home_screen.button_empty1"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HomeScreenButtonMessage(1, x, y, z));
				HomeScreenButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 26, this.topPos + 48, 25, 20).build();
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		imagebutton_24673072002 = new ImageButton(this.leftPos + 14, this.topPos + 29, 50, 50,
				new WidgetSprites(ResourceLocation.parse("inetcore:textures/screens/2467307-2002.png"), ResourceLocation.parse("inetcore:textures/screens/2467307-2002.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new HomeScreenButtonMessage(2, x, y, z));
						HomeScreenButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_24673072002", imagebutton_24673072002);
		this.addRenderableWidget(imagebutton_24673072002);
	}
}
