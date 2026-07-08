/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.valkyrienskies.core.impl.game.ChunkAllocator;
import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.impl.shadow.DQ;
import org.valkyrienskies.core.impl.shadow.dw_1;
import org.valkyrienskies.core.impl.shadow.dx_1;

@dw_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR!\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028G\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R*\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\t8GX\u0087\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\b\u0010\u0007"}, d2={"Lorg/valkyrienskies/core/impl/shadow/EC;", "", "", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "Lorg/valkyrienskies/core/impl/shadow/DP;", "b", "()Ljava/util/Map;", "a", "", "Ljava/util/Map;", "<init>", "()V"})
public final class EC {
    final Map<String, DP> a = new LinkedHashMap();

    @dx_1
    @Named(value="mutableDimensionInfo")
    @JvmName(name="a")
    public final Map<String, DP> a() {
        return this.a;
    }

    @dx_1
    @Named(value="dimensionInfo")
    @JvmName(name="b")
    public final Map<String, DP> b() {
        return this.a;
    }

    @dw_1
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/shadow/EC$a;", "", "a"})
    public static interface org.valkyrienskies.core.impl.shadow.EC$a {
        public static final a a = a.a;

        public static final class a {
            static final /* synthetic */ a a;

            private a() {
            }

            @dx_1
            public static ChunkAllocatorProvider a() {
                return new DQ(ChunkAllocator.Companion.create());
            }

            static {
                a = new a();
            }
        }
    }
}

