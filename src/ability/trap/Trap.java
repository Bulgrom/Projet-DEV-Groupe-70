package ability.trap;

import map.Square;
import map.Character;

public abstract class Trap extends ability.Ability {
	
	private int id;
	
	public Trap(){}
	
	public Trap(String name){
		super(name);
	}
	
	public boolean equals(Object trap){
		if(!(trap instanceof Trap)) return false;
		
		Trap t = (Trap) trap;
		
		return (this.id == t.id); 
	}

	public String getCodex(){
		return id + "_" + "ability.trap." + getName();
	}


	public void use(Square userLoc, Square aim) {
		if(range(userLoc, aim)){
			Trap t = aim.getTrap();
			if (t != null) aim.setTrap(this);
		}
	}

	public void setId(int id){
		this.id = id;
	}
	
	public abstract void activation(Character character);
	
	public abstract void setParameters(String[] parameters);

}
