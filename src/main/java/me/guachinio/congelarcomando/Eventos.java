package me.guachinio.congelarcomando;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class Eventos implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player p = (Player) event.getPlayer();

        if (CongelarAPI.estaCongelado(p)) {
            System.out.println("Evento: Congelamento");
            event.setCancelled(true);
        } else {
            System.out.println("Evento: Descongelamento");
            event.setCancelled(false);
        }
    }
}
