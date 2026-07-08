/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap$Builder
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_2960
 */
package backported.updates.content.client.level.entities.layer;

import backported.updates.content.common.registries.ModItems;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_2960;

@Environment(value=EnvType.CLIENT)
public class GhastHarnessLayer {
    public static final Map<class_1799, class_2960> TEXTURE_BY_ITEM = new ImmutableMap.Builder().put((Object)new class_1799((class_1935)ModItems.WHITE_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/white_harness.png")).put((Object)new class_1799((class_1935)ModItems.ORANGE_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/orange_harness.png")).put((Object)new class_1799((class_1935)ModItems.MAGENTA_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/magenta_harness.png")).put((Object)new class_1799((class_1935)ModItems.LIGHT_BLUE_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/light_blue_harness.png")).put((Object)new class_1799((class_1935)ModItems.YELLOW_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/yellow_harness.png")).put((Object)new class_1799((class_1935)ModItems.LIME_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/lime_harness.png")).put((Object)new class_1799((class_1935)ModItems.PINK_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/pink_harness.png")).put((Object)new class_1799((class_1935)ModItems.GRAY_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/gray_harness.png")).put((Object)new class_1799((class_1935)ModItems.LIGHT_GRAY_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/light_gray_harness.png")).put((Object)new class_1799((class_1935)ModItems.CYAN_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/cyan_harness.png")).put((Object)new class_1799((class_1935)ModItems.PURPLE_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/purple_harness.png")).put((Object)new class_1799((class_1935)ModItems.BLUE_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/blue_harness.png")).put((Object)new class_1799((class_1935)ModItems.BROWN_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/brown_harness.png")).put((Object)new class_1799((class_1935)ModItems.GREEN_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/green_harness.png")).put((Object)new class_1799((class_1935)ModItems.RED_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/red_harness.png")).put((Object)new class_1799((class_1935)ModItems.BLACK_HARNESS.get()), (Object)class_2960.method_60656((String)"textures/entity/ghast/harness/black_harness.png")).build();
}

