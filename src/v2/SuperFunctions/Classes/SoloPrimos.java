package v2.SuperFunctions.Classes;

import v2.SuperFunctions.Interfaces.Predicado;

//En el paquete se agrupas las clases que implementan el método abstracto de cada interfaz del paquete de Interfaces
public class SoloPrimos implements Predicado {

	@Override
	public boolean test(Integer valor) {
		
		return valor % 2 != 0;
	}

	
}
