package net.eduard.curso.sistemas;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;



/**
 * Sistema de Delay ao fazer qualquer teleport
 * 
 * @author Eduard
 *
 */
public class TodosTeleportesTerDelay implements Listener {

	public int delaySeconds = 3;

	@EventHandler
	public void event(PlayerTeleportEvent e) {
		Player p = e.getPlayer();
		if (!teleporting.contains(p)) {
//			if (!p.hasPermission("delay.bypass")) {
			e.setCancelled(true);
			teleporting.add(p);
			new BukkitRunnable() {

				@Override
				public void run() {
					p.teleport(e.getTo());
					teleporting.remove(p);
				}
			}.runTaskLater(JavaPlugin.getProvidingPlugin(TodosTeleportesTerDelay.class), delaySeconds * 20);
//			}
		}
	}

	public static List<Player> teleporting = new ArrayList<>();

}
