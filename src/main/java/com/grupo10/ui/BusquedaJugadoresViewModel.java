package com.grupo10.ui;

import java.io.Serializable;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import com.grupo10.homes.HomeJugadores;
import com.grupo10.juego.Participante;

@Observable
public class BusquedaJugadoresViewModel implements Serializable{
	
	private CriteriosBusqueda criterioBusqueda;
	private List<Participante> resultados;
	private Participante participanteSeleccionado;

	public BusquedaJugadoresViewModel(){
		criterioBusqueda = new CriteriosBusqueda();
	}
	
	public void search() {
		this.resultados = criterioBusqueda.searchJugadores(HomeJugadores.getInstance().getPartido().participantes);
	}

	public List<Participante> getResultados() {
		return resultados;
	}

	public void setResultados(List<Participante> resultados) {
		this.resultados = resultados;
	}

	public Participante getParticipanteSeleccionado() {
		return participanteSeleccionado;
	}

	public void setParticipanteSeleccionado(Participante participanteSeleccionado) {
		this.participanteSeleccionado = participanteSeleccionado;
	}

	public CriteriosBusqueda getCriterioBusqueda() {
		return criterioBusqueda;
	}
	
	public void setCriterioBusqueda(CriteriosBusqueda criterioBusqueda) {
		this.criterioBusqueda = criterioBusqueda;
	}
}
