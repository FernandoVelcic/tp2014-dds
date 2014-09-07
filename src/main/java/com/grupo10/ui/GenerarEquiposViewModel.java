package com.grupo10.ui;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import com.grupo10.criteriosdivisionequipos.*;
import com.grupo10.criteriosordenequipos.*;
import com.grupo10.homes.HomeJugadores;
import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;

@Observable
public class GenerarEquiposViewModel {
	CriterioDivision criterioDivision;
	List<CriterioDivision> listaCriteriosDivision;

	CriterioOrden criterioOrden;
	List<CriterioOrden> listaCriteriosOrden;
	
	Partido partido;
	List<Participante> equipo1;
	List<Participante> equipo2;
	
	Participante participanteSeleccionado;

	public GenerarEquiposViewModel() {
		partido = new HomeJugadores().getInstance().getPartido();
		listaCriteriosDivision = new ArrayList<CriterioDivision>();
		listaCriteriosDivision.add(new ParImpar());
		listaCriteriosDivision.add(new TresUno());
		
		listaCriteriosOrden = new ArrayList<CriterioOrden>();
		listaCriteriosOrden.add(new Calificaciones());
		listaCriteriosOrden.add(new Handicap());
		//listaCriteriosOrden.add(new MixCriterios());
		//listaCriteriosOrden.add(new Ncalificaciones());
	}

	public void generarEquipos() {
		partido.generarJugadores();
		new HomeJugadores().getInstance().getAdmin().generarEquiposTentativos(criterioOrden, criterioDivision);
		equipo1 = partido.equipo1;
		equipo2 = partido.equipo2;
	}
	
	public void confirmarEquipos() {
		
	}

	public CriterioDivision getCriterioDivision() {
		return criterioDivision;
	}
	
	public void setCriterioDivision(CriterioDivision criterioDivision) {
		this.criterioDivision = criterioDivision;
	}

	public CriterioOrden getCriterioOrden() {
		return criterioOrden;
	}
	
	public void setCriterioOrden(CriterioOrden criterioOrden) {
		this.criterioOrden = criterioOrden;
	}
	
	public List<CriterioDivision> getListaCriteriosDivision() {
		return listaCriteriosDivision;
	}

	public List<CriterioOrden> getListaCriteriosOrden() {
		return listaCriteriosOrden;
	}
	
	public List<Participante> getEquipo1() {
		return equipo1;
	}
	
	public List<Participante> getEquipo2() {
		return equipo2;
	}
	
	public Participante getParticipanteSeleccionado() {
		return participanteSeleccionado;
	}
	
	public void setParticipanteSeleccionado(Participante participanteSeleccionado) {
		this.participanteSeleccionado = participanteSeleccionado;
	}
}
