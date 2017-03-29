import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
	private static String directory = "D:/Documents/Java/";
	private String backSpace = System.lineSeparator();
	private String name;
	private String type;
	private Square[][] map;
	private int[] dim = new int[2];
	

	
	public Map(String filename) throws IOException{
	    String[][] stringMap = readMap(new File(filename));
	    
	    this.map = new Square[dim[0]][dim[1]];
	    for(int i=0; i<dim[0]; i++){
	    	for(int j=0; j<dim[1]; j++){
	    		map[i][j] = new Square(stringMap[i][j]);
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
	
	public void setName(String name){
		this.name = name;
	}
	
	public void save(){
	    try {
	    	File file = new File(directory+type+"/"+name+".txt");
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

	public String[][] readMap(File root) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(root));
		this.name = reader.readLine();
		this.type = reader.readLine();
		String[] stringDim = reader.readLine().split("x");
		this.dim[0] = Integer.parseInt(stringDim[0]);
		this.dim[1] = Integer.parseInt(stringDim[1]);
		
		/*
		System.out.println(name);
		System.out.println(type);
		System.out.println(stringDim[0]+".x"+stringDim[1]);
		*/
		
		String[][] stringMap = new String[dim[0]][dim[1]];
		for (int i = 0; i < dim[0]; i++) {
			stringMap[i] = reader.readLine().split("_");
		}
		reader.close();
		return stringMap;
		
	}

	


}
