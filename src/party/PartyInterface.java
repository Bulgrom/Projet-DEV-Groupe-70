package party;
import player.*;

import java.util.ArrayList;

import map.Character;

public class PartyInterface {
	private Party party;
	private boolean firstPlayerisAI = false;
	private boolean secondPlayerisAI = false;
	private HumanPlayer currentPlayer;
	
	
	public PartyInterface(Party party){
		this.party = party;
		currentPlayer = new HumanPlayer(this, party.firstCharacters());
	}
	
	public PartyInterface(Party party, boolean firstPlayerisAI, boolean secondPlayerisAI ){
		this.party = party;
		this.firstPlayerisAI = firstPlayerisAI;
		this.secondPlayerisAI = secondPlayerisAI;
		if(party.isFirstPlayerTurn()){
			if(!firstPlayerisAI) currentPlayer = new HumanPlayer(this, party.firstCharacters());
			else currentPlayer = new AIPlayer(this, party.firstCharacters());
		}
		else{
			if(!secondPlayerisAI) currentPlayer = new HumanPlayer(this, party.firstCharacters());
			else currentPlayer = new AIPlayer(this, party.firstCharacters());
		}
	}
	
	public Party getParty(){
		return party;
	}
	
	public HumanPlayer getCurrentPlayer(){
		return currentPlayer;
	}
	
	
	public void save(){
		party.saveParty();
	}
	
	public void newSave(){
		party.saveNewParty();
	}
	
	/*
	public void quit(){
		return menu;
	}
	*/
	
	public void endTurn(Character characterPlayed){
		ArrayList<Character> playableCharacters = party.nextCharacters(characterPlayed);
		if(party.isFirstPlayerTurn()){
			if(!firstPlayerisAI) currentPlayer = new HumanPlayer(this, playableCharacters);
			else currentPlayer = new AIPlayer(this, playableCharacters);
		}
		else{
			if(!secondPlayerisAI) currentPlayer = new HumanPlayer(this, playableCharacters);
			else currentPlayer = new AIPlayer(this, playableCharacters);
		}
	}
	
	
	}
