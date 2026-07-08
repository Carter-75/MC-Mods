/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.HE;
import org.valkyrienskies.core.impl.shadow.HF;
import org.valkyrienskies.core.impl.shadow.HG;
import org.valkyrienskies.core.impl.shadow.HH;
import org.valkyrienskies.core.impl.shadow.HI;
import org.valkyrienskies.core.impl.shadow.HJ;
import org.valkyrienskies.core.impl.shadow.HK;
import org.valkyrienskies.core.impl.shadow.HL;
import org.valkyrienskies.core.impl.shadow.HM;
import org.valkyrienskies.core.impl.shadow.HN;
import org.valkyrienskies.core.impl.shadow.HO;
import org.valkyrienskies.core.impl.shadow.HP;
import org.valkyrienskies.core.impl.shadow.ID;
import org.valkyrienskies.core.impl.shadow.IE;
import org.valkyrienskies.core.impl.shadow.hb_0;

public final class Ir {
    private static void a(HJ object, ByteBuffer object2) {
        ((ByteBuffer)object2).putInt(object.p().ordinal());
        switch (object.p()) {
            case FIXED: {
                ByteBuffer byteBuffer = object2;
                object2 = (HG)object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
                ((ID)object).a((HJ)object2, byteBuffer);
                return;
            }
            case DISTANCE: {
                ByteBuffer byteBuffer = object2;
                object2 = (HF)object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
                ((ID)object).a((HJ)object2, byteBuffer);
                object = object2;
                boolean bl = ((HF)object).b != null;
                byteBuffer.put(IE.a(bl));
                Object object3 = object2;
                Float f2 = ((HF)object3).b;
                if (f2 != null) {
                    float f3 = ((Number)f2).floatValue();
                    byteBuffer.putFloat(f3);
                }
                Object object4 = object2;
                boolean bl2 = ((HF)object4).c != null;
                byteBuffer.put(IE.a(bl2));
                Object object5 = object2;
                Float f4 = ((HF)object5).c;
                if (f4 != null) {
                    float f5 = ((Number)f4).floatValue();
                    byteBuffer.putFloat(f5);
                }
                Object object6 = object2;
                boolean bl3 = ((HF)object6).d != null;
                byteBuffer.put(IE.a(bl3));
                Object object7 = object2;
                Float f6 = ((HF)object7).d;
                if (f6 != null) {
                    float f7 = ((Number)f6).floatValue();
                    byteBuffer.putFloat(f7);
                }
                Object object8 = object2;
                boolean bl4 = ((HF)object8).e != null;
                byteBuffer.put(IE.a(bl4));
                Object object9 = object2;
                Float f8 = ((HF)object9).e;
                if (f8 != null) {
                    float f9 = ((Number)f8).floatValue();
                    byteBuffer.putFloat(f9);
                }
                Object object10 = object2;
                boolean bl5 = ((HF)object10).f != null;
                byteBuffer.put(IE.a(bl5));
                Object object11 = object2;
                Float f10 = ((HF)object11).f;
                if (f10 == null) break;
                float f11 = ((Number)f10).floatValue();
                byteBuffer.putFloat(f11);
                return;
            }
            case SPHERICAL: {
                ByteBuffer byteBuffer = object2;
                object2 = (HP)object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
                ((ID)object).a((HJ)object2, byteBuffer);
                object = object2;
                boolean bl = ((HP)object).b != null;
                byteBuffer.put(IE.a(bl));
                Object object12 = object2;
                HE.i i2 = ((HP)object12).b;
                if (i2 == null) break;
                object12 = i2;
                ID.a(i2, byteBuffer);
                return;
            }
            case REVOLUTE: {
                ByteBuffer byteBuffer = object2;
                object2 = (HO)object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
                ((ID)object).a((HJ)object2, byteBuffer);
                object = object2;
                boolean bl = ((HO)object).b != null;
                byteBuffer.put(IE.a(bl));
                Object object13 = object2;
                HE.a a2 = ((HO)object13).b;
                if (a2 != null) {
                    object13 = a2;
                    ID.a(a2, byteBuffer);
                }
                object13 = object2;
                boolean bl6 = ((HO)object13).c != null;
                byteBuffer.put(IE.a(bl6));
                Object object14 = object2;
                HO.a a3 = ((HO)object14).c;
                if (a3 != null) {
                    object14 = a3;
                    ID.a(a3, byteBuffer);
                }
                object14 = object2;
                boolean bl7 = ((HO)object14).d != null;
                byteBuffer.put(IE.a(bl7));
                Object object15 = object2;
                Float f12 = ((HO)object15).d;
                if (f12 != null) {
                    float f13 = ((Number)f12).floatValue();
                    byteBuffer.putFloat(f13);
                }
                Object object16 = object2;
                boolean bl8 = ((HO)object16).e != null;
                byteBuffer.put(IE.a(bl8));
                Object object17 = object2;
                Float f14 = ((HO)object17).e;
                if (f14 != null) {
                    float f15 = ((Number)f14).floatValue();
                    byteBuffer.putFloat(f15);
                }
                Object object18 = object2;
                boolean bl9 = ((HO)object18).f != null;
                byteBuffer.put(IE.a(bl9));
                Object object19 = object2;
                Boolean bl10 = ((HO)object19).f;
                if (bl10 == null) break;
                boolean bl11 = bl10;
                byteBuffer.put(IE.a(bl11));
                return;
            }
            case PRISMATIC: {
                ByteBuffer byteBuffer = object2;
                object2 = (HM)object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
                ((ID)object).a((HJ)object2, byteBuffer);
                object = object2;
                boolean bl = ((HM)object).b != null;
                byteBuffer.put(IE.a(bl));
                Object object20 = object2;
                HE.l l2 = ((HM)object20).b;
                if (l2 == null) break;
                object20 = l2;
                ID.a(l2, byteBuffer);
                return;
            }
            case GEAR: {
                ByteBuffer byteBuffer = object2;
                object2 = (HH)object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
                ((ID)object).a((HJ)object2, byteBuffer);
                object = object2;
                boolean bl = ((HH)object).b != null;
                byteBuffer.put(IE.a(bl));
                Object object21 = object2;
                HE.h h2 = ((HH)object21).b;
                if (h2 != null) {
                    object21 = h2;
                    ID.a(h2, byteBuffer);
                }
                object21 = object2;
                boolean bl12 = ((HH)object21).c != null;
                byteBuffer.put(IE.a(bl12));
                Object object22 = object2;
                Float f16 = ((HH)object22).c;
                if (f16 == null) break;
                float f17 = ((Number)f16).floatValue();
                byteBuffer.putFloat(f17);
                return;
            }
            case RACK_AND_PINION: {
                ByteBuffer byteBuffer = object2;
                object2 = (HN)object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
                ((ID)object).a((HJ)object2, byteBuffer);
                object = object2;
                boolean bl = ((HN)object).b != null;
                byteBuffer.put(IE.a(bl));
                Object object23 = object2;
                HE.h h3 = ((HN)object23).b;
                if (h3 != null) {
                    object23 = h3;
                    ID.a(h3, byteBuffer);
                }
                object23 = object2;
                boolean bl13 = ((HN)object23).c != null;
                byteBuffer.put(IE.a(bl13));
                Object object24 = object2;
                Float f18 = ((HN)object24).c;
                if (f18 != null) {
                    float f19 = ((Number)f18).floatValue();
                    byteBuffer.putFloat(f19);
                }
                Object object25 = object2;
                boolean bl14 = ((HN)object25).d != null;
                byteBuffer.put(IE.a(bl14));
                Object object26 = object2;
                HN.a a4 = ((HN)object26).d;
                if (a4 == null) break;
                object26 = a4;
                ID.a(a4, byteBuffer);
                return;
            }
            case D6: {
                ByteBuffer byteBuffer = object2;
                object2 = (HE)object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
                ((ID)object).a((HJ)object2, byteBuffer);
                object = object2;
                ID.a((Map)((HE)object).b, byteBuffer);
                object = object2;
                boolean bl = ((HE)object).c != null;
                byteBuffer.put(IE.a(bl));
                Object object27 = object2;
                HE.k k2 = ((HE)object27).c;
                if (k2 != null) {
                    object27 = k2;
                    ID.a(k2, byteBuffer);
                }
                object27 = object2;
                ID.a((Map)((HE)object27).d, byteBuffer);
                object27 = object2;
                boolean bl15 = ((HE)object27).e != null;
                byteBuffer.put(IE.a(bl15));
                Object object28 = object2;
                HE.a a5 = ((HE)object28).e;
                if (a5 != null) {
                    object28 = a5;
                    ID.a(a5, byteBuffer);
                }
                object28 = object2;
                boolean bl16 = ((HE)object28).f != null;
                byteBuffer.put(IE.a(bl16));
                Object object29 = object2;
                HE.i i3 = ((HE)object29).f;
                if (i3 != null) {
                    object29 = i3;
                    ID.a(i3, byteBuffer);
                }
                object29 = object2;
                boolean bl17 = ((HE)object29).g != null;
                byteBuffer.put(IE.a(bl17));
                Object object30 = object2;
                HE.j j2 = ((HE)object30).g;
                if (j2 != null) {
                    object30 = j2;
                    ID.a(j2, byteBuffer);
                }
                object30 = object2;
                ID.a((Map)((HE)object30).h, byteBuffer);
                object30 = object2;
                boolean bl18 = ((HE)object30).i != null;
                byteBuffer.put(IE.a(bl18));
                Object object31 = object2;
                HE.f f20 = ((HE)object31).i;
                if (f20 != null) {
                    object31 = f20;
                    ByteBuffer byteBuffer2 = byteBuffer;
                    Object object32 = object31;
                    object31 = ID.INSTANCE;
                    object31 = object32;
                    ID.a(((HE.f)object31).a, byteBuffer2);
                    object31 = object32;
                    boolean bl19 = ((HE.f)object31).b;
                    byteBuffer2.put(IE.a(bl19));
                }
                Object object33 = object2;
                boolean bl20 = ((HE)object33).j != null;
                byteBuffer.put(IE.a(bl20));
                Object object34 = object2;
                HE.g g2 = ((HE)object34).j;
                if (g2 == null) break;
                object34 = g2;
                ID.a(g2, byteBuffer);
                return;
            }
            default: {
                throw new IllegalArgumentException("Unknown JointType " + (Object)((Object)object.p()));
            }
        }
    }

    private static HJ c(ByteBuffer object) {
        Object object2 = HK.values()[((ByteBuffer)object).getInt()];
        switch (1.a[((Enum)object2).ordinal()]) {
            case 1: {
                object2 = object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Pair pair = ((ID)object).a((ByteBuffer)object2);
                Object object3 = (Pair)pair.component1();
                Object object4 = (Pair)pair.component2();
                pair = (Pair)pair.component3();
                Integer n2 = (Integer)object3.getFirst();
                object3 = (hb_0)object3.getSecond();
                Integer n3 = (Integer)object4.getFirst();
                object4 = (hb_0)object4.getSecond();
                return new HG(n2, (hb_0)object3, n3, (hb_0)object4, (HL)pair.getFirst(), ((Number)pair.getSecond()).doubleValue());
            }
            case 2: {
                object2 = object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Pair pair = ((ID)object).a((ByteBuffer)object2);
                Object object5 = (Pair)pair.component1();
                Object object6 = (Pair)pair.component2();
                pair = (Pair)pair.component3();
                Integer n4 = (Integer)object5.getFirst();
                object5 = (hb_0)object5.getSecond();
                Integer n5 = (Integer)object6.getFirst();
                object6 = (hb_0)object6.getSecond();
                byte by = ((ByteBuffer)object2).get();
                Float f2 = IE.a(by) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                by = ((ByteBuffer)object2).get();
                Float f3 = IE.a(by) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                by = ((ByteBuffer)object2).get();
                Float f4 = IE.a(by) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                by = ((ByteBuffer)object2).get();
                Float f5 = IE.a(by) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                by = ((ByteBuffer)object2).get();
                Float f6 = IE.a(by) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                return new HF(n4, (hb_0)object5, n5, (hb_0)object6, (HL)pair.getFirst(), f2, f3, f4, f5, f6, ((Number)pair.getSecond()).doubleValue());
            }
            case 3: {
                object2 = object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Pair pair = ((ID)object).a((ByteBuffer)object2);
                Object object7 = (Pair)pair.component1();
                Object object8 = (Pair)pair.component2();
                pair = (Pair)pair.component3();
                Integer n6 = (Integer)object7.getFirst();
                object7 = (hb_0)object7.getSecond();
                Integer n7 = (Integer)object8.getFirst();
                object8 = (hb_0)object8.getSecond();
                byte by = ((ByteBuffer)object2).get();
                HE.i i2 = IE.a(by) ? ID.n((ByteBuffer)object2) : null;
                return new HP(n6, (hb_0)object7, n7, (hb_0)object8, (HL)pair.getFirst(), i2, ((Number)pair.getSecond()).doubleValue());
            }
            case 4: {
                Boolean bl;
                object2 = object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Pair pair = ((ID)object).a((ByteBuffer)object2);
                Object object9 = (Pair)pair.component1();
                Object object10 = (Pair)pair.component2();
                pair = (Pair)pair.component3();
                Integer n8 = (Integer)object9.getFirst();
                object9 = (hb_0)object9.getSecond();
                Integer n9 = (Integer)object10.getFirst();
                object10 = (hb_0)object10.getSecond();
                byte by = ((ByteBuffer)object2).get();
                HE.a a2 = IE.a(by) ? ID.m((ByteBuffer)object2) : null;
                by = ((ByteBuffer)object2).get();
                HO.a a3 = IE.a(by) ? ID.t((ByteBuffer)object2) : null;
                by = ((ByteBuffer)object2).get();
                Float f7 = IE.a(by) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                by = ((ByteBuffer)object2).get();
                Float f8 = IE.a(by) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                by = ((ByteBuffer)object2).get();
                if (IE.a(by)) {
                    by = ((ByteBuffer)object2).get();
                    bl = IE.a(by);
                } else {
                    bl = null;
                }
                Boolean bl2 = bl;
                return new HO(n8, (hb_0)object9, n9, (hb_0)object10, (HL)pair.getFirst(), a2, a3, f7, f8, bl2, ((Number)pair.getSecond()).doubleValue());
            }
            case 5: {
                object2 = object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Pair pair = ((ID)object).a((ByteBuffer)object2);
                Object object11 = (Pair)pair.component1();
                Object object12 = (Pair)pair.component2();
                pair = (Pair)pair.component3();
                Integer n10 = (Integer)object11.getFirst();
                object11 = (hb_0)object11.getSecond();
                Integer n11 = (Integer)object12.getFirst();
                object12 = (hb_0)object12.getSecond();
                byte by = ((ByteBuffer)object2).get();
                HE.l l2 = IE.a(by) ? ID.l((ByteBuffer)object2) : null;
                return new HM(n10, (hb_0)object11, n11, (hb_0)object12, (HL)pair.getFirst(), l2, ((Number)pair.getSecond()).doubleValue());
            }
            case 6: {
                object2 = object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Pair pair = ((ID)object).a((ByteBuffer)object2);
                Object object13 = (Pair)pair.component1();
                Object object14 = (Pair)pair.component2();
                pair = (Pair)pair.component3();
                Integer n12 = (Integer)object13.getFirst();
                object13 = (hb_0)object13.getSecond();
                Integer n13 = (Integer)object14.getFirst();
                object14 = (hb_0)object14.getSecond();
                byte by = ((ByteBuffer)object2).get();
                HE.h h2 = IE.a(by) ? ID.p((ByteBuffer)object2) : null;
                by = ((ByteBuffer)object2).get();
                Float f9 = IE.a(by) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                return new HH(n12, (hb_0)object13, n13, (hb_0)object14, (HL)pair.getFirst(), h2, f9, ((Number)pair.getSecond()).doubleValue());
            }
            case 7: {
                object2 = object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Pair pair = ((ID)object).a((ByteBuffer)object2);
                Object object15 = (Pair)pair.component1();
                Object object16 = (Pair)pair.component2();
                pair = (Pair)pair.component3();
                Integer n14 = (Integer)object15.getFirst();
                object15 = (hb_0)object15.getSecond();
                Integer n15 = (Integer)object16.getFirst();
                object16 = (hb_0)object16.getSecond();
                byte by = ((ByteBuffer)object2).get();
                HE.h h3 = IE.a(by) ? ID.p((ByteBuffer)object2) : null;
                by = ((ByteBuffer)object2).get();
                Float f10 = IE.a(by) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                by = ((ByteBuffer)object2).get();
                HN.a a4 = IE.a(by) ? ID.q((ByteBuffer)object2) : null;
                return new HN(n14, (hb_0)object15, n15, (hb_0)object16, (HL)pair.getFirst(), h3, f10, a4, ((Number)pair.getSecond()).doubleValue());
            }
            case 8: {
                HE.f f11;
                EnumMap enumMap;
                HE.j j2;
                Object object17;
                Class<HE.l> clazz;
                HE.k k2;
                Class<HE.l> clazz2;
                int n16;
                Object object18;
                EnumMap<HE.b, HE.e> enumMap2;
                object2 = object;
                object = ID.INSTANCE;
                Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                Pair pair = ((ID)object).a((ByteBuffer)object2);
                Object object19 = (Pair)pair.component1();
                Object object20 = (Pair)pair.component2();
                pair = (Pair)pair.component3();
                Integer n17 = (Integer)object19.getFirst();
                object19 = (hb_0)object19.getSecond();
                Integer n18 = (Integer)object20.getFirst();
                object20 = (hb_0)object20.getSecond();
                if (((ByteBuffer)object2).get() == 0) {
                    enumMap2 = null;
                } else {
                    int n19 = ((ByteBuffer)object2).getInt();
                    object18 = new EnumMap<HE.b, HE.e>(HE.b.class);
                    n16 = 0;
                    while (n16 < n19) {
                        Object object21;
                        ++n16;
                        clazz2 = ((Enum[])HE.b.class.getEnumConstants())[((ByteBuffer)object2).getInt()];
                        Class<HE.e> clazz3 = HE.e.class;
                        if (Intrinsics.areEqual(HE.e.class, HE.e.class)) {
                            object21 = HE.e.values()[((ByteBuffer)object2).getInt()];
                        } else if (Intrinsics.areEqual(clazz3, HE.l.class)) {
                            object21 = ID.l((ByteBuffer)object2);
                        } else if (Intrinsics.areEqual(clazz3, HE.d.class)) {
                            object21 = ID.r((ByteBuffer)object2);
                        } else {
                            throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unsupported enum map value type: ", HE.e.class));
                        }
                        if (object21 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.valkyrienskies.physics_api.joints.D6Joint.D6Motion");
                        }
                        HE.e e2 = object21;
                        ((Map)object18).put(clazz2, e2);
                    }
                    enumMap2 = object18;
                }
                EnumMap<HE.b, HE.e> enumMap3 = enumMap2;
                byte by = ((ByteBuffer)object2).get();
                HE.k k3 = k2 = IE.a(by) ? ID.k((ByteBuffer)object2) : null;
                if (((ByteBuffer)object2).get() == 0) {
                    clazz = null;
                } else {
                    n16 = ((ByteBuffer)object2).getInt();
                    clazz2 = new EnumMap(HE.b.class);
                    int n20 = 0;
                    while (n20 < n16) {
                        Object object22;
                        ++n20;
                        Enum enum_ = ((Enum[])HE.b.class.getEnumConstants())[((ByteBuffer)object2).getInt()];
                        object17 = HE.l.class;
                        if (Intrinsics.areEqual(HE.l.class, HE.e.class)) {
                            object22 = HE.e.values()[((ByteBuffer)object2).getInt()];
                        } else if (Intrinsics.areEqual(object17, HE.l.class)) {
                            object22 = ID.l((ByteBuffer)object2);
                        } else if (Intrinsics.areEqual(object17, HE.d.class)) {
                            object22 = ID.r((ByteBuffer)object2);
                        } else {
                            throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unsupported enum map value type: ", HE.l.class));
                        }
                        if (object22 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.valkyrienskies.physics_api.joints.D6Joint.LinearLimitPair");
                        }
                        object17 = (HE.l)object22;
                        ((Map)((Object)clazz2)).put(enum_, object17);
                    }
                    clazz = clazz2;
                }
                object17 = clazz;
                int n21 = ((ByteBuffer)object2).get();
                HE.a a5 = IE.a((byte)n21) ? ID.m((ByteBuffer)object2) : null;
                n21 = ((ByteBuffer)object2).get();
                object18 = IE.a((byte)n21) ? ID.n((ByteBuffer)object2) : null;
                n21 = ((ByteBuffer)object2).get();
                HE.j j3 = j2 = IE.a((byte)n21) ? ID.o((ByteBuffer)object2) : null;
                if (((ByteBuffer)object2).get() == 0) {
                    enumMap = null;
                } else {
                    int n22 = ((ByteBuffer)object2).getInt();
                    EnumMap enumMap4 = new EnumMap(HE.c.class);
                    n21 = 0;
                    while (n21 < n22) {
                        Object object23;
                        ++n21;
                        Enum enum_ = ((Enum[])HE.c.class.getEnumConstants())[((ByteBuffer)object2).getInt()];
                        Object object24 = HE.d.class;
                        if (Intrinsics.areEqual(HE.d.class, HE.e.class)) {
                            object23 = HE.e.values()[((ByteBuffer)object2).getInt()];
                        } else if (Intrinsics.areEqual(object24, HE.l.class)) {
                            object23 = ID.l((ByteBuffer)object2);
                        } else if (Intrinsics.areEqual(object24, HE.d.class)) {
                            object23 = ID.r((ByteBuffer)object2);
                        } else {
                            throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unsupported enum map value type: ", HE.d.class));
                        }
                        if (object23 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.valkyrienskies.physics_api.joints.D6Joint.D6JointDrive");
                        }
                        object24 = (HE.d)object23;
                        ((Map)enumMap4).put(enum_, object24);
                    }
                    enumMap = enumMap4;
                }
                clazz2 = enumMap;
                n21 = ((ByteBuffer)object2).get();
                if (IE.a((byte)n21)) {
                    Object object25 = object2;
                    object = ID.j((ByteBuffer)object25);
                    byte by2 = ((ByteBuffer)object25).get();
                    n21 = by2;
                    boolean bl = IE.a(by2);
                    f11 = new HE.f((hb_0)object, bl);
                } else {
                    f11 = null;
                }
                HE.f f12 = f11;
                byte by3 = ((ByteBuffer)object2).get();
                n21 = by3;
                object = IE.a(by3) ? ID.s((ByteBuffer)object2) : null;
                return new HE(n17, (hb_0)object19, n18, (hb_0)object20, (HL)pair.getFirst(), enumMap3, k2, (EnumMap<HE.b, HE.l>)object17, a5, (HE.i)object18, j2, (EnumMap<HE.c, HE.d>)((Object)clazz2), f12, (HE.g)object, ((Number)pair.getSecond()).doubleValue());
            }
        }
        throw new IllegalArgumentException("Unknown JointType " + object2);
    }

    private static void a(List<HI> object, ByteBuffer byteBuffer) {
        byteBuffer.putInt(0);
        object = object.iterator();
        while (object.hasNext()) {
            HI hI = (HI)object.next();
            Ir.a(hI, byteBuffer);
        }
        int n2 = byteBuffer.position();
        byteBuffer.putInt(0, n2);
    }

    public static List<HI> a(ByteBuffer byteBuffer) {
        ArrayList<HI> arrayList = new ArrayList<HI>();
        int n2 = byteBuffer.getInt();
        while (byteBuffer.position() != n2) {
            HJ hJ;
            Object object = byteBuffer;
            int n3 = ((ByteBuffer)object).getInt();
            Object object2 = HK.values()[((ByteBuffer)object).getInt()];
            switch (1.a[((Enum)object2).ordinal()]) {
                case 1: {
                    object2 = object;
                    object = ID.INSTANCE;
                    Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                    Pair pair = ((ID)object).a((ByteBuffer)object2);
                    Object object3 = (Pair)pair.component1();
                    Object object4 = (Pair)pair.component2();
                    pair = (Pair)pair.component3();
                    Integer n4 = (Integer)object3.getFirst();
                    object3 = (hb_0)object3.getSecond();
                    Integer n5 = (Integer)object4.getFirst();
                    object4 = (hb_0)object4.getSecond();
                    hJ = new HG(n4, (hb_0)object3, n5, (hb_0)object4, (HL)pair.getFirst(), ((Number)pair.getSecond()).doubleValue());
                    break;
                }
                case 2: {
                    object2 = object;
                    object = ID.INSTANCE;
                    Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                    Pair pair = ((ID)object).a((ByteBuffer)object2);
                    Object object3 = (Pair)pair.component1();
                    Object object4 = (Pair)pair.component2();
                    pair = (Pair)pair.component3();
                    Integer n4 = (Integer)object3.getFirst();
                    object3 = (hb_0)object3.getSecond();
                    Integer n5 = (Integer)object4.getFirst();
                    object4 = (hb_0)object4.getSecond();
                    int n6 = ((ByteBuffer)object2).get();
                    Object object5 = IE.a((byte)n6) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                    n6 = ((ByteBuffer)object2).get();
                    Object object6 = IE.a((byte)n6) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                    n6 = ((ByteBuffer)object2).get();
                    Object object7 = IE.a((byte)n6) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                    n6 = ((ByteBuffer)object2).get();
                    HE.a a2 = IE.a((byte)n6) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                    n6 = ((ByteBuffer)object2).get();
                    Object object8 = IE.a((byte)n6) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                    hJ = new HF(n4, (hb_0)object3, n5, (hb_0)object4, (HL)pair.getFirst(), (Float)object5, (Float)object6, (Float)object7, (Float)((Object)a2), (Float)object8, ((Number)pair.getSecond()).doubleValue());
                    break;
                }
                case 3: {
                    object2 = object;
                    object = ID.INSTANCE;
                    Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                    Pair pair = ((ID)object).a((ByteBuffer)object2);
                    Object object3 = (Pair)pair.component1();
                    Object object4 = (Pair)pair.component2();
                    pair = (Pair)pair.component3();
                    Integer n4 = (Integer)object3.getFirst();
                    object3 = (hb_0)object3.getSecond();
                    Integer n5 = (Integer)object4.getFirst();
                    object4 = (hb_0)object4.getSecond();
                    int n6 = ((ByteBuffer)object2).get();
                    Object object5 = IE.a((byte)n6) ? ID.n((ByteBuffer)object2) : null;
                    hJ = new HP(n4, (hb_0)object3, n5, (hb_0)object4, (HL)pair.getFirst(), (HE.i)object5, ((Number)pair.getSecond()).doubleValue());
                    break;
                }
                case 4: {
                    Boolean bl;
                    object2 = object;
                    object = ID.INSTANCE;
                    Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                    Pair pair = ((ID)object).a((ByteBuffer)object2);
                    Object object3 = (Pair)pair.component1();
                    Object object4 = (Pair)pair.component2();
                    pair = (Pair)pair.component3();
                    Integer n4 = (Integer)object3.getFirst();
                    object3 = (hb_0)object3.getSecond();
                    Integer n5 = (Integer)object4.getFirst();
                    object4 = (hb_0)object4.getSecond();
                    int n6 = ((ByteBuffer)object2).get();
                    Object object5 = IE.a((byte)n6) ? ID.m((ByteBuffer)object2) : null;
                    n6 = ((ByteBuffer)object2).get();
                    Object object6 = IE.a((byte)n6) ? ID.t((ByteBuffer)object2) : null;
                    n6 = ((ByteBuffer)object2).get();
                    Object object7 = IE.a((byte)n6) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                    n6 = ((ByteBuffer)object2).get();
                    HE.a a2 = IE.a((byte)n6) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                    n6 = ((ByteBuffer)object2).get();
                    if (IE.a((byte)n6)) {
                        n6 = ((ByteBuffer)object2).get();
                        bl = IE.a((byte)n6);
                    } else {
                        bl = null;
                    }
                    Object object8 = bl;
                    hJ = new HO(n4, (hb_0)object3, n5, (hb_0)object4, (HL)pair.getFirst(), (HE.a)object5, (HO.a)object6, (Float)object7, (Float)((Object)a2), (Boolean)object8, ((Number)pair.getSecond()).doubleValue());
                    break;
                }
                case 5: {
                    object2 = object;
                    object = ID.INSTANCE;
                    Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                    Pair pair = ((ID)object).a((ByteBuffer)object2);
                    Object object3 = (Pair)pair.component1();
                    Object object4 = (Pair)pair.component2();
                    pair = (Pair)pair.component3();
                    Integer n4 = (Integer)object3.getFirst();
                    object3 = (hb_0)object3.getSecond();
                    Integer n5 = (Integer)object4.getFirst();
                    object4 = (hb_0)object4.getSecond();
                    int n6 = ((ByteBuffer)object2).get();
                    Object object5 = IE.a((byte)n6) ? ID.l((ByteBuffer)object2) : null;
                    hJ = new HM(n4, (hb_0)object3, n5, (hb_0)object4, (HL)pair.getFirst(), (HE.l)object5, ((Number)pair.getSecond()).doubleValue());
                    break;
                }
                case 6: {
                    object2 = object;
                    object = ID.INSTANCE;
                    Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                    Pair pair = ((ID)object).a((ByteBuffer)object2);
                    Object object3 = (Pair)pair.component1();
                    Object object4 = (Pair)pair.component2();
                    pair = (Pair)pair.component3();
                    Integer n4 = (Integer)object3.getFirst();
                    object3 = (hb_0)object3.getSecond();
                    Integer n5 = (Integer)object4.getFirst();
                    object4 = (hb_0)object4.getSecond();
                    int n6 = ((ByteBuffer)object2).get();
                    Object object5 = IE.a((byte)n6) ? ID.p((ByteBuffer)object2) : null;
                    n6 = ((ByteBuffer)object2).get();
                    Object object6 = IE.a((byte)n6) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                    hJ = new HH(n4, (hb_0)object3, n5, (hb_0)object4, (HL)pair.getFirst(), (HE.h)object5, (Float)object6, ((Number)pair.getSecond()).doubleValue());
                    break;
                }
                case 7: {
                    object2 = object;
                    object = ID.INSTANCE;
                    Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                    Pair pair = ((ID)object).a((ByteBuffer)object2);
                    Object object3 = (Pair)pair.component1();
                    Object object4 = (Pair)pair.component2();
                    pair = (Pair)pair.component3();
                    Integer n4 = (Integer)object3.getFirst();
                    object3 = (hb_0)object3.getSecond();
                    Integer n5 = (Integer)object4.getFirst();
                    object4 = (hb_0)object4.getSecond();
                    int n6 = ((ByteBuffer)object2).get();
                    Object object5 = IE.a((byte)n6) ? ID.p((ByteBuffer)object2) : null;
                    n6 = ((ByteBuffer)object2).get();
                    Object object6 = IE.a((byte)n6) ? Float.valueOf(((ByteBuffer)object2).getFloat()) : null;
                    n6 = ((ByteBuffer)object2).get();
                    Object object7 = IE.a((byte)n6) ? ID.q((ByteBuffer)object2) : null;
                    hJ = new HN(n4, (hb_0)object3, n5, (hb_0)object4, (HL)pair.getFirst(), (HE.h)object5, (Float)object6, (HN.a)object7, ((Number)pair.getSecond()).doubleValue());
                    break;
                }
                case 8: {
                    HE.f f2;
                    EnumMap enumMap;
                    HE.j j2;
                    Object object9;
                    Class<HE.e> clazz;
                    Object object10;
                    int n7;
                    Object object11;
                    Object object8;
                    Object object7;
                    Object object6;
                    object2 = object;
                    object = ID.INSTANCE;
                    Intrinsics.checkNotNullParameter((Object)object2, (String)"");
                    Pair pair = ((ID)object).a((ByteBuffer)object2);
                    Object object3 = (Pair)pair.component1();
                    Object object4 = (Pair)pair.component2();
                    pair = (Pair)pair.component3();
                    Integer n4 = (Integer)object3.getFirst();
                    object3 = (hb_0)object3.getSecond();
                    Integer n5 = (Integer)object4.getFirst();
                    object4 = (hb_0)object4.getSecond();
                    if (((ByteBuffer)object2).get() == 0) {
                        object11 = null;
                    } else {
                        int n8 = ((ByteBuffer)object2).getInt();
                        object8 = new EnumMap(HE.b.class);
                        n7 = 0;
                        while (n7 < n8) {
                            Object object12;
                            ++n7;
                            object10 = ((Enum[])HE.b.class.getEnumConstants())[((ByteBuffer)object2).getInt()];
                            clazz = HE.e.class;
                            if (Intrinsics.areEqual(HE.e.class, HE.e.class)) {
                                object12 = HE.e.values()[((ByteBuffer)object2).getInt()];
                            } else if (Intrinsics.areEqual(clazz, HE.l.class)) {
                                object12 = ID.l((ByteBuffer)object2);
                            } else if (Intrinsics.areEqual(clazz, HE.d.class)) {
                                object12 = ID.r((ByteBuffer)object2);
                            } else {
                                throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unsupported enum map value type: ", HE.e.class));
                            }
                            if (object12 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.valkyrienskies.physics_api.joints.D6Joint.D6Motion");
                            }
                            HE.e e2 = object12;
                            ((Map)object8).put(object10, e2);
                        }
                        object11 = object8;
                    }
                    Object object5 = object11;
                    byte by = ((ByteBuffer)object2).get();
                    Object object13 = object6 = IE.a(by) ? ID.k((ByteBuffer)object2) : null;
                    if (((ByteBuffer)object2).get() == 0) {
                        object9 = null;
                    } else {
                        n7 = ((ByteBuffer)object2).getInt();
                        object10 = new EnumMap(HE.b.class);
                        int n9 = 0;
                        while (n9 < n7) {
                            Object object14;
                            ++n9;
                            Enum enum_ = ((Enum[])HE.b.class.getEnumConstants())[((ByteBuffer)object2).getInt()];
                            object7 = HE.l.class;
                            if (Intrinsics.areEqual(HE.l.class, HE.e.class)) {
                                object14 = HE.e.values()[((ByteBuffer)object2).getInt()];
                            } else if (Intrinsics.areEqual((Object)object7, HE.l.class)) {
                                object14 = ID.l((ByteBuffer)object2);
                            } else if (Intrinsics.areEqual((Object)object7, HE.d.class)) {
                                object14 = ID.r((ByteBuffer)object2);
                            } else {
                                throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unsupported enum map value type: ", HE.l.class));
                            }
                            if (object14 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.valkyrienskies.physics_api.joints.D6Joint.LinearLimitPair");
                            }
                            object7 = (HE.l)object14;
                            ((Map)object10).put(enum_, object7);
                        }
                        object9 = object10;
                    }
                    object7 = object9;
                    int n6 = ((ByteBuffer)object2).get();
                    HE.a a2 = IE.a((byte)n6) ? ID.m((ByteBuffer)object2) : null;
                    n6 = ((ByteBuffer)object2).get();
                    object8 = IE.a((byte)n6) ? ID.n((ByteBuffer)object2) : null;
                    n6 = ((ByteBuffer)object2).get();
                    HE.j j3 = j2 = IE.a((byte)n6) ? ID.o((ByteBuffer)object2) : null;
                    if (((ByteBuffer)object2).get() == 0) {
                        enumMap = null;
                    } else {
                        int n10 = ((ByteBuffer)object2).getInt();
                        EnumMap enumMap2 = new EnumMap(HE.c.class);
                        n6 = 0;
                        while (n6 < n10) {
                            Object object15;
                            ++n6;
                            Enum enum_ = ((Enum[])HE.c.class.getEnumConstants())[((ByteBuffer)object2).getInt()];
                            Object object16 = HE.d.class;
                            if (Intrinsics.areEqual(HE.d.class, HE.e.class)) {
                                object15 = HE.e.values()[((ByteBuffer)object2).getInt()];
                            } else if (Intrinsics.areEqual(object16, HE.l.class)) {
                                object15 = ID.l((ByteBuffer)object2);
                            } else if (Intrinsics.areEqual(object16, HE.d.class)) {
                                object15 = ID.r((ByteBuffer)object2);
                            } else {
                                throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unsupported enum map value type: ", HE.d.class));
                            }
                            if (object15 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.valkyrienskies.physics_api.joints.D6Joint.D6JointDrive");
                            }
                            object16 = (HE.d)object15;
                            ((Map)enumMap2).put(enum_, object16);
                        }
                        enumMap = enumMap2;
                    }
                    object10 = enumMap;
                    n6 = ((ByteBuffer)object2).get();
                    if (IE.a((byte)n6)) {
                        Object object17 = object2;
                        object = ID.j((ByteBuffer)object17);
                        byte by2 = ((ByteBuffer)object17).get();
                        n6 = by2;
                        boolean bl = IE.a(by2);
                        f2 = new HE.f((hb_0)object, bl);
                    } else {
                        f2 = null;
                    }
                    clazz = f2;
                    byte by3 = ((ByteBuffer)object2).get();
                    n6 = by3;
                    object = IE.a(by3) ? ID.s((ByteBuffer)object2) : null;
                    hJ = new HE(n4, (hb_0)object3, n5, (hb_0)object4, (HL)pair.getFirst(), (EnumMap<HE.b, HE.e>)object5, (HE.k)object6, (EnumMap<HE.b, HE.l>)object7, a2, (HE.i)object8, j2, (EnumMap<HE.c, HE.d>)object10, (HE.f)((Object)clazz), (HE.g)object, ((Number)pair.getSecond()).doubleValue());
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unknown JointType " + object2);
                }
            }
            object = hJ;
            object = new HI(n3, (HJ)object);
            arrayList.add((HI)object);
        }
        return arrayList;
    }

    public static void a(HI hI, ByteBuffer byteBuffer) {
        HI hI2 = hI;
        byteBuffer.putInt(hI2.a);
        hI2 = hI;
        Ir.a(hI2.b, byteBuffer);
    }

    private static HI d(ByteBuffer object) {
        int n2 = ((ByteBuffer)object).getInt();
        object = Ir.c((ByteBuffer)object);
        return new HI(n2, (HJ)object);
    }

    public static void a(Vector3dc vector3dc, ByteBuffer byteBuffer) {
        byteBuffer.putDouble(vector3dc.x());
        byteBuffer.putDouble(vector3dc.y());
        byteBuffer.putDouble(vector3dc.z());
    }

    public static Vector3d b(ByteBuffer byteBuffer) {
        return new Vector3d(byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    private static void a(Quaterniondc quaterniondc, ByteBuffer byteBuffer) {
        byteBuffer.putDouble(quaterniondc.w());
        byteBuffer.putDouble(quaterniondc.x());
        byteBuffer.putDouble(quaterniondc.y());
        byteBuffer.putDouble(quaterniondc.z());
    }

    private static Quaterniond e(ByteBuffer byteBuffer) {
        double d2 = byteBuffer.getDouble();
        double d3 = byteBuffer.getDouble();
        double d4 = byteBuffer.getDouble();
        double d5 = byteBuffer.getDouble();
        return new Quaterniond(d3, d4, d5, d2);
    }
}

