/*
 * Decompiled with CFR 0.152.
 */
package org.joml;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.joml.Matrix4x3d;

public class Matrix4x3dStack
extends Matrix4x3d {
    private static final long serialVersionUID = 1L;
    private Matrix4x3d[] mats;
    private int curr;

    public Matrix4x3dStack(int stackSize) {
        if (stackSize < 1) {
            throw new IllegalArgumentException("stackSize must be >= 1");
        }
        this.mats = new Matrix4x3d[stackSize - 1];
        for (int i2 = 0; i2 < this.mats.length; ++i2) {
            this.mats[i2] = new Matrix4x3d();
        }
    }

    public Matrix4x3dStack() {
    }

    public Matrix4x3dStack clear() {
        this.curr = 0;
        this.identity();
        return this;
    }

    public Matrix4x3dStack pushMatrix() {
        if (this.curr == this.mats.length) {
            throw new IllegalStateException("max stack size of " + (this.curr + 1) + " reached");
        }
        this.mats[this.curr++].set(this);
        return this;
    }

    public Matrix4x3dStack popMatrix() {
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
        if (obj instanceof Matrix4x3dStack) {
            Matrix4x3dStack other = (Matrix4x3dStack)obj;
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
        this.mats = new Matrix4x3dStack[this.curr];
        for (int i2 = 0; i2 < this.curr; ++i2) {
            Matrix4x3d m2 = new Matrix4x3d();
            m2.readExternal(in);
            this.mats[i2] = m2;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        Matrix4x3dStack cloned = (Matrix4x3dStack)super.clone();
        Matrix4x3d[] clonedMats = new Matrix4x3d[this.mats.length];
        for (int i2 = 0; i2 < this.mats.length; ++i2) {
            clonedMats[i2] = (Matrix4x3d)this.mats[i2].clone();
        }
        cloned.mats = clonedMats;
        return cloned;
    }
}

