package br.com.MobilityApp.MobilityApp.DAO;

import br.com.MobilityApp.MobilityApp.MODEL.Automovel;
import br.com.MobilityApp.MobilityApp.MODEL.Usuario;

public interface AutomovelDAO {

	public boolean insereAutomovel(Automovel automovel, Usuario usuario);
	public boolean alteraAutomovel(Automovel automovel, Usuario usuario);
	public boolean excluiAutomovelPorApelido(String apelido, Usuario usuario);
	public Automovel buscaAutomovelPorApelido(String apelido, Usuario usuario);
	
}
