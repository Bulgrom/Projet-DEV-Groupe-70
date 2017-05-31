package party;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import org.junit.Before;

import player.HumanPlayer;

public class PartyTest {
	private Party party = new Party();

	@Before
	public void before() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		party.loadMap("mapSave/Test/");
		party.loadCharacter("characterSave/pers1.txt");
		party.loadCharacter("characterSave/pers2.txt");
		party.loadCharacter("characterSave/pers1.txt");
		
		
		party.getCharacter(0).setSpeed(30);
		party.getCharacter(0).setTeam(1);
		
		party.getCharacter(1).setSpeed(40);
		party.getCharacter(1).setTeam(2);
		
		party.getCharacter(2).setSpeed(70);
		party.getCharacter(2).setName("pers3");
		party.getCharacter(2).setTeam(2);
		
		party.getMap().getSquare(0, 1).setCharacter(party.getCharacter(0));
		party.getMap().getSquare(3, 4).setCharacter(party.getCharacter(1));
		party.getMap().getSquare(2, 2).setCharacter(party.getCharacter(2));
		
		party.initParty();
		
	}
	
	@Test
	public void testSaveParty() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		party.saveParty();
		
		party = new Party("saveParty/party1/");
		party.saveNewParty();
		
	}

	
	@Test
	public void testInitialisationInterface(){
		PartyInterface pi = new PartyInterface(party);
		
		assertTrue(party == pi.getParty());
		
		assertTrue(party.getCharacter(0).equals(party.getOrder(0)));
		
		assertTrue(party.getCharacter(1).equals(party.getOrder(1)));
		
		assertTrue(party.getCharacter(2).equals(party.getOrder(2)));
		
	}
	
	@Test
	public void testAction(){
		
		PartyInterface pi = new PartyInterface(party);
		
		HumanPlayer pu = pi.getCurrentPlayer();
		
		pu.move(party.getMap().getSquare(1, 1));
		assertTrue(party.getMap().getSquare(0, 1).getCharacter() == null);
		assertTrue(party.getMap().getSquare(1, 1).getCharacter() == party.getCharacter(0));
		 
		assertTrue(party.getCharacter(2).getMaxPV() == party.getCharacter(2).getPV());
		pu.useAction(pu.getCurrentCharacter().getAbility(1), party.getMap().getSquare(2,2));
		assertTrue(party.getCharacter(2).getMaxPV() > party.getCharacter(2).getPV());
	}
	
	@Test
	public void testEndTurn(){
		PartyInterface pi = new PartyInterface(party);
		
		HumanPlayer pu = pi.getCurrentPlayer();
		assertTrue(pu.getCurrentCharacter().equals(party.getCharacter(0)));
		
		pu.endTurn();
		assertTrue(pu != pi.getCurrentPlayer());
		pu = pi.getCurrentPlayer();
		System.out.println(pu.getCurrentCharacter().getName());
		assertTrue(pu.getCurrentCharacter().equals(party.getCharacter(1)));
		
		pu.endTurn();
		pu = pi.getCurrentPlayer();
		assertTrue(pu.getCurrentCharacter().equals(party.getCharacter(0)));
		
		pu.endTurn();
		pu = pi.getCurrentPlayer();
		assertTrue(pu.getCurrentCharacter().equals(party.getCharacter(2)));
		
		pu.endTurn();
		pu = pi.getCurrentPlayer();
		assertTrue(pu.getCurrentCharacter().equals(party.getCharacter(1)));
		

	}
	
	
	@Test
	public void testChangeCharacter(){
		party.getCharacter(1).setTeam(1);
		party.initParty();
		
		PartyInterface pi = new PartyInterface(party);
		
		HumanPlayer pu = pi.getCurrentPlayer();
		
		assertTrue(pu.getCurrentCharacter().equals(party.getCharacter(0)));
		pu.changeCharacter(pu.getPlayableCharacter(1));
		assertTrue(pu.getCurrentCharacter().equals(party.getCharacter(1)));
		
	}
}
