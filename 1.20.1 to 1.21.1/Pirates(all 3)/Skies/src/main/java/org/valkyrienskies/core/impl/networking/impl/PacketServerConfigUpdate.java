/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.networking.impl;

import com.fasterxml.jackson.databind.JsonNode;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.networking.simple.SimplePacket;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00028\u0007\u00a2\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0007\u00a2\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007"}, d2={"Lorg/valkyrienskies/core/impl/networking/impl/PacketServerConfigUpdate;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "Ljava/lang/Class;", "component1", "()Ljava/lang/Class;", "Lcom/fasterxml/jackson/databind/JsonNode;", "component2", "()Lcom/fasterxml/jackson/databind/JsonNode;", "mainClass", "newConfig", "copy", "(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JsonNode;)Lorg/valkyrienskies/core/impl/networking/impl/PacketServerConfigUpdate;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Class;", "getMainClass", "Lcom/fasterxml/jackson/databind/JsonNode;", "getNewConfig", "<init>", "(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JsonNode;)V"})
public final class PacketServerConfigUpdate
implements SimplePacket {
    private final Class<?> mainClass;
    private final JsonNode newConfig;

    /*
     * WARNING - void declaration
     */
    public PacketServerConfigUpdate(Class<?> mainClass, JsonNode newConfig) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(mainClass, (String)"");
        Intrinsics.checkNotNullParameter((Object)newConfig, (String)"");
        this.mainClass = var1_1;
        this.newConfig = var2_2;
    }

    @JvmName(name="getMainClass")
    public final Class<?> getMainClass() {
        return this.mainClass;
    }

    @JvmName(name="getNewConfig")
    public final JsonNode getNewConfig() {
        return this.newConfig;
    }

    public final Class<?> component1() {
        return this.mainClass;
    }

    public final JsonNode component2() {
        return this.newConfig;
    }

    /*
     * WARNING - void declaration
     */
    public final PacketServerConfigUpdate copy(Class<?> mainClass, JsonNode newConfig) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(mainClass, (String)"");
        Intrinsics.checkNotNullParameter((Object)newConfig, (String)"");
        return new PacketServerConfigUpdate((Class<?>)var1_1, (JsonNode)var2_2);
    }

    public static /* synthetic */ PacketServerConfigUpdate copy$default(PacketServerConfigUpdate packetServerConfigUpdate, Class clazz, JsonNode jsonNode, int n2, Object object) {
        if ((n2 & 1) != 0) {
            clazz = packetServerConfigUpdate.mainClass;
        }
        if ((n2 & 2) != 0) {
            jsonNode = packetServerConfigUpdate.newConfig;
        }
        return packetServerConfigUpdate.copy(clazz, jsonNode);
    }

    public final String toString() {
        return "PacketServerConfigUpdate(mainClass=" + this.mainClass + ", newConfig=" + this.newConfig + ")";
    }

    public final int hashCode() {
        int n2 = this.mainClass.hashCode();
        n2 = n2 * 31 + this.newConfig.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        PacketServerConfigUpdate packetServerConfigUpdate;
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketServerConfigUpdate)) {
            return false;
        }
        packetServerConfigUpdate = packetServerConfigUpdate;
        if (!Intrinsics.areEqual(this.mainClass, packetServerConfigUpdate.mainClass)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.newConfig, (Object)packetServerConfigUpdate.newConfig);
    }
}

