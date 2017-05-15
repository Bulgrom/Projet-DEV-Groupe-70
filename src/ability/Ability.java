package ability;
import map.Square;

	public abstract class Ability {
		
		public Ability(){};
		

		
		public abstract void use(Square square);
	
		public abstract String getName();
		
		public abstract String getCodex();
		
		public abstract void setParameters(String[] parameters);
	
		//public abstract String getDescription();
	

}
