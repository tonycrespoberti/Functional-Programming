package v2.SuperFunctions.Classes;

import v2.SuperFunctions.Interfaces.FuncionBinaria;

public class Sumador implements FuncionBinaria{

	@Override
	public Integer aplicar(Integer valor1, Integer valor2) {
		
		return (valor1 + valor2);
	}

}
