package v4.Generic.Interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import v4.Generic.Interface.Interfaces.*;


public class Main {

	public static void main(String[] args) {
		
		//Java JDK 9
		//La Superclase funciones fue adaptada por una que denominamos Flujo para simular un stream adaptando los métodos al tipo genérico.
		//Dado que no podemos hacer proveer(filtrar(transformar(actuar()))) por no solo engorroso, mala práctica y difícil de gestionar,
		//la idea es construir algo como proveer().filtrar().transformar().actuar(); tal cual el Stream de java manejar el flujo de elementos
		
		//Como se verá, cada método representa la entrada del siguiente (su Stream o flujo de elementos de datos)

		//1. Crear lista de enteros
		Flujo<Integer> valores = Flujo.proveer(10, new Proveedor<>() {
			
			Random random = new Random();
			@Override
			public Integer obtener() {

				return random.nextInt(10);
			}
		});
		
		System.out.println("1. Lista de Números: " + valores);
		System.out.println("");

		//Creamos una super clase donde pasamos todos los métodos imperativos de la v1.
		//Cada clase dentro de la super clase tendrá su interfaz abstracta (un solo método abstacto) para que cumpla la condición de ser
		//Interfaz Funcional @FunctionalInterface
		
		//2. Se elimina la clase SoloPares o SoloPrimos y se crea directamente una instancia de la interfaz Predicado y se implmenta su
		//método abstracto como función anómina
		Flujo<Integer> filtrados = valores.filtrar(new Predicado<>() {

			@Override
			public boolean test(Integer valor) {

				return valor % 2 == 0;
			}
			
		});
		
		System.out.println("2. Filtro: " + filtrados);
		System.out.println("");
		
		//3. De los pares anterior, elevar al cuadrado cada elemento
		//Se elimina como parámetro la clase AlCuadrado o AlCubo y se instancia directamente la Interfaz Funcion que implementa el método
		//abstracto aplicar, que en este caso usaremos elevar al cuadrado para el ejemplo
		Flujo<Integer> elevadosPotencia = filtrados.transformar(new Funcion<>() {

			@Override
			public Integer aplicar(Integer valor) {
				
				return valor * valor;
			}
			
		});
		System.out.println("3. Elevado a la potencia: " + elevadosPotencia);
		System.out.println("");
		
		//4. Mostrar el resultado de la operación anterior por consola
		Flujo<Integer> mostrar = elevadosPotencia.actuar(new Consumir<>() {
			
			@Override
			public void aceptar(Integer valor) {
				
				System.out.println(valor);
				
			}
		});
		System.out.println("4. Mostrar elementos del paso 3.: " + mostrar);
		System.out.println("");
		
		//5. Obtener la suma del resultado de elevar los numeros a la potencia que se haya aplicado (al cuadrado, al cubo, etc)
		Integer total = mostrar.reducir(0, new OperadorBinario<>() {
			
			@Override
			public Integer aplicar(Integer valor1, Integer valor2) {

				return (valor1 + valor2);
			}
		});
		System.out.printf("5. Resulrado final de las operaciones %n"+ total);
		// %s imprime caracteres, %

	}
}
