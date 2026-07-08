/*
 * Decompiled with CFR 0.152.
 */
package org.joml.primitives;

import org.joml.Matrix4fc;
import org.joml.Vector2f;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3ic;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBfc;
import org.joml.primitives.AABBi;
import org.joml.primitives.LineSegmentf;
import org.joml.primitives.Planef;
import org.joml.primitives.Rayf;
import org.joml.primitives.Spheref;

public interface AABBic {
    public int minX();

    public int minY();

    public int minZ();

    public int maxX();

    public int maxY();

    public int maxZ();

    public boolean isValid();

    public int getMax(int var1);

    public int getMin(int var1);

    public Vector3f center(Vector3f var1);

    public Vector3d center(Vector3d var1);

    public Vector3d extent(Vector3d var1);

    public Vector3f extent(Vector3f var1);

    public AABBi union(int var1, int var2, int var3, AABBi var4);

    public AABBi union(Vector3ic var1, AABBi var2);

    public AABBi union(AABBic var1, AABBi var2);

    public AABBi translate(int var1, int var2, int var3, AABBi var4);

    public AABBi intersection(AABBic var1, AABBi var2);

    public boolean containsAABB(AABBdc var1);

    public boolean containsAABB(AABBfc var1);

    public boolean containsAABB(AABBic var1);

    public boolean containsPoint(int var1, int var2, int var3);

    public boolean containsPoint(float var1, float var2, float var3);

    public boolean containsPoint(Vector3ic var1);

    public boolean containsPoint(Vector3fc var1);

    public boolean intersectsPlane(float var1, float var2, float var3, float var4);

    public boolean intersectsPlane(Planef var1);

    public boolean intersectsAABB(AABBic var1);

    public boolean intersectsAABB(AABBfc var1);

    public boolean intersectsSphere(float var1, float var2, float var3, float var4);

    public boolean intersectsSphere(Spheref var1);

    public boolean intersectsRay(float var1, float var2, float var3, float var4, float var5, float var6);

    public boolean intersectsRay(Rayf var1);

    public boolean intersectsRay(float var1, float var2, float var3, float var4, float var5, float var6, Vector2f var7);

    public boolean intersectsRay(Rayf var1, Vector2f var2);

    public int intersectLineSegment(float var1, float var2, float var3, float var4, float var5, float var6, Vector2f var7);

    public int intersectLineSegment(LineSegmentf var1, Vector2f var2);

    public AABBi transform(Matrix4fc var1, AABBi var2);
}

