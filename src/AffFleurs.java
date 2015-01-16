import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class AffFleurs extends Affichage {


	public Carte carte;
	public JLabel FleurBleue, FleurJaune, FleurRouge, FleurViolette;
	public JLabel titre;
	public JLabel imageBleue, imageJaune, imageRouge, imageViolette;

	


	public AffFleurs(Carte carte) {
		super(carte);
		this.carte=carte;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.setLayout(new GridLayout(3,4));
		
		this.titre = new JLabel("Tes Fleurs : ",SwingConstants.LEFT);
		this.FleurBleue = new JLabel("" + this.carte.getFleurBleue(),SwingConstants.CENTER);
		this.FleurJaune = new JLabel("" + this.carte.getFleurJaune(),SwingConstants.CENTER);
		this.FleurRouge = new JLabel("" + this.carte.getFleurRouge(),SwingConstants.CENTER);
		this.FleurViolette = new JLabel("" + this.carte.getFleurViolette(),SwingConstants.CENTER);
		JLabel blanc1 = new JLabel("");
		JLabel blanc2 = new JLabel("");
		JLabel blanc3 = new JLabel("");
		
		this.add(this.titre);
		this.add(blanc1);
		this.add(blanc2);
		this.add(blanc3);
		
		ImageIcon iconBleu = new ImageIcon("BleueG.png");
		this.imageBleue= new JLabel(iconBleu);
		this.add(this.imageBleue);
		this.add(this.FleurBleue); 
		
		ImageIcon iconJaune = new ImageIcon("JauneG.png");
		this.imageJaune= new JLabel(iconJaune);
		this.add(this.imageJaune);
		this.add(this.FleurJaune); 
		
		ImageIcon iconRouge = new ImageIcon("RougeG.png");
		this.imageRouge= new JLabel(iconRouge);
		this.add(this.imageRouge);
		this.add(this.FleurRouge); 
		
		ImageIcon iconViolette = new ImageIcon("VioletteG.png");
		this.imageViolette= new JLabel(iconViolette);
		this.add(this.imageViolette);
		this.add(this.FleurViolette);

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
		
		this.FleurBleue.setText("" + this.carte.getFleurBleue());
		this.FleurJaune.setText("" + this.carte.getFleurJaune());
		this.FleurRouge.setText("" + this.carte.getFleurRouge());
		this.FleurViolette.setText("" + this.carte.getFleurViolette());
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
		g.drawImage(fond, 0, 0, this.carte.getParametre().getLargeurPixFleur(),this.carte.getParametre().getHauteurPixFleur(), this); // dessine l'image en fond
	}
	
}
