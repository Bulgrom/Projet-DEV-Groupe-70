package gui;
import java.io.IOException;

import party.*;

public class TestGUI {

	public static void main (String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		Party party = new Party("saveParty/party3/");
		
		PartyInterface inter = new PartyInterface(party, false, false);
		System.out.println(inter.getCurrentPlayer().getCurrentCharacter());
		Board board = new Board(inter);
	
	}
	
	
}
