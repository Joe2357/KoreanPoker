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
	private static final String[] handTemplate = { "1Í≈", "2Í≈", "3Í≈", "4Í≈", "5Í≈", "6Í≈", "7Í≈", "8Í≈", "9Í≈", "10Í≈", "1Œ√",
			"∏≈¡∂ ( 2 )", "3Œ√", "»ÊΩŒ∏Æ ( 4 )", "√  ( 5 )", "∏Ò¥‹ ( 6 )", "»´ΩŒ∏Æ ( 7 )", "8Œ√", "±π¡¯ ( 9 )", "«≥ ( 10 )" };

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
		myItemMeta.setLore(Arrays.asList("°◊fº∏¥Ÿ ∆–"));
		item.setItemMeta(myItemMeta);
		return item;
	}
}
