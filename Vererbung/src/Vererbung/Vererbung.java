package Vererbung;

import ssj.*;

public class Vererbung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person a = new Person();			//frau
		Person b = new Person("mann");		//mann
		String Haarfarbe="ff";				//TODO warum muss ich das erst in ne veriable schreiben, damit er erkennt, dass das nen string ist
		Person c = new Person("Mann",140,Haarfarbe);
		Out.println(a);
		Out.println(b);
		Out.println(c+ "Test");
		
		Person Gen2_1 = Person.Fortpflanzen(a, b);
		Person Gen2_2 = Person.Fortpflanzen(a, b);
		
		Person a2 = a;
		Person b2 = b;
		
		for (int i = 1; i < 10; i++) {
			
			Out.println(Gen2_1);
			Out.println(Gen2_2);
			Out.println();
			while (Gen2_1.Geschlecht == Gen2_2.Geschlecht) {
				
				if (Math.random() >= 0.5) {
					Gen2_1 = Person.Fortpflanzen(a2, b2);
					Out.println(Gen2_1);
				} else {
					Gen2_2 = Person.Fortpflanzen(a2, b2);
					Out.println(Gen2_2);
				}
				
			}
			a2=Gen2_1;
			b2=Gen2_2;
			Gen2_1 = Person.Fortpflanzen(a2, b2);
			Gen2_2 = Person.Fortpflanzen(a2, b2);
			
			Out.println();
			

		}	//for-Schleife Ende
		
		Out.println(Person.AnzahlPersonen);
		
	}

}
