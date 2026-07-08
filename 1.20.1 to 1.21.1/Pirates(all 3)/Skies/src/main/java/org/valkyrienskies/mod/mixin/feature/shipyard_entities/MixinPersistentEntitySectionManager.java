/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  it.unimi.dsi.fastutil.longs.LongCollection
 *  it.unimi.dsi.fastutil.longs.LongIterator
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_5568
 *  net.minecraft.class_5573
 *  net.minecraft.class_5579
 *  net.minecraft.class_5584
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.feature.shipyard_entities;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.LongCollection;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_5568;
import net.minecraft.class_5573;
import net.minecraft.class_5579;
import net.minecraft.class_5584;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.entity.handling.VSEntityManager;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixinducks.world.OfLevel;

@Mixin(value={class_5579.class})
public abstract class MixinPersistentEntitySectionManager
implements OfLevel {
    @Shadow
    @Final
    class_5573<class_1297> field_27265;
    @Unique
    private class_1937 level;
    @Shadow
    @Final
    private LongSet field_27269;
    @Shadow
    @Final
    private Long2ObjectMap<class_5584> field_27267;

    @Override
    public class_1937 getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(class_1937 level) {
        this.level = level;
        ((OfLevel)this.field_27265).setLevel(level);
    }

    @Shadow
    private boolean method_31837(long l2) {
        throw new IllegalStateException("This should not be invoked");
    }

    @Inject(method={"processUnloads"}, at={@At(value="HEAD")}, cancellable=true)
    private void replaceProcessUnloads(CallbackInfo ci) {
        try {
            LongOpenHashSet toRemove = new LongOpenHashSet();
            LongIterator longIterator = this.field_27269.iterator();
            while (longIterator.hasNext()) {
                long key = (Long)longIterator.next();
                if (this.field_27267.get(key) != class_5584.field_27289) {
                    toRemove.add(key);
                    continue;
                }
                if (!this.method_31837(key)) continue;
                toRemove.add(key);
            }
            this.field_27269.removeAll((LongCollection)toRemove);
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
        ci.cancel();
    }

    @Inject(method={"addEntity"}, at={@At(value="HEAD")})
    <T extends class_5568> void preAddEntity(T entityAccess, boolean bl, CallbackInfoReturnable<Boolean> cir) {
        class_1297 entity;
        LoadedShip ship;
        if (entityAccess instanceof class_1297 && (ship = VSGameUtilsKt.getLoadedShipManagingPos((entity = (class_1297)entityAccess).method_37908(), (Vector3dc)VectorConversionsMCKt.toJOML(entity.method_19538()))) != null) {
            VSEntityManager.INSTANCE.getHandler(entity).freshEntityInShipyard(entity, ship);
        }
    }
}

