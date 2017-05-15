package map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import ability.*;

public class Character {
	private static String backSpace = System.lineSeparator();
	public String name;
	private int id;
	private int pv;
	private int pm;
	private int pa;
	private int def;
	private int defM;
	private int speed;
	private Ability[] ability;
	private Square position;
	
	public Character(){}
	
	public Character(String filename) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
	    readPlayer(new File(filename));
	}
	
	public Character(String name, int id, int pv, int pm, int pa, int def, int defM, int speed, Ability[] ability){
		setName(name);
		setId(id);
		setPV(pv);
		setPM(pm);
		setPA(pa);
		setDef(def);
		setDefM(defM);
		setSpeed(speed);
		setAbilities(ability);
	}
	
	public Character(String name, int id, int pv, int pm, int pa, int def, int defM, int speed){
		setName(name);
		setId(id);
		setPV(pv);
		setPM(pm);
		setPA(pa);
		setDef(def);
		setDefM(defM);
		setSpeed(speed);
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPV(){
		return pv;
	}
	
	public int getPM(){
		return pm;
	}
	
	public int getPA(){
		return pa;
	}
	
	public int getDef(){
		return def;
	}
	
	public int getDefM(){
		return defM;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public Square getPosition(){
		return position;
	}
	
	public Ability getAbility(int index){
		return ability[index];
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setPV(int pv){
		this.pv = pv;
	}
	
	public void setPM(int pm){
		this.pm = pm;
	}
	
	public void setPA(int pa){
		this.pa = pa;
	}
	
	public void setDef(int def){
		this.def = def;
	}
	
	public void setDefM(int defM){
		this.defM = defM;
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	public void setPosition(Square position){
		this.position = position;
	}
	
	public void setAbilities(Ability[] ability){
		this.ability = new Ability[ability.length];
		for (int i=0; i<ability.length;i++){
			this.ability[i] = ability[i];
		}
	}
	
	public void setStringAbilities(String[] stringAbility) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		ability = new Ability[stringAbility.length];
		for(int i=0; i<stringAbility.length; i++){
			String[] parameters = stringAbility[i].split("-");
			this.ability[i] = (Ability) Class.forName("ability."+parameters[0]).newInstance();
			this.ability[i].setParameters(Arrays.copyOfRange(parameters, 1, parameters.length));
		}
	}
	
	public void move(Square square){
		if(checkMove(square)){
			getPosition().setCharacter(null);
			setPosition(square);
		}
	}
	
	public boolean checkMove(Square square){
		if(!(square.getCharacter()==null)) return false;
		
		return true;
	}
	
	
	public void readPlayer(File root) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		BufferedReader reader = new BufferedReader(new FileReader(root));
		setName(reader.readLine());
		setId(Integer.parseInt(reader.readLine()));
		setPV(Integer.parseInt(reader.readLine()));
		setPM(Integer.parseInt(reader.readLine()));
		setPA(Integer.parseInt(reader.readLine()));
		setDef(Integer.parseInt(reader.readLine()));
		setDefM(Integer.parseInt(reader.readLine()));
		setSpeed(Integer.parseInt(reader.readLine()));
		String lastLine = reader.readLine();
		if(lastLine != null) 
			setStringAbilities(lastLine.split("_"));
		reader.close();
	}
	
	
	public void saveCharacterWithName(String directory){
		 try {
			 	new File(directory).mkdirs();
		    	File file = new File(directory + name + ".txt");
		        file .createNewFile();
		        final FileWriter writer = new FileWriter(file);
		        try {
		        	writer.write(name + backSpace + id + backSpace + pv + backSpace + pm + backSpace + pa + backSpace 
		        					  + def + backSpace + defM + backSpace + speed + backSpace);
		        if( ability != null){
		        	for (int i=0; i<ability.length; i++){
		        		writer.write(ability[i].getCodex() + "_");
		        		}
		        	}
		        }
		        finally {
		            writer.close();
		        }
		    }
		    catch (Exception e) {
		        System.out.println("Impossible de creer le fichier du Personnage " + name);
		    }
	}
	
	
	public void saveCharacterWithId(String directory){
		 try {
			 	new File(directory).mkdirs();
		    	File file = new File(directory + "Character" +"_" + id + ".txt");
		        file .createNewFile();
		        final FileWriter writer = new FileWriter(file);
		        try {
		        	writer.write(name + backSpace + id + backSpace + pv + backSpace + pm + backSpace + pa + backSpace 
		        					  + def + backSpace + defM + backSpace + speed + backSpace);
		        	if( ability != null){
		        		for (int i=0; i<ability.length; i++){
		        			writer.write(ability[i].getCodex() + "_");
		        		}
		        	}
		        }
		        finally {
		            writer.close();
		        }
		    }
		    catch (Exception e) {
		        System.out.println("Impossible de creer le fichier du Personnage " + id);
		    }
	}
	
	public String toString(){
		return "name : "+name+" id : "+id+" pv : "+pv+" pm : "+pm+" pa : "+pa+" def : "+def+" defM : "+defM+" speed : "+speed;
	}
	
	public boolean equals(Object character){
		if(!(character instanceof Character)) return false;
		
		Character c = (Character) character;
		
		return (c.getName().equals(name)) && (c.getId() == id);
	}
	
	
}
