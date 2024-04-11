package controleur;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
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
	
	@Test
	void testVerifierIdentite() {
		Gaulois asterix1 = new Gaulois("Asterix1", 10);
		village.ajouterHabitant(asterix1);
		assertEquals(control.verifierIdentite("Asterix1"), controlVerifierIdentite.verifierIdentite("Asterix1"));
	}
	
	@Test
	void testVendeursAvecProduit() {
		Gaulois asterix1 = new Gaulois("Asterix1", 10);
		village.ajouterHabitant(asterix1);
		village.installerVendeur(asterix1, "fleurs", 10);
		assertEquals(control.vendeursAvecProduit("fleurs"), "1 - Asterix1\n");
	}
	
	@Test
	void testAcheterProduit() {
		Gaulois asterix1 = new Gaulois("Asterix1", 10);
		Gaulois asterix2 = new Gaulois("Asterix2", 10);
		Gaulois asterix3 = new Gaulois("Asterix3", 10);
		village.ajouterHabitant(asterix1);
		village.ajouterHabitant(asterix2);
		village.ajouterHabitant(asterix3);
		village.installerVendeur(asterix1, "fleurs", 5);
		village.installerVendeur(asterix2, "fleurs", 5);
		village.installerVendeur(asterix3, "fleurs", 0);
		
		assertEquals(control.acheterProduit("Acheteur", "fleurs", 4, 1), "Acheteur achete 4 fleurs a Asterix1.");
		assertEquals(control.acheterProduit("Acheteur", "fleurs", 7, 2), "Acheteur veut acheter 7 fleurs, malheureusement Asterix2 n'en a plus que 5. Acheteur achete tout le stock de Asterix2.");
		assertEquals(control.acheterProduit("Acheteur", "fleurs", 4, 3), "Acheteur veut acheter 4 fleurs, malheureusement il n'y en a plus !");
	}

}
