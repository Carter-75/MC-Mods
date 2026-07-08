/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 */
package backported.updates.copper.registry;

import backported.updates.copper.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_5321;

public abstract class RegistryHelper {
    public static final String MINECRAFT_NAMESPACE = "minecraft";
    private static RegistryHelper instance;
    public static final Set<String> VANILLA_BACKPORT_IDS;
    protected final List<Runnable> registrationCallbacks = new ArrayList<Runnable>();

    public static RegistryHelper getInstance() {
        if (instance == null) {
            throw new IllegalStateException("RegistryHelper not initialized!");
        }
        return instance;
    }

    public static void setInstance(RegistryHelper helper) {
        if (instance != null) {
            throw new IllegalStateException("RegistryHelper already initialized!");
        }
        instance = helper;
    }

    public abstract <T> Supplier<T> register(class_5321<? extends class_2378<? super T>> var1, String var2, Supplier<T> var3);

    public abstract <T> Supplier<T> registerWithNamespace(class_5321<? extends class_2378<? super T>> var1, String var2, String var3, Supplier<T> var4);

    public <T> Supplier<T> registerAuto(class_5321<? extends class_2378<? super T>> registry, String name, Supplier<T> supplier) {
        return this.registerWithNamespace(registry, MINECRAFT_NAMESPACE, name, supplier);
    }

    public void onRegisterComplete(Runnable callback) {
        this.registrationCallbacks.add(callback);
    }

    public void flushRegistrationCallbacks() {
        this.fireRegistrationCallbacks();
    }

    protected void fireRegistrationCallbacks() {
        this.registrationCallbacks.forEach(Runnable::run);
        Constants.LOG.info("Fired {} registration callbacks", (Object)this.registrationCallbacks.size());
    }

    public void restoreVanillaNamespaceEntries() {
    }

    protected class_2960 id(String name) {
        return class_2960.method_60655((String)"copperagebackport", (String)name);
    }

    protected class_2960 minecraftId(String name) {
        return class_2960.method_60656((String)name);
    }

    public static boolean isVanillaBackport(String name) {
        return VANILLA_BACKPORT_IDS.contains(name);
    }

    static {
        VANILLA_BACKPORT_IDS = new HashSet<String>();
        VANILLA_BACKPORT_IDS.add("copper_chest");
        VANILLA_BACKPORT_IDS.add("exposed_copper_chest");
        VANILLA_BACKPORT_IDS.add("weathered_copper_chest");
        VANILLA_BACKPORT_IDS.add("oxidized_copper_chest");
        VANILLA_BACKPORT_IDS.add("waxed_copper_chest");
        VANILLA_BACKPORT_IDS.add("waxed_exposed_copper_chest");
        VANILLA_BACKPORT_IDS.add("waxed_weathered_copper_chest");
        VANILLA_BACKPORT_IDS.add("waxed_oxidized_copper_chest");
        VANILLA_BACKPORT_IDS.add("copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("exposed_copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("weathered_copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("oxidized_copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("waxed_copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("waxed_exposed_copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("waxed_weathered_copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("waxed_oxidized_copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("copper_golem");
        VANILLA_BACKPORT_IDS.add("copper_golem_spawn_egg");
        VANILLA_BACKPORT_IDS.add("copper_chain");
        VANILLA_BACKPORT_IDS.add("exposed_copper_chain");
        VANILLA_BACKPORT_IDS.add("weathered_copper_chain");
        VANILLA_BACKPORT_IDS.add("oxidized_copper_chain");
        VANILLA_BACKPORT_IDS.add("waxed_copper_chain");
        VANILLA_BACKPORT_IDS.add("waxed_exposed_copper_chain");
        VANILLA_BACKPORT_IDS.add("waxed_weathered_copper_chain");
        VANILLA_BACKPORT_IDS.add("waxed_oxidized_copper_chain");
        VANILLA_BACKPORT_IDS.add("copper_lantern");
        VANILLA_BACKPORT_IDS.add("exposed_copper_lantern");
        VANILLA_BACKPORT_IDS.add("weathered_copper_lantern");
        VANILLA_BACKPORT_IDS.add("oxidized_copper_lantern");
        VANILLA_BACKPORT_IDS.add("waxed_copper_lantern");
        VANILLA_BACKPORT_IDS.add("waxed_exposed_copper_lantern");
        VANILLA_BACKPORT_IDS.add("waxed_weathered_copper_lantern");
        VANILLA_BACKPORT_IDS.add("waxed_oxidized_copper_lantern");
        VANILLA_BACKPORT_IDS.add("copper_bars");
        VANILLA_BACKPORT_IDS.add("exposed_copper_bars");
        VANILLA_BACKPORT_IDS.add("weathered_copper_bars");
        VANILLA_BACKPORT_IDS.add("oxidized_copper_bars");
        VANILLA_BACKPORT_IDS.add("waxed_copper_bars");
        VANILLA_BACKPORT_IDS.add("waxed_exposed_copper_bars");
        VANILLA_BACKPORT_IDS.add("waxed_weathered_copper_bars");
        VANILLA_BACKPORT_IDS.add("waxed_oxidized_copper_bars");
        VANILLA_BACKPORT_IDS.add("exposed_lightning_rod");
        VANILLA_BACKPORT_IDS.add("weathered_lightning_rod");
        VANILLA_BACKPORT_IDS.add("oxidized_lightning_rod");
        VANILLA_BACKPORT_IDS.add("waxed_lightning_rod");
        VANILLA_BACKPORT_IDS.add("waxed_exposed_lightning_rod");
        VANILLA_BACKPORT_IDS.add("waxed_weathered_lightning_rod");
        VANILLA_BACKPORT_IDS.add("waxed_oxidized_lightning_rod");
        VANILLA_BACKPORT_IDS.add("copper_torch");
        VANILLA_BACKPORT_IDS.add("copper_wall_torch");
        VANILLA_BACKPORT_IDS.add("copper_horse_armor");
        VANILLA_BACKPORT_IDS.add("copper_axe");
        VANILLA_BACKPORT_IDS.add("copper_pickaxe");
        VANILLA_BACKPORT_IDS.add("copper_shovel");
        VANILLA_BACKPORT_IDS.add("copper_hoe");
        VANILLA_BACKPORT_IDS.add("copper_sword");
        VANILLA_BACKPORT_IDS.add("copper_helmet");
        VANILLA_BACKPORT_IDS.add("copper_chestplate");
        VANILLA_BACKPORT_IDS.add("copper_leggings");
        VANILLA_BACKPORT_IDS.add("copper_boots");
        VANILLA_BACKPORT_IDS.add("copper_nugget");
        VANILLA_BACKPORT_IDS.add("oak_shelf");
        VANILLA_BACKPORT_IDS.add("spruce_shelf");
        VANILLA_BACKPORT_IDS.add("birch_shelf");
        VANILLA_BACKPORT_IDS.add("jungle_shelf");
        VANILLA_BACKPORT_IDS.add("acacia_shelf");
        VANILLA_BACKPORT_IDS.add("dark_oak_shelf");
        VANILLA_BACKPORT_IDS.add("mangrove_shelf");
        VANILLA_BACKPORT_IDS.add("cherry_shelf");
        VANILLA_BACKPORT_IDS.add("bamboo_shelf");
        VANILLA_BACKPORT_IDS.add("crimson_shelf");
        VANILLA_BACKPORT_IDS.add("warped_shelf");
        VANILLA_BACKPORT_IDS.add("pale_oak_shelf");
        VANILLA_BACKPORT_IDS.add("copper_chest");
        VANILLA_BACKPORT_IDS.add("shelf");
        VANILLA_BACKPORT_IDS.add("copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.death.unaffected");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.hurt.unaffected");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.step.unaffected");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.head_spin.unaffected");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.death.exposed");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.hurt.exposed");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.step.exposed");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.head_spin.exposed");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.death.weathered");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.hurt.weathered");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.step.weathered");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.head_spin.weathered");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.death.oxidized");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.hurt.oxidized");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.step.oxidized");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.head_spin.oxidized");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.spawn");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.become_statue");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.shear");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.item_drop");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.item_no_drop");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.no_item_get");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.no_item_no_get");
        VANILLA_BACKPORT_IDS.add("block.copper_chest.close");
        VANILLA_BACKPORT_IDS.add("block.copper_chest.open");
        VANILLA_BACKPORT_IDS.add("block.copper_statue.break");
        VANILLA_BACKPORT_IDS.add("block.copper_statue.place");
        VANILLA_BACKPORT_IDS.add("block.copper_statue.hit");
        VANILLA_BACKPORT_IDS.add("block.copper_statue.become_statue");
        VANILLA_BACKPORT_IDS.add("block.shelf.activate");
        VANILLA_BACKPORT_IDS.add("block.shelf.deactivate");
        VANILLA_BACKPORT_IDS.add("block.shelf.place_item");
        VANILLA_BACKPORT_IDS.add("block.shelf.take_item");
        VANILLA_BACKPORT_IDS.add("block.shelf.single_swap");
        VANILLA_BACKPORT_IDS.add("block.shelf.multi_swap");
        VANILLA_BACKPORT_IDS.add("item.armor.equip_copper");
        VANILLA_BACKPORT_IDS.add("weather.end_flash");
        VANILLA_BACKPORT_IDS.add("copper_fire_flame");
    }
}

