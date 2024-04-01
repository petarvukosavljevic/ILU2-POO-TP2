package controleur;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	
	ControlVerifierIdentite control;
	Village village;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Village de test", 10, 10);
		Chef chef = new Chef("Chef", 1, village);
		village.setChef(chef);
		control = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(control);
	}

	@Test
	void testVerifierIdentite() {
		Gaulois asterix1 = new Gaulois("Asterix1", 10);
		village.ajouterHabitant(asterix1);
		assertNotNull(control.verifierIdentite("Asterix1"));
		assertTrue(control.verifierIdentite("Asterix1"));
		assertFalse(control.verifierIdentite("Asterix2"));
	}

}
