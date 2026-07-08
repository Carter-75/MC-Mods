/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Triple
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.nio.ByteBuffer;
import java.util.AbstractCollection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.valkyrienskies.core.impl.shadow.HE;
import org.valkyrienskies.core.impl.shadow.HF;
import org.valkyrienskies.core.impl.shadow.HG;
import org.valkyrienskies.core.impl.shadow.HH;
import org.valkyrienskies.core.impl.shadow.HJ;
import org.valkyrienskies.core.impl.shadow.HL;
import org.valkyrienskies.core.impl.shadow.HM;
import org.valkyrienskies.core.impl.shadow.HN;
import org.valkyrienskies.core.impl.shadow.HO;
import org.valkyrienskies.core.impl.shadow.HP;
import org.valkyrienskies.core.impl.shadow.IE;
import org.valkyrienskies.core.impl.shadow.hb_0;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J@\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0019\"\u0010\b\u0000\u0010\u0017\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0006\b\u0001\u0010\u0018\u0018\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0082\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ2\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c\"\u0010\b\u0000\u0010\u0017\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0082\b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020.2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u0002012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u0002042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b5\u00106J\u001b\u00109\u001a\u000607j\u0002`82\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020>2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b?\u0010@J\u0015\u0010B\u001a\u00020A2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020D2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\bE\u0010FJ\u0015\u0010H\u001a\u00020G2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020J2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\bK\u0010LJ\u0015\u0010N\u001a\u00020M2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bN\u0010OJ]\u0010S\u001aJ\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0018\u000107j\u0004\u0018\u0001`8\u0012\u0004\u0012\u00020;0Q\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0018\u000107j\u0004\u0018\u0001`8\u0012\u0004\u0012\u00020;0Q\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0004\u0012\u00020R0Q0P2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bS\u0010TJ\u001f\u0010W\u001a\u00020V2\u0006\u0010U\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\bW\u0010XJ\u001d\u0010Z\u001a\u00020V2\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bZ\u0010[J\u001f\u0010]\u001a\u00020V2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b]\u0010^J\u001d\u0010_\u001a\u00020V2\u0006\u0010Y\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b_\u0010`J\u001f\u0010b\u001a\u00020V2\u0006\u0010a\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\bb\u0010cJ\u001f\u0010e\u001a\u00020V2\u0006\u0010d\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\be\u0010fJC\u0010i\u001a\u00020V\"\u000e\b\u0000\u0010\u0017*\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0001\u0010\u00182\u0014\u0010h\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010g2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\bi\u0010jJ7\u0010l\u001a\u00020V\"\u000e\b\u0000\u0010\u0017*\b\u0012\u0004\u0012\u00028\u00000\u00162\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\bl\u0010mJ\u001d\u0010n\u001a\u00020V2\u0006\u0010Y\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bn\u0010oJ\u001d\u0010p\u001a\u00020V2\u0006\u0010Y\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bp\u0010qJ\u001f\u0010s\u001a\u00020V2\u0006\u0010r\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\bs\u0010tJ\u001f\u0010v\u001a\u00020V2\u0006\u0010u\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\bv\u0010wJ\u001f\u0010y\u001a\u00020V2\u0006\u0010x\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\by\u0010zJ\u001f\u0010|\u001a\u00020V2\u0006\u0010{\u001a\u00020.2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b|\u0010}J\u001f\u0010~\u001a\u00020V2\u0006\u0010U\u001a\u0002012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b~\u0010\u007fJ#\u0010\u0081\u0001\u001a\u00020V2\u0007\u0010\u0080\u0001\u001a\u0002042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J'\u0010\u0084\u0001\u001a\u00020V2\u000b\u0010\u0083\u0001\u001a\u000607j\u0002`82\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J#\u0010\u0087\u0001\u001a\u00020V2\u0007\u0010\u0086\u0001\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J \u0010\u0089\u0001\u001a\u00020V2\u0006\u0010Y\u001a\u00020>2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J \u0010\u008b\u0001\u001a\u00020V2\u0006\u0010Y\u001a\u00020A2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J#\u0010\u008e\u0001\u001a\u00020V2\u0007\u0010\u008d\u0001\u001a\u00020D2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J \u0010\u0090\u0001\u001a\u00020V2\u0006\u0010Y\u001a\u00020G2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\"\u0010\u0092\u0001\u001a\u00020V2\u0006\u0010d\u001a\u00020J2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J \u0010\u0094\u0001\u001a\u00020V2\u0006\u0010Y\u001a\u00020M2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J!\u0010\u0097\u0001\u001a\u00020V2\u0007\u0010Y\u001a\u00030\u0096\u00012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001\u00a8\u0006\u009b\u0001"}, d2={"Lorg/valkyrienskies/physics_api_krunch/encoders/JointCodec;", "", "Ljava/nio/ByteBuffer;", "buffer", "Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;", "decodeAngularLimitPair", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;", "Lorg/valkyrienskies/physics_api/joints/D6Joint;", "decodeD6", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/D6Joint;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$D6JointDrive;", "decodeD6JointDrive", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/D6Joint$D6JointDrive;", "Lorg/valkyrienskies/physics_api/joints/DistanceJoint;", "decodeDistance", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/DistanceJoint;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$DrivePosition;", "decodeDrivePosition", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/D6Joint$DrivePosition;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$DriveVelocity;", "decodeDriveVelocity", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/D6Joint$DriveVelocity;", "", "K", "V", "Ljava/util/EnumMap;", "decodeEnumMap", "(Ljava/nio/ByteBuffer;)Ljava/util/EnumMap;", "Ljava/util/EnumSet;", "decodeEnumSet", "(Ljava/nio/ByteBuffer;)Ljava/util/EnumSet;", "Lorg/valkyrienskies/physics_api/joints/FixedJoint;", "decodeFixed", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/FixedJoint;", "Lorg/valkyrienskies/physics_api/joints/GearJoint;", "decodeGear", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/GearJoint;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;", "decodeHinges", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;", "decodeLimitCone", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitPyramid;", "decodeLimitPyramid", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitPyramid;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimit;", "decodeLinearLimit", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimit;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimitPair;", "decodeLinearLimitPair", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimitPair;", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "decodeMaxForceTorque", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "", "Lorg/valkyrienskies/physics_api/PhysicsBodyId;", "decodePhysicsBodyId", "(Ljava/nio/ByteBuffer;)I", "Lorg/valkyrienskies/physics_api/Pose;", "decodePose", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/Pose;", "Lorg/valkyrienskies/physics_api/joints/PrismaticJoint;", "decodePrismatic", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/PrismaticJoint;", "Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint;", "decodeRackAndPinion", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint;", "Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint$Data;", "decodeRackAndPinionData", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint$Data;", "Lorg/valkyrienskies/physics_api/joints/RevoluteJoint;", "decodeRevolute", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/RevoluteJoint;", "Lorg/valkyrienskies/physics_api/joints/RevoluteJoint$RevoluteDriveVelocity;", "decodeRevoluteDriveVelocity", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/RevoluteJoint$RevoluteDriveVelocity;", "Lorg/valkyrienskies/physics_api/joints/SphericalJoint;", "decodeSpherical", "(Ljava/nio/ByteBuffer;)Lorg/valkyrienskies/physics_api/joints/SphericalJoint;", "Lkotlin/Triple;", "Lkotlin/Pair;", "", "decodeStart", "(Ljava/nio/ByteBuffer;)Lkotlin/Triple;", "pair", "", "encodeAngularLimitPair", "(Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;Ljava/nio/ByteBuffer;)V", "joint", "encodeD6", "(Lorg/valkyrienskies/physics_api/joints/D6Joint;Ljava/nio/ByteBuffer;)V", "drive", "encodeD6JointDrive", "(Lorg/valkyrienskies/physics_api/joints/D6Joint$D6JointDrive;Ljava/nio/ByteBuffer;)V", "encodeDistance", "(Lorg/valkyrienskies/physics_api/joints/DistanceJoint;Ljava/nio/ByteBuffer;)V", "position", "encodeDrivePosition", "(Lorg/valkyrienskies/physics_api/joints/D6Joint$DrivePosition;Ljava/nio/ByteBuffer;)V", "velocity", "encodeDriveVelocity", "(Lorg/valkyrienskies/physics_api/joints/D6Joint$DriveVelocity;Ljava/nio/ByteBuffer;)V", "", "map", "encodeEnumMap", "(Ljava/util/Map;Ljava/nio/ByteBuffer;)V", "set", "encodeEnumSet", "(Ljava/util/EnumSet;Ljava/nio/ByteBuffer;)V", "encodeFixed", "(Lorg/valkyrienskies/physics_api/joints/FixedJoint;Ljava/nio/ByteBuffer;)V", "encodeGear", "(Lorg/valkyrienskies/physics_api/joints/GearJoint;Ljava/nio/ByteBuffer;)V", "hinges", "encodeHinges", "(Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;Ljava/nio/ByteBuffer;)V", "cone", "encodeLimitCone", "(Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;Ljava/nio/ByteBuffer;)V", "pyramid", "encodeLimitPyramid", "(Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitPyramid;Ljava/nio/ByteBuffer;)V", "limit", "encodeLinearLimit", "(Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimit;Ljava/nio/ByteBuffer;)V", "encodeLinearLimitPair", "(Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimitPair;Ljava/nio/ByteBuffer;)V", "forceTorque", "encodeMaxForceTorque", "(Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;Ljava/nio/ByteBuffer;)V", "id", "encodePhysicsBodyId", "(ILjava/nio/ByteBuffer;)V", "pose", "encodePose", "(Lorg/valkyrienskies/physics_api/Pose;Ljava/nio/ByteBuffer;)V", "encodePrismatic", "(Lorg/valkyrienskies/physics_api/joints/PrismaticJoint;Ljava/nio/ByteBuffer;)V", "encodeRackAndPinion", "(Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint;Ljava/nio/ByteBuffer;)V", "data", "encodeRackAndPinionData", "(Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint$Data;Ljava/nio/ByteBuffer;)V", "encodeRevolute", "(Lorg/valkyrienskies/physics_api/joints/RevoluteJoint;Ljava/nio/ByteBuffer;)V", "encodeRevoluteDriveVelocity", "(Lorg/valkyrienskies/physics_api/joints/RevoluteJoint$RevoluteDriveVelocity;Ljava/nio/ByteBuffer;)V", "encodeSpherical", "(Lorg/valkyrienskies/physics_api/joints/SphericalJoint;Ljava/nio/ByteBuffer;)V", "Lorg/valkyrienskies/physics_api/joints/JointData;", "encodeStart", "(Lorg/valkyrienskies/physics_api/joints/JointData;Ljava/nio/ByteBuffer;)V", "<init>", "()V", "physics_api_krunch"})
public final class ID {
    public static final ID INSTANCE = new ID();

    private ID() {
    }

    public final void a(HJ hJ, ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        Intrinsics.checkNotNullParameter((Object)hJ, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
        boolean bl = hJ.a() != null;
        byteBuffer.put(IE.a(bl));
        Integer n2 = hJ.a();
        if (n2 != null) {
            int hL2 = ((Number)n2).intValue();
            byteBuffer2 = byteBuffer;
            int n3 = hL2;
            byteBuffer2.putInt(n3);
        }
        ID.a(hJ.b(), byteBuffer);
        boolean bl2 = hJ.c() != null;
        byteBuffer.put(IE.a(bl2));
        Integer n4 = hJ.c();
        if (n4 != null) {
            int n5 = ((Number)n4).intValue();
            byteBuffer2 = byteBuffer;
            int n6 = n5;
            byteBuffer2.putInt(n6);
        }
        ID.a(hJ.d(), byteBuffer);
        boolean bl3 = hJ.e() != null;
        byteBuffer.put(IE.a(bl3));
        HL hL = hJ.e();
        if (hL != null) {
            HL hL2 = hL;
            ID.a(hL, byteBuffer);
        }
        byteBuffer.putDouble(hJ.o());
    }

    public final Triple<Pair<Integer, hb_0>, Pair<Integer, hb_0>, Pair<HL, Double>> a(ByteBuffer byteBuffer) {
        Integer n2;
        Integer n3;
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
        byte by = byteBuffer.get();
        if (IE.a(by)) {
            ByteBuffer byteBuffer2 = byteBuffer;
            n3 = byteBuffer2.getInt();
        } else {
            n3 = null;
        }
        Integer n4 = n3;
        hb_0 hb_02 = ID.j(byteBuffer);
        byte by2 = byteBuffer.get();
        if (IE.a(by2)) {
            ByteBuffer byteBuffer3 = byteBuffer;
            n2 = byteBuffer3.getInt();
        } else {
            n2 = null;
        }
        Integer n5 = n2;
        hb_0 hb_03 = ID.j(byteBuffer);
        byte by3 = byteBuffer.get();
        HL hL = IE.a(by3) ? ID.v(byteBuffer) : null;
        double d2 = byteBuffer.getDouble();
        return new Triple((Object)new Pair((Object)n4, (Object)hb_02), (Object)new Pair((Object)n5, (Object)hb_03), (Object)new Pair((Object)hL, (Object)d2));
    }

    public final void a(HG hG, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)hG, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
        this.a((HJ)hG, byteBuffer);
    }

    public final HG b(ByteBuffer pair) {
        Intrinsics.checkNotNullParameter((Object)pair, (String)"");
        pair = this.a((ByteBuffer)pair);
        Object object = (Pair)pair.component1();
        Object object2 = (Pair)pair.component2();
        pair = (Pair)pair.component3();
        Integer n2 = (Integer)object.getFirst();
        object = (hb_0)object.getSecond();
        Integer n3 = (Integer)object2.getFirst();
        object2 = (hb_0)object2.getSecond();
        return new HG(n2, (hb_0)object, n3, (hb_0)object2, (HL)pair.getFirst(), ((Number)pair.getSecond()).doubleValue());
    }

    public final void a(HF hF, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)hF, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
        this.a((HJ)hF, byteBuffer);
        HF hF2 = hF;
        boolean bl = hF2.b != null;
        byteBuffer.put(IE.a(bl));
        HF hF3 = hF;
        Float f2 = hF3.b;
        if (f2 != null) {
            float f3 = ((Number)f2).floatValue();
            byteBuffer.putFloat(f3);
        }
        HF hF4 = hF;
        boolean bl2 = hF4.c != null;
        byteBuffer.put(IE.a(bl2));
        HF hF5 = hF;
        Float f4 = hF5.c;
        if (f4 != null) {
            float f5 = ((Number)f4).floatValue();
            byteBuffer.putFloat(f5);
        }
        HF hF6 = hF;
        boolean bl3 = hF6.d != null;
        byteBuffer.put(IE.a(bl3));
        HF hF7 = hF;
        Float f6 = hF7.d;
        if (f6 != null) {
            float f7 = ((Number)f6).floatValue();
            byteBuffer.putFloat(f7);
        }
        HF hF8 = hF;
        boolean bl4 = hF8.e != null;
        byteBuffer.put(IE.a(bl4));
        HF hF9 = hF;
        Float f8 = hF9.e;
        if (f8 != null) {
            float f9 = ((Number)f8).floatValue();
            byteBuffer.putFloat(f9);
        }
        HF hF10 = hF;
        boolean bl5 = hF10.f != null;
        byteBuffer.put(IE.a(bl5));
        HF hF11 = hF;
        Float f10 = hF11.f;
        if (f10 == null) {
            return;
        }
        float f11 = ((Number)f10).floatValue();
        byteBuffer.putFloat(f11);
    }

    public final HF c(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
        Pair pair = this.a(byteBuffer);
        Object object = (Pair)pair.component1();
        Object object2 = (Pair)pair.component2();
        pair = (Pair)pair.component3();
        Integer n2 = (Integer)object.getFirst();
        object = (hb_0)object.getSecond();
        Integer n3 = (Integer)object2.getFirst();
        object2 = (hb_0)object2.getSecond();
        byte by = byteBuffer.get();
        Float f2 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        Float f3 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        Float f4 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        Float f5 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        byteBuffer = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        return new HF(n2, (hb_0)object, n3, (hb_0)object2, (HL)pair.getFirst(), f2, f3, f4, f5, (Float)((Object)byteBuffer), ((Number)pair.getSecond()).doubleValue());
    }

    public final void a(HP object, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
        this.a((HJ)object, byteBuffer);
        HP hP = object;
        boolean bl = hP.b != null;
        byteBuffer.put(IE.a(bl));
        HP hP2 = object;
        HE.i i2 = hP2.b;
        if (i2 == null) {
            return;
        }
        object = i2;
        ID.a(i2, byteBuffer);
    }

    public final HP d(ByteBuffer object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Pair pair = this.a((ByteBuffer)object);
        Object object2 = (Pair)pair.component1();
        Object object3 = (Pair)pair.component2();
        pair = (Pair)pair.component3();
        Integer n2 = (Integer)object2.getFirst();
        object2 = (hb_0)object2.getSecond();
        Integer n3 = (Integer)object3.getFirst();
        object3 = (hb_0)object3.getSecond();
        byte by = ((ByteBuffer)object).get();
        object = IE.a(by) ? ID.n((ByteBuffer)object) : null;
        return new HP(n2, (hb_0)object2, n3, (hb_0)object3, (HL)pair.getFirst(), (HE.i)object, ((Number)pair.getSecond()).doubleValue());
    }

    public final void a(HO hO, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)hO, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
        this.a((HJ)hO, byteBuffer);
        HO hO2 = hO;
        boolean bl = hO2.b != null;
        byteBuffer.put(IE.a(bl));
        Object object = hO;
        HE.a a2 = ((HO)object).b;
        if (a2 != null) {
            object = a2;
            ID.a(a2, byteBuffer);
        }
        object = hO;
        boolean bl2 = ((HO)object).c != null;
        byteBuffer.put(IE.a(bl2));
        Object object2 = hO;
        HO.a a3 = ((HO)object2).c;
        if (a3 != null) {
            object2 = a3;
            ID.a(a3, byteBuffer);
        }
        object2 = hO;
        boolean bl3 = ((HO)object2).d != null;
        byteBuffer.put(IE.a(bl3));
        HO hO3 = hO;
        Float f2 = hO3.d;
        if (f2 != null) {
            float f3 = ((Number)f2).floatValue();
            byteBuffer.putFloat(f3);
        }
        HO hO4 = hO;
        boolean bl4 = hO4.e != null;
        byteBuffer.put(IE.a(bl4));
        HO hO5 = hO;
        Float f4 = hO5.e;
        if (f4 != null) {
            float f5 = ((Number)f4).floatValue();
            byteBuffer.putFloat(f5);
        }
        HO hO6 = hO;
        boolean bl5 = hO6.f != null;
        byteBuffer.put(IE.a(bl5));
        HO hO7 = hO;
        Boolean bl6 = hO7.f;
        if (bl6 == null) {
            return;
        }
        boolean bl7 = bl6;
        byteBuffer.put(IE.a(bl7));
    }

    public final HO e(ByteBuffer byteBuffer) {
        Boolean bl;
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
        Pair pair = this.a(byteBuffer);
        Object object = (Pair)pair.component1();
        Object object2 = (Pair)pair.component2();
        pair = (Pair)pair.component3();
        Integer n2 = (Integer)object.getFirst();
        object = (hb_0)object.getSecond();
        Integer n3 = (Integer)object2.getFirst();
        object2 = (hb_0)object2.getSecond();
        byte by = byteBuffer.get();
        HE.a a2 = IE.a(by) ? ID.m(byteBuffer) : null;
        by = byteBuffer.get();
        HO.a a3 = IE.a(by) ? ID.t(byteBuffer) : null;
        by = byteBuffer.get();
        Float f2 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        Float f3 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        if (IE.a(by)) {
            by = byteBuffer.get();
            bl = IE.a(by);
        } else {
            bl = null;
        }
        byteBuffer = bl;
        return new HO(n2, (hb_0)object, n3, (hb_0)object2, (HL)pair.getFirst(), a2, a3, f2, f3, (Boolean)((Object)byteBuffer), ((Number)pair.getSecond()).doubleValue());
    }

    public final void a(HM object, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
        this.a((HJ)object, byteBuffer);
        HM hM = object;
        boolean bl = hM.b != null;
        byteBuffer.put(IE.a(bl));
        HM hM2 = object;
        HE.l l2 = hM2.b;
        if (l2 == null) {
            return;
        }
        object = l2;
        ID.a(l2, byteBuffer);
    }

    public final HM f(ByteBuffer object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Pair pair = this.a((ByteBuffer)object);
        Object object2 = (Pair)pair.component1();
        Object object3 = (Pair)pair.component2();
        pair = (Pair)pair.component3();
        Integer n2 = (Integer)object2.getFirst();
        object2 = (hb_0)object2.getSecond();
        Integer n3 = (Integer)object3.getFirst();
        object3 = (hb_0)object3.getSecond();
        byte by = ((ByteBuffer)object).get();
        object = IE.a(by) ? ID.l((ByteBuffer)object) : null;
        return new HM(n2, (hb_0)object2, n3, (hb_0)object3, (HL)pair.getFirst(), (HE.l)object, ((Number)pair.getSecond()).doubleValue());
    }

    public final void a(HH hH, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)hH, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
        this.a((HJ)hH, byteBuffer);
        HH hH2 = hH;
        boolean bl = hH2.b != null;
        byteBuffer.put(IE.a(bl));
        Object object = hH;
        HE.h h2 = ((HH)object).b;
        if (h2 != null) {
            object = h2;
            ID.a(h2, byteBuffer);
        }
        object = hH;
        boolean bl2 = ((HH)object).c != null;
        byteBuffer.put(IE.a(bl2));
        HH hH3 = hH;
        Float f2 = hH3.c;
        if (f2 == null) {
            return;
        }
        float f3 = ((Number)f2).floatValue();
        byteBuffer.putFloat(f3);
    }

    public final HH g(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
        Pair pair = this.a(byteBuffer);
        Object object = (Pair)pair.component1();
        Object object2 = (Pair)pair.component2();
        pair = (Pair)pair.component3();
        Integer n2 = (Integer)object.getFirst();
        object = (hb_0)object.getSecond();
        Integer n3 = (Integer)object2.getFirst();
        object2 = (hb_0)object2.getSecond();
        byte by = byteBuffer.get();
        HE.h h2 = IE.a(by) ? ID.p(byteBuffer) : null;
        by = byteBuffer.get();
        byteBuffer = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        return new HH(n2, (hb_0)object, n3, (hb_0)object2, (HL)pair.getFirst(), h2, (Float)((Object)byteBuffer), ((Number)pair.getSecond()).doubleValue());
    }

    public final void a(HN hN, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)hN, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
        this.a((HJ)hN, byteBuffer);
        HN hN2 = hN;
        boolean bl = hN2.b != null;
        byteBuffer.put(IE.a(bl));
        Object object = hN;
        HE.h h2 = ((HN)object).b;
        if (h2 != null) {
            object = h2;
            ID.a(h2, byteBuffer);
        }
        object = hN;
        boolean bl2 = ((HN)object).c != null;
        byteBuffer.put(IE.a(bl2));
        HN hN3 = hN;
        Float f2 = hN3.c;
        if (f2 != null) {
            float f3 = ((Number)f2).floatValue();
            byteBuffer.putFloat(f3);
        }
        HN hN4 = hN;
        boolean bl3 = hN4.d != null;
        byteBuffer.put(IE.a(bl3));
        Object object2 = hN;
        HN.a a2 = ((HN)object2).d;
        if (a2 == null) {
            return;
        }
        object2 = a2;
        ID.a(a2, byteBuffer);
    }

    public final HN h(ByteBuffer object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Pair pair = this.a((ByteBuffer)object);
        Object object2 = (Pair)pair.component1();
        Object object3 = (Pair)pair.component2();
        pair = (Pair)pair.component3();
        Integer n2 = (Integer)object2.getFirst();
        object2 = (hb_0)object2.getSecond();
        Integer n3 = (Integer)object3.getFirst();
        object3 = (hb_0)object3.getSecond();
        byte by = ((ByteBuffer)object).get();
        HE.h h2 = IE.a(by) ? ID.p((ByteBuffer)object) : null;
        by = ((ByteBuffer)object).get();
        Float f2 = IE.a(by) ? Float.valueOf(((ByteBuffer)object).getFloat()) : null;
        by = ((ByteBuffer)object).get();
        object = IE.a(by) ? ID.q((ByteBuffer)object) : null;
        return new HN(n2, (hb_0)object2, n3, (hb_0)object3, (HL)pair.getFirst(), h2, f2, (HN.a)object, ((Number)pair.getSecond()).doubleValue());
    }

    public final void a(HE hE, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)hE, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"");
        this.a((HJ)hE, byteBuffer);
        HE hE2 = hE;
        ID.a((Map)hE2.b, byteBuffer);
        hE2 = hE;
        boolean bl = hE2.c != null;
        byteBuffer.put(IE.a(bl));
        Object object = hE;
        HE.k k2 = ((HE)object).c;
        if (k2 != null) {
            object = k2;
            ID.a(k2, byteBuffer);
        }
        object = hE;
        ID.a((Map)((HE)object).d, byteBuffer);
        object = hE;
        boolean bl2 = ((HE)object).e != null;
        byteBuffer.put(IE.a(bl2));
        Object object2 = hE;
        HE.a a2 = ((HE)object2).e;
        if (a2 != null) {
            object2 = a2;
            ID.a(a2, byteBuffer);
        }
        object2 = hE;
        boolean bl3 = ((HE)object2).f != null;
        byteBuffer.put(IE.a(bl3));
        Object object3 = hE;
        HE.i i2 = ((HE)object3).f;
        if (i2 != null) {
            object3 = i2;
            ID.a(i2, byteBuffer);
        }
        object3 = hE;
        boolean bl4 = ((HE)object3).g != null;
        byteBuffer.put(IE.a(bl4));
        Object object4 = hE;
        HE.j j2 = ((HE)object4).g;
        if (j2 != null) {
            object4 = j2;
            ID.a(j2, byteBuffer);
        }
        object4 = hE;
        ID.a((Map)((HE)object4).h, byteBuffer);
        object4 = hE;
        boolean bl5 = ((HE)object4).i != null;
        byteBuffer.put(IE.a(bl5));
        Object object5 = hE;
        HE.f f2 = ((HE)object5).i;
        if (f2 != null) {
            object5 = f2;
            INSTANCE.a((HE.f)object5, byteBuffer);
        }
        object5 = hE;
        boolean bl6 = ((HE)object5).j != null;
        byteBuffer.put(IE.a(bl6));
        Object object6 = hE;
        HE.g g2 = ((HE)object6).j;
        if (g2 == null) {
            return;
        }
        object6 = g2;
        ID.a(g2, byteBuffer);
    }

    public final HE i(ByteBuffer object) {
        EnumMap enumMap;
        HE.j j2;
        Object object2;
        Class<HE.l> clazz;
        HE.k k2;
        Class<HE.l> clazz2;
        int n2;
        Object object3;
        EnumMap<HE.b, HE.e> enumMap2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Pair pair = this.a((ByteBuffer)object);
        Object object4 = (Pair)pair.component1();
        Object object5 = (Pair)pair.component2();
        pair = (Pair)pair.component3();
        Integer n3 = (Integer)object4.getFirst();
        object4 = (hb_0)object4.getSecond();
        Integer n4 = (Integer)object5.getFirst();
        object5 = (hb_0)object5.getSecond();
        if (((ByteBuffer)object).get() == 0) {
            enumMap2 = null;
        } else {
            int n5 = ((ByteBuffer)object).getInt();
            object3 = new EnumMap<HE.b, HE.e>(HE.b.class);
            n2 = 0;
            while (n2 < n5) {
                Object object6;
                ++n2;
                clazz2 = ((Enum[])HE.b.class.getEnumConstants())[((ByteBuffer)object).getInt()];
                Class<HE.e> clazz3 = HE.e.class;
                if (Intrinsics.areEqual(HE.e.class, HE.e.class)) {
                    object6 = HE.e.values()[((ByteBuffer)object).getInt()];
                } else if (Intrinsics.areEqual(clazz3, HE.l.class)) {
                    object6 = ID.l((ByteBuffer)object);
                } else if (Intrinsics.areEqual(clazz3, HE.d.class)) {
                    object6 = ID.r((ByteBuffer)object);
                } else {
                    throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unsupported enum map value type: ", HE.e.class));
                }
                if (object6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.valkyrienskies.physics_api.joints.D6Joint.D6Motion");
                }
                HE.e e2 = object6;
                ((Map)object3).put(clazz2, e2);
            }
            enumMap2 = object3;
        }
        EnumMap<HE.b, HE.e> enumMap3 = enumMap2;
        byte by = ((ByteBuffer)object).get();
        HE.k k3 = k2 = IE.a(by) ? ID.k((ByteBuffer)object) : null;
        if (((ByteBuffer)object).get() == 0) {
            clazz = null;
        } else {
            n2 = ((ByteBuffer)object).getInt();
            clazz2 = new EnumMap(HE.b.class);
            int n6 = 0;
            while (n6 < n2) {
                Object object7;
                ++n6;
                Enum enum_ = ((Enum[])HE.b.class.getEnumConstants())[((ByteBuffer)object).getInt()];
                object2 = HE.l.class;
                if (Intrinsics.areEqual(HE.l.class, HE.e.class)) {
                    object7 = HE.e.values()[((ByteBuffer)object).getInt()];
                } else if (Intrinsics.areEqual(object2, HE.l.class)) {
                    object7 = ID.l((ByteBuffer)object);
                } else if (Intrinsics.areEqual(object2, HE.d.class)) {
                    object7 = ID.r((ByteBuffer)object);
                } else {
                    throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unsupported enum map value type: ", HE.l.class));
                }
                if (object7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.valkyrienskies.physics_api.joints.D6Joint.LinearLimitPair");
                }
                object2 = (HE.l)object7;
                ((Map)((Object)clazz2)).put(enum_, object2);
            }
            clazz = clazz2;
        }
        object2 = clazz;
        int n7 = ((ByteBuffer)object).get();
        HE.a a2 = IE.a((byte)n7) ? ID.m((ByteBuffer)object) : null;
        n7 = ((ByteBuffer)object).get();
        object3 = IE.a((byte)n7) ? ID.n((ByteBuffer)object) : null;
        n7 = ((ByteBuffer)object).get();
        HE.j j3 = j2 = IE.a((byte)n7) ? ID.o((ByteBuffer)object) : null;
        if (((ByteBuffer)object).get() == 0) {
            enumMap = null;
        } else {
            int n8 = ((ByteBuffer)object).getInt();
            EnumMap enumMap4 = new EnumMap(HE.c.class);
            n7 = 0;
            while (n7 < n8) {
                Object object8;
                ++n7;
                Enum enum_ = ((Enum[])HE.c.class.getEnumConstants())[((ByteBuffer)object).getInt()];
                Object object9 = HE.d.class;
                if (Intrinsics.areEqual(HE.d.class, HE.e.class)) {
                    object8 = HE.e.values()[((ByteBuffer)object).getInt()];
                } else if (Intrinsics.areEqual(object9, HE.l.class)) {
                    object8 = ID.l((ByteBuffer)object);
                } else if (Intrinsics.areEqual(object9, HE.d.class)) {
                    object8 = ID.r((ByteBuffer)object);
                } else {
                    throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unsupported enum map value type: ", HE.d.class));
                }
                if (object8 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.valkyrienskies.physics_api.joints.D6Joint.D6JointDrive");
                }
                object9 = (HE.d)object8;
                ((Map)enumMap4).put(enum_, object9);
            }
            enumMap = enumMap4;
        }
        clazz2 = enumMap;
        n7 = ((ByteBuffer)object).get();
        HE.f f2 = IE.a((byte)n7) ? this.w((ByteBuffer)object) : null;
        byte by2 = ((ByteBuffer)object).get();
        n7 = by2;
        object = IE.a(by2) ? ID.s((ByteBuffer)object) : null;
        return new HE(n3, (hb_0)object4, n4, (hb_0)object5, (HL)pair.getFirst(), enumMap3, k2, (EnumMap<HE.b, HE.l>)object2, a2, (HE.i)object3, j2, (EnumMap<HE.c, HE.d>)((Object)clazz2), f2, (HE.g)object, ((Number)pair.getSecond()).doubleValue());
    }

    private static void a(int n2, ByteBuffer byteBuffer) {
        byteBuffer.putInt(n2);
    }

    private static int u(ByteBuffer byteBuffer) {
        return byteBuffer.getInt();
    }

    public static void a(hb_0 hb_02, ByteBuffer byteBuffer) {
        hb_0 hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.a.x());
        hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.a.y());
        hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.a.z());
        hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.b.w());
        hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.b.x());
        hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.b.y());
        hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.b.z());
    }

    public static hb_0 j(ByteBuffer byteBuffer) {
        double d2 = byteBuffer.getDouble();
        double d3 = byteBuffer.getDouble();
        double d4 = byteBuffer.getDouble();
        double d5 = byteBuffer.getDouble();
        double d6 = byteBuffer.getDouble();
        double d7 = byteBuffer.getDouble();
        double d8 = byteBuffer.getDouble();
        return new hb_0(new Vector3d(d2, d3, d4), new Quaterniond(d6, d7, d8, d5));
    }

    private static void a(HL hL, ByteBuffer byteBuffer) {
        HL hL2 = hL;
        byteBuffer.putFloat(hL2.a);
        hL2 = hL;
        byteBuffer.putFloat(hL2.b);
    }

    private static HL v(ByteBuffer byteBuffer) {
        float f2 = byteBuffer.getFloat();
        float f3 = byteBuffer.getFloat();
        return new HL(f2, f3);
    }

    public static void a(HE.k k2, ByteBuffer byteBuffer) {
        HE.k k3 = k2;
        byteBuffer.putFloat(k3.a);
        k3 = k2;
        boolean bl = k3.b != null;
        byteBuffer.put(IE.a(bl));
        HE.k k4 = k2;
        Float f2 = k4.b;
        if (f2 != null) {
            float f3 = ((Number)f2).floatValue();
            byteBuffer.putFloat(f3);
        }
        HE.k k5 = k2;
        boolean bl2 = k5.c != null;
        byteBuffer.put(IE.a(bl2));
        HE.k k6 = k2;
        Float f4 = k6.c;
        if (f4 == null) {
            return;
        }
        float f5 = ((Number)f4).floatValue();
        byteBuffer.putFloat(f5);
    }

    public static HE.k k(ByteBuffer byteBuffer) {
        float f2 = byteBuffer.getFloat();
        byte by = byteBuffer.get();
        Float f3 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        byteBuffer = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        return new HE.k(f2, f3, (Float)((Object)byteBuffer));
    }

    public static void a(HE.l l2, ByteBuffer byteBuffer) {
        HE.l l3 = l2;
        byteBuffer.putFloat(l3.a);
        l3 = l2;
        byteBuffer.putFloat(l3.b);
        l3 = l2;
        boolean bl = l3.c != null;
        byteBuffer.put(IE.a(bl));
        HE.l l4 = l2;
        Float f2 = l4.c;
        if (f2 != null) {
            float f3 = ((Number)f2).floatValue();
            byteBuffer.putFloat(f3);
        }
        HE.l l5 = l2;
        boolean bl2 = l5.d != null;
        byteBuffer.put(IE.a(bl2));
        HE.l l6 = l2;
        Float f4 = l6.d;
        if (f4 != null) {
            float f5 = ((Number)f4).floatValue();
            byteBuffer.putFloat(f5);
        }
        HE.l l7 = l2;
        boolean bl3 = l7.e != null;
        byteBuffer.put(IE.a(bl3));
        HE.l l8 = l2;
        Float f6 = l8.e;
        if (f6 != null) {
            float f7 = ((Number)f6).floatValue();
            byteBuffer.putFloat(f7);
        }
        HE.l l9 = l2;
        boolean bl4 = l9.f != null;
        byteBuffer.put(IE.a(bl4));
        HE.l l10 = l2;
        Float f8 = l10.f;
        if (f8 == null) {
            return;
        }
        float f9 = ((Number)f8).floatValue();
        byteBuffer.putFloat(f9);
    }

    public static HE.l l(ByteBuffer byteBuffer) {
        float f2 = byteBuffer.getFloat();
        float f3 = byteBuffer.getFloat();
        byte by = byteBuffer.get();
        Float f4 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        Float f5 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        Float f6 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        byteBuffer = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        return new HE.l(f2, f3, f4, f5, f6, (Float)((Object)byteBuffer));
    }

    public static void a(HE.a a2, ByteBuffer byteBuffer) {
        HE.a a3 = a2;
        byteBuffer.putFloat(a3.a);
        a3 = a2;
        byteBuffer.putFloat(a3.b);
        a3 = a2;
        boolean bl = a3.c != null;
        byteBuffer.put(IE.a(bl));
        HE.a a4 = a2;
        Float f2 = a4.c;
        if (f2 != null) {
            float f3 = ((Number)f2).floatValue();
            byteBuffer.putFloat(f3);
        }
        HE.a a5 = a2;
        boolean bl2 = a5.d != null;
        byteBuffer.put(IE.a(bl2));
        HE.a a6 = a2;
        Float f4 = a6.d;
        if (f4 != null) {
            float f5 = ((Number)f4).floatValue();
            byteBuffer.putFloat(f5);
        }
        HE.a a7 = a2;
        boolean bl3 = a7.e != null;
        byteBuffer.put(IE.a(bl3));
        HE.a a8 = a2;
        Float f6 = a8.e;
        if (f6 != null) {
            float f7 = ((Number)f6).floatValue();
            byteBuffer.putFloat(f7);
        }
        HE.a a9 = a2;
        boolean bl4 = a9.f != null;
        byteBuffer.put(IE.a(bl4));
        HE.a a10 = a2;
        Float f8 = a10.f;
        if (f8 == null) {
            return;
        }
        float f9 = ((Number)f8).floatValue();
        byteBuffer.putFloat(f9);
    }

    public static HE.a m(ByteBuffer byteBuffer) {
        float f2 = byteBuffer.getFloat();
        float f3 = byteBuffer.getFloat();
        byte by = byteBuffer.get();
        Float f4 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        Float f5 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        Float f6 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        byteBuffer = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        return new HE.a(f2, f3, f4, f5, f6, (Float)((Object)byteBuffer));
    }

    public static void a(HE.i i2, ByteBuffer byteBuffer) {
        HE.i i3 = i2;
        byteBuffer.putFloat(i3.a);
        i3 = i2;
        byteBuffer.putFloat(i3.b);
        i3 = i2;
        boolean bl = i3.c != null;
        byteBuffer.put(IE.a(bl));
        HE.i i4 = i2;
        Float f2 = i4.c;
        if (f2 != null) {
            float f3 = ((Number)f2).floatValue();
            byteBuffer.putFloat(f3);
        }
        HE.i i5 = i2;
        boolean bl2 = i5.d != null;
        byteBuffer.put(IE.a(bl2));
        HE.i i6 = i2;
        Float f4 = i6.d;
        if (f4 != null) {
            float f5 = ((Number)f4).floatValue();
            byteBuffer.putFloat(f5);
        }
        HE.i i7 = i2;
        boolean bl3 = i7.e != null;
        byteBuffer.put(IE.a(bl3));
        HE.i i8 = i2;
        Float f6 = i8.e;
        if (f6 != null) {
            float f7 = ((Number)f6).floatValue();
            byteBuffer.putFloat(f7);
        }
        HE.i i9 = i2;
        boolean bl4 = i9.f != null;
        byteBuffer.put(IE.a(bl4));
        HE.i i10 = i2;
        Float f8 = i10.f;
        if (f8 == null) {
            return;
        }
        float f9 = ((Number)f8).floatValue();
        byteBuffer.putFloat(f9);
    }

    public static HE.i n(ByteBuffer byteBuffer) {
        float f2 = byteBuffer.getFloat();
        float f3 = byteBuffer.getFloat();
        byte by = byteBuffer.get();
        Float f4 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        Float f5 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        Float f6 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        byteBuffer = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        return new HE.i(f2, f3, f4, f5, f6, (Float)((Object)byteBuffer));
    }

    public static void a(HE.j j2, ByteBuffer byteBuffer) {
        HE.j j3 = j2;
        byteBuffer.putFloat(j3.a);
        j3 = j2;
        byteBuffer.putFloat(j3.b);
        j3 = j2;
        byteBuffer.putFloat(j3.c);
        j3 = j2;
        byteBuffer.putFloat(j3.d);
        j3 = j2;
        boolean bl = j3.e != null;
        byteBuffer.put(IE.a(bl));
        HE.j j4 = j2;
        Float f2 = j4.e;
        if (f2 != null) {
            float f3 = ((Number)f2).floatValue();
            byteBuffer.putFloat(f3);
        }
        HE.j j5 = j2;
        boolean bl2 = j5.f != null;
        byteBuffer.put(IE.a(bl2));
        HE.j j6 = j2;
        Float f4 = j6.f;
        if (f4 != null) {
            float f5 = ((Number)f4).floatValue();
            byteBuffer.putFloat(f5);
        }
        HE.j j7 = j2;
        boolean bl3 = j7.g != null;
        byteBuffer.put(IE.a(bl3));
        HE.j j8 = j2;
        Float f6 = j8.g;
        if (f6 != null) {
            float f7 = ((Number)f6).floatValue();
            byteBuffer.putFloat(f7);
        }
        HE.j j9 = j2;
        boolean bl4 = j9.h != null;
        byteBuffer.put(IE.a(bl4));
        HE.j j10 = j2;
        Float f8 = j10.h;
        if (f8 == null) {
            return;
        }
        float f9 = ((Number)f8).floatValue();
        byteBuffer.putFloat(f9);
    }

    public static HE.j o(ByteBuffer byteBuffer) {
        float f2 = byteBuffer.getFloat();
        float f3 = byteBuffer.getFloat();
        float f4 = byteBuffer.getFloat();
        float f5 = byteBuffer.getFloat();
        byte by = byteBuffer.get();
        Float f6 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        Float f7 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        Float f8 = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        by = byteBuffer.get();
        byteBuffer = IE.a(by) ? Float.valueOf(byteBuffer.getFloat()) : null;
        return new HE.j(f2, f3, f4, f5, f6, f7, f8, (Float)((Object)byteBuffer));
    }

    public static void a(HE.h h2, ByteBuffer byteBuffer) {
        HE.h h3 = h2;
        byteBuffer.putInt(h3.a);
        h3 = h2;
        byteBuffer.putInt(h3.b);
    }

    public static HE.h p(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.getInt();
        int n3 = byteBuffer.getInt();
        return new HE.h(n2, n3);
    }

    public static void a(HN.a a2, ByteBuffer byteBuffer) {
        HN.a a3 = a2;
        byteBuffer.putInt(a3.a);
        a3 = a2;
        byteBuffer.putInt(a3.b);
        a3 = a2;
        byteBuffer.putFloat(a3.c);
    }

    public static HN.a q(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.getInt();
        int n3 = byteBuffer.getInt();
        float f2 = byteBuffer.getFloat();
        return new HN.a(n2, n3, f2);
    }

    private static void a(HE.d d2, ByteBuffer byteBuffer) {
        HE.d d3 = d2;
        byteBuffer.putFloat(d3.a);
        d3 = d2;
        byteBuffer.putFloat(d3.b);
        d3 = d2;
        byteBuffer.putFloat(d3.c);
        d3 = d2;
        boolean bl = d3.d;
        byteBuffer.put(IE.a(bl));
    }

    public static HE.d r(ByteBuffer byteBuffer) {
        float f2 = byteBuffer.getFloat();
        float f3 = byteBuffer.getFloat();
        float f4 = byteBuffer.getFloat();
        byte bl = byteBuffer.get();
        boolean bl2 = IE.a(bl);
        return new HE.d(f2, f3, f4, bl2);
    }

    private final void a(HE.f f2, ByteBuffer byteBuffer) {
        HE.f f3 = f2;
        ID.a(f3.a, byteBuffer);
        f3 = f2;
        boolean bl = f3.b;
        byteBuffer.put(IE.a(bl));
    }

    private final HE.f w(ByteBuffer byteBuffer) {
        hb_0 hb_02 = ID.j(byteBuffer);
        byte bl = byteBuffer.get();
        boolean bl2 = IE.a(bl);
        return new HE.f(hb_02, bl2);
    }

    public static void a(HE.g g2, ByteBuffer byteBuffer) {
        HE.g g3 = g2;
        byteBuffer.putFloat(g3.a.x());
        g3 = g2;
        byteBuffer.putFloat(g3.a.y());
        g3 = g2;
        byteBuffer.putFloat(g3.a.z());
        g3 = g2;
        byteBuffer.putFloat(g3.b.x());
        g3 = g2;
        byteBuffer.putFloat(g3.b.y());
        g3 = g2;
        byteBuffer.putFloat(g3.b.z());
        g3 = g2;
        boolean bl = g3.c;
        byteBuffer.put(IE.a(bl));
    }

    public static HE.g s(ByteBuffer byteBuffer) {
        Vector3f vector3f = new Vector3f(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat());
        Vector3f vector3f2 = new Vector3f(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat());
        byte bl = byteBuffer.get();
        boolean bl2 = IE.a(bl);
        return new HE.g(vector3f, vector3f2, bl2);
    }

    public static void a(HO.a a2, ByteBuffer byteBuffer) {
        HO.a a3 = a2;
        byteBuffer.putFloat(a3.a);
        a3 = a2;
        boolean bl = a3.b;
        byteBuffer.put(IE.a(bl));
    }

    public static HO.a t(ByteBuffer byteBuffer) {
        float f2 = byteBuffer.getFloat();
        byte bl = byteBuffer.get();
        boolean bl2 = IE.a(bl);
        return new HO.a(f2, bl2);
    }

    public static <K extends Enum<K>, V> void a(Map<K, ? extends V> object, ByteBuffer byteBuffer) {
        if (object == null) {
            byteBuffer.put((byte)0);
            return;
        }
        byteBuffer.put((byte)1);
        byteBuffer.putInt(object.size());
        for (Map.Entry entry : object.entrySet()) {
            Map.Entry entry2 = entry;
            entry2 = entry;
            Object object2 = (Enum)entry.getKey();
            entry2 = entry2.getValue();
            byteBuffer.putInt(((Enum)object2).ordinal());
            object2 = entry2;
            if (object2 instanceof HE.e) {
                byteBuffer.putInt(((HE.e)((Object)entry2)).ordinal());
                continue;
            }
            if (object2 instanceof HE.l) {
                ID.a((HE.l)((Object)entry2), byteBuffer);
                continue;
            }
            if (!(object2 instanceof HE.d)) continue;
            ID.a((HE.d)((Object)entry2), byteBuffer);
        }
    }

    private static /* synthetic */ <K extends Enum<K>, V> EnumMap<K, V> x(ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 0) {
            return null;
        }
        int n2 = byteBuffer.getInt();
        Intrinsics.reifiedOperationMarker((int)4, (String)"K");
        EnumMap enumMap = new EnumMap(Enum.class);
        int n3 = 0;
        while (n3 < n2) {
            Object object;
            ++n3;
            Intrinsics.reifiedOperationMarker((int)4, (String)"K");
            Enum enum_ = ((Enum[])Enum.class.getEnumConstants())[byteBuffer.getInt()];
            Intrinsics.reifiedOperationMarker((int)4, (String)"V");
            Object object2 = Object.class;
            if (Intrinsics.areEqual(Object.class, HE.e.class)) {
                object = HE.e.values()[byteBuffer.getInt()];
            } else if (Intrinsics.areEqual(object2, HE.l.class)) {
                object = ID.l(byteBuffer);
            } else if (Intrinsics.areEqual(object2, HE.d.class)) {
                object = ID.r(byteBuffer);
            } else {
                Intrinsics.reifiedOperationMarker((int)4, (String)"V");
                throw new IllegalArgumentException(Intrinsics.stringPlus((String)"Unsupported enum map value type: ", Object.class));
            }
            Intrinsics.reifiedOperationMarker((int)1, (String)"V");
            object2 = object;
            ((Map)enumMap).put(enum_, object2);
        }
        return enumMap;
    }

    private static <K extends Enum<K>> void a(EnumSet<K> object, ByteBuffer byteBuffer) {
        if (object == null) {
            byteBuffer.put((byte)0);
            return;
        }
        byteBuffer.put((byte)1);
        byteBuffer.putInt(((AbstractCollection)object).size());
        object = (Iterable)object;
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            object2 = (Enum)object2;
            byteBuffer.putInt(((Enum)object2).ordinal());
        }
    }

    private static /* synthetic */ <K extends Enum<K>> EnumSet<K> y(ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 0) {
            return null;
        }
        int n2 = byteBuffer.getInt();
        Intrinsics.reifiedOperationMarker((int)4, (String)"K");
        EnumSet<Enum> enumSet = EnumSet.noneOf(Enum.class);
        for (int i2 = 0; i2 < n2; ++i2) {
            Intrinsics.reifiedOperationMarker((int)4, (String)"K");
            Enum enum_ = ((Enum[])Enum.class.getEnumConstants())[byteBuffer.getInt()];
            enumSet.add(enum_);
        }
        return enumSet;
    }
}

