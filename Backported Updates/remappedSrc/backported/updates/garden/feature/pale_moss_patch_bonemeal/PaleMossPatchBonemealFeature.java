/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2680
 *  net.minecraft.class_2960
 *  net.minecraft.class_3031
 *  net.minecraft.class_3481
 *  net.minecraft.class_5281
 *  net.minecraft.class_5821
 *  net.minecraft.class_7923
 */
package backported.updates.garden.feature.pale_moss_patch_bonemeal;

import backported.updates.garden.feature.pale_moss_patch_bonemeal.PaleMossPatchBonemealConfig;
import com.mojang.serialization.Codec;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_3031;
import net.minecraft.class_3481;
import net.minecraft.class_5281;
import net.minecraft.class_5821;
import net.minecraft.class_7923;

public class PaleMossPatchBonemealFeature
extends class_3031<PaleMossPatchBonemealConfig> {
    public PaleMossPatchBonemealFeature(Codec<PaleMossPatchBonemealConfig> configCodec) {
        super(configCodec);
    }

    public boolean method_13151(class_5821<PaleMossPatchBonemealConfig> context) {
        class_5281 world = context.method_33652();
        class_2338 origin = context.method_33655();
        PaleMossPatchBonemealConfig config = (PaleMossPatchBonemealConfig)context.method_33656();
        int number = config.number();
        class_2960 blockId = config.blockId();
        class_2680 blockState = ((class_2248)class_7923.field_41175.method_10223(blockId)).method_9564();
        if (blockState == null) {
            throw new IllegalStateException(String.valueOf(blockId) + " could not be parsed to a valid block identifier!");
        }
        class_2338 testPos = new class_2338((class_2382)origin);
        for (int y = 0; y < world.method_31605(); ++y) {
            if (!world.method_8320(testPos = testPos.method_10084()).method_26164(class_3481.field_29822) || !world.method_8320(testPos.method_10084()).method_27852(class_2246.field_10124)) continue;
            for (int i = 0; i < number; ++i) {
                world.method_8652(testPos, blockState, 16);
                testPos = testPos.method_10084();
                if (testPos.method_10264() >= world.method_31600()) break;
            }
            return true;
        }
        return false;
    }
}

