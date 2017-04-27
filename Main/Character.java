package Main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Ability.*;

public class Character {
	private static String directory = "C:/Users/Julien/Desktop/Personage/";
	private static String backSpace = System.lineSeparator();
	public String name;
	private int id;
	private int pv;
	private int pm;
	private int pa;
	private int def;
	private int defM;
	private Ability[] ability;
	
	public Character(){}
	
	public Character(String filename) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
	    readPlayer(new File(filename));
	}
	
	public Character(String name, int id, int pv, int pm, int pa, int def, int defM, Ability[] ability){
		setName(name);
		setId(id);
		setPV(pv);
		setPM(pm);
		setPA(pa);
		setDef(def);
		setDefM(defM);
		setAbilities(ability);
	}
	
	public Character(String name, int id, int pv, int pm, int pa, int def, int defM){
		setName(name);
		setId(id);
		setPV(pv);
		setPM(pm);
		setPA(pa);
		setDef(def);
		setDefM(defM);
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
	
	public void setAbilities(Ability[] ability){
		this.ability = new Ability[ability.length];
		for (int i=0; i<ability.length;i++){
			this.ability[i] = ability[i];
		}
	}
	
	public void setStringAbilities(String[] stringAbility) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		ability = new Ability[stringAbility.length];
		for(int i=0; i<stringAbility.length; i++){
			//Ajouter un split sur la ligne courante pour separer les parametres
			this.ability[i] = (Ability) Class.forName("Ability."+stringAbility[i]).newInstance() ;
		}
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
		String[] stringAbility = reader.readLine().split("_");
		setStringAbilities(stringAbility);
		reader.close();
	}
	
}
