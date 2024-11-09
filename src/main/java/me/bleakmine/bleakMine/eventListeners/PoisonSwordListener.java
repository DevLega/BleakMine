package me.bleakmine.bleakMine.eventListeners;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.UUID;

public class PoisonSwordListener implements Listener {

    private final HashMap<UUID, Long> cooldowns = new HashMap<>();
    private final long COOLDOWN_TIME = 5000; // 5000 мс = 5 секунд

    @EventHandler
    public void onEntityHit(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            ItemStack weapon = player.getInventory().getItemInMainHand();

            if (weapon != null && weapon.getType() == Material.NETHERITE_SWORD
                    && weapon.getItemMeta() != null
                    && weapon.getItemMeta().hasCustomModelData()
                    && weapon.getItemMeta().getCustomModelData() == 12345) {

                UUID playerId = player.getUniqueId();
                long currentTime = System.currentTimeMillis();

                if (cooldowns.containsKey(playerId)) {
                    long lastUsedTime = cooldowns.get(playerId);
                    if (currentTime - lastUsedTime < COOLDOWN_TIME) {
                        return;
                    }
                }

                cooldowns.put(playerId, currentTime);

                Entity target = event.getEntity();
                if (target instanceof LivingEntity) {
                    LivingEntity livingTarget = (LivingEntity) target;
                    livingTarget.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 40, 1));
                }
            }
        }
    }
}
