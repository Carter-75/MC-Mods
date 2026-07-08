/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.game.ChunkAllocator;
import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;
import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.game.ships.serialization.ChainUpdater;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.ServerShipDataConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV0;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV0Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV1;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV4;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineDataConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineData;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV1;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV4;
import org.valkyrienskies.core.impl.shadow.DQ;
import org.valkyrienskies.core.impl.shadow.EG;
import org.valkyrienskies.core.impl.shadow.FM;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.util.serialization.VSJacksonUtil;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\b\u0007\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineSerializer;", "", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineData;", "pipelineData", "Lorg/valkyrienskies/core/impl/shadow/EG;", "asVsPipelineModule", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineData;)Lorg/valkyrienskies/core/impl/shadow/EG;", "", "bytes", "deserialize", "([B)Lorg/valkyrienskies/core/impl/shadow/EG;", "queryableShipDataBytes", "chunkAllocatorBytes", "deserializeLegacy", "([B[B)Lorg/valkyrienskies/core/impl/shadow/EG;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV1;", "deserializeLegacyAsV1", "([B[B)Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV1;", "Lorg/valkyrienskies/core/impl/shadow/FM;", "pipeline", "serialize", "(Lorg/valkyrienskies/core/impl/shadow/FM;)[B", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "objectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineDataConverter;", "pipelineDataConverter", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineDataConverter;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/ServerShipDataConverter;", "shipDataMapper", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/ServerShipDataConverter;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/ChainUpdater;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV4;", "updater", "Lorg/valkyrienskies/core/impl/game/ships/serialization/ChainUpdater;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV0Updater;", "v0Updater", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV0Updater;", "<init>", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/ServerShipDataConverter;Lorg/valkyrienskies/core/impl/game/ships/serialization/ChainUpdater;Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV0Updater;Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineDataConverter;)V"})
public final class VSPipelineSerializer {
    private final ObjectMapper objectMapper;
    private final ServerShipDataConverter shipDataMapper;
    private final ChainUpdater<VSPipelineDataV4> updater;
    private final ServerShipDataV0Updater v0Updater;
    private final VSPipelineDataConverter pipelineDataConverter;

    /*
     * WARNING - void declaration
     */
    @Inject
    public VSPipelineSerializer(@Named(value="dto") ObjectMapper objectMapper, ServerShipDataConverter shipDataMapper, ChainUpdater<VSPipelineDataV4> updater, ServerShipDataV0Updater v0Updater, VSPipelineDataConverter pipelineDataConverter) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)objectMapper, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipDataMapper, (String)"");
        Intrinsics.checkNotNullParameter(updater, (String)"");
        Intrinsics.checkNotNullParameter((Object)v0Updater, (String)"");
        Intrinsics.checkNotNullParameter((Object)pipelineDataConverter, (String)"");
        this.objectMapper = var1_1;
        this.shipDataMapper = var2_2;
        this.updater = var3_3;
        this.v0Updater = v0Updater;
        this.pipelineDataConverter = pipelineDataConverter;
    }

    /*
     * WARNING - void declaration
     */
    public final EG deserializeLegacy(byte[] queryableShipDataBytes, byte[] chunkAllocatorBytes) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)queryableShipDataBytes, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkAllocatorBytes, (String)"");
        VSPipelineSerializer vSPipelineSerializer = this;
        return vSPipelineSerializer.asVsPipelineModule(vSPipelineSerializer.deserializeLegacyAsV1((byte[])var1_1, (byte[])var2_2));
    }

    public final EG deserialize(byte[] bytes) {
        VSPipelineData vSPipelineData;
        Intrinsics.checkNotNullParameter((Object)bytes, (String)"");
        Object object = this.objectMapper;
        vSPipelineData = (VSPipelineData)((ObjectMapper)object).readValue((byte[])vSPipelineData, (TypeReference)new TypeReference<VSPipelineData>(){});
        object = this.updater.updateToLatest(vSPipelineData);
        return this.pipelineDataConverter.convertToModel((VSPipelineDataV4)object);
    }

    public final byte[] serialize(FM pipeline) {
        Object object;
        Intrinsics.checkNotNullParameter((Object)pipeline, (String)"");
        Object object2 = pipeline;
        object2 = ((FM)object2).a;
        object2 = ((er_0)object2).a;
        Object object3 = this.shipDataMapper;
        Iterator iterator2 = object2;
        object2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object object4 = iterator2.next();
            object4 = (ShipData)object4;
            Iterator iterator3 = object2;
            iterator3.add((ServerShipDataV4)object3.convertToDto((ShipData)object4));
        }
        object3 = (List)object2;
        object2 = object;
        object = ((FM)object2).a;
        ChunkAllocatorProvider chunkAllocatorProvider = ((er_0)object).b;
        Intrinsics.checkNotNull((Object)chunkAllocatorProvider);
        object = (DQ)chunkAllocatorProvider;
        object2 = ((DQ)object).a;
        object3 = new VSPipelineDataV4((ChunkAllocator)object2, (List<ServerShipDataV4>)object3);
        byte[] byArray = this.objectMapper.writeValueAsBytes(object3);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"");
        return byArray;
    }

    /*
     * WARNING - void declaration
     */
    private final EG asVsPipelineModule(VSPipelineData pipelineData) {
        void var1_1;
        return this.pipelineDataConverter.convertToModel(this.updater.updateToLatest(var1_1));
    }

    private final VSPipelineDataV1 deserializeLegacyAsV1(byte[] queryableShipDataBytes, byte[] chunkAllocatorBytes) {
        Object object;
        Iterable<ServerShipDataV1> iterable;
        Object object2 = VSJacksonUtil.INSTANCE.getDefaultMapper();
        iterable = (List)((ObjectMapper)object2).readValue((byte[])iterable, (TypeReference)new TypeReference<List<? extends ServerShipDataV0>>(){});
        Object object3 = VSJacksonUtil.INSTANCE.getDefaultMapper();
        object2 = (ChunkAllocator)((ObjectMapper)object3).readValue((byte[])object, (TypeReference)new TypeReference<ChunkAllocator>(){});
        iterable = iterable;
        object = iterable;
        iterable = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
        object = object.iterator();
        while (object.hasNext()) {
            object3 = object.next();
            object3 = (ServerShipDataV0)object3;
            Iterable<ServerShipDataV1> iterable2 = iterable;
            iterable2.add((ServerShipDataV1)this.v0Updater.update(object3));
        }
        object3 = iterable;
        return new VSPipelineDataV1((ChunkAllocator)object2, (List<ServerShipDataV1>)object3);
    }
}

