package v6.Lambda.Expression.Interfaces;

//Para suministrar una lista de elementos. Devuelve un elemento y no recibe ningún parámetro
public interface Proveedor <T>{

	T obtener();
}
