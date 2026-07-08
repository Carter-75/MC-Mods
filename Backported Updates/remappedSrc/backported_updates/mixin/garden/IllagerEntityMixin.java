/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1314
 *  net.minecraft.class_1338
 *  net.minecraft.class_1352
 *  net.minecraft.class_1543
 *  net.minecraft.class_1937
 *  net.minecraft.class_3763
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.garden;

import backported.updates.garden.entity.CreakingEntity;
import net.minecraft.class_1299;
import net.minecraft.class_1314;
import net.minecraft.class_1338;
import net.minecraft.class_1352;
import net.minecraft.class_1543;
import net.minecraft.class_1937;
import net.minecraft.class_3763;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1543.class})
public abstract class IllagerEntityMixin
extends class_3763 {
    protected IllagerEntityMixin(class_1299<? extends class_3763> entityType, class_1937 world) {
        super(entityType, world);
    }

    @Inject(method={"initGoals"}, at={@At(value="TAIL")})
    public void initGoals(CallbackInfo ci) {
        this.field_6201.method_6277(3, (class_1352)new class_1338((class_1314)this, CreakingEntity.class, 8.0f, 1.0, 1.2));
    }
}

