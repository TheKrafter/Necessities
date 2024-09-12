package xyz.krafterdev.necessities

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.Plugin
import com.mojang.brigadier.Command
import com.mojang.brigadier.context.CommandContext
import io.papermc.paper.command.brigadier.Commands
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
@Suppress("UnstableApiUsage")
class Commands(var plugin: JavaPlugin, var conf: Config) {
    /*
        Register Base Commands
     */

    init {
        plugin.logger.info("Registering base commands...")
        register()
    }

    fun register() {
        var manager: LifecycleEventManager<Plugin?> = plugin.lifecycleManager
        manager.registerEventHandler(LifecycleEvents.COMMANDS) { event ->
            val commands: Commands = event.registrar()
            val aliases: List<String>? = conf.config?.getStringList("command-aliases")
            var commandAliases: List<String> = emptyList()
            if (aliases == null) {
                commandAliases = listOf("necessities")
            } else {
                commandAliases = listOf("necessities") + aliases
            }
            for (name in commandAliases) {
                commands.register(
                    Commands.literal("$name")
                        .executes { ctx ->
                            ctx.getSource().sender.sendPlainMessage("Necessities v1.0-SNAPSHOT, by Krafter")
                            Command.SINGLE_SUCCESS
                        }
                        .build(),
                    "Necessities by Krafter",
                )
            }

        }
    }
}