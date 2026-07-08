/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.world.World
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.nbt.NbtList
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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityType.class})
public class EntityRemapMixin {
    @Unique
    private static final String OLD_NAMESPACE = "copperagebackport:";
    @Unique
    private static final String NEW_NAMESPACE = "minecraft:";

    @Inject(method={"loadEntityWithPassengers"}, at={@At(value="HEAD")})
    private static void copperagebackport$remapEntityCompound(NbtCompound compound, World level, Function<Entity, Entity> function, CallbackInfoReturnable<Entity> cir) {
        String id;
        String remapped;
        if (compound == null) {
            return;
        }
        if (compound.contains("id", 8) && (remapped = EntityRemapMixin.copperagebackport$remapId(id = compound.getString("id"), "Entity")) != null) {
            compound.putString("id", remapped);
        }
        if (compound.contains("Item", 10)) {
            NbtCompound item = compound.getCompound("Item");
            EntityRemapMixin.copperagebackport$remapItemTag(item, "ItemFrame");
        }
        EntityRemapMixin.copperagebackport$remapEquipment(compound, "ArmorItems");
        EntityRemapMixin.copperagebackport$remapEquipment(compound, "HandItems");
    }

    @Unique
    private static void copperagebackport$remapItemTag(NbtCompound item, String context) {
        String id;
        String remapped;
        if (item == null) {
            return;
        }
        if (item.contains("id", 8) && (remapped = EntityRemapMixin.copperagebackport$remapId(id = item.getString("id"), context)) != null) {
            item.putString("id", remapped);
        }
    }

    @Unique
    private static void copperagebackport$remapEquipment(NbtCompound entity, String tagName) {
        if (!entity.contains(tagName, 9)) {
            return;
        }
        NbtList items = entity.getList(tagName, 10);
        for (int i = 0; i < items.size(); ++i) {
            NbtCompound item = items.getCompound(i);
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

