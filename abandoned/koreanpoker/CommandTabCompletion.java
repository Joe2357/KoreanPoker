package koreanpoker;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class CommandTabCompletion implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (alias.equals("koreanpoker") || alias.equals("kp")) {
			if (args.length == 1) {
				List<String> myList = new ArrayList<>();
				myList.add("reset");
				myList.add("start");
				return myList;
			} else if (args.length == 2) {
				if (args[0].equals("start")) {
					List<String> myList = new ArrayList<>();
					myList.add("2");
					myList.add("3");
					return myList;
				}
			}
		}
		return null;
	}
}
