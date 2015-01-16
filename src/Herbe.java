import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;



public class Herbe extends Objet {

	public Herbe() { // Constructeur de la classe
		super();
		
		try {
			this.image = ImageIO.read(new File("herbeEng.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.description = "c'est de l'herbe vous pouvez y planter des fleurs"; // Liste des actions
		this.nom = "noble gazon";
		String planterFB = "Planter une fleur bleue";
		String planterFJ = "Planter une fleur jaune";
		String planterFR = "Planter une fleur rouge";
		String planterFV = "Planter une fleur violette";
		String deplacer = "Déplacer";
		String engrais = "Répandre de l'engrais";
		this.actions=new ArrayList<String>();
		this.actions.add(planterFB);
		this.actions.add(planterFJ);
		this.actions.add(planterFR);
		this.actions.add(planterFV);
		this.actions.add(deplacer);
		this.actions.add(engrais);
	}	


}
