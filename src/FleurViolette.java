import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class FleurViolette extends Fleur{
	
	public FleurViolette(Boolean engrais) {
		super(engrais);
		try {
			imageFleur = ImageIO.read(new File("violetteG.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(engrais){
			this.tpPousse = 700;
		} else {
			this.tpPousse = 750;
		}
		this.tGraine = 550;
		this.tBourgeon = 200;
	}
}
