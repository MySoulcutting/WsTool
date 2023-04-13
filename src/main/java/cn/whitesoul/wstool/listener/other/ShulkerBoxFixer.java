package cn.whitesoul.wstool.listener.other;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

public class ShulkerBoxFixer implements Listener {
    @EventHandler
    public void onBlockDispense(BlockDispenseEvent event){
        if (event.getBlock().getType().equals(Material.DISPENSER) && event.getItem().getType().name().toLowerCase().endsWith("shulker_box")){
            event.setCancelled(true);
        }
    }
}
