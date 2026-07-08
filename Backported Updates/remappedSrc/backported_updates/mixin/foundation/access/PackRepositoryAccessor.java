/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3283
 *  net.minecraft.class_3285
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package backported_updates.mixin.foundation.access;

import java.util.Set;
import net.minecraft.class_3283;
import net.minecraft.class_3285;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_3283.class})
public interface PackRepositoryAccessor {
    @Accessor(value="sources")
    public Set<class_3285> getSources();

    @Mutable
    @Accessor(value="sources")
    public void setSources(Set<class_3285> var1);
}

