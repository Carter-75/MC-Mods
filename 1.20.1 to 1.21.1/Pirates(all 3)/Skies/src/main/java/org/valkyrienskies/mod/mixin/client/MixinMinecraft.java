/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1132
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_239
 *  net.minecraft.class_310
 *  net.minecraft.class_3965
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1132;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_239;
import net.minecraft.class_310;
import net.minecraft.class_3965;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.internal.world.VsiClientShipWorld;
import org.valkyrienskies.core.internal.world.VsiPipeline;
import org.valkyrienskies.mod.common.IShipObjectWorldClientCreator;
import org.valkyrienskies.mod.common.IShipObjectWorldClientProvider;
import org.valkyrienskies.mod.common.IShipObjectWorldServerProvider;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.util.EntityDragger;
import org.valkyrienskies.mod.mixinducks.client.MinecraftDuck;

@Mixin(value={class_310.class})
public abstract class MixinMinecraft
implements MinecraftDuck,
IShipObjectWorldClientProvider,
IShipObjectWorldClientCreator {
    @Unique
    private static final Logger log = LogManager.getLogger("VS2 MixinMinecraft");
    @Unique
    private static long lastLog = System.currentTimeMillis();
    @Shadow
    private boolean field_1734;
    @Shadow
    public class_638 field_1687;
    @Unique
    private class_239 originalCrosshairTarget;
    @Unique
    private VsiClientShipWorld shipObjectWorld = null;

    @Shadow
    @Nullable
    public abstract class_1132 method_1576();

    @Override
    public void vs$setOriginalCrosshairTarget(class_239 originalCrosshairTarget) {
        this.originalCrosshairTarget = originalCrosshairTarget;
    }

    @Override
    public class_239 vs$getOriginalCrosshairTarget() {
        return this.originalCrosshairTarget;
    }

    @WrapOperation(at={@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/MultiPlayerGameMode;useItemOn(Lnet/minecraft/client/player/LocalPlayer;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/phys/BlockHitResult;)Lnet/minecraft/world/InteractionResult;")}, method={"startUseItem"})
    private class_1269 useOriginalCrosshairForBlockPlacement(class_636 instance, class_746 localPlayer, class_1268 interactionHand, class_3965 blockHitResult, Operation<class_1269> useItemOn) {
        return (class_1269)useItemOn.call(new Object[]{instance, localPlayer, interactionHand, this.originalCrosshairTarget});
    }

    @Override
    @NotNull
    public VsiClientShipWorld getShipObjectWorld() {
        VsiClientShipWorld shipObjectWorldCopy = this.shipObjectWorld;
        if (shipObjectWorldCopy == null) {
            if (lastLog + 5000L < System.currentTimeMillis()) {
                lastLog = System.currentTimeMillis();
                log.warn("Requested getShipObjectWorld() but failed returning dummy world", (Throwable)new IllegalStateException("shipObjectWorld is null"));
            }
            return ValkyrienSkiesMod.getVsCore().getDummyShipWorldClient();
        }
        return shipObjectWorldCopy;
    }

    @Shadow
    public abstract class_634 method_1562();

    @Inject(method={"tick"}, at={@At(value="TAIL")})
    public void postTick(CallbackInfo ci) {
        if (!this.field_1734 && this.shipObjectWorld != null && this.field_1687 != null && this.method_1562() != null) {
            this.shipObjectWorld.tickNetworking(this.method_1562().method_48296().method_10755());
            this.shipObjectWorld.postTick();
            EntityDragger.INSTANCE.dragEntitiesWithShips(this.field_1687.method_18112(), false);
        }
    }

    @Inject(method={"runTick"}, at={@At(value="TAIL")})
    public void setGamePause(boolean pauseOnly, CallbackInfo ci) {
        VsiPipeline pipeline;
        IShipObjectWorldServerProvider provider = (IShipObjectWorldServerProvider)this.method_1576();
        if (provider != null && (pipeline = provider.getVsPipeline()) != null) {
            pipeline.setArePhysicsRunning(!this.field_1734);
        }
    }

    @Override
    public void createShipObjectWorldClient() {
        if (this.shipObjectWorld != null) {
            throw new IllegalStateException("shipObjectWorld was not null when it should be null?");
        }
        this.shipObjectWorld = ValkyrienSkiesMod.getVsCoreClient().newShipWorldClient();
    }

    @Override
    public void deleteShipObjectWorldClient() {
        VsiClientShipWorld shipObjectWorldCopy = this.shipObjectWorld;
        if (shipObjectWorldCopy == null) {
            throw new IllegalStateException("shipObjectWorld was null when it should be not null?");
        }
        shipObjectWorldCopy.destroyWorld();
        this.shipObjectWorld = null;
    }

    @Inject(method={"clearLevel"}, at={@At(value="TAIL")})
    private void postClearLevel(CallbackInfo ci) {
        if (this.shipObjectWorld != null) {
            this.deleteShipObjectWorldClient();
        }
    }
}

