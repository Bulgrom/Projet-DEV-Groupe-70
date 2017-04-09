package Ability;

public class AbilityDataBase {
	
	public AbilityDataBase(){}
	
	public Ability getAbilityById(int id){
		if(id == 1){
			return new BasicAttack(2);
		}
		else return new BasicAttack(1);
	}
	
	public Ability getAbilityById(int id, int parameter){
		if (id == 1){
			return new BasicAttack(parameter);
		}
		else return new BasicAttack(1);
	}
	
	public Ability getAbilityByCodex(String codex){
		String[] expr = codex.split(",");
		int[] tab = new int[expr.length];
		for(int i=0; i<expr.length; i++) tab[i] = Integer.parseInt(expr[i]);
		if(expr.length == 1) return getAbilityById(tab[0]);
		if(expr.length == 2) return getAbilityById(tab[0],tab[1]);
		else return new BasicAttack(1);
	}
}
