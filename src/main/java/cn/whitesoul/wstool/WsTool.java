package cn.whitesoul.wstool;

import cn.whitesoul.wslib.message.ServerInfo;
import cn.whitesoul.wstool.command.DropCommand;
import cn.whitesoul.wstool.config.Config;
import cn.whitesoul.wstool.listener.other.ShulkerBoxFixer;
import cn.whitesoul.wstool.listener.player.PlayerViewFrame;
import cn.whitesoul.wstool.listener.anti.*;
import cn.whitesoul.wstool.listener.player.PlayerJoinQuit;
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
        serverInfo.sendInfo("&b 插件版本: &f" + getDescription().getVersion());
        serverInfo.sendInfo("&b 服务器版本: &f" + getServer().getVersion());
        serverInfo.sendInfo("&a 当前功能: ");
        serverInfo.sendInfo("&e 1. &f禁止丢弃物品");
        serverInfo.sendInfo("&e 2. &f禁止/设定世界天气(变化)");
        serverInfo.sendInfo("&e 3. &f禁止/设定世界时间(变化)");
        serverInfo.sendInfo("&e 4. &f禁止进入指定世界");
        serverInfo.sendInfo("&e 5. &f禁止龙蛋传送");
        serverInfo.sendInfo("&e 6. &f禁止攻击粒子效果");
        serverInfo.sendInfo("&e 7. &f查看展示框内物品");
        serverInfo.sendInfo("&e 8. &f修复发射潜影盒崩服BUG");
        serverInfo.sendInfo("&a 未来功能:");
        serverInfo.sendInfo("&8 1. &f优化世界加载");

        //注册监听器
        getServer().getPluginManager().registerEvents(new AntiBuild(), this);
        getServer().getPluginManager().registerEvents(new AntiWeatherChange(), this);
        getServer().getPluginManager().registerEvents(new AntiWorldTimeChange(), this);
        getServer().getPluginManager().registerEvents(new AntiDropItem(),this);
        getServer().getPluginManager().registerEvents(new PlayerJoinQuit(),this);
        getServer().getPluginManager().registerEvents(new AntiJoinWorld(),this);
        getServer().getPluginManager().registerEvents(new AntiEnderEggTeleport(),this);
        getServer().getPluginManager().registerEvents(new PlayerViewFrame(),this);
        getServer().getPluginManager().registerEvents(new ShulkerBoxFixer(),this);
        if (Config.AntiAttackEffect) {
            AntiAttackEffect.register();
        }
        //注册命令
        getCommand("drop").setExecutor(new DropCommand());

    }

    @Override
    public void onDisable() {
    }
}
