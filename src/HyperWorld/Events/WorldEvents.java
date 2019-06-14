package HyperWorld.Events;

import HyperWorld.Mtut1;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class WorldEvents implements Listener {

    private Mtut1 plugin = Mtut1.getPlugin(Mtut1.class);

    @EventHandler
    public void runnable(){
        new BukkitRunnable(){

            @SuppressWarnings("Deprecation")
            @Override
            public void run(){
                //runnable \/
                for(LivingEntity e: getServer().getWorld("world").getLivingEntities()){
                    e.setCustomName(e.getType() + "" + ChatColor.GOLD + "[" + ChatColor.RED + (int) e.getHealth() + ChatColor.GOLD + "/" + ChatColor.RED + (int) e.getMaxHealth() + ChatColor.GOLD + "]");
                    e.setCustomNameVisible(true);
                }

            }
        }.runTaskTimerAsynchronously(plugin, 0, 20);
    }

    @EventHandler
    public void mobDeath(EntityDeathEvent event) {
        LivingEntity e = event.getEntity();

        if(e instanceof Player){
            event.setDroppedExp(event.getDroppedExp() *2);
        }

        if(!(e instanceof Player)) {
            //event.getDrops().clear();
            event.setDroppedExp(50);

//            if (e instanceof Pig) {
//                e.getWorld().dropItem(e.getLocation(), new ItemStack(Material.PORK, 2));
//                //how to apply variations of data value in item (short) #
//                return;
//            }
//            if (e instanceof Chicken) {
//                e.getWorld().dropItem(e.getLocation(), new ItemStack(Material.RAW_CHICKEN, 1));
//                //how to apply variations of data value in item \/
//                e.getWorld().dropItem(e.getLocation(), new ItemStack(Material.FEATHER, 2));
//                return;
//            }
//            if (e instanceof Cow) {
//                e.getWorld().dropItem(e.getLocation(), new ItemStack(Material.RAW_BEEF, 2));
//                //how to apply variations of data value in item \/
//                e.getWorld().dropItem(e.getLocation(), new ItemStack(Material.LEATHER, 2));
//                return;
//            }
        }
    }
}




