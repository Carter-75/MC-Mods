/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_52
 *  net.minecraft.class_5321
 *  net.minecraft.class_55$class_56
 *  net.minecraft.class_79
 */
package backported.updates.foundation.common.data;

import backported.updates.foundation.common.data.fabric.LootModifierImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.class_52;
import net.minecraft.class_5321;
import net.minecraft.class_55;
import net.minecraft.class_79;

public class LootModifier {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void modify(LootTableModifier modifier) {
        LootModifierImpl.modify(modifier);
    }

    public static interface LootTableContext {
        public void addPool(class_55.class_56 var1);

        public boolean addToPool(int var1, ArrayList<class_79> var2);

        default public boolean addToPool(ArrayList<class_79> content) {
            return this.addToPool(0, content);
        }

        default public boolean addToPool(int index, class_79 ... content) {
            ArrayList<class_79> entries = new ArrayList<class_79>();
            Collections.addAll(entries, content);
            return this.addToPool(index, entries);
        }

        default public boolean addToPool(class_79 ... content) {
            return this.addToPool(0, content);
        }
    }

    public static interface LootTableModifier {
        public void modify(class_5321<class_52> var1, LootTableContext var2, boolean var3);
    }
}

