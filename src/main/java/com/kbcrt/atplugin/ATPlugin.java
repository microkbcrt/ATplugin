package com.kbcrt.atplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ATPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("ATPlugin 已启用");
    }

    @Override
    public void onDisable() {
        getLogger().info("ATPlugin 已禁用");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player sender = event.getPlayer();
        String message = event.getMessage();

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (message.contains("@" + player.getName())) {
                player.sendTitle(ChatColor.GREEN + sender.getName() + ChatColor.GOLD + "在聊天中提到了你", "", 10, 70, 20);
                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0f, 1.0f);
            }
        }
    }
}
