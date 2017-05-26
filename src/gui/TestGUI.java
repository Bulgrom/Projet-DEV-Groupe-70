package gui;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ability.*;
import map.*;
import map.Character;

public class TestGUI{

	
	public static void main(String[] args) {
		System.out.println("Nouveau Test GUI");
		Map m = new Map(4,5);
		Ability punch = new Punch(200);
		Ability[] bastonChezpasSorcier = new Ability[] {punch};
		Character pers1 = new Character("jamy", 1, 1000, 3, 6, 80, 30, 10, bastonChezpasSorcier);
		Character pers2 = new Character("fred", 2, 1000, 5, 6, 50, 100, 20, bastonChezpasSorcier);
		m.getSquare(0,0).setCharacter(pers1);
		m.getSquare(0,1).setCharacter(pers2);
		Board b = new Board(m);

		
	}
	
	
	
}


