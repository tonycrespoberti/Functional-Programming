package v5.Flujo.Interfaces;

//El predicado de una interfaz funcional siempre devolver� un valor boolean
public interface Predicado <T> {
	
	boolean test(T valor);

}
