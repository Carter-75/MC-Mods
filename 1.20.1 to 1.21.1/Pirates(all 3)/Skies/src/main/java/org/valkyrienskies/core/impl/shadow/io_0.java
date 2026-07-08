/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.ij_0;
import org.valkyrienskies.core.impl.shadow.il_0;
import org.valkyrienskies.core.impl.shadow.in_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Io
 */
@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011Jr\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022U\u0010\r\u001aQ\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\b\u0012\u00060\u0005j\u0002`\u000b\u0012\u0004\u0012\u00020\f0\u0004H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0012"}, d2={"Lorg/valkyrienskies/physics_api/voxel/updates/VoxelShapeUpdateIterator;", "", "Lorg/valkyrienskies/physics_api/voxel/updates/IVoxelShapeUpdate;", "voxelShapeUpdate", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "x", "y", "z", "Lorg/valkyrienskies/physics_api/Lod1BlockStateId;", "", "function", "forEachVoxel", "(Lorg/valkyrienskies/physics_api/voxel/updates/IVoxelShapeUpdate;Lkotlin/jvm/functions/Function4;)V", "<init>", "()V", "physics_api"})
public final class io_0 {
    public static final io_0 INSTANCE = new io_0();

    private io_0() {
    }

    private static void a(il_0 il_02, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter((Object)il_02, (String)"");
        Intrinsics.checkNotNullParameter(function4, (String)"");
        il_0 il_03 = il_02;
        if (il_03 instanceof ij_0) {
            il_02 = (ij_0)il_02;
            int n2 = 0;
            while (n2 < 16) {
                int n3 = n2++;
                int n4 = 0;
                while (n4 < 16) {
                    int n5 = n4++;
                    int n6 = 0;
                    while (n6 < 16) {
                        int n7 = n6++;
                        int n8 = n5;
                        int n9 = n3;
                        int n10 = n7;
                        function4.invoke((Object)n10, (Object)n9, (Object)n8, (Object)((ij_0)il_02).a(n10, n9, n8));
                    }
                }
            }
            return;
        }
        if (il_03 instanceof in_0) {
            il_02 = (in_0)il_02;
            int n11 = 0;
            il_0 il_04 = il_02;
            int n12 = ((in_0)il_04).e.size();
            while (n11 < n12) {
                int n13;
                int n14 = n11++;
                il_0 il_05 = il_02;
                int n15 = ((in_0)il_05).e.getShort(n14);
                il_05 = il_02;
                int n16 = ((in_0)il_05).f.getInt(n14);
                int n17 = n15;
                int n18 = n17 >> 8 & 0xF;
                int n19 = n17 >> 4 & 0xF;
                n14 = n13 = n17 & 0xF;
                n15 = n19;
                n17 = n18;
                function4.invoke((Object)n17, (Object)n15, (Object)n14, (Object)n16);
            }
        }
    }
}

