import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public final class Chrono extends JLabel implements MouseListener,
ActionListener {

	private static final long serialVersionUID = 1L;
	private long debutTemps; // D�but du chrono (Temps en ms)
	private double seconds;
	private Timer timer;
	private Timer timer2;

	Color defaultColor; // Couleur par d�faut du label
	Color blinkingColor; // Couleur de clignotement
	Carte carte;


	public Chrono(Carte carte) {

		// On cr�e le timer dans le constructeur
		super("D�marrer");
		addMouseListener(this);
		timer = new Timer(100, this);
		timer2 = createTimer();
		seconds = 0;
		this.blinkingColor = Color.lightGray;
		this.defaultColor = getForeground();
		this.carte = carte;


	}

	public void conversion(long time){
		int temps = (int) time;
		int heure = temps / 3600;
		int minute = (temps / 60) % 60;
		int seconde = temps % 60;
		String h = String.valueOf(heure);
		String m = String.valueOf(minute);
		String s = String.valueOf(seconde);
		String zero = String.valueOf(0);

		if (minute < 10 && seconde < 10) {
			setText("	Temps :  " + h + ":" + zero + m + ":" + zero + s);
		}
		if (minute < 10 && seconde > 9) {
			setText("	Temps :  " + h + ":" + zero + m + ":" + s);
		}
		if (minute > 9 && seconde < 10) {
			setText("	Temps :  " + h + ":" + m + ":" + zero + s);
		}
		if (minute > 9 && seconde > 9) {
			setText("	Temps :  " + h + ":" + m + ":" + s);
		}
	}
	public void actionPerformed(ActionEvent evt) {
		// M�thode appel�e quand un event est re�u. Permet d'afficher le temps
		// �coul�.



		long time = (System.currentTimeMillis() - debutTemps) / 1000;
		conversion(time);


	}

	private Timer createTimer() {
		// Cr�ation d'une instance du Listener
		// associ� au timer
		ActionListener action = new ActionListener() { // M�thode appel�e � chaque tic du timer

			public void actionPerformed(ActionEvent event) { // Inversion de la couleur

				if (getForeground().equals(defaultColor))
					setForeground(blinkingColor);
				else
					setForeground(defaultColor);
			}
		};

		// Cr�ation d'un timer qui g�n�re un tic
		// chaque 500 milli�me de seconde
		return new Timer(500, action);
	}

	public void mousePressed(MouseEvent evt) { // MouseListener qui reagit quand on clique sur le temps

		if (timer.isRunning() == false) { // D�marre le temps

			setForeground(defaultColor);
			debutTemps = evt.getWhen() - (long) ((int) seconds * 1000.0); // On ajoute le temps avant la pause pour pas red�marrer � z�ro
			long time = (System.currentTimeMillis() - debutTemps) / 1000;
			conversion(time);
			timer.restart();
			timer2.stop();

		} else { // permet de stopper le temps

			timer.stop();
			timer2.restart();
			long endTime = evt.getWhen();
			seconds = (endTime - debutTemps) / 1000.0; // seconds est le temps affich� au moment de la pause
			conversion((long) seconds);

		}
	}

	public void mouseReleased(MouseEvent evt) {
	}

	public void mouseClicked(MouseEvent evt) {
	}

	public void mouseEntered(MouseEvent evt) {
	}

	public void mouseExited(MouseEvent evt) {
	}
}
