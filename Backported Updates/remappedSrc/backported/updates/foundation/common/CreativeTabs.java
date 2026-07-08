/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_1761
 *  net.minecraft.class_1761$class_7704
 *  net.minecraft.class_1761$class_7705
 *  net.minecraft.class_1761$class_7913
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_5321
 *  net.minecraft.class_7699
 */
package backported.updates.foundation.common;

import backported.updates.foundation.common.fabric.CreativeTabsImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.class_1761;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_5321;
import net.minecraft.class_7699;

public class CreativeTabs {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static class_1761 create(Consumer<class_1761.class_7913> consumer) {
        return CreativeTabsImpl.create(consumer);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void modify(class_5321<class_1761> key, Modifier modifier) {
        CreativeTabsImpl.modify(key, modifier);
    }

    public static interface Output
    extends class_1761.class_7704 {
        default public void method_45417(class_1799 stack, class_1761.class_7705 tabVisibility) {
            this.addAfter(class_1799.field_8037, stack, tabVisibility);
        }

        public void addAfter(class_1799 var1, class_1799 var2, class_1761.class_7705 var3);

        default public void addAfter(class_1799 target, class_1799 stack) {
            this.addAfter(target, stack, class_1761.class_7705.field_40191);
        }

        default public void addAfter(class_1935 target, class_1935 stack) {
            this.addAfter(target.method_8389().method_7854(), stack.method_8389().method_7854(), class_1761.class_7705.field_40191);
        }

        default public void addAllAfter(class_1799 target, Collection<class_1799> stacks, class_1761.class_7705 visibility) {
            List<class_1799> list = List.copyOf(stacks);
            for (int i = list.size() - 1; i >= 0; --i) {
                this.addAfter(target, list.get(i), visibility);
            }
        }

        default public void addAllAfter(class_1799 target, Collection<class_1799> stacks) {
            List<class_1799> list = List.copyOf(stacks);
            for (int i = list.size() - 1; i >= 0; --i) {
                this.addAfter(target, list.get(i));
            }
        }

        default public void addAllAfter(class_1935 target, Collection<class_1935> stacks) {
            List<class_1935> list = List.copyOf(stacks);
            for (int i = list.size() - 1; i >= 0; --i) {
                this.addAfter(target, list.get(i));
            }
        }

        public void addBefore(class_1799 var1, class_1799 var2, class_1761.class_7705 var3);

        default public void addBefore(class_1799 target, class_1799 stack) {
            this.addBefore(target, stack, class_1761.class_7705.field_40191);
        }

        default public void addBefore(class_1935 target, class_1935 stack) {
            this.addBefore(target.method_8389().method_7854(), stack.method_8389().method_7854(), class_1761.class_7705.field_40191);
        }

        default public void addAllBefore(class_1799 target, Collection<class_1799> stacks, class_1761.class_7705 visibility) {
            List<class_1799> list = List.copyOf(stacks);
            for (int i = list.size() - 1; i >= 0; --i) {
                this.addBefore(target, list.get(i), visibility);
            }
        }

        default public void addAllBefore(class_1799 target, Collection<class_1799> stacks) {
            List<class_1799> list = List.copyOf(stacks);
            for (int i = list.size() - 1; i >= 0; --i) {
                this.addBefore(target, list.get(i));
            }
        }

        default public void addAllBefore(class_1935 target, Collection<class_1935> stacks) {
            List<class_1935> list = List.copyOf(stacks);
            for (int i = list.size() - 1; i >= 0; --i) {
                this.addBefore(target, list.get(i));
            }
        }
    }

    public static interface Modifier {
        public void accept(class_7699 var1, Output var2, boolean var3);
    }
}

