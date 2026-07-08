/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1838
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2323
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_3417
 */
package net._void.civilizations.item.custom;

import net._void.civilizations.block.ModBlocks;
import net._void.civilizations.entity.custom.EgyptBossEntity;
import net._void.civilizations.util.ModTags;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1792;
import net.minecraft.class_1838;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2323;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3417;

public class EgyptKey
extends class_1792 {
    public EgyptKey(class_1792.class_1793 settings) {
        super(settings);
    }

    public class_1269 method_7884(class_1838 context) {
        class_1269 r = class_1269.field_5814;
        if (!context.method_8045().method_8608()) {
            class_2338 positionClicked = context.method_8037();
            class_2680 state = context.method_8045().method_8320(positionClicked);
            if (state.method_26164(ModTags.Blocks.EGYPT_KEY_OPENABLE)) {
                if (state.method_26204().equals(ModBlocks.COFFIN_TOP) || state.method_26204().equals(ModBlocks.COFFIN_BOTTOM)) {
                    int x = positionClicked.method_10263();
                    int y = positionClicked.method_10264();
                    int z = positionClicked.method_10260();
                    for (int i = -2; i <= 2; ++i) {
                        for (int j = -2; j <= 2; ++j) {
                            context.method_8045().method_8501(new class_2338(x + i, y, z + j), class_2246.field_10124.method_9564());
                        }
                    }
                    EgyptBossEntity customEntity = (EgyptBossEntity)((class_1299)class_1299.method_5898((String)"civilizations:egypt_boss").get()).method_5883(context.method_8045());
                    customEntity.method_30634((double)positionClicked.method_10263() + 0.5, (double)positionClicked.method_10264() + 0.5, (double)positionClicked.method_10260() + 0.5);
                    context.method_8045().method_8649((class_1297)customEntity);
                } else {
                    class_2248 block = state.method_26204();
                    class_2323 door = (class_2323)block;
                    door.method_10033((class_1297)context.method_8036(), context.method_8045(), state, positionClicked, !door.method_30841(state));
                }
                r = class_1269.field_5812;
            }
        } else if (context.method_8036() != null) {
            class_2338 positionClicked = context.method_8037();
            class_2680 state = context.method_8045().method_8320(positionClicked);
            if (state.method_26164(ModTags.Blocks.EGYPT_KEY_OPENABLE)) {
                context.method_8036().method_5783(class_3417.field_14567, 1.0f, 1.0f);
            }
        }
        return r;
    }
}

