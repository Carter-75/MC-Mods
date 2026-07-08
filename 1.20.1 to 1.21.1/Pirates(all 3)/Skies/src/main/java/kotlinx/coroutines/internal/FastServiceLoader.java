/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 */
package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.internal.FastServiceLoaderKt;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J(\u0010\u0007\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0082\b\u00a2\u0006\u0004\b\u0007\u0010\bJ3\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0012J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ.\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010 *\u00020!2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00028\u00000\"H\u0082\b\u00a2\u0006\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006*"}, d2={"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "Ljava/lang/Class;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "", "serviceClass", "createInstanceOf", "(Ljava/lang/Class;Ljava/lang/String;)Lkotlinx/coroutines/internal/MainDispatcherFactory;", "S", "name", "Ljava/lang/ClassLoader;", "loader", "service", "getProviderInstance", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "", "load", "(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/List;", "loadMainDispatcherFactory$kotlinx_coroutines_core", "()Ljava/util/List;", "loadMainDispatcherFactory", "loadProviders$kotlinx_coroutines_core", "loadProviders", "Ljava/net/URL;", "url", "parse", "(Ljava/net/URL;)Ljava/util/List;", "Ljava/io/BufferedReader;", "r", "parseFile", "(Ljava/io/BufferedReader;)Ljava/util/List;", "R", "Ljava/util/jar/JarFile;", "Lkotlin/Function1;", "block", "use", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "PREFIX", "Ljava/lang/String;", "<init>", "()V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nFastServiceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,161:1\n77#1,5:162\n77#1,5:168\n131#1,13:183\n1#2:167\n1360#3:173\n1446#3,5:174\n1549#3:179\n1620#3,3:180\n1064#4,2:196\n*S KotlinDebug\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n*L\n60#1:162,5\n61#1:168,5\n117#1:183,13\n99#1:173\n99#1:174,5\n101#1:179\n101#1:180,3\n153#1:196,2\n*E\n"})
public final class FastServiceLoader {
    @NotNull
    public static final FastServiceLoader INSTANCE = new FastServiceLoader();
    @NotNull
    private static final String PREFIX = "META-INF/services/";

    private FastServiceLoader() {
    }

    @NotNull
    public final List<MainDispatcherFactory> loadMainDispatcherFactory$kotlinx_coroutines_core() {
        List<MainDispatcherFactory> list;
        Class<MainDispatcherFactory> clz = MainDispatcherFactory.class;
        if (!FastServiceLoaderKt.getANDROID_DETECTED()) {
            return this.load(clz, clz.getClassLoader());
        }
        try {
            MainDispatcherFactory mainDispatcherFactory;
            Object this_$iv;
            Class<?> clz$iv;
            ArrayList<Object> result2 = new ArrayList<Object>(2);
            FastServiceLoader fastServiceLoader = this;
            String serviceClass$iv = "kotlinx.coroutines.android.AndroidDispatcherFactory";
            boolean $i$f$createInstanceOf = false;
            try {
                clz$iv = Class.forName(serviceClass$iv, true, clz.getClassLoader());
                clz$iv = (MainDispatcherFactory)clz.cast(clz$iv.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            catch (ClassNotFoundException e$iv) {
                clz$iv = null;
            }
            Class<?> clazz = clz$iv;
            if (clazz != null) {
                this_$iv = clazz;
                Class<?> $this$loadMainDispatcherFactory_u24lambda_u240 = this_$iv;
                boolean bl = false;
                result2.add($this$loadMainDispatcherFactory_u24lambda_u240);
            }
            this_$iv = this;
            serviceClass$iv = "kotlinx.coroutines.test.internal.TestMainDispatcherFactory";
            $i$f$createInstanceOf = false;
            try {
                clz$iv = Class.forName(serviceClass$iv, true, clz.getClassLoader());
                mainDispatcherFactory = (MainDispatcherFactory)clz.cast(clz$iv.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            catch (ClassNotFoundException e$iv) {
                mainDispatcherFactory = null;
            }
            MainDispatcherFactory mainDispatcherFactory2 = mainDispatcherFactory;
            if (mainDispatcherFactory2 != null) {
                FastServiceLoader $this$loadMainDispatcherFactory_u24lambda_u241 = fastServiceLoader = mainDispatcherFactory2;
                boolean bl = false;
                result2.add($this$loadMainDispatcherFactory_u24lambda_u241);
            }
        }
        catch (Throwable e2) {
            list = this.load(clz, clz.getClassLoader());
        }
        return list;
    }

    private final MainDispatcherFactory createInstanceOf(Class<MainDispatcherFactory> baseClass, String serviceClass) {
        MainDispatcherFactory mainDispatcherFactory;
        boolean $i$f$createInstanceOf = false;
        try {
            Class<?> clz = Class.forName(serviceClass, true, baseClass.getClassLoader());
            mainDispatcherFactory = baseClass.cast(clz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (ClassNotFoundException e2) {
            mainDispatcherFactory = null;
        }
        return mainDispatcherFactory;
    }

    private final <S> List<S> load(Class<S> service, ClassLoader loader) {
        List list;
        try {
            list = this.loadProviders$kotlinx_coroutines_core(service, loader);
        }
        catch (Throwable e2) {
            list = CollectionsKt.toList((Iterable)ServiceLoader.load(service, loader));
        }
        return list;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final <S> List<S> loadProviders$kotlinx_coroutines_core(@NotNull Class<S> service, @NotNull ClassLoader loader) {
        void $this$mapTo$iv$iv;
        Object list$iv$iv;
        URL it;
        Iterable $this$flatMapTo$iv$iv;
        void $this$flatMap$iv;
        String fullServiceName = PREFIX + service.getName();
        Enumeration<URL> urls = loader.getResources(fullServiceName);
        ArrayList<URL> arrayList = Collections.list(urls);
        Intrinsics.checkNotNullExpressionValue(arrayList, (String)"list(this)");
        Iterable iterable = arrayList;
        boolean $i$f$flatMap = false;
        void var8_8 = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            it = (URL)element$iv$iv;
            boolean bl = false;
            list$iv$iv = INSTANCE.parse(it);
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        Set providers = CollectionsKt.toSet((Iterable)((List)destination$iv$iv));
        if (!(!((Collection)providers).isEmpty())) {
            boolean $i$a$-require-FastServiceLoader$loadProviders$22 = false;
            String $i$a$-require-FastServiceLoader$loadProviders$22 = "No providers were loaded with FastServiceLoader";
            throw new IllegalArgumentException($i$a$-require-FastServiceLoader$loadProviders$22.toString());
        }
        Iterable $this$map$iv = providers;
        boolean $i$f$map = false;
        $this$flatMapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            list$iv$iv = (String)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(INSTANCE.getProviderInstance((String)((Object)it), loader, service));
        }
        return (List)destination$iv$iv;
    }

    private final <S> S getProviderInstance(String name, ClassLoader loader, Class<S> service) {
        Class<?> clazz = Class.forName(name, false, loader);
        if (!service.isAssignableFrom(clazz)) {
            boolean bl = false;
            String string = "Expected service of class " + service + ", but found " + clazz;
            throw new IllegalArgumentException(string.toString());
        }
        return service.cast(clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     */
    private final List<String> parse(URL url) {
        List<String> list;
        String path = url.toString();
        if (StringsKt.startsWith$default((String)path, (String)"jar", (boolean)false, (int)2, null)) {
            String pathToJar = StringsKt.substringBefore$default((String)StringsKt.substringAfter$default((String)path, (String)"jar:file:", null, (int)2, null), (char)'!', null, (int)2, null);
            String entry = StringsKt.substringAfter$default((String)path, (String)"!/", null, (int)2, null);
            FastServiceLoader fastServiceLoader = this;
            JarFile $this$use$iv = new JarFile(pathToJar, false);
            boolean $i$f$use = false;
            Throwable cause$iv = null;
            JarFile file = $this$use$iv;
            boolean bl = false;
            Closeable closeable = new BufferedReader(new InputStreamReader(file.getInputStream(new ZipEntry(entry)), "UTF-8"));
            Throwable throwable = null;
            BufferedReader r = (BufferedReader)closeable;
            boolean bl2 = false;
            List<String> list2 = INSTANCE.parseFile(r);
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            List<String> list3 = list2;
            $this$use$iv.close();
            return list3;
            {
                catch (Throwable throwable2) {
                    try {
                        try {
                            try {
                                throwable = throwable2;
                                throw throwable2;
                            }
                            catch (Throwable throwable3) {
                                CloseableKt.closeFinally((Closeable)closeable, throwable);
                                throw throwable3;
                            }
                        }
                        catch (Throwable e$iv) {
                            cause$iv = e$iv;
                            throw e$iv;
                        }
                    }
                    catch (Throwable throwable4) {
                        try {
                            $this$use$iv.close();
                        }
                        catch (Throwable closeException$iv) {
                            if (cause$iv == null) {
                                throw closeException$iv;
                            }
                            ExceptionsKt.addSuppressed((Throwable)cause$iv, (Throwable)closeException$iv);
                            throw cause$iv;
                        }
                        throw throwable4;
                    }
                }
            }
        }
        Closeable closeable = new BufferedReader(new InputStreamReader(url.openStream()));
        Throwable throwable = null;
        try {
            BufferedReader reader = (BufferedReader)closeable;
            boolean bl = false;
            list = INSTANCE.parseFile(reader);
        }
        catch (Throwable throwable5) {
            throwable = throwable5;
            throw throwable5;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        return list;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final <R> R use(JarFile $this$use, Function1<? super JarFile, ? extends R> block) {
        Object object;
        boolean $i$f$use = false;
        Throwable cause = null;
        try {
            object = block.invoke((Object)$this$use);
        }
        catch (Throwable e2) {
            try {
                cause = e2;
                throw e2;
            }
            catch (Throwable throwable) {
                InlineMarker.finallyStart((int)1);
                try {
                    $this$use.close();
                }
                catch (Throwable closeException) {
                    if (cause == null) {
                        throw closeException;
                    }
                    ExceptionsKt.addSuppressed((Throwable)cause, (Throwable)closeException);
                    throw cause;
                }
                InlineMarker.finallyEnd((int)1);
                throw throwable;
            }
        }
        InlineMarker.finallyStart((int)1);
        $this$use.close();
        InlineMarker.finallyEnd((int)1);
        return (R)object;
    }

    private final List<String> parseFile(BufferedReader r) {
        Set names = new LinkedHashSet();
        while (r.readLine() != null) {
            boolean bl;
            String serviceName;
            block3: {
                String line;
                serviceName = ((Object)StringsKt.trim((CharSequence)StringsKt.substringBefore$default((String)line, (String)"#", null, (int)2, null))).toString();
                CharSequence $this$all$iv = serviceName;
                boolean $i$f$all = false;
                for (int i2 = 0; i2 < $this$all$iv.length(); ++i2) {
                    char element$iv;
                    char it = element$iv = $this$all$iv.charAt(i2);
                    boolean bl2 = false;
                    if (it == '.' || Character.isJavaIdentifierPart(it)) continue;
                    bl = false;
                    break block3;
                }
                bl = true;
            }
            if (!bl) {
                boolean bl3 = false;
                String string = "Illegal service provider class name: " + serviceName;
                throw new IllegalArgumentException(string.toString());
            }
            if (!(((CharSequence)serviceName).length() > 0)) continue;
            names.add(serviceName);
        }
        return CollectionsKt.toList((Iterable)names);
    }
}

