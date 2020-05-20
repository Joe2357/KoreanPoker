package koreanpoker;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HandClass implements CommandExecutor {
	private static boolean[] isUsedHand = new boolean[20];
	private static int isUsed = 0;
	private List<MyPlayer> allUser = new ArrayList<MyPlayer>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) {
		if (command.equals("koreanpoker") || command.equals("kp")) {
			if (args.length == 0) { // �Ķ���Ͱ� ���� ���
				getHelp((Player) sender);
				return true;
			} else if (args[0].equals("reset")) {
				clearGame((Player) sender);
				return true;
			} else if (args[0].equals("start")) {
				if (args.length == 1 || !args[1].equals("2") && !args[1].equals("3")) {
					sender.sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker" + ChatColor.DARK_AQUA
							+ "] " + ChatColor.WHITE + "��Ȯ�� ���ڸ� �Է����ּ���!");
					return true;
				}
				startGame((Player) sender, Integer.parseInt(args[1]));
				return true;
			}
		}
		return true;
	}

	public static void getHelp(Player user) {
		user.sendMessage(ChatColor.WHITE + "------------------------------" + "\n" + ChatColor.DARK_AQUA + "["
				+ ChatColor.AQUA + "KoreanPoker" + ChatColor.DARK_AQUA + "]" + ChatColor.WHITE + " ��ɾ� ����" + "\n"
				+ ChatColor.YELLOW + "    /kp" + ChatColor.WHITE + " :: ������ ��Ÿ���ϴ�" + "\n" + ChatColor.YELLOW
				+ "    /kp reset" + ChatColor.WHITE + " :: ������ �ʱ�ȭ�մϴ�" + "\n" + ChatColor.YELLOW + "    /kp start "
				+ ChatColor.GOLD + "[2 / 3]" + ChatColor.WHITE + " :: ���� ������ �����մϴ�" + "\n" + ChatColor.WHITE
				+ "------------------------------\n");
	}

	public void clearGame(Player user) {
		allUser.clear();
		for (int i = 0; i < 20; i++)
			isUsedHand[i] = false;
		isUsed = 0;
		user.performCommand("clear @a minecraft:paper");
		user.sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker" + ChatColor.DARK_AQUA + "] "
				+ ChatColor.WHITE + "�ʱ�ȭ�Ǿ����ϴ�");
	}

	public void startGame(Player user, int handCount) {
		if (isUsed + handCount * Bukkit.getOnlinePlayers().size() <= 20) {
			for (Player target : Bukkit.getOnlinePlayers()) {
				MyPlayer newPlayer = new MyPlayer(target);
				for (int i = 0; i < handCount; i++) {
					int temp = 0;
					do {
						temp = (int) (Math.random() * 20);
					} while (isUsedHand[temp]);
					newPlayer.setHand(i, temp);
					isUsedHand[temp] = true;
				}
				newPlayer.giveHand();
				allUser.add(newPlayer);
				isUsed += handCount;
			}
		} else
			user.sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker" + ChatColor.DARK_AQUA + "] "
					+ ChatColor.WHITE + "�ʱ�ȭ�� ���� �ʾҰų�, �ο��� �ʹ� �����ϴ�!");
	}
}