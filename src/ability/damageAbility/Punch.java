package ability.damageAbility;
import map.Square;
import map.Character;
import ability.Ability;


public class Punch extends Ability {

	private int damage;
	//private String description;
	
	public Punch(){
		super("Punch");
		setRadius(1);
	}
	
	public Punch(int damage){
		super("Punch");
		this.damage = damage;
		setRadius(1);
	}
	
	public String getCodex(){
		return "ability.damageAbility.Punch" + "-" + damage; 
	}
	
	public void setDamage(int dmg){
		this.damage = dmg;
	}
	
	public void setParameters(String[] parameters){
		if (parameters.length != 1) System.out.println("Erreur dans setParameters de Punch");
		
		setDamage(Integer.parseInt(parameters[0]));
	}
	
	public void use(Square userLocation, Square aim){
		if(range(userLocation, aim)){
		
			Character p = aim.getCharacter();
			if (p != null){
				physicalDamage(p, damage);
			}
		}
	}
		
}
