/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_117$class_118
 *  net.minecraft.class_1299
 *  net.minecraft.class_141
 *  net.minecraft.class_1802
 *  net.minecraft.class_190
 *  net.minecraft.class_1935
 *  net.minecraft.class_2022$class_2023
 *  net.minecraft.class_2040$class_2041
 *  net.minecraft.class_2048$class_2049
 *  net.minecraft.class_215
 *  net.minecraft.class_221
 *  net.minecraft.class_39
 *  net.minecraft.class_44
 *  net.minecraft.class_47$class_50
 *  net.minecraft.class_52
 *  net.minecraft.class_5321
 *  net.minecraft.class_55
 *  net.minecraft.class_5658
 *  net.minecraft.class_5662
 *  net.minecraft.class_6862
 *  net.minecraft.class_73
 *  net.minecraft.class_77
 *  net.minecraft.class_79$class_80
 *  net.minecraft.class_8103
 *  net.minecraft.class_8129
 */
package backported.updates.content.common;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModItems;
import backported.updates.content.core.VanillaBackport;
import backported.updates.foundation.common.data.LootModifier;
import java.util.List;
import net.minecraft.class_117;
import net.minecraft.class_1299;
import net.minecraft.class_141;
import net.minecraft.class_1802;
import net.minecraft.class_190;
import net.minecraft.class_1935;
import net.minecraft.class_2022;
import net.minecraft.class_2040;
import net.minecraft.class_2048;
import net.minecraft.class_215;
import net.minecraft.class_221;
import net.minecraft.class_39;
import net.minecraft.class_44;
import net.minecraft.class_47;
import net.minecraft.class_52;
import net.minecraft.class_5321;
import net.minecraft.class_55;
import net.minecraft.class_5658;
import net.minecraft.class_5662;
import net.minecraft.class_6862;
import net.minecraft.class_73;
import net.minecraft.class_77;
import net.minecraft.class_79;
import net.minecraft.class_8103;
import net.minecraft.class_8129;

public class LootIntegrations
implements LootModifier.LootTableModifier {
    private static final List<class_5321<class_52>> CONTAIN_BUNDLE = List.of(class_39.field_434, class_39.field_16751, class_39.field_16750, class_39.field_16748, class_39.field_16749, class_39.field_16753, class_39.field_16754, class_39.field_16752);

    @Override
    public void modify(class_5321<class_52> key, LootModifier.LootTableContext context, boolean builtin) {
        if (key.equals((Object)class_1299.field_6107.method_16351()) && VanillaBackport.COMMON_CONFIG.hasTearsMusicDisc.get().booleanValue()) {
            context.addPool(class_55.method_347().method_352((class_5658)class_44.method_32448((float)1.0f)).method_351((class_79.class_80)class_77.method_411((class_1935)((class_1935)ModItems.MUSIC_DISC_TEARS.get()))).method_353((class_117.class_118)class_141.method_621((class_5658)class_44.method_32448((float)1.0f))).method_356(class_190.method_837((class_2022.class_2023)class_2022.class_2023.method_8855().method_48785(class_8129.method_48965((class_6862)class_8103.field_42247)).method_8854(class_2048.class_2049.method_8916().method_8921(class_1299.field_6066)))).method_356(class_221.method_939()));
        }
        if (key.equals((Object)class_39.field_22402) && VanillaBackport.COMMON_CONFIG.hasDriedGhasts.get().booleanValue()) {
            context.addToPool(class_77.method_411((class_1935)((class_1935)ModBlocks.DRIED_GHAST.get())).method_437(10).method_438((class_117.class_118)class_141.method_621((class_5658)class_44.method_32448((float)1.0f))).method_419());
        }
        if (key.equals((Object)class_1299.field_6051.method_16351())) {
            context.addPool(class_55.method_347().method_351((class_79.class_80)class_77.method_411((class_1935)((class_1935)ModItems.MUSIC_DISC_LAVA_CHICKEN.get()))).method_356(class_221.method_939()).method_356(class_215.method_917((class_47.class_50)class_47.class_50.field_935, (class_2048.class_2049)class_2048.class_2049.method_8916().method_8919(class_2040.class_2041.method_8897().method_29935(Boolean.valueOf(true))).method_27971(class_2048.class_2049.method_8916().method_8921(class_1299.field_6132)))));
        }
        if (key.equals((Object)class_39.field_484) && VanillaBackport.COMMON_CONFIG.hasResinLoot.get().booleanValue()) {
            context.addToPool(1, class_77.method_411((class_1935)((class_1935)ModBlocks.RESIN_CLUMP.get())).method_437(50).method_438((class_117.class_118)class_141.method_621((class_5658)class_5662.method_32462((float)2.0f, (float)4.0f))).method_419());
        }
        if (CONTAIN_BUNDLE.contains(key) && VanillaBackport.COMMON_CONFIG.hadBundleLoot.get().booleanValue()) {
            context.addPool(class_55.method_347().method_352((class_5658)class_44.method_32448((float)1.0f)).method_351((class_79.class_80)class_77.method_411((class_1935)class_1802.field_27023).method_437(1).method_438((class_117.class_118)class_141.method_621((class_5658)class_44.method_32448((float)1.0f)))).method_351((class_79.class_80)class_73.method_401().method_437(2)));
        }
        if (key.equals((Object)class_39.field_24050) && VanillaBackport.COMMON_CONFIG.hasLodestoneLoot.get().booleanValue()) {
            context.addPool(class_55.method_347().method_352((class_5658)class_44.method_32448((float)1.0f)).method_351((class_79.class_80)class_77.method_411((class_1935)class_1802.field_23256).method_437(2).method_438((class_117.class_118)class_141.method_621((class_5658)class_5662.method_32462((float)1.0f, (float)2.0f)))).method_351((class_79.class_80)class_73.method_401().method_437(1)));
        }
    }
}

