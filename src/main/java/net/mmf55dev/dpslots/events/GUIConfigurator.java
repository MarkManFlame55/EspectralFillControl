package net.mmf55dev.dpslots.events;

import net.mmf55dev.dpslots.DPSlots;
import net.mmf55dev.dpslots.inventory.ConfigInventory;
import net.mmf55dev.dpslots.inventory.SlotsInventory;
import net.mmf55dev.dpslots.items.ConfigBookItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIConfigurator implements Listener {
    @EventHandler
    public static void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            ItemStack itemStack = e.getItem();
            if (itemStack != null && itemStack.isSimilar(ConfigBookItem.give())) {
                Player player = e.getPlayer();
                player.openInventory(ConfigInventory.open(player));
                player.playSound(player, Sound.BLOCK_ENDER_CHEST_OPEN, 1f, 1f);
            }
        }
    }
    @EventHandler
    public static void onPlayerClick(InventoryClickEvent e)  {
        String invetoryTitle = e.getView().getTitle();
        Player player =  (Player) e.getWhoClicked();
        Inventory inventory = e.getClickedInventory();
        if (invetoryTitle.equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.BOLD + "ESPECTRAL" + ChatColor.GOLD + "" + ChatColor.BOLD + "UHC" + ChatColor.RESET + "Fill Control")) {
            e.setCancelled(true);
            ItemStack itemStack = e.getCurrentItem();
            if (itemStack != null) {
                if (itemStack.equals(ConfigInventory.addNames())) {
                    player.sendMessage(ChatColor.GRAY + "Usa /slotwhitelist <nickname> para añadir jugadores a la whitelist");
                    player.closeInventory();
                }
                if (itemStack.equals(ConfigInventory.setCount())) {
                    player.openInventory(SlotsInventory.open(player));
                    player.playSound(player, Sound.BLOCK_ENDER_CHEST_OPEN, 1f, 1f);
                }
                if (itemStack.equals(ConfigInventory.reset())) {
                    resetSlots();
                    player.sendMessage(ChatColor.GREEN + "Maximo de jugadores: Predeterminado");
                    player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1f ,1f);
                }
            }
        }
        if (invetoryTitle.equalsIgnoreCase("Elija numero maximo de jugadores")) {
            int slots;
            ItemStack itemStack = e.getCurrentItem();
            if (itemStack != null) {
                if (itemStack.equals(SlotsInventory.stop())) {
                    slots = Bukkit.getServer().getMaxPlayers();
                    setSlots(slots);
                    player.sendMessage(ChatColor.GREEN + "Ya no se limita el maximo de jugadores");
                    player.closeInventory();
                    player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
                } else {
                    e.setCancelled(true);
                    slots = e.getCurrentItem().getAmount();
                    setSlots(slots);
                    player.sendMessage(ChatColor.GREEN + "Numero maximo de jugadores: " + slots);
                    player.closeInventory();
                    player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1f ,1f);
                }
            }
        }
    }
    private static void setSlots(int slots) {
        DPSlots.currentSlots = slots;
    }
    private static void resetSlots() {
        DPSlots.currentSlots = DPSlots.defaultSlots;
    }
}
