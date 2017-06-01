package ability.trap;

import map.Square;
import map.Character;

public abstract class Trap extends ability.Ability {
	
	private int id;
	
	public Trap(){}
	
	public Trap(String name){
		super(name);
	}
	
	public int getId(){
		return id;
	}

	public abstract String getCodex();


	public abstract void use(Square userLoc, Square aim);

	public void setId(int id){
		this.id = id;
	}
	
	public abstract void activation(Character character);
	
	public abstract void setParameters(String[] parameters);
	
	public abstract boolean equals(Object trap);

}
