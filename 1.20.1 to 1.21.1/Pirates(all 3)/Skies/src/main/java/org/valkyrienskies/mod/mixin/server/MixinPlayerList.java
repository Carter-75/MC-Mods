/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_124
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2535
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3324
 *  net.minecraft.class_5321
 *  net.minecraft.server.MinecraftServer
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.server;

import java.util.List;
import net.minecraft.class_124;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2535;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3324;
import net.minecraft.class_5321;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.entity.handling.VSEntityManager;
import org.valkyrienskies.mod.common.util.MinecraftPlayer;
import org.valkyrienskies.mod.util.KrunchSupport;

@Mixin(value={class_3324.class})
public abstract class MixinPlayerList {
    @Shadow
    @Final
    private List<class_3222> field_14351;
    @Shadow
    @Final
    private MinecraftServer field_14360;

    @Shadow
    public abstract void method_14605(@Nullable class_1657 var1, double var2, double var4, double var6, double var8, class_5321<class_1937> var10, class_2596<?> var11);

    @Inject(method={"placeNewPlayer"}, at={@At(value="TAIL")})
    private void afterPlayerJoin(class_2535 netManager, class_3222 player, CallbackInfo ci) {
        MinecraftPlayer wrapped = VSGameUtilsKt.getPlayerWrapper((class_1657)player);
        ValkyrienSkiesMod.getVsCore().getHooks().afterClientJoinServer(wrapped);
        if (!KrunchSupport.INSTANCE.isKrunchSupported()) {
            player.method_43496((class_2561)class_2561.method_43470((String)"VS2 physics are disabled on this server, because Krunch is not supported on this server! Current supported platforms are: Windows x86-64, Linux x86-64, Linux aarch64, Macos x86-64, Macos arm64").method_27695(new class_124[]{class_124.field_1061, class_124.field_1067}));
        }
        VSEntityManager.INSTANCE.syncHandlers(wrapped);
    }

    @Inject(method={"broadcast"}, at={@At(value="HEAD")}, cancellable=true)
    private void sendToAround(@Nullable class_1657 player, double x, double y, double z, double distance, class_5321<class_1937> worldKey, class_2596<?> packet, CallbackInfo ci) {
        class_3218 world = this.field_14360.method_3847(worldKey);
        if (world == null) {
            return;
        }
        if (player != null && VSGameUtilsKt.isChunkInShipyard((class_1937)world, (int)player.method_19538().field_1352 >> 4, (int)player.method_19538().field_1351 >> 4)) {
            return;
        }
        LoadedShip ship = VSGameUtilsKt.getLoadedShipManagingPos((class_1937)world, (int)x >> 4, (int)z >> 4);
        if (ship == null) {
            return;
        }
        Vector3d p = VSGameUtilsKt.toWorldCoordinates(ship, x, y, z);
        this.method_14605(player, p.x, p.y, p.z, distance, worldKey, packet);
        ci.cancel();
    }
}

