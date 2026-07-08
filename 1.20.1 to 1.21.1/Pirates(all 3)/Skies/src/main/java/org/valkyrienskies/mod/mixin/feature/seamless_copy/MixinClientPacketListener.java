/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2626
 *  net.minecraft.class_2637
 *  net.minecraft.class_2672
 *  net.minecraft.class_4076
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.feature.seamless_copy;

import net.minecraft.class_2596;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2672;
import net.minecraft.class_4076;
import net.minecraft.class_634;
import net.minecraft.class_638;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.assembly.SeamlessChunksManager;
import org.valkyrienskies.mod.mixin.accessors.network.protocol.game.ClientboundSectionBlocksUpdatePacketAccessor;
import org.valkyrienskies.mod.mixinducks.feature.seamless_copy.SeamlessCopyClientPacketListenerDuck;

@Mixin(value={class_634.class})
public class MixinClientPacketListener
implements SeamlessCopyClientPacketListenerDuck {
    @Shadow
    private class_638 field_3699;
    @Unique
    private final SeamlessChunksManager chunks = new SeamlessChunksManager((class_634)class_634.class.cast(this));

    @Inject(at={@At(value="HEAD")}, method={"close"})
    private void beforeClose(CallbackInfo ci) {
        this.chunks.cleanup();
    }

    @Inject(at={@At(value="INVOKE", target="Lnet/minecraft/network/protocol/PacketUtils;ensureRunningOnSameThread(Lnet/minecraft/network/protocol/Packet;Lnet/minecraft/network/PacketListener;Lnet/minecraft/util/thread/BlockableEventLoop;)V", shift=At.Shift.AFTER)}, method={"handleLevelChunkWithLight"}, cancellable=true)
    private void beforeHandleLevelChunk(class_2672 packet, CallbackInfo ci) {
        if (this.field_3699 != null && this.chunks.queue(packet.method_11523(), packet.method_11524(), (class_2596<?>)packet, this.field_3699)) {
            ci.cancel();
        }
    }

    @Inject(at={@At(value="INVOKE", target="Lnet/minecraft/network/protocol/PacketUtils;ensureRunningOnSameThread(Lnet/minecraft/network/protocol/Packet;Lnet/minecraft/network/PacketListener;Lnet/minecraft/util/thread/BlockableEventLoop;)V", shift=At.Shift.AFTER)}, method={"handleChunkBlocksUpdate"}, cancellable=true)
    private void beforeHandleChunkBlocksUpdate(class_2637 packet, CallbackInfo ci) {
        class_4076 pos = ((ClientboundSectionBlocksUpdatePacketAccessor)packet).getSectionPos();
        if (this.chunks.queue(pos.method_18674(), pos.method_18687(), (class_2596<?>)packet, this.field_3699)) {
            ci.cancel();
        }
    }

    @Inject(at={@At(value="INVOKE", target="Lnet/minecraft/network/protocol/PacketUtils;ensureRunningOnSameThread(Lnet/minecraft/network/protocol/Packet;Lnet/minecraft/network/PacketListener;Lnet/minecraft/util/thread/BlockableEventLoop;)V", shift=At.Shift.AFTER)}, method={"handleBlockUpdate"}, cancellable=true)
    private void beforeHandleBlockUpdate(class_2626 packet, CallbackInfo ci) {
        if (this.chunks.queue(packet.method_11309().method_10263() >> 4, packet.method_11309().method_10260() >> 4, (class_2596<?>)packet, this.field_3699)) {
            ci.cancel();
        }
    }

    @Override
    @NotNull
    public SeamlessChunksManager vs_getChunks() {
        return this.chunks;
    }
}

