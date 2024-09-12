package xyz.krafterdev.necessities.modules

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class Teleportation(var plugin: JavaPlugin) {
    val name = "Teleportation"
    var enabled: Boolean = false
    var config: YamlConfiguration? = null
    init {
        loadConfig()
    }

    fun loadConfig() {
        var file: File = File(this.plugin.dataFolder, "modules/teleportation.yml")
        this.config = YamlConfiguration.loadConfiguration(file)
        enabled = this.config?.getBoolean("enabled") == true
        config?.save(file)
    }


}