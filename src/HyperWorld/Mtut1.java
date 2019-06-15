package HyperWorld;

import HyperWorld.Economy.EconomyCommands;
import HyperWorld.Economy.EconomyImplementer;
import HyperWorld.Events.BlockEvents;
import HyperWorld.Events.PlayerEvents;
import HyperWorld.Events.WorldEvents;
import HyperWorld.Guilds.GuildCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Mtut1 extends JavaPlugin {

    public static Mtut1 getInstance;
    public EconomyImplementer economyImplementer;
    private VaultHook vaultHook;

    public final HashMap<UUID,Double> playerBank = new HashMap<>();
    public HashMap<Location, Integer> wallT1 = new HashMap<Location, Integer>();
    public HashMap<Location, Integer> wallT2 = new HashMap<Location, Integer>();
    Commands commands = new Commands();
    private Object Integer;

    public void onEnable(){
        getCommand(commands.cmd1).setExecutor(commands);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\nHyperCore enabled\n");
        getServer().getPluginManager().registerEvents(new WorldEvents(), this);
        getServer().getPluginManager().registerEvents(new BlockEvents(), this);
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        getServer().getPluginManager().registerEvents(new GuildCore(), this);
        runEconomy();
        loadConfig();

        //runnable();
        runnableDelayed();

        //how custom recipes and custom items are added
    }

    public void onDisable(){

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\nHyperCore disabled\n");

        saveWallDamage();
        vaultHook.unhook();
    }

    public void loadConfig(){

        loadWallDamage();

    }

    private void instanceClasses() {
        getInstance = this;
        economyImplementer = new EconomyImplementer();
        vaultHook = new VaultHook();
    }

    private void runEconomy() {
        instanceClasses();
        vaultHook.hook();
        this.getCommand("e").setExecutor(new EconomyCommands());
    }

    private void loadWallDamage() {
        List<String> s = getConfig().getStringList("Block Health");

        for(String str : s){
            String[] words = str.split(":");
            wallT1.put(Bukkit.getWorld().getBlockAt().getLocation().(String.valueOf(words[0])), String.valueOf(words[1]));
        } //figure out
        getConfig().set("Block Health", s);
        saveConfig();
    }

    private void saveWallDamage() {
        List<String> s = getConfig().getStringList("Block Health");

        for(Location l : wallT1.keySet()){
            s.add(l + ":" + wallT1.get(l));
        }
        getConfig().set("Block Health", s);
        saveConfig();
    }

    //needed for custom items?


    public void runnableDelayed() {
        new BukkitRunnable() {

            @Override
            public void run() {
                getServer().broadcastMessage(ChatColor.GREEN + "Server has started");
            }
        }.runTaskLater(this, 40);
    }
}
