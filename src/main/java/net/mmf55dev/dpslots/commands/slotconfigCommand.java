package net.mmf55dev.dpslots.commands;

import net.mmf55dev.dpslots.items.ConfigBookItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class slotconfigCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player && player.isOp()) {
            ConfigBookItem.give(player);
        }
        return true;
    }
}
