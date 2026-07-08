/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.Format;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ps_0;
import org.valkyrienskies.core.impl.shadow.pw_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.pu
 */
public final class pu_0
implements Serializable {
    private static final long a = -6024911025449780478L;
    private Throwable b;
    private List<pw_0> c;
    private List<Object[]> d;
    private Map<String, Object> e;

    public pu_0(Throwable throwable) {
        this.b = throwable;
        this.c = new ArrayList<pw_0>();
        this.d = new ArrayList<Object[]>();
        this.e = new HashMap<String, Object>();
    }

    private Throwable c() {
        return this.b;
    }

    public final void a(pw_0 pw_02, Object ... objectArray) {
        this.c.add(pw_02);
        this.d.add(ps_0.a(objectArray));
    }

    public final void a(String string, Object object) {
        this.e.put(string, object);
    }

    private Object a(String string) {
        return this.e.get(string);
    }

    private Set<String> d() {
        return this.e.keySet();
    }

    public final String a() {
        Locale locale = Locale.US;
        pu_0 pu_02 = this;
        return pu_02.a(locale, ": ");
    }

    public final String b() {
        Locale locale = Locale.getDefault();
        pu_0 pu_02 = this;
        return pu_02.a(locale, ": ");
    }

    private String a(Locale locale) {
        return this.a(locale, ": ");
    }

    private String b(Locale locale, String string) {
        return this.a(locale, string);
    }

    public String a(Locale locale, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        int n3 = this.c.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            Serializable serializable = this.c.get(i2);
            Object[] objectArray = this.d.get(i2);
            serializable = new MessageFormat(serializable.a(locale), locale);
            stringBuilder.append(((Format)serializable).format(objectArray));
            if (++n2 >= n3) continue;
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.b);
        ObjectOutputStream objectOutputStream2 = objectOutputStream;
        pu_0 pu_02 = this;
        int n2 = pu_02.c.size();
        objectOutputStream2.writeInt(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            pw_0 pw_02 = pu_02.c.get(i2);
            objectOutputStream2.writeObject(pw_02);
            Object[] object = pu_02.d.get(i2);
            int n3 = object.length;
            objectOutputStream2.writeInt(n3);
            for (int i3 = 0; i3 < n3; ++i3) {
                if (object[i3] instanceof Serializable) {
                    objectOutputStream2.writeObject(object[i3]);
                    continue;
                }
                objectOutputStream2.writeObject(pu_0.a(object[i3]));
            }
        }
        objectOutputStream2 = objectOutputStream;
        pu_02 = this;
        n2 = pu_02.e.size();
        objectOutputStream2.writeInt(n2);
        for (Map.Entry<String, Object> entry : pu_02.e.entrySet()) {
            objectOutputStream2.writeObject(entry.getKey());
            Object object = entry.getValue();
            if (object instanceof Serializable) {
                objectOutputStream2.writeObject(object);
                continue;
            }
            objectOutputStream2.writeObject(pu_0.a(object));
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        Object object;
        int n2;
        this.b = (Throwable)objectInputStream.readObject();
        ObjectInputStream objectInputStream2 = objectInputStream;
        pu_0 pu_02 = this;
        int n3 = objectInputStream2.readInt();
        pu_02.c = new ArrayList<pw_0>(n3);
        pu_02.d = new ArrayList<Object[]>(n3);
        for (n2 = 0; n2 < n3; ++n2) {
            object = (Object[])objectInputStream2.readObject();
            pu_02.c.add((pw_0)object);
            int n4 = objectInputStream2.readInt();
            object = new Object[n4];
            for (int i2 = 0; i2 < n4; ++i2) {
                object[i2] = objectInputStream2.readObject();
            }
            pu_02.d.add((Object[])object);
        }
        objectInputStream2 = objectInputStream;
        pu_02 = this;
        n3 = objectInputStream2.readInt();
        pu_02.e = new HashMap<String, Object>();
        for (n2 = 0; n2 < n3; ++n2) {
            object = (String)objectInputStream2.readObject();
            Object object2 = objectInputStream2.readObject();
            pu_02.e.put((String)object, object2);
        }
    }

    private void b(ObjectOutputStream objectOutputStream) {
        int n2 = this.c.size();
        objectOutputStream.writeInt(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            Object[] objectArray = this.c.get(i2);
            objectOutputStream.writeObject(objectArray);
            objectArray = this.d.get(i2);
            int n3 = objectArray.length;
            objectOutputStream.writeInt(n3);
            for (int i3 = 0; i3 < n3; ++i3) {
                if (objectArray[i3] instanceof Serializable) {
                    objectOutputStream.writeObject(objectArray[i3]);
                    continue;
                }
                objectOutputStream.writeObject(pu_0.a(objectArray[i3]));
            }
        }
    }

    private void b(ObjectInputStream objectInputStream) {
        int n2 = objectInputStream.readInt();
        this.c = new ArrayList<pw_0>(n2);
        this.d = new ArrayList<Object[]>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            pw_0 pw_02 = (pw_0)objectInputStream.readObject();
            this.c.add(pw_02);
            int n3 = objectInputStream.readInt();
            Object[] objectArray = new Object[n3];
            for (int i3 = 0; i3 < n3; ++i3) {
                objectArray[i3] = objectInputStream.readObject();
            }
            this.d.add(objectArray);
        }
    }

    private void c(ObjectOutputStream objectOutputStream) {
        int n2 = this.e.size();
        objectOutputStream.writeInt(n2);
        for (Map.Entry<String, Object> entry : this.e.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            Object object = entry.getValue();
            if (object instanceof Serializable) {
                objectOutputStream.writeObject(object);
                continue;
            }
            objectOutputStream.writeObject(pu_0.a(object));
        }
    }

    private void c(ObjectInputStream objectInputStream) {
        int n2 = objectInputStream.readInt();
        this.e = new HashMap<String, Object>();
        for (int i2 = 0; i2 < n2; ++i2) {
            String string = (String)objectInputStream.readObject();
            Object object = objectInputStream.readObject();
            this.e.put(string, object);
        }
    }

    private static String a(Object object) {
        return "[Object could not be serialized: " + object.getClass().getName() + "]";
    }
}

