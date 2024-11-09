package me.bleakmine.bleakMine.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class BleakHealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            player.setHealth(20);
            for (PotionEffect effect : player.getActivePotionEffects()) {
                player.removePotionEffect(effect.getType());
            }

            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Ты полностью исцелён!");
        } else {
            commandSender.sendMessage(ChatColor.RED + "Эту команду может использовать только игрок.");
        }
        return true;
    }
}
