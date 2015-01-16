import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Magasin extends Objet {

	public Magasin() {
		super();
		try {
			this.image = ImageIO.read(new File("fleuristeG.png"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		this.description = "Voici le fleuriste!";
		this.nom = "Fleuriste";
		ArrayList<String> actions = new ArrayList<String>();
		String a = "Entrer chez le fleuriste";
		String b = "Engager un nouveau jardinier";
		actions.add(a);
		actions.add(b);
		this.actions = actions;

	}
}
