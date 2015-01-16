import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Menu extends JDialog implements ActionListener {

	private int NbColonnes;
	private int NbLignes;
	private static JComboBox NbL;
	private static JComboBox NbC;
	private static JTextField nom;
	private static JFrame menuInit;
	private static Parametre parametre;
	private static Semaphore sem;

	public Menu(Parametre parametre, Semaphore sem){
		Menu.parametre=parametre;
		Menu.sem=sem;
	}

	public  void creerMenuPrincipal(){
		menuInit = new JFrame(); 
		JButton BDemarrer = new JButton("Demarrer");
		//JButton BOptions = new JButton("Options");
		JButton BValider = new JButton("Valider");
		BValider.addActionListener(this);
		JButton BQuitter = new JButton("Quitter");
		BQuitter.addActionListener(this);


		//Ecran Choix de la Résolution
		JPanel Resolution = new JPanel();
		JRadioButton Resol1 = new JRadioButton("400*800");
		JRadioButton Resol2 = new JRadioButton("800*800");
		JRadioButton Resol3 = new JRadioButton("1080*1200");
		ButtonGroup BG = new ButtonGroup(); //permet de ne pouvoir sélectionner qu'un seul bouton
		Resolution.setBorder(BorderFactory.createTitledBorder("Résolution"));
		BG.add(Resol1);
		BG.add(Resol2);
		BG.add(Resol3);
		Resolution.add(Resol1);
		Resolution.add(Resol2);
		Resolution.add(Resol3);

		//Choix du nombre de Colonne et Ligne sous forme de liste déroulante

		JPanel NbLig = new JPanel();
		NbL = new JComboBox();
		for (int i = 5; i<11;i++){
			String a = ""+i;
			NbL.addItem(a);
		}
		NbLig.setBorder(BorderFactory.createTitledBorder("Choix des Lignes"));
		NbLig.add(NbL);
		NbLig.setPreferredSize(new Dimension(250, 80));

		JPanel NbCol = new JPanel();
		NbC = new JComboBox();
		for (int i = 5; i<11;i++){
			String a = ""+i;
			NbC.addItem(a);
		}
		NbCol.setBorder(BorderFactory.createTitledBorder("Choix des Colonnes"));
		NbCol.add(NbC);
		NbCol.setPreferredSize(new Dimension(250, 80));

		JPanel ChoixLC = new JPanel();
		ChoixLC.add(NbLig, BorderLayout.CENTER);
		ChoixLC.add(NbCol, BorderLayout.SOUTH);



		// Jardinier sous forme d'un cadre où taper un nom au clavier

		JPanel panNom = new JPanel();
		panNom.setPreferredSize( new Dimension(150,60));
		nom = new JTextField();
		nom.setPreferredSize(new Dimension(100,25));
		panNom.setBorder(BorderFactory.createTitledBorder("Nom du SimGardener"));
		panNom.add(nom);
		ChoixLC.add(Resolution, BorderLayout.NORTH);

		JPanel Methode = new JPanel();


		menuInit.setSize(new Dimension(400,400));
		menuInit.setTitle("Menu Principal");
		menuInit.getContentPane().add(panNom, BorderLayout.NORTH);
		menuInit.getContentPane().add(ChoixLC, BorderLayout.CENTER);
		menuInit.getContentPane().add(BValider, BorderLayout.EAST);
		menuInit.getContentPane().add(BQuitter, BorderLayout.SOUTH);

		//BValider.addActionListener(this);

		menuInit.setVisible(true);

	}



	@Override
	public void actionPerformed(ActionEvent e) {

		if (((JButton) e.getSource()).getText()  == "Valider" ) {			

			int NbCo = Integer.parseInt((String) NbC.getSelectedItem());
			int NbLi = Integer.parseInt((String) NbL.getSelectedItem());
			menuInit.setVisible(false);

			Menu.parametre = new Parametre(NbLi,NbCo,80, 200, 100, 150, 150);
			Menu.sem.release();

		}



		if (((JButton) e.getSource()).getText()  == "Quitter" ) {
			System.exit(0);
		}

	}

	public static Parametre getParametre() {
		return parametre;
	}

	public static void setParametre(Parametre parametre) {
		Menu.parametre = parametre;
	}

	public String getNom(){
		return Menu.nom.getText();
	}
}
