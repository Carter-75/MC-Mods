/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1311
 *  net.minecraft.class_2893$class_2894
 *  net.minecraft.class_2893$class_2895
 *  net.minecraft.class_2922
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_5483$class_1964
 *  net.minecraft.class_6796
 */
package backported.updates.foundation.common.worldgen.modifier;

import backported.updates.foundation.common.worldgen.modifier.BiomeContext;
import java.util.function.BiConsumer;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_2893;
import net.minecraft.class_2922;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_5483;
import net.minecraft.class_6796;

public abstract class BiomeWriter {
    public void add(BiConsumer<BiomeWriter, BiomeContext> modifier) {
        modifier.accept(this, this.context());
    }

    public abstract class_2960 name();

    public abstract BiomeContext context();

    public abstract void addFeature(class_2893.class_2895 var1, class_5321<class_6796> var2);

    public abstract void removeFeature(class_2893.class_2895 var1, class_5321<class_6796> var2);

    public void replaceFeature(class_2893.class_2895 decoration, class_5321<class_6796> feature, class_5321<class_6796> replacement) {
        if (this.context().hasFeature(feature)) {
            this.removeFeature(decoration, feature);
            this.addFeature(decoration, replacement);
        }
    }

    public abstract void addCarver(class_2893.class_2894 var1, class_5321<class_2922<?>> var2);

    public abstract void removeCarver(class_2893.class_2894 var1, class_5321<class_2922<?>> var2);

    public abstract void addSpawn(class_1311 var1, class_5483.class_1964 var2);

    public abstract void removeSpawn(class_1299<?> var1);

    public void replaceSpawn(class_1311 category, class_5483.class_1964 data) {
        if (this.context().hasEntity(() -> data.field_9389)) {
            this.removeSpawn(data.field_9389);
            this.addSpawn(category, data);
        }
    }
}

