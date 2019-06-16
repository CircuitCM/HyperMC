package HyperWorld.CustomItems;

import HyperWorld.Mtut1;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

//class for giving custom items
public class CustomItems implements Listener {
    private Plugin plugin = Mtut1.getPlugin(Mtut1.class);

    public void sampleRecipe(){

        //ItemStack is item, = new instance of item, and defines this items meta
        ItemStack item = new ItemStack(Material.DIAMOND_AXE,1);
        //meta = everything that has to do with items information
        ItemMeta meta = item.getItemMeta();

        //set display name of item meta
        meta.setDisplayName(ChatColor.AQUA + "The Legendary Test Axe");
        //Arraylist = stuff to type/hold
        ArrayList<String> lore = new ArrayList();
        //adds string to lore/arraylist
        lore.add(ChatColor.WHITE + "Power 10");
        //lore is set in meta
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); //like attack damage and stuff
        item.setItemMeta(meta);
        //define new shaped recipe
        ShapedRecipe taxe = new ShapedRecipe(item);
        //the shape of the recipe
        taxe.shape("###"," # "," % ");
        taxe.setIngredient('#', Material.GOLDEN_APPLE); //material 1 and 2 pay attention to format
        taxe.setIngredient('%', Material.DIAMOND_BLOCK);

        plugin.getServer().addRecipe(taxe); // plugin defined on top lings to Mtut1
    }
    public void wallRecipes(){

        //ItemStack is item, = new instance of item, and defines this items meta
        ItemStack item = new ItemStack(Material.COBBLESTONE,2);
        ItemStack item2 = new ItemStack(Material.ENDER_STONE,2);
        //meta = everything that has to do with items information
        ItemMeta meta = item.getItemMeta();
        ItemMeta meta2 = item2.getItemMeta();

        //set display name of item meta
        meta.setDisplayName(ChatColor.AQUA + "Tier 1 Wall Block");
        meta2.setDisplayName(ChatColor.DARK_PURPLE + "Tier 2 Wall Block");
        //Arraylist = stuff to type/hold
        ArrayList<String> lore = new ArrayList();
        ArrayList<String> lore2 = new ArrayList();
        //adds string to lore/arraylist
        lore.add(ChatColor.GOLD + "Health: 30");
        lore.add(ChatColor.WHITE + "Build walls to defend your guild!");
        lore2.add(ChatColor.GOLD + "Health: 60");
        lore2.add(ChatColor.WHITE + "Build walls to defend your guild!");
        //lore is set in meta
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); //like attack damage and stuff
        item.setItemMeta(meta);
        meta2.setLore(lore2);
        meta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); //like attack damage and stuff
        item2.setItemMeta(meta2);
        //define new shaped recipe
        ShapedRecipe w1 = new ShapedRecipe(item);
        ShapedRecipe w2 = new ShapedRecipe(item2);
        //the shape of the recipe
        w1.shape("111","121","111");
        w1.setIngredient('1', Material.STONE); //material 1 and 2 pay attention to format
        w1.setIngredient('2', Material.DEAD_BUSH);
        w2.shape("212","121","212");
        w2.setIngredient('1', Material.COBBLESTONE); //material 1 and 2 pay attention to format
        w2.setIngredient('2', Material.DEAD_BUSH);

        plugin.getServer().addRecipe(w1); // plugin defined on top lings to Mtut1
        plugin.getServer().addRecipe(w2);
    }
    public void repairToolRecipes(){

        ItemStack repairItem = new ItemStack(Material.IRON_HOE, 1);

        ItemMeta repairMeta = repairItem.getItemMeta();
        repairMeta.setDisplayName(ChatColor.AQUA + "Wall Repair Tool");

        ArrayList<String> loreRepair = new ArrayList();
        loreRepair.add(ChatColor.GOLD + "Right click your walls!");

        repairMeta.setLore(loreRepair);
        repairMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        repairItem.setItemMeta(repairMeta);

        ShapelessRecipe r = new ShapelessRecipe(repairItem);

        r.addIngredient(1, Material.IRON_HOE);
        r.addIngredient(3, Material.DEAD_BUSH);


    }
    public void claimBlockRecipes(){
        //ItemStack is item, = new instance of item, and defines this items meta
        ItemStack item = new ItemStack(Material.WOOL, 1, (byte) 1);
        ItemStack item2 = new ItemStack(Material.WOOL,1, (byte) 2);
        //meta = everything that has to do with items information
        ItemMeta meta = item.getItemMeta();
        ItemMeta meta2 = item2.getItemMeta();

        //set display name of item meta
        meta.setDisplayName(ChatColor.AQUA + "Tier 1 Claim Block");
        meta2.setDisplayName(ChatColor.DARK_PURPLE + "Tier 2 Claim Block");
        //Arraylist = stuff to type/hold
        ArrayList<String> lore = new ArrayList();
        ArrayList<String> lore2 = new ArrayList();
        //adds string to lore/arraylist
        lore.add(ChatColor.GOLD + "Claim Size: " + ChatColor.GREEN + "21x21");
        lore.add(ChatColor.GRAY + "Place to claim your guild!");
        lore2.add(ChatColor.GOLD + "Claim Size: " + ChatColor.GREEN + "41x41");
        lore2.add(ChatColor.GRAY + "Place to claim your guild!");
        //lore is set in meta
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); //like attack damage and stuff
        item.setItemMeta(meta);
        meta2.setLore(lore2);
        meta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); //like attack damage and stuff
        item2.setItemMeta(meta2);
        //define new shaped recipe
        ShapedRecipe b1 = new ShapedRecipe(item);
        ShapedRecipe b2 = new ShapedRecipe(item2);
        //the shape of the recipe
        b1.shape("222","212","222");
        b1.setIngredient('1', Material.IRON_BLOCK); //material 1 and 2 pay attention to format
        b1.setIngredient('2', Material.DEAD_BUSH);
        b2.shape("212","131","212");
        b2.setIngredient('1', Material.WOOL, 1); //material 1 and 2 pay attention to format
        b2.setIngredient('2', Material.DEAD_BUSH);
        b2.setIngredient('3', Material.DIAMOND_BLOCK);

        plugin.getServer().addRecipe(b1); // plugin defined on top lings to Mtut1
        plugin.getServer().addRecipe(b2);

    }
    public void combatGaurdsRecipes(){
        //ItemStack is item, = new instance of item, and defines this items meta
        ItemStack item = new ItemStack(Material.WOOL, 1, (byte) 3);
        ItemStack item2 = new ItemStack(Material.WOOL,1, (byte) 4);
        //meta = everything that has to do with items information
        ItemMeta meta = item.getItemMeta();
        ItemMeta meta2 = item2.getItemMeta();

        //set display name of item meta
        meta.setDisplayName(ChatColor.AQUA + "Tier 1 Combat Guard");
        meta2.setDisplayName(ChatColor.DARK_PURPLE + "Tier 2 Combat Guard");
        //Arraylist = stuff to type/hold
        ArrayList<String> lore = new ArrayList();
        ArrayList<String> lore2 = new ArrayList();
        //adds string to lore/arraylist
        lore.add(ChatColor.GOLD + "Guard range: " + ChatColor.GREEN + "15x15");
        lore.add(ChatColor.GRAY + "Place underneath 1 layer of wall block!");
        lore2.add(ChatColor.GOLD + "Guard range: " + ChatColor.GREEN + "20x20");
        lore2.add(ChatColor.GRAY + "Place underneath 1 layer of wall block!");
        //lore is set in meta
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); //like attack damage and stuff
        item.setItemMeta(meta);
        meta2.setLore(lore2);
        meta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); //like attack damage and stuff
        item2.setItemMeta(meta2);
        //define new shaped recipe
        ShapedRecipe b1 = new ShapedRecipe(item);
        ShapedRecipe b2 = new ShapedRecipe(item2);
        //the shape of the recipe
        b1.shape("242","232","212");
        b1.setIngredient('1', Material.IRON_BLOCK);
        b1.setIngredient('3', Material.GOLD_INGOT);
        b1.setIngredient('4', Material.DIAMOND);
        b1.setIngredient('2', Material.DEAD_BUSH);

        b2.shape("242","131","414");
        b2.setIngredient('1', Material.WOOL, 3);
        b2.setIngredient('3', Material.GOLD_BLOCK);
        b2.setIngredient('2', Material.DEAD_BUSH);
        b2.setIngredient('4', Material.DIAMOND);

        plugin.getServer().addRecipe(b1); // plugin defined on top lings to Mtut1
        plugin.getServer().addRecipe(b2);

    }
    public void archerGaurdsRecipes(){
        //ItemStack is item, = new instance of item, and defines this items meta
        ItemStack item = new ItemStack(Material.WOOL, 1, (byte) 0);
        ItemStack item2 = new ItemStack(Material.WOOL,1, (byte) 5);
        //meta = everything that has to do with items information
        ItemMeta meta = item.getItemMeta();
        ItemMeta meta2 = item2.getItemMeta();

        //set display name of item meta
        meta.setDisplayName(ChatColor.AQUA + "Tier 1 Archer Guard");
        meta2.setDisplayName(ChatColor.DARK_PURPLE + "Tier 2 Archer Guard");
        //Arraylist = stuff to type/hold
        ArrayList<String> lore = new ArrayList();
        ArrayList<String> lore2 = new ArrayList();
        //adds string to lore/arraylist
        lore.add(ChatColor.GOLD + "Guard range: " + ChatColor.GREEN + "20x20");
        lore.add(ChatColor.GRAY + "Place underneath 1 layer of wall block!");
        lore2.add(ChatColor.GOLD + "Guard range: " + ChatColor.GREEN + "25x25");
        lore2.add(ChatColor.GRAY + "Place underneath 1 layer of wall block!");
        //lore is set in meta
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); //like attack damage and stuff
        item.setItemMeta(meta);
        meta2.setLore(lore2);
        meta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); //like attack damage and stuff
        item2.setItemMeta(meta2);
        //define new shaped recipe
        ShapedRecipe a1 = new ShapedRecipe(item);
        ShapedRecipe a2 = new ShapedRecipe(item2);
        //the shape of the recipe
        a1.shape("242","232","212");
        a1.setIngredient('1', Material.IRON_BLOCK);
        a1.setIngredient('3', Material.DIAMOND);
        a1.setIngredient('4', Material.GOLD_INGOT);
        a1.setIngredient('2', Material.DEAD_BUSH);

        a2.shape("242","131","414");
        a2.setIngredient('1', Material.WOOL, 0);
        a2.setIngredient('3', Material.GOLD_BLOCK);
        a2.setIngredient('2', Material.DEAD_BUSH);
        a2.setIngredient('4', Material.DIAMOND);

        plugin.getServer().addRecipe(a1); // plugin defined on top lings to Mtut1
        plugin.getServer().addRecipe(a2);

    }

    public void superTier(){

        //ItemStack is item, = new instance of item, and defines this items meta
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1 );
        ItemStack item2 = new ItemStack(Material.DIAMOND_LEGGINGS,1);
        ItemStack item3 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemStack item4 = new ItemStack(Material.DIAMOND_HELMET,1);
        ItemStack item5 = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemStack item6 = new ItemStack(Material.DIAMOND_SWORD,1);

        item.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3); item.addEnchantment(Enchantment.DURABILITY, 3); item.addEnchantment(Enchantment.PROTECTION_FALL, 4);
        item2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3); item2.addEnchantment(Enchantment.DURABILITY, 3);
        item3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3); item3.addEnchantment(Enchantment.DURABILITY, 3);
        item4.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3); item4.addEnchantment(Enchantment.DURABILITY, 3);
        item5.addEnchantment(Enchantment.DAMAGE_ALL, 4); item5.addEnchantment(Enchantment.DURABILITY, 3); item5.addEnchantment(Enchantment.FIRE_ASPECT, 2);
        item6.addEnchantment(Enchantment.DAMAGE_ALL, 5); item6.addEnchantment(Enchantment.DURABILITY, 3); item6.addEnchantment(Enchantment.FIRE_ASPECT, 2);
        //meta = everything that has to do with items information
        ItemMeta meta = item.getItemMeta();
        ItemMeta meta2 = item2.getItemMeta();
        ItemMeta meta3 = item3.getItemMeta();
        ItemMeta meta4 = item4.getItemMeta();
        ItemMeta meta5 = item5.getItemMeta();
        ItemMeta meta6 = item6.getItemMeta();

        //set display name of item meta
        meta.setDisplayName(ChatColor.AQUA + "Master Boots");
        meta2.setDisplayName(ChatColor.AQUA + "Master Leggings");
        meta3.setDisplayName(ChatColor.AQUA + "Master Chestplate");
        meta4.setDisplayName(ChatColor.AQUA + "Master Helmet");
        meta5.setDisplayName(ChatColor.AQUA + "Master Sword");
        meta6.setDisplayName(ChatColor.GOLD + "Hyper Sword");

        //lore is set in meta
        //define new shaped recipe
        ShapedRecipe s1 = new ShapedRecipe(item);
        ShapedRecipe s2 = new ShapedRecipe(item2);
        ShapedRecipe s3 = new ShapedRecipe(item3);
        ShapedRecipe s4 = new ShapedRecipe(item4);
        ShapedRecipe s5 = new ShapedRecipe(item5);
        ShapedRecipe s6 = new ShapedRecipe(item6);
        //the shape of the recipe
        s1.shape("313","121","313");
        s1.setIngredient('1', Material.DIAMOND_BOOTS);
        s1.setIngredient('2', Material.DIAMOND_BLOCK);
        s1.setIngredient('3', Material.DEAD_BUSH);

        s2.shape("313","121","313");
        s2.setIngredient('1', Material.DIAMOND_LEGGINGS);
        s2.setIngredient('2', Material.DIAMOND_BLOCK);
        s2.setIngredient('3', Material.DEAD_BUSH);

        s3.shape("313","121","313");
        s3.setIngredient('1', Material.DIAMOND_CHESTPLATE);
        s3.setIngredient('2', Material.DIAMOND_BLOCK);
        s3.setIngredient('3', Material.DEAD_BUSH);

        s4.shape("313","121","313");
        s4.setIngredient('1', Material.DIAMOND_HELMET);
        s4.setIngredient('2', Material.DIAMOND_BLOCK);
        s4.setIngredient('3', Material.DEAD_BUSH);

        s5.shape("313","121","313");
        s5.setIngredient('1', Material.DIAMOND_SWORD);
        s5.setIngredient('2', Material.DIAMOND_BLOCK);
        s5.setIngredient('3', Material.DEAD_BUSH);

        s6.shape("212","121","212");
        s6.setIngredient('1', Material.DIAMOND_SWORD);
        s6.setIngredient('2', Material.DIAMOND_BLOCK);



        plugin.getServer().addRecipe(s1); // plugin defined on top lings to Mtut1
        plugin.getServer().addRecipe(s2);
        plugin.getServer().addRecipe(s3);
        plugin.getServer().addRecipe(s4);
        plugin.getServer().addRecipe(s5);
        plugin.getServer().addRecipe(s6);

    }

    public void unshaped(){
        ItemStack item = new ItemStack(Material.BLAZE_POWDER, 1);
        //what it sounds
        ShapelessRecipe sr = new ShapelessRecipe(item);

        sr.addIngredient(3,Material.DIRT);//can't exceed 9 total items
        sr.addIngredient(4,Material.GOLDEN_APPLE);
        plugin.getServer().addRecipe(sr); //yep
    }

}
