/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.util.serialization;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.dataformat.cbor.databind.CBORMapper;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.game.ships.ShipDataCommon;
import org.valkyrienskies.core.impl.shadow.GA;
import org.valkyrienskies.core.impl.shadow.GB;
import org.valkyrienskies.core.impl.shadow.GF;
import org.valkyrienskies.core.impl.shadow.GM;
import org.valkyrienskies.core.impl.shadow.GN;
import org.valkyrienskies.core.impl.shadow.gx_0;
import org.valkyrienskies.core.impl.shadow.gy_0;
import org.valkyrienskies.core.impl.shadow.gz_0;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J!\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u000f\u0010\nR\u001a\u0010\u0010\u001a\u00020\u00038\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0007\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u00020\u00148\u0007\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00038\u0007\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u00148\u0007\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018"}, d2={"Lorg/valkyrienskies/core/impl/util/serialization/VSJacksonUtil;", "", "Lkotlin/Function1;", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "", "configure", "configureAll", "(Lkotlin/jvm/functions/Function1;)V", "mapper", "configureConfigMapper", "(Lcom/fasterxml/jackson/databind/ObjectMapper;)V", "configureDeltaMapper", "configureDtoMapper", "configureMapper", "configurePacketMapper", "registerStandardModules", "configMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getConfigMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "Lcom/fasterxml/jackson/dataformat/cbor/databind/CBORMapper;", "defaultMapper", "Lcom/fasterxml/jackson/dataformat/cbor/databind/CBORMapper;", "getDefaultMapper", "()Lcom/fasterxml/jackson/dataformat/cbor/databind/CBORMapper;", "deltaMapper", "getDeltaMapper", "dtoMapper", "getDtoMapper", "packetMapper", "getPacketMapper", "<init>", "()V", "a"})
public final class VSJacksonUtil {
    public static final VSJacksonUtil INSTANCE = new VSJacksonUtil();
    private static final CBORMapper defaultMapper = new CBORMapper();
    private static final CBORMapper packetMapper = new CBORMapper();
    private static final CBORMapper deltaMapper = new CBORMapper();
    private static final ObjectMapper configMapper = new ObjectMapper();
    private static final ObjectMapper dtoMapper = new ObjectMapper();

    private VSJacksonUtil() {
    }

    @JvmName(name="getDefaultMapper")
    public final CBORMapper getDefaultMapper() {
        return defaultMapper;
    }

    @JvmName(name="getPacketMapper")
    public final CBORMapper getPacketMapper() {
        return packetMapper;
    }

    @JvmName(name="getDeltaMapper")
    public final CBORMapper getDeltaMapper() {
        return deltaMapper;
    }

    @JvmName(name="getConfigMapper")
    public final ObjectMapper getConfigMapper() {
        return configMapper;
    }

    @JvmName(name="getDtoMapper")
    public final ObjectMapper getDtoMapper() {
        return dtoMapper;
    }

    /*
     * WARNING - void declaration
     */
    public final void configureAll(Function1<? super ObjectMapper, Unit> configure) {
        void var1_1;
        Intrinsics.checkNotNullParameter(configure, (String)"");
        configure.invoke((Object)defaultMapper);
        configure.invoke((Object)packetMapper);
        configure.invoke((Object)deltaMapper);
        var1_1.invoke((Object)configMapper);
    }

    /*
     * WARNING - void declaration
     */
    private final void configureConfigMapper(ObjectMapper mapper) {
        void var1_1;
        this.configureMapper(mapper);
        var1_1.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /*
     * WARNING - void declaration
     */
    private final void configurePacketMapper(ObjectMapper mapper) {
        void var1_1;
        this.configureMapper(mapper);
        Class[] classArray = new Class[1];
        Class[] classArray2 = classArray;
        classArray[0] = GF.class;
        GM.a(mapper, new GA(classArray2));
        var1_1.addMixIn(ShipData.class, a.class);
    }

    /*
     * WARNING - void declaration
     */
    private final void configureDeltaMapper(ObjectMapper mapper) {
        void var1_1;
        this.configureMapper(mapper);
        Class[] classArray = new Class[2];
        Class[] classArray2 = classArray;
        classArray[0] = GF.class;
        classArray2[1] = gx_0.class;
        GM.a(mapper, new GA(classArray2));
        var1_1.addMixIn(ShipData.class, a.class);
    }

    /*
     * WARNING - void declaration
     */
    private final void configureDtoMapper(ObjectMapper mapper) {
        void var1_1;
        this.registerStandardModules(mapper);
        void v0 = var1_1;
        v0.setVisibility((VisibilityChecker<?>)v0.getVisibilityChecker().withGetterVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY).withIsGetterVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY).withCreatorVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY).withSetterVisibility(JsonAutoDetect.Visibility.NONE).withFieldVisibility(JsonAutoDetect.Visibility.NONE));
    }

    /*
     * WARNING - void declaration
     */
    private final void configureMapper(ObjectMapper mapper) {
        void var1_1;
        this.registerStandardModules(mapper);
        ObjectMapper objectMapper = mapper;
        objectMapper.setVisibility((VisibilityChecker<?>)objectMapper.getVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY).withGetterVisibility(JsonAutoDetect.Visibility.NONE).withIsGetterVisibility(JsonAutoDetect.Visibility.NONE).withSetterVisibility(JsonAutoDetect.Visibility.NONE));
        var1_1.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private final void registerStandardModules(ObjectMapper mapper) {
        ObjectMapper objectMapper = mapper.registerModule(new GB()).registerModule(new GN()).registerModule(new gz_0()).registerModule(new gy_0());
        Intrinsics.checkNotNullExpressionValue((Object)objectMapper, (String)"");
        ExtensionsKt.registerKotlinModule(objectMapper);
    }

    static {
        INSTANCE.configureMapper(defaultMapper);
        INSTANCE.configurePacketMapper(packetMapper);
        INSTANCE.configureDeltaMapper(deltaMapper);
        INSTANCE.configureConfigMapper(configMapper);
        INSTANCE.configureDtoMapper(dtoMapper);
    }

    @JsonSerialize(as=ShipDataCommon.class)
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u00c3\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2={"Lorg/valkyrienskies/core/impl/util/serialization/VSJacksonUtil$a;", "", "<init>", "()V"})
    static final class a {
        public static final a INSTANCE = new a();

        private a() {
        }
    }
}

