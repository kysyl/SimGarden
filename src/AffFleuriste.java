import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AffFleuriste extends Affichage implements MouseListener,
ActionListener {

	JLabel labelNom;
	ArrayList<JButton> labelActions;
	JLabel labelImage;
	JLabel labelDescription;
	String[] couleurs = { "rouges", "bleues", "violettes", "jaunes" };
	JFrame f;
	JPanel choix;
	JButton moins;
	JLabel quantite;
	JButton plus;
	JButton valider;
	int prixGraineBleue, prixGraineJaune, prixGraineRouge, prixGraineViolette, prixEngrais,
	prixFleurBleue, prixFleurJaune, prixFleurRouge, prixFleurViolette;

	public AffFleuriste(Carte carte) {
		super(carte);
	
		choix = new JPanel();
		quantite = new JLabel("0");
		f = new JFrame();
		f.setSize(300, 200);
		f.setLocationRelativeTo(null);
		choix.setLayout(new BoxLayout(choix, BoxLayout.X_AXIS));

		this.carte = carte;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.labelActions = new ArrayList<JButton>(13);
		this.labelNom = new JLabel("Bienvenue chez le fleuriste!");
		this.labelDescription = new JLabel(
				"Cliquez! Faites votre choix, on a des promos aujourd'hui!");
		this.labelImage = new JLabel();
		this.add(this.labelNom);
		this.add(this.labelImage);
	    
		//les différents prix
		this.prixEngrais = 10;
		this.prixFleurBleue = 10;
		this.prixFleurJaune = 15;
		this.prixFleurRouge = 20;
		this.prixFleurViolette = 25;
		this.prixGraineBleue = 5;
		this.prixGraineBleue = 5;
		this.prixGraineJaune = 10;
		this.prixGraineRouge = 15;
		this.prixGraineViolette = 20;


		for (int i = 0; i < 4; i++) {
			JButton bouton = new JButton();
			String text = "Graines ".concat(couleurs[i]);
			bouton.setText(text);
			bouton.addActionListener(this);
			this.labelActions.add(bouton);
			bouton.setVisible(true);
			this.add(bouton);
		}
		JButton engrais = new JButton();
		engrais.setText("Engrais");
		this.labelActions.add(engrais);
		this.labelActions.get(4).addActionListener(this);
		engrais.setVisible(true);
		this.add(engrais);

		for (int i = 0; i < 4; i++) {
			JButton bouton = new JButton("Vendre Fleurs " + couleurs[i]);
			this.labelActions.add(bouton);
			this.labelActions.get(i + 5).addActionListener(this);
			bouton.setVisible(true);
			this.add(bouton);
		}

		JButton bouton = new JButton("Sortir");
		JButton plus = new JButton("+");
		JButton moins = new JButton("-");
		JButton valider = new JButton("Valider");
		bouton.addActionListener(this);
		this.labelActions.add(bouton);
		bouton.setVisible(true);
		this.add(bouton);
		moins.addActionListener(this);
		this.labelActions.add(moins);
		moins.setVisible(true);
		choix.add(moins);
		choix.add(quantite);
		plus.addActionListener(this);
		this.labelActions.add(plus);
		plus.setVisible(true);
		choix.add(plus);
		valider.addActionListener(this);
		this.labelActions.add(valider);
		valider.setVisible(true);
		choix.add(valider);

		f.add(choix);

		this.add(this.labelDescription);

		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public void paint() {

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getText().equals(
				"Graines ".concat(couleurs[0]))) {

			f.setTitle((((JButton) e.getSource()).getText()));
			f.setVisible(true);
		}

		if (((JButton) e.getSource()).getText().equals(
				"Graines ".concat(couleurs[1]))) {

			f.setTitle((((JButton) e.getSource()).getText()));
			f.setVisible(true);

		}

		if (((JButton) e.getSource()).getText().equals(
				"Graines ".concat(couleurs[2]))) {

			f.setTitle((((JButton) e.getSource()).getText()));
			f.setVisible(true);

		}

		if (((JButton) e.getSource()).getText().equals(
				"Graines ".concat(couleurs[3]))) {

			f.setTitle((((JButton) e.getSource()).getText()));
			f.setVisible(true);

		}

		if (((JButton) e.getSource()).getText().equals(
				"Engrais pour Fleurs ")) {

			f.setTitle((((JButton) e.getSource()).getText()));
			f.setVisible(true);

		}

		if (((JButton) e.getSource()).getText().equals(
				"Vendre Fleurs ".concat(couleurs[0]))) {
			if(this.carte.getDemandeFleurRouge()==0){
				JOptionPane.showMessageDialog(null, "Personne n'en veut de ta fleur! UP'Rize tarlouze");
			}
			else{
				f.setTitle((((JButton) e.getSource()).getText()));
				f.setVisible(true);
			}
		}

		if (((JButton) e.getSource()).getText().equals(
				"Vendre Fleurs ".concat(couleurs[1]))) {
			if(this.carte.getDemandeFleurBleue()==0){
				JOptionPane.showMessageDialog(null, "Personne n'en veut de ta fleur! C'est pourtant une couleur stylée");
			}
			else{
				f.setTitle((((JButton) e.getSource()).getText()));
				f.setVisible(true);

			}
		}

		if (((JButton) e.getSource()).getText().equals(
				"Vendre Fleurs ".concat(couleurs[2]))) {
			if(this.carte.getDemandeFleurViolette()==0){
				JOptionPane.showMessageDialog(null, "Personne n'en veut de ta fleur! Personne ne veut du violet c'est moisi");
			}
			else{
				f.setTitle((((JButton) e.getSource()).getText()));
				f.setVisible(true);
			}
		}

		if (((JButton) e.getSource()).getText().equals(
				"Vendre Fleurs ".concat(couleurs[3]))) {
			if(this.carte.getDemandeFleurJaune()==0){
				JOptionPane.showMessageDialog(null, "Personne n'en veut de ta fleur! Les pyros les ont toutes mangées");
			}
			else{
				f.setTitle((((JButton) e.getSource()).getText()));
				f.setVisible(true);
			}
		}

		if (((JButton) e.getSource()).getText().equals("+")) {

			int q = Integer.parseInt(quantite.getText());
			q++;		
			String qString = Integer.toString(q);
			quantite.setText(qString);

		}

		if (((JButton) e.getSource()).getText().equals("-")) {

			int q = Integer.parseInt(quantite.getText());
			q--;		
			String qString = Integer.toString(q);
			quantite.setText(qString);

		}

		if (((JButton) e.getSource()).getText().equals("Valider")) {

			int a = Integer.parseInt(quantite.getText());
			String titre = f.getTitle();

			if(titre.equals("Graines rouges")){
				if(a*this.prixGraineRouge>this.carte.getArgent()){
					JOptionPane.showMessageDialog(null, "t'es trop pauvre");
				}
				else{
					this.carte.setGraineRouge(this.carte.getGraineRouge()+ a);	
					this.carte.setArgent(this.carte.getArgent() -a*this.prixGraineRouge);
				}

			}
			if(titre.equals("Graines bleues")){
				if(a*this.prixGraineBleue>this.carte.getArgent()){
					JOptionPane.showMessageDialog(null, "t'es trop pauvre");
				}
				else{
					this.carte.setGraineBleue(this.carte.getGraineBleue()+ a);	
					this.carte.setArgent(this.carte.getArgent() -a*this.prixGraineBleue);
				}
			}
			if(titre.equals("Graines violettes")){	
				if(a*this.prixGraineViolette>this.carte.getArgent()){
					JOptionPane.showMessageDialog(null, "t'es trop pauvre");
				}
				else{
					this.carte.setGraineViolette(this.carte.getGraineViolette()+ a);	
					this.carte.setArgent(this.carte.getArgent() -a*this.prixGraineViolette);
				}

			}
			if(titre.equals("Graines jaunes")){
				if(a*this.prixGraineJaune>this.carte.getArgent()){
					JOptionPane.showMessageDialog(null, "t'es trop pauvre");
				}
				else{
					this.carte.setGraineJaune(this.carte.getGraineJaune()+ a);	
					this.carte.setArgent(this.carte.getArgent() -a*this.prixGraineJaune);
				}
			}
			if(titre.equals("Vendre Fleurs rouges")){
				if(a>this.carte.getFleurRouge()){
					JOptionPane.showMessageDialog(null, "tu n'as pas assez de fleur rouge");
				}
				else if(a>this.carte.getDemandeFleurRouge()){
					JOptionPane.showMessageDialog(null, "il n'y a pas tant de monde qui veut de ta fleur");
				}
				else{
					this.carte.diminuerDemandeFleurRouge(a);
					this.carte.setFleurRouge(this.carte.getFleurRouge()-a);
					this.carte.setScore(this.carte.getScore() + 50*a);
					this.carte.setArgent(this.carte.getArgent() + a*this.prixFleurRouge);
					JOptionPane.showMessageDialog(null, "tu as bien vendu " + a + " fleur rouge");
					
				}

			}
			if(titre.equals("Vendre Fleurs bleues")){
				if(a>this.carte.getFleurBleue()){
					JOptionPane.showMessageDialog(null, "tu n'as pas assez de fleur bleue");
				}
				else if(a>this.carte.getDemandeFleurBleue()){
					JOptionPane.showMessageDialog(null, "il n'y a pas tant de monde qui veut de ta fleur");
				}
				else{
					this.carte.diminuerDemandeFleurBleue(a);

					this.carte.setFleurBleue(this.carte.getFleurBleue()-a);
					this.carte.setScore(this.carte.getScore() + 10*a);
					JOptionPane.showMessageDialog(null, "tu as bien vendu " + a + " fleur bleue");
					this.carte.setArgent(this.carte.getArgent() + a*this.prixFleurBleue);
				}

			}	
			if(titre.equals("Vendre Fleurs violettes")){
				if(a>this.carte.getFleurViolette()){
					JOptionPane.showMessageDialog(null, "tu n'as pas assez de fleur violette");
				}
				else if(a>this.carte.getDemandeFleurViolette()){
					JOptionPane.showMessageDialog(null, "il n'y a pas tant de monde qui veut de ta fleur");
				}
				else{
					this.carte.diminuerDemandeFleurViolette(a);
					this.carte.setFleurViolette(this.carte.getFleurViolette()-a);
					this.carte.setScore(this.carte.getScore() + 75*a);
					JOptionPane.showMessageDialog(null, "tu as bien vendu " + a + " fleur violette");
					this.carte.setArgent(this.carte.getArgent() + a*this.prixFleurViolette);
				}
			}
			if(titre.equals("Vendre Fleurs jaunes")){			
				if(a>this.carte.getFleurJaune()){
					JOptionPane.showMessageDialog(null, "tu n'as pas assez de fleur jaune");
				}
				else if(a>this.carte.getDemandeFleurJaune()){
					JOptionPane.showMessageDialog(null, "il n'y a pas tant de monde qui veut de ta fleur");
				}
				else{
					this.carte.diminuerDemandeFleurJaune(a);
					this.carte.setFleurJaune(this.carte.getFleurJaune()-a);
					this.carte.setScore(this.carte.getScore() + 20*a);
					JOptionPane.showMessageDialog(null, "tu as bien vendu " + a + " fleur Jaune");
					this.carte.setArgent(this.carte.getArgent() + a*this.prixFleurJaune);
				}
			}
			if(titre.equals("Engrais")){
				if(a*this.prixEngrais>this.carte.getArgent()){
					JOptionPane.showMessageDialog(null, "t'es trop pauvre");
				}
				else{
					this.carte.setEngrais(this.carte.getEngrais()+ a);	
					this.carte.setArgent(this.carte.getArgent() -a*this.prixEngrais);
				}

			}

			//JOptionPane.showMessageDialog(null, "Quantité validée!");

			f.setVisible(false);

		}

		if (((JButton) e.getSource()).getText().equals("Sortir")) {
			this.carte.sortirFleuriste();

		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
