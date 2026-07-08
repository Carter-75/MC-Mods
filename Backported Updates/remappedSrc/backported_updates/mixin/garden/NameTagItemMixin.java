/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1807
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.garden;

import backported.updates.garden.entity.CreakingEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1807;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1807.class})
public abstract class NameTagItemMixin
extends class_1792 {
    public NameTagItemMixin(class_1792.class_1793 settings) {
        super(settings);
    }

    @Inject(method={"useOnEntity"}, at={@At(value="HEAD")}, cancellable=true)
    public void useOnEntity(class_1799 stack, class_1657 user, class_1309 entity, class_1268 hand, CallbackInfoReturnable<class_1269> cir) {
        if (entity instanceof CreakingEntity) {
            cir.setReturnValue((Object)class_1269.field_5811);
        }
    }
}

