/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3499
 *  net.minecraft.class_3499$class_3502
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package g_mungus.vlib.mixin.v2.templatePlacement;

import java.util.List;
import net.minecraft.class_3499;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_3499.class})
public interface StructureTemplateAccessor {
    @Accessor
    public List<class_3499.class_3502> getEntityInfoList();
}

