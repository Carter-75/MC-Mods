/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2378
 *  net.minecraft.class_2487
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_2791
 *  net.minecraft.class_2806$class_2808
 *  net.minecraft.class_2818
 *  net.minecraft.class_2826
 *  net.minecraft.class_2839
 *  net.minecraft.class_2852
 *  net.minecraft.class_2902
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_3218
 *  net.minecraft.class_3611
 *  net.minecraft.class_4153
 *  net.minecraft.class_6755
 *  net.minecraft.class_7924
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.world.chunk;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2378;
import net.minecraft.class_2487;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2791;
import net.minecraft.class_2806;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_2839;
import net.minecraft.class_2852;
import net.minecraft.class_2902;
import net.minecraft.class_3218;
import net.minecraft.class_3611;
import net.minecraft.class_4153;
import net.minecraft.class_6755;
import net.minecraft.class_7924;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.BlockStateInfo;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VSLevelChunk;

@Mixin(value={class_2818.class})
public abstract class MixinLevelChunk
extends class_2791
implements VSLevelChunk {
    @Shadow
    @Final
    class_1937 field_12858;
    @Shadow
    @Mutable
    private class_6755<class_2248> field_35471;
    @Shadow
    @Mutable
    private class_6755<class_3611> field_35472;
    @Unique
    private static final Set<class_2902.class_2903> ALL_HEIGHT_MAP_TYPES = new HashSet<class_2902.class_2903>(Arrays.asList(class_2902.class_2903.values()));

    public MixinLevelChunk(Ship ship) {
        super(null, null, null, null, 0L, null, null);
        throw new IllegalStateException("This should never be called!");
    }

    @Inject(method={"setBlockState"}, at={@At(value="TAIL")})
    public void postSetBlockState(class_2338 pos, class_2680 state, boolean moved, CallbackInfoReturnable<class_2680> cir) {
        class_2680 prevState = (class_2680)cir.getReturnValue();
        VSGameUtilsKt.executeOrSchedule(this.field_12858, () -> BlockStateInfo.INSTANCE.onSetBlock(this.field_12858, pos, prevState, state));
    }

    @Shadow
    public abstract void method_38289();

    @Shadow
    public abstract void method_39305(class_3218 var1);

    @Shadow
    public abstract void method_39306(class_3218 var1);

    @Override
    public void clearChunk() {
        this.method_38289();
        this.method_39306((class_3218)this.field_12858);
        this.field_34541.clear();
        Arrays.fill(this.field_34545, null);
        class_2378 registry = this.field_12858.method_30349().method_30530(class_7924.field_41236);
        for (int i2 = 0; i2 < this.field_34545.length; ++i2) {
            if (this.field_34545[i2] != null) continue;
            this.field_34545[i2] = new class_2826(registry);
        }
        this.method_12020(false);
        this.method_39305((class_3218)this.field_12858);
        this.field_34537 = true;
    }

    @Override
    public void copyChunkFromOtherDimension(@NotNull VSLevelChunk srcChunkVS) {
        this.method_38289();
        this.method_39306((class_3218)this.field_12858);
        this.field_34541.clear();
        Arrays.fill(this.field_34545, null);
        class_2818 srcChunk = (class_2818)srcChunkVS;
        class_2487 compoundTag = class_2852.method_12410((class_3218)((class_3218)srcChunk.method_12200()), (class_2791)srcChunk);
        compoundTag.method_10582("Status", class_2806.class_2808.field_12808.name());
        class_2839 protoChunk = class_2852.method_12395((class_3218)((class_3218)this.field_12858), (class_4153)((class_3218)this.field_12858).method_19494(), (class_1923)this.field_34538, (class_2487)compoundTag);
        this.field_35471 = protoChunk.method_39307();
        this.field_35472 = protoChunk.method_39308();
        for (int i2 = 0; i2 < this.field_34545.length; ++i2) {
            this.field_34545[i2] = protoChunk.method_38259(i2);
        }
        class_2378 registry = this.field_12858.method_30349().method_30530(class_7924.field_41236);
        for (int i3 = 0; i3 < this.field_34545.length; ++i3) {
            if (this.field_34545[i3] != null) continue;
            this.field_34545[i3] = new class_2826(registry);
        }
        this.field_35468 = protoChunk.method_39299();
        for (class_2586 blockEntity : protoChunk.method_12309().values()) {
            this.method_12007(blockEntity);
        }
        this.field_34542.putAll(protoChunk.method_12316());
        for (int i4 = 0; i4 < protoChunk.method_12012().length; ++i4) {
            this.field_34536[i4] = protoChunk.method_12012()[i4];
        }
        this.method_12034(protoChunk.method_12016());
        this.method_12183(protoChunk.method_12179());
        class_2902.method_16684((class_2791)this, ALL_HEIGHT_MAP_TYPES);
        this.method_12020(false);
        this.method_39305((class_3218)this.field_12858);
        this.field_34537 = true;
    }
}

