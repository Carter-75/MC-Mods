/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 */
package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.internal.ClassValueCtorCache;
import kotlinx.coroutines.internal.CtorCache;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;
import kotlinx.coroutines.internal.FastServiceLoaderKt;
import kotlinx.coroutines.internal.WeakMapCtorCache;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000(\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a9\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0002`\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a5\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0002`\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0004H\u0002\u00a2\u0006\u0004\b\t\u0010\n\u001a#\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a\"\u0010\u0010\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0082\u0010\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\u0013\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0011\"\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0017\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018*(\b\u0002\u0010\u0019\"\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00042\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004\u00a8\u0006\u001a"}, d2={"", "E", "Ljava/lang/Class;", "clz", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "createConstructor", "(Ljava/lang/Class;)Lkotlin/jvm/functions/Function1;", "block", "safeCtor", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "exception", "tryCopyException", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "", "accumulator", "fieldsCount", "(Ljava/lang/Class;I)I", "defaultValue", "fieldsCountOrDefault", "Lkotlinx/coroutines/internal/CtorCache;", "ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "throwableFields", "I", "Ctor", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,116:1\n1#2:117\n11335#3:118\n11670#3,3:119\n12904#3,3:136\n1963#4,14:122\n*S KotlinDebug\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n*L\n45#1:118\n45#1:119,3\n82#1:136,3\n63#1:122,14\n*E\n"})
public final class ExceptionsConstructorKt {
    private static final int throwableFields;
    @NotNull
    private static final CtorCache ctorCache;

    @Nullable
    public static final <E extends Throwable> E tryCopyException(@NotNull E exception) {
        if (exception instanceof CopyableThrowable) {
            Object object;
            try {
                boolean bl = false;
                object = Result.constructor-impl(((CopyableThrowable)((Object)exception)).createCopy());
            }
            catch (Throwable throwable) {
                object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            return (E)((Throwable)(Result.isFailure-impl((Object)object) ? null : object));
        }
        return (E)((Throwable)ctorCache.get(exception.getClass()).invoke(exception));
    }

    /*
     * WARNING - void declaration
     */
    private static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> clz) {
        Pair pair;
        Object v1;
        void $this$mapTo$iv$iv;
        Function1 nullResult2 = createConstructor.nullResult.1.INSTANCE;
        if (throwableFields != ExceptionsConstructorKt.fieldsCountOrDefault(clz, 0)) {
            return nullResult2;
        }
        Constructor<?>[] $this$map$iv = clz.getConstructors();
        boolean $i$f$map = false;
        Constructor<?>[] constructorArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        int n2 = ((void)$this$mapTo$iv$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Pair pair2;
            void constructor;
            void item$iv$iv;
            void var10_15 = item$iv$iv = $this$mapTo$iv$iv[i2];
            Collection collection = destination$iv$iv;
            boolean bl = false;
            Class<?>[] p = constructor.getParameterTypes();
            switch (p.length) {
                case 2: {
                    if (Intrinsics.areEqual(p[0], String.class) && Intrinsics.areEqual(p[1], Throwable.class)) {
                        pair2 = TuplesKt.to(ExceptionsConstructorKt.safeCtor((Function1<? super Throwable, ? extends Throwable>)((Function1)new Function1<Throwable, Throwable>(constructor){
                            final /* synthetic */ Constructor<?> $constructor;
                            {
                                this.$constructor = $constructor;
                                super(1);
                            }

                            @NotNull
                            public final Throwable invoke(@NotNull Throwable e2) {
                                Object[] objectArray = new Object[]{e2.getMessage(), e2};
                                ? obj = this.$constructor.newInstance(objectArray);
                                Intrinsics.checkNotNull(obj, (String)"null cannot be cast to non-null type kotlin.Throwable");
                                return (Throwable)obj;
                            }
                        })), (Object)3);
                        break;
                    }
                    pair2 = TuplesKt.to(null, (Object)-1);
                    break;
                }
                case 1: {
                    Class<?> clazz = p[0];
                    if (Intrinsics.areEqual(clazz, String.class)) {
                        pair2 = TuplesKt.to(ExceptionsConstructorKt.safeCtor((Function1<? super Throwable, ? extends Throwable>)((Function1)new Function1<Throwable, Throwable>(constructor){
                            final /* synthetic */ Constructor<?> $constructor;
                            {
                                this.$constructor = $constructor;
                                super(1);
                            }

                            @NotNull
                            public final Throwable invoke(@NotNull Throwable e2) {
                                Throwable throwable;
                                Object[] objectArray = new Object[]{e2.getMessage()};
                                ? obj = this.$constructor.newInstance(objectArray);
                                Intrinsics.checkNotNull(obj, (String)"null cannot be cast to non-null type kotlin.Throwable");
                                Throwable it = throwable = (Throwable)obj;
                                boolean bl = false;
                                it.initCause(e2);
                                return throwable;
                            }
                        })), (Object)2);
                        break;
                    }
                    if (Intrinsics.areEqual(clazz, Throwable.class)) {
                        pair2 = TuplesKt.to(ExceptionsConstructorKt.safeCtor((Function1<? super Throwable, ? extends Throwable>)((Function1)new Function1<Throwable, Throwable>(constructor){
                            final /* synthetic */ Constructor<?> $constructor;
                            {
                                this.$constructor = $constructor;
                                super(1);
                            }

                            @NotNull
                            public final Throwable invoke(@NotNull Throwable e2) {
                                Object[] objectArray = new Object[]{e2};
                                ? obj = this.$constructor.newInstance(objectArray);
                                Intrinsics.checkNotNull(obj, (String)"null cannot be cast to non-null type kotlin.Throwable");
                                return (Throwable)obj;
                            }
                        })), (Object)1);
                        break;
                    }
                    pair2 = TuplesKt.to(null, (Object)-1);
                    break;
                }
                case 0: {
                    pair2 = TuplesKt.to(ExceptionsConstructorKt.safeCtor((Function1<? super Throwable, ? extends Throwable>)((Function1)new Function1<Throwable, Throwable>(constructor){
                        final /* synthetic */ Constructor<?> $constructor;
                        {
                            this.$constructor = $constructor;
                            super(1);
                        }

                        @NotNull
                        public final Throwable invoke(@NotNull Throwable e2) {
                            Throwable throwable;
                            ? obj = this.$constructor.newInstance(new Object[0]);
                            Intrinsics.checkNotNull(obj, (String)"null cannot be cast to non-null type kotlin.Throwable");
                            Throwable it = throwable = (Throwable)obj;
                            boolean bl = false;
                            it.initCause(e2);
                            return throwable;
                        }
                    })), (Object)0);
                    break;
                }
                default: {
                    pair2 = TuplesKt.to(null, (Object)-1);
                }
            }
            collection.add(pair2);
        }
        Iterable $this$maxByOrNull$iv = (List)destination$iv$iv;
        boolean $i$f$maxByOrNull = false;
        Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
        if (!iterator$iv.hasNext()) {
            v1 = null;
        } else {
            Object maxElem$iv = iterator$iv.next();
            if (!iterator$iv.hasNext()) {
                v1 = maxElem$iv;
            } else {
                Pair p0 = (Pair)maxElem$iv;
                boolean bl = false;
                int maxValue$iv = ((Number)p0.getSecond()).intValue();
                do {
                    Object e$iv = iterator$iv.next();
                    Pair p02 = (Pair)e$iv;
                    $i$a$-maxByOrNull-ExceptionsConstructorKt$createConstructor$2 = false;
                    int v$iv = ((Number)p02.getSecond()).intValue();
                    if (maxValue$iv >= v$iv) continue;
                    maxElem$iv = e$iv;
                    maxValue$iv = v$iv;
                } while (iterator$iv.hasNext());
                v1 = maxElem$iv;
            }
        }
        if ((pair = (Pair)v1) == null || (pair = (Function1)pair.getFirst()) == null) {
            pair = nullResult2;
        }
        return pair;
    }

    private static final Function1<Throwable, Throwable> safeCtor(Function1<? super Throwable, ? extends Throwable> block) {
        return (Function1)new Function1<Throwable, Throwable>(block){
            final /* synthetic */ Function1<Throwable, Throwable> $block;
            {
                this.$block = $block;
                super(1);
            }

            @Nullable
            public final Throwable invoke(@NotNull Throwable e2) {
                Object object;
                Object object2 = this.$block;
                try {
                    boolean bl = false;
                    Throwable result2 = (Throwable)object2.invoke((Object)e2);
                    object = Result.constructor-impl((Object)(!Intrinsics.areEqual((Object)e2.getMessage(), (Object)result2.getMessage()) && !Intrinsics.areEqual((Object)result2.getMessage(), (Object)e2.toString()) ? null : result2));
                }
                catch (Throwable throwable) {
                    object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                }
                object2 = object;
                return (Throwable)(Result.isFailure-impl(object2) ? null : object2);
            }
        };
    }

    private static final int fieldsCountOrDefault(Class<?> $this$fieldsCountOrDefault, int defaultValue) {
        Object object;
        Object object2 = JvmClassMappingKt.getKotlinClass($this$fieldsCountOrDefault);
        try {
            KClass $this$fieldsCountOrDefault_u24lambda_u242 = object2;
            boolean bl = false;
            object = Result.constructor-impl((Object)ExceptionsConstructorKt.fieldsCount$default($this$fieldsCountOrDefault, 0, 1, null));
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        object2 = object;
        object = defaultValue;
        return ((Number)(Result.isFailure-impl((Object)object2) ? object : object2)).intValue();
    }

    private static final int fieldsCount(Class<?> $this$fieldsCount, int accumulator) {
        while (true) {
            Class<?> superClass;
            Field[] $this$count$iv = $this$fieldsCount.getDeclaredFields();
            boolean $i$f$count = false;
            int count$iv = 0;
            int n2 = $this$count$iv.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Field element$iv;
                Field it = element$iv = $this$count$iv[i2];
                boolean bl = false;
                if (!(!Modifier.isStatic(it.getModifiers()))) continue;
                ++count$iv;
            }
            int fieldsCount = count$iv;
            int totalFields = accumulator + fieldsCount;
            if ($this$fieldsCount.getSuperclass() == null) {
                return totalFields;
            }
            $this$fieldsCount = superClass;
            accumulator = totalFields;
        }
    }

    static /* synthetic */ int fieldsCount$default(Class clazz, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = 0;
        }
        return ExceptionsConstructorKt.fieldsCount(clazz, n2);
    }

    public static final /* synthetic */ Function1 access$createConstructor(Class clz) {
        return ExceptionsConstructorKt.createConstructor(clz);
    }

    static {
        CtorCache ctorCache;
        throwableFields = ExceptionsConstructorKt.fieldsCountOrDefault(Throwable.class, -1);
        try {
            ctorCache = FastServiceLoaderKt.getANDROID_DETECTED() ? (CtorCache)WeakMapCtorCache.INSTANCE : (CtorCache)ClassValueCtorCache.INSTANCE;
        }
        catch (Throwable e2) {
            ctorCache = WeakMapCtorCache.INSTANCE;
        }
        ExceptionsConstructorKt.ctorCache = ctorCache;
    }
}

