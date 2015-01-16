import java.awt.Color;
import java.io.IOException;
import java.util.concurrent.Semaphore;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimGarden {

	public static void creerCarte(Parametre parametre, String nom) throws InvalidMidiDataException, IOException, MidiUnavailableException {


		// On crée une carte
		Carte carte = new Carte(parametre, nom);


		// On lui ajoute un jardinier
		Jardinier jojo = new Jardinier("jojo", carte);
		carte.jardiniers.add(jojo);

		// on crée le Jframe global

		JPanel panel = new JPanel();
		panel.setLayout(null);


		//on crée les affichages
		AffCarte affCarte = new AffCarte(carte);
		AffJeux affJeux = new AffJeux(carte);
		AffDescription affDescription = new AffDescription(carte);
		AffDemande affDemande = new AffDemande(carte);
		AffGraine affGraine = new AffGraine(carte);
		AffFleurs affFleurs = new AffFleurs(carte);

		//on place l'affjeux
		affJeux.setBounds(0, 0, carte.getParametre().getLargeurPixJeux(), carte.getParametre().getHauteurPixJeux());

		//on place la demande
		affDemande.setBounds(0, carte.getParametre().getHauteurPixJeux()+5, carte.getParametre().getLargeurPixDemande(), carte.getParametre().getHauteurPixDemande());

		//on place la carte
		affCarte.setBounds(carte.getParametre().getLargeurPixDemande()+5,carte.getParametre().getHauteurPixJeux()+5,carte.getParametre().getLargeurPixCarte(),carte.getParametre().getHauteurPixCarte());

		// on place affdescription
		affDescription.setBounds(carte.getParametre().getLargeurPixDemande()+carte.getParametre().getLargeurPixCarte()+10,carte.getParametre().getHauteurPixJeux()+5,
				carte.getParametre().getLargeurPixDescription(),carte.getParametre().getHauteurPixDescription());

		//on place l'aff graine
		affGraine.setBounds(0,carte.getParametre().getHauteurPixJeux()+carte.getParametre().getHauteurPixDescription()+10,carte.getParametre().getLargeurPixGraine(),carte.getParametre().getHauteurPixGraine());

		//on place l'afffleur
		affFleurs.setBounds(carte.getParametre().getLargeurPixGraine()+5,carte.getParametre().getHauteurPixJeux()+carte.getParametre().getHauteurPixDescription()+10,carte.getParametre().getLargeurPixFleur(),carte.getParametre().getHauteurPixFleur());

		//on ajoute les affichages
		panel.add(affDescription);
		panel.add(affJeux);
		panel.add(affCarte);
		panel.add(affDemande);
		panel.add(affGraine);
		panel.add(affFleurs);

		JFrame f = new JFrame();
		f.setSize(carte.getParametre().getLargeurPixJeux()+45,carte.getParametre().getHauteurPixCarte()+carte.getParametre().getHauteurPixJeux()+carte.getParametre().getHauteurPixFleur()+10);
		f.setTitle("Le nouveau jeu de jardinage trop stylé !");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.add(panel);
		f.setBackground(Color.black);
		f.setVisible(true);

		affCarte.addMouseListener(affDescription);

		// On configure la musique

		Musique musique = new Musique(carte);

		//Boucle principale

		while (true) {
			try {
				Thread.sleep(75);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (int i = 0; i < carte.getParametre().getNbLigneCarte(); i++) {
				for (int j = 0; j < carte.getParametre().getNbColonneCarte(); j++) {
					for (int k = 1; k < carte.getObjetnb(i, j).size(); k++) {
						carte.getObjetnb(i, j).get(k).actionAuto();
					}
				}
			}

			for(int j = 0; j < carte.jardiniers.size()-1; j++){
				carte.jardiniers.get(j).actionAuto();
			}


			musique.lancerMusiqueFond();


			carte.creationDemande();	

			affDescription.paint();
			affGraine.paint();
			affDemande.paint();
			affFleurs.paint();
			affCarte.paint();
			affJeux.paint();


		}
	}

	public static void main(String[] args) throws InvalidMidiDataException, IOException, MidiUnavailableException {

		Parametre parametre = null;
		Semaphore sem = new Semaphore(0);
		Menu Menu = new Menu(parametre, sem);
		Menu.creerMenuPrincipal();


		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		creerCarte(Menu.getParametre(), "GuiGui le Bogosse");

	}

}
