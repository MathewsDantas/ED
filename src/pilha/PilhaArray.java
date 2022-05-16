package pilha;

public class PilhaArray implements IPilha{

	private int capacidade;
	private Object[] p; // pilha
	private int t; // tamanho = t + 1
	private int FC; // fator crescimento
	
	
	public PilhaArray(int capacidade,int crescimento) {
		super();
		this.capacidade = capacidade;
		this.t = -1;
		if(crescimento <=0)
			FC = 0;
		p = new Object[capacidade];
	}

	@Override
	public void push(Object o) {
		if(t >= capacidade-1) {
			if(FC == 0) {
				capacidade*=2;
			}
			else {
				capacidade = capacidade + FC;
			}
			Object[] p2 = new Object[capacidade];
			for(int i = 0; i <size(); i++) {
				p2[i] = p[i];
			}
			p = p2;
		}
		p[++t] = o;
	}

	@Override
	public Object pop() throws PilhaVaziaException {
		if(isEmpty()) {
			throw new PilhaVaziaException("A pilha est� vazia");
		}
		return p[t--];
	}

	@Override
	public Object top() throws PilhaVaziaException {
		if(isEmpty()) {
			throw new PilhaVaziaException("A pilha est� vazia");
		}
		return p[t];
	}

	@Override
	public boolean isEmpty() {
		return t == -1;
	}

	@Override
	public int size() {
		return t+1;
	}
	
	public void mostra() {
		for(int i = 0; i <= t; i++) {
			System.out.println(p[i]);
		}
	}
	
	public void invert(){
		Object[] p_invert = new Object[capacidade];
		int j = t;
		for (int i = 0; i <= t; i++){
			p_invert[i] = p[j];
			j--;
		}
		p = p_invert;
	}

	public void adicionaPilha(PilhaArray pilha){
		int size = pilha.size();
		int i = 0;
		while (size > 0){
			push(pilha.p[i]);
			i++;
			size--;
		}
	}

	public void empty(){
		t = -1;
	}


}
