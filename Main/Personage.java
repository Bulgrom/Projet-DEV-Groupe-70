package Main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Ability.*;

public class Personage {
	private static String directory = "C:/Users/Julien/Desktop/Personage/";
	private static String backSpace = System.lineSeparator();
	public String name;
	private int id;
	public int pv;
	public Ability[] ability;
	
	public Personage(){}
	
	public Personage(String filename) throws IOException{
	    readPlayer(new File(filename));
	}
	
	public Personage(String name, int pv, Ability[] ability){
		this.name = name;
		this.pv = pv;
		this.ability = new Ability[ability.length];
		for (int i=0; i<ability.length;i++){
			this.ability[i] = ability[i];
		}
	}
	
	public int getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void readPlayer(File root) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(root));
		setName(reader.readLine());
		setId(Integer.parseInt(reader.readLine()));
		
		String[] stringAbility = reader.readLine().split("_");
		reader.close();
		ability = new Ability[stringAbility.length];
		AbilityDataBase abilityDB = new AbilityDataBase();
		for(int i=0; i<stringAbility.length;i++){
			ability[i] = abilityDB.getAbilityByCodex(stringAbility[i]);
		}

	}
	
}
