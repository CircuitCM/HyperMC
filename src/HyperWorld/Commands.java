package HyperWorld;

import net.minecraft.server.v1_8_R3.CommandExecute;
import net.minecraft.server.v1_8_R3.EntitySkeleton;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
//hcyl - command for world edit rings

public class Commands extends CommandExecute implements Listener, CommandExecutor {

    public String cmd1 = "mob";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (sender instanceof Player){

            Player player = (Player) sender;
            Location loc = player.getLocation();
                    //world of vanilla mc \/ can't use bukkit.world for mobs
            WorldServer world = ((CraftWorld)player.getWorld()).getHandle();

            if(cmd.getName().equalsIgnoreCase(cmd1)){
                EntitySkeleton skele = new EntitySkeleton(world);
                skele.move(100,100,100);
                skele.setCustomName(ChatColor.AQUA + "Bob");
                skele.setCustomNameVisible(true);

                skele.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
                world.addEntity(skele);
                return true;
            }else{
                sender.sendMessage(ChatColor.RED + "Only players GOd");
                return true;
            }

        }
        return false;
    }
}
