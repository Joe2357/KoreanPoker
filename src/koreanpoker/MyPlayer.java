package koreanpoker;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MyPlayer {
	private Player user;
	private int[] hand = new int[3];
	private static final List<String> loreList = Arrays.asList("��f���� ��");
	private static final String[] handTemplate = { "1��", "2��", "3��", "4��", "5��", "6��", "7��", "8��", "9��", "10��", "1��",
			"���� ( 2 )", "3��", "��θ� ( 4 )", "�� ( 5 )", "��� ( 6 )", "ȫ�θ� ( 7 )", "8��", "���� ( 9 )", "ǳ ( 10 )" };

	public MyPlayer(Player sender) {
		user = sender;
		handClear();
	}

	public void handClear() {
		for (int i = 0; i < 3; i++)
			hand[i] = -1;
	}

	public void setHand(int index, int input) {
		hand[index] = input;
	}

	public void giveHand() {
		for (int i = 0; i < 3; i++) {
			if (hand[i] < 0)
				return;
			user.getInventory().addItem(setItem(new ItemStack(Material.PAPER), handTemplate[hand[i]]));
		}
	}

	private ItemStack setItem(ItemStack itemStack, String name) {
		ItemMeta myItemMeta = itemStack.getItemMeta();
		myItemMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 0, true);
		myItemMeta.setDisplayName(name);
		myItemMeta.setLore(loreList);
		itemStack.setItemMeta(myItemMeta);
		return itemStack;
	}
}
