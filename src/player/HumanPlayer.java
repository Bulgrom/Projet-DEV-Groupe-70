package player;
import party.*;
import java.util.ArrayList;
import map.Character;
import map.Square;
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
	
	public void changeCharacter(Character character){
		if (!characterPlayed){
			if(playableCharacters.contains(character)) currentCharacter = character;
		}
		else System.out.println("You can't change, you've already played a character");
	}
	
	public void move(Square square){
		currentCharacter.move(square);
	}
	
	public void useAction(Ability ability, Square square){
		currentCharacter.useAbility(ability, square);
	}
	
	public void endTurn(){
		currentCharacter.incPlayTime();
		currentCharacter.resetMovement();
		currentCharacter.resetAction();
		partyInterface.endTurn(currentCharacter);
	}
	
}
