package com.kbcrt.atplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getLogger().info("ATPlugin 已启用！");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("ATPlugin 已禁用！");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        if (message.contains("@")) {
            String[] parts = message.split("@");
            for (String part : parts) {
                if (part.contains(" ")) {
                    String playerName = part.split(" ")[0];
                    if (getServer().getPlayer(playerName) != null) {
                        getServer().getPlayer(playerName).sendTitle(
                                "§a" + event.getPlayer().getName() + "§6在聊天中提到了你",
                                null,
                                10,
                                70,
                                20
                        );
                        getServer().getPlayer(playerName).sendMessage("§a" + event.getPlayer().getName() + "§6在聊天中提到了你");
                        getServer().getPlayer(playerName).playSound(playerName, org.bukkit.Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1, 1);
                    }
                }
            }
        }
    }
}
