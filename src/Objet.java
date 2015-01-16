import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Objet {
	
	ArrayList<String> actions;
	Image image;
	String nom, description;
	boolean engrais, arroser;
	int tBourgeon, tGraine, tpPousse;

	public void setNom(String nom) {
		this.nom = nom;
		this.engrais = false;
	}

	public Objet() {

	}

	public void actionAuto() {

	}

	public ArrayList<String> getAction() {
		return this.actions;
	}

	public void setAction(ArrayList<String> action) {
		this.actions = action;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public String getNom(){
		return this.nom;
	}
	public String getDescription(){
		return this.description;
	}
	public void setEngrais(boolean engrais){
		this.engrais = engrais;
	}
	public boolean getEngrais(){
		return this.engrais;
	}
	public void setArroser(boolean arroser){
		this.arroser = arroser;
	}
	public boolean getArroser(){
		return this.arroser;
	}

	public int getTpPousse() {
		return tpPousse;
	}

	public void setTpPousse(int tpPousse) {
		this.tpPousse = tpPousse;
	}

	public int gettBourgeon() {
		return tBourgeon;
	}

	public void settBourgeon(int tBourgeon) {
		this.tBourgeon = tBourgeon;
	}

	public int gettGraine() {
		return tGraine;
	}

	public void settGraine(int tGraine) {
		this.tGraine = tGraine;
	}

}
