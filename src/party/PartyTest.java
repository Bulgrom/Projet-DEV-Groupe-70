package party;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class PartyTest {

	@Test
	public void testSaveParty() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		Party party = new Party();
		party.loadMap("mapSave/Test/");
		
		party.loadCharacter("characterSave/pers1.txt");
		party.loadCharacter("characterSave/pers2.txt");
		party.loadCharacter("characterSave/pers1.txt");
		
		party.saveParty();
		
		party = new Party("saveParty/party1/");
		party.saveNewParty();
		
		
	}

}
