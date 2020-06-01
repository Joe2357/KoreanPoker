package Command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import Player.MyPlayer;
import Scoreboard.Scoreboard;

/**
 * Method section to play Korean Poker
 * 
 * @author user
 */
public class PlayGame {
	// List of players
	private static List<MyPlayer> playerList = new ArrayList<MyPlayer>();

	// playerlist get method
	public static List<MyPlayer> getPlayerList() {
		return playerList;
	}

	// reset all the games
	public static void resetGame() {
		Scoreboard.deleteScoreBoard();
		playerList.clear(); // remove all objects
		for (Player p : Bukkit.getOnlinePlayers()) { // add all players to the ArrayList
			playerList.add(new MyPlayer(p));
		}
		return;
	}

	// command that starts Korean Poker
	public void startGame(int mode) {
		resetGame(); // reset before start game

		// scoreboard setting
		Scoreboard.createScoreBoard();
		Scoreboard.setScoreBoard();

		// TODO make game statements
		// mode : 2 or 3 ( number of hands )
		return;
	}
}
