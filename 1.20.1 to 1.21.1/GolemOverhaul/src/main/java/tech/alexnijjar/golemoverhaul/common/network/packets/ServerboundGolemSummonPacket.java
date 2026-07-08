/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.common.network.Packet
 *  com.teamresourceful.resourcefullib.common.network.base.PacketType
 *  com.teamresourceful.resourcefullib.common.network.base.ServerboundPacketType
 *  com.teamresourceful.resourcefullib.common.network.defaults.DatalessPacketType$Server
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 */
package tech.alexnijjar.golemoverhaul.common.network.packets;

import com.teamresourceful.resourcefullib.common.network.Packet;
import com.teamresourceful.resourcefullib.common.network.base.PacketType;
import com.teamresourceful.resourcefullib.common.network.base.ServerboundPacketType;
import com.teamresourceful.resourcefullib.common.network.defaults.DatalessPacketType;
import java.util.function.Consumer;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.common.entities.golems.NetheriteGolem;

public class ServerboundGolemSummonPacket
implements Packet<ServerboundGolemSummonPacket> {
    public static final ServerboundPacketType<ServerboundGolemSummonPacket> TYPE = new DatalessPacketType.Server<ServerboundGolemSummonPacket>(ServerboundGolemSummonPacket.class, GolemOverhaul.asResource("golem_summon"), ServerboundGolemSummonPacket::new){

        public Consumer<class_1657> handle(ServerboundGolemSummonPacket serverboundGolemSummonPacket) {
            return player -> {
                class_1297 patt0$temp = player.method_5854();
                if (patt0$temp instanceof NetheriteGolem) {
                    NetheriteGolem golem = (NetheriteGolem)patt0$temp;
                    golem.summon();
                }
            };
        }
    };

    public PacketType<ServerboundGolemSummonPacket> type() {
        return TYPE;
    }
}

