/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;
/**
 *
 * @author Igor
 */
public class jogador {
	
	private String nome;
	private int qtdVitorias = 0;
	private int qtdDerrottas = 0;
	private int idJogador;		// Será gerado aleatóriamente entre 0 e 1000;

	public int getQtdDerrottas() {
		return qtdDerrottas;
	}

	public void setQtdDerrottas(int qtdDerrottas) {
		this.qtdDerrottas = qtdDerrottas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdVitorias() {
		return qtdVitorias;
	}

	public void setQtdVitorias(int qtdVitorias) {
		this.qtdVitorias = qtdVitorias;
	}

	public int getIdJogador() {
		return idJogador;
	}

	public void setIdJogador(int idJogador) {
		this.idJogador = idJogador;
	}
}
