package ability.trap;

import map.Square;

public class Trap extends ability.Ability {
	
	private String name;
	private int id;
	
	public Trap(){}
	
	public boolean equals(Object trap){
		if(!(trap instanceof Trap)) return false;
		
		Trap t = (Trap) trap;
		
		return (this.id == t.id); 
	}

	public String getCodex(){
		return id + "_" + "ability.trap." + name;
	}

	@Override
	public void use(Square userLoc, Square aim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(int id){
		this.id = id;
	}
	
	@Override
	public void setParameters(String[] parameters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean range(Square userLoc, Square aim) {
		// TODO Auto-generated method stub
		return false;
	}

}
