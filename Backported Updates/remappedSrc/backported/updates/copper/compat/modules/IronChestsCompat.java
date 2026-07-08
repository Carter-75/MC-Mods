/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1263
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.compat.modules;

import backported.updates.copper.compat.IContainerCompat;
import backported.updates.copper.compat.IModCompatModule;
import net.minecraft.class_1263;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import org.jetbrains.annotations.Nullable;

public class IronChestsCompat
implements IModCompatModule,
IContainerCompat {
    public static final String MOD_ID = "ironchest";
    private Class<?> abstractIronChestBlockClass;
    private Class<?> abstractTrappedIronChestBlockClass;
    private Class<?> abstractIronChestBlockEntityClass;

    @Override
    public String getModId() {
        return MOD_ID;
    }

    @Override
    public void init() {
        try {
            this.abstractIronChestBlockClass = Class.forName("com.progwml6.ironchest.common.block.regular.AbstractIronChestBlock");
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        try {
            this.abstractTrappedIronChestBlockClass = Class.forName("com.progwml6.ironchest.common.block.trapped.AbstractTrappedIronChestBlock");
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        try {
            this.abstractIronChestBlockEntityClass = Class.forName("com.progwml6.ironchest.common.block.regular.entity.AbstractIronChestBlockEntity");
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
    }

    @Override
    public boolean isValidContainer(class_2680 state) {
        class_2248 block = state.method_26204();
        if (this.abstractIronChestBlockClass != null && this.abstractIronChestBlockClass.isInstance(block)) {
            return true;
        }
        return this.abstractTrappedIronChestBlockClass != null && this.abstractTrappedIronChestBlockClass.isInstance(block);
    }

    @Override
    public boolean canHandle(class_2680 state) {
        return this.isValidContainer(state);
    }

    @Override
    public void setOpen(class_1937 level, class_2338 pos, class_2680 state, boolean open) {
        class_2586 blockEntity = level.method_8321(pos);
        if (blockEntity == null) {
            return;
        }
        if (this.abstractIronChestBlockEntityClass != null && this.abstractIronChestBlockEntityClass.isInstance(blockEntity)) {
            level.method_8427(pos, state.method_26204(), 1, open ? 1 : 0);
            if (open) {
                level.method_8396(null, pos, class_3417.field_14982, class_3419.field_15245, 0.5f, level.field_9229.method_43057() * 0.1f + 0.9f);
            } else {
                level.method_8396(null, pos, class_3417.field_14823, class_3419.field_15245, 0.5f, level.field_9229.method_43057() * 0.1f + 0.9f);
            }
        }
    }

    @Override
    @Nullable
    public class_1263 getContainer(class_2586 blockEntity, class_1937 level, class_2338 pos) {
        if (this.abstractIronChestBlockEntityClass != null && this.abstractIronChestBlockEntityClass.isInstance(blockEntity) && blockEntity instanceof class_1263) {
            class_1263 container = (class_1263)blockEntity;
            return container;
        }
        return null;
    }
}

