
public class Element {

	private int id;
	private String name;
	private String spriteLoc;
	private boolean hideView;
	private boolean[] blocDir; 
	
	public Element(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
}
