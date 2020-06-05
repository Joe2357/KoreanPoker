package Algorithm;

import java.util.List;

import Command.PlayGame;
import Player.MyPlayer;

/**
 * What is it?
 * 
 * @author Joe2357
 */
public class Winner {
	private static final int maxIndex = 33;
	private HandGrade choosedComb[] = new HandGrade[maxIndex];

	// constructor
	public Winner() {
		// Grade first initial
		setName();
		return;
	}

	// template setName initial method
	public void setName() {
		// ±§∂Ø
		choosedComb[0].setNameOfComb("38±§∂Ø");
		choosedComb[1].setNameOfComb("13±§∂Ø");
		choosedComb[2].setNameOfComb("18±§∂Ø");

		// ∂Ø
		choosedComb[3].setNameOfComb("¿Â∂Ø");
		for (int i = 4; i < 13; i++) {
			choosedComb[i].setNameOfComb(String.format("%d∂Ø", 13 - i));
		}

		// ¿œπ› ¡∂«’
		choosedComb[13].setNameOfComb("æÀ∏Æ");
		choosedComb[14].setNameOfComb("µ∂ªÁ");
		choosedComb[15].setNameOfComb("±∏ªÊ");
		choosedComb[16].setNameOfComb("¿ÂªÊ");
		choosedComb[17].setNameOfComb("¿ÂªÁ");
		choosedComb[18].setNameOfComb("ºº∑˙");

		// ≤˝
		choosedComb[19].setNameOfComb("∞©ø¿");
		for (int i = 20; i < 28; i++) {
			choosedComb[i].setNameOfComb(String.format("%d≤˝", 28 - i));
		}
		choosedComb[28].setNameOfComb("∏¡≈Î");

		// ∆Øºˆ ¡∑∫∏
		choosedComb[29].setNameOfComb("æœ«‡æÓªÁ");
		choosedComb[30].setNameOfComb("∂Ø¿‚¿Ã");
		choosedComb[31].setNameOfComb("∏€±∏ªÁ");
		choosedComb[32].setNameOfComb("±∏ªÁ");

		return;
	}

	// get winner list method
	public List<MyPlayer> getWinner() {
		for (int i = 0; i < 29; i++) { // loop all combination ( exception will be handled if statements
			if (choosedComb[i].getPlayerList().size() > 0) { // there is some players that have this combination
				if (i == 1 || i == 2) { // 13±§∂Ø or 18±§∂Ø
					if (choosedComb[29].getPlayerList().size() > 0) { // if there a player that has "æœ«‡æÓªÁ"
						return choosedComb[29].getPlayerList(); // Jackpot!
					} else {
						return choosedComb[i].getPlayerList();
					}
				} else if (i >= 4 && i < 13) { // 9∂Ø ~ 1∂Ø
					if (choosedComb[30].getPlayerList().size() > 0) { // if there a player that has "∂Ø¿‚¿Ã"
						return choosedComb[30].getPlayerList(); // Jackpot!
					} else if (choosedComb[31].getPlayerList().size() > 0) { // if there a player that has "∏€±∏ªÁ"
						return PlayGame.getPlayerList(); // all player have to re-game
					} else {
						return choosedComb[i].getPlayerList();
					}
				} else if (choosedComb[32].getPlayerList().size() > 0) { // if there a player that has "±∏ªÁ"
					return PlayGame.getPlayerList(); // all player have to re-game
				} else { // they are winners
					return choosedComb[i].getPlayerList();
				}
			}
		}
		return null;
	}

	// TODO what is this method?
	public void temp() {

		// TODO get All choosed combination from player

	}
}
