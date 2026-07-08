/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.collection.LongObjectHashMap
 *  io.netty.util.collection.LongObjectMap
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2487
 *  net.minecraft.class_2540
 *  net.minecraft.class_2806
 *  net.minecraft.class_2818
 *  net.minecraft.class_310
 *  net.minecraft.class_631
 *  net.minecraft.class_638
 *  net.minecraft.class_6603$class_6605
 *  net.minecraft.class_761
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.client.world;

import io.netty.util.collection.LongObjectHashMap;
import io.netty.util.collection.LongObjectMap;
import java.util.function.Consumer;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2487;
import net.minecraft.class_2540;
import net.minecraft.class_2806;
import net.minecraft.class_2818;
import net.minecraft.class_310;
import net.minecraft.class_631;
import net.minecraft.class_638;
import net.minecraft.class_6603;
import net.minecraft.class_761;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.compat.SodiumCompat;
import org.valkyrienskies.mod.compat.VSRenderer;
import org.valkyrienskies.mod.mixin.ValkyrienCommonMixinConfigPlugin;
import org.valkyrienskies.mod.mixin.accessors.client.multiplayer.ClientLevelAccessor;
import org.valkyrienskies.mod.mixin.accessors.client.render.LevelRendererAccessor;
import org.valkyrienskies.mod.mixinducks.client.render.IVSViewAreaMethods;
import org.valkyrienskies.mod.mixinducks.client.world.ClientChunkCacheDuck;
import org.valkyrienskies.mod.mixinducks.mod_compat.vanilla_renderer.LevelRendererDuck;

@Mixin(value={class_631.class})
public abstract class MixinClientChunkCache
implements ClientChunkCacheDuck {
    @Shadow
    @Final
    public class_638 field_16525;
    @Unique
    private final LongObjectMap<class_2818> vs$shipChunks = new LongObjectHashMap();

    @Override
    public LongObjectMap<class_2818> vs$getShipChunks() {
        return this.vs$shipChunks;
    }

    @Inject(method={"replaceWithPacketData"}, at={@At(value="HEAD")}, cancellable=true)
    private void preLoadChunkFromPacket(int x, int z, class_2540 buf, class_2487 tag, Consumer<class_6603.class_6605> consumer, CallbackInfoReturnable<class_2818> cir) {
        if (VSGameUtilsKt.isChunkInShipyard((class_1937)this.field_16525, x, z)) {
            class_2818 worldChunk;
            class_1923 pos;
            long chunkPosLong;
            class_2818 oldChunk;
            class_761 class_7612 = class_310.method_1551().field_1769;
            if (class_7612 instanceof LevelRendererDuck) {
                LevelRendererDuck levelRenderer = (LevelRendererDuck)class_7612;
                levelRenderer.vs$setNeedsFrustumUpdate();
            }
            if ((oldChunk = (class_2818)this.vs$shipChunks.get(chunkPosLong = (pos = new class_1923(x, z)).method_8324())) != null) {
                worldChunk = oldChunk;
                oldChunk.method_12224(buf, tag, consumer);
            } else {
                worldChunk = new class_2818((class_1937)this.field_16525, pos);
                worldChunk.method_12224(buf, tag, consumer);
                this.vs$shipChunks.put(chunkPosLong, (Object)worldChunk);
            }
            this.field_16525.method_23782(pos);
            if (ValkyrienCommonMixinConfigPlugin.getVSRenderer() == VSRenderer.SODIUM) {
                SodiumCompat.onChunkAdded(this.field_16525, x, z);
            }
            cir.setReturnValue((Object)worldChunk);
        }
    }

    @Override
    public void vs$removeShip(ClientShip ship) {
        ChunkClaim chunks = ship.getChunkClaim();
        for (int x = chunks.getXStart(); x <= chunks.getXEnd(); ++x) {
            for (int z = chunks.getZStart(); z <= chunks.getZEnd(); ++z) {
                this.removeShipChunk(x, z);
            }
        }
    }

    @Inject(method={"drop"}, at={@At(value="HEAD")}, cancellable=true)
    public void preUnload(int chunkX, int chunkZ, CallbackInfo ci) {
        if (VSGameUtilsKt.isChunkInShipyard((class_1937)this.field_16525, chunkX, chunkZ)) {
            this.vs$shipChunks.remove(class_1923.method_8331((int)chunkX, (int)chunkZ));
            if (ValkyrienCommonMixinConfigPlugin.getVSRenderer() != VSRenderer.SODIUM) {
                ((IVSViewAreaMethods)((LevelRendererAccessor)((ClientLevelAccessor)this.field_16525).getLevelRenderer()).getViewArea()).unloadChunk(chunkX, chunkZ);
            } else {
                SodiumCompat.onChunkRemoved(this.field_16525, chunkX, chunkZ);
            }
            ci.cancel();
        }
    }

    @Unique
    private void removeShipChunk(int chunkX, int chunkZ) {
        if (this.vs$shipChunks.remove(class_1923.method_8331((int)chunkX, (int)chunkZ)) == null) {
            return;
        }
        if (ValkyrienCommonMixinConfigPlugin.getVSRenderer() != VSRenderer.SODIUM) {
            ((IVSViewAreaMethods)((LevelRendererAccessor)((ClientLevelAccessor)this.field_16525).getLevelRenderer()).getViewArea()).unloadChunk(chunkX, chunkZ);
        } else {
            SodiumCompat.onChunkRemoved(this.field_16525, chunkX, chunkZ);
        }
    }

    @Inject(method={"getChunk(IILnet/minecraft/world/level/chunk/ChunkStatus;Z)Lnet/minecraft/world/level/chunk/LevelChunk;"}, at={@At(value="HEAD")}, cancellable=true)
    public void preGetChunk(int chunkX, int chunkZ, class_2806 chunkStatus, boolean bl, CallbackInfoReturnable<class_2818> cir) {
        class_2818 shipChunk = (class_2818)this.vs$shipChunks.get(class_1923.method_8331((int)chunkX, (int)chunkZ));
        if (shipChunk != null) {
            cir.setReturnValue((Object)shipChunk);
        }
    }
}

