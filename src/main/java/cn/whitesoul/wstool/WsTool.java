package cn.whitesoul.wstool;

import cn.whitesoul.wslib.message.ServerInfo;
import cn.whitesoul.wstool.listener.AntiBuild;
import cn.whitesoul.wstool.listener.AntiWeatherChange;
import cn.whitesoul.wstool.listener.AntiWorldTimeChange;
import org.bukkit.plugin.java.JavaPlugin;

public final class WsTool extends JavaPlugin {
    public static WsTool INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        saveDefaultConfig();
        ServerInfo serverInfo = new ServerInfo(this);
        serverInfo.sendInfo("&b 欢迎使用 &f白魂工具");
        serverInfo.sendInfo("&b 作者: &f白魂");
        serverInfo.sendInfo("&b 服务器版本: &f" + getServer().getVersion());
        serverInfo.sendInfo("&b 当前功能: ");
        //注册监听器
        getServer().getPluginManager().registerEvents(new AntiBuild(), this);
        getServer().getPluginManager().registerEvents(new AntiWeatherChange(), this);
        getServer().getPluginManager().registerEvents(new AntiWorldTimeChange(), this);

    }

    @Override
    public void onDisable() {
    }
}
