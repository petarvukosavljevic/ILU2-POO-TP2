package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	ControlAfficherVillage control;
	ControlEmmenager control2;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 5, 10);
		Chef chef = new Chef("Chef", 1, village);
		village.setChef(chef);
		control = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(control);
	}

//	@Test
//	void testDonnerNomsVillageois() {
//		for(int i = 1 ; i < 5 ; i++) {
//			control2.ajouterGaulois("h", 3);
//		}
//		assertEquals(control.donnerNomsVillageois(), "h");
//	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(control.donnerNomVillage(), "Village de test");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(control.donnerNbEtals(), 10);
	}

}
