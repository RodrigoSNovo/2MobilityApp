package br.com.MobilityApp.MobilityApp.DAO;

import br.com.MobilityApp.MobilityApp.MODEL.Transporte;
import br.com.MobilityApp.MobilityApp.MODEL.Usuario;
import br.com.MobilityApp.MobilityApp.MODEL.Viagem;

public interface ViagemDAO {

	public boolean insereViagem(Viagem viagem, Usuario usuario, Transporte transporte);
	public boolean alteraViagem(Viagem viagem, Usuario usuario, Transporte transporte);
	public boolean excluirViagem(Usuario usuario, Transporte transporte);
	public Viagem buscaViagem(Usuario usuario, Transporte transporte);
}
