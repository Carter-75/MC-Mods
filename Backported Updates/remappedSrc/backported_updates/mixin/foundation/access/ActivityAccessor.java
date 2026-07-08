/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4168
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.foundation.access;

import net.minecraft.class_4168;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_4168.class})
public interface ActivityAccessor {
    @Invoker(value="<init>")
    public static class_4168 createActivity(String name) {
        throw new AssertionError();
    }
}

