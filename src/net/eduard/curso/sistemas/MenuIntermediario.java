package net.eduard.curso.sistemas;

import net.eduard.api.EduardAPI;
import net.eduard.api.lib.plugin.IPluginInstance;
import net.eduard.curso.Main;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import net.eduard.api.lib.menu.Menu;

public class MenuIntermediario implements IPluginInstance {


	public MenuIntermediario(Plugin plugin) {
		Menu menu = new Menu("Mudar velocidade", 3,(m)->{

			return null;
		});
//		for (Player p : Mine.getPlayers()) {
////			p.getInventory().addItem(menu.getItemKey());
//
//		}
//		menu.getItems().put(10,
//				SimpleMenu.newItem(Material.LEATHER_BOOTS, 1, 0, "§aVelocidade 1", "§aClique para mudar sua velocidade"));
//		menu.getItems().put(11,
//				SimpleMenu.newItem(Material.CHAINMAIL_BOOTS, 1, 0, "§aVelocidade 2", "§aClique para mudar sua velocidade"));
//		menu.getItems().put(12,
//				SimpleMenu.newItem(Material.GOLD_BOOTS, 1, 0, "§aVelocidade 3", "§aClique parea mudar sua velocidade"));
//		menu.getItems().put(13,
//				SimpleMenu.newItem(Material.IRON_BOOTS, 1, 0, "§aVelocidade 4", "§aClique para mudar sua velocidade"));
//		menu.getItems().put(14,
//				SimpleMenu.newItem(Material.DIAMOND_BOOTS, 1, 0, "§aVelocidade 5", "§aClique para mudar sua velocidade"));


		menu.registerMenu(this);
		menu.setEffect(event -> {
			if (event.getWhoClicked() instanceof Player) {
				Player p = (Player) event.getWhoClicked();
				int slot = event.getRawSlot();
				if (slot == 10) {
					p.setWalkSpeed(0.2f);
					p.setFlySpeed(0.1f);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 1f);
				}
				if (slot == 11) {
					p.setWalkSpeed(0.4f);
					p.setFlySpeed(0.3f);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 1f);
				}
				if (slot == 12) {
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 1f);
					p.setWalkSpeed(0.6f);
					p.setFlySpeed(0.5f);
				}
				if (slot == 13) {
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 1f);
					p.setWalkSpeed(0.8f);
					p.setFlySpeed(0.7f);
				}
				if (slot == 14) {
					p.setWalkSpeed(1f);
					p.setFlySpeed(1F);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 1f);
				}

			}

		});
	}

	@Override
	public Main getPlugin() {
		return Main.getInstance();
	}
}
