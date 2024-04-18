package personnages;

import personnages.Trophee;

public class Romain {
	private String nom; 
	private int force; 
	private Equipement[] equipement;
	private int nbEquipement;
	private boolean vainqueur;
	
	public Romain(String nom, int force) { 
		this.nom = nom;
		assert force > 0 : "La force doit être supérieur à 0";
		this.force = force;
		this.equipement = new Equipement[2];
		this.nbEquipement = 0;
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
	    Equipement[] equipementEjecte = null;
	    // précondition
	    assert force > 0;
	    int oldForce = force;
	    forceCoup = calculResistanceEquipement(forceCoup);
	    force -= forceCoup;
	    
	    // Ajout de la vérification pour déterminer le vainqueur
	    if (force <= 0) {
	        equipementEjecte = ejecterEquipement();
	        parler("J'abandonne...");
	        vainqueur = false; // Le Romain a perdu
	    } else {
	        parler("Aïe");
	        vainqueur = true; // Le Romain est toujours en jeu
	    }
	    
	    // post condition : la force a diminué
	    assert force < oldForce;
	    
	    return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
	    String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
	    int resistanceEquipement = 0;
	    if (nbEquipement != 0) {
	        texte += "\nMais heureusement, grâce à mon équipement sa force est diminuée de ";
	        for (int i = 0; i < nbEquipement; i++) {
	            if (equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER)) {
	                resistanceEquipement += 8;
	            } else {
	                System.out.println("Equipement casque");
	                resistanceEquipement += 5;
	            }
	        }
	        forceCoup -= resistanceEquipement; // Appliquer la résistance totale après la boucle
	        texte += resistanceEquipement + "!";
	    }
	    parler(texte);
	    return forceCoup;
	}
	
		private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipement[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipement[i];
				nbEquipementEjecte++;
				equipement[i] = null;
		}
		}
		return equipementEjecte;
		}	
	
	
	
	
	public void sequiper(Equipement equiiipement) {
		switch(nbEquipement) {
		case 0:
			ajouterEquipement(equiiipement);
			break;
		case 1:
			if (equipement[0] == equiiipement ) {
				System.out.println("Le soldat" + nom + " possède déjà un " + equiiipement);
				break;
			}
			else {
				ajouterEquipement(equiiipement);
				break;
			}
		case 2:
			System.out.println("Le soldat" + nom + "est déjà bien protégé ! ");
		}

	
	}
	
	private void ajouterEquipement(Equipement Newequipement) {
	    equipement[nbEquipement] = Newequipement;
	    System.out.println("Le soldat " + nom + " s'équipe avec un " + Newequipement + ".");
	    nbEquipement++;
	}
	
	
	public int getForce() {
		return force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		int forceAvant = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe !");
//		} else {
//			parler("J'abandonne...");
//		}
//		int forceApres = force;
//	    assert forceApres < forceAvant : "La force d'un Romain doit avoir diminué";
//	}
	
	public static void main(String[] args) {

//		Romain minus = new Romain("Minus", 10);
//        minus.sequiper(Equipement.CASQUE); // Premier casque
//        minus.sequiper(Equipement.CASQUE); // Deuxième casque
//        minus.sequiper(Equipement.BOUCLIER); // Bouclier
//        minus.sequiper(Equipement.CASQUE); // Autre casque
	}
}
