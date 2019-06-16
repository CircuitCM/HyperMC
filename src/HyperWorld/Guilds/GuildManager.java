package HyperWorld.Guilds;


import org.bukkit.entity.Player;

import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public class GuildManager {


    private static GuildManager instance = null;
    private Object Player;

    private GuildManager() {
        instance = this;
    }

    public static GuildManager getInstance(){
        return instance;
    }
    
    private HashMap<String, GuildCore> guilds = new HashMap<>();
    private HashMap<UUID, String> players = new HashMap<>();
    // strings in hashmaps mean faction name

    public boolean createGuild(Player owner, String name) {  //We return true, if the proccess was succesfull, else we return false
        if (players.containsKey(owner.getUniqueId()))  //First we check if the player is already in a team
            return false;
        GuildCore guild = new GuildCore(owner, name);   //Then we create the new team,
        guilds.put(name, guild);    //we add the team to the teams hashmap,
        players.put(owner.getUniqueId(), name);   //and we set the player's team to the new one.
        return true;
    }

    public boolean addPlayer(Player player, String name, String rank) { //We return boolean for the same reason as above
        if (guilds.containsKey(name) && !players.containsKey(player.getUniqueId())) {     //First, we check if the team exists and the player isn't in a team currently,
            GuildCore guild = guilds.get(name);  // then we add the player to the team, and set the player's team to the new one
            guild.addMember(player, rank);
            players.put(player.getUniqueId(), name);
            return true;
        }
        return false;
    }

    public void removePlayer(Player player) {
        if (players.containsKey(player.getUniqueId())) {  //We check, if the player has a guild
            String name = players.get(player.getUniqueId());  //We temporarily store the guild's name
            players.remove(player.getUniqueId());  //We set the player's guild to none
            GuildCore guild = guilds.get(name);  //We get the name (This is why we needed it's name)
            String rank = guild.getRank(player);  //We get the rank of the player again, temporarily
            guild.removeMember(player);  //we remove the player from the teams member list
            if (rank.equals("owner")) {  //Then, for the sake of ease, if the player was the owner, we delete the guild
                Set<UUID> members = guild.getMembers();
                for (UUID uuid : members) {
                    players.remove(uuid);   //We get the members, and we set everyone's guild to none
                }
                guilds.remove(name);  //Lastly, we delete the guild itself
            }
        }
    }

//Note: If you have a Rank system, you can make it, so the guy with the highest rank will be the new owner, if you want to

    public boolean isInGuild(Player player) {
        return players.containsKey(player.getUniqueId());
    }

    public String getGuild(UUID player) {
        if (players.containsKey(player.getUniqueId()))
            return players.get(player.getUniqueId());
        return null;
    }

    public Set<String> getGuilds() {
        return guilds.keySet();
    }

    public void save() throws IOException {
        File file = new File("plugins/TeamTutorial/saves.txt");
        if (!file.exists()) {
            file.getParent().mkdirs();
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsolutePath());
        BufferedWriter bw = new BufferedWriter(fw);

        Set<String> keySet = guilds.keySet();
        for (String name : keySet) {
            GuildCore guild = guilds.get(name);
            bw.newLine();
            bw.write(guilds.toString());
        }
        bw.close();
    }
    //This method basically writes the String we get out of the teams to a file, each team occupies 1 line
    public void load() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("plugins/TeamTutorial/saves.txt"));

        String line;
        while ((line = r.readLine()) != null) {
            GuildCore guild = new GuildCore().fromString(line);
            guilds.put(guild.getName(line), guild);
            Set<UUID> members = guild.getMembers();
            for (UUID uuid : members) {
                players.put(uuid, guild.getName(line));
            }
        }
    }
}
