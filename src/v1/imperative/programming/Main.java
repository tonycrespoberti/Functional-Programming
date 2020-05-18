package v1.imperative.programming;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//Java JDK 9
		//Iniciamos con una serie de operaciones que comunmente realizamos lo cual será nuestro punto de partida para ir
		//incorporando métodos, interfaces genéricas, expresiones lambdas y progrmación funcional

		//1. Crear lista de enteros
		List<Integer> numeros = crearLista();
		System.out.println("1. Lista de Números: " + numeros);
		System.out.println("");

		//2. Quedarse solo con los Pares de la lista creada anterior
		List<Integer> pares = filtrarPares(numeros);
		System.out.println("2. Filtro: " + pares);
		System.out.println("");
		
		//3. De los pares anterior, elevar al cuadrado cada elemento
		List<Integer> cuadrados = elevarAlCuadrado(pares);
		System.out.println("3. Elevado a la potencia: " + cuadrados);
		System.out.println("");
		
		//4. Mostrar el resultado de la operación anterior por consola
		List<Integer> mostrar = mostrarList(cuadrados);
		System.out.println("4. Mostrar elementos del paso 3.: " + mostrar);
		System.out.println("");
		
		//5. Obtener la suma del resultado de elevar los numeros a la potencia que se haya aplicado (al cuadrado, al cubo, etc)
		int total = sumarLista(cuadrados);
		System.out.printf("5. Resulrado final de las operaciones %n"+ total);
		
		// %s imprime caracteres, %

	}


	//Definición de los métodos estáticos que proveerán la funcionalidad solicitada

	//1. Crear lista de enteros
	private static List<Integer> crearLista() {

		return List.of(1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144); //la secuencia de Fibonacci
	}
	

	//2. Quedarse solo con los Pares de la lista creada anterior
	private static List<Integer> filtrarPares(List<Integer> numeros) {

		List<Integer> resultado = new ArrayList<>();

		for (Integer numero : numeros) {

			if (numero % 2 == 0) {

				resultado.add(numero);
			}
		}
		return resultado;
	}


	//3. De los pares anterior, elevar al cuadrado cada elemento
	private static List<Integer> elevarAlCuadrado(List<Integer> numeros) {

		List<Integer> resultado = new ArrayList<Integer>();

		for (Integer numero : numeros) {

			resultado.add(numero * numero);
		}

		return resultado;
	}


	//4. Mostrar el resultado de la operación anterior por consola
	private static List<Integer> mostrarList(List<Integer> numeros) {

		for (Integer numero : numeros) {

			System.out.println(numero);
		}

		System.out.println("");
		return numeros;
	}


	//5. Obtener la suma del resultado de elevar los numeros a la potencia que se haya aplicado (al cuadrado, al cubo, etc)
	private static int sumarLista(List<Integer> numeros) {

		int total = 0;

		for (Integer numero : numeros) {

			total+= numero;
		}

		return total;
	}
}
