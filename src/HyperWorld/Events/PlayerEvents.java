package HyperWorld.Events;

import HyperWorld.Mtut1;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.List;

public class PlayerEvents extends BlockEvents {

    private Mtut1 plugin = Mtut1.getPlugin(Mtut1.class);
    List<Material> list = new ArrayList<Material>();

    @EventHandler
    public void join(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ScoreboardManager m = Bukkit.getScoreboardManager();
        Scoreboard b = m.getNewScoreboard();
        Objective o = b.registerNewObjective("gold", ""); //needed

        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(ChatColor.DARK_AQUA + "HyperMC Test");

        Score splitter = o.getScore(ChatColor.WHITE + "----------");
        Score gold = o.getScore(ChatColor.WHITE + "Gold: " + ChatColor.GOLD + "10,000");

        splitter.setScore(2);
        gold.setScore(1); //position

        player.setScoreboard(b);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void playerInteract(PlayerInteractEvent event){
        //gets player of PlIntEvent
        Player player = event.getPlayer();
        //get block of interact event
        Block block = event.getClickedBlock();
        if(block.getType().equals(Material.COBBLESTONE)){
            Action action = event.getAction();
            if(action.equals(Action.RIGHT_CLICK_BLOCK)){
                ItemStack item = player.getItemInHand();
                String itemMeta = item.getItemMeta().getDisplayName();
                if(item.equals(Material.IRON_HOE) && itemMeta.equals(ChatColor.AQUA + "Wall Repair Tool")){
                    Location loc = block.getLocation();
                    int h1 = wallT1.get(loc);
                    if(h1<30) {
                        wallT1.put(loc, h1 + 1);
                        item.setDurability((short) (item.getDurability()-1));
                    }
                    if(h1>=30) {
                        player.sendMessage("Wall is fully repaired!");
                    }
                }
            }
        }
        if(block.getType().equals(Material.ENDER_STONE)){
            Action action = event.getAction();
            if(action.equals(Action.RIGHT_CLICK_BLOCK)){
                ItemStack item = player.getItemInHand();
                String itemMeta = item.getItemMeta().getDisplayName();
                if(item.equals(Material.STONE_HOE) && itemMeta.equals(ChatColor.AQUA + "Wall Repair Tool")){
                    Location loc = block.getLocation();
                    int h1 = wallT2.get(loc);
                    if(h1<60) {
                        wallT2.put(loc, h1 + 1);
                        item.setDurability((short) (item.getDurability()-1));
                    }
                    if(h1>=60) {
                        player.sendMessage("Wall is fully repaired!");
                    }
                }
            }
        }

    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();
        Location loc = projectile.getLocation();

        EntityType projectileType = projectile.getType();

        //list.add(Material.BEDROCK); list.add(Material.COBBLESTONE); list.add(Material.ENDER_STONE); list.add(Material.ENCHANTMENT_TABLE); list.add(Material.ANVIL);

//        if(!(projectile instanceof Arrow)){
//            return;
//        }
        //---explosive arrow, turn into ability---shouldn't cause damage to factions?
        if (projectile instanceof Arrow) {
            Arrow arrow = (Arrow) projectile;
            if (arrow.isCritical()) {
                loc.getWorld().createExplosion(loc, 2, false);
                if (arrow.isCritical()) {
                    loc.getWorld().createExplosion(loc, 2, false);
                    if (arrow.isCritical()) {
                        loc.getWorld().createExplosion(loc, 2, false);
                        projectile.remove();
                    }
                }
            }
        } else {
            return;
        }
    }
}
