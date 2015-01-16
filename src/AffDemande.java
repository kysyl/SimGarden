import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
	
@SuppressWarnings("serial")
public class AffDemande extends Affichage  {
	

	public Carte carte;
	public JLabel demandeFleurBleue, demandeFleurJaune, demandeFleurRouge, demandeFleurViolette;
	public JLabel titre;
	public JLabel imageBleue, imageJaune, imageRouge, imageViolette;


	public AffDemande(Carte carte) {
		super(carte);
		this.carte=carte;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.setLayout(new GridLayout(9,1));// Les objets ajoutés à ce JPanel seront disposés verticalement
		this.titre = new JLabel("les demandes",SwingConstants.CENTER);
		this.demandeFleurBleue = new JLabel("" + this.carte.getDemandeFleurBleue(),SwingConstants.CENTER);
		this.demandeFleurJaune = new JLabel("" + this.carte.getDemandeFleurJaune(),SwingConstants.CENTER);
		this.demandeFleurRouge = new JLabel("" + this.carte.getDemandeFleurRouge(),SwingConstants.CENTER);
		this.demandeFleurViolette = new JLabel("" + this.carte.getDemandeFleurViolette(),SwingConstants.CENTER);
		
		this.add(this.titre);
		
		ImageIcon iconBleu = new ImageIcon("BleueG.png");
		this.imageBleue= new JLabel(iconBleu);
		this.add(this.imageBleue);
		this.add(this.demandeFleurBleue); 
		
		ImageIcon iconJaune = new ImageIcon("JauneG.png");
		this.imageJaune= new JLabel(iconJaune);
		this.add(this.imageJaune);
		this.add(this.demandeFleurJaune); 
		
		ImageIcon iconRouge = new ImageIcon("RougeG.png");
		this.imageRouge= new JLabel(iconRouge);
		this.add(this.imageRouge);
		this.add(this.demandeFleurRouge); 
		
		ImageIcon iconViolette = new ImageIcon("VioletteG.png");
		this.imageViolette= new JLabel(iconViolette);
		this.add(this.imageViolette);
		this.add(this.demandeFleurViolette);

	}
	
	public static Image scaleImage(Image source, int width, int height) {
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(source, 0, 0, width, height, null);
		g.dispose();
		return img;
	}

	public void paint(){
		
		this.demandeFleurBleue.setText("" + this.carte.getDemandeFleurBleue());
		this.demandeFleurJaune.setText("" + this.carte.getDemandeFleurJaune());
		this.demandeFleurRouge.setText("" + this.carte.getDemandeFleurRouge());
		this.demandeFleurViolette.setText("" + this.carte.getDemandeFleurViolette());
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
		g.drawImage(fond, 0, 0, this.carte.getParametre().getLargeurPixDemande(),this.carte.getParametre().getHauteurPixDemande(), this); // dessine l'image en fond
	}
}


