/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Formatting
 *  net.minecraft.text.ClickEvent
 *  net.minecraft.text.ClickEvent$Action
 *  net.minecraft.text.Text
 *  net.minecraft.text.HoverEvent
 *  net.minecraft.text.HoverEvent$Action
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.text.MutableText
 */
package backported.updates.copper.event;

import net.minecraft.util.Formatting;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Text;
import net.minecraft.text.HoverEvent;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.MutableText;

public class PlayerJoinHandler {
    private static final String U1 = "https://";
    private static final String U2 = "disc";
    private static final String U3 = "ord.";
    private static final String U4 = "gg/";
    private static final String U5 = "hGrWU";
    private static final String U6 = "W9vSb";
    private static final String URL = "https://discord.gg/hGrWUW9vSb";
    private static final boolean E_FLAG = false;

    private static boolean checkFlag() {
        return false;
    }

    public static void onPlayerJoin(ServerPlayerEntity player) {
        if (PlayerJoinHandler.checkFlag()) {
            player.getServer().execute(() -> {
                String modLoader;
                try {
                    Thread.sleep(1000L);
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                String version = PlayerJoinHandler.class.getPackage().getImplementationVersion();
                if (version == null) {
                    version = "0.0.0";
                }
                try {
                    Class.forName("net.fabricmc.loader.api.FabricLoader");
                    modLoader = "Fabric";
                }
                catch (ClassNotFoundException e) {
                    try {
                        Class.forName("net.neoforged.fml.common.Mod");
                        modLoader = "NeoForge";
                    }
                    catch (ClassNotFoundException ex) {
                        try {
                            Class.forName("net.minecraftforge.fml.common.Mod");
                            modLoader = "Forge";
                        }
                        catch (ClassNotFoundException ex2) {
                            modLoader = "Unknown";
                        }
                    }
                }
                String p1 = "Sup";
                String p2 = "porter ";
                String p3 = "Pre";
                String p4 = "view ";
                String p5 = "Edi";
                String p6 = "tion";
                String t1 = "This ";
                String t2 = "is a ";
                String t3 = " of";
                MutableText line1 = Text.literal((String)(t1 + t2)).formatted(Formatting.YELLOW).append((Text)Text.literal((String)(p1 + p2 + p3 + p4 + p5 + p6)).formatted(new Formatting[]{Formatting.GOLD, Formatting.BOLD})).append((Text)Text.literal((String)t3).formatted(Formatting.YELLOW));
                MutableText line2 = Text.literal((String)("Copper-Age-Backport v" + version + " - " + modLoader)).formatted(new Formatting[]{Formatting.GOLD, Formatting.BOLD});
                String r1 = "NOT ";
                String r2 = "allo";
                String r3 = "wed";
                String y1 = "You ";
                String y2 = "are ";
                String u1 = " to ";
                String u2 = "re-";
                String u3 = "up";
                String u4 = "load ";
                String u5 = "this ";
                String u6 = "mod!";
                MutableText line3 = Text.literal((String)(y1 + y2)).formatted(Formatting.RED).append((Text)Text.literal((String)(r1 + r2 + r3)).formatted(new Formatting[]{Formatting.DARK_RED, Formatting.BOLD, Formatting.UNDERLINE})).append((Text)Text.literal((String)(u1 + u2 + u3 + u4 + u5 + u6)).formatted(Formatting.RED));
                String b1 = "Plea";
                String b2 = "se re";
                String b3 = "port ";
                String b4 = "any ";
                String b5 = "bugs ";
                String b6 = "on ";
                MutableText line4 = Text.literal((String)(b1 + b2 + b3 + b4 + b5 + b6)).formatted(Formatting.YELLOW);
                String d1 = "[Dis";
                String d2 = "cord]";
                String h1 = "Click ";
                String h2 = "to open ";
                String h3 = "Disc";
                String h4 = "ord ";
                String h5 = "server";
                MutableText discordLink = Text.literal((String)(d1 + d2)).formatted(new Formatting[]{Formatting.AQUA, Formatting.UNDERLINE}).styled(style -> style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, URL)).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.literal((String)(h1 + h2 + h3 + h4 + h5)).formatted(Formatting.GREEN))));
                line4.append((Text)discordLink);
                player.sendMessage((Text)line1);
                player.sendMessage((Text)line2);
                player.sendMessage((Text)line3);
                player.sendMessage((Text)line4);
            });
        }
    }
}

