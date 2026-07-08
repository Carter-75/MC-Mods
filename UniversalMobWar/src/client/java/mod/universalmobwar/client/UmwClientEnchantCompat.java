package mod.universalmobwar.client;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.net.UmwClientEnchantmentsPayload;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.ArrayList;
import java.util.List;

public final class UmwClientEnchantCompat {

    private UmwClientEnchantCompat() {
    }

    public static void init() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            try {
                Registry<Enchantment> enchantRegistry = handler.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
                List<Identifier> ids = new ArrayList<>(enchantRegistry.keySet());
                ClientPlayNetworking.send(new UmwClientEnchantmentsPayload(ids));
            } catch (Exception e) {
                UniversalMobWarMod.LOGGER.warn("[EnchantCompat] Failed to send client enchantment list", e);
            }
        });
    }
}
