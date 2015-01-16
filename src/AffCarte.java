import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class AffCarte extends Affichage implements MouseListener {

	protected Carte carte;

	public AffCarte(Carte carte) {
		super(carte);
		this.carte = carte;
		this.addMouseListener(this);
	}

	public void paint() {
		Graphics g =  this.getGraphics();
		for (int i = 0; i < this.carte.getParametre().getNbLigneCarte(); i++) {
			for (int j = 0; j < this.carte.getParametre().getNbColonneCarte(); j++) {
				for (int k = 0; k < this.carte.getObjetnb(i, j).size(); k++) {
					g.drawImage(this.carte.getObjetnb(i, j).get(k).getImage(), 
							this.carte.getParametre().getTailleImage() * j,
							this.carte.getParametre().getTailleImage() * i,
							this.carte.getParametre().getTailleImage(),
							this.carte.getParametre().getTailleImage(), 
							this); // position et taille

				}
			}
		}
		for(int i = 0; i < this.carte.jardiniers.size()-1; i++){
			g.drawImage(this.carte.jardiniers.get(i).getImage(),  //image d'origine dont on va dessiner une portion définie par ori
			this.carte.jardiniers.get(i).posX, this.carte.jardiniers.get(i).posY,  //position du premier coin de l'image a dessiner
			this.carte.jardiniers.get(i).posX + this.carte.jardiniers.get(i).widthCarte, this.carte.jardiniers.get(i).posY + this.carte.jardiniers.get(i).heightCarte, //position du 2eme coin de l'image à dessiner
			this.carte.jardiniers.get(i).oriX, this.carte.jardiniers.get(i).oriY,  //position du premier coin de la portion d'image d'origine
			this.carte.jardiniers.get(i).oriX + this.carte.jardiniers.get(i).widthOri, this.carte.jardiniers.get(i).oriY + this.carte.jardiniers.get(i).heightOri, //position du deuxième coin de l'image d'origine
			null);
		}
		g.setColor(Color.gray);
		g.drawRect(this.carte.caseSelected[1]*this.carte.parametre.getTailleImage(), this.carte.caseSelected[0]*this.carte.getParametre().getTailleImage(), this.carte.getParametre().getTailleImage(), this.carte.getParametre().getTailleImage());
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if ((arg0.getX() <= this.carte.getParametre().getLargeurPixCarte())
				&& (arg0.getY() <= this.carte.getParametre().getHauteurPixCarte())) {
			this.carte.setObjetselect(this.carte.getObjetpix(arg0.getX(),
					arg0.getY()));
			int[] tab = new int[2];
			tab[0] = arg0.getY()/this.carte.getParametre().getTailleImage();
			tab[1] = arg0.getX()/this.carte.getParametre().getTailleImage();
			this.carte.setCaseSelected(tab);
		}
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
