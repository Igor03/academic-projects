/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.partidas;
/**
 *
 * @author Igor
 */
public class partidasDAO {
	public void create(partidas p){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO partidas VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, p.getId_partida());
			stmt.setString(2, p.getJogador1());
			stmt.setString(3, p.getJogador2());
			stmt.setInt(4, p.getIdJ1());
			stmt.setInt(5, p.getIdJ2());
			stmt.setString(6, p.getVencedor());
			stmt.setString(7, p.getData());
			stmt.setString(8, p.getHora());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(partidasDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
 	}
	public ArrayList<partidas> readPartidas(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<partidas> Partidas = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT * FROM partidas");
			rs = stmt.executeQuery();
			while(rs.next()){
				partidas p = new partidas();
				p.setId_partida(rs.getInt("id_partida"));
				p.setJogador1(rs.getString("nome_jogador1"));
				p.setJogador2(rs.getString("nome_jogador2"));
				p.setIdJ1(rs.getInt("id_jogador1"));
				p.setIdJ2(rs.getInt("id_jogador2"));
				p.setVencedor(rs.getString("nome_vencedor"));
				p.setData(rs.getString("data_partida"));
				p.setHora(rs.getString("hora_partida"));
				Partidas.add(p);
			}
		} catch (SQLException ex) {
			Logger.getLogger(partidasDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return Partidas;
	}
//	public void update(partidas p){
//		Connection con = ConnectionFactory.getConnection();
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement("UPDATE partidas SET nome_jogador1 = ?, nome_jogador2 = ?, id_jogador1 = ?, id_jogador2 = ?, nome_vencedor = ?, ");
//		} catch (SQLException ex) {
//			Logger.getLogger(partidasDAO.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}
}
