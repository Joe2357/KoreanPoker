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
		// ����
		choosedComb[0].setNameOfComb("38����");
		choosedComb[1].setNameOfComb("13����");
		choosedComb[2].setNameOfComb("18����");

		// ��
		choosedComb[3].setNameOfComb("�嶯");
		for (int i = 4; i < 13; i++) {
			choosedComb[i].setNameOfComb(String.format("%d��", 13 - i));
		}

		// �Ϲ� ����
		choosedComb[13].setNameOfComb("�˸�");
		choosedComb[14].setNameOfComb("����");
		choosedComb[15].setNameOfComb("����");
		choosedComb[16].setNameOfComb("���");
		choosedComb[17].setNameOfComb("���");
		choosedComb[18].setNameOfComb("����");

		// ��
		choosedComb[19].setNameOfComb("����");
		for (int i = 20; i < 28; i++) {
			choosedComb[i].setNameOfComb(String.format("%d��", 28 - i));
		}
		choosedComb[28].setNameOfComb("����");

		// Ư�� ����
		choosedComb[29].setNameOfComb("������");
		choosedComb[30].setNameOfComb("������");
		choosedComb[31].setNameOfComb("�۱���");
		choosedComb[32].setNameOfComb("����");

		return;
	}
}
