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
		control.ajouterGaulois("Asterix", 1);
		assertTrue(control.isHabitant("Asterix"));
		assertFalse(control.isHabitant("Obelix"));
		assertTrue(control.isHabitant("Chef"));
	}

	@Test
	void testAjouterDruide() {
		control.ajouterDruide("Druide", 1, 10, 20);
		assertTrue(control.isHabitant("Druide"));
	}

	@Test
	void testAjouterGaulois() {
		for(int i = 0; i < 10;i++) {
			control.ajouterGaulois("h" + i, 3);
		}
		control.ajouterGaulois("Gaulois", 3);
		assertFalse(control.isHabitant("Gaulois"));
	}

}
