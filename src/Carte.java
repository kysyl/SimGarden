import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Carte extends JPanel {

	ArrayList<ArrayList<Objet>> tableau; 
	Parametre parametre;
	ArrayList<Objet> objetSelect;
	int[] caseSelected = new int[2]; // il s'agit des cordonnées en ligne et colonnes sélectionnées
	ArrayList<Jardinier> jardiniers;
	Jardinier jardinierSelected;

	int[] ancienCaseSelected = new int[2];


	// attribut pour affjeux
	private static int score; // le score actuel
	private static int argent; // le capital du joueur
	private static int engrais; // engrais en sa possession
	//attribut graine
	private static int graineBleue, graineJaune, graineRouge, graineViolette; // le nombre de graines dans son sac

	//fleurs en stock
	private static int fleurBleue, fleurJaune, fleurRouge, fleurViolette; // le nombre de fleurs en sa possession

	//demande de fleur
	private int demandeFleurBleue, demandeFleurRouge, demandeFleurViolette, demandeFleurJaune;


	private int attente; //il sert à diminuer le score quand la demande est top importante
	private int prixJardinier = 200;

	Boolean dansMagasin;

	JFrame f = new JFrame();

	//probabilité de chaque fleur
	double probabiliteDemande = 0.0075;
	double probabiliteBleue = 0.25;
	double probabiliteRouge = 0.25;
	double probabiliteJaune = 0.25;

	// Constructeur de la carte standard de départ
	public Carte(Parametre parametre, String nom) {

		int nbLigneCarte = parametre.getNbLigneCarte();
		int nbColonneCarte= parametre.getNbColonneCarte();
		int tailleImage = parametre.getTailleImage();
		int largeurPixDescription = parametre.getLargeurPixDescription();
		int hauteurPixJeux = parametre.getHauteurPixJeux();
		int largeurPixDemande= parametre.getLargeurPixDemande();
		int hauteurPixGraine = parametre.getHauteurPixGraine();



		// Creation de l'attribut parametre
		this.parametre = parametre;


		this.caseSelected[1]=1;


		f.setSize(parametre.getLargeurPixCarte(),parametre.getHauteurPixCarte());
		f.setLocationRelativeTo(null);
		f.setTitle("Fleuriste");


		this.tableau = new ArrayList<ArrayList<Objet>>();

		for (int i = 0; i < this.getParametre().getNbColonneCarte()
				* this.getParametre().getNbLigneCarte(); i++) {
			this.tableau.add(new ArrayList<Objet>());
			if (i == nbColonneCarte - 1 
					|| i == nbColonneCarte * nbLigneCarte - 1
					|| i == nbColonneCarte * nbLigneCarte - nbColonneCarte) {
				this.tableau.get(i).add(new Rocher());
			} else {
				this.tableau.get(i).add(new Herbe());
			}
		}

		// on ajoute un magasin et un jardinier dont on spécifie la taille et les coordonnées
		jardiniers = new ArrayList<Jardinier>();
		Jardinier jar = new Jardinier(nom, this);
		this.jardiniers.add(jar);
		this.jardinierSelected = jar;

		Magasin magasin = new Magasin();
		this.tableau.get(0).add(magasin);

		this.setArgent(1000);
		this.setScore(0);
		this.setGraineBleue(2); this.setGraineJaune(2); this.setGraineRouge(2); this.setGraineViolette(2);
		this.setFleurBleue(0); this.setFleurJaune(0); this.setFleurRouge(0); this.setFleurViolette(0);
		this.setEngrais(1);
		this.setDansMagasin(false);
		this.demandeFleurBleue = 0;	this.demandeFleurJaune = 0;	this.demandeFleurRouge = 0;	this.demandeFleurViolette = 0;
		this.objetSelect = this.tableau.get(1);
		this.attente=0;

	}

	public boolean isEmptynb(int ligne, int colonne) {  //si l'arrayliste n'a qu'un objet alors elle
		int n = ligne * this.parametre.getNbColonneCarte() + colonne; //est vide.
		return (this.tableau.get(n).size() == 1);
	}

	public ArrayList<Objet> getObjetpix(int x, int y) { 
		
		int nbligne = (int) Math.floor(y / this.getParametre().getTailleImage()); 
		int nbcolonne = (int) Math.floor(x/ this.getParametre().getTailleImage()); 
		int n = nbligne * this.parametre.getNbColonneCarte() + nbcolonne;

		return tableau.get(n); 
	}

	public ArrayList<Objet> getObjetnb(int ligne, int colonne) {
		int n = ligne * this.parametre.getNbColonneCarte() + colonne;

		return this.tableau.get(n); 
	}

	public int matriceToList(int ligne, int colonne) {// on rentre le numéro de
	
		int n = ligne * this.parametre.getNbColonneCarte() + colonne;

		return n;
	}

	public int[] listToMatrice(int n) {

		int[] tab = new int[2];
		tab[0] = n / this.parametre.getNbColonneCarte();
		tab[1] = n % this.parametre.getNbColonneCarte();

		return tab;
	}

	public void incrScoreTemps() {

		this.setScore(this.getScore() + 1);

	}

	public Boolean jardinierLibre(){
		for(int i = 0; i < this.jardiniers.size()-1; i++){
			if(!this.jardiniers.get(i).estOccupe){
				this.jardinierSelected = this.jardiniers.get(i);
				return true;
			}
		}
		return false;
	}

	public void deplacerJar(){
		if(jardinierLibre()){
			this.jardinierSelected.estArrive = false;
			this.jardinierSelected.compteur = 0;
			this.jardinierSelected.destination[0] = this.caseSelected[0];
			this.jardinierSelected.destination[1] = this.caseSelected[1];
		} else {
			JOptionPane.showMessageDialog(null, "Tous tes jardiniers sont occupés !");
		}
	}	

	public void cueillir() {
		deplacerJar();
		this.jardinierSelected.estOccupe = true;
		this.jardinierSelected.actions.add("cueillir");
	}

	public void planterFleurBleue() {

		if(Carte.graineBleue <= 0){
			JOptionPane.showMessageDialog(null, "T'as pas de graine tocard !");
		} else {
			deplacerJar();
			this.jardinierSelected.estOccupe =true;
			this.jardinierSelected.actions.add("planter fleur bleue");
		}
	}

	public void planterFleurJaune() {

		if(Carte.graineJaune <= 0){
			JOptionPane.showMessageDialog(null, "T'as pas de graine tocard !");
		} else {
			deplacerJar();
			this.jardinierSelected.estOccupe =true;
			this.jardinierSelected.actions.add("planter fleur jaune");
		}
	}

	public void planterFleurRouge() {

		if(Carte.graineRouge <= 0){
			JOptionPane.showMessageDialog(null, "T'as pas de graine tocard !");
		} else {
			deplacerJar();
			this.jardinierSelected.estOccupe =true;
			this.jardinierSelected.actions.add("planter fleur rouge");
		}
	}

	public void planterFleurViolette() {

		if(Carte.graineViolette <= 0){
			JOptionPane.showMessageDialog(null, "T'as pas de graine tocard !");
		} else {
			deplacerJar();
			this.jardinierSelected.estOccupe =true;
			this.jardinierSelected.actions.add("planter fleur violette");
		}
	}

	public void repandreEngrais(){ // chatte
		if (Carte.engrais > 0) {
			deplacerJar();
			this.jardinierSelected.estOccupe = true;// chatte
			this.jardinierSelected.actions.add("repandre de l'engrais");
		} else {
			JOptionPane.showMessageDialog(null, "T'as pas d'engrais!");
		}

	}

	public void arroserGraine(){
		int n = this.matriceToList(this.caseSelected[0], this.caseSelected[1]);
		if(!this.tableau.get(n).get(1).getArroser()){
			deplacerJar();
			this.jardinierSelected.estOccupe = true;
			this.jardinierSelected.actions.add("arroser graine");
		}
		else
			JOptionPane.showMessageDialog(null, "Tu ne peux arroser cette graine qu'une seule fois!");
	}

	public void arroserBourgeon(){
		int n = this.matriceToList(this.caseSelected[0], this.caseSelected[1]);
		if(!this.tableau.get(n).get(1).getArroser()){
			deplacerJar();
			this.jardinierSelected.estOccupe = true;
			this.jardinierSelected.actions.add("arroser bourgeon");
		}
		else
			JOptionPane.showMessageDialog(null, "Tu ne peux arroser ce bourgeon qu'une seule fois!");
	}

	public void nettoyer(){
		deplacerJar();
		this.jardinierSelected.estOccupe = true;
		this.jardinierSelected.actions.add("nettoyer");
	}

	public void engagerJardinier(){
		if(this.getArgent()<this.getPrixJardinier()){
			JOptionPane.showMessageDialog(null, "Tu es pauvre!");
		}
		else{
			this.jardiniers.add(new Jardinier("Marcel", this));
			this.setArgent(this.getArgent()-this.getPrixJardinier());
			this.setPrixJardinier(this.getPrixJardinier()*2);
		}
	}

	public void entrerFleuriste(){
		
		deplacerJar();
		AffFleuriste fleuriste = new AffFleuriste(this);
		f.add(fleuriste);
		this.setDansMagasin(true);
		f.setVisible(true);
		

	}

	public void creationDemande(){
		double n = Math.random();
		if(n<probabiliteDemande){
			double p = Math.random();
			if(p < probabiliteBleue){
				setDemandeFleurBleue(this.demandeFleurBleue + 1);
			}
			else if(p < probabiliteBleue + probabiliteJaune){
				setDemandeFleurJaune(this.demandeFleurJaune + 1);
			}
			else if(p < probabiliteBleue + probabiliteJaune + probabiliteRouge){
				setDemandeFleurRouge(this.demandeFleurRouge + 1);
			}
			else {
				setDemandeFleurViolette(this.demandeFleurViolette + 1);
			}
		}

		if(this.demandeFleurBleue+this.demandeFleurJaune+this.demandeFleurRouge+this.demandeFleurViolette>10){
			this.attente++;
		}
		if(this.attente>10&&Carte.score>0){
			this.attente=0;
			Carte.score--;
		}
	}

	public void diminuerDemandeFleurBleue(int nb){
		System.out.println(this.demandeFleurBleue + "avant");
		this.demandeFleurBleue = this.demandeFleurBleue - nb;
		System.out.println(this.demandeFleurBleue + "après");
	}

	public void diminuerDemandeFleurRouge(int nb){
		this.demandeFleurRouge = this.demandeFleurRouge - nb;
	}

	public void diminuerDemandeFleurJaune(int nb){
		this.demandeFleurJaune = this.demandeFleurJaune - nb;
	}

	public void diminuerDemandeFleurViolette(int nb){
		this.demandeFleurViolette = this.demandeFleurViolette - nb;
	}

	public void sortirFleuriste(){
		this.setDansMagasin(false);
		f.setVisible(false);
	}


	// tous les getters et setters

	public int[] getCaseSelected() {
		return caseSelected;
	}

	public void setCaseSelected(int[] caseSelected) {
		this.ancienCaseSelected = this.caseSelected;
		this.caseSelected = caseSelected;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		Carte.score = score;
	}

	public int getArgent() {
		return argent;
	}

	public void setArgent(int argent) {
		Carte.argent = argent;
	}

	public Parametre getParametre() {
		return parametre;
	}

	public void setParametre(Parametre parametre) {
		this.parametre = parametre;
	}

	public ArrayList<Objet> getObjetselect() {
		return this.objetSelect;
	}

	public void setObjetselect(ArrayList<Objet> objetselect) {
		this.objetSelect = objetselect;
	}

	public ArrayList<ArrayList<Objet>> getTabInt() {
		return tableau;
	}

	public void setTabInt(ArrayList<ArrayList<Objet>> tabInt) {
		this.tableau = tabInt;
	}

	public int getGraineBleue() {
		return graineBleue;
	}

	public void setGraineBleue(int graine) {
		Carte.graineBleue = graine;
	}

	public int getGraineRouge() {
		return graineRouge;
	}

	public void setGraineRouge(int graine) {
		Carte.graineRouge = graine;
	}

	public int getGraineJaune() {
		return graineJaune;
	}

	public void setGraineJaune(int graine) {
		Carte.graineJaune = graine;
	}

	public int getGraineViolette() {
		return graineViolette;
	}

	public void setGraineViolette(int graine) {
		Carte.graineViolette = graine;
	}

	public int getFleurBleue() {
		return fleurBleue;
	}

	public void setFleurBleue(int fleur) {
		Carte.fleurBleue = fleur;
	}

	public int getFleurJaune() {
		return fleurJaune;
	}

	public void setFleurJaune(int fleur) {
		Carte.fleurJaune = fleur;
	}

	public int getFleurRouge() {
		return fleurRouge;
	}

	public void setFleurRouge(int fleur) {
		Carte.fleurRouge = fleur;
	}

	public int getFleurViolette() {
		return fleurViolette;
	}

	public void setFleurViolette(int fleur) {
		Carte.fleurViolette = fleur;
	}

	public int getEngrais() {
		return engrais;
	}

	public void setEngrais(int engrais) {
		Carte.engrais = engrais;
	}

	public Boolean getDansMagasin() {
		return dansMagasin;
	}

	public void setDansMagasin(Boolean dansMagasin) {
		this.dansMagasin = dansMagasin;
	}


	public int getDemandeFleurBleue() {
		return demandeFleurBleue;
	}


	public void setDemandeFleurBleue(int demandeFleurBleue) {
		this.demandeFleurBleue = demandeFleurBleue;
	}


	public int getDemandeFleurRouge() {
		return demandeFleurRouge;
	}


	public void setDemandeFleurRouge(int demandeFleurRouge) {
		this.demandeFleurRouge = demandeFleurRouge;
	}


	public int getDemandeFleurViolette() {
		return demandeFleurViolette;
	}


	public void setDemandeFleurViolette(int demandeFleurViolette) {
		this.demandeFleurViolette = demandeFleurViolette;
	}


	public int getDemandeFleurJaune() {
		return demandeFleurJaune;
	}


	public void setDemandeFleurJaune(int demandeFleurJaune) {
		this.demandeFleurJaune = demandeFleurJaune;
	}

	public int getPrixJardinier() {
		return prixJardinier;
	}

	public void setPrixJardinier(int prixJardinier) {
		this.prixJardinier = prixJardinier;
	}



}
