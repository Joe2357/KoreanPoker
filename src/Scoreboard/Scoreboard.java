package Scoreboard;

import org.bukkit.Bukkit;

import Command.PlayGame;
import Player.MyPlayer;

/**
 * Java Class to display money of all players
 * 
 * @author Joe2357
 */
public class Scoreboard {

	// create scoreboard
	public static void createScoreBoard() {
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
				"scoreboard objectives add money dummy {\"text\":\"µ·\",\"color\":\"yellow\",\"bold\":true}");
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "scoreboard objectives setdisplay sidebar money");
		return;
	}

	// set all player's money to scoreboard
	public static void setScoreBoard() {
		for (MyPlayer mp : PlayGame.getPlayerList()) {
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
					String.format("scoreboard players set %s money %d", mp.getPlayer().getName(), 0)); // mp.getMoney()));
		}
	}

	// delete scoreboard
	public static void deleteScoreBoard() {
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "scoreboard objectives remove money");
		return;
	}
}
