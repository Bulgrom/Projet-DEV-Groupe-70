package ability.damageAbility;
import map.Square;
import map.Character;
import map.Map;
import map.Element;
import ability.Ability;


public class Punch extends Ability {

	private int damage;
	private String name = "Punch";
	private int radius = 1;
	//private String description;
	
	public Punch(){}
	
	public Punch(int damage){
		this.damage = damage;
	}
	
	public String getName(){
		return name;
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
				p.setPV(p.getPV()-damage);
			}
		}
	}
	
	
	public boolean range(Square userLocation, Square aim){
		Map map = userLocation.getMap();
		
		if(Math.abs(userLocation.getCoord()[0] - aim.getCoord()[0]) 
				+ Math.abs(userLocation.getCoord()[1] - aim.getCoord()[1]) > radius) return false;

		float[] vertex = new float[2];
		vertex[0] = aim.getCoord()[0] - userLocation.getCoord()[0];
		vertex[1] = aim.getCoord()[1] - userLocation.getCoord()[1];
		for(int k=0; k< radius*10;k++){
			Element elem = map.getSquare(Math.round((float)k/(radius*10)*vertex[0] + userLocation.getCoord()[0]),
					Math.round((float)k/(radius*10)*vertex[1] + userLocation.getCoord()[1])).getElement();
			if((elem != null) && (!elem.allowView()))	return false;
		}

		return true;
	}
	
	
	
	
	
}
