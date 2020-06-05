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

	// get winner list method
	public List<MyPlayer> getWinner() {
		for (int i = 0; i < 29; i++) { // loop all combination ( exception will be handled if statements
			if (choosedComb[i].getPlayerList().size() > 0) { // there is some players that have this combination
				if (i == 1 || i == 2) { // 13���� or 18����
					if (choosedComb[29].getPlayerList().size() > 0) { // if there a player that has "������"
						return choosedComb[29].getPlayerList(); // Jackpot!
					} else {
						return choosedComb[i].getPlayerList();
					}
				} else if (i >= 4 && i < 13) { // 9�� ~ 1��
					if (choosedComb[30].getPlayerList().size() > 0) { // if there a player that has "������"
						return choosedComb[30].getPlayerList(); // Jackpot!
					} else if (choosedComb[31].getPlayerList().size() > 0) { // if there a player that has "�۱���"
						return PlayGame.getPlayerList(); // all player have to re-game
					} else {
						return choosedComb[i].getPlayerList();
					}
				} else if (choosedComb[32].getPlayerList().size() > 0) { // if there a player that has "����"
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
