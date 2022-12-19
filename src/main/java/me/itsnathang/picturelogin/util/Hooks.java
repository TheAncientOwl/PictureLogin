package me.itsnathang.picturelogin.util;

import me.itsnathang.picturelogin.config.ConfigManager;
import org.bukkit.plugin.PluginManager;

import java.util.logging.Logger;

public class Hooks {
    private PluginManager pluginManager;
    private ConfigManager config;
    private Logger logger;

    public static boolean AUTHME;
    public static boolean PLACEHOLDER_API;
    private static boolean SKINS_RESTORER;

    public Hooks(PluginManager plugins, ConfigManager config, Logger logger) {
        this.pluginManager = plugins;
        this.config = config;
        this.logger = logger;

        hookAuthMe();
        hookPlaceHolderAPI();
        hookSkinsRestorer();
    }

    private boolean hookPlugin(String plugin) {
        if (!pluginManager.isPluginEnabled(plugin))
            return false;

        // Make sure user wants to hook into the plugin
        if (!config.getBoolean("hooks." + plugin, true))
            return false;

        logger.info(() -> "Hooked into: " + plugin);
        return true;
    }

    private void hookAuthMe() {
        AUTHME = hookPlugin("AuthMe");
    }

    private void hookPlaceHolderAPI() {
        PLACEHOLDER_API = hookPlugin("PlaceholderAPI");
    }

    private void hookSkinsRestorer() {
        SKINS_RESTORER = hookPlugin("SkinsRestorer");
    }

    public static boolean useSkinsRestorer() {
        return SKINS_RESTORER;
    }
}
