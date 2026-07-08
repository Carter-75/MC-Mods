/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList$Builder
 *  net.minecraft.class_52$class_53
 *  net.minecraft.class_55
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package backported_updates.mixin.foundation.fabric.loot;

import com.google.common.collect.ImmutableList;
import net.minecraft.class_52;
import net.minecraft.class_55;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_52.class_53.class})
public interface LootTableBuilderAccessor {
    @Accessor
    public ImmutableList.Builder<class_55> getPools();

    @Accessor(value="pools")
    public void setPools(ImmutableList.Builder<class_55> var1);
}

