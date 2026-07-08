/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.types.Type
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2591$class_2592
 *  net.minecraft.class_2680
 */
package backported.updates.foundation.core.helper;

import com.mojang.datafixers.types.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;

public record BlockEntityTypeBuilder<T extends class_2586>(Factory<? extends T> factory, List<Supplier<class_2248>> blocks) {
    public static <T extends class_2586> BlockEntityTypeBuilder<T> create(Factory<? extends T> factory, List<Supplier<class_2248>> blocks) {
        return new BlockEntityTypeBuilder<T>(factory, blocks);
    }

    @SafeVarargs
    public static <T extends class_2586> BlockEntityTypeBuilder<T> create(Factory<? extends T> factory, Supplier<class_2248> ... blocks) {
        ArrayList<Supplier<class_2248>> entries = new ArrayList<Supplier<class_2248>>(blocks.length);
        Collections.addAll(entries, blocks);
        return new BlockEntityTypeBuilder<T>(factory, entries);
    }

    public BlockEntityTypeBuilder<T> add(Supplier<class_2248> block) {
        this.blocks.add(block);
        return this;
    }

    @SafeVarargs
    public final BlockEntityTypeBuilder<T> add(Supplier<class_2248> ... block) {
        Collections.addAll(this.blocks, block);
        return this;
    }

    public class_2591<T> build() {
        return this.build(null);
    }

    public class_2591<T> build(Type<?> type) {
        return class_2591.class_2592.method_20528(this.factory::create, (class_2248[])((class_2248[])this.blocks.stream().map(Supplier::get).toArray(class_2248[]::new))).method_11034(type);
    }

    public static interface Factory<T extends class_2586> {
        public T create(class_2338 var1, class_2680 var2);
    }
}

