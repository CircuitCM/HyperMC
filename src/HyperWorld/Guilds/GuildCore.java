package HyperWorld.Guilds;

import HyperWorld.Mtut1;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public class GuildCore extends Mtut1 implements Listener {

    private String name;
    private HashMap<UUID, String> members = new HashMap<>();
    //UUID of player in guild, and String is their rank change string to object later

    public GuildCore(Player owner, String name) {
        this.name = name;
        members.put(owner.getUniqueId(), "owner");
    }

    public GuildCore() {

    }

    public void setName(Player player, String name) {
        GuildCore.put(player.getUniqueId());

    }

    private static void put(UUID uniqueId) {
    }

    public void getName(String name) {
        GuildCore.get(getOwner());
    }

    private static void get(UUID uniqueId) {
    }

    public boolean isInGuild(Player player) {
        return members.containsKey(player.getUniqueId());
    } //Returns if the current player is part of the team

    public Set<UUID> getMembers() {
        return members.keySet();

    } //Returns an arraylist (or hashmap) of the current members

    public UUID getOwner() {
        Set<UUID> keySet = members.keySet();     //We get the keys inside the hashmap and
        for (UUID uuid : keySet) {       //loop through it, while checking the current player's rank.
            if (members.get(uuid).equals("owner"))    //If he is the owner, we return his UUID
                return uuid;
        }
        return null;
    } //returns the owner of the team

    public void addMember(Player player, String rank) {
        members.put(player.getUniqueId(), rank);
    }//Adds a player to the member list (rank is optional)

    public void removeMember(Player player) {
        if (members.containsKey(player.getUniqueId())) {    //If the hashmap contains the player, we remove him.
            members.remove(player.getUniqueId());
        }//pretty self-explanatory.
    } //Removes a player from the members list

    public String getRank(Player player) {
        if (members.containsKey(player.getUniqueId())) {
            return members.get(player.getUniqueId());
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + ";");
        Set<UUID> keySet = members.keySet();
        for (UUID uuid : keySet) {
            builder.append(uuid.toString() + ":" + members.get(uuid) + "|");
        }
        builder.setLength(builder.length() - 1); //We do this to remove the last unneccessary "|".
        return builder.toString();
    }
//You can implement the saving system however you would like to.
//I save the player and rank connections by putting a ":" between them, and a | between the players
//I also put the teams name on the begginning and I put a ";" between it and the rest of the stuff
//NOTE: Make sure you use a StringBuilder for this, because you seriously can waste memory with just pure strings

    public GuildCore fromString(String rawGuild) {
        String[] s1 = rawGuild.split(";");
        this.name = s1[0];
        String[] players = s1[1].split("|");
        for (String player : players) {
            String[] information = player.split(":");
            members.put(UUID.fromString(information[0]), information[1]);
        }
        return this;
    }
}
