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
		novo.setAnterior(this.last());
		this.fim = novo;
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

		if ( index == 0 ) {
			this.prepend(valor);
		} else {
			No<T> buffer_proximo = get(index);
			No<T> buffer_anterior = get(--index);
			buffer_anterior.setProximo(novo);
			buffer_proximo.setAnterior(novo);
			novo.setProximo(buffer_proximo);
			novo.setAnterior(buffer_anterior); 
		}		
	}
	public void prepend (T valor) {
		No<T> novo = new No<>(valor);
		if (this.inicio == null) {
			this.inicio = novo;
			this.fim = novo;
		} else {
			No<T> buffer_inicio = this.inicio;
			this.inicio = novo;
			novo.setProximo(buffer_inicio);
			buffer_inicio.setAnterior(novo);
		}
	}
	public void remove (int index) throws IllegalArgumentException {
		if ( get(index) == null ) {
			throw new IllegalArgumentException("Indice inexistente.");
		}
		if (index == 0) {
			this.inicio = this.inicio.getProximo();
			this.inicio.setAnterior(null);
		} else {
			No<T> remover = get(index);
			No<T> anterior = remover.getAnterior();
			No<T> proximo = remover.getProximo();
			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);
			remover.setAnterior(null);
			remover.setProximo(null);
			remover.setValor(null);
		}
	}
	public int total() {
		if (this.inicio == null) {
			return 0;
		}
		No<T> buffer = this.inicio;
		int total = 1;
		
		while ( buffer.getProximo() != null ) {
			total++;
			buffer = buffer.getProximo();
		}
		return total;
	}
	@Override
	public String toString() {
		if (this.inicio == null) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No<T> buffer = this.inicio;
		builder.append( buffer.getValor() );
		while ( buffer.getProximo() != null ) {
			builder.append(",");
			buffer = buffer.getProximo();
			builder.append(buffer.getValor());
		}
		builder.append("]");
		return builder.toString();
	}
}







