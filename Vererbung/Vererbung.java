package Vererbung;

import ssj.*;

public class Vererbung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person a = new Person();			//frau
		Person b = new Person("mann");		//mann
		
		Out.println(a);
		Out.println(b);
		Out.println();
		
		Person Gen2_1 = Person.Fortpflanzen(a, b);
		Person Gen2_2 = Person.Fortpflanzen(a, b);
		
		Out.println();
		
		Person a2 = a;
		Person b2 = b;
		
		for (int i = 1; i < 10; i++) {
			
			Gen2_1.printPerson();
			Gen2_2.printPerson();
			
			while (Gen2_1.Geschlecht == Gen2_2.Geschlecht) {
				
				if (Math.random() >= 0.5) {
					Gen2_1 = Person.Fortpflanzen(a2, b2);
					Gen2_1.printPerson();
				} else {
					Gen2_2 = Person.Fortpflanzen(a2, b2);
					Gen2_2.printPerson();
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
