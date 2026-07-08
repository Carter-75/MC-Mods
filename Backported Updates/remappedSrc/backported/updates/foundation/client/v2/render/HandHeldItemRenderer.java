/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1087
 *  net.minecraft.class_1091
 *  net.minecraft.class_1799
 *  net.minecraft.class_763
 *  net.minecraft.class_811
 */
package backported.updates.foundation.client.v2.render;

import backported.updates.foundation.client.v2.render.ItemRendererRegistry;
import backported.updates.foundation.core.util.event.ResultHolder;
import java.util.Set;
import net.minecraft.class_1087;
import net.minecraft.class_1091;
import net.minecraft.class_1799;
import net.minecraft.class_763;
import net.minecraft.class_811;

public record HandHeldItemRenderer(class_1091 original, class_1091 handheld) implements ItemRendererRegistry.Renderer
{
    private static final Set<class_811> CONTEXTS = Set.of(class_811.field_4317, class_811.field_4318, class_811.field_4319);

    @Override
    public ResultHolder<class_1087> renderFirstPerson(class_1799 stack, class_811 context, class_763 shaper) {
        if (CONTEXTS.contains(context)) {
            return ResultHolder.submit(shaper.method_3303().method_4742(this.original()));
        }
        return ResultHolder.pass();
    }

    @Override
    public ResultHolder<class_1087> renderThirdPerson(class_1799 stack, class_763 shaper) {
        return ResultHolder.submit(shaper.method_3303().method_4742(this.handheld()));
    }

    @Override
    public Set<class_1091> registerModels() {
        return Set.of(this.handheld());
    }
}

