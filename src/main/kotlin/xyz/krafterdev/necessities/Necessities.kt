package xyz.krafterdev.necessities

import org.bukkit.plugin.java.JavaPlugin

class Necessities : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        logger.info("Necessities © 2024 Krafter, BSD-3-Clause license")
        logger.info("Initializing...")

        // Load Configuration
        var conf = Config(this)

        // Register Commands
        var cmds = Commands(this, conf)


    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

}
