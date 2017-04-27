package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
	private static String backSpace = System.lineSeparator();
	private String name;
	private String type;
	private Square[][] map;
	private int[] dim = new int[2];
	

	public Map(){}
	
	public Map(String directory) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
	    String[][] stringMap = readMap(new File(directory + "Map.txt"));
	    
	    setMap(new Square[dim[0]][dim[1]]);
	    for(int i=0; i<dim[0]; i++){
	    	for(int j=0; j<dim[1]; j++){
	    		setSquare(i,j,new Square(directory, stringMap[i][j], i, j));
	    	}
	    }
	   }
	
	public Map(String mapDirectory, String persDirectory) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		String[][] stringMap = readMap(new File(mapDirectory + "Map.txt"));
	    
	    setMap(new Square[dim[0]][dim[1]]);
	    for(int i=0; i<dim[0]; i++){
	    	for(int j=0; j<dim[1]; j++){
	    		setSquare(i,j,new Square(persDirectory, stringMap[i][j], i, j));
	    	}
	    }
	}
	
	public Map(int length, int height){
		map = new Square[length][height];
		dim[0] = length;
		dim[1] = height;
		for(int i=0; i<length; i++){
			for(int j=0; j<height; j++){
				map[i][j] = new Square();
				map[i][j].setBackground(new Background(1));
			}
		}
	}
	
	public Map(String name, Square[][] map){
		this.name = name;
		this.type = "initial";
		this.map = map;
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
	
	public String getType(){
		return this.type;
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
	
	public void setType(String type){
		this.type = type;
	}
	
	public String[][] readMap(File root) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(root));
		setName(reader.readLine());
		setType(reader.readLine());
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
	    	// Ajouter un createur de dossier
	    	File file = new File(directory+"/"+name+".txt");
	        file .createNewFile();
	        final FileWriter writer = new FileWriter(file);
	        try {
	        	writer.write(name + backSpace + type + backSpace + dim[0] + "x" + dim[1] + backSpace);
	        	for (int i=0; i < dim[0]; i++){
	        		for (int j=0; j < dim[1]; j++){
	        			writer.write(getSquare(i, j) + "_");
	        			//writer.write(stringMap[i][j] + "_");
	        		}
	        		writer.write("\r\n");
	        	}
	        }
	        finally {
	            writer.close();
	        }
	    }
	    catch (Exception e) {
	        System.out.println("Impossible de creer le fichier");
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
	


}