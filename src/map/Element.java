package map;


public class Element {

	private int id;
	private String name;
	private String spriteLoc;
	private boolean hideView;
	private boolean[] allowDir = new boolean[4];
	
	public Element(int id){
		this.id = id;
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

	public boolean getHideView(){
	return hideView;
}

	public boolean[] getAllowDir(){
	return allowDir;
}

	public boolean getNorth(){
	return allowDir[0];
}

	public boolean getEast(){
	return allowDir[1];
}

	public boolean getSouth(){
	return allowDir[2];
}

	public boolean getWest(){
	return allowDir[3];
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

	public void setHideView(boolean hideView){
		this.hideView = hideView;
	}
	
	public void setAllowDir(boolean[] allowDir){
		this.allowDir = allowDir;
	}

	public void setNorth(boolean north){
		allowDir[0] = north;
	}
	
	public void setEast(boolean east){
		allowDir[1] = east;
	}
	
	public void setSouth(boolean south){
		allowDir[2] = south;
	}
	
	public void setWest(boolean west){
		allowDir[3] = west;
	}
	
	
	
}