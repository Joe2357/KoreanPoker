package koreanpoker;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HandClass implements CommandExecutor {
	private boolean[] isUsedHand = new boolean[20];
	private int isUsed = 0;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) {
		if (command.equals("kp")) {
			if (args.length == 0) { // 파라미터가 없을 경우
				sender.sendMessage(ChatColor.WHITE + "------------------------------" + "\n" + ChatColor.DARK_AQUA + "["
						+ ChatColor.AQUA + "KoreanPoker" + ChatColor.DARK_AQUA + "]" + ChatColor.WHITE + " 명령어 도움말"
						+ "\n" + ChatColor.YELLOW + "    /kp" + ChatColor.WHITE + " :: 도움말을 나타냅니다" + "\n"
						+ ChatColor.YELLOW + "    /kp reset" + ChatColor.WHITE + " :: 게임을 초기화합니다" + "\n"
						+ ChatColor.YELLOW + "    /kp start " + ChatColor.GOLD + "[2 / 3]" + ChatColor.WHITE
						+ " :: 섯다 게임을 실행합니다" + "\n" + ChatColor.WHITE + "------------------------------\n");
				return true;
			} else if (args[0].equals("reset")) {
				for (int i = 0; i < 20; i++) {
					isUsedHand[i] = false;
				}
				isUsed = 0;
				((Player) sender).performCommand("clear @a");
				sender.sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker" + ChatColor.DARK_AQUA
						+ "] " + ChatColor.WHITE + "초기화되었습니다");
				return true;
			} else if (args[0].equals("start")) {
				if (args.length == 1 || !args[1].equals("2") && !args[1].equals("3")) {
					sender.sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker" + ChatColor.DARK_AQUA
							+ "] " + ChatColor.WHITE + "정확한 숫자를 입력해주세요!");
					return true;
				}
				int handCount = 2;
				if (args[1].equals("3")) {
					handCount += 1;
				}
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
						isUsed += handCount;
					}
				} else {
					sender.sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker" + ChatColor.DARK_AQUA
							+ "] " + ChatColor.WHITE + "초기화가 되지 않았거나, 인원이 너무 많습니다!");
				}
				return true;
			}
		}
		return true;
	}
}