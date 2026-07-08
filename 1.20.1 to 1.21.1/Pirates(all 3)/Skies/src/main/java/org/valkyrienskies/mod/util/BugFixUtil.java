/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_238
 */
package org.valkyrienskies.mod.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_238;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lorg/valkyrienskies/mod/util/BugFixUtil;", "", "Lnet/minecraft/class_238;", "aabb", "", "isCollisionBoxTooBig", "(Lnet/minecraft/class_238;)Z", "<init>", "()V", "valkyrienskies-120"})
public final class BugFixUtil {
    @NotNull
    public static final BugFixUtil INSTANCE = new BugFixUtil();

    private BugFixUtil() {
    }

    public final boolean isCollisionBoxTooBig(@NotNull class_238 aabb) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        return aabb.method_17939() * aabb.method_17940() * aabb.method_17941() > 1.0E8;
    }
}

