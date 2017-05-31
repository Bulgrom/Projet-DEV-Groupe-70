package element;


public class Element {

	private int id;
	private String name;
	private String spriteLoc;
	private boolean allowView = true;
	private boolean allowWalk = true;
	
	public Element(int id){
		this.id = id;
	}
	
	public Element(int id, boolean allowWalk, boolean hideView){
		this.id = id;
		this.allowWalk = allowWalk;
		this.allowView = hideView;
	}
	
	public int getId(){
		return id;
	}

	public String getName(){
	return name;
}

	public String getSpriteLoc(){
	return spriteLoc;
}

	public boolean allowView(){
	return allowView;
}

	public boolean isWalkable(){
	return allowWalk;
}


	public void setId(int id){
		this.id = id;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public void setSpriteLoc(String spriteLoc){
		this.spriteLoc = spriteLoc;
	}

	public void setView(boolean hideView){
		this.allowView = hideView;
	}
	
	public void setWalkable(boolean allowWalk){
		this.allowWalk = allowWalk;
	}

	
	
}