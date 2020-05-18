package v3.Inline.Anonymous.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import v3.SuperFunctions.Interfaces.*;

public class Main {

	public static void main(String[] args) {
		
		//Java JDK 9
		//En esta version 3 la idea es eliminar la Superclase de funciones y sustituirlas por clases inLine dentro del Main.
		//Para ell en los parámetro de la Superfuncion en vez de usar la instancia de la clase que implementa la interfaz,
		//le pasamos directamente el nombre de la Interfaz y sobreescribimos allí directamente el método abstracto.
		//Así nos libramos el tener que crear clases que implementen la interfaz. Nos apoyamos en funciones anónimas.

		//1. Crear lista de enteros
		List<Integer> valores = SuperFunctions.proveer(10, new Proveedor() {
			
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
		List<Integer> filtrados = SuperFunctions.filtrar(valores, new Predicado() {

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
		List<Integer> elevadosPotencia = SuperFunctions.transformar(filtrados, new Funcion() {

			@Override
			public Integer aplicar(Integer valor) {
				
				return valor * valor;
			}
			
		});
		System.out.println("3. Elevado a la potencia: " + elevadosPotencia);
		System.out.println("");
		
		//4. Mostrar el resultado de la operación anterior por consola
		List<Integer> mostrar = SuperFunctions.actuar(elevadosPotencia, new Consumir() {
			
			@Override
			public void aceptar(Integer valor) {
				
				System.out.println(valor);
				
			}
		});
		System.out.println("4. Mostrar elementos del paso 3.: " + mostrar);
		System.out.println("");
		
		//5. Obtener la suma del resultado de elevar los numeros a la potencia que se haya aplicado (al cuadrado, al cubo, etc)
		int total = SuperFunctions.reducir(elevadosPotencia, 0, new FuncionBinaria() {
			
			@Override
			public Integer aplicar(Integer valor1, Integer valor2) {

				return (valor1 + valor2);
			}
		});
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
