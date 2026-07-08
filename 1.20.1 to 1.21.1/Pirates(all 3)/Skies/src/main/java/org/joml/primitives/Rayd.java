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

public class Rayd
implements Externalizable {
    public double oX;
    public double oY;
    public double oZ;
    public double dX;
    public double dY;
    public double dZ;

    public Rayd() {
    }

    public Rayd(Rayd source) {
        this.oX = source.oX;
        this.oY = source.oY;
        this.oZ = source.oZ;
        this.dX = source.dX;
        this.dY = source.dY;
        this.dZ = source.dZ;
    }

    public Rayd(Vector3dc origin, Vector3dc direction) {
        this.oX = origin.x();
        this.oY = origin.y();
        this.oZ = origin.z();
        this.dX = direction.x();
        this.dY = direction.y();
        this.dZ = direction.z();
    }

    public Rayd(double oX2, double oY2, double oZ2, double dX, double dY, double dZ) {
        this.oX = oX2;
        this.oY = oY2;
        this.oZ = oZ2;
        this.dX = dX;
        this.dY = dY;
        this.dZ = dZ;
    }

    public int hashCode() {
        int prime = 31;
        int result2 = 1;
        long temp = Double.doubleToLongBits(this.dX);
        result2 = 31 * result2 + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.dY);
        result2 = 31 * result2 + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.dZ);
        result2 = 31 * result2 + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.oX);
        result2 = 31 * result2 + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.oY);
        result2 = 31 * result2 + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.oZ);
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
        Rayd other = (Rayd)obj;
        if (Double.doubleToLongBits(this.dX) != Double.doubleToLongBits(other.dX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.dY) != Double.doubleToLongBits(other.dY)) {
            return false;
        }
        if (Double.doubleToLongBits(this.dZ) != Double.doubleToLongBits(other.dZ)) {
            return false;
        }
        if (Double.doubleToLongBits(this.oX) != Double.doubleToLongBits(other.oX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.oY) != Double.doubleToLongBits(other.oY)) {
            return false;
        }
        return Double.doubleToLongBits(this.oZ) == Double.doubleToLongBits(other.oZ);
    }

    public String toString() {
        return Runtime.formatNumbers(this.toString(Options.NUMBER_FORMAT));
    }

    public String toString(NumberFormat formatter) {
        return "(" + Runtime.format(this.oX, formatter) + " " + Runtime.format(this.oY, formatter) + " " + Runtime.format(this.oZ, formatter) + ") -> (" + Runtime.format(this.dX, formatter) + " " + Runtime.format(this.dY, formatter) + " " + Runtime.format(this.dZ, formatter) + ")";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(this.oX);
        out.writeDouble(this.oY);
        out.writeDouble(this.oZ);
        out.writeDouble(this.dX);
        out.writeDouble(this.dY);
        out.writeDouble(this.dZ);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.oX = in.readDouble();
        this.oY = in.readDouble();
        this.oZ = in.readDouble();
        this.dX = in.readDouble();
        this.dY = in.readDouble();
        this.dZ = in.readDouble();
    }
}

