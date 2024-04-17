package histoire;

import personnages.Gaulois;
import personnages.Druide;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		Gaulois obelix = new Gaulois("Obelix",15);
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		Gaulois asterix = new Gaulois("Asterix",8);
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minius",6);
		minus.parler("Un Gau..UN GAUGAU...");
		asterix.frapper(minus);
		
		
	}

}
