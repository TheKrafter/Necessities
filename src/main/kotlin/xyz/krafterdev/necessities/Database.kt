package xyz.krafterdev.necessities

import org.bukkit.plugin.java.JavaPlugin
import java.sql.Connection
import java.sql.DriverManager


class Database(plugin: JavaPlugin) {
    fun connect() {
        Class.forName("org.sqlite.JDBC")
        var connection: Connection = DriverManager.getConnection("jdbc:sqlite:plugins/")
    }
}