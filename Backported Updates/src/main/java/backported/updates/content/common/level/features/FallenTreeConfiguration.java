/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.world.gen.feature.FeatureConfig
 *  net.minecraft.world.gen.stateprovider.BlockStateProvider
 *  net.minecraft.world.gen.treedecorator.TreeDecorator
 *  net.minecraft.util.math.intprovider.IntProvider
 */
package backported.updates.content.common.level.features;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.util.math.intprovider.IntProvider;

public class FallenTreeConfiguration
implements FeatureConfig {
    public static final Codec<FallenTreeConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(BlockStateProvider.TYPE_CODEC.fieldOf("trunk_provider").forGetter(config -> config.trunkProvider), IntProvider.createValidatingCodec((int)0, (int)16).fieldOf("log_length").forGetter(config -> config.logLength), TreeDecorator.TYPE_CODEC.listOf().fieldOf("stump_decorators").forGetter(config -> config.stumpDecorators), TreeDecorator.TYPE_CODEC.listOf().fieldOf("log_decorators").forGetter(config -> config.logDecorators)).apply(instance, FallenTreeConfiguration::new));
    public final BlockStateProvider trunkProvider;
    public final IntProvider logLength;
    public final List<TreeDecorator> stumpDecorators;
    public final List<TreeDecorator> logDecorators;

    protected FallenTreeConfiguration(BlockStateProvider trunkProvider, IntProvider logLength, List<TreeDecorator> stumpDecorators, List<TreeDecorator> logDecorators) {
        this.trunkProvider = trunkProvider;
        this.logLength = logLength;
        this.stumpDecorators = stumpDecorators;
        this.logDecorators = logDecorators;
    }

    public static class FallenTreeConfigurationBuilder {
        private final BlockStateProvider trunkProvider;
        private final IntProvider logLength;
        private List<TreeDecorator> stumpDecorators = new ArrayList<TreeDecorator>();
        private List<TreeDecorator> logDecorators = new ArrayList<TreeDecorator>();

        public FallenTreeConfigurationBuilder(BlockStateProvider trunkProvider, IntProvider logLength) {
            this.trunkProvider = trunkProvider;
            this.logLength = logLength;
        }

        public FallenTreeConfigurationBuilder stumpDecorators(List<TreeDecorator> decorators) {
            this.stumpDecorators = decorators;
            return this;
        }

        public FallenTreeConfigurationBuilder logDecorators(List<TreeDecorator> decorators) {
            this.logDecorators = decorators;
            return this;
        }

        public FallenTreeConfiguration build() {
            return new FallenTreeConfiguration(this.trunkProvider, this.logLength, this.stumpDecorators, this.logDecorators);
        }
    }
}

