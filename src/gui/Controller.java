package gui;

import map.*;
import map.Character;
import ability.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Hashtable;

/* Le controlleur fait le lien entre MatriceBoard et Map.
L'appui sur un bouton de Matriceboard va trigger une action de controller, qui va faire des trucs en conséquence */

public class Controller {
	
	Case[][] listCase;
	
	public Controller(Case[][] listCase) {
		this.listCase = listCase;

	}
	
	


	public int askCommand(map.Character chara) {
		Scanner scan = new Scanner(System.in);
		Hashtable<Integer, Ability> abilityNumbers = showMeYourMoves(chara);
		System.out.println("Entrez la commande désirée");
		// TODO mettre toutes les conditions en fonction des actions rentrées
		// TODO Table de Hashage pour la correspondance entre la commande et le numéro de la commande? Dictionnaire? en sortie de showMeYourMoves
		// Attention à l'adaptation de la condition du dessous
		// Faire un failsafe de si on sait pas écrire pour que la machine redemande la commande
		int command = scan.nextInt();
		System.out.println(abilityNumbers);
		System.out.println(command);
		if (abilityNumbers.containsKey(command)) { //Si la commande demandée est une capacité
			Ability ability = abilityNumbers.get(command);
			showRange(abilityNumbers.get(command), chara.getPosition());
		}
		
		return command;
	}

	public Hashtable<Integer, Ability> showMeYourMoves(map.Character chara) {
		System.out.println("Commandes possibles : \n");
		System.out.println("1 - Déplacement");
		int abilityLength = chara.getAbilityLength();
		Hashtable<Integer, Ability> abilityNumbers = new Hashtable<Integer, Ability>(); //contient tous les entiers i tels que l'action i correspond à une ability
		for (int i=0; i< abilityLength; i++) {
			System.out.println(i+2 + " - " + chara.getAbility(i).toString() + "\n");
			abilityNumbers.put(i+2, chara.getAbility(i));
		}
		return abilityNumbers;
	}
	
	
	public void showRange(Ability ability, Square squareInit) {
		Map map = squareInit.getMap();
		int[] mapDim = map.getDim();
		for (int i = 0; i < mapDim[0]; i++) {
			for (int j = 0; j < mapDim[1]; j++)
				if (ability.range(squareInit, map.getMap()[i][j])) {
					listCase[i][j].showInRange();
				}
				
		}
	}
	
	
	public void applyCommand(Character chara, Square squareFin, int actionID) {
		if (actionID == 1) {
			chara.move(squareFin);
		}
		else {
			Ability punch = chara.getAbility(actionID-2);
			chara.useAbility(punch, squareFin);
			System.out.println(squareFin.getCharacter().getPV());
		}
	}

	
}
