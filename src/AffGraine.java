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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class AffGraine extends Affichage {
	
	public Carte carte;
	public JLabel graineBleue, graineJaune, graineRouge, graineViolette;
	public JLabel titre;
	public JLabel imageBleue, imageJaune, imageRouge, imageViolette;

	


	public AffGraine(Carte carte) {
		super(carte);
		this.carte=carte;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	
		this.setLayout(new GridLayout(3,4));
		
		
		this.titre = new JLabel("Tes Graines : ",SwingConstants.LEFT);
		this.graineBleue = new JLabel("" + this.carte.getGraineBleue());
		this.graineJaune = new JLabel("" + this.carte.getGraineJaune());
		this.graineRouge = new JLabel("" + this.carte.getGraineRouge());
		this.graineViolette = new JLabel("" + this.carte.getGraineViolette());
		JLabel blanc1 = new JLabel("");
		JLabel blanc2 = new JLabel("");
		JLabel blanc3 = new JLabel("");
			
		
		this.add(this.titre);
		this.add(blanc1);
		this.add(blanc2);
		this.add(blanc3);
		
		ImageIcon iconBleue = new ImageIcon("graineBleue.png");
		Image zoomBleue = scaleImage(iconBleue.getImage(), 40,40);//taille en pixels
		Icon iconScaledBleue = new ImageIcon(zoomBleue);
		this.imageBleue = new JLabel(iconScaledBleue);
		this.add(this.imageBleue);
		this.add(this.graineBleue); 
		
		ImageIcon iconJaune = new ImageIcon("graineJaune.png");
		Image zoomJaune = scaleImage(iconJaune.getImage(), 40,40);//taille en pixels
		Icon iconScaledJaune = new ImageIcon(zoomJaune);
		this.imageJaune = new JLabel(iconScaledJaune);
		this.add(this.imageJaune);
		this.add(this.graineJaune); 
		
		ImageIcon iconRouge = new ImageIcon("graineRouge.png");
		Image zoomRouge = scaleImage(iconRouge.getImage(), 40,40);//taille en pixels
		Icon iconScaledRouge = new ImageIcon(zoomRouge);
		this.imageRouge = new JLabel(iconScaledRouge);
		this.add(this.imageRouge);
		this.add(this.graineRouge); 
		
		ImageIcon iconViolette = new ImageIcon("graineViolette.png");
		Image zoomViolette = scaleImage(iconViolette.getImage(), 40,40);//taille en pixels
		Icon iconScaledViolette = new ImageIcon(zoomViolette);
		this.imageViolette = new JLabel(iconScaledViolette);
		this.add(this.imageViolette);
		this.add(this.graineViolette);

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
		
		this.graineBleue.setText("" + this.carte.getGraineBleue());
		this.graineJaune.setText("" + this.carte.getGraineJaune());
		this.graineRouge.setText("" + this.carte.getGraineRouge());
		this.graineViolette.setText("" + this.carte.getGraineViolette());
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
		g.drawImage(fond, 0, 0, this.carte.getParametre().getLargeurPixGraine(),this.carte.getParametre().getHauteurPixGraine(), this); // dessine l'image en fond
	}
	
}
