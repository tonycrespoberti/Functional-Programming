package v6.Lambda.Expression;


import java.util.List;
import java.util.Random;

import v6.Lambda.Expression.Interfaces.*;




public class Main {

	public static void main(String[] args) {
		
		//Java JDK 9
		//La Superclase funciones fue adaptada por una que denominamos Flujo para simular un stream adaptando los métodos al tipo genérico.
		//Dado que no podemos hacer proveer(filtrar(transformar(actuar()))) por no solo engorroso, mala práctica y difícil de gestionar,
		//la idea es construir algo como proveer().filtrar().transformar().actuar(); tal cual el Stream de java manejar el flujo de elementos
		
		//Como se verá, cada método representa la entrada del siguiente (su Stream o flujo de elementos de datos)

		Integer total = new Flujo<Integer>(List.of(1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144))
				
				.filtrar(valor -> valor % 2 == 0)
				
				.transformar(valor -> valor * valor)
					
				.actuar(valor -> System.out.println(valor))
						
				.reducir(0, (valor1, valor2) -> valor1 + valor2);
	}
}
