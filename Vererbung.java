package Vererbung;

import ssj.Out;

//import ssj.*;

public class Vererbung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person a = new Person();
		Person b = new Person("mann");
		
		a.printPerson();
		b.printPerson();
		Out.println();
		
		Person Gen2_1 = Person.Fortpflanzen(a, b);
		Person Gen2_2 = Person.Fortpflanzen(a, b);
		Person a2 = new Person();
		Person b2 = new Person();
		
		for (int i = 0; i < 10; i++) {
			
			Gen2_1.printPerson();
			Gen2_2.printPerson();
			a2=Gen2_1;
			b2=Gen2_2;
			Gen2_1 = Person.Fortpflanzen(a2, b2);
			Gen2_2 = Person.Fortpflanzen(a2, b2);
			
			while (Gen2_1 == null) {
				Gen2_1 = Person.Fortpflanzen(a, b);
				Gen2_1.printPerson();
			}
			
			while (Gen2_2 == null) {
				Gen2_2 = Person.Fortpflanzen(a, b);
				Gen2_2.printPerson();
			}
			Out.println();
			

		}	//for-Schleife Ende
		
	}

}
