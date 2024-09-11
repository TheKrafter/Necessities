package xyz.krafterdev.necessities

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.Plugin
import com.mojang.brigadier.Command
import com.mojang.brigadier.context.CommandContext
import io.papermc.paper.command.brigadier.Commands
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.jetbrains.kotlin.wasm.ir.WasmHeapType.Simple.Func

@Suppress("UnstableApiUsage")
class Commands(plugin: JavaPlugin, conf: Config) {
    /*
        Register Commands
     */
    var manager: LifecycleEventManager<Plugin?> = plugin.lifecycleManager

    init {
        plugin.logger.info("Registering commands...")
        plugin.getCommand("necessities").setExecutor()
    }

    /*
        Various Command Handlers
     */
    fun handle_necessities(ctx: CommandContext, ) {
        ctx.getSource().sender.sendPlainMessage("your mom")
    }
}