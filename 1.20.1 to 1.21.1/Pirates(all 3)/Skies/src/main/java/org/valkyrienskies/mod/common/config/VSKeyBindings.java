/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.class_304
 */
package org.valkyrienskies.mod.common.config;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.class_304;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013R&\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\u000b0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001a\u00a8\u0006\u001f"}, d2={"Lorg/valkyrienskies/mod/common/config/VSKeyBindings;", "", "", "name", "", "keyCode", "category", "Ljava/util/function/Supplier;", "Lnet/minecraft/class_304;", "register", "(Ljava/lang/String;ILjava/lang/String;)Ljava/util/function/Supplier;", "Ljava/util/function/Consumer;", "registerar", "", "clientSetup", "(Ljava/util/function/Consumer;)V", "keyMapping", "", "isKeyMappingFromVS2", "(Lnet/minecraft/class_304;)Z", "", "toBeRegistered", "Ljava/util/List;", "shipDown", "Ljava/util/function/Supplier;", "getShipDown", "()Ljava/util/function/Supplier;", "shipCruise", "getShipCruise", "<init>", "()V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nVSKeyBindings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VSKeyBindings.kt\norg/valkyrienskies/mod/common/config/VSKeyBindings\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,41:1\n1#2:42\n1863#3,2:43\n*S KotlinDebug\n*F\n+ 1 VSKeyBindings.kt\norg/valkyrienskies/mod/common/config/VSKeyBindings\n*L\n34#1:43,2\n*E\n"})
public final class VSKeyBindings {
    @NotNull
    public static final VSKeyBindings INSTANCE = new VSKeyBindings();
    @NotNull
    private static final List<Consumer<Consumer<class_304>>> toBeRegistered = new ArrayList();
    @NotNull
    private static final Supplier<class_304> shipDown = INSTANCE.register("key.valkyrienskies.ship_down", 86, "category.valkyrienskies.driving");
    @NotNull
    private static final Supplier<class_304> shipCruise = INSTANCE.register("key.valkyrienskies.ship_cruise", 67, "category.valkyrienskies.driving");

    private VSKeyBindings() {
    }

    @NotNull
    public final Supplier<class_304> getShipDown() {
        return shipDown;
    }

    @NotNull
    public final Supplier<class_304> getShipCruise() {
        return shipCruise;
    }

    private final Supplier<class_304> register(String name, int keyCode, String category) {
        Supplier<class_304> supplier;
        Supplier<class_304> $this$register_u24lambda_u240 = supplier = new Supplier<class_304>(name, keyCode, category){
            public class_304 registered;
            final /* synthetic */ String $name;
            final /* synthetic */ int $keyCode;
            final /* synthetic */ String $category;
            {
                this.$name = $name;
                this.$keyCode = $keyCode;
                this.$category = $category;
            }

            public final class_304 getRegistered() {
                class_304 class_3042 = this.registered;
                if (class_3042 != null) {
                    return class_3042;
                }
                Intrinsics.throwUninitializedPropertyAccessException((String)"registered");
                return null;
            }

            public final void setRegistered(class_304 class_3042) {
                Intrinsics.checkNotNullParameter((Object)class_3042, (String)"<set-?>");
                this.registered = class_3042;
            }

            public class_304 get() {
                return this.getRegistered();
            }

            public void accept(Consumer<class_304> t) {
                Intrinsics.checkNotNullParameter(t, (String)"t");
                this.setRegistered(new class_304(this.$name, this.$keyCode, this.$category));
                t.accept(this.getRegistered());
            }
        };
        boolean bl = false;
        toBeRegistered.add((Consumer<Consumer<class_304>>)((Object)$this$register_u24lambda_u240));
        return supplier;
    }

    public final void clientSetup(@NotNull Consumer<class_304> registerar) {
        Intrinsics.checkNotNullParameter(registerar, (String)"registerar");
        Iterable $this$forEach$iv = toBeRegistered;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Consumer it = (Consumer)element$iv;
            boolean bl = false;
            it.accept(registerar);
        }
    }

    public final boolean isKeyMappingFromVS2(@NotNull class_304 keyMapping) {
        Intrinsics.checkNotNullParameter((Object)keyMapping, (String)"keyMapping");
        String string = keyMapping.method_1431();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        return StringsKt.startsWith$default((String)string, (String)"key.valkyrienskies", (boolean)false, (int)2, null);
    }
}

