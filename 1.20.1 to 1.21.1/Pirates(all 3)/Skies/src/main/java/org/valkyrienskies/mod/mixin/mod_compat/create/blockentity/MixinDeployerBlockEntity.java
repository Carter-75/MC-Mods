/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.kinetics.base.KineticBlockEntity
 *  com.simibubi.create.content.kinetics.deployer.DeployerBlock
 *  com.simibubi.create.content.kinetics.deployer.DeployerBlockEntity
 *  com.simibubi.create.foundation.blockEntity.SmartBlockEntity
 *  com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour
 *  com.simibubi.create.foundation.blockEntity.behaviour.ValueBoxTransform
 *  com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollOptionBehaviour
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2561
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.deployer.DeployerBlock;
import com.simibubi.create.content.kinetics.deployer.DeployerBlockEntity;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.ValueBoxTransform;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollOptionBehaviour;
import java.util.List;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2561;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.compat.create.DeployerScrollOptionSlot;
import org.valkyrienskies.mod.mixinducks.mod_compat.create.IDeployerBehavior;

@Pseudo
@Mixin(value={DeployerBlockEntity.class})
public abstract class MixinDeployerBlockEntity
extends KineticBlockEntity
implements IDeployerBehavior {
    @Unique
    protected ScrollOptionBehaviour<IDeployerBehavior.WorkingMode> valkyrienskies$workingMode;

    public MixinDeployerBlockEntity(class_2591<?> typeIn, class_2338 pos, class_2680 state) {
        super(typeIn, pos, state);
    }

    @Inject(method={"addBehaviours"}, at={@At(value="RETURN")}, remap=false)
    public void behaviour(List<BlockEntityBehaviour> behaviours, CallbackInfo ci) {
        this.valkyrienskies$workingMode = new ScrollOptionBehaviour(IDeployerBehavior.WorkingMode.class, (class_2561)class_2561.method_43471((String)"misc.valkyrienskies.create.deployer_working_mode"), (SmartBlockEntity)((DeployerBlockEntity)this), this.valkyrienskies$getMovementModeSlot());
        behaviours.add((BlockEntityBehaviour)this.valkyrienskies$workingMode);
    }

    @Unique
    private ValueBoxTransform valkyrienskies$getMovementModeSlot() {
        return new DeployerScrollOptionSlot((state, d2) -> {
            class_2350.class_2351 axis = d2.method_10166();
            return axis == this.getSlot(((class_2350)state.method_11654((class_2769)DeployerBlock.FACING)).method_10166(), (Boolean)state.method_11654((class_2769)DeployerBlock.AXIS_ALONG_FIRST_COORDINATE));
        });
    }

    @Override
    public ScrollOptionBehaviour<IDeployerBehavior.WorkingMode> valkyrienskies$get_working_mode() {
        return this.valkyrienskies$workingMode;
    }

    @Unique
    public class_2350.class_2351 getSlot(class_2350.class_2351 axis, boolean b2) {
        switch (axis) {
            case field_11052: {
                return b2 ? class_2350.class_2351.field_11051 : class_2350.class_2351.field_11048;
            }
            case field_11048: {
                return b2 ? class_2350.class_2351.field_11051 : class_2350.class_2351.field_11052;
            }
        }
        return b2 ? class_2350.class_2351.field_11052 : class_2350.class_2351.field_11048;
    }
}

