import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


/* Voici la classe AffJeux. Cette classe correspond à l'affichage des infos du jeu (Argent, temps, score,etc...
 * La classe AffJeux hérite de la classe Affichage. C'est donc un JPanel.
 * Son construteur prend en argument une carte.
 */
@SuppressWarnings("serial")
public class AffJeux extends Affichage implements MouseListener,ActionListener{

	Carte carte;
	JLabel argent, score;
	JLabel engrais;
	JLabel imageEngrais, imageArgent, imageScore, imageChrono;


	public AffJeux(Carte carte) {
		super(carte);
		this.carte=carte;
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		this.setLayout(new GridLayout(2,4));

		this.argent = new JLabel("" + this.carte.getArgent());
		this.imageArgent = new JLabel();
		ImageIcon iconArgent = new ImageIcon("cash.png");//Change l'image
		Image zoomArgent = scaleImage(iconArgent.getImage(), 50, 50);//taille en pixels
		Icon iconScaledArgent = new ImageIcon(zoomArgent);
		this.imageArgent.setIcon(iconScaledArgent);
			

		this.score = new JLabel("                " + this.carte.getScore());
		this.imageScore = new JLabel();
		ImageIcon iconScore = new ImageIcon("score.png");//Change l'image
		Image zoomScore = scaleImage(iconScore.getImage(), 50, 50);//taille en pixels
		Icon iconScaledScore = new ImageIcon(zoomScore);
		this.imageScore.setIcon(iconScaledScore);
		
		this.imageChrono = new JLabel();
		ImageIcon iconChrono = new ImageIcon("chrono.png");//Change l'image
		Image zoomChrono = scaleImage(iconChrono.getImage(), 50, 50);//taille en pixels
		Icon iconScaledChrono = new ImageIcon(zoomChrono);
		this.imageChrono.setIcon(iconScaledChrono);
		
		
		this.engrais = new JLabel("" + this.carte.getEngrais());//
		this.imageEngrais = new JLabel();
		ImageIcon iconEngrais = new ImageIcon("engraisJeux.png");//Change l'image
		Image zoomEngrais = scaleImage(iconEngrais.getImage(), 50, 50);//taille en pixels
		Icon iconScaledEngrais = new ImageIcon(zoomEngrais);
		this.imageEngrais.setIcon(iconScaledEngrais);
		
		
		
		
		this.add(this.imageScore);
		this.add(this.imageEngrais);
		this.add(this.imageArgent);
		this.add(this.imageChrono);
		
		this.add(this.score);
		this.add(this.engrais);
		this.add(this.argent);
		this.add(new Chrono(this.carte));
		
		
	}

	public void paint(){

		this.argent.setText("" + this.carte.getArgent());
		this.score.setText("                " + this.carte.getScore());
		
		this.engrais.setText("" + this.carte.getEngrais());

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

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

	@Override
	public void actionPerformed(ActionEvent arg0) {

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
		g.drawImage(fond, 0, 0, this.carte.getParametre().getLargeurPixJeux()+10,this.carte.getParametre().getHauteurPixJeux(), this); // dessine l'image en fond
	}
	
	
	public static Image scaleImage(Image source, int width, int height) {
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(source, 0, 0, width, height, null);
		g.dispose();
		return img;
	}

}


