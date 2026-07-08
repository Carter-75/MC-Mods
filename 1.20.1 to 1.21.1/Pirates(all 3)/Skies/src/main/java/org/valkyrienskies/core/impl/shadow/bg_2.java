/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 *  org.valkyrienskies.core.impl.shadow.bg$a
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.ad_1;
import org.valkyrienskies.core.impl.shadow.al_1;
import org.valkyrienskies.core.impl.shadow.av_2;
import org.valkyrienskies.core.impl.shadow.bg;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bg
 */
public final class bg_2
implements ad_1 {
    private final Function<Enum<?>, String> a;

    public static bg_2 a() {
        return new bg_2(Enum::name);
    }

    public static bg_2 b() {
        return new bg_2(Enum::toString);
    }

    public static bg_2 c() {
        return new bg_2(null);
    }

    private bg_2(Function<Enum<?>, String> function) {
        this.a = function;
    }

    @Override
    public final void a(al_1 al_12) {
        if (this.a == null) {
            al_1 al_13 = al_12;
            al_13.d.a((M ac_12) -> {
                ac_1 ac_13 = ac_12;
                return bg_2.a(ac_13.a.getDeclaringType()) && !"name".equals(ac_12.m());
            }).a((M ac_12) -> {
                if (bg_2.a(ac_12.a.getDeclaringType())) {
                    return Boolean.FALSE;
                }
                return null;
            }).g(bg_2::a);
            al_13 = al_12;
            al_13.c.a((M ay_22) -> ((Field)ay_22.a.getRawMember()).isEnumConstant());
            return;
        }
        al_1 al_14 = al_12;
        al_14.b.a((av_2)new bg.a(this.a));
    }

    private static boolean a(ResolvedType resolvedType) {
        return resolvedType.getErasedType() == Enum.class;
    }

    private static List<String> a(ac_1 ac_12) {
        ac_12 = ac_12.a.getDeclaringType();
        if (bg_2.a((ResolvedType)ac_12)) {
            return bg_2.b((ResolvedType)ac_12.getTypeParameters().get(0), Enum::name);
        }
        return null;
    }

    private static List<String> b(ResolvedType object2, Function<Enum<?>, String> function) {
        if (((Class)(object2 = object2.getErasedType())).getEnumConstants() == null) {
            return null;
        }
        return Stream.of(((Class)object2).getEnumConstants()).map(object -> (String)function.apply((Enum)object)).collect(Collectors.toList());
    }

    static /* synthetic */ List a(ResolvedType resolvedType, Function function) {
        return bg_2.b(resolvedType, function);
    }
}

