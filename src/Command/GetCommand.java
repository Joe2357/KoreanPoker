package Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.Main;

/**
 * User input command section to play Korean Poker
 * 
 * @author Joe2357
 */
public class GetCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) {
		if (command.equals("koreanpoker") || command.equals("kp")) { // command input ( "/koreanpoker", "/kp" )
			if (args.length == 0) { // no arguments?
				getHelp((Player) sender); // call help method
				return true;
			} else { // argument is exists
				if (args[0].equals("reset")) { // reset game
					if (Main.getGame() != null) { // if exists, reset
						Main.setGame(null);
						return true;
					} else { // no game object exists
						sender.sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker"
								+ ChatColor.DARK_AQUA + "]" + ChatColor.WHITE + " ������ ������� �ʾҽ��ϴ�! ���� ������ ������ �ֽʽÿ�\n");
						return true;
					}
				} else if (args[0].equals("start")) { // start game
					if (args.length == 1) { // "/kp start"
						sender.sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker"
								+ ChatColor.DARK_AQUA + "]" + ChatColor.WHITE + " �߸��� ��ɾ��Դϴ�! ���ڸ� �Է����ּ���\n");
						return true;
					} else {
						if (args[1].equals("2")) { // "/kp start 2"
							Main.setGame(new PlayGame(2));
							Main.getGame().startGame();
							return true;
						} else if (args[1].equals("3")) { // "/kp start 3"
							Main.setGame(new PlayGame(3));
							Main.getGame().startGame();
							return true;
						} else { // Invalid integer
							sender.sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker"
									+ ChatColor.DARK_AQUA + "]" + ChatColor.WHITE + " �Է��� �߸��Ǿ����ϴ�! 2 �Ǵ� 3�� �Է����ּ���\n");
							return true;
						}
					}
				}
				return true;
			}
		}
		return true;
	}

	public static void getHelp(Player p) {
		p.sendMessage(ChatColor.WHITE + "------------------------------" + "\n" + ChatColor.DARK_AQUA + "["
				+ ChatColor.AQUA + "KoreanPoker" + ChatColor.DARK_AQUA + "]" + ChatColor.WHITE + " ��ɾ� ����" + "\n"
				+ ChatColor.YELLOW + "    /kp" + ChatColor.WHITE + " :: ������ ��Ÿ���ϴ�" + "\n" + ChatColor.YELLOW
				+ "    /kp reset" + ChatColor.WHITE + " :: ������ �ʱ�ȭ�մϴ�" + "\n" + ChatColor.YELLOW + "    /kp start "
				+ ChatColor.GOLD + "[2 / 3]" + ChatColor.WHITE + " :: ���� ������ �����մϴ�" + "\n" + ChatColor.WHITE
				+ "------------------------------\n");
		return;
	}
}
