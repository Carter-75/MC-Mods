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

public class LineSegmentf
implements Externalizable {
    public float aX;
    public float aY;
    public float aZ;
    public float bX;
    public float bY;
    public float bZ;

    public LineSegmentf() {
    }

    public LineSegmentf(LineSegmentf source) {
        this.aX = source.aX;
        this.aY = source.aY;
        this.aZ = source.aZ;
        this.aX = source.bX;
        this.bY = source.bY;
        this.bZ = source.bZ;
    }

    public LineSegmentf(Vector3fc a2, Vector3fc b2) {
        this.aX = a2.x();
        this.aY = a2.y();
        this.aZ = a2.z();
        this.bX = b2.x();
        this.bY = b2.y();
        this.bZ = b2.z();
    }

    public LineSegmentf(float aX, float aY, float aZ, float bX, float bY, float bZ) {
        this.aX = aX;
        this.aY = aY;
        this.aZ = aZ;
        this.bX = bX;
        this.bY = bY;
        this.bZ = bZ;
    }

    public int hashCode() {
        int prime = 31;
        int result2 = 1;
        result2 = 31 * result2 + Float.floatToIntBits(this.aX);
        result2 = 31 * result2 + Float.floatToIntBits(this.aY);
        result2 = 31 * result2 + Float.floatToIntBits(this.aZ);
        result2 = 31 * result2 + Float.floatToIntBits(this.bX);
        result2 = 31 * result2 + Float.floatToIntBits(this.bY);
        result2 = 31 * result2 + Float.floatToIntBits(this.bZ);
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
        LineSegmentf other = (LineSegmentf)obj;
        if (Float.floatToIntBits(this.aX) != Float.floatToIntBits(other.aX)) {
            return false;
        }
        if (Float.floatToIntBits(this.aY) != Float.floatToIntBits(other.aY)) {
            return false;
        }
        if (Float.floatToIntBits(this.aZ) != Float.floatToIntBits(other.aZ)) {
            return false;
        }
        if (Float.floatToIntBits(this.bX) != Float.floatToIntBits(other.bX)) {
            return false;
        }
        if (Float.floatToIntBits(this.bY) != Float.floatToIntBits(other.bY)) {
            return false;
        }
        return Float.floatToIntBits(this.bZ) == Float.floatToIntBits(other.bZ);
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "(" + Runtime.format(this.aX, formatter) + " " + Runtime.format(this.aY, formatter) + " " + Runtime.format(this.aZ, formatter) + ") - (" + Runtime.format(this.bX, formatter) + " " + Runtime.format(this.bY, formatter) + " " + Runtime.format(this.bZ, formatter) + ")";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeFloat(this.aX);
        out.writeFloat(this.aY);
        out.writeFloat(this.aZ);
        out.writeFloat(this.bX);
        out.writeFloat(this.bY);
        out.writeFloat(this.bZ);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.aX = in.readFloat();
        this.aY = in.readFloat();
        this.aZ = in.readFloat();
        this.bX = in.readFloat();
        this.bY = in.readFloat();
        this.bZ = in.readFloat();
    }
}

