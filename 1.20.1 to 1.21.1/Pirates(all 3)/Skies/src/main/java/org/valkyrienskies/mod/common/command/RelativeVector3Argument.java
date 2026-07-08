/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.ImmutableStringReader
 *  com.mojang.brigadier.Message
 *  com.mojang.brigadier.StringReader
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.exceptions.CommandSyntaxException
 *  com.mojang.brigadier.exceptions.SimpleCommandExceptionType
 *  com.mojang.brigadier.suggestion.Suggestions
 *  com.mojang.brigadier.suggestion.SuggestionsBuilder
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_2168
 *  net.minecraft.class_2270
 *  net.minecraft.class_2278
 *  net.minecraft.class_2561
 */
package org.valkyrienskies.mod.common.command;

import com.mojang.brigadier.ImmutableStringReader;
import com.mojang.brigadier.Message;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_2168;
import net.minecraft.class_2270;
import net.minecraft.class_2278;
import net.minecraft.class_2561;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.mod.common.command.RelativeValue;
import org.valkyrienskies.mod.common.command.RelativeVector3;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J7\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\"\u0004\b\u0000\u0010\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2={"Lorg/valkyrienskies/mod/common/command/RelativeVector3Argument;", "Lcom/mojang/brigadier/arguments/ArgumentType;", "Lorg/valkyrienskies/mod/common/command/RelativeVector3;", "Lcom/mojang/brigadier/StringReader;", "reader", "parse", "(Lcom/mojang/brigadier/StringReader;)Lorg/valkyrienskies/mod/common/command/RelativeVector3;", "S", "Lcom/mojang/brigadier/context/CommandContext;", "context", "Lcom/mojang/brigadier/suggestion/SuggestionsBuilder;", "builder", "Ljava/util/concurrent/CompletableFuture;", "Lcom/mojang/brigadier/suggestion/Suggestions;", "listSuggestions", "(Lcom/mojang/brigadier/context/CommandContext;Lcom/mojang/brigadier/suggestion/SuggestionsBuilder;)Ljava/util/concurrent/CompletableFuture;", "", "", "getExamples", "()Ljava/util/Collection;", "<init>", "()V", "Companion", "valkyrienskies-120"})
public final class RelativeVector3Argument
implements ArgumentType<RelativeVector3> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Collection<String> EXAMPLES;
    @NotNull
    private static final RelativeVector3 DUMMY_EULER_ANGLES;

    @NotNull
    public RelativeVector3 parse(@NotNull StringReader reader) {
        Intrinsics.checkNotNullParameter((Object)reader, (String)"reader");
        return new Companion.RelativeVector3ArgumentParser().parse(reader, false);
    }

    @Nullable
    public <S> CompletableFuture<Suggestions> listSuggestions(@Nullable CommandContext<S> context, @NotNull SuggestionsBuilder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        StringReader reader = new StringReader(builder.getInput());
        reader.setCursor(builder.getStart());
        Companion.RelativeVector3ArgumentParser parser = new Companion.RelativeVector3ArgumentParser();
        try {
            parser.parse(reader, true);
        }
        catch (CommandSyntaxException commandSyntaxException) {
            // empty catch block
        }
        reader.setCursor(builder.getStart());
        SuggestionsBuilder nBuilder = builder.createOffset(reader.getCursor());
        Function1<SuggestionsBuilder, Unit> function1 = parser.getSuggestionProvider();
        Intrinsics.checkNotNull((Object)nBuilder);
        function1.invoke((Object)nBuilder);
        return nBuilder.buildFuture();
    }

    @NotNull
    public Collection<String> getExamples() {
        return EXAMPLES;
    }

    @JvmStatic
    @NotNull
    public static final RelativeVector3Argument relativeVector3() {
        return Companion.relativeVector3();
    }

    @JvmStatic
    @NotNull
    public static final RelativeVector3 getRelativeVector3(@NotNull CommandContext<class_2168> commandContext, @Nullable String string) {
        return Companion.getRelativeVector3(commandContext, string);
    }

    static {
        Object[] objectArray = new String[]{"(0 0 0)", "(~ ~ ~)", "(~0.5 ~1 ~-5)"};
        EXAMPLES = CollectionsKt.listOf((Object[])objectArray);
        DUMMY_EULER_ANGLES = new RelativeVector3(new RelativeValue(0.0, false), new RelativeValue(0.0, false), new RelativeValue(0.0, false));
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J)\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2={"Lorg/valkyrienskies/mod/common/command/RelativeVector3Argument$Companion;", "", "Lorg/valkyrienskies/mod/common/command/RelativeVector3Argument;", "relativeVector3", "()Lorg/valkyrienskies/mod/common/command/RelativeVector3Argument;", "Lcom/mojang/brigadier/context/CommandContext;", "Lnet/minecraft/class_2168;", "commandContext", "", "string", "Lorg/valkyrienskies/mod/common/command/RelativeVector3;", "getRelativeVector3", "(Lcom/mojang/brigadier/context/CommandContext;Ljava/lang/String;)Lorg/valkyrienskies/mod/common/command/RelativeVector3;", "", "EXAMPLES", "Ljava/util/Collection;", "DUMMY_EULER_ANGLES", "Lorg/valkyrienskies/mod/common/command/RelativeVector3;", "<init>", "()V", "RelativeVector3ArgumentParser", "valkyrienskies-120"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final RelativeVector3Argument relativeVector3() {
            return new RelativeVector3Argument();
        }

        @JvmStatic
        @NotNull
        public final RelativeVector3 getRelativeVector3(@NotNull CommandContext<class_2168> commandContext, @Nullable String string) {
            Intrinsics.checkNotNullParameter(commandContext, (String)"commandContext");
            Object object = commandContext.getArgument(string, RelativeVector3.class);
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type org.valkyrienskies.mod.common.command.RelativeVector3");
            return (RelativeVector3)object;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR.\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u000e\u00a8\u0006\u0016"}, d2={"Lorg/valkyrienskies/mod/common/command/RelativeVector3Argument$Companion$RelativeVector3ArgumentParser;", "", "Lcom/mojang/brigadier/StringReader;", "reader", "", "invokedByListSuggestions", "Lorg/valkyrienskies/mod/common/command/RelativeVector3;", "parse", "(Lcom/mojang/brigadier/StringReader;Z)Lorg/valkyrienskies/mod/common/command/RelativeVector3;", "Lkotlin/Function1;", "Lcom/mojang/brigadier/suggestion/SuggestionsBuilder;", "", "builder", "suggest", "(Lkotlin/jvm/functions/Function1;)V", "suggestionProvider", "Lkotlin/jvm/functions/Function1;", "getSuggestionProvider", "()Lkotlin/jvm/functions/Function1;", "setSuggestionProvider", "<init>", "()V", "valkyrienskies-120"})
        @SourceDebugExtension(value={"SMAP\nRelativeVector3Argument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RelativeVector3Argument.kt\norg/valkyrienskies/mod/common/command/RelativeVector3Argument$Companion$RelativeVector3ArgumentParser\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,227:1\n1#2:228\n*E\n"})
        private static final class RelativeVector3ArgumentParser {
            @NotNull
            private Function1<? super SuggestionsBuilder, Unit> suggestionProvider = RelativeVector3ArgumentParser::suggestionProvider$lambda$0;

            @NotNull
            public final Function1<SuggestionsBuilder, Unit> getSuggestionProvider() {
                return this.suggestionProvider;
            }

            public final void setSuggestionProvider(@NotNull Function1<? super SuggestionsBuilder, Unit> function1) {
                Intrinsics.checkNotNullParameter(function1, (String)"<set-?>");
                this.suggestionProvider = function1;
            }

            @NotNull
            public final RelativeVector3 parse(@NotNull StringReader reader, boolean invokedByListSuggestions) {
                Intrinsics.checkNotNullParameter((Object)reader, (String)"reader");
                int i2 = reader.getCursor();
                this.suggest((Function1<? super SuggestionsBuilder, Unit>)((Function1)RelativeVector3ArgumentParser::parse$lambda$1));
                if (!reader.canRead()) {
                    throw class_2270.field_10736.createWithContext((ImmutableStringReader)reader);
                }
                if (!reader.canRead()) {
                    if (invokedByListSuggestions) {
                        this.suggest((Function1<? super SuggestionsBuilder, Unit>)((Function1)RelativeVector3ArgumentParser::parse$lambda$2));
                    } else {
                        throw new SimpleCommandExceptionType((Message)class_2561.method_43471((String)"command.valkyrienskies.vector_arg.fail")).createWithContext((ImmutableStringReader)reader);
                    }
                }
                if (reader.canRead() && reader.peek() == '(') {
                    reader.skip();
                    if (!reader.canRead()) {
                        if (invokedByListSuggestions) {
                            this.suggest((Function1<? super SuggestionsBuilder, Unit>)((Function1)RelativeVector3ArgumentParser::parse$lambda$3));
                        } else {
                            throw new SimpleCommandExceptionType((Message)class_2561.method_43471((String)"command.valkyrienskies.vector_arg.fail")).createWithContext((ImmutableStringReader)reader);
                        }
                    }
                    class_2278 worldCoordinate = class_2278.method_9743((StringReader)reader, (boolean)false);
                    if (!reader.canRead()) {
                        if (invokedByListSuggestions) {
                            this.suggest((Function1<? super SuggestionsBuilder, Unit>)((Function1)RelativeVector3ArgumentParser::parse$lambda$4));
                        } else {
                            throw new SimpleCommandExceptionType((Message)class_2561.method_43471((String)"command.valkyrienskies.vector_arg.fail")).createWithContext((ImmutableStringReader)reader);
                        }
                    }
                    if (reader.canRead() && reader.peek() == ' ') {
                        reader.skip();
                        if (!reader.canRead()) {
                            if (invokedByListSuggestions) {
                                this.suggest((Function1<? super SuggestionsBuilder, Unit>)((Function1)RelativeVector3ArgumentParser::parse$lambda$5));
                            } else {
                                throw new SimpleCommandExceptionType((Message)class_2561.method_43471((String)"command.valkyrienskies.vector_arg.fail")).createWithContext((ImmutableStringReader)reader);
                            }
                        }
                        class_2278 worldCoordinate2 = class_2278.method_9743((StringReader)reader, (boolean)false);
                        if (!reader.canRead()) {
                            if (invokedByListSuggestions) {
                                this.suggest((Function1<? super SuggestionsBuilder, Unit>)((Function1)RelativeVector3ArgumentParser::parse$lambda$6));
                            } else {
                                throw new SimpleCommandExceptionType((Message)class_2561.method_43471((String)"command.valkyrienskies.vector_arg.fail")).createWithContext((ImmutableStringReader)reader);
                            }
                        }
                        if (reader.canRead() && reader.peek() == ' ') {
                            class_2278 worldCoordinate3;
                            reader.skip();
                            if (!reader.canRead()) {
                                if (invokedByListSuggestions) {
                                    this.suggest((Function1<? super SuggestionsBuilder, Unit>)((Function1)RelativeVector3ArgumentParser::parse$lambda$7));
                                } else {
                                    throw new SimpleCommandExceptionType((Message)class_2561.method_43471((String)"command.valkyrienskies.vector_arg.fail")).createWithContext((ImmutableStringReader)reader);
                                }
                            }
                            if (reader.getRemainingLength() > 1 && reader.peek(1) == ')') {
                                class_2278 class_22782;
                                String string = reader.getString();
                                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getString(...)");
                                String string2 = string;
                                int n2 = 0;
                                int n3 = reader.getCursor() + 1;
                                String string3 = string2.substring(n2, n3);
                                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"substring(...)");
                                String $this$parse_u24lambda_u248 = string2 = new StringReader(string3);
                                boolean bl = false;
                                $this$parse_u24lambda_u248.setCursor(reader.getCursor());
                                String it = string2;
                                boolean bl2 = false;
                                class_2278 it2 = class_22782 = class_2278.method_9743((StringReader)it, (boolean)false);
                                boolean bl3 = false;
                                reader.read();
                                v2 = class_22782;
                            } else {
                                v2 = worldCoordinate3 = class_2278.method_9743((StringReader)reader, (boolean)false);
                            }
                            if (reader.canRead()) {
                                if (reader.peek() == ')') {
                                    reader.skip();
                                    RelativeValue pitchEulerAngle = new RelativeValue(worldCoordinate.method_9740(0.0), worldCoordinate.method_9741());
                                    RelativeValue yawEulerAngle = new RelativeValue(worldCoordinate2.method_9740(0.0), worldCoordinate2.method_9741());
                                    RelativeValue rollEulerAngle = new RelativeValue(worldCoordinate3.method_9740(0.0), worldCoordinate3.method_9741());
                                    this.suggest((Function1<? super SuggestionsBuilder, Unit>)((Function1)RelativeVector3ArgumentParser::parse$lambda$11));
                                    return new RelativeVector3(pitchEulerAngle, yawEulerAngle, rollEulerAngle);
                                }
                            } else if (invokedByListSuggestions) {
                                this.suggest((Function1<? super SuggestionsBuilder, Unit>)((Function1)RelativeVector3ArgumentParser::parse$lambda$12));
                            } else {
                                throw new SimpleCommandExceptionType((Message)class_2561.method_43471((String)"command.valkyrienskies.vector_arg.fail")).createWithContext((ImmutableStringReader)reader);
                            }
                        }
                    }
                    if (!reader.canRead()) {
                        reader.setCursor(i2);
                        throw class_2270.field_10736.createWithContext((ImmutableStringReader)reader);
                    }
                }
                reader.setCursor(i2);
                throw class_2270.field_10736.createWithContext((ImmutableStringReader)reader);
            }

            private final void suggest(Function1<? super SuggestionsBuilder, Unit> builder) {
                this.suggestionProvider = arg_0 -> RelativeVector3ArgumentParser.suggest$lambda$13(builder, arg_0);
            }

            private static final Unit suggestionProvider$lambda$0(SuggestionsBuilder it) {
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                return Unit.INSTANCE;
            }

            private static final Unit parse$lambda$1(SuggestionsBuilder builder) {
                Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
                builder.suggest("(0 0 0)");
                return Unit.INSTANCE;
            }

            private static final Unit parse$lambda$2(SuggestionsBuilder builder) {
                Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
                builder.suggest("(0 0 0)");
                return Unit.INSTANCE;
            }

            private static final Unit parse$lambda$3(SuggestionsBuilder builder) {
                Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
                builder.suggest(builder.getRemaining() + "0 0 0)");
                return Unit.INSTANCE;
            }

            private static final Unit parse$lambda$4(SuggestionsBuilder builder) {
                Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
                builder.suggest(builder.getRemaining() + " 0 0)");
                return Unit.INSTANCE;
            }

            private static final Unit parse$lambda$5(SuggestionsBuilder builder) {
                Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
                builder.suggest(builder.getRemaining() + "0 0)");
                return Unit.INSTANCE;
            }

            private static final Unit parse$lambda$6(SuggestionsBuilder builder) {
                Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
                builder.suggest(builder.getRemaining() + " 0)");
                return Unit.INSTANCE;
            }

            private static final Unit parse$lambda$7(SuggestionsBuilder builder) {
                Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
                builder.suggest(builder.getRemaining() + "0)");
                return Unit.INSTANCE;
            }

            private static final Unit parse$lambda$11(SuggestionsBuilder builder) {
                Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
                builder.suggest(builder.getRemaining());
                return Unit.INSTANCE;
            }

            private static final Unit parse$lambda$12(SuggestionsBuilder builder) {
                Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
                builder.suggest(builder.getRemaining() + ")");
                return Unit.INSTANCE;
            }

            private static final Unit suggest$lambda$13(Function1 $builder, SuggestionsBuilder it) {
                Intrinsics.checkNotNullParameter((Object)$builder, (String)"$builder");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                $builder.invoke((Object)it);
                return Unit.INSTANCE;
            }
        }
    }
}

