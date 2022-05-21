package TrabalhoFilaDeque;


import fila.FilaVaziaException;
import pilha.PilhaVaziaException;

public class ListaLigada implements IListaFila,IListaPilha{
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
		if (isEmpty()){
			throw new ListaVaziaException("Vazia");
		}
		No aux = primeiro;
		primeiro = aux.getProximo();
		tamanho--;
		return aux.getValor();
	}

	@Override
	public Object first(){
		if (isEmpty()){
			throw new ListaVaziaException("Vazia");
		}
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
		if (isEmpty()){
			throw new ListaVaziaException("Vazia");
		}
		No aux = primeiro;
		primeiro = aux.getProximo();
		tamanho--;
		return aux.getValor();
	}

	@Override
	public Object top(){
		if (isEmpty()){
			throw new ListaVaziaException("Vazia");
		}
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
}
