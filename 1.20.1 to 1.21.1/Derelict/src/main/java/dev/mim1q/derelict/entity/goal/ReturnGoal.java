/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1308
 *  net.minecraft.class_1352
 *  net.minecraft.class_1352$class_4134
 *  net.minecraft.class_2338
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.entity.goal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1308;
import net.minecraft.class_1352;
import net.minecraft.class_2338;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B-\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0011R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012\u00a8\u0006\u0013"}, d2={"Ldev/mim1q/derelict/entity/goal/ReturnGoal;", "Lnet/minecraft/class_1308;", "T", "Lnet/minecraft/class_1352;", "entity", "Lkotlin/Function0;", "", "predicate", "Lnet/minecraft/class_2338;", "posGetter", "<init>", "(Lnet/minecraft/class_1308;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "", "tick", "()V", "canStart", "()Z", "Lnet/minecraft/class_1308;", "Lkotlin/jvm/functions/Function0;", "derelict"})
public final class ReturnGoal<T extends class_1308>
extends class_1352 {
    @NotNull
    private final T entity;
    @NotNull
    private final Function0<Boolean> predicate;
    @NotNull
    private final Function0<class_2338> posGetter;

    public ReturnGoal(@NotNull T entity, @NotNull Function0<Boolean> predicate, @NotNull Function0<? extends class_2338> posGetter) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
        Intrinsics.checkNotNullParameter(posGetter, (String)"posGetter");
        this.entity = entity;
        this.predicate = predicate;
        this.posGetter = posGetter;
        this.method_6271().add(class_1352.class_4134.field_18405);
    }

    public void method_6268() {
        super.method_6268();
        class_2338 pos = (class_2338)this.posGetter.invoke();
        if (pos != null) {
            this.entity.method_5942().method_6337((double)pos.method_10263() + 0.5, (double)pos.method_10264(), (double)pos.method_10260() + 0.5, 0.7);
        }
    }

    public boolean method_6264() {
        return this.posGetter.invoke() != null && (Boolean)this.predicate.invoke() != false;
    }
}

