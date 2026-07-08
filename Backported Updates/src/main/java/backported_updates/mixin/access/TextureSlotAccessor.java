/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.data.client.TextureKey
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.access;

import net.minecraft.data.client.TextureKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={TextureKey.class})
public interface TextureSlotAccessor {
    @Invoker(value="of")
    public static TextureKey of(String name) {
        throw new IllegalStateException("");
    }
}

