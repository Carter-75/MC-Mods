/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1923
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2470
 *  net.minecraft.class_2794
 *  net.minecraft.class_2960
 *  net.minecraft.class_3341
 *  net.minecraft.class_3470
 *  net.minecraft.class_3485
 *  net.minecraft.class_3492
 *  net.minecraft.class_3773
 *  net.minecraft.class_4787$class_4788
 *  net.minecraft.class_5138
 *  net.minecraft.class_5281
 *  net.minecraft.class_5819
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common.worldgen.structure;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.core.VanillaBackport;
import net.minecraft.class_1923;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2470;
import net.minecraft.class_2794;
import net.minecraft.class_2960;
import net.minecraft.class_3341;
import net.minecraft.class_3470;
import net.minecraft.class_3485;
import net.minecraft.class_3492;
import net.minecraft.class_3773;
import net.minecraft.class_4787;
import net.minecraft.class_5138;
import net.minecraft.class_5281;
import net.minecraft.class_5819;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_4787.class_4788.class})
public abstract class NetherFossilPieceMixin
extends class_3470 {
    public NetherFossilPieceMixin(class_3773 type, int genDepth, class_3485 structureTemplateManager, class_2960 location, String templateName, class_3492 placeSettings, class_2338 templatePosition) {
        super(type, genDepth, structureTemplateManager, location, templateName, placeSettings, templatePosition);
    }

    @Inject(method={"postProcess"}, at={@At(value="TAIL")})
    private void placeDriedGhast(class_5281 level, class_5138 structureManager, class_2794 generator, class_5819 worldRandom, class_3341 box, class_1923 chunkPos, class_2338 origin, CallbackInfo ci) {
        if (VanillaBackport.COMMON_CONFIG.hasDriedGhasts.get().booleanValue() && level.method_8597().comp_644() && level.method_8597().method_44220()) {
            int z;
            int y;
            int x;
            class_2338 pos;
            class_3341 template = this.method_41624().method_16187(this.method_41626(), this.method_41625());
            class_5819 random = class_5819.method_43049((long)level.method_8412()).method_38421().method_38419(template.method_22874());
            if (random.method_43057() < 0.5f && level.method_8320(pos = new class_2338(x = template.method_35415() + random.method_43048(template.method_35414()), y = template.method_35416(), z = template.method_35417() + random.method_43048(template.method_14663()))).method_26215() && box.method_14662((class_2382)pos)) {
                level.method_8652(pos, ModBlocks.DRIED_GHAST.get().method_9564().method_26186(class_2470.method_16548((class_5819)random)), 2);
            }
        }
    }
}

