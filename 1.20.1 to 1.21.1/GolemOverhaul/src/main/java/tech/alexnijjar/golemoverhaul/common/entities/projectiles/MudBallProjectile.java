/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_239
 *  net.minecraft.class_2392
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_3417
 *  net.minecraft.class_3857
 *  net.minecraft.class_3966
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoEntity
 *  software.bernie.geckolib.core.animatable.GeoAnimatable
 *  software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
 *  software.bernie.geckolib.core.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.util.GeckoLibUtil
 */
package tech.alexnijjar.golemoverhaul.common.entities.projectiles;

import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_239;
import net.minecraft.class_2392;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_3417;
import net.minecraft.class_3857;
import net.minecraft.class_3966;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;
import tech.alexnijjar.golemoverhaul.common.entities.golems.TerracottaGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class MudBallProjectile
extends class_3857
implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache((GeoAnimatable)this);

    public MudBallProjectile(class_1299<? extends class_3857> type, class_1937 level) {
        super(type, level);
    }

    public MudBallProjectile(class_1937 level, class_1309 owner) {
        super((class_1299)ModEntityTypes.MUD_BALL.get(), level);
        this.method_7432((class_1297)owner);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Nullable
    private class_2394 getParticle() {
        class_1799 stack = this.method_7495();
        return stack.method_7960() ? null : new class_2392(class_2398.field_11218, stack);
    }

    public void method_5711(byte id) {
        if (id == 3) {
            class_2394 particle = this.getParticle();
            if (particle == null) {
                return;
            }
            for (int i = 0; i < 8; ++i) {
                this.method_37908().method_8406(particle, this.method_23317(), this.method_23318(), this.method_23321(), 0.0, 0.0, 0.0);
            }
        }
    }

    protected void method_7454(class_3966 result) {
        super.method_7454(result);
        if (result.method_17782() instanceof TerracottaGolem) {
            return;
        }
        class_1297 entity = result.method_17782();
        entity.method_5643(this.method_48923().method_48811((class_1297)this, this.method_24921()), 4.0f);
    }

    protected void method_7488(class_239 result) {
        super.method_7488(result);
        if (!this.method_37908().method_8608()) {
            this.method_37908().method_8421((class_1297)this, (byte)3);
            this.method_5783(class_3417.field_37329, 1.0f, 1.0f);
            this.method_31472();
        }
    }

    protected class_1792 method_16942() {
        return class_1802.field_37537;
    }
}

