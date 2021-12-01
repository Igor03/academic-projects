/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.jogador;

/**
 *
 * @author Igor
 */
public class jogadorDAO {
	
	public void create(jogador j){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSERT INTO jogador VALUES(?, ?, ?, ?)");
			stmt.setString(1, j.getNome());
			stmt.setInt(2, j.getIdJogador());
			stmt.setInt(3, j.getQtdVitorias());
			stmt.setInt(4, j.getQtdDerrottas());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(jogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}			
	}
	public ArrayList<jogador> readJogadores(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// ArrayList auxiliar
		ArrayList<jogador> Jogadores = new ArrayList<jogador>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM jogador");
			rs = stmt.executeQuery();
			while(rs.next()){
				jogador j = new jogador();
				j.setNome(rs.getString("nome_jogador"));
				j.setIdJogador(rs.getInt("id_jogador"));
				j.setQtdVitorias(rs.getInt("qtd_vitorias"));
				j.setQtdDerrottas(rs.getInt("qtd_derrotas"));
				Jogadores.add(j);
			}
		} catch (SQLException ex) {
			Logger.getLogger(jogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return Jogadores;
	}
	public void update(jogador j){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
 			stmt = con.prepareStatement("UPDATE jogador SET nome_jogador = ?, id_jogador = ?, qtd_vitorias = ?, qtd_derrotas = ? WHERE id_jogador = ? ");
			stmt.setString(1, j.getNome());
			stmt.setInt(2, j.getIdJogador());
			stmt.setInt(3, j.getQtdVitorias());
			stmt.setInt(4, j.getQtdDerrottas());
			stmt.setInt(5, j.getIdJogador());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(jogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	public ArrayList<jogador> readTop10Jogadores(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// ArrayList auxiliar
		ArrayList<jogador> Jogadores = new ArrayList<jogador>();
		try {
			stmt = con.prepareStatement("SELECT * FROM jogador ORDER BY qtd_vitorias DESC LIMIT 10");
			rs = stmt.executeQuery();
			while(rs.next()){
				jogador j = new jogador();
				j.setNome(rs.getString("nome_jogador"));
				j.setIdJogador(rs.getInt("id_jogador"));
				j.setQtdVitorias(rs.getInt("qtd_vitorias"));
				j.setQtdDerrottas(rs.getInt("qtd_derrotas"));
				Jogadores.add(j);
			}
		} catch (SQLException ex) {
			Logger.getLogger(jogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return Jogadores;
	}
}
