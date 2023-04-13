package cn.whitesoul.wstool.listener.anti;

import cn.whitesoul.wslib.message.Message;
import cn.whitesoul.wstool.config.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class AntiJoinWorld implements Listener {
    @EventHandler
    public void onPlayer(PlayerChangedWorldEvent event) {
        for (String worldName : Config.AntiJoinWorld) {
            if (event.getPlayer().getWorld().getName().equalsIgnoreCase(worldName) && !event.getPlayer().hasPermission("antiworlds.bypass." + worldName)) {
                Message.sendMessage(event.getPlayer(), Config.AntiJoinWorldMessage);
                //传送回原世界
                event.getPlayer().teleport(event.getFrom().getSpawnLocation());
            }
        }
    }
}

