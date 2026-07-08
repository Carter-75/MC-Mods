/*
 * Decompiled with CFR 0.152.
 */
package org.joml.primitives;

import java.text.NumberFormat;
import org.joml.Matrix4fc;
import org.joml.Vector2f;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBf;
import org.joml.primitives.AABBic;
import org.joml.primitives.LineSegmentf;
import org.joml.primitives.Planef;
import org.joml.primitives.Rayf;
import org.joml.primitives.Spheref;

public interface AABBfc {
    public float minX();

    public float minY();

    public float minZ();

    public float maxX();

    public float maxY();

    public float maxZ();

    public boolean isValid();

    public float getMax(int var1);

    public float getMin(int var1);

    public Vector3f center(Vector3f var1);

    public Vector3d center(Vector3d var1);

    public Vector3d extent(Vector3d var1);

    public Vector3f extent(Vector3f var1);

    public AABBf union(float var1, float var2, float var3, AABBf var4);

    public AABBf union(Vector3fc var1, AABBf var2);

    public AABBf union(AABBf var1, AABBf var2);

    public AABBf translate(Vector3fc var1, AABBf var2);

    public AABBf translate(float var1, float var2, float var3, AABBf var4);

    public AABBf intersection(AABBfc var1, AABBf var2);

    public boolean containsAABB(AABBdc var1);

    public boolean containsAABB(AABBfc var1);

    public boolean containsAABB(AABBic var1);

    public boolean containsPoint(float var1, float var2, float var3);

    public boolean containsPoint(Vector3fc var1);

    public boolean intersectsPlane(float var1, float var2, float var3, float var4);

    public boolean intersectsPlane(Planef var1);

    public boolean intersectsAABB(AABBfc var1);

    public boolean intersectsSphere(float var1, float var2, float var3, float var4);

    public boolean intersectsSphere(Spheref var1);

    public boolean intersectsRay(float var1, float var2, float var3, float var4, float var5, float var6);

    public boolean intersectsRay(Rayf var1);

    public boolean intersectsRay(float var1, float var2, float var3, float var4, float var5, float var6, Vector2f var7);

    public boolean intersectsRay(Rayf var1, Vector2f var2);

    public int intersectsLineSegment(float var1, float var2, float var3, float var4, float var5, float var6, Vector2f var7);

    public int intersectsLineSegment(LineSegmentf var1, Vector2f var2);

    public AABBf transform(Matrix4fc var1, AABBf var2);

    public String toString(NumberFormat var1);
}

