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
								+ ChatColor.DARK_AQUA + "]" + ChatColor.WHITE + " 게임이 실행되지 않았습니다! 먼저 게임을 실행해 주십시오\n");
						return true;
					}
				} else if (args[0].equals("start")) { // start game
					if (args.length == 1) { // "/kp start"
						sender.sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker"
								+ ChatColor.DARK_AQUA + "]" + ChatColor.WHITE + " 잘못된 명령어입니다! 숫자를 입력해주세요\n");
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
									+ ChatColor.DARK_AQUA + "]" + ChatColor.WHITE + " 입력이 잘못되었습니다! 2 또는 3을 입력해주세요\n");
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
				+ ChatColor.AQUA + "KoreanPoker" + ChatColor.DARK_AQUA + "]" + ChatColor.WHITE + " 명령어 도움말" + "\n"
				+ ChatColor.YELLOW + "    /kp" + ChatColor.WHITE + " :: 도움말을 나타냅니다" + "\n" + ChatColor.YELLOW
				+ "    /kp reset" + ChatColor.WHITE + " :: 게임을 초기화합니다" + "\n" + ChatColor.YELLOW + "    /kp start "
				+ ChatColor.GOLD + "[2 / 3]" + ChatColor.WHITE + " :: 섯다 게임을 실행합니다" + "\n" + ChatColor.WHITE
				+ "------------------------------\n");
		return;
	}
}
