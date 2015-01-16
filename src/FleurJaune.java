import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class FleurJaune extends Fleur{

	public FleurJaune(Boolean engrais) {
		super(engrais);
		try {
			imageFleur = ImageIO.read(new File("jauneG.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(engrais){
			this.tpPousse = 500;
		} else {
			this.tpPousse = 550;
		}
		this.tGraine = 400;
		this.tBourgeon = 200;
	}
}
