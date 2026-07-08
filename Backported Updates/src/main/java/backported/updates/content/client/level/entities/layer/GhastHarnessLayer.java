/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap$Builder
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.util.Identifier
 */
package backported.updates.content.client.level.entities.layer;

import backported.updates.content.common.registries.ModItems;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class GhastHarnessLayer {
    public static final Map<ItemStack, Identifier> TEXTURE_BY_ITEM = new ImmutableMap.Builder().put(new ItemStack((ItemConvertible)ModItems.WHITE_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/white_harness.png")).put(new ItemStack((ItemConvertible)ModItems.ORANGE_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/orange_harness.png")).put(new ItemStack((ItemConvertible)ModItems.MAGENTA_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/magenta_harness.png")).put(new ItemStack((ItemConvertible)ModItems.LIGHT_BLUE_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/light_blue_harness.png")).put(new ItemStack((ItemConvertible)ModItems.YELLOW_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/yellow_harness.png")).put(new ItemStack((ItemConvertible)ModItems.LIME_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/lime_harness.png")).put(new ItemStack((ItemConvertible)ModItems.PINK_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/pink_harness.png")).put(new ItemStack((ItemConvertible)ModItems.GRAY_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/gray_harness.png")).put(new ItemStack((ItemConvertible)ModItems.LIGHT_GRAY_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/light_gray_harness.png")).put(new ItemStack((ItemConvertible)ModItems.CYAN_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/cyan_harness.png")).put(new ItemStack((ItemConvertible)ModItems.PURPLE_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/purple_harness.png")).put(new ItemStack((ItemConvertible)ModItems.BLUE_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/blue_harness.png")).put(new ItemStack((ItemConvertible)ModItems.BROWN_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/brown_harness.png")).put(new ItemStack((ItemConvertible)ModItems.GREEN_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/green_harness.png")).put(new ItemStack((ItemConvertible)ModItems.RED_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/red_harness.png")).put(new ItemStack((ItemConvertible)ModItems.BLACK_HARNESS.get()), Identifier.ofVanilla((String)"textures/entity/ghast/harness/black_harness.png")).build();
}

