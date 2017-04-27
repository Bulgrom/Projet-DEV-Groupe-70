package Main;

import java.io.IOException;

public class Square {
	private Background background;
	private int height = 0;
	private Element elem;
	private Character pers;
	private int[] coord = new int[2];
	
	
	public Square(){}
	
	public Square(String directory, String codex, int i, int j) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		setCoord(i,j);
		String[] separator = codex.split("b");
		setBackground(new Background(Integer.parseInt(separator[0])));
		if (separator.length == 2){
			separator[0] = separator[1];
		
			separator = separator[0].split("h");
			if (separator.length == 2){
				setHeight(Integer.parseInt(separator[0]));
				separator[0] = separator[1];
			}
		
			separator = separator[0].split("e");
			if (separator.length == 2){
				setElement(new Element(Integer.parseInt(separator[0])));
				separator[0] = separator[1];
			}
		
			separator = separator[0].split("p");
			if (separator.length == 1){
				setCharacter(new Character(directory + "personage" +separator[0] + ".txt"));
			}
		}
	}

	public Background getBackground(){
		return background;
	}
	
	public int getHeight(){
		return height;
	}

	public Element getElement(){
		return elem;
	}
	
	public Character getCharacter(){
		return pers;
	}
	
	public int[] getCoord(){
		return coord;
	}
	
	public void setBackground(Background background){
		this.background = background;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
	public void setElement(Element elem){
		this.elem = elem;
	}
	
	public void setCharacter(Character pers){
		this.pers = pers;
	}
	
	public void setCoord(int i, int j){
		coord[0] = i;
		coord[1] = j;
	}
	
	public String toString(){
		String line = background.getId() + "b";
		if (height != 0){
			line = line + height + "h";
		}
		if (elem != null){
			line = line + elem.getId() + "e";
		}
		if (pers != null){
			line = line + pers.getId() + "p";
		}
		return line;
}

}
