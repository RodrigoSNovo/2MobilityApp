package br.com.MobilityApp.MobilityApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import br.com.MobilityApp.MobilityApp.CONEXAO.ConexaoDB;
import br.com.MobilityApp.MobilityApp.MODEL.Local;
import br.com.MobilityApp.MobilityApp.MODEL.Usuario;

public class LocalDAOJdbc implements LocalDAO {

	@Override
	public boolean insereLocal(Local local, Usuario usuario) {
		String query = "INSERT INTO local (id_pessoa, apelido, endereco, data_cadastro) VALUES (?, ?, ?, ?)";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, usuario.getId());
			ps.setString(2, local.getApelido());
			ps.setString(3, local.getEndereco());
			ps.setDate(4, new java.sql.Date(new Date().getTime()));
			
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
	public boolean alteraLocal(Local local, Usuario usuario) {
		String query = "UPDATE local SET apelido = ?, endereco = ? WHERE id = ? AND id_pessoa = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, local.getApelido());
			ps.setString(2, local.getEndereco());
			ps.setInt(3, local.getId());
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
	public boolean excluiLocalPorApelido(String apelido, Usuario usuario) {
		String query = "DELETE local WHERE apelido = ? AND id_pessoa = ?";
		
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
	public Local buscaLocalPorApelido(String apelido, Usuario usuario) {
		String query = "SELECT * FROM local WHERE apelido = ? AND id_pessoa = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, apelido);
			ps.setInt(2, usuario.getId());
			
			ResultSet rs = ps.executeQuery();
			
			Local local = null;
			if(rs.next()) {
				local = new Local();
				local.setId(rs.getInt("id"));
				local.setIdUsuario(rs.getInt("id_pessoa"));
				local.setApelido(rs.getString("apelido"));
				local.setEndereco(rs.getString("endereco"));
				local.setDataCadastro(rs.getDate("data_cadastro"));
			}
			
            rs.close();
            ps.close();
            conn.close();
			
			return local;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}
	}

}
