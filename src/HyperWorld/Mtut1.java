package HyperWorld;

import HyperWorld.Events.BlockEvents;
import HyperWorld.Events.PlayerEvents;
import HyperWorld.Events.WorldEvents;
import HyperWorld.Guilds.GuildCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;

public class Mtut1 extends JavaPlugin {

    public HashMap<Location, Integer> wallT1 = new HashMap<Location, Integer>();
    public HashMap<Location, Integer> wallT2 = new HashMap<Location, Integer>();
    Commands commands = new Commands();
    private Object Integer;

    public void onEnable(){
        getCommand(commands.cmd1).setExecutor(commands);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nMtut1 enabled\n\n");
        getServer().getPluginManager().registerEvents(new WorldEvents(), this);
        getServer().getPluginManager().registerEvents(new BlockEvents(), this);
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        getServer().getPluginManager().registerEvents(new GuildCore(), this);
        loadConfig();

        //runnable();
        runnableDelayed();

        //how custom recipes and custom items are added
    }

    public void onDisable(){
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nMtut1 disabled\n\n");

        List<String> s = getConfig().getStringList("Block Health");

        for(Location l : wallT1.keySet()){
            s.add(l + ":" + wallT1.get(l));
        }
        getConfig().set("Block Health", s);
        saveConfig();

    }

    //needed for custom items?
    public void loadConfig(){
        List<String> s = getConfig().getStringList("Block Health");

        for(String str : s){
            String[] words = str.split(":");
            wallT1.put(Bukkit.getWorld().getBlockAt().getLocation().(String.valueOf(words[0])), String.valueOf(words[1]));
        } //figure out
        getConfig().set("Block Health", s);
        saveConfig();
    }

    public void runnableDelayed() {
        new BukkitRunnable() {

            @Override
            public void run() {
                getServer().broadcastMessage(ChatColor.GREEN + "Server has started");
            }
        }.runTaskLater(this, 40);
    }
}
