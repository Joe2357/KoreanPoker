package Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Scoreboard.Scoreboard;

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
			} else if (args.length == 1) { // argument is 1
				// TODO get user input & reset or start game
				return true;
			}
		} else if (command.equals("test")) { // only for test purpose
			Scoreboard.createScoreBoard();
			PlayGame.resetGame();
			Scoreboard.setScoreBoard();
			return true;
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
