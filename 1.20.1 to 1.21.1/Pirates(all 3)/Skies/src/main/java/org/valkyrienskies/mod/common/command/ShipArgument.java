/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.StringReader
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.exceptions.CommandSyntaxException
 *  com.mojang.brigadier.suggestion.Suggestions
 *  com.mojang.brigadier.suggestion.SuggestionsBuilder
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_2164
 *  net.minecraft.class_2168
 *  net.minecraft.class_2172
 *  net.minecraft.class_2561
 */
package org.valkyrienskies.mod.common.command;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_2164;
import net.minecraft.class_2168;
import net.minecraft.class_2172;
import net.minecraft.class_2561;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.world.ShipWorld;
import org.valkyrienskies.mod.common.command.ShipArgumentParser;
import org.valkyrienskies.mod.common.command.ShipSelector;
import org.valkyrienskies.mod.common.command.VSCommandsKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0011\b\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eJ5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\"\b\b\u0000\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2={"Lorg/valkyrienskies/mod/common/command/ShipArgument;", "Lcom/mojang/brigadier/arguments/ArgumentType;", "Lorg/valkyrienskies/mod/common/command/ShipSelector;", "", "S", "Lcom/mojang/brigadier/context/CommandContext;", "context", "Lcom/mojang/brigadier/suggestion/SuggestionsBuilder;", "builder", "Ljava/util/concurrent/CompletableFuture;", "Lcom/mojang/brigadier/suggestion/Suggestions;", "listSuggestions", "(Lcom/mojang/brigadier/context/CommandContext;Lcom/mojang/brigadier/suggestion/SuggestionsBuilder;)Ljava/util/concurrent/CompletableFuture;", "Lcom/mojang/brigadier/StringReader;", "reader", "parse", "(Lcom/mojang/brigadier/StringReader;)Lorg/valkyrienskies/mod/common/command/ShipSelector;", "", "", "getExamples", "()Ljava/util/Collection;", "", "selectorOnly", "Z", "getSelectorOnly", "()Z", "", "EXAMPLES", "Ljava/util/List;", "<init>", "(Z)V", "Companion", "valkyrienskies-120"})
public final class ShipArgument
implements ArgumentType<ShipSelector> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean selectorOnly;
    @NotNull
    private final List<String> EXAMPLES;
    @NotNull
    private static final class_2164 ERROR_NO_SHIP_FOUND = new class_2164((class_2561)class_2561.method_43471((String)"argument.valkyrienskies.ship.no_found"));
    @NotNull
    private static final class_2164 ERROR_MANY_SHIP_FOUND = new class_2164((class_2561)class_2561.method_43471((String)"argument.valkyrienskies.ship.multiple_found"));

    private ShipArgument(boolean selectorOnly) {
        this.selectorOnly = selectorOnly;
        Object[] objectArray = new String[]{"the-mogus", "@v", "@v[slug=the-mogus]"};
        this.EXAMPLES = CollectionsKt.listOf((Object[])objectArray);
    }

    public final boolean getSelectorOnly() {
        return this.selectorOnly;
    }

    @NotNull
    public <S> CompletableFuture<Suggestions> listSuggestions(@NotNull CommandContext<S> context, @NotNull SuggestionsBuilder builder) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        StringReader reader = new StringReader(builder.getInput());
        reader.setCursor(builder.getStart());
        boolean startsWithAt = reader.canRead() && reader.peek() == '@';
        Object object = context.getSource();
        ShipArgumentParser parser = new ShipArgumentParser(object instanceof class_2172 ? (class_2172)object : null, this.selectorOnly);
        try {
            parser.parse(reader, true);
        }
        catch (CommandSyntaxException commandSyntaxException) {
            // empty catch block
        }
        if (!startsWithAt) {
            reader.setCursor(builder.getStart());
        }
        SuggestionsBuilder nBuilder = builder.createOffset(reader.getCursor());
        Function1<SuggestionsBuilder, Unit> function1 = parser.getSuggestionProvider();
        Intrinsics.checkNotNull((Object)nBuilder);
        function1.invoke((Object)nBuilder);
        CompletableFuture completableFuture = nBuilder.buildFuture();
        Intrinsics.checkNotNullExpressionValue((Object)completableFuture, (String)"buildFuture(...)");
        return completableFuture;
    }

    @NotNull
    public ShipSelector parse(@NotNull StringReader reader) {
        Intrinsics.checkNotNullParameter((Object)reader, (String)"reader");
        return new ShipArgumentParser(null, this.selectorOnly).parse(reader, false);
    }

    @NotNull
    public Collection<String> getExamples() {
        return this.EXAMPLES;
    }

    @JvmStatic
    @NotNull
    public static final ShipArgument selectorOnly() {
        return Companion.selectorOnly();
    }

    @JvmStatic
    @NotNull
    public static final ShipArgument ships() {
        return Companion.ships();
    }

    @JvmStatic
    @NotNull
    public static final Set<Ship> getShips(@NotNull CommandContext<class_2168> context, @NotNull String argName) {
        return Companion.getShips(context, argName);
    }

    @JvmStatic
    @NotNull
    public static final Ship getShip(@NotNull CommandContext<class_2168> context, @NotNull String argName) {
        return Companion.getShip(context, argName);
    }

    public /* synthetic */ ShipArgument(boolean selectorOnly, DefaultConstructorMarker $constructor_marker) {
        this(selectorOnly);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0004J+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ%\u0010\u000f\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013\u00a8\u0006\u0017"}, d2={"Lorg/valkyrienskies/mod/common/command/ShipArgument$Companion;", "", "Lorg/valkyrienskies/mod/common/command/ShipArgument;", "selectorOnly", "()Lorg/valkyrienskies/mod/common/command/ShipArgument;", "ships", "Lcom/mojang/brigadier/context/CommandContext;", "Lnet/minecraft/class_2168;", "context", "", "argName", "", "Lorg/valkyrienskies/core/api/ships/Ship;", "getShips", "(Lcom/mojang/brigadier/context/CommandContext;Ljava/lang/String;)Ljava/util/Set;", "getShip", "(Lcom/mojang/brigadier/context/CommandContext;Ljava/lang/String;)Lorg/valkyrienskies/core/api/ships/Ship;", "Lnet/minecraft/class_2164;", "ERROR_NO_SHIP_FOUND", "Lnet/minecraft/class_2164;", "ERROR_MANY_SHIP_FOUND", "<init>", "()V", "valkyrienskies-120"})
    @SourceDebugExtension(value={"SMAP\nShipArgument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShipArgument.kt\norg/valkyrienskies/mod/common/command/ShipArgument$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,107:1\n1557#2:108\n1628#2,3:109\n774#2:112\n865#2,2:113\n*S KotlinDebug\n*F\n+ 1 ShipArgument.kt\norg/valkyrienskies/mod/common/command/ShipArgument$Companion\n*L\n74#1:108\n74#1:109,3\n79#1:112\n79#1:113,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final ShipArgument selectorOnly() {
            return new ShipArgument(true, null);
        }

        @JvmStatic
        @NotNull
        public final ShipArgument ships() {
            return new ShipArgument(false, null);
        }

        /*
         * WARNING - void declaration
         */
        @JvmStatic
        @NotNull
        public final Set<Ship> getShips(@NotNull CommandContext<class_2168> context, @NotNull String argName) {
            void $this$filterTo$iv$iv;
            void $this$filter$iv;
            Set<Ship> set;
            void $this$mapTo$iv$iv;
            Intrinsics.checkNotNullParameter(context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)argName, (String)"argName");
            ShipSelector selector = (ShipSelector)context.getArgument(argName, ShipSelector.class);
            Object object = context.getSource();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
            ShipWorld shipWorld = VSCommandsKt.getShipWorld((class_2172)object);
            Set<Ship> fromLoadedShips = selector.select(shipWorld.getLoadedShips());
            Iterable $this$map$iv = fromLoadedShips;
            boolean $i$f$map22 = false;
            Iterable iterable = $this$map$iv;
            Set<Ship> destination$iv$iv = (Set<Ship>)((Object)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10)));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                Ship ship = (Ship)item$iv$iv;
                set = destination$iv$iv;
                boolean bl = false;
                set.add((Ship)((Object)Long.valueOf(it.getId())));
            }
            Set fromLoadedShipIds = CollectionsKt.toSet((Iterable)((List)((Object)destination$iv$iv)));
            Set<Ship> fromUnloadedShips = selector.select(shipWorld.getAllShips());
            Iterable $i$f$map22 = fromUnloadedShips;
            set = fromLoadedShips;
            boolean $i$f$filter = false;
            destination$iv$iv = $this$filter$iv;
            Collection destination$iv$iv2 = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                Ship it = (Ship)element$iv$iv;
                boolean bl = false;
                if (!(!fromLoadedShipIds.contains(it.getId()))) continue;
                destination$iv$iv2.add(element$iv$iv);
            }
            return SetsKt.plus(set, (Iterable)((List)destination$iv$iv2));
        }

        @JvmStatic
        @NotNull
        public final Ship getShip(@NotNull CommandContext<class_2168> context, @NotNull String argName) {
            Intrinsics.checkNotNullParameter(context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)argName, (String)"argName");
            ShipSelector selector = (ShipSelector)context.getArgument(argName, ShipSelector.class);
            Object object = context.getSource();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
            Set<Ship> loadedShips = selector.select(VSCommandsKt.getShipWorld((class_2172)object).getLoadedShips());
            if (loadedShips.size() == 1) {
                return (Ship)CollectionsKt.first((Iterable)loadedShips);
            }
            Object object2 = context.getSource();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"getSource(...)");
            Set<Ship> r = selector.select(VSCommandsKt.getShipWorld((class_2172)object2).getAllShips());
            if (r.isEmpty()) {
                throw ERROR_NO_SHIP_FOUND;
            }
            if (r.size() == 1) {
                return (Ship)CollectionsKt.first((Iterable)r);
            }
            throw ERROR_MANY_SHIP_FOUND;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

