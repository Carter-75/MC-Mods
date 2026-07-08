/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.logging.LogUtils
 *  kotlin.Metadata
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.loader.api.FabricLoader
 */
package org.valkyrienskies.mod.platform;

import com.mojang.logging.LogUtils;
import kotlin.Metadata;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.internal.VsiCore;
import org.valkyrienskies.core.internal.VsiCoreFactory;
import org.valkyrienskies.mod.common.VSCoreProvider;
import org.valkyrienskies.mod.fabric.common.FabricHooksImpl;
import org.valkyrienskies.mod.fabric.common.VSFabricNetworking;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2={"Lorg/valkyrienskies/mod/platform/VSCoreProviderImpl;", "Lorg/valkyrienskies/mod/common/VSCoreProvider;", "Lorg/valkyrienskies/core/internal/VsiCore;", "newVSCore", "()Lorg/valkyrienskies/core/internal/VsiCore;", "<init>", "()V", "valkyrienskies-120"})
public final class VSCoreProviderImpl
implements VSCoreProvider {
    @Override
    @NotNull
    public VsiCore newVSCore() {
        boolean isClient = FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
        VSFabricNetworking networking = new VSFabricNetworking(isClient);
        FabricHooksImpl hooks = new FabricHooksImpl(networking);
        VsiCore vsCore = isClient ? (VsiCore)VsiCoreFactory.Companion.getInstance().newVsCoreClient(hooks) : (VsiCore)VsiCoreFactory.Companion.getInstance().newVsCoreServer(hooks);
        networking.register(vsCore.getHooks());
        LogUtils.getLogger().info("Initialized VSCore on Fabric!");
        return vsCore;
    }
}

