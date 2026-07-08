/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2487
 *  net.minecraft.class_2561
 *  net.minecraft.class_2561$class_2562
 *  net.minecraft.class_2586
 *  net.minecraft.class_2586$class_9473
 *  net.minecraft.class_2622
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_7225$class_7874
 *  net.minecraft.class_9323$class_9324
 *  net.minecraft.class_9334
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.block.entity;

import backported.updates.copper.block.CopperGolemStatueBlock;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.registry.ModBlockEntities;
import backported.updates.copper.registry.ModEntities;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2622;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_7225;
import net.minecraft.class_9323;
import net.minecraft.class_9334;
import org.jetbrains.annotations.Nullable;

public class CopperGolemStatueBlockEntity
extends class_2586 {
    @Nullable
    private class_2561 customName;

    public CopperGolemStatueBlockEntity(class_2338 pos, class_2680 state) {
        super(ModBlockEntities.COPPER_GOLEM_STATUE_BLOCK_ENTITY.get(), pos, state);
    }

    public void createStatue(CopperGolemEntity golem) {
        this.customName = golem.method_5797();
        this.method_5431();
    }

    @Nullable
    public CopperGolemEntity removeStatue(class_2680 state, class_3218 level) {
        CopperGolemEntity golem = (CopperGolemEntity)ModEntities.COPPER_GOLEM.get().method_5883((class_1937)level);
        if (golem != null) {
            class_2338 blockPos = this.method_11016();
            golem.method_5808((double)blockPos.method_10263() + 0.5, blockPos.method_10264(), (double)blockPos.method_10260() + 0.5, ((class_2350)state.method_11654((class_2769)CopperGolemStatueBlock.FACING)).method_10144(), 0.0f);
            golem.field_6241 = golem.method_36454();
            golem.field_6283 = golem.method_36454();
            golem.method_5665(this.customName);
            golem.setWeatherState(((CopperGolemStatueBlock)state.method_26204()).getWeatheringState());
            return golem;
        }
        return null;
    }

    protected void method_11007(class_2487 tag, class_7225.class_7874 registries) {
        super.method_11007(tag, registries);
        if (this.customName != null) {
            tag.method_10582("CustomName", class_2561.class_2562.method_10867((class_2561)this.customName, (class_7225.class_7874)registries));
        }
    }

    protected void method_11014(class_2487 tag, class_7225.class_7874 registries) {
        super.method_11014(tag, registries);
        if (tag.method_10545("CustomName")) {
            this.customName = class_2561.class_2562.method_10877((String)tag.method_10558("CustomName"), (class_7225.class_7874)registries);
        }
    }

    public class_2622 getUpdatePacket() {
        return class_2622.method_38585((class_2586)this);
    }

    public class_2487 method_16887(class_7225.class_7874 registries) {
        return this.method_38244(registries);
    }

    protected void method_57568(class_2586.class_9473 componentInput) {
        super.method_57568(componentInput);
        this.customName = (class_2561)componentInput.method_58694(class_9334.field_49631);
    }

    protected void method_57567(class_9323.class_9324 components) {
        super.method_57567(components);
        components.method_57840(class_9334.field_49631, (Object)this.customName);
    }

    public void method_57569(class_2487 tag) {
        tag.method_10551("CustomName");
    }
}

