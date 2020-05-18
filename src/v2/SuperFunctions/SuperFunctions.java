package v2.SuperFunctions;

import java.util.ArrayList;
import java.util.List;

import v2.SuperFunctions.Interfaces.Consumir;
import v2.SuperFunctions.Interfaces.Funcion;
import v2.SuperFunctions.Interfaces.FuncionBinaria;
import v2.SuperFunctions.Interfaces.Predicado;
import v2.SuperFunctions.Interfaces.Proveedor;

//Esta super clase permite traer todos los m�todos estaticos definidos en la v1. del ejemplo. Pasamos los m�todos est�ticos
//a clases.
public class SuperFunctions {

	//1. Clase Proveedora. Las funciones lambdas tiene un proveedor, una entrada, hacen una operacion y generan una salida.
	public static List<Integer> proveer(Integer size, Proveedor proveedor){
		
		List<Integer> resultado = new ArrayList<Integer>();
		
		for (int i = 0; i < size; i++) {
			
			resultado.add(proveedor.obtener());
		}
		
		return resultado;
		
	}
	
	//La numeraci�n de las clases viene de las funciones que se invocan en el Main
	//2. Clase filtrar, operaci�n muy com�n en la Interfaz Collector usada mucho por las Interfaces Funcionales
	public static List<Integer> filtrar(List<Integer> valores, Predicado predicado){
		
		List<Integer> resultado = new ArrayList<Integer>();
		
		for (Integer valor : valores) {
			
			if (predicado.test(valor)) {
				
				resultado.add(valor);
			}
		}
		
		return resultado;
	}
	
	//La numeraci�n de las clases viene de las funciones que se invocan en el Main
	//3. Clase transformar, ser�a la operacion que realizar�a una lambda para devolver un elemento nuevo.
	public static List<Integer> transformar(List<Integer> valores, Funcion funcion){
		
		List<Integer> resultado = new ArrayList<Integer>();
		
		for (Integer valor : valores) {
			
			resultado.add(funcion.aplicar(valor));
		}
		
		return resultado;
	}
	
	//La numeraci�n de las clases viene de las funciones que se invocan en el Main
	//4. Clase mostrar que act�a y consume el resultado que recibe para hacer algo con ello, en este caso mostrar por consola
	public static List<Integer> actuar(List<Integer> valores, Consumir consumir){
		
		for (Integer valor : valores) {
			consumir.aceptar(valor);
		}
		
		return valores;
	}
	
	//La numeraci�n de las clases viene de las funciones que se invocan en el Main
	//5. Clase reduce el valor final recibido por las multiples clases que le preceden
	public static Integer reducir(List<Integer> valores, Integer identidad, FuncionBinaria  funcionBinaria) {
		
		int total = identidad;
		
		for (Integer valor : valores) {
			
			total = funcionBinaria.aplicar(total, valor);
		}
		
		return total;
	}
	
}
