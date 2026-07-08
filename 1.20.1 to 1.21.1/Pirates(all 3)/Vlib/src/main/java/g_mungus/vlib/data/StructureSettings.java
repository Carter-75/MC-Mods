/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonAlias
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.annotation.JsonDeserialize
 *  com.fasterxml.jackson.databind.exc.MismatchedInputException
 *  com.fasterxml.jackson.module.kotlin.ExtensionsKt
 *  kotlin.Metadata
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package g_mungus.vlib.data;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import g_mungus.vlib.data.FolderListDeserializer;
import java.io.Closeable;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(BA\u0012\u000e\b\u0001\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b&\u0010'J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJN\u0010\u0014\u001a\u00020\u00002\u000e\b\u0003\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0013\u001a\u00020\u0006H\u00c6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\nH\u00d6\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b!\u0010\bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\u000e\u00a8\u0006)"}, d2={"Lg_mungus/vlib/data/StructureSettings;", "", "", "", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/Boolean;", "component3", "", "component4", "()Ljava/lang/Integer;", "component5", "()Z", "folders", "rename", "static", "randomYRange", "randomRotation", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Z)Lg_mungus/vlib/data/StructureSettings;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getFolders", "Ljava/lang/Boolean;", "getRename", "getStatic", "Ljava/lang/Integer;", "getRandomYRange", "Z", "getRandomRotation", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Z)V", "Companion", "vlib"})
public final class StructureSettings {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<String> folders;
    @Nullable
    private final Boolean rename;
    @Nullable
    private final Boolean static;
    @Nullable
    private final Integer randomYRange;
    private final boolean randomRotation;

    public StructureSettings(@JsonAlias(value={"folder"}) @JsonDeserialize(using=FolderListDeserializer.class) @NotNull List<String> folders, @Nullable Boolean rename, @Nullable Boolean bl, @Nullable Integer randomYRange, boolean randomRotation) {
        Intrinsics.checkNotNullParameter(folders, (String)"folders");
        this.folders = folders;
        this.rename = rename;
        this.static = bl;
        this.randomYRange = randomYRange;
        this.randomRotation = randomRotation;
    }

    public /* synthetic */ StructureSettings(List list, Boolean bl, Boolean bl2, Integer n, boolean bl3, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            n = null;
        }
        if ((n2 & 0x10) != 0) {
            bl3 = false;
        }
        this(list, bl, bl2, n, bl3);
    }

    @NotNull
    public final List<String> getFolders() {
        return this.folders;
    }

    @Nullable
    public final Boolean getRename() {
        return this.rename;
    }

    @Nullable
    public final Boolean getStatic() {
        return this.static;
    }

    @Nullable
    public final Integer getRandomYRange() {
        return this.randomYRange;
    }

    public final boolean getRandomRotation() {
        return this.randomRotation;
    }

    @NotNull
    public final List<String> component1() {
        return this.folders;
    }

    @Nullable
    public final Boolean component2() {
        return this.rename;
    }

    @Nullable
    public final Boolean component3() {
        return this.static;
    }

    @Nullable
    public final Integer component4() {
        return this.randomYRange;
    }

    public final boolean component5() {
        return this.randomRotation;
    }

    @NotNull
    public final StructureSettings copy(@JsonAlias(value={"folder"}) @JsonDeserialize(using=FolderListDeserializer.class) @NotNull List<String> folders, @Nullable Boolean rename, @Nullable Boolean bl, @Nullable Integer randomYRange, boolean randomRotation) {
        Intrinsics.checkNotNullParameter(folders, (String)"folders");
        return new StructureSettings(folders, rename, bl, randomYRange, randomRotation);
    }

    public static /* synthetic */ StructureSettings copy$default(StructureSettings structureSettings, List list, Boolean bl, Boolean bl2, Integer n, boolean bl3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = structureSettings.folders;
        }
        if ((n2 & 2) != 0) {
            bl = structureSettings.rename;
        }
        if ((n2 & 4) != 0) {
            bl2 = structureSettings.static;
        }
        if ((n2 & 8) != 0) {
            n = structureSettings.randomYRange;
        }
        if ((n2 & 0x10) != 0) {
            bl3 = structureSettings.randomRotation;
        }
        return structureSettings.copy(list, bl, bl2, n, bl3);
    }

    @NotNull
    public String toString() {
        return "StructureSettings(folders=" + this.folders + ", rename=" + this.rename + ", static=" + this.static + ", randomYRange=" + this.randomYRange + ", randomRotation=" + this.randomRotation + ")";
    }

    public int hashCode() {
        int result = ((Object)this.folders).hashCode();
        result = result * 31 + (this.rename == null ? 0 : ((Object)this.rename).hashCode());
        result = result * 31 + (this.static == null ? 0 : ((Object)this.static).hashCode());
        result = result * 31 + (this.randomYRange == null ? 0 : ((Object)this.randomYRange).hashCode());
        result = result * 31 + Boolean.hashCode(this.randomRotation);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StructureSettings)) {
            return false;
        }
        StructureSettings structureSettings = (StructureSettings)other;
        if (!Intrinsics.areEqual(this.folders, structureSettings.folders)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.rename, (Object)structureSettings.rename)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.static, (Object)structureSettings.static)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.randomYRange, (Object)structureSettings.randomYRange)) {
            return false;
        }
        return this.randomRotation == structureSettings.randomRotation;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lg_mungus/vlib/data/StructureSettings$Companion;", "", "Ljava/io/InputStream;", "inputStream", "Lg_mungus/vlib/data/StructureSettings;", "readJson", "(Ljava/io/InputStream;)Lg_mungus/vlib/data/StructureSettings;", "<init>", "()V", "vlib"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Nullable
        public final StructureSettings readJson(@NotNull InputStream inputStream) {
            StructureSettings structureSettings;
            Intrinsics.checkNotNullParameter((Object)inputStream, (String)"inputStream");
            ObjectMapper objectMapper = ExtensionsKt.jacksonObjectMapper();
            Closeable closeable = inputStream;
            Throwable throwable = null;
            try {
                StructureSettings structureSettings2;
                InputStream it = (InputStream)closeable;
                boolean bl = false;
                try {
                    structureSettings2 = (StructureSettings)objectMapper.readValue(it, StructureSettings.class);
                }
                catch (MismatchedInputException e) {
                    structureSettings2 = null;
                }
                structureSettings = structureSettings2;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            }
            return structureSettings;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

