package net.mmf55dev.dpslots.inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ConfigInventory {
    public static Inventory open(Player player) {
        if (player != null) {
           Inventory inventory = Bukkit.createInventory(player, InventoryType.HOPPER, ChatColor.AQUA + "" + ChatColor.BOLD + "ESPECTRAL" + ChatColor.GOLD + "" + ChatColor.BOLD + "UHC" + ChatColor.RESET + "Fill Control" );

            inventory.setItem(0, empty());
            inventory.setItem(1, reset());
            inventory.setItem(2, setCount());
            inventory.setItem(3, addNames());
            inventory.setItem(4, empty());
            return inventory;
        }
        return null;
    }
    public static ItemStack empty() {
        ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(" ");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack reset() {
        ItemStack itemStack = new ItemStack(Material.BARRIER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.RED + "Reiniciar Slots");
        itemMeta.setLocalizedName("reset");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack setCount() {
        ItemStack itemStack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.GREEN + "Establecer Maximo de jugadores");
        itemMeta.setLocalizedName("slots");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack addNames() {
        ItemStack itemStack = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GOLD + "Añadir jugadores a la whitelist");
        itemMeta.setLocalizedName("whitelist");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
