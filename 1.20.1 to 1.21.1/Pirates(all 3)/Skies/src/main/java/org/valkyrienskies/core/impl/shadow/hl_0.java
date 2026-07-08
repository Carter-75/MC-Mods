/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.joml.Vector3dc;
import org.joml.primitives.AABBi;
import org.valkyrienskies.core.impl.shadow.GS;
import org.valkyrienskies.core.impl.shadow.GU;
import org.valkyrienskies.core.impl.shadow.ig_0;
import org.valkyrienskies.physics_api_krunch.voxel.KrunchUnsafeVoxelChunk16Reference;
import org.valkyrienskies.physics_api_krunch.voxel.KrunchVoxelChunk16;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Hl
 */
public interface hl_0
extends GS {
    public KrunchVoxelChunk16 a(int var1, int var2, int var3, ig_0 var4);

    public void b(int var1, int var2, int var3, ig_0 var4);

    public KrunchVoxelChunk16 a(int var1, int var2, int var3);

    public void b(int var1, int var2, int var3);

    public KrunchVoxelChunk16 c(int var1, int var2, int var3);

    public void d(int var1, int var2, int var3);

    public void a();

    public boolean i_();

    public KrunchVoxelChunk16 e(int var1, int var2, int var3);

    public boolean f(int var1, int var2, int var3);

    public KrunchUnsafeVoxelChunk16Reference g(int var1, int var2, int var3);

    public void a(int var1, int var2, int var3, int var4, int var5, int var6);

    public boolean c();

    public void a(boolean var1);

    public int d();

    public boolean a(AABBi var1);

    public GU e();

    public Vector3dc f();

    public void a(Vector3dc var1);
}

