package cn.whitesoul.wstool.listener;

import cn.whitesoul.wstool.WsTool;
import cn.whitesoul.wstool.config.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.scheduler.BukkitRunnable;


public class AntiWorldTimeChange implements Listener {
    @EventHandler
    public void onWorldLoadEvent(WorldLoadEvent event) {
        //创建异步任务
        new BukkitRunnable() {
            @Override
            public void run() {
                //遍历世界名字
                for (String worldName : Config.AntiWorldTimeWorld) {
                    String name = worldName.split("#")[0];
                    String time = worldName.split("#")[1];
                    //判断是否为该世界
                    if (event.getWorld().getName().equalsIgnoreCase(name)) {
                        //更改改世界时间
                        switch (time) {
                            case "day":
                                event.getWorld().setTime(1000);
                                break;
                            case "night":
                                event.getWorld().setTime(18000);
                                break;
                            case "afternoon":
                                event.getWorld().setTime(6000);
                                break;
                        }
                    }
                }
            }
        }.runTaskTimerAsynchronously(WsTool.INSTANCE,0,10);
    }
}
