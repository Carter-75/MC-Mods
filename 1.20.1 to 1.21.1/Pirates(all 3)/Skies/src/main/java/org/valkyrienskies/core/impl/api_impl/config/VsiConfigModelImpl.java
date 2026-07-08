/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KProperty
 *  kotlin.reflect.KProperty1
 *  kotlin.reflect.full.KClasses
 *  kotlin.reflect.jvm.ReflectJvmMapping
 */
package org.valkyrienskies.core.impl.api_impl.config;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.ReflectJvmMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.impl.api_impl.config.VsiConfigModelCategoryImpl;
import org.valkyrienskies.core.impl.api_impl.config.VsiConfigModelEntryImpl;
import org.valkyrienskies.core.internal.config.ConfigCategory;
import org.valkyrienskies.core.internal.config.ConfigEntry;
import org.valkyrienskies.core.internal.config.VsiConfigModel;
import org.valkyrienskies.core.internal.config.VsiConfigModelCategory;
import org.valkyrienskies.core.internal.config.VsiConfigModelEntry;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0018"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelImpl;", "Lorg/valkyrienskies/core/internal/config/VsiConfigModel;", "Lorg/valkyrienskies/core/internal/config/VsiConfigModelCategory;", "component1", "()Lorg/valkyrienskies/core/internal/config/VsiConfigModelCategory;", "root", "copy", "(Lorg/valkyrienskies/core/internal/config/VsiConfigModelCategory;)Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/internal/config/VsiConfigModelCategory;", "getRoot", "<init>", "(Lorg/valkyrienskies/core/internal/config/VsiConfigModelCategory;)V", "Companion", "internal"})
public final class VsiConfigModelImpl
implements VsiConfigModel {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final VsiConfigModelCategory root;

    public VsiConfigModelImpl(@NotNull VsiConfigModelCategory root) {
        Intrinsics.checkNotNullParameter((Object)root, (String)"root");
        this.root = root;
    }

    @Override
    @NotNull
    public VsiConfigModelCategory getRoot() {
        return this.root;
    }

    @NotNull
    public final VsiConfigModelCategory component1() {
        return this.root;
    }

    @NotNull
    public final VsiConfigModelImpl copy(@NotNull VsiConfigModelCategory root) {
        Intrinsics.checkNotNullParameter((Object)root, (String)"root");
        return new VsiConfigModelImpl(root);
    }

    public static /* synthetic */ VsiConfigModelImpl copy$default(VsiConfigModelImpl vsiConfigModelImpl, VsiConfigModelCategory vsiConfigModelCategory, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vsiConfigModelCategory = vsiConfigModelImpl.root;
        }
        return vsiConfigModelImpl.copy(vsiConfigModelCategory);
    }

    @NotNull
    public String toString() {
        return "VsiConfigModelImpl(root=" + this.root + ")";
    }

    public int hashCode() {
        return this.root.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VsiConfigModelImpl)) {
            return false;
        }
        VsiConfigModelImpl vsiConfigModelImpl = (VsiConfigModelImpl)other;
        return Intrinsics.areEqual((Object)this.root, (Object)vsiConfigModelImpl.root);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelImpl$Companion;", "", "root", "Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelImpl;", "build", "(Ljava/lang/Object;)Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelImpl;", "obj", "", "title", "Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelCategoryImpl;", "buildConfigTree", "(Ljava/lang/Object;Ljava/lang/String;)Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelCategoryImpl;", "Ljava/lang/reflect/Field;", "field", "getCategory", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelCategoryImpl;", "name", "Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelEntryImpl;", "getEntry", "(Ljava/lang/reflect/Field;Ljava/lang/String;Ljava/lang/Object;)Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelEntryImpl;", "<init>", "()V", "internal"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final VsiConfigModelImpl build(@NotNull Object root) {
            Intrinsics.checkNotNullParameter((Object)root, (String)"root");
            return new VsiConfigModelImpl(this.buildConfigTree(root, "root"));
        }

        private final VsiConfigModelCategoryImpl buildConfigTree(Object obj, String title) {
            VsiConfigModelCategoryImpl root = new VsiConfigModelCategoryImpl(title, null, 2, null);
            for (KProperty1 member : KClasses.getMemberProperties((KClass)Reflection.getOrCreateKotlinClass(obj.getClass()))) {
                Field field;
                if (ReflectJvmMapping.getJavaField((KProperty)((KProperty)member)) == null) continue;
                field.setAccessible(true);
                VsiConfigModelCategoryImpl category = this.getCategory(field, obj);
                if (category != null) {
                    root.addCategory(category);
                    continue;
                }
                String name = member.getName();
                VsiConfigModelEntryImpl<Object> entry = this.getEntry(field, name, obj);
                if (entry == null) continue;
                root.addEntry(name, (VsiConfigModelEntry)entry);
            }
            return root;
        }

        private final VsiConfigModelEntryImpl<Object> getEntry(Field field, String name, Object obj) {
            VsiConfigModelEntryImpl vsiConfigModelEntryImpl;
            ConfigEntry configEntry = field.getAnnotation(ConfigEntry.class);
            if (configEntry != null) {
                ConfigEntry annotation = configEntry;
                boolean bl = false;
                vsiConfigModelEntryImpl = VsiConfigModelEntryImpl.Companion.build((Function0)new Function0<Object>(field, obj){
                    final /* synthetic */ Field $field;
                    final /* synthetic */ Object $obj;
                    {
                        this.$field = $field;
                        this.$obj = $obj;
                        super(0);
                    }

                    public final Object invoke() {
                        Object object = this.$field.get(this.$obj);
                        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlin.Any");
                        return object;
                    }
                }, (Function1)new Function1<Object, Unit>(field, obj){
                    final /* synthetic */ Field $field;
                    final /* synthetic */ Object $obj;
                    {
                        this.$field = $field;
                        this.$obj = $obj;
                        super(1);
                    }

                    public final void invoke(Object v) {
                        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
                        this.$field.set(this.$obj, v);
                    }
                }, annotation.min(), annotation.max(), name, annotation.description());
            } else {
                vsiConfigModelEntryImpl = null;
            }
            return vsiConfigModelEntryImpl;
        }

        private final VsiConfigModelCategoryImpl getCategory(Field field, Object obj) {
            VsiConfigModelCategoryImpl vsiConfigModelCategoryImpl;
            ConfigCategory configCategory = field.getAnnotation(ConfigCategory.class);
            if (configCategory != null) {
                ConfigCategory annotation = configCategory;
                boolean bl = false;
                Object object = field.get(obj);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"field.get(obj)");
                vsiConfigModelCategoryImpl = Companion.buildConfigTree(object, annotation.title());
            } else {
                vsiConfigModelCategoryImpl = null;
            }
            return vsiConfigModelCategoryImpl;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

