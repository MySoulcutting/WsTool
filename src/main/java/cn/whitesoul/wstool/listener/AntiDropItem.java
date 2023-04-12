package cn.whitesoul.wstool.listener;

import cn.whitesoul.wstool.config.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class AntiDropItem implements Listener {
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
        for (String worldName : Config.AntiDropWorld) {
            if (event.getPlayer().getWorld().getName().equalsIgnoreCase(worldName)) {
                event.setCancelled(true);
            }
        }
    }
}
