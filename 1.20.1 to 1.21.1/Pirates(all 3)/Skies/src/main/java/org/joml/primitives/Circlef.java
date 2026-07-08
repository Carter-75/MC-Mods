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
import org.joml.Vector2fc;

public class Circlef
implements Externalizable {
    public float x;
    public float y;
    public float r;

    public Circlef() {
    }

    public Circlef(Circlef source) {
        this.x = source.x;
        this.y = source.y;
        this.r = source.r;
    }

    public Circlef(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Circlef translate(Vector2fc xy) {
        return this.translate(xy.x(), xy.y(), this);
    }

    public Circlef translate(Vector2fc xy, Circlef dest) {
        return this.translate(xy.x(), xy.y(), dest);
    }

    public Circlef translate(float x, float y) {
        return this.translate(x, y, this);
    }

    public Circlef translate(float x, float y, Circlef dest) {
        dest.x = this.x + x;
        dest.y = this.y + y;
        return dest;
    }

    public int hashCode() {
        int prime = 31;
        int result2 = 1;
        result2 = 31 * result2 + Float.floatToIntBits(this.r);
        result2 = 31 * result2 + Float.floatToIntBits(this.x);
        result2 = 31 * result2 + Float.floatToIntBits(this.y);
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
        Circlef other = (Circlef)obj;
        if (Float.floatToIntBits(this.r) != Float.floatToIntBits(other.r)) {
            return false;
        }
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
            return false;
        }
        return Float.floatToIntBits(this.y) == Float.floatToIntBits(other.y);
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "(" + Runtime.format(this.x, formatter) + " " + Runtime.format(this.y, formatter) + " " + Runtime.format(this.r, formatter) + ")";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeFloat(this.x);
        out.writeFloat(this.y);
        out.writeFloat(this.r);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.x = in.readFloat();
        this.y = in.readFloat();
        this.r = in.readFloat();
    }
}

