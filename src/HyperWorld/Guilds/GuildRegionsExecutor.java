package HyperWorld.Guilds;

import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Location;


import java.util.UUID;

public class GuildRegionsExecutor {

    private GuildManager guildManager;


    public void makeGuildRegion1(UUID uuidplayer, Location loc){

        BlockVector min = new BlockVector(loc.getBlockX() - 10, 0, loc.getBlockZ() - 10);
        BlockVector max = new BlockVector(loc.getBlockX() + 10, 255, loc.getBlockZ() + 10);
        ProtectedRegion guildRegion = new ProtectedCuboidRegion(guildManager.getGuild(uuidplayer), min, max);

    }

    public void makeGuildRegion2(UUID uuidplayer, Location loc){

        BlockVector min = new BlockVector(loc.getBlockX() - 21, 0, loc.getBlockZ() - 21);
        BlockVector max = new BlockVector(loc.getBlockX() + 21, 255, loc.getBlockZ() + 21);
        ProtectedRegion guildRegion = new ProtectedCuboidRegion(guildManager.getGuild(uuidplayer), min, max);

    }

    public void removeGuildRegion1(Location loc){


    }
}
