import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Rocher extends Objet {


	public Rocher() {
		super();
		try {
			this.image = ImageIO.read(new File("caillou1G.png"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		this.description = "On ne peut rien y planter";
		this.nom = "caillou";
		this.actions=new ArrayList<String>();
	}
}
