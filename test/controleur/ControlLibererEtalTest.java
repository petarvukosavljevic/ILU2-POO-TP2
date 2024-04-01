package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	
	ControlLibererEtal control;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	Village village;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Village de test", 10, 10);
		Chef chef = new Chef("Chef", 1, village);
		village.setChef(chef);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		control = new ControlLibererEtal(controlTrouverEtalVendeur);
	}

	@Test
	void testControlLibererEtal() {
		assertNotNull(control);
	}

	@Test
	void testIsVendeur() {
		Gaulois asterix1 = new Gaulois("Asterix1", 10);
		Gaulois asterix2 = new Gaulois("Asterix2", 10);
		village.ajouterHabitant(asterix1);
		village.ajouterHabitant(asterix2);
		village.installerVendeur(asterix1, "fleurs", 10);
		assertTrue(control.isVendeur("Asterix1"));
	}

	@Test
	void testLibererEtal() {
		Gaulois asterix1 = new Gaulois("Asterix1", 10);
		village.ajouterHabitant(asterix1);
		village.installerVendeur(asterix1, "fleurs", 10);
		assertArrayEquals(control.libererEtal("Asterix1"), village.rechercherEtal(asterix1).etatEtal());
	}

}
