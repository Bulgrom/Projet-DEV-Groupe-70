package party;
import map.Map;
import trap.Trap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import map.Character;

public class Party {
	
	private static String backSpace = System.lineSeparator();
	private int id;
	private String name;
	private Map map;
	private LinkedList<Character> characters = new LinkedList<Character>();
	//private LinkedList<Trap> traps = new LinkedList<Trap>();
	//private Weather weather;

	public Party(){
		String directory = "saveParty/";
		File d = new File(directory);
		d.mkdir();
		setId(d.list().length+1);
	};
	
	public Party(String partyDirectory) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		map = new Map(partyDirectory);
		File directory = new File(partyDirectory);
		for(int i=1; i<directory.list().length-1; i++){
			characters.add(new Character(partyDirectory + "Character_"+i+".txt"));
		}
		BufferedReader reader = new BufferedReader(new FileReader(partyDirectory+"data.txt"));
		setName(reader.readLine());
		reader.close();
		
	}
	
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public Map getMap(){
		return map;
	}
	
	public LinkedList<Character> getCharacters(){
		return characters;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void loadMap(String mapDirectory) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		map = new Map(mapDirectory);
	}
	
	public void loadCharacter(String characterFilename) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		Character c = new Character(characterFilename);
		c.setId(characters.size()+1);
		characters.add(c);
	}
	
	
	public void saveParty(){
		String directory = "saveParty/party" + id + "/";
		new File(directory).mkdirs();

		try {
	    	File file = new File(directory + "data.txt");
	        file .createNewFile();
	        final FileWriter writer = new FileWriter(file);
	        try {
	        	writer.write(name + backSpace);
	        }
	        finally {
	            writer.close();
	        }
	    }
	    catch (Exception e) {
	        System.out.println("Impossible de creer le fichier du Personnage " + name);
	    }
		
		map.saveMap(directory);
		for(int i=0; i<characters.size();i++){
			characters.get(i).saveCharacterWithId(directory);
		}
	}
	
	public void saveNewParty(){
		String directory = "saveParty/";
		File d = new File(directory);
		d.mkdir();
		setId(d.list().length+1);
		saveParty();
	}
}
