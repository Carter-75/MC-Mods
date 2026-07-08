/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.networking.v1.PacketSender
 *  net.minecraft.class_1113
 *  net.minecraft.class_1309
 *  net.minecraft.class_2540
 *  net.minecraft.class_310
 *  net.minecraft.class_3419
 *  net.minecraft.class_634
 */
package net._void.civilizations.networking.packet;

import java.util.HashMap;
import java.util.Map;
import net._void.civilizations.sound.CustomSoundInstance;
import net._void.civilizations.sound.ModSounds;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.class_1113;
import net.minecraft.class_1309;
import net.minecraft.class_2540;
import net.minecraft.class_310;
import net.minecraft.class_3419;
import net.minecraft.class_634;

public class BossMusicPlayS2CPacket {
    private static Map<String, Map<String, CustomSoundInstance>> map = new HashMap<String, Map<String, CustomSoundInstance>>();

    public static void receive(class_310 client, class_634 handler, class_2540 buf, PacketSender sender) {
        if (client.field_1724 == null) {
            return;
        }
        switch (buf.method_19772()) {
            case "EgyptBossPlay": {
                if (!map.containsKey(client.field_1724.method_5845())) {
                    map.put(client.field_1724.method_5845(), (Map<String, CustomSoundInstance>)new HashMap<String, CustomSoundInstance>(){
                        {
                            this.put("EgyptBoss", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.EGYPT_BOSS_MUSIC, class_3419.field_15250));
                        }
                    });
                    break;
                }
                if (!map.get(client.field_1724.method_5845()).containsKey("EgyptBoss")) {
                    map.get(client.field_1724.method_5845()).put("EgyptBoss", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.EGYPT_BOSS_MUSIC, class_3419.field_15250));
                    break;
                }
                if (client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("EgyptBoss"))) break;
                client.method_1483().method_4873((class_1113)map.get(client.field_1724.method_5845()).get("EgyptBoss"));
                break;
            }
            case "EgyptBossStop": {
                if (!map.containsKey(client.field_1724.method_5845()) || !map.get(client.field_1724.method_5845()).containsKey("EgyptBoss") || !client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("EgyptBoss"))) break;
                client.method_1483().method_4870((class_1113)map.get(client.field_1724.method_5845()).get("EgyptBoss"));
                map.get(client.field_1724.method_5845()).remove("EgyptBoss");
                break;
            }
            case "ChinaBossPlay": {
                if (!map.containsKey(client.field_1724.method_5845())) {
                    map.put(client.field_1724.method_5845(), (Map<String, CustomSoundInstance>)new HashMap<String, CustomSoundInstance>(){
                        {
                            this.put("ChinaBoss", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.CHINA_BOSS_MUSIC, class_3419.field_15250));
                        }
                    });
                    break;
                }
                if (!map.get(client.field_1724.method_5845()).containsKey("ChinaBoss")) {
                    map.get(client.field_1724.method_5845()).put("ChinaBoss", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.CHINA_BOSS_MUSIC, class_3419.field_15250));
                    break;
                }
                if (client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("ChinaBoss"))) break;
                client.method_1483().method_4873((class_1113)map.get(client.field_1724.method_5845()).get("ChinaBoss"));
                break;
            }
            case "ChinaBossStop": {
                if (!map.containsKey(client.field_1724.method_5845()) || !map.get(client.field_1724.method_5845()).containsKey("ChinaBoss") || !client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("ChinaBoss"))) break;
                client.method_1483().method_4870((class_1113)map.get(client.field_1724.method_5845()).get("ChinaBoss"));
                map.get(client.field_1724.method_5845()).remove("ChinaBoss");
                break;
            }
            case "NordicBossPlay": {
                if (!map.containsKey(client.field_1724.method_5845())) {
                    map.put(client.field_1724.method_5845(), (Map<String, CustomSoundInstance>)new HashMap<String, CustomSoundInstance>(){
                        {
                            this.put("NordicBoss", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.NORDIC_BOSS_MUSIC, class_3419.field_15250));
                        }
                    });
                    break;
                }
                if (!map.get(client.field_1724.method_5845()).containsKey("NordicBoss")) {
                    map.get(client.field_1724.method_5845()).put("NordicBoss", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.NORDIC_BOSS_MUSIC, class_3419.field_15250));
                    break;
                }
                if (client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("NordicBoss"))) break;
                client.method_1483().method_4873((class_1113)map.get(client.field_1724.method_5845()).get("NordicBoss"));
                break;
            }
            case "NordicBossStop": {
                if (!map.containsKey(client.field_1724.method_5845()) || !map.get(client.field_1724.method_5845()).containsKey("NordicBoss") || !client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("NordicBoss"))) break;
                client.method_1483().method_4870((class_1113)map.get(client.field_1724.method_5845()).get("NordicBoss"));
                map.get(client.field_1724.method_5845()).remove("NordicBoss");
                break;
            }
            case "RomeBossPlay": {
                if (!map.containsKey(client.field_1724.method_5845())) {
                    map.put(client.field_1724.method_5845(), (Map<String, CustomSoundInstance>)new HashMap<String, CustomSoundInstance>(){
                        {
                            this.put("RomeBoss", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.ROME_BOSS_MUSIC, class_3419.field_15250));
                        }
                    });
                    break;
                }
                if (!map.get(client.field_1724.method_5845()).containsKey("RomeBoss")) {
                    map.get(client.field_1724.method_5845()).put("RomeBoss", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.ROME_BOSS_MUSIC, class_3419.field_15250));
                    break;
                }
                if (client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("RomeBoss"))) break;
                client.method_1483().method_4873((class_1113)map.get(client.field_1724.method_5845()).get("RomeBoss"));
                break;
            }
            case "RomeBossStop": {
                if (!map.containsKey(client.field_1724.method_5845()) || !map.get(client.field_1724.method_5845()).containsKey("RomeBoss") || !client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("RomeBoss"))) break;
                client.method_1483().method_4870((class_1113)map.get(client.field_1724.method_5845()).get("RomeBoss"));
                map.get(client.field_1724.method_5845()).remove("RomeBoss");
                break;
            }
            case "GreeceBossPlay": {
                if (!map.containsKey(client.field_1724.method_5845())) {
                    map.put(client.field_1724.method_5845(), (Map<String, CustomSoundInstance>)new HashMap<String, CustomSoundInstance>(){
                        {
                            this.put("EgyptBoss", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.GREECE_BOSS_MUSIC, class_3419.field_15250));
                        }
                    });
                    break;
                }
                if (!map.get(client.field_1724.method_5845()).containsKey("GreeceBoss")) {
                    map.get(client.field_1724.method_5845()).put("GreeceBoss", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.GREECE_BOSS_MUSIC, class_3419.field_15250));
                    break;
                }
                if (client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("GreeceBoss"))) break;
                client.method_1483().method_4873((class_1113)map.get(client.field_1724.method_5845()).get("GreeceBoss"));
                break;
            }
            case "GreeceBossStop": {
                if (!map.containsKey(client.field_1724.method_5845()) || !map.get(client.field_1724.method_5845()).containsKey("GreeceBoss") || !client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("GreeceBoss"))) break;
                client.method_1483().method_4870((class_1113)map.get(client.field_1724.method_5845()).get("GreeceBoss"));
                map.get(client.field_1724.method_5845()).remove("GreeceBoss");
                break;
            }
            case "EgyptGodPlay": {
                if (!map.containsKey(client.field_1724.method_5845())) {
                    map.put(client.field_1724.method_5845(), (Map<String, CustomSoundInstance>)new HashMap<String, CustomSoundInstance>(){
                        {
                            this.put("EgyptBoss", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.EGYPT_GOD_MUSIC, class_3419.field_15250));
                        }
                    });
                    break;
                }
                if (!map.get(client.field_1724.method_5845()).containsKey("EgyptGod")) {
                    map.get(client.field_1724.method_5845()).put("EgyptGod", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.EGYPT_GOD_MUSIC, class_3419.field_15250));
                    break;
                }
                if (client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("EgyptGod"))) break;
                client.method_1483().method_4873((class_1113)map.get(client.field_1724.method_5845()).get("EgyptGod"));
                break;
            }
            case "EgyptGodStop": {
                if (!map.containsKey(client.field_1724.method_5845()) || !map.get(client.field_1724.method_5845()).containsKey("EgyptGod") || !client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("EgyptGod"))) break;
                client.method_1483().method_4870((class_1113)map.get(client.field_1724.method_5845()).get("EgyptGod"));
                map.get(client.field_1724.method_5845()).remove("EgyptGod");
                break;
            }
            case "ChinaGodPlay": {
                if (!map.containsKey(client.field_1724.method_5845())) {
                    map.put(client.field_1724.method_5845(), (Map<String, CustomSoundInstance>)new HashMap<String, CustomSoundInstance>(){
                        {
                            this.put("ChinaGod", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.CHINA_GOD_MUSIC, class_3419.field_15250));
                        }
                    });
                    break;
                }
                if (!map.get(client.field_1724.method_5845()).containsKey("ChinaGod")) {
                    map.get(client.field_1724.method_5845()).put("ChinaGod", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.CHINA_GOD_MUSIC, class_3419.field_15250));
                    break;
                }
                if (client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("ChinaGod"))) break;
                client.method_1483().method_4873((class_1113)map.get(client.field_1724.method_5845()).get("ChinaGod"));
                break;
            }
            case "ChinaGodStop": {
                if (!map.containsKey(client.field_1724.method_5845()) || !map.get(client.field_1724.method_5845()).containsKey("ChinaGod") || !client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("ChinaGod"))) break;
                client.method_1483().method_4870((class_1113)map.get(client.field_1724.method_5845()).get("ChinaGod"));
                map.get(client.field_1724.method_5845()).remove("ChinaGod");
                break;
            }
            case "NordicGodPlay": {
                if (!map.containsKey(client.field_1724.method_5845())) {
                    map.put(client.field_1724.method_5845(), (Map<String, CustomSoundInstance>)new HashMap<String, CustomSoundInstance>(){
                        {
                            this.put("NordicGod", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.NORDIC_GOD_MUSIC, class_3419.field_15250));
                        }
                    });
                    break;
                }
                if (!map.get(client.field_1724.method_5845()).containsKey("NordicGod")) {
                    map.get(client.field_1724.method_5845()).put("NordicGod", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.NORDIC_GOD_MUSIC, class_3419.field_15250));
                    break;
                }
                if (client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("NordicGod"))) break;
                client.method_1483().method_4873((class_1113)map.get(client.field_1724.method_5845()).get("NordicGod"));
                break;
            }
            case "NordicGodStop": {
                if (!map.containsKey(client.field_1724.method_5845()) || !map.get(client.field_1724.method_5845()).containsKey("NordicGod") || !client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("NordicGod"))) break;
                client.method_1483().method_4870((class_1113)map.get(client.field_1724.method_5845()).get("NordicGod"));
                map.get(client.field_1724.method_5845()).remove("NordicGod");
                break;
            }
            case "RomeGodPlay": {
                if (!map.containsKey(client.field_1724.method_5845())) {
                    map.put(client.field_1724.method_5845(), (Map<String, CustomSoundInstance>)new HashMap<String, CustomSoundInstance>(){
                        {
                            this.put("RomeGod", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.ROME_GOD_MUSIC, class_3419.field_15250));
                        }
                    });
                    break;
                }
                if (!map.get(client.field_1724.method_5845()).containsKey("RomeGod")) {
                    map.get(client.field_1724.method_5845()).put("RomeGod", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.ROME_GOD_MUSIC, class_3419.field_15250));
                    break;
                }
                if (client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("RomeGod"))) break;
                client.method_1483().method_4873((class_1113)map.get(client.field_1724.method_5845()).get("RomeGod"));
                break;
            }
            case "RomeGodStop": {
                if (!map.containsKey(client.field_1724.method_5845()) || !map.get(client.field_1724.method_5845()).containsKey("RomeGod") || !client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("RomeGod"))) break;
                client.method_1483().method_4870((class_1113)map.get(client.field_1724.method_5845()).get("RomeGod"));
                map.get(client.field_1724.method_5845()).remove("RomeGod");
                break;
            }
            case "GreeceGodPlay": {
                if (!map.containsKey(client.field_1724.method_5845())) {
                    map.put(client.field_1724.method_5845(), (Map<String, CustomSoundInstance>)new HashMap<String, CustomSoundInstance>(){
                        {
                            this.put("GreeceGod", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.GREECE_GOD_MUSIC, class_3419.field_15250));
                        }
                    });
                    break;
                }
                if (!map.get(client.field_1724.method_5845()).containsKey("GreeceGod")) {
                    map.get(client.field_1724.method_5845()).put("GreeceGod", new CustomSoundInstance((class_1309)class_310.method_1551().field_1724, ModSounds.GREECE_GOD_MUSIC, class_3419.field_15250));
                    break;
                }
                if (client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("GreeceGod"))) break;
                client.method_1483().method_4873((class_1113)map.get(client.field_1724.method_5845()).get("GreeceGod"));
                break;
            }
            case "GreeceGodStop": {
                if (!map.containsKey(client.field_1724.method_5845()) || !map.get(client.field_1724.method_5845()).containsKey("GreeceGod") || !client.method_1483().method_4877((class_1113)map.get(client.field_1724.method_5845()).get("GreeceGod"))) break;
                client.method_1483().method_4870((class_1113)map.get(client.field_1724.method_5845()).get("GreeceGod"));
                map.get(client.field_1724.method_5845()).remove("GreeceGod");
            }
        }
    }
}

