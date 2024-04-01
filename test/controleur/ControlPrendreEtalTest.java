package controleur;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	ControlPrendreEtal control;
	ControlVerifierIdentite controlVerifierIdentite;
	Village village;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Village de test", 5, 10);
		Chef chef = new Chef("Chef", 1, village);
		village.setChef(chef);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		control = new ControlPrendreEtal(controlVerifierIdentite, village);
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(control);
	}

	@Test
	void testResteEtals() {
		assertEquals(control.resteEtals(), village.rechercherEtalVide());
	}

	@Test
	void testPrendreEtal() {
		Gaulois asterix1 = new Gaulois("Asterix1", 10);
		village.ajouterHabitant(asterix1);
		control.prendreEtal("Asterix1", "fleurs", 10);
		assertNotNull(village.rechercherEtal(asterix1));
	}

	@Test
	void testVerifierIdentite() {
		Gaulois asterix1 = new Gaulois("Asterix1", 10);
		village.ajouterHabitant(asterix1);
		assertEquals(control.verifierIdentite("Asterix1"), controlVerifierIdentite.verifierIdentite("Asterix1"));
	}

}
