/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.BiMap
 *  dev.emi.emi.api.EmiPlugin
 *  dev.emi.emi.api.EmiRegistry
 *  dev.emi.emi.api.recipe.EmiRecipe
 *  dev.emi.emi.api.recipe.EmiWorldInteractionRecipe
 *  dev.emi.emi.api.recipe.EmiWorldInteractionRecipe$Builder
 *  dev.emi.emi.api.stack.EmiIngredient
 *  dev.emi.emi.api.stack.EmiStack
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_5953
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.compat.emi;

import com.google.common.collect.BiMap;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiWorldInteractionRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.item.StaffItemKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_5953;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\u00020\n*\u00020\tH\u0002\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Ldev/mim1q/derelict/compat/emi/EmiDerelictPlugin;", "Ldev/emi/emi/api/EmiPlugin;", "<init>", "()V", "Ldev/emi/emi/api/EmiRegistry;", "registry", "", "register", "(Ldev/emi/emi/api/EmiRegistry;)V", "Lnet/minecraft/class_1935;", "Ldev/emi/emi/api/stack/EmiStack;", "emiStack", "(Lnet/minecraft/class_1935;)Ldev/emi/emi/api/stack/EmiStack;", "derelict"})
@SourceDebugExtension(value={"SMAP\nEmiDerelictPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmiDerelictPlugin.kt\ndev/mim1q/derelict/compat/emi/EmiDerelictPlugin\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,37:1\n216#2,2:38\n216#2,2:40\n*S KotlinDebug\n*F\n+ 1 EmiDerelictPlugin.kt\ndev/mim1q/derelict/compat/emi/EmiDerelictPlugin\n*L\n15#1:38,2\n25#1:40,2\n*E\n"})
public final class EmiDerelictPlugin
implements EmiPlugin {
    @NotNull
    public static final EmiDerelictPlugin INSTANCE = new EmiDerelictPlugin();

    private EmiDerelictPlugin() {
    }

    public void register(@NotNull EmiRegistry registry) {
        Intrinsics.checkNotNullParameter((Object)registry, (String)"registry");
        BiMap biMap = (BiMap)class_5953.field_29560.get();
        if (biMap != null) {
            Map $this$forEach$iv = (Map)biMap;
            boolean $i$f$forEach = false;
            Iterator iterator = $this$forEach$iv.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry element$iv;
                Map.Entry it = element$iv = iterator.next();
                boolean bl = false;
                EmiWorldInteractionRecipe.Builder builder = EmiWorldInteractionRecipe.builder();
                Object k = it.getKey();
                Intrinsics.checkNotNullExpressionValue(k, (String)"<get-key>(...)");
                EmiWorldInteractionRecipe.Builder builder2 = builder.leftInput((EmiIngredient)INSTANCE.emiStack((class_1935)k)).rightInput((EmiIngredient)EmiStack.of((class_1935)((class_1935)ModBlocksAndItems.INSTANCE.getWAXING_STAFF())), true);
                Object v = it.getValue();
                Intrinsics.checkNotNullExpressionValue(v, (String)"<get-value>(...)");
                registry.addRecipe((EmiRecipe)builder2.output(INSTANCE.emiStack((class_1935)v)).build());
            }
        }
        Map<class_2248, class_2248> $this$forEach$iv = StaffItemKt.getFullAgingMap();
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<class_2248, class_2248>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<class_2248, class_2248> element$iv;
            Map.Entry<class_2248, class_2248> it = element$iv = iterator.next();
            boolean bl = false;
            registry.addRecipe((EmiRecipe)EmiWorldInteractionRecipe.builder().leftInput((EmiIngredient)INSTANCE.emiStack((class_1935)it.getKey())).rightInput((EmiIngredient)EmiStack.of((class_1935)((class_1935)ModBlocksAndItems.INSTANCE.getAGING_STAFF())), true).output(INSTANCE.emiStack((class_1935)it.getValue())).build());
        }
    }

    private final EmiStack emiStack(class_1935 $this$emiStack) {
        EmiStack emiStack = EmiStack.of((class_1935)$this$emiStack);
        Intrinsics.checkNotNullExpressionValue((Object)emiStack, (String)"of(...)");
        return emiStack;
    }
}

