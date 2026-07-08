/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Unit
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_238
 *  net.minecraft.class_2424
 *  net.minecraft.class_243
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 *  net.minecraft.class_2784
 *  net.minecraft.class_2818
 *  net.minecraft.class_2874
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_3218
 *  net.minecraft.class_3324
 *  net.minecraft.class_4048
 *  net.minecraft.class_5321
 *  net.minecraft.class_5454
 *  net.minecraft.class_5459
 *  net.minecraft.class_5459$class_5460
 *  net.minecraft.server.MinecraftServer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import kotlin.Unit;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2424;
import net.minecraft.class_243;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_2784;
import net.minecraft.class_2818;
import net.minecraft.class_2874;
import net.minecraft.class_2902;
import net.minecraft.class_3218;
import net.minecraft.class_3324;
import net.minecraft.class_4048;
import net.minecraft.class_5321;
import net.minecraft.class_5454;
import net.minecraft.class_5459;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.internal.ShipTeleportData;
import org.valkyrienskies.core.internal.VsiGameServer;
import org.valkyrienskies.core.internal.ships.VsiLoadedServerShip;
import org.valkyrienskies.core.internal.world.VsiPipeline;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.mod.common.IShipObjectWorldServerProvider;
import org.valkyrienskies.mod.common.ShipSavedData;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.config.DimensionParametersResolver;
import org.valkyrienskies.mod.common.config.MassDatapackResolver;
import org.valkyrienskies.mod.common.hooks.VSGameEvents;
import org.valkyrienskies.mod.common.util.EntityDragger;
import org.valkyrienskies.mod.common.util.ShipSettingsKt;
import org.valkyrienskies.mod.common.util.VSLevelChunk;
import org.valkyrienskies.mod.common.util.VSServerLevel;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.common.world.ChunkManagement;
import org.valkyrienskies.mod.compat.LoadedMods;
import org.valkyrienskies.mod.compat.Weather2Compat;
import org.valkyrienskies.mod.util.KrunchSupport;
import org.valkyrienskies.mod.util.McMathUtilKt;

@Mixin(value={MinecraftServer.class})
public abstract class MixinMinecraftServer
implements IShipObjectWorldServerProvider,
VsiGameServer {
    @Shadow
    private class_3324 field_4550;
    @Unique
    private VsiServerShipWorld shipWorld;
    @Unique
    private VsiPipeline vsPipeline;
    @Unique
    private Set<String> loadedLevels = new HashSet<String>();
    @Unique
    private final Map<String, class_3218> dimensionToLevelMap = new HashMap<String, class_3218>();

    @Shadow
    public abstract class_3218 method_30002();

    @Shadow
    public abstract Iterable<class_3218> method_3738();

    @Inject(at={@At(value="INVOKE", target="Lnet/minecraft/server/MinecraftServer;initServer()Z")}, method={"runServer"})
    private void beforeInitServer(CallbackInfo info) {
        ValkyrienSkiesMod.setCurrentServer((MinecraftServer)MinecraftServer.class.cast(this));
    }

    @Inject(at={@At(value="TAIL")}, method={"stopServer"})
    private void afterStopServer(CallbackInfo ci) {
        ValkyrienSkiesMod.setCurrentServer(null);
    }

    @Override
    @Nullable
    public VsiServerShipWorld getShipObjectWorld() {
        return this.shipWorld;
    }

    @Override
    @Nullable
    public VsiPipeline getVsPipeline() {
        return this.vsPipeline;
    }

    @Inject(method={"createLevels"}, at={@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerLevel;getDataStorage()Lnet/minecraft/world/level/storage/DimensionDataStorage;")})
    private void postCreateLevels(CallbackInfo ci) {
        if (!MassDatapackResolver.INSTANCE.getRegisteredBlocks()) {
            ArrayList blockStateList = new ArrayList(class_2248.field_10651.method_10204());
            class_2248.field_10651.forEach(blockStateList::add);
            MassDatapackResolver.INSTANCE.registerAllBlockStates(blockStateList);
            ValkyrienSkiesMod.getVsCore().registerBlockStates(MassDatapackResolver.INSTANCE.getBlockStateData());
        }
        ShipSavedData shipSavedData = (ShipSavedData)this.method_30002().method_17983().method_17924(ShipSavedData::load, ShipSavedData.Companion::createEmpty, "vs_ship_data");
        Throwable ex = shipSavedData.getLoadingException();
        if (ex != null) {
            System.err.println("VALKYRIEN SKIES ERROR WHILE LOADING SHIP DATA");
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        this.vsPipeline = shipSavedData.getPipeline();
        KrunchSupport.INSTANCE.setKrunchSupported(!this.vsPipeline.isUsingDummyPhysics());
        this.shipWorld = this.vsPipeline.getShipWorld();
        this.shipWorld.setGameServer(this);
        VSGameEvents.INSTANCE.getRegistriesCompleted().emit(Unit.INSTANCE);
        DimensionParametersResolver.Parameters params = DimensionParametersResolver.INSTANCE.getDimensionMap().get(VSGameUtilsKt.getDimensionId((class_1937)this.method_30002()));
        if (params != null) {
            this.getShipObjectWorld().addDimension(VSGameUtilsKt.getDimensionId((class_1937)this.method_30002()), VSGameUtilsKt.getYRange((class_1937)this.method_30002()), params.getGravity(), params.getSeaLevel(), params.getMaxY());
        } else {
            this.getShipObjectWorld().addDimension(VSGameUtilsKt.getDimensionId((class_1937)this.method_30002()), VSGameUtilsKt.getYRange((class_1937)this.method_30002()), McMathUtilKt.getDEFAULT_WORLD_GRAVITY(), 63.0, 962.0);
        }
    }

    @Inject(method={"tickServer"}, at={@At(value="HEAD")})
    private void preTick(CallbackInfo ci) {
        Set vsPlayers = this.field_4550.method_14571().stream().map(VSGameUtilsKt::getPlayerWrapper).collect(Collectors.toSet());
        this.shipWorld.setPlayers(vsPlayers);
        HashMap<String, class_3218> newLoadedLevels = new HashMap<String, class_3218>();
        for (class_3218 level : this.method_3738()) {
            String dimensionId = VSGameUtilsKt.getDimensionId((class_1937)level);
            newLoadedLevels.put(dimensionId, level);
            this.dimensionToLevelMap.put(dimensionId, level);
        }
        for (String oldLoadedLevelId : this.loadedLevels) {
            if (newLoadedLevels.containsKey(oldLoadedLevelId)) continue;
            this.shipWorld.removeDimension(oldLoadedLevelId);
            this.dimensionToLevelMap.remove(oldLoadedLevelId);
        }
        this.loadedLevels = newLoadedLevels.keySet();
        this.vsPipeline.preTickGame();
    }

    @Inject(method={"tickChildren"}, at={@At(value="INVOKE", target="Lnet/minecraft/server/network/ServerConnectionListener;tick()V", shift=At.Shift.AFTER)})
    private void preConnectionTick(CallbackInfo ci) {
        ChunkManagement.tickChunkLoading(this.shipWorld, (MinecraftServer)MinecraftServer.class.cast(this));
    }

    @Shadow
    public abstract class_3218 method_3847(class_5321<class_1937> var1);

    @Shadow
    public abstract boolean method_3839();

    @Inject(method={"tickServer"}, at={@At(value="TAIL")})
    private void postTick(CallbackInfo ci) {
        this.vsPipeline.postTickGame();
        for (class_3218 level : this.method_3738()) {
            EntityDragger.INSTANCE.dragEntitiesWithShips(level.method_27909(), false);
            if (!LoadedMods.getWeather2()) continue;
            Weather2Compat.INSTANCE.tick(level);
        }
    }

    @Unique
    private void handleShipPortals() {
        ArrayList<LoadedServerShip> loadedShipsCopy = new ArrayList<LoadedServerShip>(this.shipWorld.getLoadedShips());
        for (LoadedServerShip shipObject : loadedShipsCopy) {
            class_2338 blockPos2;
            if (!ShipSettingsKt.getSettings(shipObject).getChangeDimensionOnTouchPortals()) continue;
            class_3218 level = this.dimensionToLevelMap.get(shipObject.getChunkClaimDimension());
            Vector3dc shipPos = shipObject.getTransform().getPositionInWorld();
            double bbRadius = 0.5;
            class_2338 blockPos = class_2338.method_49637((double)(shipPos.x() - 0.5), (double)(shipPos.y() - 0.5), (double)(shipPos.z() - 0.5));
            if (!level.method_22343(blockPos, blockPos2 = class_2338.method_49637((double)(shipPos.x() + 0.5), (double)(shipPos.y() + 0.5), (double)(shipPos.z() + 0.5)))) continue;
            ((VsiLoadedServerShip)shipObject).decayPortalCoolDown();
            class_2338.class_2339 mutableBlockPos = new class_2338.class_2339();
            for (int i2 = blockPos.method_10263(); i2 <= blockPos2.method_10263(); ++i2) {
                for (int j2 = blockPos.method_10264(); j2 <= blockPos2.method_10264(); ++j2) {
                    for (int k2 = blockPos.method_10260(); k2 <= blockPos2.method_10260(); ++k2) {
                        class_3218 destLevel;
                        mutableBlockPos.method_10103(i2, j2, k2);
                        class_2680 blockState = level.method_8320((class_2338)mutableBlockPos);
                        if (blockState.method_26204() == class_2246.field_10316) {
                            if (!((VsiLoadedServerShip)shipObject).isOnPortalCoolDown() && (destLevel = this.method_3847((class_5321<class_1937>)(level.method_27983() == class_1937.field_25180 ? class_1937.field_25179 : class_1937.field_25180))) != null && this.method_3839()) {
                                level.method_16107().method_15396("portal");
                                this.shipChangeDimension(level, destLevel, (class_2338)mutableBlockPos, shipObject);
                                level.method_16107().method_15407();
                            }
                            ((VsiLoadedServerShip)shipObject).handleInsidePortal();
                            continue;
                        }
                        if (blockState.method_26204() != class_2246.field_10027) continue;
                        destLevel = level.method_8503().method_3847(level.method_27983() == class_1937.field_25181 ? class_1937.field_25179 : class_1937.field_25181);
                        if (destLevel == null) {
                            return;
                        }
                        this.shipChangeDimension(level, destLevel, null, shipObject);
                    }
                }
            }
        }
    }

    @Unique
    private void shipChangeDimension(@NotNull class_3218 srcLevel, @NotNull class_3218 destLevel, @Nullable class_2338 portalEntrancePos, @NotNull LoadedServerShip shipObject) {
        class_5454 portalInfo = this.findDimensionEntryPoint(srcLevel, destLevel, portalEntrancePos, shipObject.getTransform().getPositionInWorld());
        if (portalInfo == null) {
            return;
        }
        ShipTeleportData shipTeleportData = ValkyrienSkiesMod.getVsCore().newShipTeleportData(VectorConversionsMCKt.toJOML(portalInfo.field_25879), shipObject.getTransform().getShipToWorldRotation(), new Vector3d(), new Vector3d(), VSGameUtilsKt.getDimensionId((class_1937)destLevel), null, null);
        this.shipWorld.teleportShip(shipObject, shipTeleportData);
    }

    @Unique
    @Nullable
    private class_5454 findDimensionEntryPoint(@NotNull class_3218 srcLevel, @NotNull class_3218 destLevel, @Nullable class_2338 portalEntrancePos, @NotNull Vector3dc shipPos) {
        boolean bl3;
        boolean bl = srcLevel.method_27983() == class_1937.field_25181 && destLevel.method_27983() == class_1937.field_25179;
        boolean bl2 = destLevel.method_27983() == class_1937.field_25181;
        class_243 deltaMovement = class_243.field_1353;
        class_4048 entityDimensions = new class_4048(1.0f, 1.0f, true);
        if (bl || bl2) {
            class_2338 blockPos = bl2 ? class_3218.field_25144 : destLevel.method_8598(class_2902.class_2903.field_13203, destLevel.method_43126());
            return new class_5454(new class_243((double)blockPos.method_10263() + 0.5, (double)blockPos.method_10264(), (double)blockPos.method_10260() + 0.5), deltaMovement, 0.0f, 0.0f);
        }
        boolean bl4 = bl3 = destLevel.method_27983() == class_1937.field_25180;
        if (srcLevel.method_27983() != class_1937.field_25180 && !bl3) {
            return null;
        }
        class_2784 worldBorder = destLevel.method_8621();
        double d2 = class_2874.method_31109((class_2874)srcLevel.method_8597(), (class_2874)destLevel.method_8597());
        class_2338 blockPos2 = worldBorder.method_39538(shipPos.x() * d2, shipPos.y(), shipPos.z() * d2);
        return this.getExitPortal(destLevel, blockPos2, bl3, worldBorder).map(foundRectangle -> {
            class_243 vec3;
            class_2350.class_2351 axis;
            if (portalEntrancePos != null) {
                class_2680 blockState = srcLevel.method_8320(portalEntrancePos);
                if (blockState.method_28498((class_2769)class_2741.field_12529)) {
                    axis = (class_2350.class_2351)blockState.method_11654((class_2769)class_2741.field_12529);
                    class_5459.class_5460 foundRectangle2 = class_5459.method_30574((class_2338)portalEntrancePos, (class_2350.class_2351)axis, (int)21, (class_2350.class_2351)class_2350.class_2351.field_11052, (int)21, blockPos -> srcLevel.method_8320(blockPos) == blockState);
                    vec3 = this.getRelativePortalPosition(axis, foundRectangle2, entityDimensions, VectorConversionsMCKt.toMinecraft(shipPos));
                } else {
                    axis = class_2350.class_2351.field_11048;
                    vec3 = new class_243(0.5, 0.0, 0.0);
                }
            } else {
                axis = class_2350.class_2351.field_11048;
                vec3 = new class_243(0.5, 0.0, 0.0);
            }
            return MixinMinecraftServer.valkyrienskies$createPortalInfo(destLevel, foundRectangle, axis, vec3, entityDimensions, deltaMovement, 0.0f, 0.0f);
        }).orElse(null);
    }

    @Unique
    private static class_5454 valkyrienskies$createPortalInfo(class_3218 serverLevel, class_5459.class_5460 foundRectangle, class_2350.class_2351 axis, class_243 vec3, class_4048 entityDimensions, class_243 vec32, float f2, float g2) {
        class_2338 blockPos = foundRectangle.field_25936;
        class_2680 blockState = serverLevel.method_8320(blockPos);
        class_2350.class_2351 axis2 = blockState.method_28500((class_2769)class_2741.field_12529).orElse(class_2350.class_2351.field_11048);
        double d2 = foundRectangle.field_25937;
        double e2 = foundRectangle.field_25938;
        int i2 = axis == axis2 ? 0 : 90;
        class_243 vec33 = axis == axis2 ? vec32 : new class_243(vec32.field_1350, vec32.field_1351, -vec32.field_1352);
        double h2 = (double)entityDimensions.field_18067 / 2.0 + (d2 - (double)entityDimensions.field_18067) * vec3.method_10216();
        double j2 = (e2 - (double)entityDimensions.field_18068) * vec3.method_10214();
        double k2 = 0.5 + vec3.method_10215();
        boolean bl = axis2 == class_2350.class_2351.field_11048;
        class_243 vec34 = new class_243((double)blockPos.method_10263() + (bl ? h2 : k2), (double)blockPos.method_10264() + j2, (double)blockPos.method_10260() + (bl ? k2 : h2));
        class_243 vec35 = MixinMinecraftServer.valkyrienskies$findCollisionFreePosition(vec34, serverLevel, entityDimensions);
        return new class_5454(vec35, vec33, f2 + (float)i2, g2);
    }

    @Unique
    private static class_243 valkyrienskies$findCollisionFreePosition(class_243 vec3, class_3218 serverLevel, class_4048 entityDimensions) {
        if (!(entityDimensions.field_18067 > 4.0f) && !(entityDimensions.field_18068 > 4.0f)) {
            double d2 = (double)entityDimensions.field_18068 / 2.0;
            class_243 vec32 = vec3.method_1031(0.0, d2, 0.0);
            class_265 voxelShape = class_259.method_1078((class_238)class_238.method_30048((class_243)vec32, (double)entityDimensions.field_18067, (double)0.0, (double)entityDimensions.field_18067).method_1012(0.0, 1.0, 0.0).method_1014(1.0E-6));
            Optional optional = serverLevel.method_33594(null, voxelShape, vec32, (double)entityDimensions.field_18067, (double)entityDimensions.field_18068, (double)entityDimensions.field_18067);
            Optional<class_243> optional2 = optional.map(vec3x -> vec3x.method_1023(0.0, d2, 0.0));
            return optional2.orElse(vec3);
        }
        return vec3;
    }

    @Unique
    private class_243 getRelativePortalPosition(class_2350.class_2351 axis, class_5459.class_5460 foundRectangle, class_4048 entityDimensions, class_243 position) {
        return class_2424.method_30494((class_5459.class_5460)foundRectangle, (class_2350.class_2351)axis, (class_243)position, (class_4048)entityDimensions);
    }

    @Unique
    private Optional<class_5459.class_5460> getExitPortal(class_3218 serverLevel, class_2338 blockPos, boolean bl, class_2784 worldBorder) {
        return serverLevel.method_14173().method_30483(blockPos, bl, worldBorder);
    }

    @Inject(method={"stopServer"}, at={@At(value="HEAD")})
    private void preStopServer(CallbackInfo ci) {
        if (this.vsPipeline != null) {
            this.vsPipeline.setDeleteResources(true);
            this.vsPipeline.setArePhysicsRunning(true);
        }
    }

    @Inject(method={"stopServer"}, at={@At(value="RETURN")})
    private void postStopServer(CallbackInfo ci) {
        this.dimensionToLevelMap.clear();
        this.shipWorld.setGameServer(null);
        this.shipWorld = null;
    }

    @NotNull
    private class_3218 getLevelFromDimensionId(@NotNull String dimensionId) {
        return this.dimensionToLevelMap.get(dimensionId);
    }

    @Override
    public void moveTerrainAcrossDimensions(@NotNull IShipActiveChunksSet shipChunks, @NotNull String srcDimension, @NotNull String destDimension) {
        class_3218 srcLevel = this.getLevelFromDimensionId(srcDimension);
        class_3218 destLevel = this.getLevelFromDimensionId(destDimension);
        shipChunks.forEach((x, z) -> {
            class_2818 srcChunk = srcLevel.method_8497(x, z);
            ((VSServerLevel)destLevel).removeChunk(x, z);
            class_2818 destChunk = destLevel.method_8497(x, z);
            ((VSLevelChunk)destChunk).copyChunkFromOtherDimension((VSLevelChunk)srcChunk);
        });
        shipChunks.forEach((x, z) -> {
            class_2818 srcChunk = srcLevel.method_8497(x, z);
            ((VSLevelChunk)srcChunk).clearChunk();
            class_1923 chunkPos = srcChunk.method_12004();
            srcLevel.method_14178().method_12124(chunkPos, false);
            ((VSServerLevel)srcLevel).removeChunk(x, z);
        });
    }
}

