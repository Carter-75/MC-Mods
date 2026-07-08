/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.ImmutableStringReader
 *  com.mojang.brigadier.Message
 *  com.mojang.brigadier.StringReader
 *  com.mojang.brigadier.exceptions.DynamicCommandExceptionType
 *  com.mojang.brigadier.exceptions.SimpleCommandExceptionType
 *  com.mojang.brigadier.suggestion.SuggestionsBuilder
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.class_2172
 *  net.minecraft.class_2561
 */
package org.valkyrienskies.mod.common.command;

import com.mojang.brigadier.ImmutableStringReader;
import com.mojang.brigadier.Message;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.class_2172;
import net.minecraft.class_2561;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.command.ShipSelector;
import org.valkyrienskies.mod.common.command.VSCommandsKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\u00020\u0001:\u0001DB\u0019\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\bB\u0010CJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0012J\u000f\u0010\u0019\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0019\u0010\u0012J)\u0010\u001e\u001a\u00020\u000e2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000e0\u001aH\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\n\u001a\u00020 H\u0002\u00a2\u0006\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R.\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e0'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u0010\u0010R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010<\u001a\n\u0018\u00010:j\u0004\u0018\u0001`;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A\u00a8\u0006E"}, d2={"Lorg/valkyrienskies/mod/common/command/ShipArgumentParser;", "", "Lcom/mojang/brigadier/StringReader;", "reader", "", "isForSuggestion", "Lorg/valkyrienskies/mod/common/command/ShipSelector;", "parse", "(Lcom/mojang/brigadier/StringReader;Z)Lorg/valkyrienskies/mod/common/command/ShipSelector;", "", "s", "isOption", "(Ljava/lang/String;)Z", "textSoFar", "", "suggestOptions", "(Ljava/lang/String;)V", "suggestSelectorOrSlug", "()V", "option", "suggestionsOfOption", "parseOption", "(Ljava/lang/String;Lcom/mojang/brigadier/StringReader;)V", "suggestEquals", "suggestOpenOptions", "suggestOptionsNextOrClose", "Lkotlin/Function2;", "Lcom/mojang/brigadier/suggestion/SuggestionsBuilder;", "Lnet/minecraft/class_2172;", "builder", "suggest", "(Lkotlin/jvm/functions/Function2;)V", "", "expectR", "(Lcom/mojang/brigadier/StringReader;C)V", "source", "Lnet/minecraft/class_2172;", "selectorOnly", "Z", "Lkotlin/Function1;", "suggestionProvider", "Lkotlin/jvm/functions/Function1;", "getSuggestionProvider", "()Lkotlin/jvm/functions/Function1;", "setSuggestionProvider", "(Lkotlin/jvm/functions/Function1;)V", "slug", "Ljava/lang/String;", "getSlug", "()Ljava/lang/String;", "setSlug", "", "limit", "Ljava/lang/Integer;", "getLimit", "()Ljava/lang/Integer;", "setLimit", "(Ljava/lang/Integer;)V", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "id", "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "<init>", "(Lnet/minecraft/class_2172;Z)V", "Companion", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nShipArgumentParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShipArgumentParser.kt\norg/valkyrienskies/mod/common/command/ShipArgumentParser\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,205:1\n1755#2,3:206\n1611#2,9:209\n1863#2:218\n1864#2:220\n1620#2:221\n774#2:222\n865#2,2:223\n1863#2,2:225\n1611#2,9:227\n1863#2:236\n1864#2:238\n1620#2:239\n774#2:240\n865#2,2:241\n1863#2,2:243\n1557#2:245\n1628#2,3:246\n774#2:249\n865#2,2:250\n1863#2,2:252\n1#3:219\n1#3:237\n*S KotlinDebug\n*F\n+ 1 ShipArgumentParser.kt\norg/valkyrienskies/mod/common/command/ShipArgumentParser\n*L\n158#1:206,3\n128#1:209,9\n128#1:218\n128#1:220\n128#1:221\n129#1:222\n129#1:223,2\n130#1:225,2\n138#1:227,9\n138#1:236\n138#1:238\n138#1:239\n139#1:240\n139#1:241,2\n140#1:243,2\n146#1:245\n146#1:246,3\n147#1:249\n147#1:250,2\n148#1:252,2\n128#1:219\n138#1:237\n*E\n"})
public final class ShipArgumentParser {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final class_2172 source;
    private boolean selectorOnly;
    @NotNull
    private Function1<? super SuggestionsBuilder, Unit> suggestionProvider;
    @Nullable
    private String slug;
    @Nullable
    private Integer limit;
    @Nullable
    private Long id;
    @NotNull
    private static final SimpleCommandExceptionType ERROR_MISSING_SELECTOR_TYPE = new SimpleCommandExceptionType((Message)class_2561.method_43471((String)"argument.ship.selector.missing"));
    @NotNull
    private static final SimpleCommandExceptionType ERROR_INVALID_SLUG_OR_ID = new SimpleCommandExceptionType((Message)class_2561.method_43471((String)"argument.ship.invalid"));
    @NotNull
    private static final SimpleCommandExceptionType ERROR_EXPECTED_END_OF_OPTIONS = new SimpleCommandExceptionType((Message)class_2561.method_43471((String)"argument.ship.options.unterminated"));
    @NotNull
    private static final DynamicCommandExceptionType ERROR_EXPECTED_OPTION_VALUE = new DynamicCommandExceptionType(ShipArgumentParser::ERROR_EXPECTED_OPTION_VALUE$lambda$22);
    @NotNull
    private static final DynamicCommandExceptionType ERROR_UNKNOWN_OPTION = new DynamicCommandExceptionType(ShipArgumentParser::ERROR_UNKNOWN_OPTION$lambda$23);

    public ShipArgumentParser(@Nullable class_2172 source, boolean selectorOnly) {
        this.source = source;
        this.selectorOnly = selectorOnly;
        this.suggestionProvider = ShipArgumentParser::suggestionProvider$lambda$0;
    }

    @NotNull
    public final Function1<SuggestionsBuilder, Unit> getSuggestionProvider() {
        return this.suggestionProvider;
    }

    public final void setSuggestionProvider(@NotNull Function1<? super SuggestionsBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"<set-?>");
        this.suggestionProvider = function1;
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
    }

    public final void setSlug(@Nullable String string) {
        this.slug = string;
    }

    @Nullable
    public final Integer getLimit() {
        return this.limit;
    }

    public final void setLimit(@Nullable Integer n2) {
        this.limit = n2;
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    public final void setId(@Nullable Long l2) {
        this.id = l2;
    }

    @NotNull
    public final ShipSelector parse(@NotNull StringReader reader, boolean isForSuggestion) {
        Intrinsics.checkNotNullParameter((Object)reader, (String)"reader");
        int start = reader.getCursor();
        this.suggestSelectorOrSlug();
        if (!reader.canRead()) {
            throw ERROR_MISSING_SELECTOR_TYPE.createWithContext((ImmutableStringReader)reader);
        }
        if (reader.read() == '@') {
            if (!reader.canRead()) {
                this.suggest((Function2<? super SuggestionsBuilder, ? super class_2172, Unit>)((Function2)ShipArgumentParser::parse$lambda$1));
            } else {
                reader.read();
                if (!reader.canRead()) {
                    this.suggestOpenOptions();
                } else if (reader.read() == '[') {
                    if (!reader.canRead()) {
                        ShipArgumentParser.suggestOptions$default(this, null, 1, null);
                    } else {
                        while (reader.canRead() && reader.peek() != ']') {
                            int i2 = reader.getCursor();
                            String s = reader.readString();
                            this.suggestOptions(s);
                            reader.skipWhitespace();
                            Intrinsics.checkNotNull((Object)s);
                            if (!this.isOption(s)) {
                                if (isForSuggestion) {
                                    reader.setCursor(i2);
                                    throw ERROR_UNKNOWN_OPTION.createWithContext((ImmutableStringReader)reader, (Object)s);
                                }
                                return new ShipSelector(null, null, 0);
                            }
                            reader.skipWhitespace();
                            this.suggestEquals();
                            if (!reader.canRead() || reader.peek() != '=') {
                                throw ERROR_EXPECTED_OPTION_VALUE.createWithContext((ImmutableStringReader)reader, (Object)s);
                            }
                            reader.skip();
                            reader.skipWhitespace();
                            this.suggestionsOfOption(s);
                            reader.skipWhitespace();
                            if (!reader.canRead()) {
                                throw ERROR_EXPECTED_OPTION_VALUE.createWithContext((ImmutableStringReader)reader, (Object)s);
                            }
                            this.parseOption(s, reader);
                            reader.skipWhitespace();
                            this.suggestOptionsNextOrClose();
                            reader.skipWhitespace();
                        }
                    }
                    if (!reader.canRead() || reader.read() != ']') {
                        if (isForSuggestion) {
                            throw ERROR_EXPECTED_END_OF_OPTIONS.createWithContext((ImmutableStringReader)reader);
                        }
                        return new ShipSelector(null, null, 0);
                    }
                    this.suggest((Function2<? super SuggestionsBuilder, ? super class_2172, Unit>)((Function2)ShipArgumentParser::parse$lambda$2));
                }
            }
        } else if (!this.selectorOnly) {
            this.suggestionsOfOption("slug");
            reader.setCursor(start);
            this.slug = reader.readUnquotedString();
        }
        Integer n2 = this.limit;
        return new ShipSelector(this.slug, this.id, n2 != null ? n2 : Integer.MAX_VALUE);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isOption(String s) {
        String string = s;
        switch (string.hashCode()) {
            case 102976443: {
                if (string.equals("limit")) return true;
                return false;
            }
            case 3355: {
                if (string.equals("id")) return true;
                return false;
            }
            case 3533483: {
                if (!string.equals("slug")) return false;
                return true;
            }
        }
        return false;
    }

    private final void suggestOptions(String textSoFar) {
        this.suggest((Function2<? super SuggestionsBuilder, ? super class_2172, Unit>)((Function2)(arg_0, arg_1) -> ShipArgumentParser.suggestOptions$lambda$3(textSoFar, arg_0, arg_1)));
    }

    static /* synthetic */ void suggestOptions$default(ShipArgumentParser shipArgumentParser, String string, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = null;
        }
        shipArgumentParser.suggestOptions(string);
    }

    private final void suggestSelectorOrSlug() {
        this.suggest((Function2<? super SuggestionsBuilder, ? super class_2172, Unit>)((Function2)(arg_0, arg_1) -> ShipArgumentParser.suggestSelectorOrSlug$lambda$7(this, arg_0, arg_1)));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void suggestionsOfOption(@NotNull String option) {
        Intrinsics.checkNotNullParameter((Object)option, (String)"option");
        String string = option;
        switch (string.hashCode()) {
            case 102976443: {
                if (string.equals("limit")) return;
                throw ERROR_UNKNOWN_OPTION.create((Object)option);
            }
            case 3355: {
                if (string.equals("id")) break;
                throw ERROR_UNKNOWN_OPTION.create((Object)option);
            }
            case 3533483: {
                if (!string.equals("slug")) throw ERROR_UNKNOWN_OPTION.create((Object)option);
                this.suggest((Function2<? super SuggestionsBuilder, ? super class_2172, Unit>)((Function2)ShipArgumentParser::suggestionsOfOption$lambda$11));
                return;
            }
        }
        this.suggest((Function2<? super SuggestionsBuilder, ? super class_2172, Unit>)((Function2)ShipArgumentParser::suggestionsOfOption$lambda$15));
        return;
        throw ERROR_UNKNOWN_OPTION.create((Object)option);
    }

    /*
     * Unable to fully structure code
     */
    public final void parseOption(@NotNull String option, @NotNull StringReader reader) {
        block9: {
            block8: {
                Intrinsics.checkNotNullParameter((Object)option, (String)"option");
                Intrinsics.checkNotNullParameter((Object)reader, (String)"reader");
                var3_3 = option;
                switch (var3_3.hashCode()) {
                    case 102976443: {
                        if (!var3_3.equals("limit")) {
                            ** break;
                        }
                        break block8;
                    }
                    case 3355: {
                        if (var3_3.equals("id")) break;
                        ** break;
                    }
                    case 3533483: {
                        if (!var3_3.equals("slug")) ** break;
                        start = reader.getCursor();
                        slug = reader.readUnquotedString();
                        v0 = this.source;
                        if (v0 == null || (v0 = VSCommandsKt.getShipWorld((class_2172)v0)) == null || (v0 = v0.getAllShips()) == null) ** GOTO lbl32
                        $this$any$iv = (Iterable)v0;
                        $i$f$any = false;
                        if (!($this$any$iv instanceof Collection) || !((Collection)$this$any$iv).isEmpty()) ** GOTO lbl23
                        v1 = false;
                        ** GOTO lbl30
lbl23:
                        // 2 sources

                        for (T element$iv : $this$any$iv) {
                            it = (Ship)element$iv;
                            $i$a$-any-ShipArgumentParser$parseOption$1 = false;
                            if (!Intrinsics.areEqual((Object)it.getSlug(), (Object)slug)) continue;
                            v1 = true;
                            ** GOTO lbl30
                        }
                        v1 = false;
lbl30:
                        // 3 sources

                        v2 = !v1;
                        ** GOTO lbl33
lbl32:
                        // 1 sources

                        v2 = false;
lbl33:
                        // 2 sources

                        if (v2) {
                            reader.setCursor(start);
                            throw ShipArgumentParser.ERROR_INVALID_SLUG_OR_ID.create();
                        }
                        this.slug = slug;
                        break block9;
                    }
                }
                this.id = reader.readLong();
                break block9;
            }
            this.limit = reader.readInt();
            break block9;
lbl43:
            // 4 sources

            throw ShipArgumentParser.ERROR_UNKNOWN_OPTION.create((Object)option);
        }
    }

    private final void suggestEquals() {
        this.suggest((Function2<? super SuggestionsBuilder, ? super class_2172, Unit>)((Function2)ShipArgumentParser::suggestEquals$lambda$17));
    }

    private final void suggestOpenOptions() {
        this.suggest((Function2<? super SuggestionsBuilder, ? super class_2172, Unit>)((Function2)ShipArgumentParser::suggestOpenOptions$lambda$18));
    }

    private final void suggestOptionsNextOrClose() {
        this.suggest((Function2<? super SuggestionsBuilder, ? super class_2172, Unit>)((Function2)ShipArgumentParser::suggestOptionsNextOrClose$lambda$19));
    }

    private final void suggest(Function2<? super SuggestionsBuilder, ? super class_2172, Unit> builder) {
        if (this.source != null) {
            this.suggestionProvider = arg_0 -> ShipArgumentParser.suggest$lambda$20(builder, this, arg_0);
        }
    }

    private final void expectR(StringReader $this$expectR, char s) {
        this.suggest((Function2<? super SuggestionsBuilder, ? super class_2172, Unit>)((Function2)(arg_0, arg_1) -> ShipArgumentParser.expectR$lambda$21(s, arg_0, arg_1)));
        $this$expectR.expect(s);
    }

    private static final Unit suggestionProvider$lambda$0(SuggestionsBuilder it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Unit.INSTANCE;
    }

    private static final Unit parse$lambda$1(SuggestionsBuilder builder, class_2172 class_21722) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Intrinsics.checkNotNullParameter((Object)class_21722, (String)"<unused var>");
        builder.suggest("v");
        return Unit.INSTANCE;
    }

    private static final Unit parse$lambda$2(SuggestionsBuilder suggestionsBuilder, class_2172 class_21722) {
        Intrinsics.checkNotNullParameter((Object)suggestionsBuilder, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)class_21722, (String)"<unused var>");
        return Unit.INSTANCE;
    }

    private static final Unit suggestOptions$lambda$3(String $textSoFar, SuggestionsBuilder builder, class_2172 source) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if ($textSoFar == null) {
            builder.suggest("slug=");
            builder.suggest("limit=");
            builder.suggest("id=");
        } else {
            if (StringsKt.startsWith$default((String)"slug=", (String)$textSoFar, (boolean)false, (int)2, null)) {
                builder.suggest("slug=");
            }
            if (StringsKt.startsWith$default((String)"limit=", (String)$textSoFar, (boolean)false, (int)2, null)) {
                builder.suggest("limit=");
            }
            if (StringsKt.startsWith$default((String)"id=", (String)$textSoFar, (boolean)false, (int)2, null)) {
                builder.suggest("id=");
            }
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit suggestSelectorOrSlug$lambda$7(ShipArgumentParser this$0, SuggestionsBuilder builder, class_2172 source) {
        Intrinsics.checkNotNullParameter((Object)this$0, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        builder.suggest("@v");
        if (!this$0.selectorOnly) {
            void $this$filterTo$iv$iv;
            Iterable $this$mapNotNullTo$iv$iv;
            Iterable $this$mapNotNull$iv = VSCommandsKt.getShipWorld(source).getAllShips();
            boolean $i$f$mapNotNull = false;
            Iterable iterable = $this$mapNotNull$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            Iterator $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                String it$iv$iv;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                boolean bl = false;
                Ship it = (Ship)element$iv$iv;
                boolean bl2 = false;
                if (it.getSlug() == null) continue;
                boolean bl3 = false;
                destination$iv$iv.add(it$iv$iv);
            }
            Iterable $this$filter$iv = (List)destination$iv$iv;
            boolean $i$f$filter = false;
            $this$mapNotNullTo$iv$iv = $this$filter$iv;
            destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                String it = (String)element$iv$iv;
                boolean bl = false;
                String string = builder.getRemaining();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getRemaining(...)");
                if (!StringsKt.startsWith$default((String)it, (String)string, (boolean)false, (int)2, null)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $this$forEach$iv = (List)destination$iv$iv;
            boolean $i$f$forEach2 = false;
            for (Object element$iv : $this$forEach$iv) {
                String it = (String)element$iv;
                boolean bl = false;
                builder.suggest(it);
            }
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit suggestionsOfOption$lambda$11(SuggestionsBuilder builder, class_2172 source) {
        void $this$filterTo$iv$iv;
        Iterable $this$mapNotNullTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Iterable $this$mapNotNull$iv = VSCommandsKt.getShipWorld(source).getAllShips();
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        Iterator $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            String it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl = false;
            Ship it = (Ship)element$iv$iv;
            boolean bl2 = false;
            if (it.getSlug() == null) continue;
            boolean bl3 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        Iterable $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$filter = false;
        $this$mapNotNullTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            String it = (String)element$iv$iv;
            boolean bl = false;
            String string = builder.getRemaining();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getRemaining(...)");
            if (!StringsKt.startsWith$default((String)it, (String)string, (boolean)false, (int)2, null)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach2 = false;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String)element$iv;
            boolean bl = false;
            builder.suggest(it);
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit suggestionsOfOption$lambda$15(SuggestionsBuilder builder, class_2172 source) {
        void $this$filterTo$iv$iv;
        String it;
        Iterable $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Iterable $this$map$iv = VSCommandsKt.getShipWorld(source).getAllShips();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Ship ship = (Ship)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(String.valueOf(it.getId()));
        }
        Iterable $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$filter = false;
        $this$mapTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (String)element$iv$iv;
            boolean bl = false;
            String string = builder.getRemaining();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getRemaining(...)");
            if (!StringsKt.startsWith$default((String)it, (String)string, (boolean)false, (int)2, null)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            String it2 = (String)element$iv;
            boolean bl = false;
            builder.suggest(it2);
        }
        return Unit.INSTANCE;
    }

    private static final Unit suggestEquals$lambda$17(SuggestionsBuilder builder, class_2172 class_21722) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Intrinsics.checkNotNullParameter((Object)class_21722, (String)"<unused var>");
        builder.suggest("=");
        return Unit.INSTANCE;
    }

    private static final Unit suggestOpenOptions$lambda$18(SuggestionsBuilder builder, class_2172 class_21722) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Intrinsics.checkNotNullParameter((Object)class_21722, (String)"<unused var>");
        builder.suggest("[");
        return Unit.INSTANCE;
    }

    private static final Unit suggestOptionsNextOrClose$lambda$19(SuggestionsBuilder builder, class_2172 class_21722) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Intrinsics.checkNotNullParameter((Object)class_21722, (String)"<unused var>");
        builder.suggest(",");
        builder.suggest("]");
        return Unit.INSTANCE;
    }

    private static final Unit suggest$lambda$20(Function2 $builder, ShipArgumentParser this$0, SuggestionsBuilder it) {
        Intrinsics.checkNotNullParameter((Object)$builder, (String)"$builder");
        Intrinsics.checkNotNullParameter((Object)this$0, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $builder.invoke((Object)it, (Object)this$0.source);
        return Unit.INSTANCE;
    }

    private static final Unit expectR$lambda$21(char $s, SuggestionsBuilder builder, class_2172 source) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        builder.suggest(String.valueOf($s));
        return Unit.INSTANCE;
    }

    private static final Message ERROR_EXPECTED_OPTION_VALUE$lambda$22(Object it) {
        Object[] objectArray = new Object[]{it};
        return (Message)class_2561.method_43469((String)"argument.ship.options.valueless", (Object[])objectArray);
    }

    private static final Message ERROR_UNKNOWN_OPTION$lambda$23(Object it) {
        Object[] objectArray = new Object[]{it};
        return (Message)class_2561.method_43469((String)"argument.entity.options.unknown", (Object[])objectArray);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0014"}, d2={"Lorg/valkyrienskies/mod/common/command/ShipArgumentParser$Companion;", "", "Lcom/mojang/brigadier/exceptions/SimpleCommandExceptionType;", "ERROR_MISSING_SELECTOR_TYPE", "Lcom/mojang/brigadier/exceptions/SimpleCommandExceptionType;", "getERROR_MISSING_SELECTOR_TYPE", "()Lcom/mojang/brigadier/exceptions/SimpleCommandExceptionType;", "ERROR_INVALID_SLUG_OR_ID", "getERROR_INVALID_SLUG_OR_ID", "ERROR_EXPECTED_END_OF_OPTIONS", "getERROR_EXPECTED_END_OF_OPTIONS", "Lcom/mojang/brigadier/exceptions/DynamicCommandExceptionType;", "ERROR_EXPECTED_OPTION_VALUE", "Lcom/mojang/brigadier/exceptions/DynamicCommandExceptionType;", "getERROR_EXPECTED_OPTION_VALUE", "()Lcom/mojang/brigadier/exceptions/DynamicCommandExceptionType;", "ERROR_UNKNOWN_OPTION", "getERROR_UNKNOWN_OPTION", "<init>", "()V", "valkyrienskies-120"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SimpleCommandExceptionType getERROR_MISSING_SELECTOR_TYPE() {
            return ERROR_MISSING_SELECTOR_TYPE;
        }

        @NotNull
        public final SimpleCommandExceptionType getERROR_INVALID_SLUG_OR_ID() {
            return ERROR_INVALID_SLUG_OR_ID;
        }

        @NotNull
        public final SimpleCommandExceptionType getERROR_EXPECTED_END_OF_OPTIONS() {
            return ERROR_EXPECTED_END_OF_OPTIONS;
        }

        @NotNull
        public final DynamicCommandExceptionType getERROR_EXPECTED_OPTION_VALUE() {
            return ERROR_EXPECTED_OPTION_VALUE;
        }

        @NotNull
        public final DynamicCommandExceptionType getERROR_UNKNOWN_OPTION() {
            return ERROR_UNKNOWN_OPTION;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

