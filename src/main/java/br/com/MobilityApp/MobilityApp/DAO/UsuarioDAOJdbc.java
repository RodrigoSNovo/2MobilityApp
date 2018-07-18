package br.com.MobilityApp.MobilityApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import br.com.MobilityApp.MobilityApp.CONEXAO.ConexaoDB;
import br.com.MobilityApp.MobilityApp.MODEL.Usuario;

public class UsuarioDAOJdbc implements UsuarioDAO{

	@Override
	public boolean insereUsuario(Usuario usuario) {
		String query = "INSERT INTO pessoa (cpf, email, nome_completo, telefone, ddd, dt_nascimento, senha, dt_criacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, usuario.getCpf());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getNome());
			ps.setString(4, usuario.getTelefone());
			ps.setString(5, usuario.getDdd());
			ps.setDate(6, (java.sql.Date) usuario.getDataNascimento());
			ps.setString(7, usuario.getSenha());
			ps.setDate(8, new java.sql.Date(new Date().getTime()));
			
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
	public boolean alteraUsuario(Usuario usuario) {
		String query = "UPDATE pessoa SET cpf = ?, email = ?, nome_completo = ?, telefone = ?, ddd = ?, dt_nascimento = ?, senha = ? WHERE id = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, usuario.getCpf());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getNome());
			ps.setString(4, usuario.getTelefone());
			ps.setString(5, usuario.getDdd());
			ps.setDate(6, (java.sql.Date) usuario.getDataNascimento());
			ps.setString(7, usuario.getSenha());
			ps.setInt(8, usuario.getId());
			
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
	public boolean excluirUsuarioPorCpf(String cpf) {
		String query = "DELETE pessoa WHERE cpf = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, cpf);
			
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
	public Usuario buscaUsuarioPorEmail(String email) {
		String query = "SELECT * FROM pessoa WHERE email = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			Usuario usuario = null;
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNome(rs.getString("nome_completo"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setDdd(rs.getString("ddd"));
				usuario.setDataNascimento(rs.getDate("dt_nascimento"));
//				usuario.setSenha(rs.getString("senha"));
				usuario.setDataCricao(rs.getDate("dt_criacao"));
			}
			
            rs.close();
            ps.close();
            conn.close();
			
			return usuario;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}
	}
}
