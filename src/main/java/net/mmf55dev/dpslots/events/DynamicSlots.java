package net.mmf55dev.dpslots.events;

import net.mmf55dev.dpslots.DPSlots;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class DynamicSlots implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Server server = player.getServer();
        int onlinePlayers = 0;
        for (Player serverPlayers : server.getOnlinePlayers()) {
            onlinePlayers++;
        }
        if (onlinePlayers > DPSlots.currentSlots) {
            if (!DPSlots.whitelistedPlayers.contains(player.getDisplayName())) {
                player.kickPlayer("Server is alredy full");
            }
        }
    }
}
