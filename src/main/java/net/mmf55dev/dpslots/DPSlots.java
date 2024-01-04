package net.mmf55dev.dpslots;

import net.mmf55dev.dpslots.commands.slotconfigCommand;
import net.mmf55dev.dpslots.commands.slotwhitelistCommand;
import net.mmf55dev.dpslots.events.DynamicSlots;
import net.mmf55dev.dpslots.events.GUIConfigurator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class DPSlots extends JavaPlugin {

    public static final List<String> whitelistedPlayers = new ArrayList<>();
    public static int currentSlots;
    public static int defaultSlots;

    @Override
    public void onEnable() {
        hardcodedAdded();
        setDefaultSlots();
        initSlots();

        getCommand("slotconfig").setExecutor(new slotconfigCommand());
        getCommand("slotwhitelist").setExecutor(new slotwhitelistCommand());

        getServer().getPluginManager().registerEvents(new GUIConfigurator(), this);
        getServer().getPluginManager().registerEvents(new DynamicSlots(), this);

        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    private void hardcodedAdded() {
        whitelistedPlayers.add("MarkManFlame_55");
        whitelistedPlayers.add("FedeWii");
        whitelistedPlayers.add("Coghlan");
        whitelistedPlayers.add("Guaka25");
    }
    private void initSlots() {
        currentSlots = defaultSlots;
    }
    private void setDefaultSlots() {
        defaultSlots = getConfig().getInt("default-slots");
    }
}
