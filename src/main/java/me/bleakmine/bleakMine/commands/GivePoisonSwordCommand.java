package me.bleakmine.bleakMine.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GivePoisonSwordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(strings.length < 1) {
            commandSender.sendMessage(ChatColor.RED + "Использование: /loresword <имя игрока>");
            return false;
        }

        Player targetPlayer = Bukkit.getPlayer(strings[0]);
        if(targetPlayer == null) {
            commandSender.sendMessage(ChatColor.RED + "Игрок не найден или находится вне сети.");
            return false;
        }

        ItemStack poisonSword = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta poisonSwordMeta = poisonSword.getItemMeta();

        if (poisonSwordMeta != null) {
            poisonSwordMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Пыточный Клинок");
            poisonSwordMeta.setCustomModelData(12345);

            poisonSword.setItemMeta(poisonSwordMeta);
        }

        targetPlayer.getInventory().addItem(poisonSword);
        targetPlayer.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Ты получил пыточный клинок! Береги его.");
        commandSender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Вы успешно выдали пыточный клинок игроку " + targetPlayer.getName() + "!");
        return true;
    }
}
