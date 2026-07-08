/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_2248
 *  net.minecraft.class_7923
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.CoreRegistry;
import backported.updates.foundation.core.helper.fabric.ItemRegistryImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1792;
import net.minecraft.class_2248;
import net.minecraft.class_7923;

public class ItemRegistry {
    private final CoreRegistry<class_1792> items;

    private ItemRegistry(String modId) {
        this.items = CoreRegistry.create(class_7923.field_41178, modId);
    }

    public static ItemRegistry create(String modId) {
        return new ItemRegistry(modId);
    }

    public <T extends class_1792> Supplier<T> register(String name, Supplier<T> item) {
        return this.items.register(name, item);
    }

    public Supplier<class_1792> register(String name) {
        return this.register(name, new class_1792.class_1793());
    }

    public Supplier<class_1792> register(String name, class_1792.class_1793 properties) {
        return this.register(name, class_1792::new, properties);
    }

    public Supplier<class_1792> register(String name, Function<class_1792.class_1793, class_1792> function) {
        return this.register(name, function, new class_1792.class_1793());
    }

    public Supplier<class_1792> register(String name, Function<class_1792.class_1793, class_1792> factory, class_1792.class_1793 properties) {
        return this.items.register(name, () -> (class_1792)factory.apply(properties));
    }

    public <T extends class_1308> Supplier<class_1792> spawnEgg(String name, Supplier<class_1299<T>> entity, int primaryColor, int secondaryColor, class_1792.class_1793 properties) {
        return this.items.register(name, () -> ItemRegistry.createSpawnEgg(entity, primaryColor, secondaryColor, properties));
    }

    public Supplier<class_1792> fromBlock(Supplier<class_2248> block) {
        return () -> ((class_2248)block.get()).method_8389();
    }

    public void register() {
        this.items.register();
    }

    public CoreRegistry<class_1792> registry() {
        return this.items;
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T extends class_1308> class_1792 createSpawnEgg(Supplier<class_1299<T>> entity, int primaryColor, int secondaryColor, class_1792.class_1793 properties) {
        return ItemRegistryImpl.createSpawnEgg(entity, primaryColor, secondaryColor, properties);
    }
}

