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
public class partidas {
	private int id_partida;
	private String jogador1;
	private String jogador2;
	private int idJ1;
	private int idJ2;
	private String vencedor;
	private String data;
	private String hora;

	public String getJogador1() {
		return jogador1;
	}
	public int getId_partida() {
		return id_partida;
	}
	public void setId_partida(int id_partida) {
		this.id_partida = id_partida;
	}
	public void setJogador1(String jogador1) {
		this.jogador1 = jogador1;
	}
	public String getJogador2() {
		return jogador2;
	}
	public void setJogador2(String jogador2) {
		this.jogador2 = jogador2;
	}
	public int getIdJ1() {
		return idJ1;
	}
	public void setIdJ1(int idJ1) {
		this.idJ1 = idJ1;
	}
	public int getIdJ2() {
		return idJ2;
	}
	public void setIdJ2(int idJ2) {
		this.idJ2 = idJ2;
	}
	public String getVencedor() {
		return vencedor;
	}
	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
}
