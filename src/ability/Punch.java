package ability;
import map.Square;
import map.Character;


public class Punch extends Ability {

	private int damage;
	private String name = "Punch";
	//private String description;
	
	public Punch(){}
	
	public Punch(int damage){
		this.damage = damage;
	}
	
	public String getName(){
		return name;
	}
	
	public String getCodex(){
		return "Punch" + "-" + damage; 
	}
	
	public void setDamage(int dmg){
		this.damage = dmg;
	}
	
	public void setParameters(String[] parameters){
		if (parameters.length != 1) System.out.println("Erreur dans setParameters de Punch");
		
		setDamage(Integer.parseInt(parameters[0]));
	}
	
	public void use(Square square){
		Character p = square.getCharacter();
		if (p != null){
			p.setPV(p.getPV()-damage);
		}
	}
}
