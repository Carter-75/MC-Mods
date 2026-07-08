/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1937
 *  net.minecraft.class_2487
 *  net.minecraft.class_2499
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.copper;

import backported.updates.copper.Constants;
import backported.updates.copper.registry.RegistryHelper;
import java.util.function.Function;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1937;
import net.minecraft.class_2487;
import net.minecraft.class_2499;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1299.class})
public class EntityRemapMixin {
    @Unique
    private static final String OLD_NAMESPACE = "copperagebackport:";
    @Unique
    private static final String NEW_NAMESPACE = "minecraft:";

    @Inject(method={"loadEntityRecursive(Lnet/minecraft/nbt/CompoundTag;Lnet/minecraft/world/level/Level;Ljava/util/function/Function;)Lnet/minecraft/world/entity/Entity;"}, at={@At(value="HEAD")})
    private static void copperagebackport$remapEntityCompound(class_2487 compound, class_1937 level, Function<class_1297, class_1297> function, CallbackInfoReturnable<class_1297> cir) {
        String id;
        String remapped;
        if (compound == null) {
            return;
        }
        if (compound.method_10573("id", 8) && (remapped = EntityRemapMixin.copperagebackport$remapId(id = compound.method_10558("id"), "Entity")) != null) {
            compound.method_10582("id", remapped);
        }
        if (compound.method_10573("Item", 10)) {
            class_2487 item = compound.method_10562("Item");
            EntityRemapMixin.copperagebackport$remapItemTag(item, "ItemFrame");
        }
        EntityRemapMixin.copperagebackport$remapEquipment(compound, "ArmorItems");
        EntityRemapMixin.copperagebackport$remapEquipment(compound, "HandItems");
    }

    @Unique
    private static void copperagebackport$remapItemTag(class_2487 item, String context) {
        String id;
        String remapped;
        if (item == null) {
            return;
        }
        if (item.method_10573("id", 8) && (remapped = EntityRemapMixin.copperagebackport$remapId(id = item.method_10558("id"), context)) != null) {
            item.method_10582("id", remapped);
        }
    }

    @Unique
    private static void copperagebackport$remapEquipment(class_2487 entity, String tagName) {
        if (!entity.method_10573(tagName, 9)) {
            return;
        }
        class_2499 items = entity.method_10554(tagName, 10);
        for (int i = 0; i < items.size(); ++i) {
            class_2487 item = items.method_10602(i);
            EntityRemapMixin.copperagebackport$remapItemTag(item, tagName);
        }
    }

    @Unique
    private static String copperagebackport$remapId(String id, String context) {
        if (id == null || !id.startsWith(OLD_NAMESPACE)) {
            return null;
        }
        String path = id.substring(OLD_NAMESPACE.length());
        if (RegistryHelper.VANILLA_BACKPORT_IDS.contains(path)) {
            String newId = NEW_NAMESPACE + path;
            Constants.LOG.info("[{}] Migrate legacy {} -> {}", new Object[]{context, id, newId});
            return newId;
        }
        return null;
    }
}

