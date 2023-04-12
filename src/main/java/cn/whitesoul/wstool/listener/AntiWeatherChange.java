package cn.whitesoul.wstool.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherEvent;

public class AntiWorldWeather implements Listener {
    @EventHandler
    public void onWeatherChange(WeatherEvent event) {
        event.getWorld().setWeatherDuration();
        event.setCancelled(true);
    }
}
