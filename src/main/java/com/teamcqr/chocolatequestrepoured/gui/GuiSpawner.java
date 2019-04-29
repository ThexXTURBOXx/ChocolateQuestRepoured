package com.teamcqr.chocolatequestrepoured.gui;

import com.teamcqr.chocolatequestrepoured.gui.container.ContainerSpawner;
import com.teamcqr.chocolatequestrepoured.tileentity.TileEntitySpawner;
import com.teamcqr.chocolatequestrepoured.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiSpawner extends GuiContainer
{
	private static final ResourceLocation GUI_SPAWNER = new ResourceLocation("textures/gui/container/dispenser.png");
	private final InventoryPlayer playerInventory;
	private final TileEntitySpawner te;

	public GuiSpawner(InventoryPlayer playerInventory, TileEntitySpawner tileInventory) 
	{
		super(new ContainerSpawner(playerInventory, tileInventory));
		this.playerInventory = playerInventory;
		this.te = tileInventory;

		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		String s = this.te.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_SPAWNER);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
} 