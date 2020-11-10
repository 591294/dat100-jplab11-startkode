package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		Innlegg[] innlegg = samling.getSamling();
		try {
			FileWriter fileWrite = new FileWriter(mappe + filnavn);
			PrintWriter printWrite = new PrintWriter(fileWrite);
			printWrite.println(samling.getAntall());
			String type = "";
			
			if (innlegg[0] instanceof Tekst) {
				type = "TEKST";
				Tekst tekst = (Tekst) innlegg[0];
				printWrite.println(type);
				printWrite.println(innlegg[0].getId());
				printWrite.println(innlegg[0].getBruker());
				printWrite.println(innlegg[0].getDato());
				printWrite.println(innlegg[0].getLikes());
				printWrite.println(tekst.getTekst());			
			}
			
			if (innlegg[1] instanceof Bilde){
				type = "BILDE";
				Bilde bilde = (Bilde) innlegg[1];
				printWrite.println(type);
				printWrite.println(innlegg[1].getId());
				printWrite.println(innlegg[1].getBruker());
				printWrite.println(innlegg[1].getDato());
				printWrite.println(innlegg[1].getLikes());
				printWrite.println(bilde.getTekst());				
				printWrite.println(bilde.getUrl());
			}						
		

			printWrite.close();

			
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
