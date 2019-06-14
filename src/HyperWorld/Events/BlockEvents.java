package HyperWorld.Events;

import HyperWorld.Mtut1;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class BlockEvents extends Mtut1 implements Listener {

    private Mtut1 plugin = Mtut1.getPlugin(Mtut1.class);

    Random random = new Random();


//        BlockIterator iterator = new BlockIterator(projectile.getWorld(), loc.toVector(), projectile.getVelocity().normalize(), 0.0D, 4);
//        Block hitBlock = null;
//        double rand1to10 = Math.random();
//
//        while(iterator.hasNext()){
//            hitBlock = iterator.next();
//            hitBlock.breakNaturally();

//            if(hitBlock.getType() == Material.GLASS){
//
//
//
//            }else{
//                hitBlock.breakNaturally();
//            }


//--- place event for walls
    @EventHandler
    public void blockPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        Material blockType = block.getType();
        //int dmg1 = wallT1.get(block.getLocation());
        //int dmg2 = wallT2.get(block.getLocation());

        if (blockType.equals(Material.COBBLESTONE)) {
            wallT1.put(block.getLocation(), 29);
        }

        if (blockType.equals(Material.ENDER_STONE)) {
            wallT2.put(block.getLocation(), 49);
        }
    }
//---break holder walls
    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.HIGHEST)
    public void blockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        Material blockType = block.getType();
        Location loc = block.getLocation();
        byte dat = block.getData();

        if(blockType.equals(Material.DIRT)&& dat == (1)){
            block.setType(Material.AIR);
            ItemStack cdirt = new ItemStack(Material.DIRT, 1, (short) 1);
            double rand1to10 = Math.random();

            new BukkitRunnable() {

                @Override
                public void run() {
                    block.setType(Material.AIR);
                }

            }.runTask(plugin);

            if(rand1to10 < 0.9){

                player.sendMessage(String.valueOf(rand1to10));
                block.getWorld().dropItem(loc, cdirt);
            }
            if(rand1to10 >= 0.9){

                block.getWorld().dropItem(loc, new ItemStack(Material.DEAD_BUSH, 1));
                player.sendMessage(String.valueOf(rand1to10));
            }
        }

        if (blockType.equals(Material.COBBLESTONE)) {
            int dmg1 = wallT1.get(loc);
            wallT1.put(loc, dmg1 - 1);
            block.setType(Material.AIR);

            if (dmg1 >= 1) {
                player.sendMessage(String.valueOf(dmg1));

                new BukkitRunnable() {

                    @Override
                    public void run() {
                       block.setType(Material.COBBLESTONE);
                    }

                }.runTask(plugin);

            } else {
                player.sendMessage(ChatColor.AQUA + "lvl 1 fortified block destroyed");
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        block.setType(Material.AIR);
                    }

                }.runTask(plugin);
//            else {
//                player.sendMessage(ChatColor.AQUA + "lvl 1 fortified block destroyed");
//                int a = 0;
                //---GET BETTER SYSTEM THAN THIS--//
//                while(a <=20000) {
//                    try {
//                        a++;
//                        Thread.sleep(100L);    // 1000L = 1000ms = 1 second
//                        new BukkitRunnable() {
//
//                            @Override
//                            public void run() {
//                                loc.getBlock().setType(Material.AIR);
//                            }
//                        }.runTask(plugin);
//                    }
//                    catch (InterruptedException e) {
//                        //I don't think you need to do anything for your particular problem
//                    }
//                }
//                wallT1.remove(loc);
//            }
            }
        }
        if (blockType.equals(Material.ENDER_STONE)) {
            int dmg2 = wallT2.get(loc);
            wallT2.put(loc, dmg2 - 1);

            block.setType(Material.AIR);

            if (dmg2 >= 1) {
                player.sendMessage(String.valueOf(dmg2));
                block.getDrops().clear();
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        block.setType(Material.ENDER_STONE);
                    }

                }.runTask(plugin);

            } else {
                player.sendMessage(ChatColor.AQUA + "lvl 2 fortified block destroyed");
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        block.setType(Material.AIR);
                    }

                }.runTask(plugin);
                wallT2.remove(loc);
            }
        }
    }

    //---explode event finish
//    @SuppressWarnings("deprecation")
//    @EventHandler
//    public void onBlockExplode(ExplosionPrimeEvent Block, List<Block> blocks, float yield){
//
//        Material blockType = blocks.listIterator().;
//        Location loc = blocks.
//        byte dat = block.getData();
//
//
//        if (blockType.equals(Material.COBBLESTONE)) {
//            int dmg1 = wallT1.get(loc);
//            wallT1.put(loc, dmg1 - 1);
//            block.setType(Material.AIR);
//
//            if (dmg1 >= 1) {
//                Bukkit.getServer().broadcastMessage(String.valueOf(dmg1));
//
//                new BukkitRunnable() {
//
//                    @Override
//                    public void run() {
//                        block.setType(Material.COBBLESTONE);
//                    }
//
//                }.runTask(plugin);
//
//            } else {
//                Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "lvl 1 fortified block destroyed");
//                new BukkitRunnable() {
//
//                    @Override
//                    public void run() {
//                        block.setType(Material.AIR);
//                    }
//
//                }.runTask(plugin);
//            }
//        }
//        if (blockType.equals(Material.ENDER_STONE)) {
//            int dmg2 = wallT2.get(loc);
//            wallT2.put(loc, dmg2 - 1);
//
//            block.setType(Material.AIR);
//
//            if (dmg2 >= 1) {
//                Bukkit.getServer().broadcastMessage(String.valueOf(dmg2));
//                block.getDrops().clear();
//                new BukkitRunnable() {
//
//                    @Override
//                    public void run() {
//                        block.setType(Material.ENDER_STONE);
//                    }
//
//                }.runTask(plugin);
//
//            } else {
//                Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "lvl 2 fortified block destroyed");
//                new BukkitRunnable() {
//
//                    @Override
//                    public void run() {
//                        block.setType(Material.AIR);
//                    }
//
//                }.runTask(plugin);
//                wallT2.remove(loc);
//            }
//        }
//    }

    //--liquid flow
    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockFromTo(BlockFromToEvent event) {
        Material id = event.getBlock().getType();
        if(id.equals(Material.STATIONARY_WATER) || id.equals(Material.STATIONARY_LAVA)) {
            event.setCancelled(true);
        }
    }
}



