package gui;

import map.*;
import map.Character;
import ability.*;
import java.util.Scanner;
import java.util.Hashtable;
import player.*;
import party.*;
import map.Character;
/* Le controlleur fait le lien entre MatriceBoard et Map.
L'appui sur un bouton de Matriceboard va trigger une action de controller, qui va faire des trucs en conséquence */


//TODO : utiliser git

public class Controller {

	Case[][] listCase;
	Character currentCharacter;
	PartyInterface partyInterface;
	
	public Controller(Case[][] listCase, PartyInterface partyInterface) {
		this.listCase = listCase;
		this.partyInterface = partyInterface;
		this.currentCharacter = partyInterface.getCurrentPlayer().getCurrentCharacter();
		System.out.println("C'est à " + currentCharacter.getName() + " de commencer !");
	}

	public Character getCurrentCharacter() {
		return this.currentCharacter;
	}
	
	public int askCommand() {
		Scanner scan = new Scanner(System.in);
		Hashtable<Integer, Ability> abilityNumbers = showMeYourMoves();
		System.out.println("Entrez la commande désirée");
		
		// TODO mettre toutes les conditions en fonction des actions rentrées
		// Faire un failsafe de si on sait pas écrire pour que la machine
		// redemande la commande
		int command = scan.nextInt();
		if (command == 0) {
			this.endTurn();
			System.out.println("Fin du tour");
			System.out.println("C'est à " + currentCharacter.getName() + " de jouer !");
		}
		if (command == 1) {
			showMovementRange();
		}
		if (abilityNumbers.containsKey(command)) { // Si la commande demandée
													// est une capacité
			Ability ability = abilityNumbers.get(command);
			showRange(abilityNumbers.get(command), currentCharacter.getPosition());
		}
		return command;
	}

	public void endTurn() {
		partyInterface.endTurn(currentCharacter);
		this.currentCharacter = partyInterface.getCurrentPlayer().getCurrentCharacter();


	}
	
	
	public Hashtable<Integer, Ability> showMeYourMoves() {
		System.out.println("Commandes possibles : \n");
		System.out.println("0 - Fin de tour");
		System.out.println("1 - Déplacement");
		int abilityLength = currentCharacter.getAbilityLength();
		Hashtable<Integer, Ability> abilityNumbers = new Hashtable<Integer, Ability>(); // contient tous les entiers i tq i corresponde à une ability
		for (int i = 0; i < abilityLength; i++) {
			System.out.println(i + 2 + " - " + currentCharacter.getAbility(i).toString() + "\n");
			abilityNumbers.put(i + 2, currentCharacter.getAbility(i));
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

	public void showMovementRange() {
		Map map = currentCharacter.getPosition().getMap();
		int[] mapDim = map.getDim();
		for (int i = 0; i < mapDim[0]; i++) {
			for (int j = 0; j < mapDim[1]; j++)
				if (currentCharacter.checkMove(map.getMap()[i][j])) {
					listCase[i][j].showInRange();
				}
		}
	}

	public void applyCommand(Square squareFin, int actionID) {
		if (actionID == 1) {
			currentCharacter.move(squareFin);
			System.out.println("Mouvement de " + currentCharacter.getName() + " effectué");
		} else {
			try {
				Ability ability = currentCharacter.getAbility(actionID - 2);
				currentCharacter.useAbility(ability, squareFin);
				System.out.println(currentCharacter.getName() + " utilise " + ability.getName() + " !");
				try {
					System.out.println(squareFin.getCharacter().getName() + " a maintenant " + squareFin.getCharacter().getPV() + " PV!");
				} catch (Exception e) {
				}
			} catch (Exception e) {
				System.out.println("Erreur : Commande non disponible");
			}
		}

	}
}