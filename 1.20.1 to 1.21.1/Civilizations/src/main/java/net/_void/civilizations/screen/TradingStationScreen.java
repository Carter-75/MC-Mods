/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
 *  net.fabricmc.fabric.api.networking.v1.PacketByteBufs
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_2540
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_332
 *  net.minecraft.class_364
 *  net.minecraft.class_465
 *  net.minecraft.class_757
 */
package net._void.civilizations.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import java.util.Objects;
import net._void.civilizations.networking.ModMessages;
import net._void.civilizations.screen.TradingStationScreenHandler;
import net._void.civilizations.util.CustomWidget;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_2540;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_364;
import net.minecraft.class_465;
import net.minecraft.class_757;

public class TradingStationScreen
extends class_465<TradingStationScreenHandler> {
    private static final class_2960 TEXTURE = new class_2960("civilizations", "textures/gui/trade_menu.png");
    private static final class_2960 haybale = new class_2960("minecraft", "textures/block/hay_block_side.png");
    private static final class_2960 clay = new class_2960("minecraft", "textures/block/clay.png");
    private static final class_2960 coin = new class_2960("civilizations", "textures/item/egypt_coin.png");
    private static final class_2960 papyrus = new class_2960("civilizations", "textures/item/papyrus.png");
    private static final class_2960 gold_nugget = new class_2960("minecraft", "textures/item/gold_nugget.png");

    public TradingStationScreen(TradingStationScreenHandler handler, class_1661 inventory, class_2561 title) {
        super((class_1703)handler, inventory, title);
    }

    protected void method_25426() {
        super.method_25426();
        this.field_25268 = 1000;
        this.field_25270 = 1000;
        final int x = (this.field_22789 - this.field_2792) / 2;
        final int y = (this.field_22790 - this.field_2779) / 2;
        CustomWidget customWidget1 = new CustomWidget(x + 6, y + 14, 39, 23){

            protected boolean method_25361(double mouseX, double mouseY) {
                class_2540 buffer;
                if (mouseX >= (double)(x + 6) && mouseX <= (double)(x + 45) && mouseY >= (double)(y + 14) && mouseY <= (double)(y + 37)) {
                    buffer = PacketByteBufs.create();
                    buffer.writeInt(1);
                    ClientPlayNetworking.send((class_2960)ModMessages.TRADE, (class_2540)buffer);
                }
                if (mouseX >= (double)(x + 45) && mouseX <= (double)(x + 84) && mouseY >= (double)(y + 14) && mouseY <= (double)(y + 37)) {
                    buffer = PacketByteBufs.create();
                    buffer.writeInt(2);
                    ClientPlayNetworking.send((class_2960)ModMessages.TRADE, (class_2540)buffer);
                }
                if (mouseX >= (double)(x + 6) && mouseX <= (double)(x + 45) && mouseY >= (double)(y + 37) && mouseY <= (double)(y + 60)) {
                    buffer = PacketByteBufs.create();
                    buffer.writeInt(3);
                    ClientPlayNetworking.send((class_2960)ModMessages.TRADE, (class_2540)buffer);
                }
                if (mouseX >= (double)(x + 45) && mouseX <= (double)(x + 84) && mouseY >= (double)(y + 37) && mouseY <= (double)(y + 60)) {
                    buffer = PacketByteBufs.create();
                    buffer.writeInt(4);
                    ClientPlayNetworking.send((class_2960)ModMessages.TRADE, (class_2540)buffer);
                }
                return super.method_25361(mouseX, mouseY);
            }
        };
        CustomWidget customWidget2 = new CustomWidget(x + 45, y + 14, 39, 23){};
        CustomWidget customWidget3 = new CustomWidget(x + 6, y + 37, 39, 23){};
        CustomWidget customWidget4 = new CustomWidget(x + 45, y + 37, 39, 23){};
        this.method_37063((class_364)customWidget1);
        this.method_37063((class_364)customWidget2);
        this.method_37063((class_364)customWidget3);
        this.method_37063((class_364)customWidget4);
    }

    protected void method_2389(class_332 context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(class_757::method_34542);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.setShaderTexture((int)0, (class_2960)TEXTURE);
        int x = (this.field_22789 - this.field_2792) / 2;
        int y = (this.field_22790 - this.field_2779) / 2;
        context.method_25302(TEXTURE, x, y, 0, 0, this.field_2792, this.field_2779);
        Objects.requireNonNull(this.field_22793);
        context.method_51433(this.field_22793, "Trades", x + 29, y + 24 - 9 - 10, 0x373737, false);
        Objects.requireNonNull(this.field_22793);
        context.method_51433(this.field_22793, "Quests", x + 115, y + 24 - 9 - 10, 0x373737, false);
        this.renderReputationBar(context, x, y);
        this.renderTrades(context, x, y);
        this.renderQuests(context, x, y);
    }

    private void renderReputationBar(class_332 context, int x, int y) {
        int reputation = ((TradingStationScreenHandler)this.field_2797).getReputation();
        if (reputation >= 90) {
            context.method_25302(TEXTURE, x + 91, y + 14, 176, 0, 80, 5);
        } else {
            context.method_25302(TEXTURE, x + 91, y + 14, 176, 0, 1 + (int)Math.floor((double)reputation * 0.85), 5);
            context.method_25302(TEXTURE, x + 91 + (int)Math.floor((double)reputation * 0.85), y + 14, 176 + (int)Math.floor((double)reputation * 0.85), 5, 80 - (int)Math.floor((double)reputation * 0.85), 5);
        }
    }

    private void renderTrades(class_332 context, int x, int y) {
        context.method_25290(haybale, x + 9, y + 17, 0.0f, 0.0f, 16, 16, 16, 16);
        context.method_25290(coin, x + 26, y + 17, 0.0f, 0.0f, 16, 16, 16, 16);
        context.method_25290(clay, x + 48, y + 17, 0.0f, 0.0f, 16, 16, 16, 16);
        context.method_25290(coin, x + 65, y + 17, 0.0f, 0.0f, 16, 16, 16, 16);
        context.method_25290(coin, x + 9, y + 40, 0.0f, 0.0f, 16, 16, 16, 16);
        context.method_25290(papyrus, x + 26, y + 40, 0.0f, 0.0f, 16, 16, 16, 16);
        context.method_25290(coin, x + 48, y + 40, 0.0f, 0.0f, 16, 16, 16, 16);
        context.method_25290(gold_nugget, x + 65, y + 40, 0.0f, 0.0f, 16, 16, 16, 16);
    }

    private void renderQuests(class_332 context, int x, int y) {
        int reputation = ((TradingStationScreenHandler)this.field_2797).getReputation();
        String line1 = "I found a very";
        String line2 = "precious item.";
        String line3 = "Bring some coins";
        String line4 = "and it's yours";
        switch (reputation) {
            case 0: {
                line1 = "Hello traveller";
                line2 = "could you bring";
                line3 = "me some food";
                line4 = "for the camels?";
                break;
            }
            case 10: {
                line1 = "We need some";
                line2 = "sandstone to";
                line3 = "repair the";
                line4 = "pyramids";
                break;
            }
            case 20: {
                line1 = "We need clay";
                line2 = "for pottery,";
                line3 = "could you bring";
                line4 = "me some?";
                break;
            }
            case 30: {
                line1 = "My brush is";
                line2 = "worn out could";
                line3 = "you bring me";
                line4 = "a new one?";
                break;
            }
            case 40: {
                line1 = "I'm running out";
                line2 = "of food, could";
                line3 = "you bring me";
                line4 = "some bread?";
                break;
            }
            case 50: {
                line1 = "I need copper";
                line2 = "for my tools,";
                line3 = "could you help";
                line4 = "me with that?";
                break;
            }
            case 60: {
                line1 = "I need leather";
                line2 = "to make clothes";
                line3 = "Think you can";
                line4 = "help me?";
                break;
            }
            case 70: {
                line1 = "Bring me some";
                line2 = "honey and I'll";
                line3 = "give you some";
                line4 = "precious stuff";
                break;
            }
            case 80: {
                line1 = "I need diamonds";
                line2 = "for a gift to the";
                line3 = "king, can you";
                line4 = "help with that?";
            }
        }
        int n = x + 131 - this.size(line1) / 2;
        Objects.requireNonNull(this.field_22793);
        context.method_51433(this.field_22793, line1, n, y + 40 - 9 - 10, 0x373737, false);
        int n2 = x + 131 - this.size(line2) / 2;
        Objects.requireNonNull(this.field_22793);
        context.method_51433(this.field_22793, line2, n2, y + 50 - 9 - 10, 0x373737, false);
        int n3 = x + 131 - this.size(line3) / 2;
        Objects.requireNonNull(this.field_22793);
        context.method_51433(this.field_22793, line3, n3, y + 60 - 9 - 10, 0x373737, false);
        int n4 = x + 131 - this.size(line4) / 2;
        Objects.requireNonNull(this.field_22793);
        context.method_51433(this.field_22793, line4, n4, y + 70 - 9 - 10, 0x373737, false);
    }

    public void method_25394(class_332 context, int mouseX, int mouseY, float delta) {
        this.method_25420(context);
        super.method_25394(context, mouseX, mouseY, delta);
        this.method_2380(context, mouseX, mouseY);
    }

    public int size(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        int size = text.length() - 1;
        List<Character> ch = text.chars().mapToObj(c -> Character.valueOf((char)c)).toList();
        for (char c2 : ch) {
            if (c2 == ' ' || c2 == 't' || c2 == 'I') {
                size += 3;
                continue;
            }
            if (c2 == 'i' || c2 == '!' || c2 == '.' || c2 == ',' || c2 == '\'') {
                ++size;
                continue;
            }
            if (c2 == 'l') {
                size += 2;
                continue;
            }
            if (c2 == 'f' || c2 == 'k') {
                size += 4;
                continue;
            }
            size += 5;
        }
        return size;
    }
}

