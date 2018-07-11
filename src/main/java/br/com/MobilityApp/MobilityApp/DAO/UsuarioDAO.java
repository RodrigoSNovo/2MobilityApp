package br.com.MobilityApp.MobilityApp.DAO;

import br.com.MobilityApp.MobilityApp.MODEL.Usuario;

public interface UsuarioDAO {
	
	public boolean insereUsuario(Usuario usuario);
	public boolean alteraUsuario(Usuario usuario);
	public boolean excluirUsuario(Usuario usuario);
	public Usuario buscaUsuarioPorCpf(String cpf);

}
