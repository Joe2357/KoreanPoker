package Algorithm;

import java.util.ArrayList;
import java.util.List;

import Player.MyPlayer;
import Hand.Hand;

/**
 * calculate my hand, which grade do I have?
 * 
 * @author Joe2357
 */
public class MyHandGrade {
	private static String[][] pair;

	// constructor
	public MyHandGrade() {
		pair = new String[20][20];
		setPair();
		return;
	}

	// method that calculate result hands
	public List<String> getMyGrade(MyPlayer mp) {
		List<String> retval = new ArrayList<String>();
		retval.add("");
		retval.add("¡×f------------------------------");
		for (int i = 0; i < 20; i++) { // brute force
			for (int j = i + 1; j < 20; j++) {
				if (mp.getHand()[i] && mp.getHand()[j]) { // if player has that card
					retval.add("    " + Hand.getHandTemplate()[i] + " + " + Hand.getHandTemplate()[j] + " -> "
							+ pair[i][j]);
				}
			}
		}
		retval.add("¡×f------------------------------");
		return retval;
	}

	// combination name first initial
	public void setPair() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				// first initial ( ²ý )
				pair[i][j] = String.format("%d²ý", (i + j + 2) % 10);
				if (pair[i][j].equals("0²ý")) {
					pair[i][j] = "¸ÁÅë";
				} else if (pair[i][j].equals("9²ý")) {
					pair[i][j] = "°©¿À";
				}
				if (i % 10 == j % 10) {
					pair[i][j] = String.format("%d¶¯", i % 10 + 1);
					if (i % 10 + 1 == 10) {
						pair[i][j] = "Àå¶¯";
					}
				}
			}
		}

		// stronger than ²ý
		pair[12][17] = "38±¤¶¯";
		pair[10][17] = "18±¤¶¯";
		pair[10][12] = "13±¤¶¯";
		pair[0][1] = pair[0][11] = pair[1][10] = pair[10][11] = "¾Ë¸®";
		pair[0][3] = pair[0][13] = pair[3][10] = pair[10][13] = "µ¶»ç";
		pair[0][8] = pair[0][18] = pair[8][10] = pair[10][18] = "±¸»æ";
		pair[0][9] = pair[0][19] = pair[9][10] = pair[10][19] = "Àå»æ";
		pair[3][9] = pair[3][19] = pair[9][13] = pair[13][19] = "Àå»ç";
		pair[3][5] = pair[3][15] = pair[5][13] = pair[13][15] = "¼¼·ú";

		// special combination
		pair[13][16] = "¾ÏÇà¾î»ç";
		pair[12][16] = "¶¯ÀâÀÌ";
		pair[13][18] = "¸Û±¸»ç";
		pair[3][8] = pair[3][18] = pair[8][13] = "±¸»ç";
		return;
	}
}