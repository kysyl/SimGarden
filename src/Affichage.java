import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Affichage extends JPanel{

	protected Carte carte;

	public Affichage(Carte carte) {
		super();
		this.carte = carte;
	}
	
}