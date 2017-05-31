package player;
import party.*;
import java.util.ArrayList;
import map.Character;
import map.Square;
import map.Status;
import ability.Ability;

public class HumanPlayer {
	private PartyInterface partyInterface;
	private ArrayList<Character> playableCharacters = new ArrayList<Character>();
	private Character currentCharacter;
	private boolean characterPlayed = false;
	
	
	public HumanPlayer(PartyInterface partyInterface, ArrayList<Character> playableCharacters){
		this.partyInterface = partyInterface;
		this.playableCharacters = playableCharacters;
		this.currentCharacter = playableCharacters.get(0);
	}
	
	public Character getCurrentCharacter(){
		return currentCharacter;
	}
	
	public Character getPlayableCharacter(int index){
		return playableCharacters.get(index);
	}
	
	public void changeCharacter(Character character){
		if (!characterPlayed){
			if(playableCharacters.contains(character)) currentCharacter = character;
		}
		else System.out.println("You can't change, you've already played a character");
	}
	
	public void move(Square square){
		currentCharacter.move(square);
		characterPlayed = true;
		if(currentCharacter.isDead()){
			partyInterface.getParty().getOrder().remove(currentCharacter);
			endTurn();
		}
	}
	
	public void useAction(Ability ability, Square square){
		currentCharacter.useAbility(ability, square);
		if(square.getCharacter().getStatus() == Status.DEAD) partyInterface.getParty().getOrder().remove(square.getCharacter());
		characterPlayed = true;
	}
	
	public void endTurn(){
		currentCharacter.incPlayTime();
		currentCharacter.resetMovement();
		currentCharacter.resetAction();
		currentCharacter.resetPv();
		partyInterface.endTurn(currentCharacter);
	}
	
}
