package net.fc.techdecor.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.fc.techdecor.world.inventory.LockMenu;
import net.fc.techdecor.network.LockButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class LockScreen extends AbstractContainerScreen<LockMenu> {
	private final static HashMap<String, Object> guistate = LockMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;

	public LockScreen(LockMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 165;
		this.imageHeight = 235;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("techdecor:textures/screens/lock.png");

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

		guiGraphics.blit(ResourceLocation.parse("techdecor:textures/screens/untitled.png"), this.leftPos + 1, this.topPos + 1, 0, 0, 165, 234, 165, 234);

		guiGraphics.blit(ResourceLocation.parse("techdecor:textures/screens/solid-color-image.png"), this.leftPos + -1, this.topPos + 210, 0, 0, 165, 25, 165, 25);

		guiGraphics.blit(ResourceLocation.parse("techdecor:textures/screens/file1.png"), this.leftPos + 49, this.topPos + 52, 0, 0, 64, 30, 64, 30);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.techdecor.lock.label_cerizon"), 91, 4, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.techdecor.lock.label_kphone"), 5, 4, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.techdecor.lock.label_press_to_home_button_to_unlock"), 7, 197, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.techdecor.lock.button_empty"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new LockButtonMessage(0, x, y, z));
				LockButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 61, this.topPos + 212, 40, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
	}
}
