/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilhaDuplamenteEncadeada;

/**
 *
 * @author Igor
 */
public class pilhaDuplamenteEncadeada {
	private NoPilha header;
	private NoPilha trailer;
	private int tamanho;

	public pilhaDuplamenteEncadeada() {
		this.header = new NoPilha (null, null, null);
		this.trailer = new NoPilha (null, header, null);
		
		header.setProximo(trailer);
		tamanho = 0;
	}
	
	public void insereInicio(NoPilha novoNo){
		trailer.getAnterior().setProximo(novoNo);
		novoNo.setAnterior(trailer.getAnterior());
		novoNo.setProximo(trailer);
		trailer.setAnterior(novoNo);
		
		tamanho++;
	}
	public NoPilha removeFinal() {
		NoPilha noRemovido = trailer.getAnterior();
		if (tamanho==0){
			System.out.println("A pilha esta vazia!");
			return null;
		}
		
		trailer.setAnterior(noRemovido.getAnterior());
		noRemovido.getAnterior().setProximo(trailer);
		noRemovido.setProximo(null);
		noRemovido.setAnterior(null);
				
		tamanho--;
		return noRemovido;
	}
	
	public void limpaPilha(){
		while(getTamanho()>0){
			removeFinal();
		}
	}
	
	public int getTamanho(){
		//System.out.println(this.tamanho);
		return this.tamanho;
	}
	
	public void imprimePilha(){
		NoPilha aux = header;
		
		while (aux!=null){
			System.out.print("<-> "+ aux.getValor());
			aux = aux.getProximo();
		}
		System.out.println();
	}
}