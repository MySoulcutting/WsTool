package cn.whitesoul.wstool.listener.anti;

import cn.whitesoul.wslib.message.Message;
import cn.whitesoul.wstool.WsTool;
import cn.whitesoul.wstool.config.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class AntiDropItem implements Listener {
    public static ConcurrentHashMap<UUID,Boolean> dropMap = new ConcurrentHashMap<>();
    /*
    *   1.玩家进入存如hashmap false
    *   2.执行drop之后hashmap true
    *   3.再次执行hashmap false
    *   4.每隔一段事件hashmap false
    *   5.玩家离开hashmap remove
    *
    * */
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        for (String worldName : Config.AntiDropWorld) {
            if (event.getPlayer().getWorld().getName().equalsIgnoreCase(worldName) && dropMap.get(uuid)) {
                event.setCancelled(false);
            } else if (event.getPlayer().getWorld().getName().equalsIgnoreCase(worldName) && !dropMap.get(uuid)){
                Message.sendMessage(event.getPlayer(), Config.AntiDropMessages);
                event.setCancelled(true);
            }
        }
    }
}
