public class Parametre {


	//les parametres de la carte
	private int nbLigneCarte =0; 	  //nombre de lignes de la carte
	private int nbColonneCarte =0; 	 //nombre de colonnes de la carte
	private int tailleImage =0;				 //taille d'une case en pixels, taille fixe
	private int largeurPixCarte =0;			 //largeur en pixels de la carte
	private int hauteurPixCarte =0; 		   	// hauteur en pixels de la carte

	//les parametres d'affdescriptions
	private int largeurPixDescription =0; //largeur en pixel de l'écran description
	private int hauteurPixDescription =0; //hauteur en pixel de l'écran description

	//les parametres de affjeux
	private int largeurPixJeux =0; //largeur en pixel de l'affichage jeux
	private int hauteurPixJeux =0 ; //hauteur en pixel de l'affichage jeux

	// les parametres de affFleur
	private int largeurPixFleur = 0;
	private int hauteurPixFleur = 0;

	// les parametres de graine
	private int largeurPixGraine = 0;
	private int hauteurPixGraine = 0;

	//les parametres de affDemande
	private int largeurPixDemande = 0;
	private int hauteurPixDemande = 0;

	//écart entre les Jpannel 
	private int ecart = 5;

	public Parametre(int nbLigneCarte, int nbColonneCarte, int tailleImage, int largeurPixDescription, int hauteurPixJeux, int largeurPixDemande,int hauteurPixFleur) {
		
		//la carte
		this.nbLigneCarte = nbLigneCarte;
		this.nbColonneCarte = nbColonneCarte;
		this.tailleImage = tailleImage;
		this.largeurPixCarte=this.nbColonneCarte*this.tailleImage;
		this.hauteurPixCarte=this.nbLigneCarte*this.tailleImage;
		
		//la description
		this.largeurPixDescription = largeurPixDescription;
		this.hauteurPixDescription = this.hauteurPixCarte;

		//la demande
		this.largeurPixDemande = largeurPixDemande;
		this.hauteurPixDemande = this.hauteurPixCarte;

		//affjeux
		this.largeurPixJeux = this.largeurPixDemande+this.largeurPixCarte+this.largeurPixDescription + 2*this.ecart;
		this.hauteurPixJeux = hauteurPixJeux;

		//Fleur
		this.largeurPixFleur = (this.largeurPixJeux-this.ecart)/2;
		this.hauteurPixFleur = hauteurPixFleur;

		//Graines
		this.largeurPixGraine = this.largeurPixJeux-this.ecart-this.largeurPixFleur;
		this.hauteurPixGraine = this.hauteurPixFleur;
	}

	public int getNbLigneCarte() {
		return nbLigneCarte;
	}

	public int getNbColonneCarte() {
		return nbColonneCarte;
	}

	public int getTailleImage() {
		return tailleImage;
	}

	public int getLargeurPixCarte() {
		return largeurPixCarte;
	}

	public int getHauteurPixCarte() {
		return hauteurPixCarte;
	}

	public int getLargeurPixDescription() {
		return largeurPixDescription;
	}

	public int getHauteurPixDescription() {
		return hauteurPixDescription;
	}

	public int getLargeurPixJeux() {
		return largeurPixJeux;
	}

	public int getHauteurPixJeux() {
		return hauteurPixJeux;
	}

	public int getLargeurPixFleur() {
		return largeurPixFleur;
	}

	public int getHauteurPixFleur() {
		return hauteurPixFleur;
	}

	public int getLargeurPixGraine() {
		return largeurPixGraine;
	}

	public int getHauteurPixGraine() {
		return hauteurPixGraine;
	}

	public int getLargeurPixDemande() {
		return largeurPixDemande;
	}

	public int getHauteurPixDemande() {
		return hauteurPixDemande;
	}

	public int getEcart() {
		return ecart;
	}


}