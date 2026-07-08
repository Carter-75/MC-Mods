/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_5218
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.foundation.access;

import net.minecraft.class_5218;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_5218.class})
public interface LevelResourceAccessor {
    @Invoker(value="<init>")
    public static class_5218 createLevelResource(String string) {
        throw new UnsupportedOperationException();
    }
}

