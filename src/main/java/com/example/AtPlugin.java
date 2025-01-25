package com.example;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AtPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getLogger().info("艾特插件已启用");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("艾特插件已禁用");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();
        for (Player target : Bukkit.getOnlinePlayers()) {
            if (message.contains("@" + target.getName())) {
                target.sendTitle(
                    ChatColor.GREEN + player.getName(),
                    ChatColor.GOLD + "在聊天中提到了你",
                    10, 70, 20
                );
            }
        }
    }
}
