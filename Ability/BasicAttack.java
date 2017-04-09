package Ability;
import Main.Personage;

public class BasicAttack extends Ability {
	
	private int damage;
	private String name = "Attaque Basique";
	private String description;
	
	public BasicAttack(int damage){
		this.damage = damage;
	}
	
	public String getName(){
		return name;
	}
	
	public void use(Personage pers){
		pers.pv -= damage;
	}
	
}
