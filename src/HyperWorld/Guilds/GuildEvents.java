package HyperWorld.Guilds;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.UUID;

public class GuildEvents implements Listener {

    @EventHandler
    public void guildAttackEvent(EntityDamageByEntityEvent e){
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
            Player damager = (Player) e.getDamager();
            Player damaged = (Player) e.getEntity();
            UUID udamager = damager.getUniqueId();
            UUID udamaged = damaged.getUniqueId();

            if(players.get(udamager) == players.get(udamaged)){
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
}
