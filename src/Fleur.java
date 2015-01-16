import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Fleur extends Objet {

	Image imagePousse, imageFleur, imageFanee;

	public Fleur(Boolean engrais) {
		super();
		try {
			this.image = ImageIO.read(new File("graineL.png"));
			imagePousse = ImageIO.read(new File("Pousses.png"));
			imageFanee = ImageIO.read(new File("fleurMoisie.png"));
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		this.description = "Une petite graine qui vient � peine d'�tre plant�e... ";
		this.nom="Graine"; 
		ArrayList<String> actions = new ArrayList<String>();
		String cueillir = "Arroser la graine";
		actions.add(cueillir);
		this.actions=actions;
		this.arroser = false;
	}

	public void actionAuto(){

		if(this.tpPousse > tGraine){
			this.tpPousse--;
		}
		
		else if(this.tpPousse == tGraine){
			this.image = imagePousse;
			tpPousse--;
			this.nom = "Bourgeon";
			this.description = "Un pauv' bourgeon sans utilit�";
			this.arroser = false;
			this.actions.clear();
			String arroser = "Arroser le bourgeon";
			this.actions.add(arroser);
		}
		
		else if(this.tpPousse > tBourgeon){
			this.tpPousse--;
		}
		
		else if(this.tpPousse == tBourgeon){
			this.image = imageFleur;
			tpPousse--;
			this.nom = "Fleur";
			this.description = "Une belle fleur pr�te � �tre cueillie ! c'est joli ca sent parfois bon";
			this.arroser = false;
			this.actions.clear();
			String cueillir = "Cueillir";
			this.actions.add(cueillir);
		}
		
		else if(this.tpPousse > 0){
			this.tpPousse--;
		}
		
		else if(this.tpPousse == 0){
			this.image = imageFanee;
			tpPousse--;
			this.nom = "Fleur fanee";
			this.description = "Cette fleur a fan�e par manque d'attention... elle est bonne pour la poubelle !";
			this.actions.clear();
			String jeter = "Jeter la fleur fan�e";
			this.actions.add(jeter);
		}
	}


	public int gettGraine() {
		return tGraine;
	}

	public void settGraine(int tGraine) {
		this.tGraine = tGraine;
	}

	public int gettBourgeon() {
		return tBourgeon;
	}

	public void settBourgeon(int tBourgeon) {
		this.tBourgeon = tBourgeon;
	}

	public int getTpPousse() {
		return tpPousse;
	}

	public void setTpPousse(int tpPousse) {
		this.tpPousse = tpPousse;
	}



}
