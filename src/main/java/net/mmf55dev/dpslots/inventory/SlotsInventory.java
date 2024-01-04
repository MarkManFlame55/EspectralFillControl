package net.mmf55dev.dpslots.inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SlotsInventory {
    public static Inventory open(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 54, "Seleccione el numero maximo de jugadores");
        inventory.setItem(0, stop());
        inventory.setItem(2, new ItemStack(Material.PLAYER_HEAD, 1));
        inventory.setItem(3, new ItemStack(Material.PLAYER_HEAD, 2));
        inventory.setItem(4, new ItemStack(Material.PLAYER_HEAD, 3));
        inventory.setItem(5, new ItemStack(Material.PLAYER_HEAD, 4));
        inventory.setItem(6, new ItemStack(Material.PLAYER_HEAD, 5));
        inventory.setItem(11, new ItemStack(Material.PLAYER_HEAD, 6));
        inventory.setItem(12, new ItemStack(Material.PLAYER_HEAD, 7));
        inventory.setItem(13, new ItemStack(Material.PLAYER_HEAD, 8));
        inventory.setItem(14, new ItemStack(Material.PLAYER_HEAD, 9));
        inventory.setItem(15, new ItemStack(Material.PLAYER_HEAD, 10));
        inventory.setItem(20, new ItemStack(Material.PLAYER_HEAD, 11));
        inventory.setItem(21, new ItemStack(Material.PLAYER_HEAD, 12));
        inventory.setItem(22, new ItemStack(Material.PLAYER_HEAD, 13));
        inventory.setItem(23, new ItemStack(Material.PLAYER_HEAD, 14));
        inventory.setItem(24, new ItemStack(Material.PLAYER_HEAD, 15));
        inventory.setItem(29, new ItemStack(Material.PLAYER_HEAD, 16));
        inventory.setItem(30, new ItemStack(Material.PLAYER_HEAD, 17));
        inventory.setItem(31, new ItemStack(Material.PLAYER_HEAD, 18));
        inventory.setItem(32, new ItemStack(Material.PLAYER_HEAD, 19));
        inventory.setItem(33, new ItemStack(Material.PLAYER_HEAD, 20));
        inventory.setItem(38, new ItemStack(Material.PLAYER_HEAD, 21));
        inventory.setItem(39, new ItemStack(Material.PLAYER_HEAD, 22));
        inventory.setItem(40, new ItemStack(Material.PLAYER_HEAD, 23));
        inventory.setItem(41, new ItemStack(Material.PLAYER_HEAD, 24));
        inventory.setItem(42, new ItemStack(Material.PLAYER_HEAD, 25));
        inventory.setItem(47, new ItemStack(Material.PLAYER_HEAD, 26));
        inventory.setItem(48, new ItemStack(Material.PLAYER_HEAD, 27));
        inventory.setItem(49, new ItemStack(Material.PLAYER_HEAD, 28));
        inventory.setItem(50, new ItemStack(Material.PLAYER_HEAD, 29));
        inventory.setItem(51, new ItemStack(Material.PLAYER_HEAD, 30));

        for (int i = 0;i<53;i++) {
            if (inventory.getItem(i) != null && inventory.getItem(i).getType().equals(Material.PLAYER_HEAD)) {
                ItemStack itemStack = inventory.getItem(i);
                assert itemStack != null;
                ItemMeta newMeta = itemStack.getItemMeta();
                assert newMeta != null;
                newMeta.setDisplayName(ChatColor.GOLD + Integer.toString(itemStack.getAmount()));
                itemStack.setItemMeta(newMeta);
            }
        }
        return inventory;
    }
    private static ItemStack empty() {
        ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(" ");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack stop() {
        ItemStack itemStack = new ItemStack(Material.BARRIER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.RED + "Sin Limite");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
