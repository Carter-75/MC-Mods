/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.exceptions.CommandSyntaxException
 *  net.minecraft.class_2168
 *  net.minecraft.class_2232
 *  net.minecraft.class_2262
 *  net.minecraft.class_2338
 *  net.minecraft.class_2960
 *  net.minecraft.class_3218
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package g_mungus.vlib.mixin.v2.templatePlacement;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import g_mungus.vlib.v2.internal.template.StructureTemplateInternalExtKt;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.class_2168;
import net.minecraft.class_2232;
import net.minecraft.class_2262;
import net.minecraft.class_2338;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_2262.class})
public class BlockPosArgumentMixin {
    @Inject(method={"getLoadedBlockPos(Lcom/mojang/brigadier/context/CommandContext;Lnet/minecraft/server/level/ServerLevel;Ljava/lang/String;)Lnet/minecraft/core/BlockPos;"}, at={@At(value="HEAD")}, cancellable=true)
    private static void onGetLoadedBlockPos(CommandContext<class_2168> commandContext, class_3218 serverLevel, String string, CallbackInfoReturnable<class_2338> cir) throws CommandSyntaxException {
        AtomicBoolean shouldBypassHeightCheck = new AtomicBoolean(false);
        try {
            class_2960 id = class_2232.method_9443(commandContext, (String)"template");
            serverLevel.method_14183().method_15094(id).ifPresent(template -> shouldBypassHeightCheck.set(StructureTemplateInternalExtKt.readAdditional(template).isShip()));
        }
        catch (Exception id) {
            // empty catch block
        }
        if (shouldBypassHeightCheck.get()) {
            class_2338 blockPos = class_2262.method_48299(commandContext, (String)string);
            if (!serverLevel.method_22340(blockPos)) {
                throw class_2262.field_10703.create();
            }
            cir.setReturnValue((Object)blockPos);
        }
    }
}

