/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.valkyrienskies.core.impl.shadow.fk_2;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hm
 */
public final class hm_2<I, O>
implements fq_1<I, O> {
    private final String a;
    private final Class<?>[] b;
    private final Object[] c;

    public static <I, O> fq_1<I, O> a(String string) {
        if (string == null) {
            throw new NullPointerException("The method to invoke must not be null");
        }
        return new hm_2<I, O>(string);
    }

    public static <I, O> fq_1<I, O> a(String string, Class<?>[] classArray, Object[] objectArray) {
        if (string == null) {
            throw new NullPointerException("The method to invoke must not be null");
        }
        if (classArray == null && objectArray != null || classArray != null && objectArray == null || classArray != null && objectArray != null && classArray.length != objectArray.length) {
            throw new IllegalArgumentException("The parameter types must match the arguments");
        }
        if (classArray == null || classArray.length == 0) {
            return new hm_2<I, O>(string);
        }
        return new hm_2<I, O>(string, classArray, objectArray);
    }

    private hm_2(String string) {
        this.a = string;
        this.b = null;
        this.c = null;
    }

    private hm_2(String string, Class<?>[] classArray, Object[] objectArray) {
        this.a = string;
        this.b = classArray != null ? (Class[])classArray.clone() : null;
        this.c = objectArray != null ? (Object[])objectArray.clone() : null;
    }

    @Override
    public final O a(Object object) {
        if (object == null) {
            return null;
        }
        try {
            GenericDeclaration genericDeclaration = object.getClass();
            genericDeclaration = genericDeclaration.getMethod(this.a, this.b);
            return (O)((Method)genericDeclaration).invoke(object, this.c);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new fk_2("InvokerTransformer: The method '" + this.a + "' on '" + object.getClass() + "' does not exist");
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new fk_2("InvokerTransformer: The method '" + this.a + "' on '" + object.getClass() + "' cannot be accessed");
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new fk_2("InvokerTransformer: The method '" + this.a + "' on '" + object.getClass() + "' threw an exception", invocationTargetException);
        }
    }
}

