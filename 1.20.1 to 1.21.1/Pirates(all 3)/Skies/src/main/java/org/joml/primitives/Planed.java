/*
 * Decompiled with CFR 0.152.
 */
package org.joml.primitives;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.NumberFormat;
import org.joml.Math;
import org.joml.Options;
import org.joml.Runtime;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.joml.Vector4d;
import org.joml.primitives.Intersectiond;

public class Planed
implements Externalizable {
    public double a;
    public double b;
    public double c;
    public double d;

    public Planed() {
    }

    public Planed(Planed source) {
        this.a = source.a;
        this.b = source.b;
        this.c = source.c;
        this.d = source.d;
    }

    public Planed(Vector3dc point, Vector3dc normal) {
        this.a = normal.x();
        this.b = normal.y();
        this.c = normal.z();
        this.d = -this.a * point.x() - this.b * point.y() - this.c * point.z();
    }

    public Planed(double a2, double b2, double c2, double d2) {
        this.a = a2;
        this.b = b2;
        this.c = c2;
        this.d = d2;
    }

    public Planed(Vector3dc pointA, Vector3dc pointB, Vector3dc pointC) {
        double abX = pointB.x() - pointA.x();
        double abY = pointB.y() - pointA.y();
        double abZ = pointB.z() - pointA.z();
        double acX = pointC.x() - pointA.x();
        double acY = pointC.y() - pointA.y();
        double acZ = pointC.z() - pointA.z();
        this.a = abY * acZ - abZ * acY;
        this.b = abZ * acX - abX * acZ;
        this.c = abX * acY - abY * acX;
        this.d = -this.a * pointA.x() - this.b * pointA.y() - this.c * pointA.z();
    }

    public Planed(Vector3fc pointA, Vector3fc pointB, Vector3fc pointC) {
        double abX = pointB.x() - pointA.x();
        double abY = pointB.y() - pointA.y();
        double abZ = pointB.z() - pointA.z();
        double acX = pointC.x() - pointA.x();
        double acY = pointC.y() - pointA.y();
        double acZ = pointC.z() - pointA.z();
        this.a = abY * acZ - abZ * acY;
        this.b = abZ * acX - abX * acZ;
        this.c = abX * acY - abY * acX;
        this.d = -this.a * (double)pointA.x() - this.b * (double)pointA.y() - this.c * (double)pointA.z();
    }

    public Planed set(double a2, double b2, double c2, double d2) {
        this.a = a2;
        this.b = b2;
        this.c = c2;
        this.d = d2;
        return this;
    }

    public Planed normalize() {
        return this.normalize(this);
    }

    public Planed normalize(Planed dest) {
        double invLength = Math.invsqrt(this.a * this.a + this.b * this.b + this.c * this.c);
        dest.a = this.a * invLength;
        dest.b = this.b * invLength;
        dest.c = this.c * invLength;
        dest.d = this.d * invLength;
        return dest;
    }

    public double distance(double x, double y, double z) {
        return Intersectiond.distancePointPlane(x, y, z, this.a, this.b, this.c, this.d);
    }

    public static Vector4d equationFromPoints(Vector3d v0, Vector3d v1, Vector3d v2, Vector4d dest) {
        return Planed.equationFromPoints(v0.x, v0.y, v0.z, v1.x, v1.y, v1.z, v2.x, v2.y, v2.z, dest);
    }

    public static Vector4d equationFromPoints(double v0X, double v0Y, double v0Z, double v1X, double v1Y, double v1Z, double v2X, double v2Y, double v2Z, Vector4d dest) {
        double v1Y0Y = v1Y - v0Y;
        double v2Z0Z = v2Z - v0Z;
        double v2Y0Y = v2Y - v0Y;
        double v1Z0Z = v1Z - v0Z;
        double v2X0X = v2X - v0X;
        double v1X0X = v1X - v0X;
        double a2 = v1Y0Y * v2Z0Z - v2Y0Y * v1Z0Z;
        double b2 = v1Z0Z * v2X0X - v2Z0Z * v1X0X;
        double c2 = v1X0X * v2Y0Y - v2X0X * v1Y0Y;
        double d2 = -(a2 * v0X + b2 * v0Y + c2 * v0Z);
        dest.x = a2;
        dest.y = b2;
        dest.z = c2;
        dest.w = d2;
        return dest;
    }

    public int hashCode() {
        int prime = 31;
        int result2 = 1;
        long temp = Double.doubleToLongBits(this.a);
        result2 = 31 * result2 + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.b);
        result2 = 31 * result2 + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.c);
        result2 = 31 * result2 + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.d);
        result2 = 31 * result2 + (int)(temp ^ temp >>> 32);
        return result2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Planed other = (Planed)obj;
        if (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(other.a)) {
            return false;
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(other.b)) {
            return false;
        }
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(other.c)) {
            return false;
        }
        return Double.doubleToLongBits(this.d) == Double.doubleToLongBits(other.d);
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "[" + Runtime.format(this.a, formatter) + " " + Runtime.format(this.b, formatter) + " " + Runtime.format(this.c, formatter) + " " + Runtime.format(this.d, formatter) + "]";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(this.a);
        out.writeDouble(this.b);
        out.writeDouble(this.c);
        out.writeDouble(this.d);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.a = in.readDouble();
        this.b = in.readDouble();
        this.c = in.readDouble();
        this.d = in.readDouble();
    }
}

