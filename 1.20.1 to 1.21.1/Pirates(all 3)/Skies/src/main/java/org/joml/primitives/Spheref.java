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
import org.joml.Vector3fc;

public class Spheref
implements Externalizable {
    public float x;
    public float y;
    public float z;
    public float r;

    public Spheref() {
    }

    public Spheref(Spheref source) {
        this.x = source.x;
        this.y = source.y;
        this.z = source.z;
        this.r = source.r;
    }

    public Spheref(Vector3fc c2, float r) {
        this.x = c2.x();
        this.y = c2.y();
        this.z = c2.z();
        this.r = r;
    }

    public Spheref(float x, float y, float z, float r) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
    }

    public Spheref translate(Vector3fc xyz) {
        return this.translate(xyz.x(), xyz.y(), xyz.z(), this);
    }

    public Spheref translate(Vector3fc xyz, Spheref dest) {
        return this.translate(xyz.x(), xyz.y(), xyz.z(), dest);
    }

    public Spheref translate(float x, float y, float z) {
        return this.translate(x, y, z, this);
    }

    public Spheref translate(float x, float y, float z, Spheref dest) {
        dest.x = this.x + x;
        dest.y = this.y + y;
        dest.z = this.z + z;
        return dest;
    }

    public int hashCode() {
        int prime = 31;
        int result2 = 1;
        result2 = 31 * result2 + Float.floatToIntBits(this.r);
        result2 = 31 * result2 + Float.floatToIntBits(this.x);
        result2 = 31 * result2 + Float.floatToIntBits(this.y);
        result2 = 31 * result2 + Float.floatToIntBits(this.z);
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
        Spheref other = (Spheref)obj;
        if (Float.floatToIntBits(this.r) != Float.floatToIntBits(other.r)) {
            return false;
        }
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
            return false;
        }
        if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
            return false;
        }
        return Float.floatToIntBits(this.z) == Float.floatToIntBits(other.z);
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "[" + Runtime.format(this.x, formatter) + " " + Runtime.format(this.y, formatter) + " " + Runtime.format(this.z, formatter) + " " + Runtime.format(this.r, formatter) + "]";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeFloat(this.x);
        out.writeFloat(this.y);
        out.writeFloat(this.z);
        out.writeFloat(this.r);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.x = in.readFloat();
        this.y = in.readFloat();
        this.z = in.readFloat();
        this.r = in.readFloat();
    }
}

