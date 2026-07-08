/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.time.YearMonth;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import org.valkyrienskies.core.impl.shadow.l_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.j
 */
public class j_0
implements l_0 {
    private static String b = "leap_second_dates.csv";
    private final SortedSet<YearMonth> c = new TreeSet<YearMonth>();
    private final YearMonth d;

    public j_0() {
        try (InputStream inputStream = j_0.class.getClassLoader().getResourceAsStream("leap_second_dates.csv");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream, "leap_second_dates.csv was not found on the classpath"), StandardCharsets.UTF_8));){
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                if (string.isEmpty()) continue;
                this.c.add(YearMonth.parse(string));
            }
        }
        catch (IOException iOException) {
            throw new UncheckedIOException(iOException);
        }
        this.d = this.c.last();
    }

    @Override
    public final boolean a(YearMonth yearMonth) {
        return this.c.contains(yearMonth);
    }

    @Override
    public final YearMonth a() {
        return this.d;
    }
}

