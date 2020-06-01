package Player;

import org.bukkit.entity.Player;

/**
 * Player Object that playing Korean Poker
 * 
 * @author Joe2357
 */
public class MyPlayer {
	private Player player; // object master
	private int money; // how many emeralds this player have?

	// constructor ( first initial )
	public MyPlayer(Player p) {
		player = p;
		money = 100;
		return;
	}
	
	// player get method
	public Player getPlayer() {
		return player;
	}
	
	// money get method
	public int getMoney() {
		return money;
	}
	
	// add or subtract money
	public void addMoney(int value) {
		money += value;
		return;
	}
	
	// check whether player use all money
	public boolean isDead() {
		return money <= 0;
	}
}
