/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraftforge.common.ForgeConfigSpec
 *  net.minecraftforge.common.ForgeConfigSpec$Builder
 *  net.minecraftforge.common.ForgeConfigSpec$ConfigValue
 *  net.minecraftforge.fml.config.ModConfig
 */
package org.valkyrienskies.mod.common.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.impl.api_impl.config.VsiConfigModelImpl;
import org.valkyrienskies.core.internal.config.VsiConfigModel;
import org.valkyrienskies.mod.api.config.VSConfigApi;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.config.ConfigType;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.hooks.VSGameEvents;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006RD\u0010\u000b\u001a&\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t`\n8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR*\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001bR\u0014\u0010!\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001eR\u0017\u0010\"\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001bR\u0014\u0010$\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0017\u0010%\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u001b\u00a8\u0006("}, d2={"Lorg/valkyrienskies/mod/common/config/VSConfigUpdater;", "", "Lnet/minecraftforge/fml/config/ModConfig;", "config", "", "update", "(Lnet/minecraftforge/fml/config/ModConfig;)V", "Ljava/util/HashMap;", "", "Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;", "Lkotlin/collections/HashMap;", "forgeConfigValuesMap", "Ljava/util/HashMap;", "getForgeConfigValuesMap", "()Ljava/util/HashMap;", "getForgeConfigValuesMap$annotations", "()V", "Lkotlin/Function2;", "configValueConsumer", "Lkotlin/jvm/functions/Function2;", "Lorg/valkyrienskies/core/internal/config/VsiConfigModel;", "core_server_config", "Lorg/valkyrienskies/core/internal/config/VsiConfigModel;", "Lnet/minecraftforge/common/ForgeConfigSpec;", "CORE_SERVER_SPEC", "Lnet/minecraftforge/common/ForgeConfigSpec;", "getCORE_SERVER_SPEC", "()Lnet/minecraftforge/common/ForgeConfigSpec;", "Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelImpl;", "server_config", "Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelImpl;", "SERVER_SPEC", "getSERVER_SPEC", "common_config", "COMMON_SPEC", "getCOMMON_SPEC", "client_config", "CLIENT_SPEC", "getCLIENT_SPEC", "<init>", "valkyrienskies-120"})
public final class VSConfigUpdater {
    @NotNull
    public static final VSConfigUpdater INSTANCE = new VSConfigUpdater();
    @NotNull
    private static final HashMap<String, ForgeConfigSpec.ConfigValue<?>> forgeConfigValuesMap = new HashMap();
    @NotNull
    private static final Function2<String, ForgeConfigSpec.ConfigValue<?>, Unit> configValueConsumer = VSConfigUpdater::configValueConsumer$lambda$0;
    @NotNull
    private static final VsiConfigModel core_server_config = ValkyrienSkiesMod.getVsCore().getServerConfig();
    @NotNull
    private static final ForgeConfigSpec CORE_SERVER_SPEC;
    @NotNull
    private static final VsiConfigModelImpl server_config;
    @NotNull
    private static final ForgeConfigSpec SERVER_SPEC;
    @NotNull
    private static final VsiConfigModelImpl common_config;
    @NotNull
    private static final ForgeConfigSpec COMMON_SPEC;
    @NotNull
    private static final VsiConfigModelImpl client_config;
    @NotNull
    private static final ForgeConfigSpec CLIENT_SPEC;

    private VSConfigUpdater() {
    }

    @NotNull
    public static final HashMap<String, ForgeConfigSpec.ConfigValue<?>> getForgeConfigValuesMap() {
        return forgeConfigValuesMap;
    }

    @JvmStatic
    public static /* synthetic */ void getForgeConfigValuesMap$annotations() {
    }

    @NotNull
    public final ForgeConfigSpec getCORE_SERVER_SPEC() {
        return CORE_SERVER_SPEC;
    }

    @NotNull
    public final ForgeConfigSpec getSERVER_SPEC() {
        return SERVER_SPEC;
    }

    @NotNull
    public final ForgeConfigSpec getCOMMON_SPEC() {
        return COMMON_SPEC;
    }

    @NotNull
    public final ForgeConfigSpec getCLIENT_SPEC() {
        return CLIENT_SPEC;
    }

    @ApiStatus.Internal
    public final void update(@NotNull ModConfig config) {
        Intrinsics.checkNotNullParameter((Object)config, (String)"config");
        Set updatedEntries = new LinkedHashSet();
        VSConfigApi.update(core_server_config, config, ConfigType.CORE_SERVER, updatedEntries);
        VSConfigApi.update(server_config, config, ConfigType.SERVER, updatedEntries);
        VSConfigApi.update(common_config, config, ConfigType.COMMON, updatedEntries);
        VSConfigApi.update(client_config, config, ConfigType.CLIENT, updatedEntries);
        if (!((Collection)updatedEntries).isEmpty()) {
            VSGameEvents.INSTANCE.getConfigUpdated().emit(updatedEntries);
        }
    }

    private static final Unit configValueConsumer$lambda$0(String name, ForgeConfigSpec.ConfigValue value) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        ((Map)forgeConfigValuesMap).put(name, value);
        return Unit.INSTANCE;
    }

    static {
        ForgeConfigSpec forgeConfigSpec = VSConfigApi.buildForgeConfigSpec(core_server_config.getRoot(), new ForgeConfigSpec.Builder(), configValueConsumer).build();
        Intrinsics.checkNotNullExpressionValue((Object)forgeConfigSpec, (String)"build(...)");
        CORE_SERVER_SPEC = forgeConfigSpec;
        server_config = VSConfigApi.buildVSConfigModel(VSGameConfig.SERVER);
        ForgeConfigSpec forgeConfigSpec2 = VSConfigApi.buildForgeConfigSpec(server_config.getRoot(), new ForgeConfigSpec.Builder(), configValueConsumer).build();
        Intrinsics.checkNotNullExpressionValue((Object)forgeConfigSpec2, (String)"build(...)");
        SERVER_SPEC = forgeConfigSpec2;
        common_config = VSConfigApi.buildVSConfigModel(VSGameConfig.COMMON);
        ForgeConfigSpec forgeConfigSpec3 = VSConfigApi.buildForgeConfigSpec(common_config.getRoot(), new ForgeConfigSpec.Builder(), configValueConsumer).build();
        Intrinsics.checkNotNullExpressionValue((Object)forgeConfigSpec3, (String)"build(...)");
        COMMON_SPEC = forgeConfigSpec3;
        client_config = VSConfigApi.buildVSConfigModel(VSGameConfig.CLIENT);
        ForgeConfigSpec forgeConfigSpec4 = VSConfigApi.buildForgeConfigSpec(client_config.getRoot(), new ForgeConfigSpec.Builder(), configValueConsumer).build();
        Intrinsics.checkNotNullExpressionValue((Object)forgeConfigSpec4, (String)"build(...)");
        CLIENT_SPEC = forgeConfigSpec4;
    }
}

