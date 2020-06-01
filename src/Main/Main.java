package Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import Command.GetCommand;
import Scoreboard.Scoreboard;

/**
 * Minecraft Plugin to play Korean Poker
 * 
 * @author Joe2357
 */
public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		enableMessage();
		getCommand("koreanpoker").setExecutor(new GetCommand());
		getCommand("test").setExecutor(new GetCommand());
		return;
	}

	@Override
	public void onDisable() {
		Scoreboard.deleteScoreBoard();
		disableMessage();
		return;
	}

	public void enableMessage() {
		PluginDescriptionFile pdFile = this.getDescription();
		Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "----------------------------------------");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "MCMPS" + ChatColor.DARK_AQUA
				+ "]" + ChatColor.WHITE + " 플러그인이 활성화되었습니다.");
		Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "플러그인 이름 : " + ChatColor.WHITE + pdFile.getName());
		Bukkit.getConsoleSender()
				.sendMessage(ChatColor.RED + "Version : " + ChatColor.WHITE + "v" + pdFile.getVersion());
		Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "----------------------------------------");
		return;
	}

	public void disableMessage() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "----------------------------------------");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "MCMPS" + ChatColor.DARK_AQUA
				+ "]" + ChatColor.WHITE + " 플러그인이 비활성화되었습니다.");
		Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "----------------------------------------");
		return;
	}
}