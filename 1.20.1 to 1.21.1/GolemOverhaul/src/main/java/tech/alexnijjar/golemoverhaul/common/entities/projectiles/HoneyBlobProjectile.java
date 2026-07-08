/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1665
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2392
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3965
 *  net.minecraft.class_3966
 *  software.bernie.geckolib.animatable.GeoEntity
 *  software.bernie.geckolib.core.animatable.GeoAnimatable
 *  software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
 *  software.bernie.geckolib.core.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.util.GeckoLibUtil
 */
package tech.alexnijjar.golemoverhaul.common.entities.projectiles;

import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1665;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2392;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;
import tech.alexnijjar.golemoverhaul.common.registry.ModItems;
import tech.alexnijjar.golemoverhaul.common.tags.ModEntityTypeTags;

public class HoneyBlobProjectile
extends class_1665
implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache((GeoAnimatable)this);

    public HoneyBlobProjectile(class_1299<? extends class_1665> type, class_1937 level) {
        super(type, level);
    }

    public HoneyBlobProjectile(class_1937 level, class_1309 owner) {
        super((class_1299)ModEntityTypes.HONEY_BLOB.get(), level);
        this.method_7432((class_1297)owner);
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
    }

    private class_2394 getParticle() {
        return new class_2392(class_2398.field_11218, class_1802.field_21086.method_7854());
    }

    public void method_5711(byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.method_37908().method_8406(this.getParticle(), this.method_23317(), this.method_23318(), this.method_23321(), 0.0, 0.0, 0.0);
            }
        }
    }

    protected void method_7454(class_3966 result) {
        class_1309 livingEntity;
        class_1297 entity = result.method_17782();
        if (entity instanceof class_1309) {
            livingEntity = (class_1309)entity;
            if (entity.method_5864().method_20210(ModEntityTypeTags.HONEY_IMMUNE)) {
                livingEntity.method_6025(20.0f);
                return;
            }
        }
        if (this.method_24921() != null && entity.equals((Object)this.method_24921())) {
            return;
        }
        entity.method_5643(this.method_48923().method_48811((class_1297)this, this.method_24921()), 6.0f);
        if (entity instanceof class_1309) {
            livingEntity = (class_1309)entity;
            livingEntity.method_6092(new class_1293(class_1294.field_5909, this.method_24921() instanceof class_1657 ? 180 : 60, 2));
        }
        if (!this.method_37908().method_8608()) {
            this.method_37908().method_8421((class_1297)this, (byte)3);
            this.method_31472();
        }
    }

    protected void method_24920(class_3965 result) {
        super.method_24920(result);
        if (!this.method_37908().method_8608()) {
            this.method_37908().method_8421((class_1297)this, (byte)3);
            this.method_31472();
        }
    }

    protected class_3414 method_7440() {
        return class_3417.field_21070;
    }

    protected class_1799 method_7445() {
        return ((class_1792)ModItems.HONEY_BLOB.get()).method_7854();
    }

    public void method_5773() {
        super.method_5773();
        if (this.field_7588) {
            this.method_31472();
        }
    }
}

