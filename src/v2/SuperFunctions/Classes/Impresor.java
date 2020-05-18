package v2.SuperFunctions.Classes;

import v2.SuperFunctions.Interfaces.Consumir;

public class Impresor implements Consumir{

	@Override
	public void aceptar(Integer valor) {

		System.out.println(valor);
		
	}

}
