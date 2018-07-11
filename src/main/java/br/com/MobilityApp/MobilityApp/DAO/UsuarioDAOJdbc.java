package br.com.MobilityApp.MobilityApp.DAO;

import br.com.MobilityApp.MobilityApp.MODEL.Usuario;

public class UsuarioDAOJdbc implements UsuarioDAO{

	@Override
	public boolean insereUsuario(Usuario usuario) {
		try {
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean alteraUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluirUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario buscaUsuarioPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

}
