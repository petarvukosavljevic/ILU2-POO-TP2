package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;		//non utiliser
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	
	public Gaulois[] donnerVendeursProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	
	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	
	public String vendeursAvecProduit(String produit) {
		StringBuilder vendeurs = new StringBuilder();
		Gaulois[] vendeurProduit = village.rechercherVendeursProduit(produit);
		for(int i = 0; i<vendeurProduit.length; i++) {
			vendeurs.append((i+1) + " - " + vendeurProduit[i].getNom() + "\n");
		}
		return vendeurs.toString();
	}


	public String acheterProduit(String nomAcheteur, String produit, int quantiteSouhaite, int choix) {
		StringBuilder kupovina = new StringBuilder();
		Gaulois[] vendeurProduit = donnerVendeursProduit(produit);
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(vendeurProduit[choix-1].getNom());
		int produitDispo = etal.acheterProduit(quantiteSouhaite);
		if(produitDispo == 0) {
			kupovina.append(nomAcheteur + " veut acheter " + quantiteSouhaite + " " + produit + ", malheureusement il n'y en a plus !");
		} else if(quantiteSouhaite > produitDispo) {
			kupovina.append(nomAcheteur + " veut acheter " + quantiteSouhaite + " " + produit + ", malheureusement " + vendeurProduit[choix-1].getNom() 
					+ " n'en a plus que " + produitDispo + ". " + nomAcheteur + " achete tout le stock de " + vendeurProduit[choix-1].getNom() + ".");
		} else {
			kupovina.append(nomAcheteur + " achete " + quantiteSouhaite + " " + produit + " a " + vendeurProduit[choix-1].getNom() + ".");
		}
		return kupovina.toString();
	}
}
