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
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;
import org.joml.primitives.Intersectionf;

public class Planef
implements Externalizable {
    public float a;
    public float b;
    public float c;
    public float d;

    public Planef() {
    }

    public Planef(Planef source) {
        this.a = source.a;
        this.b = source.b;
        this.c = source.c;
        this.d = source.d;
    }

    public Planef(Vector3fc point, Vector3fc normal) {
        this.a = normal.x();
        this.b = normal.y();
        this.c = normal.z();
        this.d = -this.a * point.x() - this.b * point.y() - this.c * point.z();
    }

    public Planef(Vector3fc pointA, Vector3fc pointB, Vector3fc pointC) {
        float abX = pointB.x() - pointA.x();
        float abY = pointB.y() - pointA.y();
        float abZ = pointB.z() - pointA.z();
        float acX = pointC.x() - pointA.x();
        float acY = pointC.y() - pointA.y();
        float acZ = pointC.z() - pointA.z();
        this.a = abY * acZ - abZ * acY;
        this.b = abZ * acX - abX * acZ;
        this.c = abX * acY - abY * acX;
        this.d = -this.a * pointA.x() - this.b * pointA.y() - this.c * pointA.z();
    }

    public Planef(float a2, float b2, float c2, float d2) {
        this.a = a2;
        this.b = b2;
        this.c = c2;
        this.d = d2;
    }

    public Planef set(float a2, float b2, float c2, float d2) {
        this.a = a2;
        this.b = b2;
        this.c = c2;
        this.d = d2;
        return this;
    }

    public Planef normalize() {
        return this.normalize(this);
    }

    public Planef normalize(Planef dest) {
        float invLength = Math.invsqrt(this.a * this.a + this.b * this.b + this.c * this.c);
        dest.a = this.a * invLength;
        dest.b = this.b * invLength;
        dest.c = this.c * invLength;
        dest.d = this.d * invLength;
        return dest;
    }

    public float distance(float x, float y, float z) {
        return Intersectionf.distancePointPlane(x, y, z, this.a, this.b, this.c, this.d);
    }

    public static Vector4f equationFromPoints(Vector3f v0, Vector3f v1, Vector3f v2, Vector4f dest) {
        return Planef.equationFromPoints(v0.x, v0.y, v0.z, v1.x, v1.y, v1.z, v2.x, v2.y, v2.z, dest);
    }

    public static Vector4f equationFromPoints(float v0X, float v0Y, float v0Z, float v1X, float v1Y, float v1Z, float v2X, float v2Y, float v2Z, Vector4f dest) {
        float v1Y0Y = v1Y - v0Y;
        float v2Z0Z = v2Z - v0Z;
        float v2Y0Y = v2Y - v0Y;
        float v1Z0Z = v1Z - v0Z;
        float v2X0X = v2X - v0X;
        float v1X0X = v1X - v0X;
        float a2 = v1Y0Y * v2Z0Z - v2Y0Y * v1Z0Z;
        float b2 = v1Z0Z * v2X0X - v2Z0Z * v1X0X;
        float c2 = v1X0X * v2Y0Y - v2X0X * v1Y0Y;
        float d2 = -(a2 * v0X + b2 * v0Y + c2 * v0Z);
        dest.x = a2;
        dest.y = b2;
        dest.z = c2;
        dest.w = d2;
        return dest;
    }

    public int hashCode() {
        int prime = 31;
        int result2 = 1;
        result2 = 31 * result2 + Float.floatToIntBits(this.a);
        result2 = 31 * result2 + Float.floatToIntBits(this.b);
        result2 = 31 * result2 + Float.floatToIntBits(this.c);
        result2 = 31 * result2 + Float.floatToIntBits(this.d);
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
        Planef other = (Planef)obj;
        if (Float.floatToIntBits(this.a) != Float.floatToIntBits(other.a)) {
            return false;
        }
        if (Float.floatToIntBits(this.b) != Float.floatToIntBits(other.b)) {
            return false;
        }
        if (Float.floatToIntBits(this.c) != Float.floatToIntBits(other.c)) {
            return false;
        }
        return Float.floatToIntBits(this.d) == Float.floatToIntBits(other.d);
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "[" + Runtime.format(this.a, formatter) + " " + Runtime.format(this.b, formatter) + " " + Runtime.format(this.c, formatter) + " " + Runtime.format(this.d, formatter) + "]";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeFloat(this.a);
        out.writeFloat(this.b);
        out.writeFloat(this.c);
        out.writeFloat(this.d);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.a = in.readFloat();
        this.b = in.readFloat();
        this.c = in.readFloat();
        this.d = in.readFloat();
    }
}

