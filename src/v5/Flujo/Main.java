package v5.Flujo;


import java.util.Random;

import v5.Flujo.Interfaces.*;


public class Main {

	public static void main(String[] args) {
		
		Integer total = 
				Flujo.proveer(10, new Proveedor<Integer>() {
			
					Random random = new Random();
					@Override
					public Integer obtener() {
		
						return random.nextInt(10);
					}
				}).filtrar(new Predicado<Integer>() {
		
					@Override
					public boolean test(Integer valor) {
		
						return valor % 2 == 0;
					}
					
				}).transformar(new Funcion<Integer, Integer>() {
		
					@Override
					public Integer aplicar(Integer valor) {
						
						return valor * valor;
					}
					
				}).actuar(new Consumir<Integer>() {
					
					@Override
					public void aceptar(Integer valor) {
						
						System.out.println(valor);
						
					}
				}).reducir(0, new OperadorBinario<Integer>() {
	
					@Override
					public Integer aplicar(Integer valor1, Integer valor2) {
						
						return valor1 + valor2;
					}
				});

	}
}
