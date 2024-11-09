package me.bleakmine.bleakMine.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BleakFeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            player.setFoodLevel(20);

            player.sendMessage(ChatColor.GOLD + "Ты теперь сыт и полон энергии!");
        } else {
            commandSender.sendMessage(ChatColor.RED + "Данну команду может вводить только игрок");
            return false;
        }
        return true;
    }
}
