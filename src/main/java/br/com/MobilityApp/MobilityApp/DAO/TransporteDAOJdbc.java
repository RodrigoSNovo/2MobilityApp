package br.com.MobilityApp.MobilityApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.MobilityApp.MobilityApp.CONEXAO.ConexaoDB;
import br.com.MobilityApp.MobilityApp.MODEL.Transporte;

public class TransporteDAOJdbc implements TransporteDAO {

	@Override
	public boolean insereTransporte(Transporte transporte) {
		
		String query = "INSERT INTO tipo_transporte(apelido) VALUES (?)";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, transporte.getApelido());
			
			ps.execute();
            ps.close();
            conn.close();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean alteraTransporte(Transporte transporte) {
		String query = "UPDATE tipo_transporte SET apelido = ? WHERE id_tipo_transporte = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, transporte.getApelido());
			ps.setInt(2, transporte.getId());
			
			ps.execute();
            ps.close();
            conn.close();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean excluiTransportePorId(int id) {
		String query = "DELETE tipo_transporte WHERE id_tipo_transporte = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ps.execute();
            ps.close();
            conn.close();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Transporte buscaTransportePorApelido(String apelido) {
		String query = "SELECT * FROM tipo_transporte WHERE apelido = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, apelido);
			
			ResultSet rs = ps.executeQuery();
			
			Transporte transporte = null;
			if(rs.next()) {
				transporte = new Transporte();
				transporte.setId(rs.getInt("id_tipo_transporte"));
				transporte.setApelido(rs.getString("apelido"));
			}
			
            rs.close();
            ps.close();
            conn.close();
			
			return transporte;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}
	}

}
