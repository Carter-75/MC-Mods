/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder
 *  net.minecraft.class_1299
 *  net.minecraft.class_1311
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_4048
 *  net.minecraft.class_7923
 */
package net._void.civilizations.entity;

import net._void.civilizations.entity.custom.BossAnubisEntity;
import net._void.civilizations.entity.custom.BossArtemisEntity;
import net._void.civilizations.entity.custom.BossLokiCloneEntity;
import net._void.civilizations.entity.custom.BossLokiEntity;
import net._void.civilizations.entity.custom.BossMercuryEntity;
import net._void.civilizations.entity.custom.BossWukongEntity;
import net._void.civilizations.entity.custom.ChinaBossEntity;
import net._void.civilizations.entity.custom.ChinaCivilianEntity;
import net._void.civilizations.entity.custom.ChinaGuardEntity;
import net._void.civilizations.entity.custom.EgyptBossEntity;
import net._void.civilizations.entity.custom.EgyptCivilianEntity;
import net._void.civilizations.entity.custom.EgyptNpcEntity;
import net._void.civilizations.entity.custom.GreeceBossEntity;
import net._void.civilizations.entity.custom.GreeceCivilianEntity;
import net._void.civilizations.entity.custom.NordicBossEntity;
import net._void.civilizations.entity.custom.NordicCivilianEntity;
import net._void.civilizations.entity.custom.RomeBossEntity;
import net._void.civilizations.entity.custom.RomeCivilianEntity;
import net._void.civilizations.entity.custom.RomeGuardEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_4048;
import net.minecraft.class_7923;

public class ModEntities {
    public static final class_1299<EgyptCivilianEntity> EGYPT_CIVILIAN = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "egypt_civilian"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, EgyptCivilianEntity::new).dimensions(class_4048.method_18385((float)1.0f, (float)2.0f)).build());
    public static final class_1299<EgyptNpcEntity> EGYPT_NPC = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "egypt_npc"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, EgyptNpcEntity::new).dimensions(class_4048.method_18385((float)1.0f, (float)2.0f)).build());
    public static final class_1299<EgyptBossEntity> EGYPT_BOSS = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "egypt_boss"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, EgyptBossEntity::new).dimensions(class_4048.method_18385((float)1.0f, (float)2.0f)).build());
    public static final class_1299<ChinaCivilianEntity> CHINA_CIVILIAN = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "china_civilian"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, ChinaCivilianEntity::new).dimensions(class_4048.method_18385((float)1.0f, (float)2.0f)).build());
    public static final class_1299<ChinaGuardEntity> CHINA_GUARD = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "china_guard"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, ChinaGuardEntity::new).dimensions(class_4048.method_18385((float)1.0f, (float)2.0f)).build());
    public static final class_1299<ChinaBossEntity> CHINA_BOSS = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "china_boss"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, ChinaBossEntity::new).dimensions(class_4048.method_18385((float)1.0f, (float)2.0f)).build());
    public static final class_1299<NordicCivilianEntity> NORDIC_CIVILIAN = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "nordic_civilian"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, NordicCivilianEntity::new).dimensions(class_4048.method_18385((float)1.0f, (float)2.0f)).build());
    public static final class_1299<NordicBossEntity> NORDIC_BOSS = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "nordic_boss"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, NordicBossEntity::new).dimensions(class_4048.method_18385((float)1.0f, (float)2.0f)).build());
    public static final class_1299<GreeceCivilianEntity> GREECE_CIVILIAN = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "greece_civilian"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, GreeceCivilianEntity::new).dimensions(class_4048.method_18385((float)1.0f, (float)2.0f)).build());
    public static final class_1299<GreeceBossEntity> GREECE_BOSS = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "greece_boss"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, GreeceBossEntity::new).dimensions(class_4048.method_18385((float)1.0f, (float)2.0f)).build());
    public static final class_1299<RomeCivilianEntity> ROME_CIVILIAN = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "rome_civilian"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, RomeCivilianEntity::new).dimensions(class_4048.method_18385((float)1.0f, (float)2.0f)).build());
    public static final class_1299<RomeBossEntity> ROME_BOSS = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "rome_boss"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, RomeBossEntity::new).dimensions(class_4048.method_18385((float)1.0f, (float)2.0f)).build());
    public static final class_1299<RomeGuardEntity> ROME_GUARD = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "rome_guard"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, RomeGuardEntity::new).dimensions(class_4048.method_18385((float)1.0f, (float)2.0f)).build());
    public static final class_1299<BossArtemisEntity> BOSS_ARTEMIS = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "boss_artemis"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, BossArtemisEntity::new).dimensions(class_4048.method_18385((float)2.0f, (float)4.0f)).build());
    public static final class_1299<BossAnubisEntity> BOSS_ANUBIS = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "boss_anubis"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, BossAnubisEntity::new).dimensions(class_4048.method_18385((float)2.0f, (float)4.0f)).build());
    public static final class_1299<BossMercuryEntity> BOSS_MERCURY = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "boss_mercury"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, BossMercuryEntity::new).dimensions(class_4048.method_18385((float)2.0f, (float)4.0f)).build());
    public static final class_1299<BossLokiEntity> BOSS_LOKI = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "boss_loki"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, BossLokiEntity::new).dimensions(class_4048.method_18385((float)2.0f, (float)4.0f)).build());
    public static final class_1299<BossLokiCloneEntity> BOSS_LOKI_CLONE = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "boss_loki_clone"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, BossLokiCloneEntity::new).dimensions(class_4048.method_18385((float)2.0f, (float)4.0f)).build());
    public static final class_1299<BossWukongEntity> BOSS_WUKONG = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)new class_2960("civilizations", "boss_wukong"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6294, BossWukongEntity::new).dimensions(class_4048.method_18385((float)2.0f, (float)4.0f)).build());
}

