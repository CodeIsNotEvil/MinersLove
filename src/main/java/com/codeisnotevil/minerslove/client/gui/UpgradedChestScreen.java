package com.codeisnotevil.minerslove.client.gui;

import com.codeisnotevil.minerslove.MinersLove;
import com.codeisnotevil.minerslove.container.UpgradedChestContainer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class UpgradedChestScreen extends ContainerScreen<UpgradedChestContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(MinersLove.MOD_ID, "textures/gui/tab_items.png");

    public UpgradedChestScreen(UpgradedChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 194;
        this.ySize = 193;
    }

    @Override
    public void render(final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        this.font.drawString(this.title.getFormattedText(), 8.0f, 6.0f, 4210752);
        //this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(),8.0f, 108.0f, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f); //RGBA
        this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.xSize) / 2;
        this.blit(x,y,0,0,this.xSize, this.ySize);
    }
}
