package cn.whitesoul.wstool.listener.player;

import cn.whitesoul.wstool.listener.anti.AntiDropItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayerJoinQuit implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        //添加到dropMap
        UUID uuid = event.getPlayer().getUniqueId();
        AntiDropItem.dropMap.put(uuid,false);
    }
    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        //从dropMap移除
        UUID uuid = event.getPlayer().getUniqueId();
        AntiDropItem.dropMap.remove(uuid);
    }
}
