package Hand;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Java Class to give players a card ( hand )
 * 
 * @author Joe2357
 */
public class Hand {
	// card name template
	private static final String[] handTemplate = { "1��", "2��", "3��", "4��", "5��", "6��", "7��", "8��", "9��", "10��", "1��",
			"���� ( 2 )", "3��", "��θ� ( 4 )", "�� ( 5 )", "��� ( 6 )", "ȫ�θ� ( 7 )", "8��", "���� ( 9 )", "ǳ ( 10 )" };

	// method that gives players a card ( hand )
	public static void giveHand(Player p, int hand) {
		ItemStack item = makeItem(hand);
		p.getInventory().addItem(item);
		return;
	}

	// make custom item function
	private static ItemStack makeItem(int hand) {
		ItemStack item = new ItemStack(Material.PAPER); // paper ( hand )
		ItemMeta myItemMeta = item.getItemMeta();
		myItemMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 0, true);
		myItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS); // hide enchant statements
		myItemMeta.setDisplayName(handTemplate[hand]);
		myItemMeta.setLore(Arrays.asList("��f���� ��"));
		item.setItemMeta(myItemMeta);
		return item;
	}
}
