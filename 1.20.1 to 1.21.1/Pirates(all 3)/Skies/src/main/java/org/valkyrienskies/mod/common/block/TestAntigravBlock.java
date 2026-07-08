/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2343
 *  net.minecraft.class_2498
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_4970$class_2251
 */
package org.valkyrienskies.mod.common.block;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2498;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.mod.common.blockentity.TestAntigravBlockEntity;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ!\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lorg/valkyrienskies/mod/common/block/TestAntigravBlock;", "Lnet/minecraft/class_2248;", "Lnet/minecraft/class_2343;", "Lnet/minecraft/class_2338;", "blockPos", "Lnet/minecraft/class_2680;", "blockState", "Lnet/minecraft/class_2586;", "newBlockEntity", "(Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)Lnet/minecraft/class_2586;", "<init>", "()V", "valkyrienskies-120"})
public final class TestAntigravBlock
extends class_2248
implements class_2343 {
    @NotNull
    public static final TestAntigravBlock INSTANCE = new TestAntigravBlock();

    private TestAntigravBlock() {
        super(class_4970.class_2251.method_9637().method_9629(1.0f, 120.0f).method_9626(class_2498.field_11544));
    }

    @Nullable
    public class_2586 method_10123(@NotNull class_2338 blockPos, @NotNull class_2680 blockState) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        return new TestAntigravBlockEntity(blockPos, blockState);
    }
}

