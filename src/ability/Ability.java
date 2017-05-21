package ability;
import map.Square;

	public abstract class Ability {
		
		public Ability(){};
		
		public abstract void use(Square userLoc, Square aim);
	
		public abstract String getName();
		
		public abstract String getCodex();
		
		public abstract void setParameters(String[] parameters);
	
		//public abstract String getDescription();
		
		public abstract boolean range(Square userLoc, Square aim);
	

}
