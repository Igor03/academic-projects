/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilhaDuplamenteEncadeada;

import javax.swing.JButton;

/**
 *
 * @author Igor
 */
public class NoPilha {
	
	private NoPilha proximo;
	private NoPilha anterior;
	private JButton valor;

	public NoPilha(NoPilha proximo, NoPilha anterior, JButton valor) {
		this.proximo = proximo;
		this.anterior = anterior;
		this.valor = valor;
	}

	public NoPilha getProximo() {
		return proximo;
	}

	public void setProximo(NoPilha proximo) {
		this.proximo = proximo;
	}

	public NoPilha getAnterior() {
		return anterior;
	}

	public void setAnterior(NoPilha anterior) {
		this.anterior = anterior;
	}

	public JButton getValor() {
		return valor;
	}

	public void setValor(JButton valor) {
		this.valor = valor;
	}

	
}
