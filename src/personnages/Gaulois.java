package personnages;

import java.util.Iterator;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		
	}
	public void frapper(Romain romain) { 
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom()); 
		romain.recevoirCoup(force / 3 * effetPotion);
}
	
	public void boirePotion(int forcePotion, Gaulois gaulois) {
		effetPotion = forcePotion;
		gaulois.parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplé");
		
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
//		System.out.println(asterix.getNom());
//		System.out.println(asterix); 
//		System.out.println(asterix.prendreParole());
//		asterix.parler("Allons battre ces gaulois");
		Romain jules = new Romain("Jules",7);
//		asterix.frapper(jules);
		Druide panoramix = new Druide("Panoramix",5,10);
		asterix.boirePotion(panoramix.preparerPotion(panoramix), asterix);
		asterix.frapper(jules);
		
		
		
	}
}
