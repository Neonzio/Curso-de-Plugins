package net.eduard.curso.projeto.essentials;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * Comando de trocar o gamemode seu e de outros jogadores
 * @author Eduard
 *
 */

public class ComandoGamemode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender snd, Command cmd, String arg, String[] args) {
		if (snd instanceof Player) {
			Player p = (Player) snd;
			if (args.length == 0) {
				if (p.getGameMode().equals(GameMode.CREATIVE)) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage("§eSeu modo de jogo foi mudado sobrevivencia");
				} else {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage("§eSeu modo de jogo foi mudado criativo");
				}
			} else if (args.length == 1) {
				String a = args[0];
				if (a.equalsIgnoreCase("0")) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage("§eSeu modo de jogo foi mudado Sobrevivencia");
				} else if (a.equalsIgnoreCase("1")) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage("§eSeu modo de jogo foi mudado Criativo");
				} else if (a.equalsIgnoreCase("2")) {
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage("§eSeu modo de jogo foi mudado Aventura");
				}
			} else {
				Player b = Bukkit.getPlayer(args[1]);
				if (b != null) {
					if (args[0].equalsIgnoreCase("0")) {
						b.setGameMode(GameMode.SURVIVAL);
						snd.sendMessage("§eO modo de jogo de " + b.getName() + "foi mudado para sobrevivencia");
					} else if (args[0].equalsIgnoreCase("1")) {
						b.setGameMode(GameMode.CREATIVE);
						snd.sendMessage("§eO modo de jogo de " + b.getName() + "foi mudado para sobrevivencia");
					}
				} else {
					snd.sendMessage("§cEste jogador nao esta online, ou nao existe.");
				}
			}
		}
		return false;
	}

}
