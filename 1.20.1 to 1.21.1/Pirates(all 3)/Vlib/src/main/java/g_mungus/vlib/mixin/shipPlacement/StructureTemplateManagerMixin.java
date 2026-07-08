/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_3485
 *  net.minecraft.class_3499
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package g_mungus.vlib.mixin.shipPlacement;

import g_mungus.vlib.data.StructureSettings;
import g_mungus.vlib.structure.StructureManager;
import g_mungus.vlib.v2.internal.template.StructureTemplateInternalExtKt;
import g_mungus.vlib.v2.internal.template.VLibStructureData;
import java.util.Map;
import java.util.Optional;
import net.minecraft.class_2960;
import net.minecraft.class_3485;
import net.minecraft.class_3499;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_3485.class})
public abstract class StructureTemplateManagerMixin {
    @Final
    @Shadow
    private Map<class_2960, Optional<class_3499>> field_15513;

    @Shadow
    protected abstract Optional<class_3499> method_44245(class_2960 var1);

    @Inject(method={"get"}, at={@At(value="HEAD")}, cancellable=true)
    public void getTemplateMixin(class_2960 id, CallbackInfoReturnable<Optional<class_3499>> cir) {
        Optional template = this.field_15513.computeIfAbsent(id, this::method_44245);
        if (template.isPresent() && StructureManager.INSTANCE.getModifiedStructures().containsKey(id.method_12836())) {
            StructureSettings structureSettings = StructureManager.INSTANCE.getModifiedStructures().get(id.method_12836());
            boolean shouldAssemble = false;
            for (String folder : structureSettings.getFolders()) {
                if (!id.method_12832().startsWith(folder)) continue;
                shouldAssemble = true;
                break;
            }
            if (shouldAssemble) {
                StructureTemplateInternalExtKt.saveAdditional((class_3499)template.get(), new VLibStructureData(true));
            }
        }
        cir.setReturnValue((Object)template);
    }
}

