package koreanpoker;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MyPlayer {
	private Player user;
	private int[] hand = new int[3];
	private String[] template = { "1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "1光", "매조 ( 2 )", "3光",
			"흑싸리 ( 4 )", "초 ( 5 )", "목단 ( 6 )", "홍싸리 ( 7 )", "8光", "국진 ( 9 )", "풍 ( 10 )", };

	public MyPlayer(Player sender) {
		user = sender;
		hand[0] = -1;
		hand[1] = -1;
		hand[2] = -1;
	}

	public void setHand(int index, int input) {
		hand[index] = input;
		return;
	}

	public void giveHand() {
		List<String> loreList = new ArrayList<String>();
		loreList.add("§f섯다 패");
		for (int i = 0; i < 3; i++) {
			if (hand[i] < 0)
				return;
			user.getInventory().addItem(setItem(new ItemStack(Material.PAPER), template[hand[i]], loreList));
		}
	}

	private ItemStack setItem(ItemStack itemStack, String name, List<String> lore) {
		ItemMeta myItemMeta = itemStack.getItemMeta();
		myItemMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 0, true);
		myItemMeta.setDisplayName(name);
		myItemMeta.setLore(lore);
		itemStack.setItemMeta(myItemMeta);
		return itemStack;
	}
}
