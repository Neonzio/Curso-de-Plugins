package net.eduard.curso.rankup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import net.eduard.api.lib.storage.Storable;
import net.eduard.api.lib.modules.StorageAttributes;

public class RankManager implements Storable {

	public RankManager() {
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Rank> ranks = new ArrayList<>();
	
	
	public Rank getRank(String nome) {
		for (Rank rank : ranks) {
			if (rank.getName().equalsIgnoreCase(nome)) {
				return rank;
			}
		}
		return null;
	}
	public Rank getRankPelaPosicao(int posicao) {
		for (Rank rank : ranks) {
			if (rank.getPosicao() == posicao) {
				return rank;
			}
		}
		return null;
	}
	public Rank getRank(int level) {
		for (Rank rank : ranks) {
			if (rank.getLevel() == level) {
				return rank;
			}
		}
		return null;

	}


	@StorageAttributes(reference = true)
	private Map<UUID, Rank> players = new HashMap<>();

	public Map<UUID, Rank> getPlayers() {
		return players;
	}

	public void setPlayers(Map<UUID, Rank> players) {
		this.players = players;
	}

	public ArrayList<Rank> getRanks() {
		return ranks;
	}

	public void setRanks(ArrayList<Rank> ranks) {
		this.ranks = ranks;
	}

	public void register(Rank rank) {
		ranks.add(rank);

	}

	public Rank getRank(Player player) {
		Rank rank = players.get(player.getUniqueId());
		if (rank == null) {
			rank = getRank(1);
			players.put(player.getUniqueId(), rank);
		}
		return rank;
	}


}
