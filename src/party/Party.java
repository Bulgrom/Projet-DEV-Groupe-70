package party;
import map.Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import map.Character;

public class Party {
	
	private static String backSpace = System.lineSeparator();
	private int id;
	private String name;
	private Map map;
	private ArrayList<Character> allCharacters = new ArrayList<Character>();
	private ArrayList<Character> firstTeam = new ArrayList<Character>();
	private ArrayList<Character> secondTeam = new ArrayList<Character>();
	private ArrayList<Character> order = new ArrayList<Character>();
	private Character lastCharacter;

	public Party(){
		String directory = "saveParty/";
		File d = new File(directory);
		d.mkdir();
		setId(d.list().length+1);
	};
	
	public Party(String partyDirectory) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		(new File("saveParty/")).mkdir();
		map = new Map(partyDirectory);
		File directory = new File(partyDirectory);
		for(int i=1; i<directory.list().length-1; i++){
			allCharacters.add(new Character(partyDirectory + "Character_"+i+".txt"));
		}
		ordered(allCharacters);
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
	
	public Character getCharacter(int index){
		return allCharacters.get(index);
	}
	
	public ArrayList<Character> getAllCharacters(){
		return allCharacters;
	}
	
	public ArrayList<Character> getFirstTeam(){
		return firstTeam;
	}
	
	public ArrayList<Character> getSecondTeam(){
		return secondTeam;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	
	public boolean isFirstPlayerTurn(){
		return firstTeam.contains(order.get(0));
	}
	
	public void ordered(ArrayList<Character> allCharacters){
		order = allCharacters;
		order.sort((Character o1, Character o2) -> o1.getSpeed()-o2.getSpeed());
		lastCharacter = order.get(order.size()-1);
	}
	
	public ArrayList<Character> firstCharacters(){
		ArrayList<Character> playableCharacters = new ArrayList<Character>();
		playableCharacters.add(order.get(0));
		int index = 1;
		while( index < order.size() && 
				((firstTeam.contains(order.get(0)) && firstTeam.contains(order.get(index))) 
				|| (secondTeam.contains(order.get(0)) && secondTeam.contains(order.get(index))))){
			playableCharacters.add(order.get(index));
			index++;
		}
		return playableCharacters;
	}
	
	
	public ArrayList<Character> nextCharacters(Character characterPlayed){
		ArrayList<Character> playableCharacters = new ArrayList<Character>();
		
		if (characterPlayed.equals(lastCharacter)){
			for(int i=0; i<allCharacters.size(); i++) allCharacters.get(i).decPlayTime();
		}
		
		order.remove(characterPlayed);
		
		playableCharacters.add(order.get(0));
		int index = 1;
		while( index < order.size() && 
				((firstTeam.contains(order.get(0)) && firstTeam.contains(order.get(index))) 
				|| (secondTeam.contains(order.get(0)) && secondTeam.contains(order.get(index))))){
			playableCharacters.add(order.get(index));
			index++;
		}
		
		index++;
		while(index < order.size() &&
				(characterPlayed.getSpeed()*characterPlayed.getPlayTime() >= order.get(index).getSpeed()*order.get(index).getPlayTime())){
			index++;
		}
		order.add(index,characterPlayed);
		
		return playableCharacters;
	}
	
	
	public void loadMap(String mapDirectory) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		map = new Map(mapDirectory);
	}
	
	public void loadCharacter(String characterFilename) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		Character c = new Character(characterFilename);
		c.setId(allCharacters.size()+1);
		allCharacters.add(c);
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
		for(int i=0; i<allCharacters.size();i++){
			allCharacters.get(i).saveCharacterWithId(directory);
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
