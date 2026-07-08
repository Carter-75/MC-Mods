/*
 * Decompiled with CFR 0.152.
 */
package org.joml;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.joml.Matrix3f;

public class Matrix3fStack
extends Matrix3f {
    private static final long serialVersionUID = 1L;
    private Matrix3f[] mats;
    private int curr;

    public Matrix3fStack(int stackSize) {
        if (stackSize < 1) {
            throw new IllegalArgumentException("stackSize must be >= 1");
        }
        this.mats = new Matrix3f[stackSize - 1];
        for (int i2 = 0; i2 < this.mats.length; ++i2) {
            this.mats[i2] = new Matrix3f();
        }
    }

    public Matrix3fStack() {
    }

    public Matrix3fStack clear() {
        this.curr = 0;
        this.identity();
        return this;
    }

    public Matrix3fStack pushMatrix() {
        if (this.curr == this.mats.length) {
            throw new IllegalStateException("max stack size of " + (this.curr + 1) + " reached");
        }
        this.mats[this.curr++].set(this);
        return this;
    }

    public Matrix3fStack popMatrix() {
        if (this.curr == 0) {
            throw new IllegalStateException("already at the bottom of the stack");
        }
        this.set(this.mats[--this.curr]);
        return this;
    }

    public int hashCode() {
        int prime = 31;
        int result2 = super.hashCode();
        result2 = 31 * result2 + this.curr;
        for (int i2 = 0; i2 < this.curr; ++i2) {
            result2 = 31 * result2 + this.mats[i2].hashCode();
        }
        return result2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof Matrix3fStack) {
            Matrix3fStack other = (Matrix3fStack)obj;
            if (this.curr != other.curr) {
                return false;
            }
            for (int i2 = 0; i2 < this.curr; ++i2) {
                if (this.mats[i2].equals(other.mats[i2])) continue;
                return false;
            }
        }
        return true;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeInt(this.curr);
        for (int i2 = 0; i2 < this.curr; ++i2) {
            out.writeObject(this.mats[i2]);
        }
    }

    public void readExternal(ObjectInput in) throws IOException {
        super.readExternal(in);
        this.curr = in.readInt();
        this.mats = new Matrix3fStack[this.curr];
        for (int i2 = 0; i2 < this.curr; ++i2) {
            Matrix3f m2 = new Matrix3f();
            m2.readExternal(in);
            this.mats[i2] = m2;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        Matrix3fStack cloned = (Matrix3fStack)super.clone();
        Matrix3f[] clonedMats = new Matrix3f[this.mats.length];
        for (int i2 = 0; i2 < this.mats.length; ++i2) {
            clonedMats[i2] = (Matrix3f)this.mats[i2].clone();
        }
        cloned.mats = clonedMats;
        return cloned;
    }
}

