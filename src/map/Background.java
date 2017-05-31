package map;
import java.awt.Color;

public enum Background {

	GRASS (1, "grass", Color.GREEN),
	WATER (2, "water", Color.BLUE),
	SAND  (3, "sand", Color.YELLOW),
	EMPTY (0, "empty", Color.BLACK);
	
	private int id;
	private String name;
	private Color color;
	
	Background(int id, String name, Color color){
		this.id = id;
		this.name = name;
		this.color = color;
	}

	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}

	public Color getColor(){
		return color;
	}

}
