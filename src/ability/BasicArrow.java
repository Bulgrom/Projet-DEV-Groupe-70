package ability;

import map.Character;
import map.Element;
import map.Map;
import map.Square;

public class BasicArrow extends Ability{
	private int damage;
	private String name = "Punch";
	private int radius = 5;
	//private String description;
	
	public BasicArrow(){}
	
	public BasicArrow(int damage, int radius){
		this.damage = damage;
		this.radius = radius;
	}
	
	public String getName(){
		return name;
	}
	
	public String getCodex(){
		return "BasicArrow" + "-" + damage + "-" + radius; 
	}
	
	public void setDamage(int dmg){
		this.damage = dmg;
	}
	
	public void setRadius(int radius){
		this.radius = radius;
	}
	
	public void setParameters(String[] parameters){
		if (parameters.length != 2) System.out.println("Erreur dans setParameters de Punch");
		
		setDamage(Integer.parseInt(parameters[0]));
		setRadius(Integer.parseInt(parameters[1]));
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
