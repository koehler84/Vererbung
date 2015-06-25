package Vererbung;

class Person {
	
	String  Farbstring;
	int Generation;
	boolean Geschlecht;				//true = m�nnlich ; false = weiblich
	int Gr��e;						//in cm
	byte Augenfarbe;
	byte[] AugenGene;				//Gene der Augenfarbe ; 0=grau ; 1=blau ; 2=braun ; 3=gr�n
	int Haarfarbe;					//Farben im RGB Spektrum(rrggbb als Hexzahl)
	
	static String[] AugenfarbeKodierung = {"grau",/*1*/"","blau-gr�n","grau-blau","braun",/*5*/"grau-blau","grau-braun","gr�n-braun","blau","gr�n-braun",/*10*/"grau-braun","blau-braun","gr�n","blau-braun","",/*15*/"grau-gr�n"};
	static int AnzahlPersonen;
	
	Person () {
		this.Geschlecht = false;
		this.Gr��e = 165;
		
		this.AugenGene = AugenGenRandom();
		this.Augenfarbe = AugenFarbeRechnerByte(AugenGene);				//�bergabe der Gene zur Berechnung des Strings
		
		this.Haarfarbe = 16445630;	//16445630 entspricht Blond ... so ziemlich
		this.Generation = 1;
		AnzahlPersonen++;
	}	//Default Constructor ends
	
	Person (String geschlecht) {
		
		AnzahlPersonen++;
		
		if (geschlecht.equals("mann".toLowerCase())) {
			this.Geschlecht = true;
			this.Gr��e = 180;
			this.AugenGene = AugenGenRandom();
			this.Augenfarbe = AugenFarbeRechnerByte(AugenGene);
			this.Haarfarbe = 16445630;
			this.Generation = 1;
		} else if (geschlecht.equals("frau".toLowerCase())) {
			this.Geschlecht = false;
			this.Gr��e = 165;
			this.AugenGene = AugenGenRandom();
			this.Augenfarbe = AugenFarbeRechnerByte(AugenGene);
			this.Haarfarbe = 16445630;
			this.Generation = 1;
		} else {
			
		}
		
	}	
	
	Person (String geschlecht, int Gr��e, int Haarfarbe) {
		
		AnzahlPersonen++;
		
		if (geschlecht.equals("mann".toLowerCase())) {
			this.Geschlecht = true;
			this.Gr��e = Gr��e;
			this.AugenGene = AugenGenRandom();
			this.Augenfarbe = AugenFarbeRechnerByte(AugenGene);
			this.Haarfarbe = Haarfarbe;
			this.Generation = 1;
		} else if (geschlecht.equals("frau".toLowerCase())) {
			this.Geschlecht = false;
			this.Gr��e = Gr��e;
			this.AugenGene = AugenGenRandom();
			this.Augenfarbe = AugenFarbeRechnerByte(AugenGene);
			this.Haarfarbe = Haarfarbe;
			this.Generation = 1;
		} else {
			
		}
		
	}	
	
Person (String geschlecht, int Gr��e, String Farbstring) {
		
		AnzahlPersonen++;
		this.Haarfarbe = Integer.parseInt(Farbstring.toUpperCase(), 16);	//haarfarbe als rrggbb hexzahl umwandeln in int
																			//TODO Unterscheidung hexzahl und vorgegebene Standardwerte (blond schwarz, rot, grau, etc)  
		
		
		if (geschlecht.equals("mann".toLowerCase())) {
			this.Geschlecht = true;
			this.AugenGene = AugenGenRandom();
			this.Augenfarbe = AugenFarbeRechnerByte(AugenGene);
			this.Generation = 1;
		} else if (geschlecht.equals("frau".toLowerCase())) {
			this.Geschlecht = false;
			this.AugenGene = AugenGenRandom();
			this.Augenfarbe = AugenFarbeRechnerByte(AugenGene);

			this.Generation = 1;
		} else {
			
		}
		
	}
	
	
	//Constructor ends
	
	
	static String AugenFarbeRechner (byte[] Gene) {
		
		int AugenfarbeZahl = Gene[0]*2 + Gene[1]*3;
		String Farbe = new String();
		
		switch (AugenfarbeZahl) {
		case 0:				Farbe = "grau"; break;
		case 2:				Farbe = "blau-gr�n"; break;
		case 3: case 5:		Farbe = "grau-blau"; break;
		case 4:				Farbe = "braun"; break;
		case 6: case 10:	Farbe = "grau-braun"; break;
		case 8:				Farbe = "blau"; break;
		case 9: case 7:		Farbe = "gr�n-braun"; break;
		case 11: case 13:	Farbe = "blau-braun"; break;
		case 12:			Farbe = "gr�n"; break;
		case 15:			Farbe = "grau-gr�n"; break;		
		}
		
		return Farbe;
	}
	
	static byte AugenFarbeRechnerByte (byte[] Gene) {
		return (byte)(Gene[0]*2 + Gene[1]*3);
	}
	
	static byte[] AugenGenRandom () {
		
		byte[] AugenGen = new byte[2];
		byte random = (byte)(Math.random()*10);
		
		for (int i = 0; i < AugenGen.length; i++) {
			
			if (random >= 0 && random <= 3) {
				AugenGen[i] = random;
			}
			random = (byte)(Math.random()*10);
		}
		
		return AugenGen;
	}
	
	static Person Fortpflanzen (Person a, Person b) {
		
		Person erg = new Person();
		
		if (a.Geschlecht == false) {			//a soll immer der Mann, b immer die Frau sein
			Person h;
			h = a;
			a = b;
			b = h;
		}
		
		if (a.Geschlecht != b.Geschlecht) {			//Mutter und Vater
			
			//Was passiert wenn a und b unterschiedliche Generationen sind? Gr��ere Generation++
			if (a.Generation > b.Generation) {
				erg.Generation = a.Generation+1;
			} else {
				erg.Generation = b.Generation+1;
			}
			
			double random = Math.random();
			
			//Geschlecht ; hier kann Augenfarbe nicht eingebaut werden, da "random" sp�ter aktualisiert wird
			if (random >= 0.5) {
				erg.Geschlecht = true;
			} else {
				erg.Geschlecht = false;
			}
			
			//Gr��e	TODO Wachstum mit jeder Generation addieren
			if (a.Gr��e > b.Gr��e) {
				erg.Gr��e = b.Gr��e+(int)(Math.abs(a.Gr��e-b.Gr��e)*random);
			} else {
				erg.Gr��e = a.Gr��e+(int)(Math.abs(a.Gr��e-b.Gr��e)*random);
			}
						
			//Augenfarbe ; Gen[0] von A und Gen[1] von B werden vererbt 
			random = Math.random();				//neue Zufallszahl um Unabh�ngigkeit zu anderen Merkmalen zu erreichen
			erg.AugenGene = new byte[2];
			if (random >= 0.35) {
				erg.AugenGene[0] = a.AugenGene[0];
				erg.AugenGene[1] = b.AugenGene[1];
			} else {
				erg.AugenGene[0] = a.AugenGene[1];
				erg.AugenGene[1] = b.AugenGene[0];
			}
			
			
			
			
			return erg;
			
		} else {									//Gleiches Geschlecht der Eltern => fail
			return null;
		}
				
	}		//static Fortpflanzen ends
	
	
	
	
	//allgemeine Funktionen
	public String toString() {
		String TAB = "\u0009";
		if (AugenfarbeKodierung[this.Augenfarbe].length() <= 5) TAB = "\u0009\u0009";
		
		if (this.Geschlecht) {		//mann
			return "Mann, " + this.Gr��e + "cm, Augenfarbe: " + AugenfarbeKodierung[this.Augenfarbe] + "," + TAB + this.Haarfarbe + " HAARFARBE, Generation: " + this.Generation;
		} else {		//frau
			return "Frau, " + this.Gr��e + "cm, Augenfarbe: " + AugenfarbeKodierung[this.Augenfarbe] + "," + TAB + this.Haarfarbe + " HAARFARBE, Generation: " + this.Generation;
		}
	}
	/*
	void printPerson() {
			
		String TAB = "\u0009";
		if (AugenfarbeKodierung[this.Augenfarbe].length() <= 5) TAB = "\u0009\u0009";
		
		if (this.Geschlecht) {		//mann
			Out.println("Mann, " + this.Gr��e + "cm, Augenfarbe: " + AugenfarbeKodierung[this.Augenfarbe] + "," + TAB + "PLATZHALTER HAARFARBE, Generation: " + this.Generation);
		} else {		//frau
			Out.println("Frau, " + this.Gr��e + "cm, Augenfarbe: " + AugenfarbeKodierung[this.Augenfarbe] + "," + TAB + "PLATZHALTER HAARFARBE, Generation: " + this.Generation);
		}
		
	}	//printPerson ends
	*/
}	//class Person ends
