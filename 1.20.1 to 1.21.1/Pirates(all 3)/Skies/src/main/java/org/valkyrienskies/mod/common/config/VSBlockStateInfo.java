/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2960
 */
package org.valkyrienskies.mod.common.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2960;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\nJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJN\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\rH\u00c6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001\u00a2\u0006\u0004\b\u001c\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u001dH\u00d6\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u0007R\u0017\u0010\u0012\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\nR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b&\u0010\nR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b'\u0010\nR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\u000f\u00a8\u0006,"}, d2={"Lorg/valkyrienskies/mod/common/config/VSBlockStateInfo;", "", "Lnet/minecraft/class_2960;", "component1", "()Lnet/minecraft/class_2960;", "", "component2", "()I", "", "component3", "()D", "component4", "component5", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "component6", "()Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "id", "priority", "mass", "friction", "elasticity", "type", "copy", "(Lnet/minecraft/class_2960;IDDDLorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;)Lorg/valkyrienskies/mod/common/config/VSBlockStateInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Lnet/minecraft/class_2960;", "getId", "I", "getPriority", "D", "getMass", "getFriction", "getElasticity", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "getType", "<init>", "(Lnet/minecraft/class_2960;IDDDLorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;)V", "valkyrienskies-120"})
final class VSBlockStateInfo {
    @NotNull
    private final class_2960 id;
    private final int priority;
    private final double mass;
    private final double friction;
    private final double elasticity;
    @Nullable
    private final VsiBlockType type;

    public VSBlockStateInfo(@NotNull class_2960 id, int priority, double mass, double friction, double elasticity, @Nullable VsiBlockType type) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        this.id = id;
        this.priority = priority;
        this.mass = mass;
        this.friction = friction;
        this.elasticity = elasticity;
        this.type = type;
    }

    @NotNull
    public final class_2960 getId() {
        return this.id;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final double getMass() {
        return this.mass;
    }

    public final double getFriction() {
        return this.friction;
    }

    public final double getElasticity() {
        return this.elasticity;
    }

    @Nullable
    public final VsiBlockType getType() {
        return this.type;
    }

    @NotNull
    public final class_2960 component1() {
        return this.id;
    }

    public final int component2() {
        return this.priority;
    }

    public final double component3() {
        return this.mass;
    }

    public final double component4() {
        return this.friction;
    }

    public final double component5() {
        return this.elasticity;
    }

    @Nullable
    public final VsiBlockType component6() {
        return this.type;
    }

    @NotNull
    public final VSBlockStateInfo copy(@NotNull class_2960 id, int priority, double mass, double friction, double elasticity, @Nullable VsiBlockType type) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        return new VSBlockStateInfo(id, priority, mass, friction, elasticity, type);
    }

    public static /* synthetic */ VSBlockStateInfo copy$default(VSBlockStateInfo vSBlockStateInfo, class_2960 class_29602, int n2, double d2, double d3, double d4, VsiBlockType vsiBlockType, int n3, Object object) {
        if ((n3 & 1) != 0) {
            class_29602 = vSBlockStateInfo.id;
        }
        if ((n3 & 2) != 0) {
            n2 = vSBlockStateInfo.priority;
        }
        if ((n3 & 4) != 0) {
            d2 = vSBlockStateInfo.mass;
        }
        if ((n3 & 8) != 0) {
            d3 = vSBlockStateInfo.friction;
        }
        if ((n3 & 0x10) != 0) {
            d4 = vSBlockStateInfo.elasticity;
        }
        if ((n3 & 0x20) != 0) {
            vsiBlockType = vSBlockStateInfo.type;
        }
        return vSBlockStateInfo.copy(class_29602, n2, d2, d3, d4, vsiBlockType);
    }

    @NotNull
    public String toString() {
        return "VSBlockStateInfo(id=" + this.id + ", priority=" + this.priority + ", mass=" + this.mass + ", friction=" + this.friction + ", elasticity=" + this.elasticity + ", type=" + this.type + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + Integer.hashCode(this.priority);
        result2 = result2 * 31 + Double.hashCode(this.mass);
        result2 = result2 * 31 + Double.hashCode(this.friction);
        result2 = result2 * 31 + Double.hashCode(this.elasticity);
        result2 = result2 * 31 + (this.type == null ? 0 : this.type.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSBlockStateInfo)) {
            return false;
        }
        VSBlockStateInfo vSBlockStateInfo = (VSBlockStateInfo)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)vSBlockStateInfo.id)) {
            return false;
        }
        if (this.priority != vSBlockStateInfo.priority) {
            return false;
        }
        if (Double.compare(this.mass, vSBlockStateInfo.mass) != 0) {
            return false;
        }
        if (Double.compare(this.friction, vSBlockStateInfo.friction) != 0) {
            return false;
        }
        if (Double.compare(this.elasticity, vSBlockStateInfo.elasticity) != 0) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.type, (Object)vSBlockStateInfo.type);
    }
}

