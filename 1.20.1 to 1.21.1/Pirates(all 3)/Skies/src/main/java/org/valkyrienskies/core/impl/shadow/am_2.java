/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.valkyrienskies.core.impl.shadow.an_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.am
 */
public final class am_2 {
    public final a[] a;
    public static final am_2 b = new am_2(new a[0]);
    private static int c = Integer.MIN_VALUE;

    private am_2(a[] aArray) {
        this.a = aArray;
    }

    public am_2(List<a> list) {
        this.a = list.toArray(new a[0]);
    }

    public static am_2 a(String string) {
        StringBuilder stringBuilder = null;
        ArrayList<a> arrayList = new ArrayList<a>();
        block8: for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (i2 == 0) {
                if (c2 != '/') {
                    throw new IllegalArgumentException("Missing leading slash");
                }
                stringBuilder = new StringBuilder();
                continue;
            }
            switch (c2) {
                case '~': {
                    switch (string.charAt(++i2)) {
                        case '0': {
                            stringBuilder.append('~');
                            continue block8;
                        }
                        case '1': {
                            stringBuilder.append('/');
                            continue block8;
                        }
                    }
                    throw new IllegalArgumentException("Invalid escape sequence ~" + string.charAt(i2) + " at index " + i2);
                }
                case '/': {
                    arrayList.add(new a(stringBuilder.toString()));
                    stringBuilder.setLength(0);
                    continue block8;
                }
                default: {
                    stringBuilder.append(c2);
                }
            }
        }
        if (stringBuilder == null) {
            return b;
        }
        arrayList.add(org.valkyrienskies.core.impl.shadow.am$a.a(stringBuilder.toString()));
        return new am_2(arrayList);
    }

    public final boolean a() {
        return this.a.length == 0;
    }

    final am_2 b(String string) {
        a[] aArray = Arrays.copyOf(this.a, this.a.length + 1);
        a[] aArray2 = aArray;
        aArray[this.a.length] = new a(string);
        return new am_2(aArray2);
    }

    final am_2 a(int n2) {
        return this.b(Integer.toString(n2));
    }

    final int b() {
        return this.a.length;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        a[] aArray = this.a;
        int n2 = this.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            a a2 = aArray[i2];
            stringBuilder.append('/');
            stringBuilder.append(a2);
        }
        return stringBuilder.toString();
    }

    public final List<a> c() {
        return Arrays.asList((Object[])this.a.clone());
    }

    public final a b(int n2) {
        if (n2 < 0 || n2 >= this.a.length) {
            throw new IndexOutOfBoundsException("Illegal index: " + n2);
        }
        return this.a[n2];
    }

    public final a d() {
        if (this.a()) {
            throw new IllegalStateException("Root pointers contain no reference tokens");
        }
        return this.a[this.a.length - 1];
    }

    public final am_2 e() {
        if (this.a()) {
            return this;
        }
        return new am_2(Arrays.copyOf(this.a, this.a.length - 1));
    }

    private void a(int n2, String string, JsonNode jsonNode) {
        throw new an_2(string, new am_2(Arrays.copyOf(this.a, n2)), jsonNode);
    }

    public final JsonNode a(JsonNode jsonNode) {
        JsonNode jsonNode2 = jsonNode;
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            a a2;
            a a3 = this.a[i2];
            if (jsonNode2.isArray()) {
                if (!a3.a()) {
                    a2 = a3;
                    this.a(i2, "Can't reference field \"" + a2.a + "\" on array", jsonNode);
                }
                if (a3.b() == Integer.MIN_VALUE || a3.b() >= jsonNode2.size()) {
                    this.a(i2, "Array index " + a3.toString() + " is out of bounds", jsonNode);
                }
                jsonNode2 = jsonNode2.get(a3.b());
                continue;
            }
            if (jsonNode2.isObject()) {
                a2 = a3;
                if (!jsonNode2.has(a2.a)) {
                    a2 = a3;
                    this.a(i2, "Missing field \"" + a2.a + "\"", jsonNode);
                }
                a2 = a3;
                jsonNode2 = jsonNode2.get(a2.a);
                continue;
            }
            this.a(i2, "Can't reference past scalar value", jsonNode);
        }
        return jsonNode2;
    }

    public final boolean equals(Object o) {
        am_2 am_22;
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        am_22 = am_22;
        return Arrays.equals(this.a, am_22.a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public static final class a {
        String a;
        private transient Integer b = null;
        private static final Pattern c = Pattern.compile("~0");
        private static final Pattern d = Pattern.compile("~1");
        private static final Pattern e = Pattern.compile("~");
        private static final Pattern f = Pattern.compile("/");
        private static final Pattern g = Pattern.compile("-|0|(?:[1-9][0-9]*)");

        public a(String string) {
            if (string == null) {
                throw new IllegalArgumentException("Token can't be null");
            }
            this.a = string;
        }

        private static String a(Object object) {
            object = object.toString();
            object = d.matcher((CharSequence)object).replaceAll("/");
            return c.matcher((CharSequence)object).replaceAll("~");
        }

        private static String b(Object object) {
            object = object.toString();
            object = e.matcher((CharSequence)object).replaceAll("~0");
            return f.matcher((CharSequence)object).replaceAll("~1");
        }

        public static a a(String string) {
            if (string == null) {
                throw new IllegalArgumentException("Token can't be null");
            }
            string = string.toString();
            string = d.matcher(string).replaceAll("/");
            return new a(c.matcher(string).replaceAll("~"));
        }

        public final boolean a() {
            if (this.b != null) {
                return true;
            }
            Matcher matcher = g.matcher(this.a);
            if (matcher.matches()) {
                this.b = matcher.group().equals("-") ? Integer.MIN_VALUE : Integer.parseInt(matcher.group());
                return true;
            }
            return false;
        }

        public final int b() {
            if (!this.a()) {
                throw new IllegalStateException("Object operation on array target");
            }
            return this.b;
        }

        public final String c() {
            return this.a;
        }

        public final String toString() {
            String string = this.a;
            string = string.toString();
            string = e.matcher(string).replaceAll("~0");
            return f.matcher(string).replaceAll("~1");
        }

        public final boolean equals(Object o) {
            a a2;
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            a2 = a2;
            return this.a.equals(a2.a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }
    }
}

