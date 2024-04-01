package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	
	ControlAfficherMarche control;
	Village village;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Village de test", 10, 10);
		Chef chef = new Chef("Chef", 1, village);
		village.setChef(chef);
		control = new ControlAfficherMarche(village);
	}

	@Test
	void testControlAfficherMarche() {
		assertNotNull(control);
	}

	@Test
	void testDonnerInfosMarche() {
		Gaulois asterix1 = new Gaulois("Asterix1", 10);
		Gaulois asterix2 = new Gaulois("Asterix2", 10);
		village.ajouterHabitant(asterix1);
		village.ajouterHabitant(asterix2);
		village.installerVendeur(asterix1, "fleurs", 10);
		village.installerVendeur(asterix2, "autre fleurs", 10);
		assertArrayEquals(control.donnerInfosMarche(), village.donnerEtatMarche());
	}

}
