package cn.whitesoul.wstool.listener.player;

import cn.whitesoul.wstool.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

public class PlayerViewFrame implements Listener {
    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event){
        if (Config.ViewFrame && event.getRightClicked().getType().equals(EntityType.ITEM_FRAME) && event.getPlayer().isSneaking()){
            ItemFrame itemFrame = (ItemFrame) event.getRightClicked();
            Inventory inventory = Bukkit.createInventory(null, 9, "§e§l物品展示框");
            inventory.setItem(4, itemFrame.getItem());
            event.getPlayer().openInventory(inventory);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if (event.getView() !=null && event.getWhoClicked() !=null && event.getInventory().getName().equals("§e§l物品展示框")){
            event.setCancelled(true);
        }
    }

}
