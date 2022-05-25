package TrabalhoFilaDeque;

import TrabalhoFilaDeque.FilaLista.IListaFila;
import TrabalhoFilaDeque.PilhaLista.IListaPilha;

public class ListaLigada implements IListaFila, IListaPilha {
	private No primeiro;
	private No ultimo;
	private int tamanho;

	public ListaLigada() {
		this.primeiro = null;
		this.ultimo = null;
		this.tamanho = 0;
	}
	
	public No getPrimeiro() {
		return primeiro;
	}
	public void setPrimeiro(No primeiro) {
		this.primeiro = primeiro;
	}
	public No getUltimo() {
		return ultimo;
	}
	public void setUltimo(No ultimo) {
		this.ultimo = ultimo;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	//------------------Fila--------------------------
	public void enqueue(Object o) {
		No elemento = new No();
		elemento.setValor(o);

		if(tamanho == 0) {
			primeiro = elemento;
			ultimo = elemento;
		}
		else {
			ultimo.setProximo(elemento);
			ultimo = elemento;
		}
		tamanho++;
	}

	@Override
	public Object dequeue(){

		No aux = primeiro;
		primeiro = aux.getProximo();
		tamanho--;
		return aux.getValor();
	}

	@Override
	public Object first(){

		return primeiro.getValor();
	}

	@Override
	public int size() {
		return tamanho;
	}

	//------------------Pilha--------------------------
	@Override
	public void push(Object o) {
		No elemento = new No();
		elemento.setValor(o);
		if(tamanho == 0) {
			primeiro = elemento;
			ultimo = elemento;
		}
		else {
			elemento.setProximo(primeiro);
			primeiro = elemento;// o novo elemento sempre será o primeiro.
		}
		tamanho++;
	}

	@Override
	public Object pop(){

		No aux = primeiro;
		primeiro = aux.getProximo();
		tamanho--;
		return aux.getValor();
	}

	@Override
	public Object top(){

		return primeiro.getValor();
	}

	@Override
	public boolean isEmpty() {
		return primeiro == null;
	}

	@Override
	public void print() {
		No elemento = primeiro;
		for (int i = 1; i <= tamanho; i++){
			System.out.println("Posição: " + i + " Valor: " + elemento.getValor());
			elemento = elemento.getProximo();
		}
	}

	//------------------FilaComDuasPilhas--------------------------
	public ListaLigada invertLista(){
		ListaLigada pilhaInvertida = new ListaLigada();
		No antigo_primeiro = primeiro;

		for (int i = 0; i < tamanho; i++){
			pilhaInvertida.push(antigo_primeiro.getValor());
			antigo_primeiro = antigo_primeiro.getProximo();
		}

		return pilhaInvertida;
	}
}
