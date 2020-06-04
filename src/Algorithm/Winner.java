package Algorithm;

/**
 * What is it?
 * 
 * @author Joe2357
 */
public class Winner {
	private HandGrade choosedComb[] = new HandGrade[33];

	// constructor
	public Winner() {
		// Grade first initial
		setName();
		
		// TODO get All choosed combination from player
		
		// TODO check who is winner, and return Myplayer object
		
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
}
