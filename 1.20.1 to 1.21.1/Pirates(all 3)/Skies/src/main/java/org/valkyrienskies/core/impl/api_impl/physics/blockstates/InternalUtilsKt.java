/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.api_impl.physics.blockstates;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.joml.primitives.AABBic;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0006\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\b\u001a\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0006\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2={"Lkotlin/Function0;", "", "name", "", "value", "", "require4bits", "(Lkotlin/jvm/functions/Function0;I)V", "(Ljava/lang/String;I)V", "Lorg/joml/primitives/AABBic;", "aabb", "(Ljava/lang/String;Lorg/joml/primitives/AABBic;)V"})
public final class InternalUtilsKt {
    /*
     * WARNING - void declaration
     */
    public static final void require4bits(String name, AABBic aabb) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)name, (String)"");
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"");
        int n2 = aabb.minX();
        if (!(n2 >= 0 ? n2 < 16 : false)) {
            name = (String)name + ".minX" + " must be >= 0 and <= 15, but is " + n2;
            throw new IllegalArgumentException(name.toString());
        }
        n2 = aabb.minY();
        if (!(n2 >= 0 ? n2 < 16 : false)) {
            name = (String)name + ".minY" + " must be >= 0 and <= 15, but is " + n2;
            throw new IllegalArgumentException(name.toString());
        }
        n2 = aabb.minZ();
        if (!(n2 >= 0 ? n2 < 16 : false)) {
            name = (String)name + ".minZ" + " must be >= 0 and <= 15, but is " + n2;
            throw new IllegalArgumentException(name.toString());
        }
        n2 = aabb.maxX();
        if (!(n2 >= 0 ? n2 < 16 : false)) {
            name = (String)name + ".maxX" + " must be >= 0 and <= 15, but is " + n2;
            throw new IllegalArgumentException(name.toString());
        }
        n2 = aabb.maxY();
        if (!(n2 >= 0 ? n2 < 16 : false)) {
            name = (String)name + ".maxY" + " must be >= 0 and <= 15, but is " + n2;
            throw new IllegalArgumentException(name.toString());
        }
        n2 = var1_1.maxZ();
        if (!(n2 >= 0 ? n2 < 16 : false)) {
            String string;
            string = (String)string + ".maxZ" + " must be >= 0 and <= 15, but is " + n2;
            throw new IllegalArgumentException(string.toString());
        }
    }

    /*
     * WARNING - void declaration
     */
    public static final void require4bits(String name, int value) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"");
        if (!(value >= 0 ? value < 16 : false)) {
            void var1_1;
            String string;
            string = string + " must be >= 0 and <= 15, but is " + (int)var1_1;
            throw new IllegalArgumentException(string.toString());
        }
    }

    /*
     * WARNING - void declaration
     */
    public static final void require4bits(Function0<String> name, int value) {
        Intrinsics.checkNotNullParameter(name, (String)"");
        if (!(value >= 0 ? value < 16 : false)) {
            void var1_1;
            String string;
            string = string.invoke() + " must be >= 0 and <= 15, but is " + (int)var1_1;
            throw new IllegalArgumentException(string.toString());
        }
    }
}

