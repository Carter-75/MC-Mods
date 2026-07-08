/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1922
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_7923
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.CoreRegistry;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.class_1299;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_4970;
import net.minecraft.class_7923;

public class BlockRegistry {
    private final CoreRegistry<class_2248> blocks;
    private final CoreRegistry<class_1792> items;

    private BlockRegistry(String modid) {
        this.blocks = CoreRegistry.create(class_7923.field_41175, modid);
        this.items = CoreRegistry.create(class_7923.field_41178, modid);
    }

    public static BlockRegistry create(String modid) {
        return new BlockRegistry(modid);
    }

    public Supplier<class_2248> register(String name, Function<class_4970.class_2251, class_2248> blockFactory, class_4970.class_2251 blockProperties, BiFunction<class_2248, class_1792.class_1793, class_1792> itemFactory, class_1792.class_1793 itemProperties) {
        return this.register(name, blockFactory, blockProperties, name, itemFactory, itemProperties);
    }

    public Supplier<class_2248> register(String blockName, Function<class_4970.class_2251, class_2248> blockFactory, class_4970.class_2251 blockProperties, String itemName, BiFunction<class_2248, class_1792.class_1793, class_1792> itemFactory, class_1792.class_1793 itemProperties) {
        Supplier<class_2248> block = this.registerNoItem(blockName, blockFactory, blockProperties);
        this.items.register(itemName, () -> (class_1792)itemFactory.apply((class_2248)block.get(), itemProperties));
        return block;
    }

    public Supplier<class_2248> register(String blockName, Supplier<class_2248> block, String itemName, Function<Supplier<class_2248>, class_1792> item) {
        Supplier<class_2248> entry = this.registerNoItem(blockName, block);
        this.items.register(itemName, () -> (class_1792)item.apply(entry));
        return entry;
    }

    public Supplier<class_2248> register(String name, Supplier<class_2248> block, Function<Supplier<class_2248>, class_1792> item) {
        Supplier<class_2248> entry = this.registerNoItem(name, block);
        this.items.register(name, () -> (class_1792)item.apply(entry));
        return entry;
    }

    public Supplier<class_2248> register(String name, class_4970.class_2251 properties) {
        return this.register(name, () -> new class_2248(properties));
    }

    public Supplier<class_2248> register(String name, Function<class_4970.class_2251, class_2248> factory, class_4970.class_2251 properties) {
        return this.register(name, () -> (class_2248)factory.apply(properties));
    }

    public Supplier<class_2248> register(String name, Supplier<class_2248> block) {
        return this.register(name, block, (Supplier<class_2248> entry) -> new class_1747((class_2248)entry.get(), new class_1792.class_1793()));
    }

    public Supplier<class_2248> registerNoItem(String name, class_4970.class_2251 properties) {
        return this.registerNoItem(name, () -> new class_2248(properties));
    }

    public Supplier<class_2248> registerNoItem(String name, Function<class_4970.class_2251, class_2248> factory, class_4970.class_2251 properties) {
        return this.registerNoItem(name, () -> (class_2248)factory.apply(properties));
    }

    public Supplier<class_2248> registerNoItem(String name, Supplier<class_2248> block) {
        return this.blocks.register(name, block);
    }

    public void register() {
        this.blocks.register();
        this.items.register();
    }

    public CoreRegistry<class_2248> blocks() {
        return this.blocks;
    }

    public CoreRegistry<class_1792> items() {
        return this.items;
    }

    public Supplier<class_1792> registerItem(String name, Supplier<class_1792> item) {
        return this.items.register(name, item);
    }

    public boolean never(class_2680 state, class_1922 level, class_2338 pos, class_1299<?> entity) {
        return false;
    }

    public boolean always(class_2680 state, class_1922 level, class_2338 pos, class_1299<?> entity) {
        return true;
    }

    public boolean ocelotOrParrot(class_2680 state, class_1922 level, class_2338 pos, class_1299<?> entity) {
        return entity == class_1299.field_6081 || entity == class_1299.field_6104;
    }

    public boolean always(class_2680 state, class_1922 level, class_2338 pos) {
        return true;
    }

    public boolean never(class_2680 state, class_1922 level, class_2338 pos) {
        return false;
    }
}

