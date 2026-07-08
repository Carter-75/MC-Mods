/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.valkyrienskies.core.impl.shadow.fk_2;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hl
 */
public final class hl_2<T>
implements fq_1<Class<? extends T>, T> {
    private static final hl_2 a = new hl_2();
    private final Class<?>[] b;
    private final Object[] c;

    public static <T> fq_1<Class<? extends T>, T> a() {
        return a;
    }

    public static <T> fq_1<Class<? extends T>, T> a(Class<?>[] classArray, Object[] objectArray) {
        if (classArray == null && objectArray != null || classArray != null && objectArray == null || classArray != null && objectArray != null && classArray.length != objectArray.length) {
            throw new IllegalArgumentException("Parameter types must match the arguments");
        }
        if (classArray == null || classArray.length == 0) {
            return new hl_2<T>();
        }
        return new hl_2<T>(classArray, objectArray);
    }

    private hl_2() {
        this.b = null;
        this.c = null;
    }

    private hl_2(Class<?>[] classArray, Object[] objectArray) {
        this.b = classArray != null ? (Class[])classArray.clone() : null;
        this.c = objectArray != null ? (Object[])objectArray.clone() : null;
    }

    @Override
    private T a(Class<? extends T> genericDeclaration) {
        try {
            if (genericDeclaration == null) {
                throw new fk_2("InstantiateTransformer: Input object was not an instanceof Class, it was a null object");
            }
            genericDeclaration = genericDeclaration.getConstructor(this.b);
            return ((Constructor)genericDeclaration).newInstance(this.c);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new fk_2("InstantiateTransformer: The constructor must exist and be public ");
        }
        catch (InstantiationException instantiationException) {
            throw new fk_2("InstantiateTransformer: InstantiationException", instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new fk_2("InstantiateTransformer: Constructor must be public", illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new fk_2("InstantiateTransformer: Constructor threw an exception", invocationTargetException);
        }
    }
}

