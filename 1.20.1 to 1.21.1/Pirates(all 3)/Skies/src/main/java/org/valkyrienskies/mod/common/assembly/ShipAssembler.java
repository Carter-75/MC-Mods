/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin._Assertions
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.server.MinecraftServer
 */
package org.valkyrienskies.mod.common.assembly;

import java.util.List;
import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.internal.VsiCore;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import org.valkyrienskies.mod.common.BlockStateInfo;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.assembly.AssemblyUtil;
import org.valkyrienskies.mod.common.util.SplittingDisablerAttachment;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ5\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\r\u00a2\u0006\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2={"Lorg/valkyrienskies/mod/common/assembly/ShipAssembler;", "", "Lnet/minecraft/class_1937;", "level", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_2680;", "prevState", "newState", "", "triggerBlockChange", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;Lnet/minecraft/class_2680;)V", "state", "", "isValidShipBlock", "(Lnet/minecraft/class_2680;)Z", "", "blocks", "removeOriginal", "", "scale", "shouldDisableSplitting", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "assembleToShip", "(Lnet/minecraft/class_1937;Ljava/util/List;ZDZ)Lorg/valkyrienskies/core/api/ships/ServerShip;", "<init>", "()V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nShipAssembler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShipAssembler.kt\norg/valkyrienskies/mod/common/assembly/ShipAssembler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n1#2:141\n*E\n"})
public final class ShipAssembler {
    @NotNull
    public static final ShipAssembler INSTANCE = new ShipAssembler();

    private ShipAssembler() {
    }

    public final void triggerBlockChange(@Nullable class_1937 level, @Nullable class_2338 pos, @Nullable class_2680 prevState, @Nullable class_2680 newState) {
        class_1937 class_19372 = level;
        Intrinsics.checkNotNull((Object)class_19372);
        class_2338 class_23382 = pos;
        Intrinsics.checkNotNull((Object)class_23382);
        class_2680 class_26802 = prevState;
        Intrinsics.checkNotNull((Object)class_26802);
        class_2680 class_26803 = newState;
        Intrinsics.checkNotNull((Object)class_26803);
        BlockStateInfo.INSTANCE.onSetBlock(class_19372, class_23382, class_26802, class_26803);
    }

    public final boolean isValidShipBlock(@Nullable class_2680 state) {
        if (state != null) {
            return !state.method_26215();
        }
        return true;
    }

    @NotNull
    public final ServerShip assembleToShip(@NotNull class_1937 level, @NotNull List<? extends class_2338> blocks, boolean removeOriginal, double scale, boolean shouldDisableSplitting) {
        ServerShip newShip;
        block18: {
            Object object;
            class_2338 shipPos;
            class_2338 relative;
            Object object2;
            Vector3i vector3i;
            Object v0;
            class_3218 class_32182;
            class_3218 sLevel;
            block17: {
                Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                Intrinsics.checkNotNullParameter(blocks, (String)"blocks");
                boolean bl = level instanceof class_3218;
                if (_Assertions.ENABLED && !bl) {
                    boolean $i$a$-assert-ShipAssembler$assembleToShip$232 = false;
                    String $i$a$-assert-ShipAssembler$assembleToShip$232 = "Can't create ships clientside!";
                    throw new AssertionError((Object)$i$a$-assert-ShipAssembler$assembleToShip$232);
                }
                sLevel = (class_3218)level;
                if (blocks.isEmpty()) {
                    throw new IllegalArgumentException("No blocks to assemble.");
                }
                Iterable iterable = blocks;
                class_32182 = sLevel;
                Iterable iterable2 = iterable;
                for (Object t : iterable2) {
                    class_2338 it = (class_2338)t;
                    boolean bl2 = false;
                    if (!(!sLevel.method_8320(it).method_26215())) continue;
                    v0 = t;
                    break block17;
                }
                v0 = null;
            }
            class_2338 class_23382 = v0;
            if (class_23382 == null) {
                throw new IllegalArgumentException("Existing ship");
            }
            LoadedServerShip existingShip = VSGameUtilsKt.getLoadedShipManagingPos(class_32182, (class_2382)class_23382);
            class_2338 structureCornerMin = null;
            class_2338 structureCornerMax = null;
            boolean hasSolids = false;
            for (class_2338 class_23383 : blocks) {
                if (!this.isValidShipBlock(((class_3218)level).method_8320(class_23383))) continue;
                if (structureCornerMin == null) {
                    structureCornerMin = class_23383;
                    structureCornerMax = class_23383;
                } else {
                    structureCornerMin = AssemblyUtil.INSTANCE.getMinCorner(structureCornerMin, class_23383);
                    class_2338 class_23384 = structureCornerMax;
                    Intrinsics.checkNotNull((Object)class_23384);
                    structureCornerMax = AssemblyUtil.INSTANCE.getMaxCorner(class_23384, class_23383);
                }
                hasSolids = true;
            }
            if (!hasSolids) {
                throw new IllegalArgumentException("No solid blocks found in the structure");
            }
            class_2338 class_23385 = structureCornerMin;
            Intrinsics.checkNotNull(class_23385);
            class_2338 class_23386 = structureCornerMax;
            Intrinsics.checkNotNull(class_23386);
            Vector3ic contraptionOGPos = AssemblyUtil.INSTANCE.getMiddle(class_23385, class_23386);
            if (existingShip != null) {
                Vector3d vector3d = existingShip.getShipToWorld().transformPosition(new Vector3d(contraptionOGPos));
                Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"transformPosition(...)");
                class_2338 doubleVer = class_2338.method_49638((class_2374)((class_2374)ValkyrienSkies.toMinecraft(vector3d)));
                vector3i = new Vector3i(doubleVer.method_10263(), doubleVer.method_10264(), doubleVer.method_10260());
            } else {
                vector3i = new Vector3i(contraptionOGPos);
            }
            Vector3i vector3i2 = vector3i;
            MinecraftServer minecraftServer = ((class_3218)level).method_8503();
            Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
            newShip = VSGameUtilsKt.getShipObjectWorld(minecraftServer).createNewShipAtBlock(vector3i2, false, scale, VSGameUtilsKt.getDimensionId(level));
            if (shouldDisableSplitting && (object2 = (LoadedServerShip)VSGameUtilsKt.getShipObjectWorld((class_3218)level).getLoadedShips().getById(newShip.getId())) != null && (object2 = object2.getAttachment(SplittingDisablerAttachment.class)) != null) {
                ((SplittingDisablerAttachment)object2).disableSplitting();
            }
            Matrix4dc matrix4dc = newShip.getWorldToShip();
            class_243 class_2432 = new class_2338(vector3i2.x, vector3i2.y, vector3i2.z).method_46558();
            Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"getCenter(...)");
            Vector3d contraptionShipPos = matrix4dc.transformPosition(ValkyrienSkies.toJOML(class_2432));
            class_2338 contraptionBlockPos = class_2338.method_49637((double)contraptionShipPos.x, (double)contraptionShipPos.y, (double)contraptionShipPos.z);
            boolean centerBlockReplaced = false;
            for (class_2338 class_23387 : blocks) {
                if (!this.isValidShipBlock(((class_3218)level).method_8320(class_23387))) continue;
                Intrinsics.checkNotNullExpressionValue((Object)class_23387.method_10059((class_2382)new class_2338(contraptionOGPos.x(), contraptionOGPos.y(), contraptionOGPos.z())), (String)"subtract(...)");
                Intrinsics.checkNotNullExpressionValue((Object)contraptionBlockPos.method_10081((class_2382)relative), (String)"offset(...)");
                AssemblyUtil.INSTANCE.copyBlock(level, class_23387, shipPos);
                if (!relative.equals((Object)class_2338.field_10980)) continue;
                centerBlockReplaced = true;
            }
            if (removeOriginal) {
                for (class_2338 class_23388 : blocks) {
                    if (!this.isValidShipBlock(((class_3218)level).method_8320(class_23388))) continue;
                    AssemblyUtil.INSTANCE.removeBlock(level, class_23388);
                }
            }
            for (class_2338 class_23389 : blocks) {
                Intrinsics.checkNotNullExpressionValue((Object)class_23389.method_10059((class_2382)new class_2338(contraptionOGPos.x(), contraptionOGPos.y(), contraptionOGPos.z())), (String)"subtract(...)");
                Intrinsics.checkNotNullExpressionValue((Object)contraptionBlockPos.method_10081((class_2382)relative), (String)"offset(...)");
                class_2680 class_26802 = ((class_3218)level).method_8320(shipPos);
                Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"getBlockState(...)");
                AssemblyUtil.INSTANCE.updateBlock(level, class_23389, shipPos, class_26802);
            }
            class_243 class_2433 = new class_2338(contraptionOGPos.x(), contraptionOGPos.y(), contraptionOGPos.z()).method_46558();
            Intrinsics.checkNotNullExpressionValue((Object)class_2433, (String)"getCenter(...)");
            Vector3d shipPos2 = ValkyrienSkies.toJOML(class_2433);
            if (existingShip != null) {
                MinecraftServer minecraftServer2 = sLevel.method_8503();
                Intrinsics.checkNotNullExpressionValue((Object)minecraftServer2, (String)"getServer(...)");
                VsiServerShipWorld vsiServerShipWorld = VSGameUtilsKt.getShipObjectWorld(minecraftServer2);
                VsiCore vsiCore = VSGameUtilsKt.getVsCore();
                Vector3d vector3d = existingShip.getShipToWorld().transformPosition(shipPos2, new Vector3d());
                Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"transformPosition(...)");
                vsiServerShipWorld.teleportShip(newShip, VsiCore.newShipTeleportData$default(vsiCore, vector3d, existingShip.getTransform().getShipToWorldRotation(), existingShip.getVelocity(), existingShip.getOmega(), existingShip.getChunkClaimDimension(), existingShip.getTransform().getShipToWorldScaling().x(), null, 64, null));
            } else {
                MinecraftServer minecraftServer3 = sLevel.method_8503();
                Intrinsics.checkNotNullExpressionValue((Object)minecraftServer3, (String)"getServer(...)");
                VSGameUtilsKt.getShipObjectWorld(minecraftServer3).teleportShip(newShip, VsiCore.newShipTeleportData$default(VSGameUtilsKt.getVsCore(), shipPos2, null, null, null, null, null, null, 126, null));
            }
            if (!shouldDisableSplitting || (object = (LoadedServerShip)VSGameUtilsKt.getShipObjectWorld((class_3218)level).getLoadedShips().getById(newShip.getId())) == null || (object = object.getAttachment(SplittingDisablerAttachment.class)) == null) break block18;
            ((SplittingDisablerAttachment)object).enableSplitting();
        }
        return newShip;
    }

    public static /* synthetic */ ServerShip assembleToShip$default(ShipAssembler shipAssembler, class_1937 class_19372, List list, boolean bl, double d2, boolean bl2, int n2, Object object) {
        if ((n2 & 8) != 0) {
            d2 = 1.0;
        }
        if ((n2 & 0x10) != 0) {
            bl2 = false;
        }
        return shipAssembler.assembleToShip(class_19372, list, bl, d2, bl2);
    }
}

