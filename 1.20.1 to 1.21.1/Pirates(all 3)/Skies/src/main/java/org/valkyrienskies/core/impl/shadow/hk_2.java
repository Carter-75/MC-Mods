/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.fk_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hk
 */
public final class hk_2<T>
implements fh_2<T> {
    private final Class<T> a;
    private final Class<?>[] b;
    private final Object[] c;
    private transient Constructor<T> d = null;

    public static <T> fh_2<T> a(Class<T> clazz, Class<?>[] classArray, Object[] objectArray) {
        if (clazz == null) {
            throw new NullPointerException("Class to instantiate must not be null");
        }
        if (classArray == null && objectArray != null || classArray != null && objectArray == null || classArray != null && objectArray != null && classArray.length != objectArray.length) {
            throw new IllegalArgumentException("Parameter types must match the arguments");
        }
        if (classArray == null || classArray.length == 0) {
            return new hk_2<T>(clazz);
        }
        return new hk_2<T>(clazz, classArray, objectArray);
    }

    private hk_2(Class<T> clazz) {
        this.a = clazz;
        this.b = null;
        this.c = null;
        this.b();
    }

    public hk_2(Class<T> clazz, Class<?>[] classArray, Object[] objectArray) {
        this.a = clazz;
        this.b = (Class[])classArray.clone();
        this.c = (Object[])objectArray.clone();
        this.b();
    }

    private void b() {
        try {
            this.d = this.a.getConstructor(this.b);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new IllegalArgumentException("InstantiateFactory: The constructor must exist and be public ");
        }
    }

    @Override
    public final T a() {
        if (this.d == null) {
            this.b();
        }
        try {
            return this.d.newInstance(this.c);
        }
        catch (InstantiationException instantiationException) {
            throw new fk_2("InstantiateFactory: InstantiationException", instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new fk_2("InstantiateFactory: Constructor must be public", illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new fk_2("InstantiateFactory: Constructor threw an exception", invocationTargetException);
        }
    }
}

