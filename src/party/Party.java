package party;
import map.Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import map.Character;

public class Party {
	
	private static String backSpace = System.lineSeparator();
	private int id;
	private Calendar date = Calendar.getInstance() ;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.ENGLISH);
	private Map map;
	private ArrayList<Character> allCharacters = new ArrayList<Character>();
	private ArrayList<Character> order = new ArrayList<Character>();
	private Character lastCharacter;
	private int numberOfTurns = 0;

	public Party(){
		String directory = "saveParty/";
		File d = new File(directory);
		d.mkdir();
		setId(d.list().length+1);
	};
	
	public Party(String partyDirectory) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		(new File("saveParty/")).mkdir();
		map = new Map(partyDirectory);
		for(int i=0; i<map.getLines(); i++){
			for(int j=0; j<map.getColumns();j++){
				if(map.getSquare(i, j).getCharacter() != null) allCharacters.add(map.getSquare(i, j).getCharacter());
			}
			
		}
		
		BufferedReader reader = new BufferedReader(new FileReader(partyDirectory+"data.txt"));
		try {
			setDate(reader.readLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setNumberOfTurns(Integer.parseInt(reader.readLine()));
		reader.close();
	}
	
	
	public int getId(){
		return id;
	}
	
	public Map getMap(){
		return map;
	}
	
	public String getDate(){
		return sdf.format(date.getTime());
	}
	
	public int getNumberOfTurns(){
		return numberOfTurns;
	}
	
	public Character getCharacter(int index){
		return allCharacters.get(index);
	}
	
	public ArrayList<Character> getAllCharacters(){
		return allCharacters;
	}
	
	public Character getOrder(int index){
		return order.get(index);
	}
	
	public ArrayList<Character> getOrder(){
		return order;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setDate(String date) throws ParseException{
		this.date.setTime(sdf.parse(date));
	}
	
	public void setNumberOfTurns(int numberOfTurns){
		this.numberOfTurns = numberOfTurns;
	}
	
	public void incTurns(){
		numberOfTurns++;
	}

	public boolean isFirstPlayerTurn(){
		return order.get(0).getTeam() == 1;
	}
	
	
	public ArrayList<Character> firstCharacters(){
		ArrayList<Character> playableCharacters = new ArrayList<Character>();
		playableCharacters.add(order.get(0));
		int index = 1;
		while( index < order.size() && (order.get(0).getTeam() == order.get(index).getTeam()) ){
			playableCharacters.add(order.get(index));
			index++;
		}
		return playableCharacters;
	}
	
	public void initParty(){
		order = new ArrayList<Character>();
		for(int i=0; i<allCharacters.size();i++){
			order.add(allCharacters.get(i));
		}
		order.sort((Character o1, Character o2) -> o1.getSpeed()-o2.getSpeed());
		lastCharacter = order.get(order.size()-1);
		
	}
	
	public ArrayList<Character> nextCharacters(Character characterPlayed){
		ArrayList<Character> playableCharacters = new ArrayList<Character>();
		
		if (characterPlayed.equals(lastCharacter)){
			for(int i=0; i<allCharacters.size(); i++) allCharacters.get(i).decPlayTime();
		}
		
		int index;
		if(order.contains(characterPlayed)){
			order.remove(characterPlayed);
		
			playableCharacters.add(order.get(0));
			index = 1;

			while(index < order.size() && ((characterPlayed.getTeam() == order.get(index).getTeam()) ||
					(characterPlayed.getSpeed()*characterPlayed.getPlayTime() >= order.get(index).getSpeed()*order.get(index).getPlayTime()))){
				index++;
			}
			order.add(index,characterPlayed);
		}
		
		index = 1;
		while( index < order.size() && (order.get(0).getTeam() == order.get(index).getTeam()) ){
			playableCharacters.add(order.get(index));
			index++;
		}
		
		return playableCharacters;
	}
	
	
	public void loadMap(String mapDirectory) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		map = new Map(mapDirectory);
	}
	
	public void loadCharacter(String characterFilename) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		Character c = new Character(characterFilename);
		c.setId(allCharacters.size()+1);
		allCharacters.add(c);
		initParty();
	}
	
	
	public void saveParty(){
		String directory = "saveParty/party" + id + "/";
		new File(directory).mkdirs();

		try {
	    	File file = new File(directory + "data.txt");
	        file .createNewFile();
	        final FileWriter writer = new FileWriter(file);
	        try {
	        	writer.write(getDate() + backSpace + numberOfTurns + backSpace);
	        }
	        finally {
	            writer.close();
	        }
	    }
	    catch (Exception e) {
	        System.out.println("Impossible de creer le fichier de la party " + id);
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
