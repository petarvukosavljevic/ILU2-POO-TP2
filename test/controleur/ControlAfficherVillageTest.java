package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	ControlAfficherVillage control;
	Village village;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Village de test", 5, 10);
		Chef chef = new Chef("Chef", 1, village);
		village.setChef(chef);
		village.ajouterHabitant(new Gaulois("Asterix1", 10));
		village.ajouterHabitant(new Gaulois("Asterix2", 10));
		control = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(control);
	}

	@Test
	void testDonnerNomsVillageois() {
		assertArrayEquals(control.donnerNomsVillageois(), village.donnerVillageois());
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(control.donnerNomVillage(), "Village de test");
		assertNotEquals(control.donnerNomVillage(), "Mauvais nom");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(control.donnerNbEtals(), 10);
		assertNotEquals(control.donnerNbEtals(), 3);
	}

}
