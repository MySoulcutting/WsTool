package cn.whitesoul.wstool.config;

import cn.whitesoul.wslib.message.Message;
import cn.whitesoul.wstool.WsTool;

import java.util.List;

public class Config {
    public static String AntiBuildMessage = WsTool.INSTANCE.getConfig().getString("AntiBuild.Message");
    public static List<String> AntiBuildWorld = WsTool.INSTANCE.getConfig().getStringList("AntiBuild.Worlds");
    public static List<String> AntiWeatherWorld = WsTool.INSTANCE.getConfig().getStringList("AntiWeather.Worlds");
    public static List<String> AntiWorldTimeWorld = WsTool.INSTANCE.getConfig().getStringList("AntiWorldTime.Worlds");
    public static List<String> AntiDropWorld = WsTool.INSTANCE.getConfig().getStringList("AntiDrop.Worlds");

}
