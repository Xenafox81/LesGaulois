package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private int nbVillageoisMaximum;
	
	
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	

	public void setChef(Chef chef) { 
		this.chef = chef; 
	 } 
	
	public String getNom(String nom) {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) { 
		villageois[nbVillageois] = gaulois;
		nbVillageois = nbVillageois + 1;
	}
	
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " il y a les gaulois :");
		for (int i = 0; i < nbVillageois;i ++) {
			System.out.println(villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix",8);
		village.ajouterHabitant(asterix);
		Gaulois obelix = new Gaulois("Obelix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
