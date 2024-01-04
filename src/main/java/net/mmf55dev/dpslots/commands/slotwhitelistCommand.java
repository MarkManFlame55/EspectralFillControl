package net.mmf55dev.dpslots.commands;

import net.mmf55dev.dpslots.DPSlots;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class slotwhitelistCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.isOp()) {
            if (strings.length == 1) {
                String nickname = strings[0];
                DPSlots.whitelistedPlayers.add(nickname);
                if (commandSender instanceof Player player) {
                    player.sendMessage(ChatColor.GREEN + "Added " + nickname + " to whitelist");
                } else {
                    commandSender.sendMessage("Added " + nickname + " to whitelist");
                }
            }
        }

        return true;
    }
}
