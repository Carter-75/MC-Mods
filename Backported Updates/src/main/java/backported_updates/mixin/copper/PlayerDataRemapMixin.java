/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.nbt.NbtList
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.copper;

import backported.updates.copper.Constants;
import backported.updates.copper.registry.RegistryHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={PlayerEntity.class})
public class PlayerDataRemapMixin {
    @Unique
    private static final String OLD_NAMESPACE = "copperagebackport:";
    @Unique
    private static final String NEW_NAMESPACE = "minecraft:";

    @Inject(method={"readCustomDataFromNbt"}, at={@At(value="HEAD")})
    private void copperagebackport$remapPlayerData(NbtCompound tag, CallbackInfo ci) {
        if (tag == null) {
            return;
        }
        if (tag.contains("Inventory", 9)) {
            NbtList inventory = tag.getList("Inventory", 10);
            PlayerDataRemapMixin.copperagebackport$remapItemList(inventory);
        }
        if (tag.contains("EnderItems", 9)) {
            NbtList enderItems = tag.getList("EnderItems", 10);
            PlayerDataRemapMixin.copperagebackport$remapItemList(enderItems);
        }
    }

    @Unique
    private static void copperagebackport$remapItemList(NbtList items) {
        for (int i = 0; i < items.size(); ++i) {
            String id;
            String remapped;
            NbtCompound item = items.getCompound(i);
            if (!item.contains("id", 8) || (remapped = PlayerDataRemapMixin.copperagebackport$remapId(id = item.getString("id"), "PlayerItem")) == null) continue;
            item.putString("id", remapped);
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

