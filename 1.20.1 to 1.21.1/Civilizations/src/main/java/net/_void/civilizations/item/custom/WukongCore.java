/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1269
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1836
 *  net.minecraft.class_1838
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2561
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  org.jetbrains.annotations.Nullable
 */
package net._void.civilizations.item.custom;

import java.util.List;
import net._void.civilizations.entity.custom.BossWukongEntity;
import net._void.civilizations.item.ModItems;
import net.minecraft.class_1269;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1838;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2561;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import org.jetbrains.annotations.Nullable;

public class WukongCore
extends class_1792 {
    private int tick = -1;
    private int spawnTick = -1;
    private int x;
    private int y;
    private int z;

    public WukongCore(class_1792.class_1793 settings) {
        super(settings);
    }

    public void method_7851(class_1799 stack, @Nullable class_1937 world, List<class_2561> tooltip, class_1836 context) {
        tooltip.add((class_2561)class_2561.method_43471((String)"tooltip.civilizations.wukong_core"));
        super.method_7851(stack, world, tooltip, context);
    }

    public class_1269 method_7884(class_1838 context) {
        class_1269 r = class_1269.field_5814;
        if (!context.method_8045().method_8608()) {
            this.tick = 0;
            this.x = context.method_8037().method_10263();
            this.y = context.method_8037().method_10264();
            this.z = context.method_8037().method_10260();
            if (context.method_8036() != null) {
                context.method_8036().method_7357().method_7906((class_1792)this, 3000);
            }
            r = class_1269.field_5812;
        }
        return r;
    }

    public void method_7888(class_1799 stack, class_1937 world, class_1297 entity, int slot, boolean selected) {
        if (!world.method_8608()) {
            int n;
            class_1657 player;
            int j;
            int i;
            if (this.tick == 0) {
                for (i = -2; i <= 2; ++i) {
                    for (j = -2; j <= 2; ++j) {
                        for (int k = 1; k <= 5; ++k) {
                            world.method_8501(new class_2338(this.x + i, this.y + k, this.z + j), class_2246.field_10124.method_9564());
                        }
                    }
                }
            }
            if (this.tick >= 0) {
                ++this.tick;
            }
            if (this.spawnTick >= 0) {
                ++this.spawnTick;
            }
            if (this.tick == 10) {
                ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)this.x + 0.5, (double)(this.y + 1), (double)this.z + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
            }
            if (this.tick == 20) {
                ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)this.x + 0.5, (double)(this.y + 1), (double)this.z + 0.5, 10, 0.0, 0.0, 0.0, 1.0);
                for (i = -1; i <= 1; i += 2) {
                    ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)(this.x + i) + 0.5, (double)(this.y + 1), (double)this.z + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                    ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)this.x + 0.5, (double)(this.y + 1), (double)(this.z + i) + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                }
            }
            if (this.tick == 30) {
                ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)this.x + 0.5, (double)(this.y + 1), (double)this.z + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                for (i = -1; i <= 1; i += 2) {
                    ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)(this.x + i) + 0.5, (double)(this.y + 1), (double)this.z + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                    ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)this.x + 0.5, (double)(this.y + 1), (double)(this.z + i) + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                }
                for (i = -1; i <= 1; i += 2) {
                    for (j = -1; j <= 1; j += 2) {
                        ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)(this.x + i) + 0.5, (double)(this.y + 1), (double)(this.z + j) + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                    }
                }
                world.method_8501(new class_2338(this.x, this.y + 1, this.z), class_2246.field_10068.method_9564());
            }
            if (this.tick == 40) {
                ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)this.x + 0.5, (double)(this.y + 1), (double)this.z + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                for (i = -1; i <= 1; i += 2) {
                    ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)(this.x + i) + 0.5, (double)(this.y + 1), (double)this.z + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                    ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)this.x + 0.5, (double)(this.y + 1), (double)(this.z + i) + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                }
                for (i = -1; i <= 1; i += 2) {
                    for (j = -1; j <= 1; j += 2) {
                        ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)(this.x + i) + 0.5, (double)(this.y + 1), (double)(this.z + j) + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                    }
                }
                for (i = -2; i <= 2; i += 4) {
                    for (j = -1; j <= 1; ++j) {
                        ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)(this.x + i) + 0.5, (double)(this.y + 1), (double)(this.z + j) + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                        ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)(this.x + j) + 0.5, (double)(this.y + 1), (double)(this.z + i) + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                    }
                }
                for (i = -1; i <= 1; i += 2) {
                    world.method_8501(new class_2338(this.x + i, this.y + 1, this.z), class_2246.field_22109.method_9564());
                    world.method_8501(new class_2338(this.x, this.y + 1, this.z + i), class_2246.field_22109.method_9564());
                }
            }
            if (this.tick == 50) {
                for (i = -2; i <= 2; ++i) {
                    for (j = -2; j <= 2; ++j) {
                        ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)(this.x + j) + 0.5, (double)(this.y + 1), (double)(this.z + i) + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                    }
                }
                for (i = -1; i <= 1; i += 2) {
                    for (j = -1; j <= 1; j += 2) {
                        world.method_8501(new class_2338(this.x + i, this.y + 1, this.z + j), class_2246.field_10272.method_9564());
                        world.method_8501(new class_2338(this.x + i, this.y, this.z + j), class_2246.field_10164.method_9564());
                    }
                }
            }
            if (this.tick == 60) {
                for (i = -2; i <= 2; ++i) {
                    for (j = -2; j <= 2; ++j) {
                        ((class_3218)world).method_14199((class_2394)class_2398.field_11207, (double)(this.x + j) + 0.5, (double)(this.y + 1), (double)(this.z + i) + 0.5, 5, 0.0, 0.0, 0.0, 1.0);
                    }
                }
                for (i = -2; i <= 2; i += 4) {
                    for (j = -1; j <= 1; ++j) {
                        world.method_8501(new class_2338(this.x + i, this.y + 1, this.z + j), class_2246.field_10478.method_9564());
                        world.method_8501(new class_2338(this.x + j, this.y + 1, this.z + i), class_2246.field_10478.method_9564());
                        world.method_8501(new class_2338(this.x + i, this.y, this.z + j), class_2246.field_9986.method_9564());
                        world.method_8501(new class_2338(this.x + j, this.y, this.z + i), class_2246.field_9986.method_9564());
                    }
                }
            }
            if (this.tick == 80 && entity instanceof class_1657) {
                class_1657 player2 = (class_1657)entity;
                player2.method_6092(new class_1293(class_1294.field_5902, 600, 11, false, false));
                player2.method_6092(new class_1293(class_1294.field_5912, 600, 0, false, false));
                for (class_1657 player22 : world.method_18456()) {
                    if (!(player2.method_5858((class_1297)player22) <= 100.0) || player2.equals((Object)player22)) continue;
                    player22.method_6092(new class_1293(class_1294.field_5902, 600, 12, false, false));
                    player22.method_6092(new class_1293(class_1294.field_5912, 600, 0, false, false));
                }
            }
            if (entity instanceof class_1657 && (player = (class_1657)entity).method_23318() >= 202.0 && player.method_6059(class_1294.field_5902)) {
                player.method_26082(new class_1293(class_1294.field_5902, 0, 0), (class_1297)player);
                player.method_26082(new class_1293(class_1294.field_5912, 0, 0), (class_1297)player);
                for (class_1657 player2 : world.method_18456()) {
                    if (!(player.method_5858((class_1297)player2) <= 900.0) || player.equals((Object)player2)) continue;
                    player2.method_26082(new class_1293(class_1294.field_5902, 0, 0), (class_1297)player);
                    player2.method_26082(new class_1293(class_1294.field_5912, 0, 0), (class_1297)player);
                    player2.method_6092(new class_1293(class_1294.field_5906, 100, 0, false, false));
                }
                this.spawnTick = 0;
                for (double i2 = -50.0; i2 <= 100.0; i2 += 1.0) {
                    block78: for (double j2 = -50.0; j2 <= 100.0; j2 += 1.0) {
                        if (!(Math.pow(i2, 2.0) + Math.pow(j2, 2.0) <= Math.pow(35.0, 2.0))) continue;
                        int n2 = (int)(Math.random() * 4.0 + 1.0);
                        switch (n2) {
                            case 1: {
                                world.method_8501(new class_2338(this.x + (int)i2, 200, this.z + (int)j2), class_2246.field_9986.method_9564());
                                continue block78;
                            }
                            case 2: {
                                world.method_8501(new class_2338(this.x + (int)i2, 200, this.z + (int)j2), class_2246.field_10541.method_9564());
                                continue block78;
                            }
                            case 3: {
                                world.method_8501(new class_2338(this.x + (int)i2, 200, this.z + (int)j2), class_2246.field_22120.method_9564());
                                continue block78;
                            }
                            case 4: {
                                world.method_8501(new class_2338(this.x + (int)i2, 200, this.z + (int)j2), class_2246.field_10515.method_9564());
                            }
                        }
                    }
                }
            }
            if (this.spawnTick == 60) {
                BossWukongEntity customEntity = (BossWukongEntity)((class_1299)class_1299.method_5898((String)"civilizations:boss_wukong").get()).method_5883(world);
                customEntity.method_30634((double)this.x + 0.5, 201.0, (double)this.z + 0.5);
                customEntity.setCoords(this.x, this.y, this.z);
                world.method_8649((class_1297)customEntity);
                if (entity instanceof class_1657) {
                    class_1657 player3 = (class_1657)entity;
                    player3.method_31548().method_5447(slot, new class_1799((class_1935)ModItems.CHINA_CORE));
                }
            }
            if (this.tick == 100) {
                for (double i3 = -50.0; i3 <= 100.0; i3 += 1.0) {
                    block80: for (double j3 = -50.0; j3 <= 100.0; j3 += 1.0) {
                        if (!(Math.pow(i3, 2.0) + Math.pow(j3, 2.0) >= Math.pow(31.0, 2.0)) || !(Math.pow(i3, 2.0) + Math.pow(j3, 2.0) <= Math.pow(35.0, 2.0))) continue;
                        n = (int)(Math.random() * 4.0 + 1.0);
                        switch (n) {
                            case 1: {
                                world.method_8501(new class_2338(this.x + (int)i3, 200, this.z + (int)j3), class_2246.field_9986.method_9564());
                                continue block80;
                            }
                            case 2: {
                                world.method_8501(new class_2338(this.x + (int)i3, 200, this.z + (int)j3), class_2246.field_10541.method_9564());
                                continue block80;
                            }
                            case 3: {
                                world.method_8501(new class_2338(this.x + (int)i3, 200, this.z + (int)j3), class_2246.field_22120.method_9564());
                                continue block80;
                            }
                            case 4: {
                                world.method_8501(new class_2338(this.x + (int)i3, 200, this.z + (int)j3), class_2246.field_10515.method_9564());
                                if ((int)(Math.random() * 3.0 + 1.0) != 1) continue block80;
                                world.method_8501(new class_2338(this.x + (int)i3, 201, this.z + (int)j3), class_2246.field_10036.method_9564());
                            }
                        }
                    }
                }
            }
            if (this.tick == 130) {
                for (double i4 = -50.0; i4 <= 100.0; i4 += 1.0) {
                    block82: for (double j4 = -50.0; j4 <= 100.0; j4 += 1.0) {
                        if (!(Math.pow(i4, 2.0) + Math.pow(j4, 2.0) >= Math.pow(27.0, 2.0)) || !(Math.pow(i4, 2.0) + Math.pow(j4, 2.0) <= Math.pow(31.0, 2.0))) continue;
                        n = (int)(Math.random() * 4.0 + 1.0);
                        switch (n) {
                            case 1: {
                                world.method_8501(new class_2338(this.x + (int)i4, 200, this.z + (int)j4), class_2246.field_9986.method_9564());
                                continue block82;
                            }
                            case 2: {
                                world.method_8501(new class_2338(this.x + (int)i4, 200, this.z + (int)j4), class_2246.field_10541.method_9564());
                                continue block82;
                            }
                            case 3: {
                                world.method_8501(new class_2338(this.x + (int)i4, 200, this.z + (int)j4), class_2246.field_22120.method_9564());
                                continue block82;
                            }
                            case 4: {
                                world.method_8501(new class_2338(this.x + (int)i4, 200, this.z + (int)j4), class_2246.field_10515.method_9564());
                                if ((int)(Math.random() * 3.0 + 1.0) != 1) continue block82;
                                world.method_8501(new class_2338(this.x + (int)i4, 201, this.z + (int)j4), class_2246.field_10036.method_9564());
                            }
                        }
                    }
                }
            }
            if (this.tick == 160) {
                for (double i5 = -50.0; i5 <= 100.0; i5 += 1.0) {
                    block84: for (double j5 = -50.0; j5 <= 100.0; j5 += 1.0) {
                        if (!(Math.pow(i5, 2.0) + Math.pow(j5, 2.0) >= Math.pow(23.0, 2.0)) || !(Math.pow(i5, 2.0) + Math.pow(j5, 2.0) <= Math.pow(27.0, 2.0))) continue;
                        n = (int)(Math.random() * 4.0 + 1.0);
                        switch (n) {
                            case 1: {
                                world.method_8501(new class_2338(this.x + (int)i5, 200, this.z + (int)j5), class_2246.field_9986.method_9564());
                                continue block84;
                            }
                            case 2: {
                                world.method_8501(new class_2338(this.x + (int)i5, 200, this.z + (int)j5), class_2246.field_10541.method_9564());
                                continue block84;
                            }
                            case 3: {
                                world.method_8501(new class_2338(this.x + (int)i5, 200, this.z + (int)j5), class_2246.field_22120.method_9564());
                                continue block84;
                            }
                            case 4: {
                                world.method_8501(new class_2338(this.x + (int)i5, 200, this.z + (int)j5), class_2246.field_10515.method_9564());
                                if ((int)(Math.random() * 3.0 + 1.0) != 1) continue block84;
                                world.method_8501(new class_2338(this.x + (int)i5, 201, this.z + (int)j5), class_2246.field_10036.method_9564());
                            }
                        }
                    }
                }
            }
            if (this.tick == 190) {
                for (double i6 = -50.0; i6 <= 100.0; i6 += 1.0) {
                    block86: for (double j6 = -50.0; j6 <= 100.0; j6 += 1.0) {
                        if (!(Math.pow(i6, 2.0) + Math.pow(j6, 2.0) >= Math.pow(19.0, 2.0)) || !(Math.pow(i6, 2.0) + Math.pow(j6, 2.0) <= Math.pow(23.0, 2.0))) continue;
                        n = (int)(Math.random() * 4.0 + 1.0);
                        switch (n) {
                            case 1: {
                                world.method_8501(new class_2338(this.x + (int)i6, 200, this.z + (int)j6), class_2246.field_9986.method_9564());
                                continue block86;
                            }
                            case 2: {
                                world.method_8501(new class_2338(this.x + (int)i6, 200, this.z + (int)j6), class_2246.field_10541.method_9564());
                                continue block86;
                            }
                            case 3: {
                                world.method_8501(new class_2338(this.x + (int)i6, 200, this.z + (int)j6), class_2246.field_22120.method_9564());
                                continue block86;
                            }
                            case 4: {
                                world.method_8501(new class_2338(this.x + (int)i6, 200, this.z + (int)j6), class_2246.field_10515.method_9564());
                                if ((int)(Math.random() * 3.0 + 1.0) != 1) continue block86;
                                world.method_8501(new class_2338(this.x + (int)i6, 201, this.z + (int)j6), class_2246.field_10036.method_9564());
                            }
                        }
                    }
                }
            }
            if (this.tick == 210) {
                for (double i7 = -50.0; i7 <= 100.0; i7 += 1.0) {
                    block88: for (double j7 = -50.0; j7 <= 100.0; j7 += 1.0) {
                        if (!(Math.pow(i7, 2.0) + Math.pow(j7, 2.0) >= Math.pow(15.0, 2.0)) || !(Math.pow(i7, 2.0) + Math.pow(j7, 2.0) <= Math.pow(19.0, 2.0))) continue;
                        n = (int)(Math.random() * 4.0 + 1.0);
                        switch (n) {
                            case 1: {
                                world.method_8501(new class_2338(this.x + (int)i7, 200, this.z + (int)j7), class_2246.field_9986.method_9564());
                                continue block88;
                            }
                            case 2: {
                                world.method_8501(new class_2338(this.x + (int)i7, 200, this.z + (int)j7), class_2246.field_10541.method_9564());
                                continue block88;
                            }
                            case 3: {
                                world.method_8501(new class_2338(this.x + (int)i7, 200, this.z + (int)j7), class_2246.field_22120.method_9564());
                                continue block88;
                            }
                            case 4: {
                                world.method_8501(new class_2338(this.x + (int)i7, 200, this.z + (int)j7), class_2246.field_10515.method_9564());
                                if ((int)(Math.random() * 3.0 + 1.0) != 1) continue block88;
                                world.method_8501(new class_2338(this.x + (int)i7, 201, this.z + (int)j7), class_2246.field_10036.method_9564());
                            }
                        }
                    }
                }
            }
            if (this.tick == 240) {
                for (double i8 = -50.0; i8 <= 100.0; i8 += 1.0) {
                    block90: for (double j8 = -50.0; j8 <= 100.0; j8 += 1.0) {
                        if (!(Math.pow(i8, 2.0) + Math.pow(j8, 2.0) >= Math.pow(11.0, 2.0)) || !(Math.pow(i8, 2.0) + Math.pow(j8, 2.0) <= Math.pow(15.0, 2.0))) continue;
                        n = (int)(Math.random() * 4.0 + 1.0);
                        switch (n) {
                            case 1: {
                                world.method_8501(new class_2338(this.x + (int)i8, 200, this.z + (int)j8), class_2246.field_9986.method_9564());
                                continue block90;
                            }
                            case 2: {
                                world.method_8501(new class_2338(this.x + (int)i8, 200, this.z + (int)j8), class_2246.field_10541.method_9564());
                                continue block90;
                            }
                            case 3: {
                                world.method_8501(new class_2338(this.x + (int)i8, 200, this.z + (int)j8), class_2246.field_22120.method_9564());
                                continue block90;
                            }
                            case 4: {
                                world.method_8501(new class_2338(this.x + (int)i8, 200, this.z + (int)j8), class_2246.field_10515.method_9564());
                                if ((int)(Math.random() * 3.0 + 1.0) != 1) continue block90;
                                world.method_8501(new class_2338(this.x + (int)i8, 201, this.z + (int)j8), class_2246.field_10036.method_9564());
                            }
                        }
                    }
                }
            }
            if (this.tick == 270) {
                for (double i9 = -50.0; i9 <= 100.0; i9 += 1.0) {
                    block92: for (double j9 = -50.0; j9 <= 100.0; j9 += 1.0) {
                        if (!(Math.pow(i9, 2.0) + Math.pow(j9, 2.0) >= Math.pow(7.0, 2.0)) || !(Math.pow(i9, 2.0) + Math.pow(j9, 2.0) <= Math.pow(11.0, 2.0))) continue;
                        n = (int)(Math.random() * 4.0 + 1.0);
                        switch (n) {
                            case 1: {
                                world.method_8501(new class_2338(this.x + (int)i9, 200, this.z + (int)j9), class_2246.field_9986.method_9564());
                                continue block92;
                            }
                            case 2: {
                                world.method_8501(new class_2338(this.x + (int)i9, 200, this.z + (int)j9), class_2246.field_10541.method_9564());
                                continue block92;
                            }
                            case 3: {
                                world.method_8501(new class_2338(this.x + (int)i9, 200, this.z + (int)j9), class_2246.field_22120.method_9564());
                                continue block92;
                            }
                            case 4: {
                                world.method_8501(new class_2338(this.x + (int)i9, 200, this.z + (int)j9), class_2246.field_10515.method_9564());
                                if ((int)(Math.random() * 3.0 + 1.0) != 1) continue block92;
                                world.method_8501(new class_2338(this.x + (int)i9, 201, this.z + (int)j9), class_2246.field_10036.method_9564());
                            }
                        }
                    }
                }
            }
            if (this.tick == 300) {
                for (double i10 = -50.0; i10 <= 100.0; i10 += 1.0) {
                    block94: for (double j10 = -50.0; j10 <= 100.0; j10 += 1.0) {
                        if (!(Math.pow(i10, 2.0) + Math.pow(j10, 2.0) >= Math.pow(5.0, 2.0)) || !(Math.pow(i10, 2.0) + Math.pow(j10, 2.0) <= Math.pow(7.0, 2.0))) continue;
                        n = (int)(Math.random() * 4.0 + 1.0);
                        switch (n) {
                            case 1: {
                                world.method_8501(new class_2338(this.x + (int)i10, 200, this.z + (int)j10), class_2246.field_9986.method_9564());
                                continue block94;
                            }
                            case 2: {
                                world.method_8501(new class_2338(this.x + (int)i10, 200, this.z + (int)j10), class_2246.field_10541.method_9564());
                                continue block94;
                            }
                            case 3: {
                                world.method_8501(new class_2338(this.x + (int)i10, 200, this.z + (int)j10), class_2246.field_22120.method_9564());
                                continue block94;
                            }
                            case 4: {
                                world.method_8501(new class_2338(this.x + (int)i10, 200, this.z + (int)j10), class_2246.field_10515.method_9564());
                                if ((int)(Math.random() * 3.0 + 1.0) != 1) continue block94;
                                world.method_8501(new class_2338(this.x + (int)i10, 201, this.z + (int)j10), class_2246.field_10036.method_9564());
                            }
                        }
                    }
                }
            }
        } else {
            class_1657 player;
            if (this.tick == 1 && entity instanceof class_1657) {
                player = (class_1657)entity;
                player.method_5783(class_3417.field_15045, 1.0f, 1.0f);
            }
            if (this.tick == 60 && entity instanceof class_1657) {
                player = (class_1657)entity;
                player.method_5783(class_3417.field_14981, 1.0f, 1.0f);
            }
        }
        super.method_7888(stack, world, entity, slot, selected);
    }
}

