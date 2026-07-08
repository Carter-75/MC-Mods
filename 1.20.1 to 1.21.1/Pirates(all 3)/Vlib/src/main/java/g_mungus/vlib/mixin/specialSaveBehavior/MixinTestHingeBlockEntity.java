/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  net.minecraft.class_1268
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2318
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2520
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_2960
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3492
 *  net.minecraft.class_3965
 *  net.minecraft.class_5425
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3d
 *  org.joml.Vector3dc
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.valkyrienskies.core.api.ships.ServerShip
 *  org.valkyrienskies.core.api.ships.Ship
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 *  org.valkyrienskies.mod.common.block.TestHingeBlock
 *  org.valkyrienskies.mod.common.blockentity.TestHingeBlockEntity
 *  org.valkyrienskies.mod.common.util.VectorConversionsMCKt
 */
package g_mungus.vlib.mixin.specialSaveBehavior;

import g_mungus.vlib.VLib;
import g_mungus.vlib.v2.api.VLibAPI;
import g_mungus.vlib.v2.api.experimental.HasSpecialSaveBehavior;
import g_mungus.vlib.v2.api.extension.NBTExtKt;
import g_mungus.vlib.v2.api.extension.ServerLevelExtKt;
import g_mungus.vlib.v2.api.extension.ShipExtKt;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2318;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2520;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3492;
import net.minecraft.class_3965;
import net.minecraft.class_5425;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.block.TestHingeBlock;
import org.valkyrienskies.mod.common.blockentity.TestHingeBlockEntity;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={TestHingeBlockEntity.class}, remap=false)
public abstract class MixinTestHingeBlockEntity
extends class_2586
implements HasSpecialSaveBehavior {
    @Unique
    private class_2960 vlib$constraintTemplate = null;
    @Unique
    private class_2338 vlib$templateOffset = null;
    @Unique
    private final String vlib$templateKey = "vlib$templateLocation";
    @Unique
    private final String vlib$offsetKey = "vlib$structure_offset";

    @Shadow
    public class_2338 getOtherHingePos() {
        return null;
    }

    public MixinTestHingeBlockEntity(class_2591<?> type, class_2338 pos, class_2680 blockState) {
        super(type, pos, blockState);
    }

    @Override
    public void executeWhenSavingShip() {
        class_2338 hingePos = this.getOtherHingePos();
        class_1937 class_19372 = this.method_10997();
        if (class_19372 instanceof class_3218) {
            ServerShip ship;
            class_3218 serverLevel = (class_3218)class_19372;
            if (hingePos != null && (ship = VSGameUtilsKt.getShipManagingPos((class_3218)serverLevel, (class_2338)this.getOtherHingePos())) != null) {
                class_2960 location = new class_2960("vlib", Objects.requireNonNull(ship.getSlug()));
                class_2338 corner = ShipExtKt.getTemplateCorner((Ship)ship);
                VLibAPI.saveShipToTemplate(ship, location, serverLevel);
                VLibAPI.discardShip(ship, serverLevel);
                this.vlib$constraintTemplate = location;
                this.vlib$templateOffset = hingePos.method_10059((class_2382)corner);
            }
        }
    }

    @Override
    public void executeAfterLoadingShip() {
        class_1937 class_19372 = this.method_10997();
        if (class_19372 instanceof class_3218) {
            class_3218 serverLevel = (class_3218)class_19372;
            if (this.vlib$constraintTemplate != null) {
                class_3222 player = (class_3222)serverLevel.method_18766(it -> true).get(0);
                TestHingeBlock block = (TestHingeBlock)this.method_11010().method_26204();
                block.method_9534(this.method_11010(), (class_1937)serverLevel, this.method_11016(), (class_1657)player, class_1268.field_5808, class_3965.method_17778((class_243)player.method_19538(), (class_2350)player.method_5735(), (class_2338)player.method_24515()));
                serverLevel.method_14183().method_15094(this.vlib$constraintTemplate).ifPresent(structureTemplate -> {
                    class_2338 hingePos = this.getOtherHingePos();
                    class_2338 structurePos = hingePos.method_10059((class_2382)this.vlib$templateOffset);
                    ServerShip ship = VSGameUtilsKt.getShipManagingPos((class_3218)serverLevel, (class_2338)hingePos);
                    if (ship != null) {
                        ServerLevelExtKt.scheduleCallback(serverLevel, 3, (Function0<Unit>)((Function0)() -> {
                            structureTemplate.method_15172((class_5425)serverLevel, structurePos, structurePos, new class_3492(), serverLevel.field_9229, 0);
                            Vector3dc positionInWorld = ship.getTransform().getPositionInWorld();
                            Vector3dc targetPos = this.getTargetPos(serverLevel);
                            Vector3d cogInWorld = ship.getShipToWorld().transformPosition(ship.getInertiaData().getCenterOfMassInShip(), new Vector3d());
                            ShipExtKt.teleport(ship, serverLevel, (Vector3dc)targetPos.add((Vector3dc)cogInWorld, new Vector3d()).add(0.5, 0.5, 0.5).sub(positionInWorld));
                            return Unit.INSTANCE;
                        }));
                    } else {
                        VLib.INSTANCE.getLOGGER().error("SHIP IS NULL");
                    }
                });
            }
        }
    }

    @Unique
    Vector3dc getTargetPos(class_3218 serverLevel) {
        ServerShip ship = VSGameUtilsKt.getShipManagingPos((class_3218)serverLevel, (class_2338)this.method_11016());
        class_2338 blockPos = this.method_11016().method_10081(((class_2350)this.method_11010().method_11654((class_2769)class_2318.field_10927)).method_10163());
        Vector3d pos = VectorConversionsMCKt.toJOML((class_243)blockPos.method_46558());
        return ship != null ? ship.getShipToWorld().transformPosition((Vector3dc)pos, new Vector3d()) : pos;
    }

    protected void method_11007(@NotNull class_2487 tag) {
        super.method_11007(tag);
        if (this.vlib$constraintTemplate != null) {
            tag.method_10582("vlib$templateLocation", this.vlib$constraintTemplate.toString());
            NBTExtKt.putVec3i(tag, "vlib$structure_offset", (class_2382)this.vlib$templateOffset);
        }
    }

    public void method_11014(@NotNull class_2487 tag) {
        super.method_11014(tag);
        class_2520 template = tag.method_10580("vlib$templateLocation");
        if (template != null) {
            this.vlib$constraintTemplate = new class_2960(template.method_10714());
            class_2338 vec = NBTExtKt.getVec3i(tag, "vlib$structure_offset");
            this.vlib$templateOffset = vec != null ? new class_2338((class_2382)vec) : null;
        }
    }
}

