/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.class_117
 *  net.minecraft.class_5341
 *  net.minecraft.class_55
 *  net.minecraft.class_5658
 *  net.minecraft.class_79
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.foundation.fabric.loot;

import backported.updates.foundation.common.data.fabric.LootPoolAccess;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_117;
import net.minecraft.class_5341;
import net.minecraft.class_55;
import net.minecraft.class_5658;
import net.minecraft.class_79;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_55.class})
public class LootPoolMixin
implements LootPoolAccess {
    @Shadow
    @Final
    public class_5658 field_957;
    @Shadow
    @Final
    public class_5658 field_958;
    @Shadow
    @Final
    public List<class_5341> field_954;
    @Shadow
    @Final
    public List<class_117> field_956;
    @Shadow
    @Final
    public List<class_79> field_953;

    @Invoker(value="<init>")
    static class_55 create(List<class_79> entries, List<class_5341> conditions, List<class_117> functions, class_5658 rolls, class_5658 bonusRolls) {
        throw new AssertionError();
    }

    @Override
    public class_55 mergeEntries(List<class_79> contents) {
        ArrayList merged = Lists.newArrayList(this.field_953);
        merged.addAll(contents);
        return LootPoolMixin.create(merged, this.field_954, this.field_956, this.field_957, this.field_958);
    }
}

