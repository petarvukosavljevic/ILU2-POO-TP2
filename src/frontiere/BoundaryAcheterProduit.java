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
		System.out.println("Quel produit voulez-vous acheter ?");
		String produit = scan.nextLine();
		Gaulois[] vendeurProduit = controlAcheterProduit.donnerVendeursProduit(produit);
		if(vendeurProduit == null) {
			System.out.println("Desole, personne ne vend ce produit au marche");
		} else {
			System.out.println("Chez quel commercant voulez-vous acheter des " + produit + "?\n");
			for(int i = 0; i<vendeurProduit.length-1; i++) {
				System.out.println(i+1 + " - " + vendeurProduit[i] + "\n");
			}
			
		}
	}
}
