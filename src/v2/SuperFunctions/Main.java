package v2.SuperFunctions;

import java.util.ArrayList;
import java.util.List;

import v2.SuperFunctions.Classes.AlCuadrado;
import v2.SuperFunctions.Classes.AlCubo;
import v2.SuperFunctions.Classes.Impresor;
import v2.SuperFunctions.Classes.ProveeNumeroAleatorio;
import v2.SuperFunctions.Classes.SoloPares;
import v2.SuperFunctions.Classes.SoloPrimos;
import v2.SuperFunctions.Classes.Sumador;

public class Main {

	public static void main(String[] args) {
		
		//Java JDK 9
		//La idea ahora es sustituir los métodos estáticos de la v1.imperative.programming por interfaces y sus clases que las implementen

		//1. Crear lista de enteros
		List<Integer> valores = SuperFunctions.proveer(10, new ProveeNumeroAleatorio());
		System.out.println("1. Lista de Números: " + valores);
		System.out.println("");

		//Creamos una super clase donde pasamos todos los métodos imperativos de la v1.
		//Cada clase dentro de la super clase tendrá su interfaz abstracta (un solo método abstacto) para que cumpla la condición de ser
		//Interfaz Funcional @FunctionalInterface
		
		//2. Quedarse solo con los Pares de la lista creada anterior
		//List<Integer> pares = filtrarPares(numeros); Version imperativa
		List<Integer> filtrados = SuperFunctions.filtrar(valores, new SoloPares()); //<--clase que implmentando el método abstracto de la interfaz Predicado
		System.out.println("2. Filtro: " + filtrados);
		System.out.println("");
		
		//3. De los pares anterior, elevar al cuadrado cada elemento
		List<Integer> elevadosPotencia = SuperFunctions.transformar(filtrados, new AlCuadrado());
		System.out.println("3. Elevado a la potencia: " + elevadosPotencia);
		System.out.println("");
		
		//4. Mostrar el resultado de la operación anterior por consola
		List<Integer> mostrar = SuperFunctions.actuar(elevadosPotencia, new Impresor());
		System.out.println("4. Mostrar elementos del paso 3.: " + mostrar);
		System.out.println("");
		
		//5. Obtener la suma del resultado de elevar los numeros a la potencia que se haya aplicado (al cuadrado, al cubo, etc)
		int total = SuperFunctions.reducir(elevadosPotencia, 0, new Sumador());
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
