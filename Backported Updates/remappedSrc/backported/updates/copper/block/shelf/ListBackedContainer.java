/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1262
 *  net.minecraft.class_1263
 *  net.minecraft.class_1799
 *  net.minecraft.class_2371
 */
package backported.updates.copper.block.shelf;

import java.util.function.Predicate;
import net.minecraft.class_1262;
import net.minecraft.class_1263;
import net.minecraft.class_1799;
import net.minecraft.class_2371;

public interface ListBackedContainer
extends class_1263 {
    public class_2371<class_1799> getItems();

    default public int count() {
        return (int)this.getItems().stream().filter(Predicate.not(class_1799::method_7960)).count();
    }

    default public int method_5439() {
        return this.getItems().size();
    }

    default public void method_5448() {
        this.getItems().clear();
    }

    default public boolean method_5442() {
        return this.getItems().stream().allMatch(class_1799::method_7960);
    }

    default public class_1799 method_5438(int slot) {
        return (class_1799)this.getItems().get(slot);
    }

    default public class_1799 method_5434(int slot, int amount) {
        class_1799 itemstack = class_1262.method_5430(this.getItems(), (int)slot, (int)amount);
        if (!itemstack.method_7960()) {
            this.method_5431();
        }
        return itemstack;
    }

    default public class_1799 method_5441(int slot) {
        return class_1262.method_5428(this.getItems(), (int)slot);
    }

    default public boolean method_5437(int slot, class_1799 stack) {
        if (!this.acceptsItemType(stack)) {
            return false;
        }
        class_1799 existing = this.method_5438(slot);
        if (existing.method_7960()) {
            return true;
        }
        return class_1799.method_31577((class_1799)existing, (class_1799)stack) && existing.method_7947() < existing.method_7914();
    }

    default public boolean acceptsItemType(class_1799 stack) {
        return true;
    }

    default public void method_5447(int slot, class_1799 stack) {
        this.setItemNoUpdate(slot, stack);
        this.method_5431();
    }

    default public void setItemNoUpdate(int slot, class_1799 stack) {
        this.getItems().set(slot, (Object)stack);
        if (stack.method_7947() > this.method_5444()) {
            stack.method_7939(this.method_5444());
        }
    }
}

