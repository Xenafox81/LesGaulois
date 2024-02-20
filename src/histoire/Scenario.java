package histoire;

import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		Romain minius = new Romain("Minius",6);
		asterix.parler("Bonjour à tous");
		minius.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minius);
		asterix.frapper(minius);
		asterix.frapper(minius);
		
	}

}
