package controleur;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	
	ControlAcheterProduit control;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	ControlVerifierIdentite controlVerifierIdentite;
	Village village;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Village de test", 10, 10);
		Chef chef = new Chef("Chef", 1, village);
		village.setChef(chef);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		control = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}

	@Test
	void testControlAcheterProduit() {
		assertNotNull(control);
	}
	
	@Test
	void testDonnerVendeursProduit() {
		Gaulois asterix1 = new Gaulois("Asterix1", 10);
		village.ajouterHabitant(asterix1);
		village.installerVendeur(asterix1, "fleurs", 10);
		assertArrayEquals(control.donnerVendeursProduit("fleurs"), village.rechercherVendeursProduit("fleurs"));
		assertArrayEquals(control.donnerVendeursProduit("autre produit"), null);
	}

}
