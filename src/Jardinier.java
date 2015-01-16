import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Jardinier extends Objet{

	Boolean estArrive, estOccupe;
	int posX, posY, widthCarte, heightCarte, oriX, oriY, widthOri, heightOri;
	int[] coordonnee = new int[2]; int[] destination = new int[2];
	Image imgPlante1, imgPlante2, imgArrose, imgCueille1, imgCueille2, imgNettoie1, imgNettoie2, imgEngrais1, imgEngrais2, imgJar;
	int compteur;
	Carte carte;

	public Jardinier(String nom, Carte carte) {
		super();
		
		try {
			imgJar = ImageIO.read(new File("sacha.png"));
			imgEngrais1 = ImageIO.read(new File("taup1.png"));
			imgEngrais2 = ImageIO.read(new File("taup2.png"));
			imgArrose = ImageIO.read(new File("cara.png"));
			imgCueille1 = ImageIO.read(new File("ins1.png"));
			imgCueille2 = ImageIO.read(new File("ins2.png"));
			imgNettoie1 = ImageIO.read(new File("tasm1.png"));
			imgNettoie2 = ImageIO.read(new File("tasm2.png"));
			imgPlante1 = ImageIO.read(new File("cheti1.png"));
			imgPlante2 = ImageIO.read(new File("cheti2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.carte = carte;
		this.image = imgJar;
		this.description = "�a, c'est vous";
		this.nom = nom; 
		this.actions=new ArrayList<String>();
		this.estArrive = true; this.estOccupe = false;
		this.compteur = 0;

		this.posX = (int)(this.carte.parametre.getTailleImage()*7/6); this.posY = 0;
		this.widthCarte = (int)(this.carte.parametre.getTailleImage()*2/3); this.heightCarte = this.carte.parametre.getTailleImage();
		this.oriX = 24; this.oriY = 64;
		this.widthOri = 24; this.heightOri = 32;
		this.coordonnee[0] = 0; this.coordonnee[1] = 1;
	}

	public void deplacementElementaire(){
		
		if(this.coordonnee[1] < this.destination[1]){
			if(this.compteur == 0){
				this.posX = this.posX + (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 0; this.oriY = 32;
				this.compteur++;
			} else if(this.compteur == 1){
				this.posX = this.posX + (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 24; this.oriY = 32;
				this.compteur++;
			} else if(this.compteur == 2){
				this.posX = this.posX + (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 48; this.oriY = 32;
				this.compteur++;
			} else if(this.compteur == 3){
				this.posX = this.posX + (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 24; this.oriY = 32;
				this.coordonnee[1]++;
				this.compteur = 0;
			}
		} 
		
		else if(this.coordonnee[1] > this.destination[1]){
			if(this.compteur == 0){
				this.posX = this.posX - (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 0; this.oriY = 96;
				this.compteur++;
			} else if(this.compteur == 1){
				this.posX = this.posX - (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 24; this.oriY = 96;
				this.compteur++;
			} else if(this.compteur == 2){
				this.posX = this.posX - (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 48; this.oriY = 96;
				this.compteur++;
			} else if(this.compteur == 3){
				this.posX = this.posX - (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 24; this.oriY = 96;
				this.coordonnee[1]--;
				this.compteur = 0;
			} 
		}
		
		else if(this.coordonnee[0] > this.destination[0]){
			if(this.compteur == 0){
				this.posY = this.posY - (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 0; this.oriY = 0;
				this.compteur++;
			} else if(this.compteur == 1){
				this.posY = this.posY - (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 24; this.oriY = 0;
				this.compteur++;
			} else if(this.compteur == 2){
				this.posY = this.posY - (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 48; this.oriY = 0;
				this.compteur++;
			} else if(this.compteur == 3){
				this.posY = this.posY - (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 24; this.oriY = 0;
				this.coordonnee[0]--;
				this.compteur = 0;
			}
		}
		
		else if(this.coordonnee[0] < this.destination[0]){
			if(this.compteur == 0){
				this.posY = this.posY + (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 0; this.oriY = 64;
				this.compteur++;
			} else if(this.compteur == 1){
				this.posY = this.posY + (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 24; this.oriY = 64;
				this.compteur++;
			} else if(this.compteur == 2){
				this.posY = this.posY + (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 48; this.oriY = 64;
				this.compteur++;
			} else if(this.compteur == 3){
				this.posY = this.posY + (int) Math.floor(this.carte.parametre.getTailleImage()*1/4);
				this.oriX = 24; this.oriY = 64;
				this.coordonnee[0]++;
				this.compteur = 0;
			}
		}
		
		else {
			this.oriX = 24; this.oriY = 64;
			this.estArrive = true;
		}
	}

	public void action(){
		
		if(this.compteur == 0){
			this.oriX = 216; this.oriY = 0;
		} else if(this.compteur == 5){
			this.oriX = 240; this.oriY = 0;
		} else if(this.getAction().get(0) == "cueillir"){
			this.cueillir();
		} else if(this.getAction().get(0) == "planter fleur bleue"){
			this.planterB();
		} else if(this.getAction().get(0) == "planter fleur jaune"){
			this.planterJ();
		} else if(this.getAction().get(0) == "planter fleur rouge"){
			this.planterR();
		} else if(this.getAction().get(0) == "planter fleur violette"){
			this.planterV();
		} else if(this.getAction().get(0) == "arroser graine"){
			this.arroserG();
		} else if(this.getAction().get(0) == "arroser bourgeon"){
			this.arroserB();
		} else if(this.getAction().get(0) == "repandre de l'engrais"){
			this.engrais();
		} else if(this.getAction().get(0) == "nettoyer"){
			this.nettoyer();
		} 
		this.compteur++;
	}

	public void cueillir(){
		if(this.compteur%10 == 0){
			this.image = this.imgCueille1;
			this.oriX = 0; this.oriY = 0; this.widthOri = 80; this.heightOri = 80;
		} else if(this.compteur%10 == 5){
			this.image = this.imgCueille2;
			this.oriX = 0; this.oriY = 0; this.widthOri = 80; this.heightOri = 80;
		} else if(this.compteur == 59){
			if(this.carte.tableau.get(this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1])).get(1) instanceof FleurBleue){
				this.carte.setFleurBleue(this.carte.getFleurBleue() + 1);		
			} 

			if(this.carte.tableau.get(this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1])).get(1) instanceof FleurJaune){
				this.carte.setFleurJaune(this.carte.getFleurJaune() + 1);
			}

			if(this.carte.tableau.get(this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1])).get(1) instanceof FleurRouge){
				this.carte.setFleurRouge(this.carte.getFleurRouge() + 1);
			}

			if(this.carte.tableau.get(this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1])).get(1) instanceof FleurViolette){
				this.carte.setFleurViolette(this.carte.getFleurViolette() + 1);
			}

			this.carte.tableau.get(this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1])).remove(1);
			this.carte.tableau.get(this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1])).get(0).engrais = false;

			try {
				this.carte.tableau.get(this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1])).get(0).setImage(ImageIO.read((new File("herbeEng.png"))));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.estOccupe = false;
			this.actions.clear();
			this.image = this.imgJar;
			this.oriX = 24; this.oriY = 64; this.widthOri = 24; this.heightOri = 32;

		}
	}

	public void planterB(){
		if(this.compteur%10 == 0){
			this.image = this.imgPlante1;
			this.oriX = 0; this.oriY = 0; this.widthOri = 79; this.heightOri = 79;
		} else if(this.compteur%10 == 5){
			this.image = this.imgPlante2;
			this.oriX = 0; this.oriY = 0; this.widthOri = 79; this.heightOri = 79;
		} else if(this.compteur == 59){
			int n = this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1]);
			this.carte.tableau.get(n).add(new FleurBleue(this.carte.tableau.get(n).get(0).getEngrais()));
			this.carte.setGraineBleue(this.carte.getGraineBleue() - 1);

			this.estOccupe = false;
			this.actions.clear();
			this.image = this.imgJar;
			this.oriX = 24; this.oriY = 64; this.widthOri = 24; this.heightOri = 32;

		}
	}

	public void planterJ(){
		if(this.compteur%10 == 0){
			this.image = this.imgPlante1;
			this.oriX = 0; this.oriY = 0; this.widthOri = 79; this.heightOri = 79;
		} else if(this.compteur%10 == 5){
			this.image = this.imgPlante2;
			this.oriX = 0; this.oriY = 0; this.widthOri = 79; this.heightOri = 79;
		} else if(this.compteur == 59){
			int n = this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1]);
			this.carte.tableau.get(n).add(new FleurJaune(this.carte.tableau.get(n).get(0).getEngrais()));
			this.carte.setGraineJaune(this.carte.getGraineJaune() - 1);

			this.estOccupe = false;
			this.actions.clear();
			this.image = this.imgJar;
			this.oriX = 24; this.oriY = 64; this.widthOri = 24; this.heightOri = 32;

		}
	}

	public void planterR(){
		if(this.compteur%10 == 0){
			this.image = this.imgPlante1;
			this.oriX = 0; this.oriY = 0; this.widthOri = 79; this.heightOri = 79;
		} else if(this.compteur%10 == 5){
			this.image = this.imgPlante2;
			this.oriX = 0; this.oriY = 0; this.widthOri = 79; this.heightOri = 79;
		} else if(this.compteur == 59){
			int n = this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1]);
			this.carte.tableau.get(n).add(new FleurRouge(this.carte.tableau.get(n).get(0).getEngrais()));
			this.carte.setGraineRouge(this.carte.getGraineRouge() - 1);

			this.estOccupe = false;
			this.actions.clear();
			this.image = this.imgJar;
			this.oriX = 24; this.oriY = 64; this.widthOri = 24; this.heightOri = 32;

		}
	}

	public void planterV(){
		if(this.compteur%10 == 0){
			this.image = this.imgPlante1;
			this.oriX = 0; this.oriY = 0; this.widthOri = 79; this.heightOri = 79;
		} else if(this.compteur%10 == 5){
			this.image = this.imgPlante2;
			this.oriX = 0; this.oriY = 0; this.widthOri = 79; this.heightOri = 79;
		} else if(this.compteur == 59){
			int n = this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1]);
			this.carte.tableau.get(n).add(new FleurViolette(this.carte.tableau.get(n).get(0).getEngrais()));
			this.carte.setGraineViolette(this.carte.getGraineViolette() - 1);

			this.estOccupe = false;
			this.actions.clear();
			this.image = this.imgJar;
			this.oriX = 24; this.oriY = 64; this.widthOri = 24; this.heightOri = 32;

		}
	}

	public void arroserG(){
		if(this.compteur == 10){
			this.image = this.imgArrose;
			this.oriX = 0; this.oriY = 0; this.widthOri = 393; this.heightOri = 318;
		}  else if(this.compteur == 59){
			int n = this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1]);
			int diff = (int) (this.carte.tableau.get(n).get(1).tpPousse - this.carte.tableau.get(n).get(1).gettGraine())/2;
			this.carte.tableau.get(n).get(1).setTpPousse(this.carte.tableau.get(n).get(1).getTpPousse() - diff); 
			this.carte.tableau.get(n).get(1).setArroser(true);

			this.estOccupe = false;
			this.actions.clear();
			this.image = this.imgJar;
			this.oriX = 24; this.oriY = 64; this.widthOri = 24; this.heightOri = 32;

		}
	}

	public void arroserB(){
		if(this.compteur == 10){
			this.image = this.imgArrose;
			this.oriX = 0; this.oriY = 0; this.widthOri = 393; this.heightOri = 318;
		}  else if(this.compteur == 59){
			int n = this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1]);
			int diff = (int) (this.carte.tableau.get(n).get(1).tpPousse - this.carte.tableau.get(n).get(1).gettBourgeon())/2;
			this.carte.tableau.get(n).get(1).setTpPousse(this.carte.tableau.get(n).get(1).getTpPousse() - diff); 
			this.carte.tableau.get(n).get(1).setArroser(true);

			this.estOccupe = false;
			this.actions.clear();
			this.image = this.imgJar;
			this.oriX = 24; this.oriY = 64; this.widthOri = 24; this.heightOri = 32;

		}
	}

	public void engrais(){
		if(this.compteur%10 == 0){
			this.image = this.imgEngrais1;
			this.oriX = 0; this.oriY = 0; this.widthOri = 80; this.heightOri = 80;
		} else if(this.compteur%10 == 5){
			this.image = this.imgEngrais2;
			this.oriX = 0; this.oriY = 0; this.widthOri = 80; this.heightOri = 80;
		} else if(this.compteur == 59){
			int n = this.carte.matriceToList(this.coordonnee[0],
					this.coordonnee[1]);
			this.carte.setEngrais(this.carte.getEngrais() - 1);
			this.carte.tableau.get(n).get(0).setEngrais(true);
			try {
				this.carte.tableau.get(n).get(0).image = ImageIO.read(new File("engrais.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.estOccupe = false;
			this.actions.clear();
			this.image = this.imgJar;
			this.oriX = 24; this.oriY = 64; this.widthOri = 24; this.heightOri = 32;
		}
	}

	public void nettoyer(){
		if(this.compteur%10 == 0){
			this.image = this.imgNettoie1;
			this.oriX = 0; this.oriY = 0; this.widthOri = 80; this.heightOri = 80;
		} else if(this.compteur%10 == 5){
			this.image = this.imgNettoie2;
			this.oriX = 0; this.oriY = 0; this.widthOri = 80; this.heightOri = 80;
		} else if(this.compteur == 59){
			this.carte.tableau.get(this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1])).remove(1);
			this.carte.tableau.get(this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1])).get(0).engrais = false;

			try {
				this.carte.tableau.get(this.carte.matriceToList(this.coordonnee[0], this.coordonnee[1])).get(0).setImage(ImageIO.read((new File("herbeEng.png"))));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.estOccupe = false;
			this.actions.clear();
			this.image = this.imgJar;
			this.oriX = 24; this.oriY = 64; this.widthOri = 24; this.heightOri = 32;

		}
	}

	public void actionAuto(){
		if(!this.estArrive){
			this.deplacementElementaire();
		} else if (this.estOccupe){
			this.action();
		}
	}
}