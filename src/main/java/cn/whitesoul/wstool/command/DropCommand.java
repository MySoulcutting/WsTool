package cn.whitesoul.wstool.command;

import cn.whitesoul.wslib.message.Message;
import cn.whitesoul.wstool.WsTool;
import cn.whitesoul.wstool.config.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

import static cn.whitesoul.wstool.listener.anti.AntiDropItem.dropMap;

public class DropCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (Config.AntiDropCommands) {
            //判断dropMap
            if (sender instanceof Player) {
                UUID uuid = ((Player) sender).getUniqueId();
                if (dropMap.get(uuid)) {
                    dropMap.put(uuid, false);
                    Message.sendMessage(((Player) sender).getPlayer(), Config.AntiDropNoMessages);
                } else {
                    dropMap.put(uuid, true);
                    Message.sendMessage(((Player) sender).getPlayer(), Config.AntiDropYesMessages);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (dropMap.get(uuid)) {
                                dropMap.put(uuid, false);
                                Message.sendMessage(((Player) sender), Config.AntiDropNoMessages);
                                cancel();
                            }
                        }
                    }.runTaskTimerAsynchronously(WsTool.INSTANCE, Config.AntiDropDelay * 20L, 0);
                }
            }
        }
        return false;
    }
}
