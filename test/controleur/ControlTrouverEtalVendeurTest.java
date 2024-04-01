package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	
	ControlTrouverEtalVendeur control;
	Village village;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Village de test", 10, 10);
		Chef chef = new Chef("Chef", 1, village);
		village.setChef(chef);
		control = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(control);
	}

	@Test
	void testTrouverEtalVendeur() {
		Gaulois asterix1 = new Gaulois("Asterix1", 10);
		village.ajouterHabitant(asterix1);
		village.installerVendeur(asterix1, "fleurs", 10);
		assertNotNull(village.trouverHabitant("Asterix1"));
		assertEquals(control.trouverEtalVendeur("Asterix1"), village.rechercherEtal(asterix1));
	}

}
