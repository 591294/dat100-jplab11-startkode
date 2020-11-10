package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggTabell;
	private int nesteLedig;

	public Blogg() {
		this.innleggTabell = new Innlegg[20];
		
	}

	public Blogg(int lengde) {
		this.innleggTabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return innleggTabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {

		boolean funnet = false;
		int i = 0;
		
		while (i < nesteLedig && !funnet) {
			if (innleggTabell[i].erLik(innlegg)) {
				funnet = true;
			} else {
				i++;
			}
		}
		if (funnet) {
			return i;
		} else {
			return -1;
		}
	}

	public boolean finnes(Innlegg innlegg) {
		boolean finnes = true;
		
		if(finnInnlegg(innlegg) == -1) {
			finnes = false;
		}
		return finnes;
	}

	public boolean ledigPlass() {
		boolean ledig = false;
		
		if (innleggTabell.length > nesteLedig) {
			ledig = true;
		}
		
		return ledig;

	}
	
	public boolean leggTil(Innlegg innlegg) {

		boolean lagtTil =! finnes(innlegg) && ledigPlass();
		
		if (lagtTil) {
			innleggTabell[nesteLedig] = innlegg;
			lagtTil = true;
			nesteLedig++;
		}
		return lagtTil;
	}
	
	public String toString() {
		String b = getAntall() + "\n";
		
		for (int i = 0; i < innleggTabell.length; i++) {
			b += innleggTabell[i].toString();
		}
		return b;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}