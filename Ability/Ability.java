package Ability;
import Main.Square;

	public abstract class Ability {
		
		public Ability(){};
		
		public abstract void use(Square square);
	
		public abstract String getName();
	
		//public abstract String getDescription();
	

}
