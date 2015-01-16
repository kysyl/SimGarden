import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TraitementBout implements ActionListener {
	Carte carte;

	public TraitementBout(Carte carte) {
		this.carte = carte;
	}

	public void actionPerformed(ActionEvent e) {

		if (((JButton) e.getSource()).getText() == "Cueillir") {
			this.carte.cueillir();
		}

		if (((JButton) e.getSource()).getText() == "Planter une fleur bleue") {
			this.carte.planterFleurBleue();
		}

		if (((JButton) e.getSource()).getText() == "Planter une fleur jaune") {
			this.carte.planterFleurJaune();
		}

		if (((JButton) e.getSource()).getText() == "Planter une fleur violette") {
			this.carte.planterFleurViolette();
		}

		if (((JButton) e.getSource()).getText() == "Planter une fleur rouge") {
			this.carte.planterFleurRouge();
		}

		if (((JButton) e.getSource()).getText() == "Déplacer") {
			this.carte.deplacerJar();
		}

		if (((JButton) e.getSource()).getText() == "Répandre de l'engrais") {
			this.carte.repandreEngrais();
		}

		if (((JButton) e.getSource()).getText() == "Jeter la fleur fanée") {
			this.carte.nettoyer();
		}

		if (((JButton) e.getSource()).getText() == "Entrer chez le fleuriste") {
			this.carte.entrerFleuriste();
		}

		if (((JButton) e.getSource()).getText() == "Engager un nouveau jardinier") {
			this.carte.engagerJardinier();
		}

		if (((JButton) e.getSource()).getText() == "Arroser la graine") {
			this.carte.arroserGraine();
		}

		if (((JButton) e.getSource()).getText() == "Arroser le bourgeon") {
			this.carte.arroserBourgeon();
		}
	}
}