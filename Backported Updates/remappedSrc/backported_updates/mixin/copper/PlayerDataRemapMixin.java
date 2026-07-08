/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_2487
 *  net.minecraft.class_2499
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.copper;

import backported.updates.copper.Constants;
import backported.updates.copper.registry.RegistryHelper;
import net.minecraft.class_1657;
import net.minecraft.class_2487;
import net.minecraft.class_2499;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1657.class})
public class PlayerDataRemapMixin {
    @Unique
    private static final String OLD_NAMESPACE = "copperagebackport:";
    @Unique
    private static final String NEW_NAMESPACE = "minecraft:";

    @Inject(method={"readAdditionalSaveData"}, at={@At(value="HEAD")})
    private void copperagebackport$remapPlayerData(class_2487 tag, CallbackInfo ci) {
        if (tag == null) {
            return;
        }
        if (tag.method_10573("Inventory", 9)) {
            class_2499 inventory = tag.method_10554("Inventory", 10);
            PlayerDataRemapMixin.copperagebackport$remapItemList(inventory);
        }
        if (tag.method_10573("EnderItems", 9)) {
            class_2499 enderItems = tag.method_10554("EnderItems", 10);
            PlayerDataRemapMixin.copperagebackport$remapItemList(enderItems);
        }
    }

    @Unique
    private static void copperagebackport$remapItemList(class_2499 items) {
        for (int i = 0; i < items.size(); ++i) {
            String id;
            String remapped;
            class_2487 item = items.method_10602(i);
            if (!item.method_10573("id", 8) || (remapped = PlayerDataRemapMixin.copperagebackport$remapId(id = item.method_10558("id"), "PlayerItem")) == null) continue;
            item.method_10582("id", remapped);
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

