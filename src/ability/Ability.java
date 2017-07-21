package ability;
import element.Element;
import map.Map;
import map.Square;
import map.Character;

import java.io.File;

import gui.SoundPlayer;


	public abstract class Ability {
		
		private int radius;
		private String name;
		private int paCost = 10;
		private String abilitySoundPath ;
		
		public Ability(){};
		
		public Ability(String name){
			this.name = name;
		}
		
		public abstract void use(Square userLoc, Square aim);
		
		public abstract String getCodex();
		
		public abstract void setParameters(String[] parameters);
		
	
		public String getName(){
			return name;
		}
		
	    
		public String getAbilitySound() {
			return this.abilitySoundPath;
		}
		
		public void setAbilitySound(String abilitySound) {
			this.abilitySoundPath = abilitySound;
		}
		
		public void playAbilitySound() {
			Thread soundThread = new Thread(new SoundPlayer(this.abilitySoundPath));
			soundThread.start();
		}
		
		public String toString() {
			return this.getName();
		}

		
		public int getRadius(){
			return radius;
		}
	
		public int getPaCost(){
			return paCost;
		}
		
		public void setRadius(int radius){
			this.radius = radius;
		}
		
		public void setPaCost(int paCost){
			this.paCost = paCost;
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
		
		public boolean checkPa(Character c){
			return c.getPA() <= paCost;
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