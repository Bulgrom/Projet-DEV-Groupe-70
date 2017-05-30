package player;

import java.util.ArrayList;

import map.Character;
import party.PartyInterface;

public class AIPlayer extends HumanPlayer {
	
	public AIPlayer(PartyInterface partyInterface, ArrayList<Character> playableCharacters){
		super(partyInterface, playableCharacters);
	}

	public void main(String[] args){
		System.out.println("AI turn");
		endTurn();
	}
}
