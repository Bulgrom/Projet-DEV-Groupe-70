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
		setParty(party);
		currentPlayer = new HumanPlayer(this, party.firstCharacters());
	}
	
	public PartyInterface(Party party, boolean firstPlayerisAI, boolean secondPlayerisAI ){
		setParty(party);
		this.firstPlayerisAI = firstPlayerisAI;
		this.secondPlayerisAI = secondPlayerisAI;
		if(this.party.isFirstPlayerTurn()){
			if(!firstPlayerisAI) currentPlayer = new HumanPlayer(this, this.party.firstCharacters());
			else currentPlayer = new AIPlayer(this, this.party.firstCharacters());
		}
		else{
			if(!secondPlayerisAI) currentPlayer = new HumanPlayer(this, this.party.firstCharacters());
			else currentPlayer = new AIPlayer(this, this.party.firstCharacters());
		}
	}
	
	public Party getParty(){
		return party;
	}
	
	public void setParty(Party party){
		this.party = party;
		party.initParty();
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
	
	public void win(int team){
		System.out.println("L'equipe " + team + " a gagne !!!");
	}
	
	/*
	public void quit(){
		return menu;
	}
	*/
	
	public void endTurn(Character characterPlayed){
		ArrayList<Character> playableCharacters = party.nextCharacters(characterPlayed);
		if(playableCharacters.size() == party.getOrder().size()) win(playableCharacters.get(0).getTeam());
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
