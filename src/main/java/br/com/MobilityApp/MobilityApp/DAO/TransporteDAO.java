package br.com.MobilityApp.MobilityApp.DAO;

import br.com.MobilityApp.MobilityApp.MODEL.Transporte;

public interface TransporteDAO {

	public boolean insereTransporte(Transporte transporte);
	public boolean alteraTransporte(Transporte transporte);
	public boolean excluiTransportePorId(int id);
	public Transporte buscaTransportePorApelido(String apelido);
}
