/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.world.BlockRenderView
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.biome.Biome$Weather
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.client.world.BiomeColorCache
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.world.biome.ColorResolver
 *  net.minecraft.registry.entry.RegistryEntry
 */
package backported.updates.content.client.api.color;

import backported.updates.content.client.api.color.DryFoliageColor;
import backported.updates.content.client.resources.LeafColorReloadListener;
import backported.updates.content.core.data.tags.ModBiomeTags;
import backported_updates.mixin.access.BiomeAccessor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.biome.Biome;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.world.BiomeColorCache;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.world.biome.ColorResolver;
import net.minecraft.registry.entry.RegistryEntry;

@Environment(value=EnvType.CLIENT)
public class LeafColors {
    private static final Map<Predicate<RegistryEntry<Biome>>, Integer> COLOR_MAP = new ConcurrentHashMap<Predicate<RegistryEntry<Biome>>, Integer>();
    public static final ColorResolver DRY_FOLIAGE_COLOR_RESOLVER = (biome, d, e) -> {
        Biome.Weather settings = ((BiomeAccessor)(Object)biome).getWeather();
        double temperature = MathHelper.clamp((float)settings.temperature(), (float)0.0f, (float)1.0f);
        double humidity = MathHelper.clamp((float)settings.downfall(), (float)0.0f, (float)1.0f);
        return DryFoliageColor.get(temperature, humidity);
    };

    public static int getAverageDryFoliageColor(BlockPos pos) {
        ClientWorld level = MinecraftClient.getInstance().world;
        if (level != null) {
            RegistryEntry biome = level.getBiome(pos);
            return COLOR_MAP.entrySet().stream().filter(entry -> (entry.getKey()).test(biome)).findFirst().map(Map.Entry::getValue).orElseGet(() -> new BiomeColorCache(value -> level.calculateColor(value, DRY_FOLIAGE_COLOR_RESOLVER)).getBiomeColor(pos));
        }
        return -10732494;
    }

    public static int getClientLeafTintColor(BlockPos pos) {
        ClientWorld level = MinecraftClient.getInstance().world;
        if (level == null) {
            return 0;
        }
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();
        if (LeafColorReloadListener.hasCustomColor(block)) {
            return LeafColorReloadListener.getCustomColor(block);
        }
        return MinecraftClient.getInstance().getBlockColors().getColor(state, (BlockRenderView)level, pos, 0);
    }

    static {
        COLOR_MAP.put(holder -> holder.isIn(ModBiomeTags.HAS_PALE_LEAF_LITTER), 10528412);
        COLOR_MAP.put(holder -> holder.isIn(ModBiomeTags.HAS_DARK_LEAF_LITTER), 8082228);
    }
}

