package cn.whitesoul.wstool.listener.anti;

import cn.whitesoul.wstool.WsTool;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class AntiAttackEffect {

    public static void register() {
        ProtocolManager pm = ProtocolLibrary.getProtocolManager();
        pm.addPacketListener(new PacketAdapter(WsTool.INSTANCE, ListenerPriority.NORMAL, PacketType.Play.Server.WORLD_PARTICLES){
            @Override
            public void onPacketSending(PacketEvent event) {
                PacketContainer packetContainer = event.getPacket();
                List<EnumWrappers.Particle> particles = packetContainer.getParticles().getValues();

                if(particles.contains(EnumWrappers.Particle.DAMAGE_INDICATOR)) {
                int i = particles.indexOf(EnumWrappers.Particle.DAMAGE_INDICATOR);
                event.getPacket().getIntegers().write(i,1);
            } else {
                     event.setCancelled(true);
                 }
            }
        });
    }
}
