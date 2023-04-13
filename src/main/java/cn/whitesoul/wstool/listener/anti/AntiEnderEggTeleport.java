package cn.whitesoul.wstool.listener.anti;

import cn.whitesoul.wslib.message.Message;
import cn.whitesoul.wstool.config.Config;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class AntiEnderEggTeleport implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        //禁止右键龙蛋传送
        if (Config.AntiEnderEgg && event.getItem() != null && event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getItem().getType().equals(Material.DRAGON_EGG)){
            Message.sendMessage(event.getPlayer(), Config.AntiEnderEggMessage);
            event.setCancelled(true);
        }
    }
}
