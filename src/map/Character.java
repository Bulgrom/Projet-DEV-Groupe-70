package map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.lang.Math;

import ability.*;

public class Character {
	private static String backSpace = System.lineSeparator();
	private String name;
	private int id;
	private int pv;
	private int pm;
	private int pa;
	private int def;
	private int defM;
	private int speed;
	private Ability[] ability;
	private Square position;
	private int maxPv;
	private int maxPm;
	private int maxPa;
	private int maxDef;
	private int maxDefM;
	private int playTime = 1;
	private int team = 0;
	private Status status = Status.HEALTHY;
	private String spriteLoc;
	
	public Character(String filename) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
	    readPlayer(new File(filename));
	}
	
	public Character(String name, int id, int pv, int pm, int pa, int def, int defM, int speed, Ability[] ability){
		setName(name);
		setId(id);
		setPV(pv);
		this.maxPv = pv;
		setPM(pm);
		this.maxPm = pm;
		setPA(pa);
		this.maxPa = pa;
		setDef(def);
		this.maxDef = def;
		setDefM(defM);
		this.maxDefM = defM;
		setSpeed(speed);
		setAbilities(ability);
	}
	
	public Character(String name, int id, int pv, int pm, int pa, int def, int defM, int speed){
		setName(name);
		setId(id);
		setPV(pv);
		this.maxPv = pv;
		setPM(pm);
		this.maxPm = pm;
		setPA(pa);
		this.maxPa = pa;
		setDef(def);
		this.maxDef = def;
		setDefM(defM);
		this.maxDefM = defM;
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
	
	public int getMaxPV(){
		return maxPv;
	}
	
	public int getPM(){
		return pm;
	}
	
	public int getMaxPM(){
		return maxPm;
	}
	
	public int getPA(){
		return pa;
	}
	
	public int getMaxPA(){
		return maxPa;
	}
	
	public int getDef(){
		return def;
	}
	
	public int getMaxDef(){
		return maxDef;
	}
	
	public int getDefM(){
		return defM;
	}
	
	public int getMaxDefM(){
		return maxDefM;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public Square getPosition(){
		return position;
	}
	
	public int getPlayTime(){
		return playTime;
	}
	
	public int getTeam(){
		return team;
	}
	
	public Status getStatus(){
		return status;
	}
	
	public String getSpriteLoc(){
		return spriteLoc;
	}
	
	public Ability getAbility(int index){
		return ability[index];
	}
	
	public int getAbilityLength() {
 		if (ability == null) {
			return 0;
 		}
 		else return ability.length;
	}
	
	public Status getStatusByName(String name){
		for(Status s: Status.values()){
			if(s.toString() == name) return s;
		}
		return Status.HEALTHY;
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
	
	public void incPlayTime(){
		playTime++;
	}
	
	public void decPlayTime(){
		playTime--;
	}
	
	public void setTeam(int team){
		this.team = team;
	}
	
	public void setStatus(Status status){
		this.status = status;
	}
	
	public void setSpriteLoc(String spriteLoc){
		this.spriteLoc = spriteLoc;
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
			this.ability[i] = (Ability) Class.forName(parameters[0]).newInstance();
			this.ability[i].setParameters(Arrays.copyOfRange(parameters, 1, parameters.length));
		}
	}
	
	
	public void useAbility(Ability ability, Square aim){
		if(Arrays.asList(this.ability).contains(ability)){
			ability.use(position, aim);
		}else System.out.println(name + " ne connait pas la capacite " + ability);
	}
	
	public void move(Square square){
		if(checkMove(square)){
			getPosition().setCharacter(null);
			square.setCharacter(this);
			
		}
	}
	
	public boolean checkMove(Square square){
		if(!(square.getCharacter()==null)) return false;
		if(Math.abs(position.getCoord()[0] - square.getCoord()[0]) 
				+ Math.abs(position.getCoord()[1] - square.getCoord()[1]) > pm) return false;
		Path path = new Path(position, square, pm);
		if(!path.isReachable()) return false;
		
		return true;
	}
		
	
	
	public void resetAction(){
		if(status == Status.PARALYSED){
			pa += Math.floorDiv(maxPa, 3);
		}else{
			pa += Math.floorDiv(maxPa*2,3);
		}
		if(pa > maxPa) pa = maxPa;
	}
	
	public void resetMovement(){
		if(status == Status.INERT){
			pm += Math.floorDiv(maxPm, 3);
		}else{
			pm += Math.floorDiv(maxPm*2, 3);
		}
		if(pm > maxPm) pm = maxPm;
	}
	
	public void resetPv(){
		if(status == Status.BURNED) pv -= Math.floorDiv(maxPv, 10);
		checkDeath();
	}
	
	public void checkDeath(){
		if(pv <= 0) status = Status.DEAD;
	}
	
	public boolean isDead(){
		return status == Status.DEAD;
	}
	
	
	public void readPlayer(File root) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		BufferedReader reader = new BufferedReader(new FileReader(root));
		setName(reader.readLine());
		setId(Integer.parseInt(reader.readLine()));
		String[] pv = reader.readLine().split("_");
		setPV(Integer.parseInt(pv[0]));
		this.maxPv = Integer.parseInt(pv[1]);
		
		String[] pm = reader.readLine().split("_");
		setPM(Integer.parseInt(pm[0]));
		this.maxPm = Integer.parseInt(pm[1]);
		
		String[] pa = reader.readLine().split("_");
		setPA(Integer.parseInt(pa[0]));
		this.maxPa = Integer.parseInt(pa[1]);
		
		String[] def = reader.readLine().split("_");
		setDef(Integer.parseInt(def[0]));
		this.maxDef = Integer.parseInt(def[1]);
		
		String[] defM = reader.readLine().split("_");
		setDefM(Integer.parseInt(defM[0]));
		this.maxDefM = Integer.parseInt(defM[1]);
		
		setSpeed(Integer.parseInt(reader.readLine()));
		
		playTime = Integer.parseInt(reader.readLine());
		
		team = Integer.parseInt(reader.readLine());
		
		status = getStatusByName(reader.readLine());
		
		setSpriteLoc(reader.readLine());
				
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
		        	writer.write(name + backSpace 
		        				+ id + backSpace 
		        				+ pv + "_" + maxPv + backSpace 
		        				+ pm + "_" + maxPm + backSpace 
		        				+ pa + "_" + maxPa + backSpace 
		        				+ def + "_" + maxDef + backSpace 
		        				+ defM + "_" + maxDefM  + backSpace 
		        				+ speed + backSpace
		        				+ playTime + backSpace
		        				+ team + backSpace
		        				+ status + backSpace
		        				+ spriteLoc + backSpace);
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
		        	writer.write(name + backSpace 
	        				+ id + backSpace 
	        				+ pv + "_" + maxPv + backSpace 
	        				+ pm + "_" + maxPm + backSpace 
	        				+ pa + "_" + maxPa + backSpace 
	        				+ def + "_" + maxDef + backSpace 
	        				+ defM + "_" + maxDefM  + backSpace 
	        				+ speed + backSpace
	        				+ playTime + backSpace
	        				+ team + backSpace
	        				+ status + backSpace
	        				+ spriteLoc + backSpace);
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
		return "name : " + name
				+ ", id : " + id 
				+ ", pv : " + pv + "/" + maxPv 
				+ ", pm : " + pm + "/" + maxPm
				+ ", pa : " + pa + "/" + maxPa
				+ ", def : " + def + "/" + maxDef
				+ ", defM : " + defM + "/" + maxDefM
				+ ", speed : " + speed
				+", status :" + status;
	}
	
	public boolean equals(Object character){
		if(!(character instanceof Character)) return false;
		
		Character c = (Character) character;
		
		return (c.getName().equals(name)) && (c.getId() == id);
	}
	
	
}
