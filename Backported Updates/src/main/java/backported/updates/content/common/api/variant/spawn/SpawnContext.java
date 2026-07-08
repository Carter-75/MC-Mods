/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.ServerWorldAccess
 *  net.minecraft.registry.entry.RegistryEntry
 */
package backported.updates.content.common.api.variant.spawn;

import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.registry.entry.RegistryEntry;

public record SpawnContext(BlockPos pos, ServerWorldAccess level, RegistryEntry<Biome> biome) {
    public static SpawnContext create(ServerWorldAccess level, BlockPos pos) {
        RegistryEntry biome = level.getBiome(pos);
        return new SpawnContext(pos, level, (RegistryEntry<Biome>)biome);
    }
}

