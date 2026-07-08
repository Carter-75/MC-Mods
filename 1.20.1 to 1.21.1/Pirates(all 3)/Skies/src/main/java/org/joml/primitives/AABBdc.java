/*
 * Decompiled with CFR 0.152.
 */
package org.joml.primitives;

import org.joml.Matrix4dc;
import org.joml.Vector2d;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBfc;
import org.joml.primitives.AABBic;
import org.joml.primitives.LineSegmentf;
import org.joml.primitives.Planed;
import org.joml.primitives.Rayd;
import org.joml.primitives.Spheref;

public interface AABBdc {
    public double minX();

    public double minY();

    public double minZ();

    public double maxX();

    public double maxY();

    public double maxZ();

    public boolean isValid();

    public double getMax(int var1);

    public double getMin(int var1);

    public Vector3d center(Vector3d var1);

    public Vector3f center(Vector3f var1);

    public Vector3d extent(Vector3d var1);

    public Vector3f extent(Vector3f var1);

    public AABBd union(double var1, double var3, double var5, AABBd var7);

    public AABBd union(Vector3dc var1, AABBd var2);

    public AABBd union(AABBdc var1, AABBd var2);

    public AABBd translate(Vector3dc var1, AABBd var2);

    public AABBd translate(Vector3fc var1, AABBd var2);

    public AABBd translate(double var1, double var3, double var5, AABBd var7);

    public AABBd intersection(AABBdc var1, AABBd var2);

    public boolean containsAABB(AABBdc var1);

    public boolean containsAABB(AABBfc var1);

    public boolean containsAABB(AABBic var1);

    public boolean containsPoint(double var1, double var3, double var5);

    public boolean containsPoint(Vector3dc var1);

    public boolean intersectsPlane(double var1, double var3, double var5, double var7);

    public boolean intersectsPlane(Planed var1);

    public boolean intersectsAABB(AABBd var1);

    public boolean intersectsSphere(double var1, double var3, double var5, double var7);

    public boolean intersectsSphere(Spheref var1);

    public boolean intersectsRay(double var1, double var3, double var5, double var7, double var9, double var11);

    public boolean intersectsRay(Rayd var1);

    public boolean intersectsRay(double var1, double var3, double var5, double var7, double var9, double var11, Vector2d var13);

    public boolean intersectsRay(Rayd var1, Vector2d var2);

    public int intersectsLineSegment(double var1, double var3, double var5, double var7, double var9, double var11, Vector2d var13);

    public int intersectsLineSegment(LineSegmentf var1, Vector2d var2);

    public AABBd transform(Matrix4dc var1, AABBd var2);
}

