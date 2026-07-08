/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.util.DyeColor
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.text.Text
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.client;

import backported.updates.content.common.api.bundle.BundleFeatures;
import backported.updates.content.core.data.tags.ModItemTags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={HandledScreen.class})
public abstract class AbstractContainerScreenMixin<T extends ScreenHandler>
extends Screen
implements ScreenHandlerProvider<T> {
    @Shadow
    protected int backgroundWidth;
    @Unique
    private static final Identifier BUNDLE_OPEN_BACK = Identifier.ofVanilla((String)"textures/item/bundle_open_back.png");
    @Unique
    private static final Identifier BUNDLE_OPEN_FRONT = Identifier.ofVanilla((String)"textures/item/bundle_open_front.png");

    protected AbstractContainerScreenMixin(Text title) {
        super(title);
    }

    @Inject(method={"drawSlot"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$renderBundleContents(DrawContext graphics, Slot slot, CallbackInfo ci) {
        ItemStack selectedItem;
        ItemStack stack = slot.getStack();
        if (stack.isIn(ModItemTags.BUNDLES) && !(selectedItem = BundleFeatures.getSelectedItemStack(stack)).isEmpty()) {
            Identifier backTexture = BUNDLE_OPEN_BACK;
            Identifier frontTexture = BUNDLE_OPEN_FRONT;
            for (DyeColor color : DyeColor.values()) {
                if (!stack.isOf(BundleFeatures.getByColor(color)) || stack.isOf(Items.BUNDLE)) continue;
                backTexture = Identifier.ofVanilla((String)("textures/item/" + color.getName() + "_bundle_open_back.png"));
                frontTexture = Identifier.ofVanilla((String)("textures/item/" + color.getName() + "_bundle_open_front.png"));
                break;
            }
            MatrixStack pose = graphics.getMatrices();
            int slotX = slot.x;
            int slotY = slot.y;
            pose.push();
            pose.translate(0.0f, 0.0f, 100.0f);
            graphics.drawTexture(backTexture, slotX, slotY, 0.0f, 0.0f, 16, 16, 16, 16);
            graphics.drawItem(selectedItem, slotX, slotY, slot.x + slot.y * this.backgroundWidth);
            pose.push();
            pose.translate(0.0f, 0.0f, 200.0f);
            graphics.drawTexture(frontTexture, slotX, slotY, 0.0f, 0.0f, 16, 16, 16, 16);
            graphics.drawItemInSlot(this.textRenderer, stack, slotX, slotY);
            pose.pop();
            pose.pop();
            ci.cancel();
        }
    }
}

