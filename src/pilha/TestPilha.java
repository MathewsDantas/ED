package pilha;

public class TestPilha {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		PilhaArray P1=new PilhaArray(1, 0);
		//PilhaVector P1=new PilhaVector();
		P1.push(10);
		P1.push(20);
		P1.push(30);
		P1.mostra();
		P1.empty();
		P1.push(40);
		P1.push(50);
		try{
		P1.pop();
		}catch(Exception err){
			System.out.println("Erro: "+err.getMessage());
		}
		P1.push(60);
		System.out.println("Pilha:");
		P1.mostra();
		P1.invert();
		System.out.println("Pilha Invert:");
		P1.mostra();
		System.out.println();
		
		
		PilhaArray P2=new PilhaArray(1,0);
		P2.push(100);
		P2.adicionaPilha(P1);
		P2.push(120);
		System.out.println("Adiciona pilha: ");
		P2.mostra();
		
		//System.out.print( P1.testeExpressao("([{}{}{aju}j dk])") );
		
		
		
		//testando FILAcomDuasPilhas
		
		//FilaComPilhas F1=new FilaComPilhas();
		System.out.println("Fila 1:");
		//F1.enqueue(5);
		//F1.enqueue(6);
		//F1.enqueue(7);
		//F1.mostra();
		System.out.println("Fila 2:");
		//F1.dequeue();
		//F1.mostra();
	}
}
