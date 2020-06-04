package Command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

/**
 * Command helper when using Tab
 * 
 * @author Joe2357
 */
public class TabCompletion implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String cmd, String[] args) {

		List<String> retval = new ArrayList<String>();
		if (cmd.equals("kp") || cmd.equals("koreanpoker")) {
			if (args.length == 0) { // "/kp"
				retval.add("reset");
				retval.add("start");
				return retval;
			} else if (args.length == 1) {
				if (args[0].equals("start")) { // "/kp start"
					retval.add("2");
					retval.add("3");
					return retval;
				}
			}
		}

		return null;
	}
}
