package Main;

import java.io.IOException;

public class Square {
	private Background background;
	private int height = 0;
	private Element elem;
	private Personage pers;
	
	
	public Square(){}
	
	public Square(String directory, String codex) throws IOException{
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
				setPersonage(new Personage(directory + "personage" +separator[0] + ".txt"));
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
	
	public Personage getPersonage(){
		return pers;
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
	
	public void setPersonage(Personage pers){
		this.pers = pers;
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
