package br.com.MobilityApp.MobilityApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import br.com.MobilityApp.MobilityApp.CONEXAO.ConexaoDB;
import br.com.MobilityApp.MobilityApp.MODEL.Automovel;
import br.com.MobilityApp.MobilityApp.MODEL.Local;
import br.com.MobilityApp.MobilityApp.MODEL.Usuario;

public class AutomovelDAOJdbc implements AutomovelDAO {

	@Override
	public boolean insereAutomovel(Automovel automovel, Usuario usuario) {
		String query = "INSERT INTO automovel (id_pessoa, apelido, media_combustivel, km_litro, dt_registro) VALUES (?, ?, ?, ?, ?)";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, usuario.getId());
			ps.setString(2, automovel.getApelido());
			ps.setDouble(3, automovel.getMediaCombustivel());
			ps.setInt(4, automovel.getKmLitro());
			ps.setDate(5, new java.sql.Date(new Date().getTime()));
			
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
	public boolean alteraAutomovel(Automovel automovel, Usuario usuario) {
		String query = "UPDATE automovel SET apelido = ?, media_combustivel = ?, km_litro = ? WHERE id_pessoa = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, automovel.getApelido());
			ps.setDouble(2, automovel.getMediaCombustivel());
			ps.setInt(3, automovel.getKmLitro());
			ps.setInt(4, usuario.getId());
			
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
	public boolean excluiAutomovelPorApelido(String apelido, Usuario usuario) {
		String query = "DELETE automovel WHERE apelido = ? AND id_pessoa = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, apelido);
			ps.setInt(2, usuario.getId());
			
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
	public Automovel buscaAutomovelPorApelido(String apelido, Usuario usuario) {
		String query = "SELECT * FROM automovel WHERE apelido = ? AND id_pessoa = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, apelido);
			ps.setInt(2, usuario.getId());
			
			ResultSet rs = ps.executeQuery();
			
			Automovel automovel = null;
			if(rs.next()) {
				automovel = new Automovel();
				automovel.setId(rs.getInt("id_automovel"));
				automovel.setIdUsuario(rs.getInt("id_pessoa"));
				automovel.setApelido(rs.getString("apelido"));
				automovel.setMediaCombustivel(rs.getDouble("media_combustivel"));
				automovel.setKmLitro(rs.getInt("km_litro"));
				automovel.setDataRegistro(rs.getDate("dt_registro"));
			}
			
            rs.close();
            ps.close();
            conn.close();
			
			return automovel;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}
	}

}
