/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_3037
 *  net.minecraft.class_4651
 *  net.minecraft.class_4662
 *  net.minecraft.class_6017
 */
package backported.updates.content.common.level.features;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_3037;
import net.minecraft.class_4651;
import net.minecraft.class_4662;
import net.minecraft.class_6017;

public class FallenTreeConfiguration
implements class_3037 {
    public static final Codec<FallenTreeConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group((App)class_4651.field_24937.fieldOf("trunk_provider").forGetter(config -> config.trunkProvider), (App)class_6017.method_35004((int)0, (int)16).fieldOf("log_length").forGetter(config -> config.logLength), (App)class_4662.field_24962.listOf().fieldOf("stump_decorators").forGetter(config -> config.stumpDecorators), (App)class_4662.field_24962.listOf().fieldOf("log_decorators").forGetter(config -> config.logDecorators)).apply((Applicative)instance, FallenTreeConfiguration::new));
    public final class_4651 trunkProvider;
    public final class_6017 logLength;
    public final List<class_4662> stumpDecorators;
    public final List<class_4662> logDecorators;

    protected FallenTreeConfiguration(class_4651 trunkProvider, class_6017 logLength, List<class_4662> stumpDecorators, List<class_4662> logDecorators) {
        this.trunkProvider = trunkProvider;
        this.logLength = logLength;
        this.stumpDecorators = stumpDecorators;
        this.logDecorators = logDecorators;
    }

    public static class FallenTreeConfigurationBuilder {
        private final class_4651 trunkProvider;
        private final class_6017 logLength;
        private List<class_4662> stumpDecorators = new ArrayList<class_4662>();
        private List<class_4662> logDecorators = new ArrayList<class_4662>();

        public FallenTreeConfigurationBuilder(class_4651 trunkProvider, class_6017 logLength) {
            this.trunkProvider = trunkProvider;
            this.logLength = logLength;
        }

        public FallenTreeConfigurationBuilder stumpDecorators(List<class_4662> decorators) {
            this.stumpDecorators = decorators;
            return this;
        }

        public FallenTreeConfigurationBuilder logDecorators(List<class_4662> decorators) {
            this.logDecorators = decorators;
            return this;
        }

        public FallenTreeConfiguration build() {
            return new FallenTreeConfiguration(this.trunkProvider, this.logLength, this.stumpDecorators, this.logDecorators);
        }
    }
}

