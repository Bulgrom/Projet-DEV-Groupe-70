package map ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import ability.trap.*;
import element.Element;

public class Square {
	private Background background;
	private int height = 0;
	private Element elem;
	private Character pers;
	private Trap trap;
	private int[] coord = new int[2];
	private Map map;
	
	
	public Square(int i, int j, Map map){
		setCoord(i, j);
		setMap(map);
	}
	
	public Square(String codex, int i, int j, String directory, Map map) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		setCoord(i,j);
		setMap(map);
		String[] separator = codex.split("b");
		setBackground(getBackgroundById(Integer.parseInt(separator[0])));
		if (separator.length == 2){
			separator[0] = separator[1];
		
			if (separator[0].contains("h")){
				separator = separator[0].split("h");
				setHeight(Integer.parseInt(separator[0]));
				if (separator.length == 2) separator[0] = separator[1];
			}
		
			if (separator[0].contains("e")){
				separator = separator[0].split("e");
				setElement(directory, Integer.parseInt(separator[0]));
				if (separator.length == 2) separator[0] = separator[1];
			}
			
			if (separator[0].contains("t")){
				separator = separator[0].split("t");
				setTrap(directory, Integer.parseInt(separator[0]));
				if (separator.length == 2) separator[0] = separator[1];
			}
		
			if (separator[0].contains("p")){
				separator = separator[0].split("p");
				setCharacter(new Character(directory + "Character_" +separator[0] + ".txt"));
				if (separator.length == 2) separator[0] = separator[1];
			}
		}
	}

	public Background getBackground(){
		return background;
	}
	
	public Background getBackgroundById(int id){
		for(Background b : Background.values()){
			if(b.getId() == id) return b;
		}
		System.out.println("Id not found");
		return Background.EMPTY;
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
	
	public Trap getTrap(){
		return trap;
	}
	
	public int[] getCoord(){
		return coord;
	}
	
	public Map getMap(){
		return map;
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
	
	public void setElement(String directory, int id) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(new File(directory + "Element.txt")));
		
		String line;
		try {
			line = reader.readLine();
			while (line != null){
				if(Integer.parseInt(line.split("_")[0]) == id) setElement((Element) Class.forName(line.split("_")[1]).newInstance());
				line = reader.readLine();
			}
			getElement().setId(id);
		} catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			reader.close();
		}


	}
	
	public void setCharacter(Character pers){
		if(pers != null){
			pers.setPosition(this);
			this.pers = pers;
		}
		else this.pers = pers;
	}
	
	public void setTrap(Trap trap){
		this.trap = trap;
	}
	
	public void setTrap(String directory, int id) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(new File(directory + "Trap.txt")));
		
		String line;
		try {
			line = reader.readLine();
			while (line != null){
				if(Integer.parseInt(line.split("_")[0]) == id) setTrap((Trap) Class.forName(line.split("_")[1]).newInstance());
				line = reader.readLine();
			}
			getTrap().setId(id);
		} catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			reader.close();
		}
	}
	
	public void setCoord(int i, int j){
		coord[0] = i;
		coord[1] = j;
	}
	
	public void setMap(Map map){
		this.map = map;
	}
	
	public String toString(){
		String line = background.getId() + "b";
		if (height != 0){
			line = line + height + "h";
		}
		if (elem != null){
			line = line + elem.getId() + "e";
		}
		/*if (trap != null){
			line = line + trap.getId() + "t";
		}*/
		if (pers != null){
			line = line + pers.getId() + "p";
		}
		return line;
}

	public boolean equals(Object square){
		if(!(square instanceof Square)) return false;
		
		Square s = (Square) square;
		
		if (coord[0] != s.getCoord()[0]) return false;
		if (coord[1] != s.getCoord()[1]) return false;
		
		return (this.toString().equals(s.toString()));
	}
	
}
