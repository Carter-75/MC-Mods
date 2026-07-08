/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.AbstractContraptionEntity
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_3499$class_3501
 */
package org.valkyrienskies.mod.fabric.common;

import com.simibubi.create.content.contraptions.AbstractContraptionEntity;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3499;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4dc;
import org.valkyrienskies.core.api.ships.ContraptionWingProvider;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.Wing;
import org.valkyrienskies.core.api.ships.WingManager;
import org.valkyrienskies.mod.common.block.WingBlock;
import org.valkyrienskies.mod.common.entity.handling.AbstractShipyardEntityHandler;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2={"Lorg/valkyrienskies/mod/fabric/common/ContraptionShipyardEntityHandlerFabric;", "Lorg/valkyrienskies/mod/common/entity/handling/AbstractShipyardEntityHandler;", "Lnet/minecraft/class_1297;", "entity", "Lorg/valkyrienskies/core/api/ships/Ship;", "ship", "", "freshEntityInShipyard", "(Lnet/minecraft/class_1297;Lorg/valkyrienskies/core/api/ships/Ship;)V", "entityRemovedFromShipyard", "<init>", "()V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nContraptionShipyardEntityHandlerFabric.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContraptionShipyardEntityHandlerFabric.kt\norg/valkyrienskies/mod/fabric/common/ContraptionShipyardEntityHandlerFabric\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,41:1\n216#2,2:42\n*S KotlinDebug\n*F\n+ 1 ContraptionShipyardEntityHandlerFabric.kt\norg/valkyrienskies/mod/fabric/common/ContraptionShipyardEntityHandlerFabric\n*L\n20#1:42,2\n*E\n"})
public final class ContraptionShipyardEntityHandlerFabric
extends AbstractShipyardEntityHandler {
    @NotNull
    public static final ContraptionShipyardEntityHandlerFabric INSTANCE = new ContraptionShipyardEntityHandlerFabric();

    private ContraptionShipyardEntityHandlerFabric() {
    }

    @Override
    public void freshEntityInShipyard(@NotNull class_1297 entity, @NotNull Ship ship) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        if (entity instanceof AbstractContraptionEntity && ship instanceof LoadedServerShip) {
            ContraptionWingProvider cfr_ignored_0 = (ContraptionWingProvider)entity;
            WingManager wingManager = ((LoadedServerShip)ship).getWingManager();
            Intrinsics.checkNotNull((Object)wingManager);
            WingManager attachment = wingManager;
            ((ContraptionWingProvider)entity).setWingGroupId(attachment.createWingGroup(true));
            Map map2 = ((AbstractContraptionEntity)entity).getContraption().getBlocks();
            Intrinsics.checkNotNullExpressionValue((Object)map2, (String)"getBlocks(...)");
            Map $this$forEach$iv = map2;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry element$iv;
                Map.Entry entry = element$iv = iterator2.next();
                boolean bl = false;
                Object k2 = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(k2, (String)"component1(...)");
                class_2338 pos = (class_2338)k2;
                Object v = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(v, (String)"component2(...)");
                class_3499.class_3501 blockInfo = (class_3499.class_3501)v;
                class_2248 block = blockInfo.comp_1342().method_26204();
                if (!(block instanceof WingBlock)) continue;
                WingBlock wingBlock = (WingBlock)block;
                class_2680 class_26802 = blockInfo.comp_1342();
                Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"state(...)");
                Wing wing = wingBlock.getWing(null, null, class_26802);
                attachment.setWing(((ContraptionWingProvider)entity).getWingGroupId(), pos.method_10263(), pos.method_10264(), pos.method_10260(), wing);
            }
            Matrix4dc transform2 = ((ContraptionWingProvider)entity).computeContraptionWingTransform();
            attachment.setWingGroupTransform(((ContraptionWingProvider)entity).getWingGroupId(), transform2);
        }
    }

    @Override
    public void entityRemovedFromShipyard(@NotNull class_1297 entity, @NotNull Ship ship) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        if (entity instanceof AbstractContraptionEntity && ship instanceof LoadedServerShip) {
            ContraptionWingProvider cfr_ignored_0 = (ContraptionWingProvider)entity;
            WingManager wingManager = ((LoadedServerShip)ship).getWingManager();
            Intrinsics.checkNotNull((Object)wingManager);
            WingManager attachment = wingManager;
            attachment.deleteWingGroup(((ContraptionWingProvider)entity).getWingGroupId());
            ((ContraptionWingProvider)entity).setWingGroupId(-1);
        }
    }
}

