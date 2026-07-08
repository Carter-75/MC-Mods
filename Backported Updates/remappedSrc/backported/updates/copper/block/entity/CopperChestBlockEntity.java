/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1258
 *  net.minecraft.class_1263
 *  net.minecraft.class_1657
 *  net.minecraft.class_1707
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2595
 *  net.minecraft.class_2680
 *  net.minecraft.class_3419
 *  net.minecraft.class_5561
 */
package backported.updates.copper.block.entity;

import backported.updates.copper.ModSounds;
import backported.updates.copper.registry.ModBlockEntities;
import net.minecraft.class_1258;
import net.minecraft.class_1263;
import net.minecraft.class_1657;
import net.minecraft.class_1707;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2595;
import net.minecraft.class_2680;
import net.minecraft.class_3419;
import net.minecraft.class_5561;

public class CopperChestBlockEntity
extends class_2595 {
    private final class_5561 openersCounter = new class_5561(){

        protected void method_31681(class_1937 level, class_2338 blockPos, class_2680 blockState) {
        }

        protected void method_31683(class_1937 level, class_2338 blockPos, class_2680 blockState) {
        }

        protected void method_31682(class_1937 level, class_2338 pos, class_2680 state, int oldCount, int newCount) {
            if (oldCount == 0 && newCount > 0) {
                level.method_43128(null, (double)pos.method_10263() + 0.5, (double)pos.method_10264() + 0.5, (double)pos.method_10260() + 0.5, ModSounds.COPPER_CHEST_OPEN.get(), class_3419.field_15245, 0.5f, level.field_9229.method_43057() * 0.1f + 0.9f);
            } else if (newCount == 0 && oldCount > 0) {
                level.method_43128(null, (double)pos.method_10263() + 0.5, (double)pos.method_10264() + 0.5, (double)pos.method_10260() + 0.5, ModSounds.COPPER_CHEST_CLOSE.get(), class_3419.field_15245, 0.5f, level.field_9229.method_43057() * 0.1f + 0.9f);
            }
            level.method_8427(pos, state.method_26204(), 1, newCount);
        }

        protected boolean method_31679(class_1657 player) {
            if (!(player.field_7512 instanceof class_1707)) {
                return false;
            }
            class_1263 container = ((class_1707)player.field_7512).method_7629();
            return container == CopperChestBlockEntity.this || container instanceof class_1258 && ((class_1258)container).method_5405((class_1263)CopperChestBlockEntity.this);
        }
    };

    public CopperChestBlockEntity(class_2338 pos, class_2680 state) {
        super(ModBlockEntities.COPPER_CHEST_BLOCK_ENTITY.get(), pos, state);
    }

    public void method_5435(class_1657 player) {
        if (!this.field_11865 && !player.method_7325() && this.method_10997() != null) {
            this.openersCounter.method_31684(player, this.method_10997(), this.method_11016(), this.method_11010());
        }
    }

    public void method_5432(class_1657 player) {
        if (!this.field_11865 && !player.method_7325() && this.method_10997() != null) {
            this.openersCounter.method_31685(player, this.method_10997(), this.method_11016(), this.method_11010());
        }
    }

    public void method_31671() {
        if (!this.field_11865 && this.method_10997() != null) {
            this.openersCounter.method_31686(this.method_10997(), this.method_11016(), this.method_11010());
        }
    }

    public boolean isChestOpen() {
        return this.openersCounter.method_31678() > 0;
    }
}

