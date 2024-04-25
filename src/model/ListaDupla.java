package model;

import java.lang.Exception;
import model.No;

public class ListaDupla<T> {
	private No<T> inicio = null;
	private No<T> fim = null;
	
	//append
	//get
	//index
	//insert
	//last
	//prepend
	//remove
	//total
	
	public void append (T elemento) {
		No<T> novo = new No<>(elemento);
		if (this.fim == null) {
			this.fim = novo;
			this.inicio = novo;
			return;
		} 
		this.last().setProximo(novo);
	}
	public No<T> last() throws IllegalArgumentException {
		if (this.inicio == null) {
			throw new IllegalArgumentException("Lista vazia.");
		}
		No<T> buffer = this.inicio;
		while ( buffer.getProximo() != null ) {
			buffer = buffer.getProximo();
		}
		return buffer;		
	}
	public No<T> get(int index) throws IllegalArgumentException {
		int i = 0;
		if (this.inicio == null) {
			throw new IllegalArgumentException("Lista vazia.");
		}
		No<T> buffer = this.inicio;
		while (i < index) {
			i++;
			buffer = buffer.getProximo();
		}
		if (buffer == null) {
			throw new IllegalArgumentException("Indice informado nao existe.");
		}
		return buffer;
	}
	public int index(T valor) throws IllegalArgumentException {
		if (this.inicio == null) {
			throw new IllegalArgumentException("Lista vazia.");
		}
		No<T> buffer = this.inicio;
		int index = 0;
		while (buffer.getProximo() != null) {
			if (buffer.getValor() == valor) {
				return index;
			} else {
				buffer = buffer.getProximo();
				index++;
			}
		}
		throw new IllegalArgumentException("Item nao encontrado na lista.");
	}
	public void insert(T valor, int index) {
		No<T> novo = new No<>(valor);
		No<T> buffer_proximo = get(index);
		No<T> buffer_anterior = get(--index);
		buffer_anterior.setProximo(novo);
		buffer_proximo.setAnterior(novo);
		novo.setProximo(buffer_proximo);
		novo.setAnterior(buffer_anterior); //deve estar errado
		
	}
}







