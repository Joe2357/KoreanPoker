package Command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Algorithm.CombinationTemplate;
import Player.MyPlayer;
import Scoreboard.Scoreboard;
import Hand.Hand;

/**
 * Method section to play Korean Poker
 * 
 * @author Joe2357
 */
public class PlayGame {
	// List of players
	private static List<MyPlayer> playerList = new ArrayList<MyPlayer>();
	private int gameMode;

	// constructor
	public PlayGame(int mode) {
		gameMode = mode;
		initGame();
		return;
	}

	// player list get method
	public static List<MyPlayer> getPlayerList() {
		return playerList;
	}

	// initial all the games
	public void initGame() {
		Scoreboard.deleteScoreBoard();
		playerList.clear(); // remove all objects
		for (Player p : Bukkit.getOnlinePlayers()) { // add all players to the ArrayList
			playerList.add(new MyPlayer(p));
		}
		return;
	}

	// command that starts Korean Poker
	public void startGame() {
		initGame(); // reset before start game

		if (playerList.size() * gameMode > 20) { // out of range
			for (MyPlayer mp : playerList) {
				mp.getPlayer().sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker"
						+ ChatColor.DARK_AQUA + "]" + ChatColor.WHITE + " 인원이 너무 많아 게임을 실행할 수 없습니다!\n");
			}
			return;
		}

		// scoreboard setting
		Scoreboard.createScoreBoard();
		Scoreboard.setScoreBoard();

		// game section
		while (playerList.size() > 1) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "clear @a minecraft:paper"); // clear all hands
			doingTurn();

			// TODO make betting method
			
			// TODO make player to choose one combination of their hands

			// TODO calculate who is the winner of this game
			
			// TODO give and take money from players

			// check dead person
			for (MyPlayer mp : playerList) {
				if (mp.isDead()) {
					for (Player p : Bukkit.getOnlinePlayers()) { // print he was dead
						p.sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker" + ChatColor.DARK_AQUA
								+ "] " + ChatColor.GREEN + playerList.get(0).getPlayer().getName() + ChatColor.RED
								+ " 님이 파산하였습니다..\n");
					}
					playerList.remove(mp); // remove him from player list
				}
			}

			Scoreboard.setScoreBoard();
		}

		// print result
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker" + ChatColor.DARK_AQUA + "] "
					+ ChatColor.GREEN + playerList.get(0).getPlayer().getName() + ChatColor.WHITE + " 님이 우승하였습니다!\n");
		}

		return;

	}

	// doing 1 turn of Korean Poker
	public void doingTurn() {
		// hand first initial
		boolean isUsed[] = new boolean[20];
		for (int i = 0; i < 20; i++) {
			isUsed[i] = false;
		}

		// player first initial
		for (MyPlayer mp : playerList) {

			mp.resetHand(); // clear hands
			mp.setUsingMoney(0);

			// serve hand
			for (int i = 0; i < gameMode; i++) {
				int rnd;
				do {
					rnd = (int) (Math.random() * 20);
				} while (isUsed[rnd]); // unused random integer created
				isUsed[rnd] = true;
				mp.setHand(rnd);
				Hand.giveHand(mp.getPlayer(), rnd); // serving hand
			}

			// push 1 emeralds in pot
			mp.addMoney(-1);
			mp.addUsingMoney(1);
			mp.getPlayer().getInventory().remove(new ItemStack(Material.EMERALD, 1));

			List<String> tempList = new CombinationTemplate().getMyGrade(mp);
			mp.getPlayer().sendMessage(tempList.toArray(new String[tempList.size()])); // send which grade of hand do I
																						// have?
		}

		Scoreboard.setScoreBoard();
		return;
	}
}
