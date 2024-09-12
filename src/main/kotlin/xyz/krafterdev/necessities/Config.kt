package xyz.krafterdev.necessities

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import xyz.krafterdev.necessities.modules.Teleportation
import java.io.File


class Config(var plugin: JavaPlugin) {
    /*
        Load and read configuration files
     */
    var config: YamlConfiguration?
    var modulesEnabled: ArrayList<String> = ArrayList<String>()

    init {
        plugin.logger.info("Loading configuration files...")
        plugin.saveResource("config.yml", false)
        var file: File = File(plugin.dataFolder, "config.yml")
        config = YamlConfiguration.loadConfiguration(file)
        loadModules()
        if (!file.exists()) {
            config?.save(file)
        }
    }

    fun loadModules() {
        var moduleTp: Teleportation = Teleportation(plugin)

        for (module in listOf(moduleTp)) {
            //if (module.enabled) {
                modulesEnabled += module.name
            //}
        }

        plugin.logger.info("Loaded modules: $modulesEnabled")
    }
}