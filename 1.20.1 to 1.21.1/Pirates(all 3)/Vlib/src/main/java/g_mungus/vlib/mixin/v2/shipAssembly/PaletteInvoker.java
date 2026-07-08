/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3499$class_3501
 *  net.minecraft.class_3499$class_5162
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package g_mungus.vlib.mixin.v2.shipAssembly;

import java.util.List;
import net.minecraft.class_3499;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_3499.class_5162.class})
public interface PaletteInvoker {
    @Invoker(value="<init>")
    public static class_3499.class_5162 invokeInit(List<class_3499.class_3501> blocks) {
        throw new AssertionError();
    }
}

