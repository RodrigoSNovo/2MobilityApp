package br.com.MobilityApp.MobilityApp.DAO;

import br.com.MobilityApp.MobilityApp.MODEL.Automovel;
import br.com.MobilityApp.MobilityApp.MODEL.Usuario;

public interface AutomovelDAO {

	public boolean insereAutomovel(Automovel automovel, Usuario usuario);
	public boolean alteraAutomovel(Automovel automovel, Usuario usuario);
	public boolean excluiAutomovel(Automovel automovel, Usuario usuario);
	public Automovel buscaAutomovel(Usuario usuario);
	
}
