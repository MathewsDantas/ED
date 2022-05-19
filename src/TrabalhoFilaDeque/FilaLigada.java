package TrabalhoFilaDeque;


public class FilaLigada {
	private No primeiro;
	private No ultimo;
	private int tamanho;
	
	
	public FilaLigada() {
		super();
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
	
	public void enqueue(Object o) {
		No elemento = new No();
		elemento.setValor(o);
		
		if(primeiro == null && ultimo == null) {
			primeiro = elemento;
			ultimo = elemento;
		}
		else {
			ultimo.setProximo(elemento);
			ultimo = elemento;
		}
		tamanho++;
	}
	
}
