import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Musique {

	Carte carte;
	int cpt; // 
	Sequence musiqueCarte;
	Sequence musiqueMagasin;
	Sequence musiqueRamassage;
	Sequencer sequencerCarte;
	Sequencer sequencerMagasin;
	Sequencer sequencerRamassage;
	File muscarte = new File("PkmRS_103.mid");
	File musmag = new File("PkmRS-Mart.mid");
	File musrama = new File("PkmRS-Berry.mid");

	public Musique(Carte carte) throws InvalidMidiDataException, IOException,
	MidiUnavailableException {

		this.carte = carte;
		this.cpt = 1; 


		this.musiqueCarte = MidiSystem.getSequence(muscarte);

		this.musiqueMagasin = MidiSystem.getSequence(musmag);

		this.musiqueRamassage = MidiSystem.getSequence(musrama);

		sequencerCarte = MidiSystem.getSequencer();
		sequencerCarte.setLoopStartPoint(0);
		sequencerCarte.setLoopEndPoint(-1);
		sequencerCarte.setLoopCount(Sequencer.LOOP_CONTINUOUSLY); 
		sequencerCarte.open();
		sequencerCarte.setSequence(MidiSystem.getSequence(muscarte));


		sequencerMagasin = MidiSystem.getSequencer();
		sequencerMagasin.setLoopStartPoint(0);
		sequencerMagasin.setLoopEndPoint(-1);
		sequencerMagasin.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		sequencerMagasin.open();
		sequencerMagasin.setSequence(MidiSystem.getSequence(musmag));


		sequencerRamassage = MidiSystem.getSequencer();
		sequencerRamassage.setLoopStartPoint(0);
		sequencerRamassage.setLoopEndPoint(-1);
		sequencerRamassage.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		sequencerRamassage.open();
		sequencerRamassage.setSequence(MidiSystem.getSequence(musrama));

	}

	public void lancerMusiqueFond() {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (carte.getDansMagasin() == false) {
			if (cpt == 1) {
				cpt = 0;
				this.sequencerMagasin.stop();
				this.sequencerCarte.start();
				this.sequencerMagasin.setTickPosition(0);
			}
		}

		if (carte.getDansMagasin() == true) {
			if (cpt == 0) {
				cpt = 1;
				this.sequencerCarte.stop();
				this.sequencerMagasin.start();
				this.sequencerCarte.setTickPosition(0);
			}
		}

	}

	public void reglerSequencer(Sequencer sequencer, File file)
			throws InvalidMidiDataException, IOException,
			MidiUnavailableException {

		sequencer = MidiSystem.getSequencer();


		sequencer.open();
		sequencer.setSequence(MidiSystem.getSequence(file));

	}
}

