import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/* Voici la classe AffDescription. La classe AffDescription hérite de la classe Affichage. C'est donc un JPanel.
 * Il a comme un attribut un ObjetFixe qui est son objet sélectionné.
 * Son construteur prend en argument une carte.
 * La méthode paint change les objets selectionnes de la carte et affiche le Jpanel avec en haut les noms des objets, ensuite des boutons correspondant aux actions possibles
 * des objets et enfin les image des objets.
 */

@SuppressWarnings("serial")
public class AffDescription extends Affichage implements MouseListener{
	JLabel labelNom;
	ArrayList<JButton> labelActions;
	JLabel labelImage;
	JLabel labelDescription;


	public AffDescription(Carte carte) { //Constructeur
		super(carte);
		
		this.carte=carte;
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.labelActions=new ArrayList<JButton>(6);

		this.labelNom=new JLabel("Aucun objet sélectionné");
		
		this.labelDescription=new JLabel("Commencez par cliquer");

		this.labelImage=new JLabel();

		this.add(this.labelNom);
		
		this.add(this.labelImage);
		
		for(int i=0;i<6;i++){ //par défaut, le JPanel a 6 boutons qu'on set invisbles (seule solution qu'on a trouvée pour un résultat efficace)
			JButton bouton = new JButton("Action " + (i+1));
			this.labelActions.add(bouton);
			this.labelActions.get(i).addActionListener(new TraitementBout(this.carte));
			bouton.setVisible(false);
			this.add(bouton);
		}
		
		this.add(this.labelDescription);

	}

	public static Image scaleImage(Image source, int width, int height) {
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(source, 0, 0, width, height, null);
		g.dispose();
		return img;
	}

	public void paint(){//Prend l'objet le plus haut dans l'arrayList Objetselect et affiche son nom, ses actions...
		
	
		
		int lastIndex = this.carte.getObjetselect().size();
		
		this.labelNom.setText(this.carte.getObjetselect().get(lastIndex-1).getNom()); //Change le nom de labelDescription
		this.labelDescription.setText(this.carte.getObjetselect().get(lastIndex-1).description);

		ImageIcon icon = new ImageIcon(this.carte.getObjetselect().get(lastIndex-1).image); //Change l'image
		Image zoom = scaleImage(icon.getImage(), this.carte.getParametre().getLargeurPixDescription(), this.carte.getParametre().getLargeurPixDescription());//taille en pixels
		Icon iconScaled = new ImageIcon(zoom);
		this.labelImage.setIcon(iconScaled);
		
		for(int i = 0; i < this.carte.getObjetselect().get(lastIndex-1).actions.size();i++){ //Change les bouttons
			this.labelActions.get(i).setVisible(true);//rend visible un certain nb de boutton
			this.labelActions.get(i).setText(this.carte.getObjetselect().get(lastIndex-1).actions.get(i));
			
		}
		for(int i = this.carte.getObjetselect().get(lastIndex-1).actions.size(); i<this.labelActions.size();i++){
			this.labelActions.get(i).setVisible(false);//rend invisible les boutons inutiles
		}
		
		
		
		
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
			this.paint();
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
	
	protected void paintComponent(Graphics g){ //méthode pour le fond d'écran de l'AffDesciption
	    super.paintComponent(g); // necessaire pour le dessin de l'icone et du texte eventuel
	 
	    Image fond = null;
	    try {
			fond=ImageIO.read(new File("bois6.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    g.drawImage(fond, 0, 0, this.carte.getParametre().getLargeurPixCarte()+this.carte.getParametre().getLargeurPixDescription(), this.carte.getParametre().getHauteurPixDescription(), this); // dessine l'image en fond
	}

}