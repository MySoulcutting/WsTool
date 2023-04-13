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
    public static int AntiDropDelay = WsTool.INSTANCE.getConfig().getInt("AntiDrop.Delay");
    public static String  AntiDropNoMessages = WsTool.INSTANCE.getConfig().getString("AntiDrop.NoMessage");
    public static String  AntiDropMessages = WsTool.INSTANCE.getConfig().getString("AntiDrop.Message");
    public static String  AntiDropYesMessages = WsTool.INSTANCE.getConfig().getString("AntiDrop.YesMessage");
    public static Boolean AntiDropCommands = WsTool.INSTANCE.getConfig().getBoolean("AntiDrop.Commands");
    public static List<String>  AntiJoinWorld = WsTool.INSTANCE.getConfig().getStringList("AntiJoinWorld.Worlds");
    public static String  AntiJoinWorldMessage = WsTool.INSTANCE.getConfig().getString("AntiJoinWorld.Message");
    public static Boolean AntiAttackEffect = WsTool.INSTANCE.getConfig().getBoolean("AntiAttackEffect.Enable");
    public static Boolean AntiEnderEgg = WsTool.INSTANCE.getConfig().getBoolean("AntiEnderEgg.Enable");
    public static String AntiEnderEggMessage = WsTool.INSTANCE.getConfig().getString("AntiEnderEgg.Message");
    public static Boolean ViewFrame = WsTool.INSTANCE.getConfig().getBoolean("ViewFrame.Enable");

}
