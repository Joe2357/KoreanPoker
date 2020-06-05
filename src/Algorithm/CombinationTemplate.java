package Algorithm;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

import Player.MyPlayer;
import Hand.Hand;

/**
 * calculate my hand, which grade do I have?
 * 
 * @author Joe2357
 */
public class CombinationTemplate {
	private static String[][] pair;

	// constructor
	public CombinationTemplate() {
		pair = new String[20][20];
		setPair();
		return;
	}

	// method that calculate result hands
	public static List<String> getMyGrade(MyPlayer mp) {
		List<String> retval = new ArrayList<String>();
		for (int i = 0; i < 20; i++) { // brute force
			for (int j = i + 1; j < 20; j++) {
				if (mp.getHand()[i] && mp.getHand()[j]) { // if player has that card
					retval.add(pair[i][j]);
				}
			}
		}
		return null;
	}

	// method that send message to player
	public List<String> sendMyGrade(MyPlayer mp) {
		List<String> retval = new ArrayList<String>();
		List<String> getResult = getMyGrade(mp);
		retval.add("");
		retval.add("------------------------------");
		retval.add(ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "KoreanPoker" + ChatColor.DARK_AQUA + "]"
				+ ChatColor.WHITE + " ���� ���� ���");
		for (String str : getResult) { // add string list
			retval.add("    " + str);
		}
		retval.add("------------------------------");
		return retval;
	}

	// combination name first initial
	public void setPair() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				// first initial ( �� )
				pair[i][j] = String.format("%d��", (i + j + 2) % 10);
				if (pair[i][j].equals("0��")) {
					pair[i][j] = "����";
				} else if (pair[i][j].equals("9��")) {
					pair[i][j] = "����";
				}
				if (i % 10 == j % 10) {
					pair[i][j] = String.format("%d��", i % 10 + 1);
					if (i % 10 + 1 == 10) {
						pair[i][j] = "�嶯";
					}
				}
			}
		}

		// stronger than ��
		pair[12][17] = "38����";
		pair[10][17] = "18����";
		pair[10][12] = "13����";
		pair[0][1] = pair[0][11] = pair[1][10] = pair[10][11] = "�˸�";
		pair[0][3] = pair[0][13] = pair[3][10] = pair[10][13] = "����";
		pair[0][8] = pair[0][18] = pair[8][10] = pair[10][18] = "����";
		pair[0][9] = pair[0][19] = pair[9][10] = pair[10][19] = "���";
		pair[3][9] = pair[3][19] = pair[9][13] = pair[13][19] = "���";
		pair[3][5] = pair[3][15] = pair[5][13] = pair[13][15] = "����";

		// special combination
		pair[13][16] = "������";
		pair[12][16] = "������";
		pair[13][18] = "�۱���";
		pair[3][8] = pair[3][18] = pair[8][13] = "����";
		return;
	}
}