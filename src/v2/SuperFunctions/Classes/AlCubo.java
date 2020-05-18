package v2.SuperFunctions.Classes;

import v2.SuperFunctions.Interfaces.Funcion;

//En el paquete se agrupas las clases que implementan el método abstracto de cada interfaz del paquete de Interfaces
public class AlCubo implements Funcion{

	@Override
	public Integer aplicar(Integer valor) {

		return valor * valor* valor;
	}

}
