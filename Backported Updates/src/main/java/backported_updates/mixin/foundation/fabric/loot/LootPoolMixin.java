/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.loot.function.LootFunction
 *  net.minecraft.loot.condition.LootCondition
 *  net.minecraft.loot.LootPool
 *  net.minecraft.loot.provider.number.LootNumberProvider
 *  net.minecraft.loot.entry.LootPoolEntry
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.foundation.fabric.loot;

import backported.updates.foundation.common.data.fabric.LootPoolAccess;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.entry.LootPoolEntry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={LootPool.class})
public class LootPoolMixin
implements LootPoolAccess {
    @Shadow
    @Final
    public LootNumberProvider rolls;
    @Shadow
    @Final
    public LootNumberProvider bonusRolls;
    @Shadow
    @Final
    public List<LootCondition> conditions;
    @Shadow
    @Final
    public List<LootFunction> functions;
    @Shadow
    @Final
    public List<LootPoolEntry> entries;

    @Invoker(value="<init>")
    static LootPool create(List<LootPoolEntry> entries, List<LootCondition> conditions, List<LootFunction> functions, LootNumberProvider rolls, LootNumberProvider bonusRolls) {
        throw new AssertionError();
    }

    @Override
    public LootPool mergeEntries(List<LootPoolEntry> contents) {
        ArrayList merged = Lists.newArrayList(this.entries);
        merged.addAll(contents);
        return LootPoolMixin.create(merged, this.conditions, this.functions, this.rolls, this.bonusRolls);
    }
}

