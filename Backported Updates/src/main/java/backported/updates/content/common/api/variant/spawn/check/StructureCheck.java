/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.registry.Registry
 *  net.minecraft.world.gen.structure.Structure
 *  net.minecraft.structure.StructureStart
 *  net.minecraft.world.gen.StructureAccessor
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.entry.RegistryEntryList
 *  net.minecraft.registry.RegistryCodecs
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.common.api.variant.spawn.check;

import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.structure.StructureStart;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.RegistryCodecs;
import net.minecraft.registry.RegistryKeys;

public record StructureCheck(RegistryEntryList<Structure> requiredStructures) implements SpawnCondition
{
    public static final MapCodec<StructureCheck> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(RegistryCodecs.entryList(RegistryKeys.STRUCTURE).fieldOf("structures").forGetter(StructureCheck::requiredStructures)).apply(instance, StructureCheck::new));

    @Override
    public boolean test(SpawnContext context) {
        return this.getStructureWithPieceAt(context, arg_0 -> this.requiredStructures.contains(arg_0)).hasChildren();
    }

    private StructureStart getStructureWithPieceAt(SpawnContext context, Predicate<RegistryEntry<Structure>> predicate) {
        StructureAccessor manager = context.level().toServerWorld().getStructureAccessor();
        BlockPos pos = context.pos();
        Registry<Structure> registry = manager.getRegistryManager().get(RegistryKeys.STRUCTURE);
        List<StructureStart> starts = manager.getStructureStarts(new ChunkPos(pos), structure -> registry.getEntry(registry.getRawId(structure)).map(predicate::test).orElse(false));
        for (StructureStart start : starts) {
            if (!manager.structureContains(pos, start)) continue;
            return start;
        }
        return StructureStart.DEFAULT;
    }

    @Override
    public MapCodec<? extends SpawnCondition> codec() {
        return CODEC;
    }
}

