package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis desolee " + nomAcheteur + " mais il faut etre un habitant de notre village pour commencer ici.");
		}
		System.out.println("Quel produit voulez-vous acheter ?");
		String produit = scan.nextLine();
		Gaulois[] vendeurProduit = controlAcheterProduit.donnerVendeursProduit(produit);
		if(vendeurProduit == null) {
			System.out.println("Desole, personne ne vend ce produit au marche");
		} else {
			System.out.println("Chez quel commercant voulez-vous acheter des " + produit + "?\n");
			int choix = -1;
			do {
				
			String vendeursAvecProduit = controlAcheterProduit.vendeursAvecProduit(produit);
			choix = Clavier.entrerEntier(vendeursAvecProduit.toString());
			if(choix < 1 && choix > vendeurProduit.length) {
				System.out.println("Aucun vendeur de " + produit + " dans cette etal! Choisissez un autre.\n");
			} else {
				System.out.println(nomAcheteur + " se deplace jusqu'a l'etal du vendeur " + vendeurProduit[choix-1].getNom()+".");
			}
			
			} while(choix < 1 && choix > vendeurProduit.length);
			System.out.println("Bonjour " + nomAcheteur + ".\n");
			int quantiteSouhaite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
			String acheterProduit = controlAcheterProduit.acheterProduit(nomAcheteur, produit, quantiteSouhaite, choix);
			System.out.println(acheterProduit);
		}
	}
}
