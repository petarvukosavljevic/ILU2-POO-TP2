package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	
	ControlEmmenager control;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 10, 10);
		Chef chef = new Chef("Chef", 1, village);
		village.setChef(chef);
		control = new ControlEmmenager(village);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(control);
	}

	@Test
	void testIsHabitant() {
		control.ajouterGaulois("Bonemine", 10);
		assertTrue(control.isHabitant("Bonemine"));
		assertFalse(control.isHabitant("Existe pas"));
		control.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(control.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterDruide() {
		control.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(control.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterGaulois() {
		control.ajouterGaulois("Bonemine", 10);
		assertTrue(control.isHabitant("Bonemine"));
	}

}
