/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.qc
 */
public abstract class qc_0
extends NumberFormat
implements Serializable {
    private static final long a = -6981118387974191891L;
    private NumberFormat b;
    private NumberFormat c;

    protected qc_0() {
        this(qc_0.a(Locale.getDefault()));
    }

    protected qc_0(NumberFormat numberFormat) {
        NumberFormat numberFormat2 = numberFormat;
        this(numberFormat2, (NumberFormat)numberFormat2.clone());
    }

    protected qc_0(NumberFormat numberFormat, NumberFormat numberFormat2) {
        this.c = numberFormat;
        this.b = numberFormat2;
    }

    protected static NumberFormat a() {
        return qc_0.a(Locale.getDefault());
    }

    protected static NumberFormat a(Locale cloneable) {
        cloneable = NumberFormat.getNumberInstance((Locale)cloneable);
        ((NumberFormat)cloneable).setMaximumFractionDigits(0);
        ((NumberFormat)cloneable).setParseIntegerOnly(true);
        return cloneable;
    }

    public final NumberFormat b() {
        return this.b;
    }

    public final NumberFormat c() {
        return this.c;
    }

    private void a(NumberFormat numberFormat) {
        if (numberFormat == null) {
            throw new pl_0(px_0.DENOMINATOR_FORMAT, new Object[0]);
        }
        this.b = numberFormat;
    }

    private void b(NumberFormat numberFormat) {
        if (numberFormat == null) {
            throw new pl_0(px_0.NUMERATOR_FORMAT, new Object[0]);
        }
        this.c = numberFormat;
    }

    protected static void a(String string, ParsePosition parsePosition) {
        qc_0.b(string, parsePosition);
        ParsePosition parsePosition2 = parsePosition;
        parsePosition2.setIndex(parsePosition2.getIndex() - 1);
    }

    protected static char b(String string, ParsePosition parsePosition) {
        int n2 = parsePosition.getIndex();
        int n3 = string.length();
        char c2 = '\u0000';
        if (n2 < n3) {
            char c3;
            while (Character.isWhitespace(c3 = string.charAt(n2++)) && n2 < n3) {
            }
            parsePosition.setIndex(n2);
            if (n2 < n3) {
                c2 = c3;
            }
        }
        return c2;
    }

    /*
     * WARNING - void declaration
     */
    public StringBuffer format(double value, StringBuffer buffer, FieldPosition position) {
        void var3_2;
        void var1_1;
        return this.format((Object)((double)var1_1), (StringBuffer)var3_2, position);
    }

    /*
     * WARNING - void declaration
     */
    public StringBuffer format(long value, StringBuffer buffer, FieldPosition position) {
        void var3_2;
        void var1_1;
        return this.format((Object)((long)var1_1), (StringBuffer)var3_2, position);
    }
}

