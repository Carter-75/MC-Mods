/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.fk_2;
import org.valkyrienskies.core.impl.shadow.gu_1;
import org.valkyrienskies.core.impl.shadow.hk_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hB
 */
public final class hb_1 {
    public static <T> fh_2<T> a(T t) {
        if (t == null) {
            return gu_1.a(null);
        }
        try {
            Method method = t.getClass().getMethod("clone", null);
            return new a(t, method, 0);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            try {
                t.getClass().getConstructor(t.getClass());
                return new hk_2(t.getClass(), new Class[]{t.getClass()}, new Object[]{t});
            }
            catch (NoSuchMethodException noSuchMethodException2) {
                if (t instanceof Serializable) {
                    return new b((Serializable)t, 0);
                }
                throw new IllegalArgumentException("The prototype must be cloneable via a public clone method");
            }
        }
    }

    private hb_1() {
    }

    static final class b<T extends Serializable>
    implements fh_2<T> {
        private final T a;

        private b(T t) {
            this.a = t;
        }

        /*
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private T b() {
            Object object;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            ByteArrayInputStream byteArrayInputStream = null;
            try {
                object = new ObjectOutputStream(byteArrayOutputStream);
                ((ObjectOutputStream)object).writeObject(this.a);
                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                object = new ObjectInputStream(byteArrayInputStream);
                object = (Serializable)((ObjectInputStream)object).readObject();
            }
            catch (ClassNotFoundException classNotFoundException) {
                try {
                    throw new fk_2(classNotFoundException);
                    catch (IOException iOException) {
                        throw new fk_2(iOException);
                    }
                }
                catch (Throwable throwable) {
                    try {
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                    }
                    catch (IOException iOException) {}
                    try {
                        byteArrayOutputStream.close();
                        throw throwable;
                    }
                    catch (IOException iOException) {}
                    throw throwable;
                }
            }
            try {
                byteArrayInputStream.close();
            }
            catch (IOException iOException) {}
            try {
                byteArrayOutputStream.close();
                return (T)object;
            }
            catch (IOException iOException) {}
            return (T)object;
        }

        @Override
        public final /* synthetic */ Object a() {
            return this.b();
        }

        /* synthetic */ b(Serializable serializable, byte by) {
            this(serializable);
        }
    }

    static final class a<T>
    implements fh_2<T> {
        private final T a;
        private transient Method b;

        private a(T t, Method method) {
            this.a = t;
            this.b = method;
        }

        private void b() {
            try {
                this.b = this.a.getClass().getMethod("clone", null);
                return;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new IllegalArgumentException("PrototypeCloneFactory: The clone method must exist and be public ");
            }
        }

        @Override
        public final T a() {
            if (this.b == null) {
                a a2 = this;
                try {
                    a2.b = a2.a.getClass().getMethod("clone", null);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    throw new IllegalArgumentException("PrototypeCloneFactory: The clone method must exist and be public ");
                }
            }
            try {
                return (T)this.b.invoke(this.a, null);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new fk_2("PrototypeCloneFactory: Clone method must be public", illegalAccessException);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new fk_2("PrototypeCloneFactory: Clone method threw an exception", invocationTargetException);
            }
        }

        /* synthetic */ a(Object object, Method method, byte by) {
            this(object, method);
        }
    }
}

