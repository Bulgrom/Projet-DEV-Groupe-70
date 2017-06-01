package gui;
import java.io.IOException;

import menu.Window;
import party.*;

public class TestGUI {

	public static void showMap(Window w, String name, String partyName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		Party party = new Party(name);
		
		PartyInterface inter = new PartyInterface(party, false, false);
		System.out.println(inter.getCurrentPlayer().getCurrentCharacter());
		Board board = new Board(inter,w,partyName);
	
	}
	
	
}
