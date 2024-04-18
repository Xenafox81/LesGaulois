package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

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
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
		
//	}
//	public void frapper(Romain romain) { 
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom()); 
//		romain.recevoirCoup(force / 3 * effetPotion);
//}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesRomain = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesRomain != null && i < tropheesRomain.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = tropheesRomain[i];
		}
		}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplé");
		
	}
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees > 0) {
	        System.out.println("Le gaulois " + nom + " : \"Je donne au musée tous mes trophées :");
	        for (int i = 0; i < nbTrophees; i++) {
	        	System.out.println(trophees[i]);

	    }
		
	}
	}
	

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
//		System.out.println(asterix.getNom());
		System.out.println(asterix); 
//		System.out.println(asterix.prendreParole());
//		asterix.parler("Allons battre ces gaulois");
		Romain jules = new Romain("Jules",7);
//		asterix.frapper(jules);
		Druide panoramix = new Druide("Panoramix",5,10);
		asterix.boirePotion(panoramix.preparerPotion());
		asterix.frapper(jules);
		Musee musee1 = new Musee();
		asterix.faireUneDonnation(musee1);
		
		
		
	}
}
