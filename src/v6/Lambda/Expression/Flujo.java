package v6.Lambda.Expression;

import java.util.ArrayList;
import java.util.List;

import v6.Lambda.Expression.Interfaces.*;





//Lo que en la v3.Inline.Abonymous.Classes era una Superclase llamda Superfuncion, aquí la vamos de denominar Flujo para 
//simular el flujo (stream) de datos entre funciones.
public class Flujo <T> {
	
	private final List<T> valores;
	
	public Flujo (List<T> valores) {
		
		this.valores = valores;
	}
	
	@Override
	public String toString() {
		return "Flujo [valores=" + valores + "]";
	}


	//1. Clase Proveedora. Las funciones lambdas tiene un proveedor, una entrada, hacen una operacion y generan una salida.
	public static <T> Flujo<T> proveer(int size, Proveedor<T> proveedor){
		
		List<T> resultado = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			
			resultado.add(proveedor.obtener());
		}
		
		return new Flujo<>(resultado);
		
	}
	
	//La numeración de las clases viene de las funciones que se invocan en el Main
	//2. Clase filtrar, operación muy común en la Interfaz Collector usada mucho por las Interfaces Funcionales
	public Flujo<T> filtrar(Predicado<T> predicado){
		
		List<T> resultado = new ArrayList<>();
		
		for (T valor : valores) {
			
			if (predicado.test(valor)) {
				
				resultado.add(valor);
			}
		}
		
		return new Flujo<>(resultado);
	}
	
	//La numeración de las clases viene de las funciones que se invocan en el Main
	//3. Clase transformar, sería la operacion que realizaría una lambda para devolver un elemento nuevo.
	public <R> Flujo<R> transformar(Funcion<T, R> funcion){
		
		List<R> resultado = new ArrayList<>();
		
		for (T valor : valores) {
			
			resultado.add(funcion.aplicar(valor));
		}
		
		return new Flujo<>(resultado);
	}
	
	//La numeración de las clases viene de las funciones que se invocan en el Main
	//4. Clase mostrar que actúa y consume el resultado que recibe para hacer algo con ello, en este caso mostrar por consola
	public Flujo<T> actuar(Consumir<T> consumir){
		
		for (T valor : valores) {
			
			consumir.aceptar(valor);
		}
		
		return new Flujo<>(valores);
	}
	
	//La numeración de las clases viene de las funciones que se invocan en el Main
	//5. Clase reduce el valor final recibido por las multiples clases que le preceden
	public T reducir(T identidad, OperadorBinario<T>  funcionBinaria) {
		
		T total = identidad;
		
		for (T valor : valores) {
			
			total = funcionBinaria.aplicar(total, valor);
		}
		System.out.println("Reducir: " + total);
		return total;
	}
	
}
