/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList$Builder
 *  net.minecraft.loot.LootTable$Builder
 *  net.minecraft.loot.LootPool
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package backported_updates.mixin.foundation.fabric.loot;

import com.google.common.collect.ImmutableList;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootPool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={LootTable.Builder.class})
public interface LootTableBuilderAccessor {
    @Accessor
    public ImmutableList.Builder<LootPool> getPools();

    @Accessor(value="pools")
    public void setPools(ImmutableList.Builder<LootPool> var1);
}

