import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class FleurRouge extends Fleur{

	public FleurRouge(Boolean engrais) {
		super(engrais);
		try {
			imageFleur = ImageIO.read(new File("rougeG.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(engrais){
			this.tpPousse = 600;
		} else {
			this.tpPousse = 650;
		}
		this.tGraine = 450;
		this.tBourgeon = 200;
	}
}
