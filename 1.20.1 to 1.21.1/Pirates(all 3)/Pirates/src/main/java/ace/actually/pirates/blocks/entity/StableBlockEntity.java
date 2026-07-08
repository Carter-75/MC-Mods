/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2487
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  org.joml.Vector3d
 *  org.joml.Vector3dc
 *  org.valkyrienskies.core.api.ships.LoadedServerShip
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 *  org.valkyrienskies.mod.common.ValkyrienSkiesMod
 *  org.valkyrienskies.mod.common.util.GameToPhysicsAdapter
 *  org.valkyrienskies.mod.common.util.VectorConversionsMCKt
 */
package ace.actually.pirates.blocks.entity;

import ace.actually.pirates.Pirates;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2487;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.util.GameToPhysicsAdapter;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

public class StableBlockEntity
extends class_2586 {
    double multiplier = 1.0;

    public StableBlockEntity(class_2338 pos, class_2680 state) {
        super((class_2591)Pirates.STABLE_BLOCK_ENTITY.get(), pos, state);
    }

    public void method_11014(class_2487 nbt) {
        super.method_11014(nbt);
        this.multiplier = nbt.method_10574("multiplier");
    }

    protected void method_11007(class_2487 nbt) {
        nbt.method_10549("multiplier", this.multiplier);
        super.method_11007(nbt);
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
        this.method_5431();
    }

    public static void tick(class_1937 world, class_2338 pos, class_2680 state, StableBlockEntity be) {
        LoadedServerShip ship;
        class_3218 serverWorld;
        if (world instanceof class_3218 && VSGameUtilsKt.isBlockInShipyard((class_1937)(serverWorld = (class_3218)world), (class_2338)pos) && (ship = VSGameUtilsKt.getShipObjectManagingPos((class_3218)serverWorld, (class_2382)pos)) != null) {
            GameToPhysicsAdapter gtfa = ValkyrienSkiesMod.getOrCreateGTPA((String)VSGameUtilsKt.getDimensionId((class_1937)world));
            class_2382 vec3i = class_2382.field_11176.method_30931();
            Vector3d v3d = VectorConversionsMCKt.toJOMLD((class_2382)vec3i).mul(be.multiplier * ship.getInertiaData().getMass());
            Vector3d loc = new Vector3d((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260()).sub(ship.getTransform().getPositionInShip());
            gtfa.applyInvariantForceToPos(ship.getId(), (Vector3dc)v3d, (Vector3dc)loc);
        }
    }
}

