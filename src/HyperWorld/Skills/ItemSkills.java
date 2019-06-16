package HyperWorld.Skills;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemSkills {

    public void itemSkills(){
        ItemStack lasso = new ItemStack(Material.FISHING_ROD, 1);
        ItemStack lasso2 = new ItemStack(Material.FISHING_ROD, 1);
        ItemStack lasso3 = new ItemStack(Material.FISHING_ROD, 1);
        ItemStack lasso4 = new ItemStack(Material.FERMENTED_SPIDER_EYE, 1);

        ItemStack biglad = new ItemStack(Material.NETHER_WARTS, 1);
        ItemStack biglad2 = new ItemStack(Material.NETHER_WARTS, 1);
        ItemStack biglad3 = new ItemStack(Material.NETHER_WARTS, 1);
        ItemStack biglad4 = new ItemStack(Material.NETHER_WARTS, 1);

        ItemStack aurahealth = new ItemStack(Material.GLOWSTONE_DUST, 1);
        ItemStack aurahealth2 = new ItemStack(Material.GLOWSTONE_DUST, 1);
        ItemStack aurahealth3 = new ItemStack(Material.GLOWSTONE_DUST, 1);
        ItemStack aurahealth4 = new ItemStack(Material.GLOWSTONE_DUST, 1);

        ItemStack berserker = new ItemStack(Material.REDSTONE, 1);
        ItemStack berserker2 = new ItemStack(Material.REDSTONE, 1);
        ItemStack berserker3 = new ItemStack(Material.REDSTONE, 1);
        ItemStack berserker4 = new ItemStack(Material.REDSTONE, 1);

        ItemStack speed = new ItemStack(Material.SUGAR, 1);
        ItemStack speed2 = new ItemStack(Material.SUGAR, 1);
        ItemStack speed3 = new ItemStack(Material.SUGAR, 1);
        ItemStack speed4 = new ItemStack(Material.SUGAR, 1);

        ItemStack strength = new ItemStack(Material.SULPHUR, 1);
        ItemStack strength2 = new ItemStack(Material.SULPHUR, 1);
        ItemStack strength3 = new ItemStack(Material.SULPHUR, 1);
        ItemStack strength4 = new ItemStack(Material.SULPHUR, 1);

        ItemStack haste = new ItemStack(Material.GHAST_TEAR, 1);
        ItemStack haste2 = new ItemStack(Material.GHAST_TEAR, 1);
        ItemStack haste3 = new ItemStack(Material.GHAST_TEAR, 1);
        ItemStack haste4 = new ItemStack(Material.GHAST_TEAR, 1);


        lasso.getItemMeta().setDisplayName("Novice Lasso");
        lasso2.getItemMeta().setDisplayName(ChatColor.AQUA + "Expert Lasso");
        lasso3.getItemMeta().setDisplayName(ChatColor.DARK_PURPLE + "Master Lasso");
        lasso4.getItemMeta().setDisplayName(ChatColor.GOLD + "Hyper Lasso");

        biglad.getItemMeta().setDisplayName("Novice Big Lad");
        biglad2.getItemMeta().setDisplayName(ChatColor.AQUA + "Expert Big Lad");
        biglad3.getItemMeta().setDisplayName(ChatColor.DARK_PURPLE + "Master Big Lad");
        biglad4.getItemMeta().setDisplayName(ChatColor.GOLD + "Hyper Big Lad");

        aurahealth.getItemMeta().setDisplayName("Novice Aura Health");
        aurahealth2.getItemMeta().setDisplayName(ChatColor.AQUA + "Expert Aura Health");
        aurahealth3.getItemMeta().setDisplayName(ChatColor.DARK_PURPLE + "Master Aura Health");
        aurahealth4.getItemMeta().setDisplayName(ChatColor.GOLD + "Hyper Aura Health");

        berserker.getItemMeta().setDisplayName("Novice Berserker");
        berserker2.getItemMeta().setDisplayName(ChatColor.AQUA + "Expert Berserker");
        berserker3.getItemMeta().setDisplayName(ChatColor.DARK_PURPLE + "Master Berserker");
        berserker4.getItemMeta().setDisplayName(ChatColor.GOLD + "Hyper Berserker");

        speed.getItemMeta().setDisplayName("Novice Speed");
        speed2.getItemMeta().setDisplayName(ChatColor.AQUA + "Expert Speed");
        speed3.getItemMeta().setDisplayName(ChatColor.DARK_PURPLE + "Master Speed");
        speed4.getItemMeta().setDisplayName(ChatColor.GOLD + "Hyper Speed");

        strength.getItemMeta().setDisplayName("Novice Strength");
        strength2.getItemMeta().setDisplayName(ChatColor.AQUA + "Expert Strength");
        strength3.getItemMeta().setDisplayName(ChatColor.DARK_PURPLE + "Master Strength");
        strength4.getItemMeta().setDisplayName(ChatColor.GOLD + "Hyper Strength");

        haste.getItemMeta().setDisplayName("Novice Haste");
        haste2.getItemMeta().setDisplayName(ChatColor.AQUA + "Expert Haste");
        haste3.getItemMeta().setDisplayName(ChatColor.DARK_PURPLE + "Master Haste");
        haste4.getItemMeta().setDisplayName(ChatColor.GOLD + "Hyper Haste");


        ArrayList<String> lassoLore = new ArrayList<>();
        ArrayList<String> lassoLore2 = new ArrayList<>();

        ArrayList<String> bigladLore = new ArrayList<>();
        ArrayList<String> bigladLore2 = new ArrayList<>();
        ArrayList<String> bigladLore3 = new ArrayList<>();
        ArrayList<String> bigladLore4 = new ArrayList<>();

        ArrayList<String> aurahealthLore = new ArrayList<>();
        ArrayList<String> aurahealthLore2 = new ArrayList<>();
        ArrayList<String> aurahealthLore3 = new ArrayList<>();
        ArrayList<String> aurahealthLore4 = new ArrayList<>();

        ArrayList<String> berserkerLore = new ArrayList<>();
        ArrayList<String> berserkerLore2 = new ArrayList<>();
        ArrayList<String> berserkerLore3 = new ArrayList<>();
        ArrayList<String> berserkerLore4 = new ArrayList<>();

        ArrayList<String> speedLore = new ArrayList<>();
        ArrayList<String> speedLore2 = new ArrayList<>();
        ArrayList<String> speedLore3 = new ArrayList<>();
        ArrayList<String> speedLore4 = new ArrayList<>();

        ArrayList<String> strengthLore = new ArrayList<>();
        ArrayList<String> strengthLore2 = new ArrayList<>();
        ArrayList<String> strengthLore3 = new ArrayList<>();
        ArrayList<String> strengthLore4 = new ArrayList<>();

        ArrayList<String> hasteLore = new ArrayList<>();
        ArrayList<String> hasteLore2 = new ArrayList<>();
        ArrayList<String> hasteLore3 = new ArrayList<>();
        ArrayList<String> hasteLore4 = new ArrayList<>();
        //finish

    }

}
