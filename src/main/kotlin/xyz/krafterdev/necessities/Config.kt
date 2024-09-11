package xyz.krafterdev.necessities

import org.bukkit.plugin.java.JavaPlugin
import java.io.InputStream

class Config(plugin: JavaPlugin) {
    /*
        Load and read configuration files
     */
    var config: InputStream?
    init {
        plugin.logger.info("Loading configuration files...")
        plugin.saveResource("config.yml", false)
        config = plugin.getResource("config.yml")
        // Load module-specific configurations
    }
}