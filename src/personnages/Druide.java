package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à " + effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	public int preparerPotion(Druide druide) {
		Random random = new Random();
		int forcepot = random.nextInt(effetPotionMin, effetPotionMax  + 1);
		if (forcepot > 7) {
		druide.parler("J'ai préparé une super potion de force " + forcepot);
		}
		else {
		druide.parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcepot);
		}
		return forcepot;
	}
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.preparerPotion(panoramix);
	}
}
