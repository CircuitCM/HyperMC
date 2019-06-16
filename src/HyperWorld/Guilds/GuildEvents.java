package HyperWorld.Guilds;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

import java.util.UUID;

public class GuildEvents implements Listener {

    private GuildManager guildManager;
    private GuildRegionsExecutor guildRegionsExecutor;

    @EventHandler
    public void guildAttackEvent(EntityDamageByEntityEvent e){
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
            Player damager = (Player) e.getDamager();
            Player damaged = (Player) e.getEntity();
            UUID udamager = damager.getUniqueId();
            UUID udamaged = damaged.getUniqueId();

            if(guildManager.getGuild(udamager) == guildManager.getGuild(udamaged)){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent player){

        //while in combat timer, last player damager gets 20% of currency xp, 20% devided between all online faction members. death loses 50%
        if(player.getEventName() == "//fill correct"){

        }
    }

    @EventHandler
    public void guildBlockPlaceEvent(BlockPlaceEvent e){

        ItemStack item = e.getItemInHand();
        if(item.equals(Material.WOOL) && item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Tier 1 Claim Block")) {
            UUID placer = e.getPlayer().getUniqueId();
            Location loc = e.getBlock().getLocation();
            if(guildManager.getGuild(placer) != null) {
                guildRegionsExecutor.makeGuildRegion1(placer, loc);

            }else{
                guildManager.createGuild(placer, name); //work this out
            }

        }


    }
}
