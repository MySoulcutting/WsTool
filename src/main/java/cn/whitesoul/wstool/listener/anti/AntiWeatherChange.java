package cn.whitesoul.wstool.listener.anti;

import cn.whitesoul.wslib.message.Message;
import cn.whitesoul.wstool.config.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.WorldLoadEvent;

public class AntiWeatherChange implements Listener {
    @EventHandler
    public void onWorldLoadEvent(WorldLoadEvent event) {
        //遍历世界名字
        for (String worldName : Config.AntiWeatherWorld) {
            String name = worldName.split("#")[0];
            String weather = worldName.split("#")[1];
            //判断是否为该世界
            if (event.getWorld().getName().equalsIgnoreCase(name)) {
                //更改改世界天气
                switch (weather) {
                    case "sun":
                        event.getWorld().setStorm(false);
                        event.getWorld().setThundering(false);
                        System.out.println("§b成功将§f " + event.getWorld().getName() + " §b天气设置为§e晴天!");
                        break;
                    case "rain":
                        event.getWorld().setStorm(true);
                        event.getWorld().setThundering(false);
                        System.out.println("§b成功将§f " + event.getWorld().getName() + " §b天气设置为§5雨雪天!");
                        break;
                    case "thunder":
                        event.getWorld().setStorm(true);
                        event.getWorld().setThundering(true);
                        System.out.println("§b成功将§f " + event.getWorld().getName() + " §b天气设置为§c雷暴天!");
                        break;
                }
            }
        }
    }
    @EventHandler
    public void onWeatherChangeEvent(WeatherChangeEvent event){
        for (String worldName : Config.AntiWeatherWorld) {
            String name = worldName.split("#")[0];
            //判断是否为该世界
            if (event.getWorld().getName().equalsIgnoreCase(name)) {
                event.setCancelled(true);
            }
        }
    }
}
