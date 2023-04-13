package cn.whitesoul.wstool.listener.anti;

import cn.whitesoul.wslib.message.Message;
import cn.whitesoul.wstool.event.AntiBuildEvent;
import cn.whitesoul.wstool.config.Config;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.*;


import static org.bukkit.Bukkit.getServer;

public class AntiBuild implements Listener {
    public AntiBuildEvent antiBuildEvent;
    @EventHandler
    public void AntiBuildEvent(AntiBuildEvent event){
        Player player = event.getPlayer();
        World world = event.getPlayer().getWorld();
        //判断是否为op
        if (player.isOp() ) {
            return;
        }
        for (String s : Config.AntiBuildWorld) {
            //判断世界
            if (world.getName().equalsIgnoreCase(s)) {
                Message.sendMessage(player, Config.AntiBuildMessage);
                event.setCancelled(true);
            }
        }
    }
    //破坏事件
    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        antiBuildEvent = new AntiBuildEvent(event.getPlayer());
        getServer().getPluginManager().callEvent(antiBuildEvent);
        if (antiBuildEvent.isCancelled()) {
            event.setCancelled(true);
        }
    }
    //放置事件
    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        antiBuildEvent = new AntiBuildEvent(event.getPlayer());
        getServer().getPluginManager().callEvent(antiBuildEvent);
        if (antiBuildEvent.isCancelled()) {
            event.setCancelled(true);
        }
    }
    //空桶事件
    @EventHandler
    public void onPlayerBucketEmptyEvent(PlayerBucketEmptyEvent event) {
        antiBuildEvent = new AntiBuildEvent(event.getPlayer());
        getServer().getPluginManager().callEvent(antiBuildEvent);
        if (antiBuildEvent.isCancelled()) {
            event.setCancelled(true);
        }
    }
    //装桶事件
    @EventHandler
    public void onPlayerBucketFillEvent(PlayerBucketFillEvent event) {
        antiBuildEvent = new AntiBuildEvent(event.getPlayer());
        getServer().getPluginManager().callEvent(antiBuildEvent);
        if (antiBuildEvent.isCancelled()) {
            event.setCancelled(true);
        }
    }
    //盔甲架交互事件
    @EventHandler
    public void onPlayerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent event){
        antiBuildEvent = new AntiBuildEvent(event.getPlayer());
        getServer().getPluginManager().callEvent(antiBuildEvent);
        if (antiBuildEvent.isCancelled()) {
            event.setCancelled(true);
        }
    }
    //盔甲架 / 末影水晶 破坏事件
    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event){
        if (event.getEntity().getType().equals(EntityType.ARMOR_STAND) || event.getEntity().getType().equals(EntityType.ENDER_CRYSTAL)){
            if (event.getDamager().getType().equals(EntityType.PLAYER)) {
                antiBuildEvent = new AntiBuildEvent((Player) event.getDamager());
                getServer().getPluginManager().callEvent(antiBuildEvent);
                if (antiBuildEvent.isCancelled()) {
                    event.setCancelled(true);
                }
            }
        }
    }
    //盔甲架放置事件
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event){
        if (event.getItem() != null && event.getItem().getType() != null) {
            if (event.getItem().getType().equals(Material.ARMOR_STAND) || event.getItem().getType().equals(Material.END_CRYSTAL)) {
                antiBuildEvent = new AntiBuildEvent(event.getPlayer());
                getServer().getPluginManager().callEvent(antiBuildEvent);
                if (antiBuildEvent.isCancelled()) {
                    event.setCancelled(true);
                }
            }
        }
    }
    //展示框放置事件
    @EventHandler
    public void onHangingPlaceEvent(HangingPlaceEvent event){
        antiBuildEvent = new AntiBuildEvent(event.getPlayer());
        getServer().getPluginManager().callEvent(antiBuildEvent);
        if (antiBuildEvent.isCancelled()) {
            event.setCancelled(true);
        }
    }
    //展示框破坏事件
    @EventHandler
    public void onHangingBreakEvent(HangingBreakByEntityEvent event){
        if (event.getRemover() instanceof Player) {
            antiBuildEvent = new AntiBuildEvent((Player) event.getRemover());
            getServer().getPluginManager().callEvent(antiBuildEvent);
            if (antiBuildEvent.isCancelled()) {
                event.setCancelled(true);
            }
        }
    }
    //展示框交互 / 末影水晶爆炸 事件
    @EventHandler
    public void onPlayerInteractAtEntityEvent(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        if (event.getRightClicked().getType().equals(EntityType.ITEM_FRAME) || event.getRightClicked().getType().equals(EntityType.ENDER_CRYSTAL)){
            antiBuildEvent = new AntiBuildEvent(player);
            getServer().getPluginManager().callEvent(antiBuildEvent);
            if (antiBuildEvent.isCancelled()) {
                event.setCancelled(true);
            }
        }
    }
}
