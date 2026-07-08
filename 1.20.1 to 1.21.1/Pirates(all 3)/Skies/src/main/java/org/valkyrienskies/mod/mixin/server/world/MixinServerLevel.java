/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  it.unimi.dsi.fastutil.longs.Long2LongOpenHashMap
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_1959
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_2680
 *  net.minecraft.class_2791
 *  net.minecraft.class_2818
 *  net.minecraft.class_2826
 *  net.minecraft.class_3193
 *  net.minecraft.class_3215
 *  net.minecraft.class_3218
 *  net.minecraft.class_4076
 *  net.minecraft.class_4153
 *  net.minecraft.class_6880
 *  net.minecraft.server.MinecraftServer
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.server.world;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import it.unimi.dsi.fastutil.longs.Long2LongOpenHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_1959;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_2680;
import net.minecraft.class_2791;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_3193;
import net.minecraft.class_3215;
import net.minecraft.class_3218;
import net.minecraft.class_4076;
import net.minecraft.class_4153;
import net.minecraft.class_6880;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Wing;
import org.valkyrienskies.core.api.ships.WingManager;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.core.internal.world.chunks.VsiTerrainUpdate;
import org.valkyrienskies.mod.common.IShipObjectWorldServerProvider;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.block.WingBlock;
import org.valkyrienskies.mod.common.config.DimensionParametersResolver;
import org.valkyrienskies.mod.common.util.DragInfoReporter;
import org.valkyrienskies.mod.common.util.VSServerLevel;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixin.accessors.server.level.ChunkMapAccessor;
import org.valkyrienskies.mod.mixin.accessors.server.level.DistanceManagerAccessor;
import org.valkyrienskies.mod.mixinducks.world.OfLevel;
import org.valkyrienskies.mod.util.McMathUtilKt;

@Mixin(value={class_3218.class})
public abstract class MixinServerLevel
implements IShipObjectWorldServerProvider,
VSServerLevel {
    @Shadow
    @Final
    private class_3215 field_24624;
    @Unique
    private final Map<class_1923, List<Vector3ic>> vs$knownChunks = new HashMap<class_1923, List<Vector3ic>>();
    @Unique
    private final Long2LongOpenHashMap vs$chunksToUnload = new Long2LongOpenHashMap();
    @Unique
    private static final long VS$CHUNK_UNLOAD_THRESHOLD = 100L;

    @Shadow
    @NotNull
    public abstract MinecraftServer method_8503();

    @Shadow
    public abstract int method_19498(class_4076 var1);

    @Override
    @Nullable
    public VsiServerShipWorld getShipObjectWorld() {
        return ((IShipObjectWorldServerProvider)this.method_8503()).getShipObjectWorld();
    }

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    void onInit(CallbackInfo ci) {
        if (this.getShipObjectWorld() != null) {
            DimensionParametersResolver.Parameters params = DimensionParametersResolver.INSTANCE.getDimensionMap().get(VSGameUtilsKt.getDimensionId((class_1937)((class_3218)this)));
            if (params != null) {
                this.getShipObjectWorld().addDimension(VSGameUtilsKt.getDimensionId((class_1937)((class_3218)this)), VSGameUtilsKt.getYRange((class_1937)((class_3218)this)), params.getGravity(), params.getSeaLevel(), params.getMaxY());
                return;
            }
            this.getShipObjectWorld().addDimension(VSGameUtilsKt.getDimensionId((class_1937)((class_3218)this)), VSGameUtilsKt.getYRange((class_1937)((class_3218)this)), McMathUtilKt.getDEFAULT_WORLD_GRAVITY(), 62.0, 962.0);
        }
    }

    @Inject(method={"getPoiManager"}, at={@At(value="HEAD")})
    void onGetPoiManager(CallbackInfoReturnable<class_4153> cir) {
        class_4153 class_41532 = this.field_24624.method_19493();
        if (class_41532 instanceof OfLevel) {
            OfLevel levelProvider = (OfLevel)class_41532;
            levelProvider.setLevel((class_1937)((class_3218)this));
        }
    }

    @Inject(method={"isCloseToVillage"}, at={@At(value="HEAD")}, cancellable=true)
    void preIsCloseToVillage(class_2338 blockPos, int i2, CallbackInfoReturnable<Boolean> cir) {
        if (i2 <= 6) {
            boolean[] found = new boolean[]{false};
            VSGameUtilsKt.transformToNearbyShipsAndWorld((class_1937)class_3218.class.cast(this), (double)blockPos.method_10263(), (double)blockPos.method_10264(), (double)blockPos.method_10260(), (double)i2 * 100.0, (x, y, z) -> {
                found[0] = found[0] || this.method_19498(class_4076.method_18682((class_2338)class_2338.method_49637((double)x, (double)y, (double)z))) <= i2;
            });
            if (found[0]) {
                cir.setReturnValue((Object)true);
            }
        }
    }

    @WrapOperation(method={"sendParticles(Lnet/minecraft/server/level/ServerPlayer;ZDDDLnet/minecraft/network/protocol/Packet;)Z"}, at={@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;closerToCenterThan(Lnet/minecraft/core/Position;D)Z")})
    private boolean includeShipsInParticleDistanceCheck(class_2338 player, class_2374 particle, double distance, Operation<Boolean> closerToCenterThan) {
        class_3218 self = (class_3218)class_3218.class.cast(this);
        LoadedServerShip ship = VSGameUtilsKt.getLoadedShipManagingPos(self, (int)particle.method_10216() >> 4, (int)particle.method_10215() >> 4);
        if (ship == null) {
            return (Boolean)closerToCenterThan.call(new Object[]{player, particle, distance});
        }
        Vector3d posInWorld = ship.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(particle));
        return posInWorld.distanceSquared(player.method_10263(), player.method_10264(), player.method_10260()) < distance * distance;
    }

    @Unique
    private void vs$loadChunk(@NotNull class_2791 worldChunk, List<VsiTerrainUpdate> voxelShapeUpdates) {
        this.vs$chunksToUnload.remove(worldChunk.method_12004().method_8324());
        if (!this.vs$knownChunks.containsKey(worldChunk.method_12004())) {
            ArrayList<Vector3i> voxelChunkPositions = new ArrayList<Vector3i>();
            int chunkX = worldChunk.method_12004().field_9181;
            int chunkZ = worldChunk.method_12004().field_9180;
            class_2826[] chunkSections = worldChunk.method_12006();
            for (int sectionY = 0; sectionY < chunkSections.length; ++sectionY) {
                class_2826 chunkSection = chunkSections[sectionY];
                Vector3i chunkPos = new Vector3i(chunkX, worldChunk.method_31604(sectionY), chunkZ);
                voxelChunkPositions.add(chunkPos);
                if (chunkSection != null && !chunkSection.method_38292()) {
                    VsiTerrainUpdate voxelShapeUpdate = VSGameUtilsKt.toDenseVoxelUpdate(chunkSection, chunkPos);
                    voxelShapeUpdates.add(voxelShapeUpdate);
                    class_3218 thisAsLevel = (class_3218)class_3218.class.cast(this);
                    LoadedServerShip ship = VSGameUtilsKt.getLoadedShipManagingPos(thisAsLevel, chunkX, chunkZ);
                    if (ship == null) continue;
                    WingManager shipAsWingManager = ship.getWingManager();
                    class_2338.class_2339 mutableBlockPos = new class_2338.class_2339();
                    for (int x = 0; x < 16; ++x) {
                        for (int y = 0; y < 16; ++y) {
                            for (int z = 0; z < 16; ++z) {
                                class_2680 blockState = chunkSection.method_12254(x, y, z);
                                int posX = (chunkX << 4) + x;
                                int posY = worldChunk.method_31607() + (sectionY << 4) + y;
                                int posZ = (chunkZ << 4) + z;
                                if (!(blockState.method_26204() instanceof WingBlock)) continue;
                                mutableBlockPos.method_10103(posX, posY, posZ);
                                Wing wing = ((WingBlock)blockState.method_26204()).getWing((class_1937)thisAsLevel, (class_2338)mutableBlockPos, blockState);
                                if (wing == null) continue;
                                shipAsWingManager.setWing(shipAsWingManager.getFirstWingGroupId(), posX, posY, posZ, wing);
                            }
                        }
                    }
                    continue;
                }
                VsiTerrainUpdate emptyVoxelShapeUpdate = ValkyrienSkiesMod.getVsCore().newEmptyVoxelShapeUpdate(chunkPos.x(), chunkPos.y(), chunkPos.z(), true);
                voxelShapeUpdates.add(emptyVoxelShapeUpdate);
            }
            this.vs$knownChunks.put(worldChunk.method_12004(), voxelChunkPositions);
        }
    }

    @Inject(method={"tick"}, at={@At(value="TAIL")})
    private void postTick(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        class_3218 self = (class_3218)class_3218.class.cast(this);
        VsiServerShipWorld shipObjectWorld = VSGameUtilsKt.getShipObjectWorld(self);
        ChunkMapAccessor chunkMapAccessor = (ChunkMapAccessor)this.field_24624.field_17254;
        ArrayList<VsiTerrainUpdate> voxelShapeUpdates = new ArrayList<VsiTerrainUpdate>();
        DistanceManagerAccessor distanceManagerAccessor = (DistanceManagerAccessor)this.field_24624.field_17254.method_17263();
        for (class_3193 chunkHolder : chunkMapAccessor.callGetChunks()) {
            Optional worldChunkOptional;
            if (this.vs$knownChunks.containsKey(chunkHolder.method_13994()) || !distanceManagerAccessor.getTickets().containsKey(chunkHolder.method_13994().method_8324()) || !(worldChunkOptional = chunkHolder.method_16145().getNow(class_3193.field_16427).left()).isPresent()) continue;
            class_2818 worldChunk = (class_2818)worldChunkOptional.get();
            this.vs$loadChunk((class_2791)worldChunk, voxelShapeUpdates);
        }
        Iterator<Map.Entry<class_1923, List<Vector3ic>>> knownChunkPosIterator = this.vs$knownChunks.entrySet().iterator();
        while (knownChunkPosIterator.hasNext()) {
            Map.Entry<class_1923, List<Vector3ic>> knownChunkPosEntry = knownChunkPosIterator.next();
            long chunkPos = knownChunkPosEntry.getKey().method_8324();
            if (distanceManagerAccessor.getTickets().containsKey(chunkPos) && chunkMapAccessor.callGetVisibleChunkIfPresent(chunkPos) != null) continue;
            long ticksWaitingToUnload = this.vs$chunksToUnload.getOrDefault(chunkPos, 0L);
            if (ticksWaitingToUnload > 100L) {
                for (Vector3ic unloadedChunk : knownChunkPosEntry.getValue()) {
                    VsiTerrainUpdate deleteVoxelShapeUpdate = ValkyrienSkiesMod.getVsCore().newDeleteTerrainUpdate(unloadedChunk.x(), unloadedChunk.y(), unloadedChunk.z());
                    voxelShapeUpdates.add(deleteVoxelShapeUpdate);
                }
                knownChunkPosIterator.remove();
                this.vs$chunksToUnload.remove(chunkPos);
                continue;
            }
            this.vs$chunksToUnload.put(chunkPos, ticksWaitingToUnload + 1L);
        }
        shipObjectWorld.addTerrainUpdates(VSGameUtilsKt.getDimensionId((class_1937)self), voxelShapeUpdates);
        if (ValkyrienSkiesMod.getVsCore().getHooks().getEnableSplitting()) {
            ValkyrienSkiesMod.splitHandler.tick((class_3218)class_3218.class.cast(this));
        }
        DragInfoReporter.INSTANCE.tick((class_3218)this);
    }

    @Override
    public void removeChunk(int chunkX, int chunkZ) {
        class_1923 chunkPos = new class_1923(chunkX, chunkZ);
        this.vs$knownChunks.remove(chunkPos);
    }

    @Redirect(method={"tickChunk"}, at=@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerLevel;getBiome(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/core/Holder;"))
    private class_6880<class_1959> adjustForWorldPosition(class_3218 instance, class_2338 blockPos) {
        class_3218 level = (class_3218)class_3218.class.cast(this);
        ServerShip ship = VSGameUtilsKt.getShipManagingPos(level, blockPos);
        if (ship != null) {
            Vector3d vPosWorld = ship.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOMLD((class_2382)blockPos));
            class_2338 blockPosWorld = class_2338.method_49637((double)vPosWorld.x, (double)vPosWorld.y, (double)vPosWorld.z);
            return level.method_23753(blockPosWorld);
        }
        return level.method_23753(blockPos);
    }
}

