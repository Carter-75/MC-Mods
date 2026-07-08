/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_3218
 *  net.minecraft.class_3492
 *  net.minecraft.class_3499
 *  net.minecraft.class_5281
 *  net.minecraft.class_5425
 *  net.minecraft.class_5819
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 */
package g_mungus.vlib.mixin.v2.templatePlacement;

import g_mungus.vlib.v2.api.extension.StructureTemplateExtKt;
import g_mungus.vlib.v2.internal.injected.HasCallbackQueue;
import g_mungus.vlib.v2.internal.template.StructureTemplateInternalExtKt;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_3218;
import net.minecraft.class_3492;
import net.minecraft.class_3499;
import net.minecraft.class_5281;
import net.minecraft.class_5425;
import net.minecraft.class_5819;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_3499.class})
public class StructureTemplateMixin {
    @Unique
    private static final ConcurrentHashMap<class_2338, Boolean> vlib$blacklist = new ConcurrentHashMap();

    @Inject(method={"placeInWorld"}, at={@At(value="HEAD")}, cancellable=true)
    void redirectToShipPlacement(class_5425 serverLevelAccessor, class_2338 blockPos, class_2338 blockPos2, class_3492 structurePlaceSettings, class_5819 randomSource, int i, CallbackInfoReturnable<Boolean> cir) {
        class_3218 serverLevel;
        class_3499 template = (class_3499)this;
        if (StructureTemplateInternalExtKt.readAdditional(template).isShip() && serverLevelAccessor instanceof class_5281 && !VSGameUtilsKt.isBlockInShipyard((class_1937)(serverLevel = serverLevelAccessor.method_8410()), (class_2338)blockPos)) {
            if (serverLevelAccessor instanceof class_3218) {
                StructureTemplateExtKt.placeAsShip(template, serverLevel, blockPos, false);
            } else if (vlib$blacklist.putIfAbsent(blockPos, Boolean.TRUE) == null) {
                ((HasCallbackQueue)serverLevel).vlib$enqueue(0, (Function0<Unit>)((Function0)() -> {
                    StructureTemplateExtKt.placeAsShip(template, serverLevel, blockPos, false);
                    return Unit.INSTANCE;
                }));
            }
            cir.setReturnValue((Object)true);
        }
    }
}

