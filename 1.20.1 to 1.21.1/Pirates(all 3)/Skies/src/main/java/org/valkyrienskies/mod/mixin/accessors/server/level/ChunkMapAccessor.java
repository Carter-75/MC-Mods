/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  net.minecraft.class_1923
 *  net.minecraft.class_2672
 *  net.minecraft.class_2791
 *  net.minecraft.class_2806$class_2808
 *  net.minecraft.class_3193
 *  net.minecraft.class_3222
 *  net.minecraft.class_3898
 *  net.minecraft.class_3898$class_3216
 *  net.minecraft.class_4153
 *  org.apache.commons.lang3.mutable.MutableObject
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package org.valkyrienskies.mod.mixin.accessors.server.level;

import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.function.BooleanSupplier;
import net.minecraft.class_1923;
import net.minecraft.class_2672;
import net.minecraft.class_2791;
import net.minecraft.class_2806;
import net.minecraft.class_3193;
import net.minecraft.class_3222;
import net.minecraft.class_3898;
import net.minecraft.class_4153;
import org.apache.commons.lang3.mutable.MutableObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_3898.class})
public interface ChunkMapAccessor {
    @Invoker(value="updateChunkTracking")
    public void callUpdateChunkTracking(class_3222 var1, class_1923 var2, MutableObject<class_2672> var3, boolean var4, boolean var5);

    @Invoker(value="getChunks")
    public Iterable<class_3193> callGetChunks();

    @Invoker(value="getVisibleChunkIfPresent")
    public class_3193 callGetVisibleChunkIfPresent(long var1);

    @Invoker(value="save")
    public boolean callSave(class_2791 var1);

    @Accessor(value="toDrop")
    public LongSet getToDrop();

    @Invoker(value="processUnloads")
    public void callProcessUnloads(BooleanSupplier var1);

    @Accessor(value="poiManager")
    public class_4153 getPoiManager();

    @Invoker(value="markPosition")
    public byte callMarkPosition(class_1923 var1, class_2806.class_2808 var2);

    @Accessor(value="distanceManager")
    public class_3898.class_3216 getDistanceManager();
}

