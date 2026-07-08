/*
 * Decompiled with CFR 0.152.
 */
package org.joml.primitives;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.NumberFormat;
import org.joml.Options;
import org.joml.Runtime;
import org.joml.Vector3dc;
import org.joml.Vector3fc;

public class Sphered
implements Externalizable {
    public double x;
    public double y;
    public double z;
    public double r;

    public Sphered() {
    }

    public Sphered(Sphered source) {
        this.x = source.x;
        this.y = source.y;
        this.z = source.z;
        this.r = source.r;
    }

    public Sphered(Vector3fc c2, double r) {
        this.x = c2.x();
        this.y = c2.y();
        this.z = c2.z();
        this.r = r;
    }

    public Sphered(Vector3dc c2, double r) {
        this.x = c2.x();
        this.y = c2.y();
        this.z = c2.z();
        this.r = r;
    }

    public Sphered(double x, double y, double z, double r) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
    }

    public Sphered translate(Vector3dc xyz) {
        return this.translate(xyz.x(), xyz.y(), xyz.z(), this);
    }

    public Sphered translate(Vector3dc xyz, Sphered dest) {
        return this.translate(xyz.x(), xyz.y(), xyz.z(), dest);
    }

    public Sphered translate(Vector3fc xyz) {
        return this.translate(xyz.x(), xyz.y(), xyz.z(), this);
    }

    public Sphered translate(Vector3fc xyz, Sphered dest) {
        return this.translate(xyz.x(), xyz.y(), xyz.z(), dest);
    }

    public Sphered translate(double x, double y, double z) {
        return this.translate(x, y, z, this);
    }

    public Sphered translate(double x, double y, double z, Sphered dest) {
        dest.x = this.x + x;
        dest.y = this.y + y;
        dest.z = this.z + z;
        return dest;
    }

    public int hashCode() {
        int prime = 31;
        int result2 = 1;
        long temp = Double.doubleToLongBits(this.r);
        result2 = 31 * result2 + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.x);
        result2 = 31 * result2 + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.y);
        result2 = 31 * result2 + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.z);
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
        Sphered other = (Sphered)obj;
        if (Double.doubleToLongBits(this.r) != Double.doubleToLongBits(other.r)) {
            return false;
        }
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return Double.doubleToLongBits(this.z) == Double.doubleToLongBits(other.z);
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "[" + Runtime.format(this.x, formatter) + " " + Runtime.format(this.y, formatter) + " " + Runtime.format(this.z, formatter) + " " + Runtime.format(this.r, formatter) + "]";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(this.x);
        out.writeDouble(this.y);
        out.writeDouble(this.z);
        out.writeDouble(this.r);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.x = in.readDouble();
        this.y = in.readDouble();
        this.z = in.readDouble();
        this.r = in.readDouble();
    }
}

