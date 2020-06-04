package Player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Player Object that playing Korean Poker
 * 
 * @author Joe2357
 */
public class MyPlayer {
	private static final int DEPOSIT = 30;
	private Player player; // object master
	private boolean[] myHand = new boolean[20];
	private int money; // how many emeralds this player have?
	private int usingMoney; // used money in the pot in this turn

	// constructor ( first initial )
	public MyPlayer(Player p) {
		player = p;
		for (int i = 0; i < 20; i++) {
			myHand[i] = false;
		}
		money = DEPOSIT;
		player.getInventory().addItem(new ItemStack(Material.EMERALD, DEPOSIT));
		usingMoney = 0;
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

	// usingMoney get method
	public int getUsingMoney() {
		return usingMoney;
	}

	// usingMoney set method
	public void setUsingMoney(int value) {
		usingMoney = value;
		return;
	}

	// add or subtract usingMoney
	public void addUsingMoney(int value) {
		usingMoney += value;
		return;
	}

	// check whether player use all money

	public boolean isDead() {
		return money <= 0;
	}

	// remove all hands from player
	public void resetHand() {
		for (int i = 0; i < 20; i++) {
			myHand[i] = false;
		}
		return;
	}

	// set which hand does player have
	public void setHand(int idx) {
		myHand[idx] = true;
		return;
	}

	// myHand get method
	public boolean[] getHand() {
		return myHand;
	}
}
