package Algorithm;

import java.util.ArrayList;
import java.util.List;

import Player.MyPlayer;

/**
 * class that has combination's name and grade maybe do same work "struct" in C
 * 
 * @author Joe2357
 */
public class HandGrade {
	private String nameOfComb;
	private List<MyPlayer> hadPlayer = new ArrayList<MyPlayer>();
	
	// name set method
	public void setNameOfComb(String name) {
		nameOfComb = name;
		return;
	}

	// name get method
	public String getNameOfComb() {
		return nameOfComb;
	}

	// player add method
	public void addPlayer(MyPlayer mp) {
		if (hadPlayer.indexOf(mp) != -1) { // remove case of overlapped player
			hadPlayer.add(mp);
		}
		return;
	}
	
	// player list get method
	public List<MyPlayer> getPlayerList(){
		return hadPlayer;
	}
}
