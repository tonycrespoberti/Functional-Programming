package v2.SuperFunctions.Classes;

import java.util.Random;

import v2.SuperFunctions.Interfaces.Proveedor;

//En el paquete se agrupas las clases que implementan el método abstracto de cada interfaz del paquete de Interfaces
public class ProveeNumeroAleatorio implements Proveedor {

	Random ramdon = new Random();
	
	@Override
	public Integer obtener() {
		return ramdon.nextInt(10);
	}

}
