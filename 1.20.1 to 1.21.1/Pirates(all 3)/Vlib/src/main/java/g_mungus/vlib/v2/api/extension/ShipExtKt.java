/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2960
 *  net.minecraft.class_3218
 *  net.minecraft.class_3499
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Quaterniond
 *  org.joml.Quaterniondc
 *  org.joml.Vector3dc
 *  org.joml.primitives.AABBic
 *  org.valkyrienskies.core.api.ships.ServerShip
 *  org.valkyrienskies.core.api.ships.Ship
 *  org.valkyrienskies.core.impl.game.ShipTeleportDataImpl
 *  org.valkyrienskies.core.internal.ShipTeleportData
 *  org.valkyrienskies.core.internal.world.VsiServerShipWorld
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 */
package g_mungus.vlib.v2.api.extension;

import g_mungus.vlib.v2.api.model.NamedStructureTemplate;
import g_mungus.vlib.v2.internal.template.StructureTemplateInternalExtKt;
import g_mungus.vlib.v2.internal.template.VLibStructureData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import net.minecraft.class_3499;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.impl.game.ShipTeleportDataImpl;
import org.valkyrienskies.core.internal.ShipTeleportData;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a%\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\f\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u000f\u001a\u00020\u000e*\u00020\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a\u0011\u0010\u0011\u001a\u00020\u0002*\u00020\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a!\u0010\u0016\u001a\u00020\u0015*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a!\u0010\u0018\u001a\u00020\u0015*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u0018\u0010\u0017\u001a\u0019\u0010\u0019\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001b"}, d2={"Lorg/valkyrienskies/core/api/ships/Ship;", "Lkotlin/Function1;", "Lnet/minecraft/class_2338;", "", "callback", "forEachBlock", "(Lorg/valkyrienskies/core/api/ships/Ship;Lkotlin/jvm/functions/Function1;)V", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "Lnet/minecraft/class_3218;", "level", "Lorg/joml/Vector3dc;", "newPos", "teleport", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Lnet/minecraft/class_3218;Lorg/joml/Vector3dc;)V", "Lnet/minecraft/class_2382;", "getTemplateSize", "(Lorg/valkyrienskies/core/api/ships/Ship;)Lnet/minecraft/class_2382;", "getTemplateCorner", "(Lorg/valkyrienskies/core/api/ships/Ship;)Lnet/minecraft/class_2338;", "Lnet/minecraft/class_2960;", "name", "Lg_mungus/vlib/v2/api/model/NamedStructureTemplate;", "getTemplate", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Lnet/minecraft/class_2960;Lnet/minecraft/class_3218;)Lg_mungus/vlib/v2/api/model/NamedStructureTemplate;", "saveToTemplate", "discard", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Lnet/minecraft/class_3218;)V", "vlib"})
@SourceDebugExtension(value={"SMAP\nShipExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShipExt.kt\ng_mungus/vlib/v2/api/extension/ShipExtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
public final class ShipExtKt {
    public static final void forEachBlock(@NotNull Ship $this$forEachBlock, @NotNull Function1<? super class_2338, Unit> callback) {
        int n;
        Intrinsics.checkNotNullParameter((Object)$this$forEachBlock, (String)"<this>");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        AABBic aABBic = $this$forEachBlock.getShipAABB();
        if (aABBic == null) {
            return;
        }
        AABBic aabb = aABBic;
        int x = aabb.minX();
        if (x <= (n = aabb.maxX())) {
            while (true) {
                int n2;
                int y;
                if ((y = aabb.minY()) <= (n2 = aabb.maxY())) {
                    while (true) {
                        int n3;
                        int z;
                        if ((z = aabb.minZ()) <= (n3 = aabb.maxZ())) {
                            while (true) {
                                callback.invoke((Object)new class_2338(x, y, z));
                                if (z == n3) break;
                                ++z;
                            }
                        }
                        if (y == n2) break;
                        ++y;
                    }
                }
                if (x == n) break;
                ++x;
            }
        }
    }

    public static final void teleport(@NotNull ServerShip $this$teleport, @NotNull class_3218 level, @NotNull Vector3dc newPos) {
        Intrinsics.checkNotNullParameter((Object)$this$teleport, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)newPos, (String)"newPos");
        VsiServerShipWorld vsiServerShipWorld = VSGameUtilsKt.getShipObjectWorld((class_3218)level);
        Quaterniond quaterniond = $this$teleport.getWorldToShip().getNormalizedRotation(new Quaterniond());
        Intrinsics.checkNotNullExpressionValue((Object)quaterniond, (String)"getNormalizedRotation(...)");
        vsiServerShipWorld.teleportShip($this$teleport, (ShipTeleportData)new ShipTeleportDataImpl(newPos, (Quaterniondc)quaterniond, null, null, null, null, null, 124, null));
    }

    @NotNull
    public static final class_2382 getTemplateSize(@NotNull Ship $this$getTemplateSize) {
        Intrinsics.checkNotNullParameter((Object)$this$getTemplateSize, (String)"<this>");
        AABBic aABBic = $this$getTemplateSize.getShipAABB();
        Intrinsics.checkNotNull((Object)aABBic);
        AABBic it = aABBic;
        boolean bl = false;
        return new class_2382(it.maxX() - it.minX() + 2, it.maxY() - it.minY() + 2, it.maxZ() - it.minZ() + 2);
    }

    @NotNull
    public static final class_2338 getTemplateCorner(@NotNull Ship $this$getTemplateCorner) {
        Intrinsics.checkNotNullParameter((Object)$this$getTemplateCorner, (String)"<this>");
        AABBic aABBic = $this$getTemplateCorner.getShipAABB();
        Intrinsics.checkNotNull((Object)aABBic);
        AABBic it = aABBic;
        boolean bl = false;
        return new class_2338(it.minX() - 1, it.minY() - 1, it.minZ() - 1);
    }

    @NotNull
    public static final NamedStructureTemplate getTemplate(@NotNull ServerShip $this$getTemplate, @NotNull class_2960 name, @NotNull class_3218 level) {
        Intrinsics.checkNotNullParameter((Object)$this$getTemplate, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Object it = level.method_14183().method_15091(name);
        boolean bl = false;
        it.method_15174((class_1937)level, ShipExtKt.getTemplateCorner((Ship)$this$getTemplate), ShipExtKt.getTemplateSize((Ship)$this$getTemplate), false, class_2246.field_10124);
        Intrinsics.checkNotNull((Object)it);
        NamedStructureTemplate namedStructureTemplate = new NamedStructureTemplate((class_3499)it, name);
        it = namedStructureTemplate;
        boolean bl2 = false;
        StructureTemplateInternalExtKt.saveAdditional(((NamedStructureTemplate)it).getTemplate(), new VLibStructureData(true));
        return namedStructureTemplate;
    }

    @NotNull
    public static final NamedStructureTemplate saveToTemplate(@NotNull ServerShip $this$saveToTemplate, @NotNull class_2960 name, @NotNull class_3218 level) {
        NamedStructureTemplate namedStructureTemplate;
        Intrinsics.checkNotNullParameter((Object)$this$saveToTemplate, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        NamedStructureTemplate it = namedStructureTemplate = ShipExtKt.getTemplate($this$saveToTemplate, name, level);
        boolean bl = false;
        level.method_14183().method_15093(name);
        return namedStructureTemplate;
    }

    public static final void discard(@NotNull ServerShip $this$discard, @NotNull class_3218 level) {
        Intrinsics.checkNotNullParameter((Object)$this$discard, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        VSGameUtilsKt.getShipObjectWorld((class_3218)level).deleteShip($this$discard);
    }
}

