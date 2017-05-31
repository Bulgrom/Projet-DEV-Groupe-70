package ability;
import element.Element;
import map.Map;
import map.Square;
import map.Character;

	public abstract class Ability {
		
		private int radius;
		private String name;
		
		public Ability(){};
		
		public Ability(String name){
			this.name = name;
		}
		
		public abstract void use(Square userLoc, Square aim);
	
		public String getName(){
			return name;
		}
		
		public int getRadius(){
			return radius;
		}
		
		public abstract String getCodex();
		
		public abstract void setParameters(String[] parameters);
		
		public void setRadius(int radius){
			this.radius = radius;
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
		
		public void physicalDamage(Character c, int damage){
			if(c.getDef() < damage)	c.setPV(c.getPV() + c.getDef() - damage);
			c.checkDeath();
		}
		
		public void magicDamage(Character c, int damage){
			if(c.getDefM() < damage) c.setPV(c.getPV() + c.getDefM() - damage);
			c.checkDeath();
		}
}
