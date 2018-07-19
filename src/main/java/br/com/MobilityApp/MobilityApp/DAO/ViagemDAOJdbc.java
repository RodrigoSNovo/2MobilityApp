package br.com.MobilityApp.MobilityApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import br.com.MobilityApp.MobilityApp.CONEXAO.ConexaoDB;
import br.com.MobilityApp.MobilityApp.MODEL.Transporte;
import br.com.MobilityApp.MobilityApp.MODEL.Usuario;
import br.com.MobilityApp.MobilityApp.MODEL.Viagem;

public class ViagemDAOJdbc implements ViagemDAO {

	@Override
	public boolean insereViagem(Viagem viagem, Usuario usuario, Transporte transporte) {
		String query = "INSERT INTO viagem (id_pessoa, id_tipo_transporte, tempo_viagem, distancia_viagem, endereco_partida, endereco_chegada, data_viagem) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, usuario.getId());
			ps.setInt(2, transporte.getId());
			ps.setString(3, viagem.getTempoViagem());
			ps.setString(4, viagem.getDistanciaViagem());
			ps.setString(5, viagem.getEnderecoPartida());
			ps.setString(6, viagem.getEnderecoDestino());
			ps.setDate(7, new java.sql.Date(new Date().getTime()));
			
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
	public boolean alteraViagem(Viagem viagem, Usuario usuario, Transporte transporte) {
		String query = "UPDATE viagem SET id_pessoa = ?, id_tipo_transporte = ?, tempo_viagem = ?, distancia_viagem = ?, endereco_partida = ?, endereco_chegada = ? WHERE id_viagem = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, usuario.getId());
			ps.setInt(2, transporte.getId());
			ps.setString(3, viagem.getTempoViagem());
			ps.setString(4, viagem.getDistanciaViagem());
			ps.setString(5, viagem.getEnderecoPartida());
			ps.setString(6, viagem.getEnderecoDestino());
			ps.setInt(7, viagem.getId());
			
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
	public boolean excluirViagem(Usuario usuario, Transporte transporte) {
		String query = "DELETE viagem WHERE id_pessoa = ? AND id_tipo_transporte = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, usuario.getId());
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
	public Viagem buscaViagem(Usuario usuario, Transporte transporte) {
		String query = "SELECT * FROM viagem WHERE id_pessoa = ? AND id_tipo_transporte = ?";
		
		try {
			Connection conn = new ConexaoDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, usuario.getId());
			ps.setInt(2, transporte.getId());
			
			ResultSet rs = ps.executeQuery();
			
			Viagem viagem = null;
			if(rs.next()) {
				viagem = new Viagem();
				viagem.setId(rs.getInt("id_viagem"));
				viagem.setIdUsuario(rs.getInt("id_pessoa"));
				viagem.setIdTransporte(rs.getInt("id_tipo_transporte"));
				viagem.setTempoViagem(rs.getString("tempo_viagem"));
				viagem.setDistanciaViagem(rs.getString("distancia_viagem"));
				viagem.setEnderecoPartida(rs.getString("endereco_partida"));
				viagem.setEnderecoDestino(rs.getString("endereco_chegada"));
				viagem.setDataViagem(rs.getDate("data_viagem"));
			}
			
            rs.close();
            ps.close();
            conn.close();
			
			return viagem;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}
	}

}
