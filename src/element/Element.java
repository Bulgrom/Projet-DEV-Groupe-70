package element;


public class Element {

	private int id;
	private String name;
	private String spriteLoc;
	private boolean allowView = true;
	private boolean allowWalk = true;
	
	public Element(){}
	
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

	public String getCodex(){
		return id + "_element." + name;
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
	
	public boolean equals(Object element){
		if(!(element instanceof Element)) return false;
		
		Element e = (Element) element;
		return (this.id == e.id) && (this.name == e.name);
	}
	
}