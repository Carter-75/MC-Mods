/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.valkyrienskies.core.impl.shadow.HW;
import org.valkyrienskies.core.impl.shadow.HX;
import org.valkyrienskies.core.impl.shadow.HZ;
import org.valkyrienskies.core.impl.shadow.hi_0;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0010\bf\u0018\u0000 .2\u00020\u0001:\u0001.J'\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\b\u0010\tJ'\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\f\u0010\tJ'\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\r\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u000e\u0010\tJ%\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\u0010\u000f\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\u0010\u0012\u001a\u00060\u0005j\u0002`\n2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0016\u001a\u00060\u0005j\u0002`\r2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&\u00a2\u0006\u0004\b\u001a\u0010\u001bJ3\u0010\u001c\u001a\u00020\u00072\n\u0010\u0016\u001a\u00060\u0005j\u0002`\r2\n\u0010\u0012\u001a\u00060\u0005j\u0002`\n2\n\u0010\u000f\u001a\u00060\u0005j\u0002`\u0006H&\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00078fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00138fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\u000b8fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u0006/"}, d2={"Lorg/valkyrienskies/physics_api/Lod1BlockRegistry;", "Ljava/lang/AutoCloseable;", "Lorg/valkyrienskies/physics_api/VSByteBuffer;", "vsByteBuffer", "", "", "Lorg/valkyrienskies/physics_api/Lod1BlockStateId;", "Lorg/valkyrienskies/physics_api/voxel/Lod1BlockState;", "getAllLod1BlockStates", "(Lorg/valkyrienskies/physics_api/VSByteBuffer;)Ljava/util/Map;", "Lorg/valkyrienskies/physics_api/Lod1LiquidBlockStateId;", "Lorg/valkyrienskies/physics_api/voxel/Lod1SolidBlockState;", "getAllLod1LiquidBlockStates", "Lorg/valkyrienskies/physics_api/Lod1SolidBlockStateId;", "getAllLod1SolidBlockStates", "lod1BlockStateId", "getLod1BlockState", "(ILorg/valkyrienskies/physics_api/VSByteBuffer;)Lorg/valkyrienskies/physics_api/voxel/Lod1BlockState;", "lod1LiquidBlockStateId", "Lorg/valkyrienskies/physics_api/voxel/Lod1LiquidBlockState;", "getLod1LiquidBlockState", "(ILorg/valkyrienskies/physics_api/VSByteBuffer;)Lorg/valkyrienskies/physics_api/voxel/Lod1LiquidBlockState;", "lod1SolidBlockStateId", "getLod1SolidBlockState", "(ILorg/valkyrienskies/physics_api/VSByteBuffer;)Lorg/valkyrienskies/physics_api/voxel/Lod1SolidBlockState;", "", "isDeleted", "()Z", "registerLod1BlockState", "(III)Lorg/valkyrienskies/physics_api/voxel/Lod1BlockState;", "lod1LiquidBlockState", "", "registerLod1LiquidBlockState", "(Lorg/valkyrienskies/physics_api/voxel/Lod1LiquidBlockState;Lorg/valkyrienskies/physics_api/VSByteBuffer;)V", "lod1SolidBlockState", "registerLod1SolidBlockState", "(Lorg/valkyrienskies/physics_api/voxel/Lod1SolidBlockState;Lorg/valkyrienskies/physics_api/VSByteBuffer;)V", "getAirBlockState", "()Lorg/valkyrienskies/physics_api/voxel/Lod1BlockState;", "airBlockState", "getLiquidAirBlockState", "()Lorg/valkyrienskies/physics_api/voxel/Lod1LiquidBlockState;", "liquidAirBlockState", "getSolidAirBlockState", "()Lorg/valkyrienskies/physics_api/voxel/Lod1SolidBlockState;", "solidAirBlockState", "Companion", "physics_api"})
public interface GU
extends AutoCloseable {
    public static final a a = org.valkyrienskies.core.impl.shadow.GU$a.a;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;

    public void a(HZ var1, hi_0 var2);

    public void a(HX var1, hi_0 var2);

    public HW a(int var1, int var2, int var3);

    public HZ a(int var1, hi_0 var2);

    public Map<Integer, HZ> a(hi_0 var1);

    public HX b(int var1, hi_0 var2);

    public Map<Integer, HZ> b(hi_0 var1);

    public HW c(int var1, hi_0 var2);

    public Map<Integer, HW> c(hi_0 var1);

    public boolean a();

    @JvmName(name="b")
    public HZ b();

    @JvmName(name="c")
    public HX c();

    @JvmName(name="d")
    public HW d();

    public static final class a {
        static final /* synthetic */ a a;
        private static int b = 0;
        private static int c = 0;
        private static int d = 0;

        private a() {
        }

        static {
            a = new a();
        }
    }
}

