package controller;
import model.ListaDupla;

public class Metodos {
	public Metodos() {
		super();
	}
	public void teste() {
		ListaDupla lista = new ListaDupla();
		lista.append(1);
		lista.append(2);
		lista.append(4);
		
		System.out.println(lista.toString());
		
		lista.insert(3,2);
		lista.insert(0,0);
		
		System.out.println(lista.toString());

		lista.remove(0);
		
		System.out.println(lista.toString());
		
		lista.remove(0);
		
		System.out.println(lista.toString());
		
		lista.prepend(0);
		System.out.println(lista.toString());


	}
}
