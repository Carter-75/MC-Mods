package mod.universalmobwar.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Implements the /kit command that hands out a maxed gear loadout using the config's top tiers.
 */
public final class KitCommand {

    private KitCommand() {}

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext registryAccess, Commands.CommandSelection environment) {
        dispatcher.register(Commands.literal("kit")
            .executes(context -> giveKit(context, context.getSource().getPlayerOrException()))
            .then(Commands.argument("player", EntityArgument.player())
                .requires(source -> source.hasPermission(2))
                .executes(context -> giveKit(context, EntityArgument.getPlayer(context, "player"))))
        );
    }

    private static int giveKit(CommandContext<CommandSourceStack> context, ServerPlayer target) throws CommandSyntaxException {
        Registry<Enchantment> enchantRegistry = context.getSource().getServer().registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
        List<ItemStack> kitItems = buildKit(enchantRegistry);
        kitItems.forEach(target::addItem);

        target.sendSystemMessage(Component.literal("You received the Universal Arsenal kit!")
            .withStyle(style -> style.withColor(ChatFormatting.GOLD).withBold(true)));

        CommandSourceStack source = context.getSource();
        if (source.getEntity() == null || source.getEntity() != target) {
            String targetName = target.getName().getString();
            source.sendSuccess(() -> Component.literal("Gave the Universal kit to ")
                .withStyle(style -> style.withColor(ChatFormatting.GREEN))
                .append(Component.literal(targetName).withStyle(style -> style.withColor(ChatFormatting.YELLOW).withBold(true))), true);
        }

        return kitItems.size();
    }

    private static List<ItemStack> buildKit(Registry<Enchantment> enchantRegistry) {
        List<ItemStack> kit = new ArrayList<>();

        kit.add(armorPiece(Items.NETHERITE_HELMET, stack -> {
            add(stack, enchantRegistry, Enchantments.PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.FIRE_PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.BLAST_PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.PROJECTILE_PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.THORNS, 3);
            add(stack, enchantRegistry, Enchantments.UNBREAKING, 3);
            add(stack, enchantRegistry, Enchantments.MENDING, 1);
            add(stack, enchantRegistry, Enchantments.AQUA_AFFINITY, 1);
            add(stack, enchantRegistry, Enchantments.RESPIRATION, 3);
        }));

        kit.add(armorPiece(Items.NETHERITE_CHESTPLATE, stack -> {
            add(stack, enchantRegistry, Enchantments.PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.FIRE_PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.BLAST_PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.PROJECTILE_PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.THORNS, 3);
            add(stack, enchantRegistry, Enchantments.UNBREAKING, 3);
            add(stack, enchantRegistry, Enchantments.MENDING, 1);
        }));

        kit.add(armorPiece(Items.NETHERITE_LEGGINGS, stack -> {
            add(stack, enchantRegistry, Enchantments.PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.FIRE_PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.BLAST_PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.PROJECTILE_PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.THORNS, 3);
            add(stack, enchantRegistry, Enchantments.UNBREAKING, 3);
            add(stack, enchantRegistry, Enchantments.MENDING, 1);
            add(stack, enchantRegistry, Enchantments.SWIFT_SNEAK, 3);
        }));

        kit.add(armorPiece(Items.NETHERITE_BOOTS, stack -> {
            add(stack, enchantRegistry, Enchantments.PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.FIRE_PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.BLAST_PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.PROJECTILE_PROTECTION, 4);
            add(stack, enchantRegistry, Enchantments.THORNS, 3);
            add(stack, enchantRegistry, Enchantments.UNBREAKING, 3);
            add(stack, enchantRegistry, Enchantments.MENDING, 1);
            add(stack, enchantRegistry, Enchantments.FEATHER_FALLING, 4);
            add(stack, enchantRegistry, Enchantments.DEPTH_STRIDER, 3);
            add(stack, enchantRegistry, Enchantments.SOUL_SPEED, 3);
            add(stack, enchantRegistry, Enchantments.FROST_WALKER, 2);
        }));

        kit.add(weapon(Items.NETHERITE_SWORD, stack -> {
            add(stack, enchantRegistry, Enchantments.SHARPNESS, 5);
            add(stack, enchantRegistry, Enchantments.FIRE_ASPECT, 2);
            add(stack, enchantRegistry, Enchantments.KNOCKBACK, 2);
            add(stack, enchantRegistry, Enchantments.LOOTING, 3);
            add(stack, enchantRegistry, Enchantments.UNBREAKING, 3);
            add(stack, enchantRegistry, Enchantments.MENDING, 1);
        }));

        kit.add(weapon(Items.TRIDENT, stack -> {
            add(stack, enchantRegistry, Enchantments.IMPALING, 5);
            add(stack, enchantRegistry, Enchantments.LOYALTY, 3);
            add(stack, enchantRegistry, Enchantments.RIPTIDE, 3);
            add(stack, enchantRegistry, Enchantments.CHANNELING, 1);
            add(stack, enchantRegistry, Enchantments.UNBREAKING, 3);
            add(stack, enchantRegistry, Enchantments.MENDING, 1);
        }));

        kit.add(weapon(Items.CROSSBOW, stack -> {
            add(stack, enchantRegistry, Enchantments.QUICK_CHARGE, 3);
            add(stack, enchantRegistry, Enchantments.PIERCING, 4);
            add(stack, enchantRegistry, Enchantments.MULTISHOT, 1);
            add(stack, enchantRegistry, Enchantments.UNBREAKING, 3);
            add(stack, enchantRegistry, Enchantments.MENDING, 1);
        }));

        kit.add(weapon(Items.BOW, stack -> {
            add(stack, enchantRegistry, Enchantments.POWER, 5);
            add(stack, enchantRegistry, Enchantments.PUNCH, 2);
            add(stack, enchantRegistry, Enchantments.FLAME, 1);
            add(stack, enchantRegistry, Enchantments.INFINITY, 1);
            add(stack, enchantRegistry, Enchantments.UNBREAKING, 3);
            add(stack, enchantRegistry, Enchantments.MENDING, 1);
        }));

        kit.add(weapon(Items.SHIELD, stack -> {
            add(stack, enchantRegistry, Enchantments.UNBREAKING, 3);
            add(stack, enchantRegistry, Enchantments.MENDING, 1);
        }));

        ItemStack arrow = new ItemStack(Items.ARROW);
        arrow.setCount(1);
        kit.add(arrow);

        kit.add(new ItemStack(Items.TOTEM_OF_UNDYING));

        return kit;
    }

    private static ItemStack armorPiece(Item item, Consumer<ItemStack> enchantments) {
        return withEnchantments(item, enchantments);
    }

    private static ItemStack weapon(Item item, Consumer<ItemStack> enchantments) {
        return withEnchantments(item, enchantments);
    }

    private static ItemStack withEnchantments(Item item, Consumer<ItemStack> enchantments) {
        ItemStack stack = new ItemStack(item);
        enchantments.accept(stack);
        return stack;
    }

    private static void add(ItemStack stack, Registry<Enchantment> enchantRegistry, ResourceKey<Enchantment> enchantmentKey, int level) {
        Holder<Enchantment> entry = enchantRegistry
            .get(enchantmentKey)
            .orElseThrow(() -> new IllegalStateException("Missing enchantment: " + enchantmentKey.location()));
        stack.enchant(entry, level);
    }
}
