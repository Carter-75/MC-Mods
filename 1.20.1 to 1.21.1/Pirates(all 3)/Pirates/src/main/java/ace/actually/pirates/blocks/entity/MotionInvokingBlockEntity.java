/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2487
 *  net.minecraft.class_2495
 *  net.minecraft.class_2499
 *  net.minecraft.class_2520
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  org.joml.Vector3d
 *  org.joml.Vector3dc
 *  org.valkyrienskies.core.api.ships.LoadedServerShip
 *  org.valkyrienskies.core.api.ships.Ship
 *  org.valkyrienskies.mod.api.SeatedControllingPlayer
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 *  org.valkyrienskies.mod.common.ValkyrienSkiesMod
 *  org.valkyrienskies.mod.common.util.GameToPhysicsAdapter
 */
package ace.actually.pirates.blocks.entity;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.blocks.MotionInvokingBlock;
import ace.actually.pirates.util.ConfigUtils;
import ace.actually.pirates.util.EurekaCompat;
import ace.actually.pirates.util.SailsCompat;
import java.util.List;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2487;
import net.minecraft.class_2495;
import net.minecraft.class_2499;
import net.minecraft.class_2520;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.api.SeatedControllingPlayer;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.util.GameToPhysicsAdapter;

public class MotionInvokingBlockEntity
extends class_2586 {
    class_2499 path = new class_2499();
    long nextInstruction = 0L;
    int[] target = new int[3];
    double ldx = -1.0;
    double ldz = -1.0;
    private static int updateTicks = -1;

    public MotionInvokingBlockEntity(class_2338 pos, class_2680 state) {
        super((class_2591)Pirates.MOTION_INVOKING_BLOCK_ENTITY.get(), pos, state);
    }

    public static void tick(class_1937 world, class_2338 pos, class_2680 state, MotionInvokingBlockEntity be) {
        class_1923 chunkPos;
        LoadedServerShip ship;
        if (!((Boolean)state.method_11654((class_2769)MotionInvokingBlock.ARMED)).booleanValue()) {
            return;
        }
        if (((Integer)state.method_11654((class_2769)MotionInvokingBlock.COMPAT)).equals(1)) {
            if (!Pirates.loadedCompats.sails) {
                state = (class_2680)state.method_11657((class_2769)MotionInvokingBlock.COMPAT, (Comparable)Integer.valueOf(0));
                world.method_8652(pos, state, 10);
                return;
            }
            if (!SailsCompat.checkHelm(world, pos)) {
                MotionInvokingBlock.disarm(world, pos);
                return;
            }
        } else if (((Integer)state.method_11654((class_2769)MotionInvokingBlock.COMPAT)).equals(2)) {
            if (!Pirates.loadedCompats.eureka) {
                state = (class_2680)state.method_11657((class_2769)MotionInvokingBlock.COMPAT, (Comparable)Integer.valueOf(0));
                world.method_8652(pos, state, 10);
                return;
            }
            if (!EurekaCompat.checkHelm(world, pos)) {
                MotionInvokingBlock.disarm(world, pos);
                return;
            }
        }
        if (updateTicks == -1) {
            updateTicks = Integer.parseInt(ConfigUtils.config.getOrDefault("controlled-ship-updates", "100"));
        }
        if (!world.field_9236 && world.method_8450().method_8355(Pirates.PIRATES_IS_LIVE_WORLD) && world.method_8510() >= be.nextInstruction && VSGameUtilsKt.isBlockInShipyard((class_1937)world, (class_2338)pos) && (ship = VSGameUtilsKt.getShipObjectManagingPos((class_3218)((class_3218)world), (class_1923)(chunkPos = world.method_22350(pos).method_12004()))) != null) {
            ship.setStatic(false);
            SeatedControllingPlayer seatedControllingPlayer = (SeatedControllingPlayer)ship.getAttachment(SeatedControllingPlayer.class);
            if (seatedControllingPlayer == null && world.method_8320(pos.method_10084()).method_28498((class_2769)class_2741.field_12481)) {
                if (((Integer)state.method_11654((class_2769)MotionInvokingBlock.COMPAT)).equals(1)) {
                    seatedControllingPlayer = new SeatedControllingPlayer(((class_2350)world.method_8320(pos.method_10084()).method_11654((class_2769)class_2741.field_12481)).method_10153());
                } else if (((Integer)state.method_11654((class_2769)MotionInvokingBlock.COMPAT)).equals(2)) {
                    seatedControllingPlayer = new SeatedControllingPlayer(((class_2350)world.method_8320(pos.method_10084()).method_11654((class_2769)class_2741.field_12481)).method_10153());
                }
                ship.setAttachment(SeatedControllingPlayer.class, (Object)seatedControllingPlayer);
            }
            if (world.method_8532() % (long)updateTicks == 0L) {
                if (be.path.isEmpty()) {
                    List<Ship> ships = VSGameUtilsKt.getAllShips((class_1937)world).stream().filter(a -> {
                        Vector3dc f2;
                        if (a.getId() == ship.getId()) {
                            return false;
                        }
                        Vector3dc f1 = ship.getTransform().getPositionInWorld();
                        return f1.distanceSquared(f2 = a.getTransform().getPositionInWorld()) < (double)Pirates.pursuitDistance;
                    }).toList();
                    if (!ships.isEmpty()) {
                        Vector3dc o = ships.get(0).getTransform().getPositionInWorld();
                        be.setTarget(new int[]{(int)o.x(), (int)o.y(), (int)o.z()});
                    }
                } else {
                    int[] v = be.path.method_36111(0);
                    be.setTarget(v);
                    Vector3dc f1 = ship.getTransform().getPositionInWorld();
                    Vector3d f2 = new Vector3d((double)v[0], (double)v[1], (double)v[2]);
                    if (f1.distanceSquared((Vector3dc)f2) < 100.0) {
                        class_2495 nbtInts = (class_2495)be.path.method_10536(0);
                        be.path.add((Object)nbtInts);
                    }
                }
            }
            switch ((Integer)state.method_11654((class_2769)MotionInvokingBlock.COMPAT)) {
                case 1: {
                    SailsCompat.moveTowards(be, seatedControllingPlayer, ship);
                    break;
                }
                case 2: {
                    EurekaCompat.moveTowards(be, seatedControllingPlayer, ship);
                    break;
                }
                default: {
                    be.moveShipForward(ship);
                }
            }
        }
    }

    protected void method_11007(class_2487 nbt) {
        nbt.method_10566("path", (class_2520)this.path);
        nbt.method_10544("nextInstruction", this.nextInstruction);
        nbt.method_10539("target", this.target);
        super.method_11007(nbt);
    }

    public void method_11014(class_2487 nbt) {
        super.method_11014(nbt);
        this.nextInstruction = nbt.method_10537("nextInstruction");
        if (nbt.method_10545("path")) {
            this.path = (class_2499)nbt.method_10580("path");
        }
        if (nbt.method_10545("target")) {
            this.target = nbt.method_10561("target");
        }
    }

    public void setTarget(int[] target) {
        this.target = target;
        this.method_5431();
    }

    public int[] getTarget() {
        return this.target;
    }

    public double getLdx() {
        return this.ldx;
    }

    public double getLdz() {
        return this.ldz;
    }

    public void setLdx(double ldx) {
        this.ldx = ldx;
    }

    public void setLdz(double ldz) {
        this.ldz = ldz;
    }

    public class_2499 getPath() {
        return this.path;
    }

    public void setPath(class_2499 path) {
        this.path = path;
        this.method_5431();
    }

    public void addPathNode(class_2338 pos) {
        this.path.add((Object)new class_2495(new int[]{pos.method_10263(), pos.method_10264(), pos.method_10260()}));
        this.method_5431();
    }

    private void moveShipForward(LoadedServerShip ship) {
        double mass = ship.getInertiaData().getMass();
        Vector3d qdc = ship.getTransform().getShipToWorldRotation().getEulerAnglesZXY(new Vector3d()).normalize().mul(mass * 10.0);
        qdc = new Vector3d(-qdc.x, 0.0, -qdc.z);
        GameToPhysicsAdapter gtfa = ValkyrienSkiesMod.getOrCreateGTPA((String)VSGameUtilsKt.getDimensionId((class_1937)this.field_11863));
        Vector3dc v3dc = ship.getInertiaData().getCenterOfMassInShip();
        Vector3d loc = new Vector3d(v3dc.x() + 1.0, v3dc.y(), v3dc.z() + 1.0);
        gtfa.applyInvariantForceToPos(ship.getId(), (Vector3dc)qdc, (Vector3dc)loc.sub(ship.getTransform().getPositionInShip()));
    }
}

