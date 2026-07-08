/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1271
 *  net.minecraft.class_1297
 *  net.minecraft.class_1301
 *  net.minecraft.class_1657
 *  net.minecraft.class_1690
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_3468
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3965
 *  net.minecraft.class_5712
 *  net.minecraft.class_6880
 */
package backported.updates.content.common.level.items;

import backported.updates.content.common.level.boat.PaleOakBoat;
import backported.updates.content.common.level.boat.PaleOakChestBoat;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1297;
import net.minecraft.class_1301;
import net.minecraft.class_1657;
import net.minecraft.class_1690;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3468;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_5712;
import net.minecraft.class_6880;

public class PaleOakBoatItem
extends class_1792 {
    private static final Predicate<class_1297> ENTITY_PREDICATE = class_1301.field_6155.and(class_1297::method_5863);
    private final boolean hasChest;

    public PaleOakBoatItem(boolean hasChest, class_1792.class_1793 properties) {
        super(properties);
        this.hasChest = hasChest;
    }

    public class_1271<class_1799> method_7836(class_1937 level, class_1657 player, class_1268 hand) {
        class_1799 heldStack = player.method_5998(hand);
        class_3965 hitResult = PaleOakBoatItem.method_7872((class_1937)level, (class_1657)player, (class_3959.class_242)class_3959.class_242.field_1347);
        if (hitResult.method_17783() == class_239.class_240.field_1333) {
            return class_1271.method_22430((Object)heldStack);
        }
        class_243 viewVector = player.method_5828(1.0f);
        List list = level.method_8333((class_1297)player, player.method_5829().method_18804(viewVector.method_1021(5.0)).method_1014(1.0), ENTITY_PREDICATE);
        if (!list.isEmpty()) {
            class_243 eyePosition = player.method_33571();
            for (class_1297 entity : list) {
                class_238 aabb = entity.method_5829().method_1014((double)entity.method_5871());
                if (!aabb.method_1006(eyePosition)) continue;
                return class_1271.method_22430((Object)heldStack);
            }
        }
        if (hitResult.method_17783() == class_239.class_240.field_1332) {
            class_1690 boat = this.getBoat(level, (class_239)hitResult);
            boat.method_36456(player.method_36454());
            if (!level.method_8587((class_1297)boat, boat.method_5829())) {
                return class_1271.method_22431((Object)heldStack);
            }
            if (!level.method_8608()) {
                level.method_8649((class_1297)boat);
                level.method_33596((class_1297)player, (class_6880)class_5712.field_28738, class_2338.method_49638((class_2374)hitResult.method_17784()));
                if (!player.method_31549().field_7477) {
                    heldStack.method_7934(1);
                }
            }
            player.method_7259(class_3468.field_15372.method_14956((Object)this));
            return class_1271.method_29237((Object)heldStack, (boolean)level.method_8608());
        }
        return class_1271.method_22430((Object)heldStack);
    }

    private class_1690 getBoat(class_1937 level, class_239 hitResult) {
        return this.hasChest ? new PaleOakChestBoat(level, hitResult.method_17784().field_1352, hitResult.method_17784().field_1351, hitResult.method_17784().field_1350) : new PaleOakBoat(level, hitResult.method_17784().field_1352, hitResult.method_17784().field_1351, hitResult.method_17784().field_1350);
    }
}

