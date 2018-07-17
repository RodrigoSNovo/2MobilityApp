package br.com.MobilityApp.MobilityApp.DAO;

import br.com.MobilityApp.MobilityApp.MODEL.Local;
import br.com.MobilityApp.MobilityApp.MODEL.Usuario;

public interface LocalDAO {

	public boolean insereLocal(Local local, Usuario usuario);
	public boolean alteraLocal(Local local, Usuario usuario);
	public boolean excluiLocalPorApelido(String apelido, Usuario usuario);
	public Local buscaLocalPorApelido(String apelido, Usuario usuario);
}
