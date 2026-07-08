/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2337
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5547
 *  net.minecraft.class_5554
 *  net.minecraft.class_5819
 *  net.minecraft.class_5955
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_9062
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package backported_updates.mixin.copper;

import backported.updates.copper.registry.ModBlocks;
import java.util.Optional;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2337;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5547;
import net.minecraft.class_5554;
import net.minecraft.class_5819;
import net.minecraft.class_5955;
import net.minecraft.class_9062;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_5554.class})
public abstract class LightningRodBlockMixin
extends class_2337
implements class_5955,
class_5547<class_5955.class_5811> {
    public LightningRodBlockMixin(class_4970.class_2251 properties) {
        super(properties);
    }

    public class_5955.class_5811 getAge() {
        return class_5955.class_5811.field_28704;
    }

    @Unique
    private Optional<class_2248> copperagebackport$getNextBlock() {
        return Optional.of((class_2248)ModBlocks.EXPOSED_LIGHTNING_ROD.get());
    }

    @Unique
    private Optional<class_2248> copperagebackport$getWaxedBlock() {
        return Optional.of((class_2248)ModBlocks.WAXED_LIGHTNING_ROD.get());
    }

    protected boolean method_9542(class_2680 state) {
        return true;
    }

    protected void method_9514(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        float f = 0.05688889f;
        if (random.method_43057() < f) {
            this.copperagebackport$tryOxidize(state, level, pos, random);
        }
    }

    @Unique
    private void copperagebackport$tryOxidize(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        Optional<class_2248> nextBlock = this.copperagebackport$getNextBlock();
        if (nextBlock.isPresent()) {
            float chance = 1.0f * this.method_33620();
            if (random.method_43057() < chance) {
                level.method_8501(pos, nextBlock.get().method_34725(state));
            }
        }
    }

    public Optional<class_2680> method_31639(class_2680 state) {
        return this.copperagebackport$getNextBlock().map(block -> block.method_34725(state));
    }

    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hitResult) {
        Optional<class_2248> waxedBlock;
        if (stack.method_31574(class_1802.field_20414) && (waxedBlock = this.copperagebackport$getWaxedBlock()).isPresent()) {
            level.method_8396(player, pos, class_3417.field_29543, class_3419.field_15245, 1.0f, 1.0f);
            level.method_8444(player, 3003, pos, 0);
            if (!level.field_9236) {
                level.method_8652(pos, waxedBlock.get().method_34725(state), 11);
                if (!player.method_31549().field_7477) {
                    stack.method_7934(1);
                }
            }
            return class_9062.method_55644((boolean)level.field_9236);
        }
        return class_9062.field_47731;
    }

    public float method_33620() {
        return 1.0f;
    }
}

