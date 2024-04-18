package personnages;

import personnages.Equipement;

public class Romain {
	private String nom; 
	private int force; 
	private Equipement[] equipement;
	private int nbEquipement;
	
	public Romain(String nom, int force) { 
		this.nom = nom;
		assert force > 0 : "La force doit être supérieur à 0";
		this.force = force;
		this.equipement = new Equipement[2];
		this.nbEquipement = 0;
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
	
	
	
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		int forceAvant = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe !");
		} else {
			parler("J'abandonne...");
		}
		int forceApres = force;
	    assert forceApres < forceAvant : "La force d'un Romain doit avoir diminué";
	}
	
	public static void main(String[] args) {

		Romain minus = new Romain("Minus", 10);
        minus.sequiper(Equipement.CASQUE); // Premier casque
        minus.sequiper(Equipement.CASQUE); // Deuxième casque
        minus.sequiper(Equipement.BOUCLIER); // Bouclier
        minus.sequiper(Equipement.CASQUE); // Autre casque
	}
}
