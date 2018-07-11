package br.com.MobilityApp.MobilityApp.DAO;

import br.com.MobilityApp.MobilityApp.MODEL.Transporte;

public interface TransporteDAO {

	public boolean insereTransporte(Transporte transporte);
	public boolean alteraTransporte(Transporte transporte);
	public boolean excluiTransporte(Transporte transporte);
	public Transporte buscaTransporte(Transporte transporte);
}
