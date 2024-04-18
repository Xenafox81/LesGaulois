package personnages;

public class Musee {
	private Trophee[] trophees;
	private int nbTrophees;
	
	public Musee() {
        this.trophees = new Trophee[200];
        this.nbTrophees = 0; 
    }
	
	public void donnerTrophees(Gaulois gaulois, Trophee trophee) {
		trophees[nbTrophees] = trophee;
        nbTrophees++;
		
	}

	    public String extraireInstructionsOCaml() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("let musee = [\n");
	        for (int i = 0; i < nbTrophees; i++) {
	            Trophee trophee = trophees[i];
	            String nomGaulois = trophee.getGaulois().getNom();
	            String nomEquipement = trophee.getEquipement().toString();
	            sb.append("\"").append(nomGaulois).append("\", \"").append(nomEquipement).append("\";\n");
	        }
	        sb.append("]");
	        return sb.toString();
	    }
	}
	

