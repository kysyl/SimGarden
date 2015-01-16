import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class FleurBleue extends Fleur{

	public FleurBleue(Boolean engrais) {
		super(engrais);
		try {
			imageFleur = ImageIO.read(new File("bleueG.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(engrais){
			this.tpPousse = 350;
		} else {
			this.tpPousse = 400;
		}
		this.tGraine = 325;
		this.tBourgeon = 200;
	}

}
