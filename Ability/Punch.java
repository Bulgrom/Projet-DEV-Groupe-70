package Ability;
import Main.Square;
import Main.Character;


public class Punch extends Ability {

	private int damage;
	private String name = "Attaque Basique";
	private String description;
	
	public Punch(int damage){
		this.damage = damage;
	}
	
	public String getName(){
		return name;
	}
	
	public void use(Square square){
		Character p = square.getCharacter();
		if (p != null){
			p.setPV(p.getPV()-damage);
		}
	}
}
