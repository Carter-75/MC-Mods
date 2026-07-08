/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  at.petrak.hexcasting.api.casting.circles.BlockEntityAbstractImpetus
 *  at.petrak.hexcasting.api.casting.eval.CastingEnvironment
 *  at.petrak.hexcasting.api.casting.eval.CastingEnvironmentComponent$HasEditPermissionsAt
 *  at.petrak.hexcasting.api.casting.eval.CastingEnvironmentComponent$IsVecInRange
 *  at.petrak.hexcasting.api.casting.eval.CastingEnvironmentComponent$Key
 *  at.petrak.hexcasting.api.casting.eval.env.CircleCastEnv
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1309
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 */
package org.valkyrienskies.mod.compat.hexcasting;

import at.petrak.hexcasting.api.casting.circles.BlockEntityAbstractImpetus;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironmentComponent;
import at.petrak.hexcasting.api.casting.eval.env.CircleCastEnv;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1309;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.compat.hexcasting.Key;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2={"Lorg/valkyrienskies/mod/compat/hexcasting/AmbitRemapping;", "Lat/petrak/hexcasting/api/casting/eval/CastingEnvironmentComponent$IsVecInRange;", "Lat/petrak/hexcasting/api/casting/eval/CastingEnvironmentComponent$HasEditPermissionsAt;", "Lat/petrak/hexcasting/api/casting/eval/CastingEnvironmentComponent$Key;", "getKey", "()Lat/petrak/hexcasting/api/casting/eval/CastingEnvironmentComponent$Key;", "Lnet/minecraft/class_2338;", "pos", "", "current", "onHasEditPermissionsAt", "(Lnet/minecraft/class_2338;Z)Z", "Lnet/minecraft/class_243;", "vec", "onIsVecInRange", "(Lnet/minecraft/class_243;Z)Z", "getCasterPosition", "()Lnet/minecraft/class_243;", "Lat/petrak/hexcasting/api/casting/eval/CastingEnvironment;", "env", "Lat/petrak/hexcasting/api/casting/eval/CastingEnvironment;", "getEnv", "()Lat/petrak/hexcasting/api/casting/eval/CastingEnvironment;", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "id", "Ljava/util/UUID;", "Lorg/valkyrienskies/mod/compat/hexcasting/Key;", "key", "Lorg/valkyrienskies/mod/compat/hexcasting/Key;", "<init>", "(Lat/petrak/hexcasting/api/casting/eval/CastingEnvironment;)V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nShipAmbit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShipAmbit.kt\norg/valkyrienskies/mod/compat/hexcasting/AmbitRemapping\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,64:1\n1#2:65\n*E\n"})
public class AmbitRemapping
implements CastingEnvironmentComponent.IsVecInRange,
CastingEnvironmentComponent.HasEditPermissionsAt {
    @NotNull
    private final CastingEnvironment env;
    private final UUID id;
    @NotNull
    private final Key key;

    public AmbitRemapping(@NotNull CastingEnvironment env) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        this.env = env;
        UUID uUID = this.id = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"id");
        this.key = new Key(uUID);
    }

    @NotNull
    public final CastingEnvironment getEnv() {
        return this.env;
    }

    @NotNull
    public CastingEnvironmentComponent.Key<?> getKey() {
        return this.key;
    }

    public boolean onHasEditPermissionsAt(@NotNull class_2338 pos, boolean current) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if (current) {
            return true;
        }
        LoadedServerShip loadedServerShip = VSGameUtilsKt.getLoadedShipManagingPos(this.env.getWorld(), (class_2382)pos);
        if (loadedServerShip != null) {
            LoadedServerShip ship = loadedServerShip;
            boolean bl = false;
            Ship ship2 = ship;
            class_243 class_2432 = pos.method_46558();
            Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"getCenter(...)");
            return this.env.hasEditPermissionsAt(class_2338.method_49638((class_2374)((class_2374)ValkyrienSkies.positionToWorld(ship2, class_2432))));
        }
        return current;
    }

    public boolean onIsVecInRange(@NotNull class_243 vec, boolean current) {
        LoadedServerShip otherPos;
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        if (current) {
            return true;
        }
        class_3218 level = this.env.getWorld();
        class_243 class_2432 = this.getCasterPosition();
        if (class_2432 == null) {
            class_2432 = class_243.field_1353;
        }
        class_243 castVec = class_2432;
        Intrinsics.checkNotNull((Object)castVec);
        LoadedServerShip casterShip = VSGameUtilsKt.getLoadedShipManagingPos(level, (Vector3dc)VectorConversionsMCKt.toJOML(castVec));
        LoadedServerShip otherShip = VSGameUtilsKt.getLoadedShipManagingPos(level, (Vector3dc)VectorConversionsMCKt.toJOML(vec));
        if (Intrinsics.areEqual((Object)casterShip, (Object)otherShip)) {
            return current;
        }
        LoadedServerShip loadedServerShip = otherShip;
        if (loadedServerShip == null || (loadedServerShip = ValkyrienSkies.positionToWorld((Ship)loadedServerShip, vec)) == null) {
            loadedServerShip = otherPos = vec;
        }
        if (casterShip != null) {
            LoadedServerShip casterShip2 = casterShip;
            boolean bl = false;
            return this.env.isVecInRange(ValkyrienSkies.positionToShip((Ship)casterShip2, (class_243)otherPos));
        }
        return this.env.isVecInRange((class_243)otherPos);
    }

    @Nullable
    public class_243 getCasterPosition() {
        class_243 class_2432;
        class_1309 class_13092 = this.env.getCastingEntity();
        if (class_13092 != null && (class_2432 = class_13092.method_19538()) != null) {
            class_243 it = class_2432;
            boolean bl = false;
            return it;
        }
        if (this.env instanceof CircleCastEnv) {
            BlockEntityAbstractImpetus blockEntityAbstractImpetus = ((CircleCastEnv)this.env).getImpetus();
            return blockEntityAbstractImpetus != null && (blockEntityAbstractImpetus = blockEntityAbstractImpetus.method_11016()) != null ? blockEntityAbstractImpetus.method_46558() : null;
        }
        return null;
    }
}

