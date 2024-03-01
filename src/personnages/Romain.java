package personnages;

public class Romain {
	private String nom; 
	private int force; 
	
	public Romain(String nom, int force) { 
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
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		int forceCoupinit = forceCoup;
		assert forceCoup > 0 : "La force d'un Romain est toujours positive";
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
				
		}
		assert forceCoup < forceCoupinit : "La force doit avoir diminué";
	}
	public static void main(String[] args) {
		Romain jules = new Romain("Jules",-7);
		assert jules.force > 0 : "C'est pas bon";
	}
}
