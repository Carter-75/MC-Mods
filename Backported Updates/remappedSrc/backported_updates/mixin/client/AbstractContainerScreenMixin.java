/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1703
 *  net.minecraft.class_1735
 *  net.minecraft.class_1767
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_332
 *  net.minecraft.class_3936
 *  net.minecraft.class_437
 *  net.minecraft.class_4587
 *  net.minecraft.class_465
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
import net.minecraft.class_1703;
import net.minecraft.class_1735;
import net.minecraft.class_1767;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_3936;
import net.minecraft.class_437;
import net.minecraft.class_4587;
import net.minecraft.class_465;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_465.class})
public abstract class AbstractContainerScreenMixin<T extends class_1703>
extends class_437
implements class_3936<T> {
    @Shadow
    protected int field_2792;
    @Unique
    private static final class_2960 BUNDLE_OPEN_BACK = class_2960.method_60656((String)"textures/item/bundle_open_back.png");
    @Unique
    private static final class_2960 BUNDLE_OPEN_FRONT = class_2960.method_60656((String)"textures/item/bundle_open_front.png");

    protected AbstractContainerScreenMixin(class_2561 title) {
        super(title);
    }

    @Inject(method={"renderSlot"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$renderBundleContents(class_332 graphics, class_1735 slot, CallbackInfo ci) {
        class_1799 selectedItem;
        class_1799 stack = slot.method_7677();
        if (stack.method_31573(ModItemTags.BUNDLES) && !(selectedItem = BundleFeatures.getSelectedItemStack(stack)).method_7960()) {
            class_2960 backTexture = BUNDLE_OPEN_BACK;
            class_2960 frontTexture = BUNDLE_OPEN_FRONT;
            for (class_1767 color : class_1767.values()) {
                if (!stack.method_31574(BundleFeatures.getByColor(color)) || stack.method_31574(class_1802.field_27023)) continue;
                backTexture = class_2960.method_60656((String)("textures/item/" + color.method_7792() + "_bundle_open_back.png"));
                frontTexture = class_2960.method_60656((String)("textures/item/" + color.method_7792() + "_bundle_open_front.png"));
                break;
            }
            class_4587 pose = graphics.method_51448();
            int slotX = slot.field_7873;
            int slotY = slot.field_7872;
            pose.method_22903();
            pose.method_46416(0.0f, 0.0f, 100.0f);
            graphics.method_25290(backTexture, slotX, slotY, 0.0f, 0.0f, 16, 16, 16, 16);
            graphics.method_51428(selectedItem, slotX, slotY, slot.field_7873 + slot.field_7872 * this.field_2792);
            pose.method_22903();
            pose.method_46416(0.0f, 0.0f, 200.0f);
            graphics.method_25290(frontTexture, slotX, slotY, 0.0f, 0.0f, 16, 16, 16, 16);
            graphics.method_51431(this.field_22793, stack, slotX, slotY);
            pose.method_22909();
            pose.method_22909();
            ci.cancel();
        }
    }
}

