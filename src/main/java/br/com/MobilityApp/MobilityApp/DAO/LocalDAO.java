package br.com.MobilityApp.MobilityApp.DAO;

import br.com.MobilityApp.MobilityApp.MODEL.Local;
import br.com.MobilityApp.MobilityApp.MODEL.Usuario;

public interface LocalDAO {

	public boolean insereLocal(Local local, Usuario usuario);
	public boolean alteraLocal(Local local, Usuario usuario);
	public boolean excluiLocal(Local local, Usuario usuario);
	public Local buscaLocal(Usuario usuario);
}
