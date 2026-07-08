/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.MapMaker
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 */
package org.valkyrienskies.mod.common;

import com.google.common.collect.MapMaker;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixin.accessors.entity.EntityAccessor;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a2\u0006\u0004\b\t\u0010\nJ!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007\u00a2\u0006\u0004\b\t\u0010\rJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0007\u00a2\u0006\u0004\b\t\u0010\u0013J5\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0007\u00a2\u0006\u0004\b\t\u0010\u0014R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2={"Lorg/valkyrienskies/mod/common/PlayerUtil;", "", "Lnet/minecraft/class_1657;", "player", "Lnet/minecraft/class_1937;", "world", "Lnet/minecraft/class_2338;", "blockInShip", "", "transformPlayerTemporarily", "(Lnet/minecraft/class_1657;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;)V", "Lorg/valkyrienskies/core/api/ships/LoadedShip;", "ship", "(Lnet/minecraft/class_1657;Lorg/valkyrienskies/core/api/ships/LoadedShip;)V", "untransformPlayer", "(Lnet/minecraft/class_1657;)V", "T", "Lkotlin/Function0;", "inside", "(Lnet/minecraft/class_1657;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lnet/minecraft/class_1657;Lorg/valkyrienskies/core/api/ships/LoadedShip;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Ljava/util/concurrent/ConcurrentMap;", "Lorg/valkyrienskies/mod/common/PlayerUtil$TempPlayerPosInfo;", "prevPosInfo", "Ljava/util/concurrent/ConcurrentMap;", "<init>", "()V", "TempPlayerPosInfo", "valkyrienskies-120"})
public final class PlayerUtil {
    @NotNull
    public static final PlayerUtil INSTANCE = new PlayerUtil();
    @NotNull
    private static final ConcurrentMap<class_1657, TempPlayerPosInfo> prevPosInfo;

    private PlayerUtil() {
    }

    @JvmStatic
    public static final void transformPlayerTemporarily(@NotNull class_1657 player, @NotNull class_1937 world, @NotNull class_2338 blockInShip) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)blockInShip, (String)"blockInShip");
        PlayerUtil.transformPlayerTemporarily(player, VSGameUtilsKt.getLoadedShipManagingPos(world, (class_2382)blockInShip));
    }

    @JvmStatic
    public static final void transformPlayerTemporarily(@NotNull class_1657 player, @Nullable LoadedShip ship) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (ship == null) {
            return;
        }
        class_1937 class_19372 = player.method_37908();
        Intrinsics.checkNotNullExpressionValue((Object)class_19372, (String)"level(...)");
        if (VSGameUtilsKt.isBlockInShipyard(class_19372, player.method_23317(), player.method_23318(), player.method_23321())) {
            return;
        }
        Map map2 = prevPosInfo;
        float f2 = player.method_36454();
        float f3 = player.field_6241;
        float f4 = player.method_36455();
        class_243 class_2432 = player.method_19538();
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"position(...)");
        TempPlayerPosInfo tempPlayerPosInfo = new TempPlayerPosInfo(f2, f3, f4, class_2432);
        map2.put(player, tempPlayerPosInfo);
        Matrix4dc shipMatrix = ship.getWorldToShip();
        class_243 class_2433 = player.method_5720();
        Intrinsics.checkNotNullExpressionValue((Object)class_2433, (String)"getLookAngle(...)");
        Vector3d direction = shipMatrix.transformDirection(VectorConversionsMCKt.toJOML(class_2433));
        class_243 class_2434 = player.method_19538();
        Intrinsics.checkNotNullExpressionValue((Object)class_2434, (String)"position(...)");
        Vector3d position = shipMatrix.transformPosition(VectorConversionsMCKt.toJOML(class_2434));
        double yaw = -Math.atan2(direction.x, direction.z);
        double pitch = -Math.atan2(direction.y, Math.sqrt(direction.x * direction.x + direction.z * direction.z));
        player.method_36456((float)(yaw * 57.29577951308232));
        player.field_6241 = player.method_36454();
        player.method_36457((float)(pitch * 57.29577951308232));
        EntityAccessor entityAccessor = (EntityAccessor)player;
        Intrinsics.checkNotNull((Object)position);
        entityAccessor.setPosNoUpdates(VectorConversionsMCKt.toMinecraft(position));
    }

    @JvmStatic
    public static final void untransformPlayer(@NotNull class_1657 player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        TempPlayerPosInfo tempPlayerPosInfo = (TempPlayerPosInfo)prevPosInfo.remove(player);
        if (tempPlayerPosInfo == null) {
            return;
        }
        TempPlayerPosInfo info = tempPlayerPosInfo;
        player.method_36457(info.getPitch());
        player.method_36456(info.getYaw());
        player.field_6241 = info.getHeadYaw();
        ((EntityAccessor)player).setPosNoUpdates(info.getPos());
    }

    @JvmStatic
    public static final <T> T transformPlayerTemporarily(@NotNull class_1657 player, @NotNull class_1937 world, @NotNull class_2338 blockInShip, @NotNull Function0<? extends T> inside) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)blockInShip, (String)"blockInShip");
        Intrinsics.checkNotNullParameter(inside, (String)"inside");
        return PlayerUtil.transformPlayerTemporarily(player, VSGameUtilsKt.getLoadedShipManagingPos(world, (class_2382)blockInShip), inside);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @JvmStatic
    public static final <T> T transformPlayerTemporarily(@NotNull class_1657 player, @Nullable LoadedShip ship, @NotNull Function0<? extends T> inside) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter(inside, (String)"inside");
        PlayerUtil.transformPlayerTemporarily(player, ship);
        try {
            Object object = inside.invoke();
            return (T)object;
        }
        finally {
            PlayerUtil.untransformPlayer(player);
        }
    }

    static {
        ConcurrentMap concurrentMap = new MapMaker().weakKeys().makeMap();
        Intrinsics.checkNotNullExpressionValue((Object)concurrentMap, (String)"makeMap(...)");
        prevPosInfo = concurrentMap;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007H\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\t\u00a8\u0006\""}, d2={"Lorg/valkyrienskies/mod/common/PlayerUtil$TempPlayerPosInfo;", "", "", "component1", "()F", "component2", "component3", "Lnet/minecraft/class_243;", "component4", "()Lnet/minecraft/class_243;", "yaw", "headYaw", "pitch", "pos", "copy", "(FFFLnet/minecraft/class_243;)Lorg/valkyrienskies/mod/common/PlayerUtil$TempPlayerPosInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "F", "getYaw", "getHeadYaw", "getPitch", "Lnet/minecraft/class_243;", "getPos", "<init>", "(FFFLnet/minecraft/class_243;)V", "valkyrienskies-120"})
    private static final class TempPlayerPosInfo {
        private final float yaw;
        private final float headYaw;
        private final float pitch;
        @NotNull
        private final class_243 pos;

        public TempPlayerPosInfo(float yaw, float headYaw, float pitch, @NotNull class_243 pos) {
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            this.yaw = yaw;
            this.headYaw = headYaw;
            this.pitch = pitch;
            this.pos = pos;
        }

        public final float getYaw() {
            return this.yaw;
        }

        public final float getHeadYaw() {
            return this.headYaw;
        }

        public final float getPitch() {
            return this.pitch;
        }

        @NotNull
        public final class_243 getPos() {
            return this.pos;
        }

        public final float component1() {
            return this.yaw;
        }

        public final float component2() {
            return this.headYaw;
        }

        public final float component3() {
            return this.pitch;
        }

        @NotNull
        public final class_243 component4() {
            return this.pos;
        }

        @NotNull
        public final TempPlayerPosInfo copy(float yaw, float headYaw, float pitch, @NotNull class_243 pos) {
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            return new TempPlayerPosInfo(yaw, headYaw, pitch, pos);
        }

        public static /* synthetic */ TempPlayerPosInfo copy$default(TempPlayerPosInfo tempPlayerPosInfo, float f2, float f3, float f4, class_243 class_2432, int n2, Object object) {
            if ((n2 & 1) != 0) {
                f2 = tempPlayerPosInfo.yaw;
            }
            if ((n2 & 2) != 0) {
                f3 = tempPlayerPosInfo.headYaw;
            }
            if ((n2 & 4) != 0) {
                f4 = tempPlayerPosInfo.pitch;
            }
            if ((n2 & 8) != 0) {
                class_2432 = tempPlayerPosInfo.pos;
            }
            return tempPlayerPosInfo.copy(f2, f3, f4, class_2432);
        }

        @NotNull
        public String toString() {
            return "TempPlayerPosInfo(yaw=" + this.yaw + ", headYaw=" + this.headYaw + ", pitch=" + this.pitch + ", pos=" + this.pos + ")";
        }

        public int hashCode() {
            int result2 = Float.hashCode(this.yaw);
            result2 = result2 * 31 + Float.hashCode(this.headYaw);
            result2 = result2 * 31 + Float.hashCode(this.pitch);
            result2 = result2 * 31 + this.pos.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TempPlayerPosInfo)) {
                return false;
            }
            TempPlayerPosInfo tempPlayerPosInfo = (TempPlayerPosInfo)other;
            if (Float.compare(this.yaw, tempPlayerPosInfo.yaw) != 0) {
                return false;
            }
            if (Float.compare(this.headYaw, tempPlayerPosInfo.headYaw) != 0) {
                return false;
            }
            if (Float.compare(this.pitch, tempPlayerPosInfo.pitch) != 0) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.pos, (Object)tempPlayerPosInfo.pos);
        }
    }
}

