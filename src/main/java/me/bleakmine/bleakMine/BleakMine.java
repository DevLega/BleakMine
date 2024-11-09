package me.bleakmine.bleakMine;

import me.bleakmine.bleakMine.commands.BleakFeedCommand;
import me.bleakmine.bleakMine.commands.BleakHealCommand;
import me.bleakmine.bleakMine.commands.GivePoisonSwordCommand;
import me.bleakmine.bleakMine.eventListeners.PoisonSwordListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BleakMine extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // POISON SWORD
        getCommand("loresword").setExecutor(new GivePoisonSwordCommand());
        getServer().getPluginManager().registerEvents(new PoisonSwordListener(), this);

        // FEED
        getCommand("bleakfeed").setExecutor(new BleakFeedCommand());

        // HEAL
        getCommand("bleakheal").setExecutor(new BleakHealCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
