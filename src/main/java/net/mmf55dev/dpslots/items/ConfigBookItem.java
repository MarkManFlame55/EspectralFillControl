package net.mmf55dev.dpslots.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ConfigBookItem {
    public static ItemStack give() {
        ItemStack itemStack = new ItemStack(Material.BOOK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.GOLD + "Configuración del fill");
        itemMeta.setLocalizedName("config_book");
        List<String> itemLore = new ArrayList<>();

        itemLore.add(ChatColor.DARK_GRAY + "Click derecho para abrir");
        itemLore.add(ChatColor.DARK_GRAY + "la configuración");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static void give(Player player) {
        player.getInventory().addItem(give());
    }
}
