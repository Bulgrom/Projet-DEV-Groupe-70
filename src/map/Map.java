package map;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import element.Element;
import ability.trap.Trap;


public class Map {
	private static String backSpace = System.lineSeparator();
	private String name;
	private Square[][] map;
	protected int[] dim = new int[2];
	
	
	public Map(String directory) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
	    String[][] stringMap = readMap(new File(directory + "Map.txt"));
	    
	    setMap(new Square[dim[0]][dim[1]]);
	    for(int i=0; i<dim[0]; i++){
	    	for(int j=0; j<dim[1]; j++){
	    		setSquare(i,j,new Square(stringMap[i][j], i, j, directory, this));
	    	}
	    }
	   }
	
	public Map(int height, int length){
		map = new Square[height][length];
		setDim(height, length);
		for(int i=0; i<height; i++){
			for(int j=0; j<length; j++){
				map[i][j] = new Square(i, j, this);
				map[i][j].setBackground(Background.GRASS);
			}
		}
	}
			
	public String getName(){
		return name;
	}
	
	public Square[][] getMap(){
		return map;
	}
	
	public Square getSquare(int n, int m){
		return map[n][m];
	}
	

	public int getLines(){
		return dim[0];
	}
	
	public int getColumns(){
		return dim[1];
	}
	
	public int[] getDim(){
		return dim;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setMap(Square[][] map){
		this.map = map;
	}
	
	public void setSquare(int i, int j, Square square){
		map[i][j] = square;
	}
	
	public void setDim(int i, int j){
		dim[0] = i;
		dim[1] = j;
	}
	
	public String[][] readMap(File root) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(root));
		setName(reader.readLine());
		String[] stringDim = reader.readLine().split("x");
		this.dim[0] = Integer.parseInt(stringDim[0]);
		this.dim[1] = Integer.parseInt(stringDim[1]);
		
		String[][] stringMap = new String[dim[0]][dim[1]];
		for (int i = 0; i < dim[0]; i++) {
			stringMap[i] = reader.readLine().split("_");
		}
		reader.close();
		return stringMap;
		
	}

	public void saveMap(String directory){
	    try {
			new File(directory).mkdirs();
	    	File file = new File(directory + "Map.txt");
	        file .createNewFile();
	        (new File(directory + "Element.txt")).createNewFile();
	        (new File(directory + "Trap.txt")).createNewFile();
	        final FileWriter writer = new FileWriter(file);
	        
	        LinkedList<Element> elementList = new LinkedList<Element>();
	        LinkedList<Trap> trapList = new LinkedList<Trap>();
	        
	        final FileWriter elementWriter = new FileWriter(new File(directory + "Element.txt"));
	        final FileWriter trapWriter = new FileWriter(new File(directory + "Trap.txt"));
	        try {
	        	writer.write(name + backSpace + dim[0] + "x" + dim[1] + backSpace);
	        	for (int i=0; i < dim[0]; i++){
	        		for (int j=0; j < dim[1]; j++){
	        			writer.write(getSquare(i, j) + "_");
	        			if((getSquare(i,j).getElement() != null) && !(elementList.contains(getSquare(i,j).getElement()))) 
	        					elementList.add(getSquare(i,j).getElement());
	        			if((getSquare(i,j).getTrap() != null) && !(trapList.contains(getSquare(i,j).getTrap()))) 
        						trapList.add(getSquare(i,j).getTrap());
	        		}
	        		writer.write(backSpace);
	        	}
	        	
	        	for(int i=0; i<elementList.size();i++){
	        		elementWriter.write(elementList.get(i).getCodex() + backSpace);
	        	}
	        	
	        	for(int i=0; i<trapList.size(); i++){
	        		trapWriter.write(trapList.get(i).getCodex() + backSpace);
	        	}
	        }
	        finally {
	            writer.close();
	            elementWriter.close();
	            trapWriter.close();
	        }
	    }
	    catch (Exception e) {
	        System.out.println("Impossible de creer le fichier Map " + name);
	    }
	}

	public String toString(){
		String str = "";
		for(int i=0; i<dim[0]; i++){
	    	for(int j=0; j<dim[1]; j++){
	    		str += getSquare(i,j) + " ";
	    	}
	    	str += backSpace;
	    }
		return str;
	}
	
	public boolean equals(Object map){
		if(!(map instanceof Map)) return false;
		
		Map m = (Map) map;
		
		return (m.toString().equals(this.toString())) && (m.getName().equals(name));
	}

}