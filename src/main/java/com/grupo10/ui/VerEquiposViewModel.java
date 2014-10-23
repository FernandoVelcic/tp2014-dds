package com.grupo10.ui;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import com.grupo10.db.EntityManagerHelper;
import com.grupo10.homes.HomeJugadores;
import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;

@Observable
public class VerEquiposViewModel {

	Partido partido;
	List<Partido> selectPartido;
	List<Long> selectIdPartido;
	List<Participante> equipo1;
	List<Participante> equipo2;
	
	public VerEquiposViewModel(){
		selectPartido = new ArrayList<Partido>();
		selectPartido = EntityManagerHelper.getEntityManager().createQuery("from Partido").getResultList();
		//Esto seria para ver los ids de los partidos, no funciona todavia
		//selectPartido.forEach(partido -> selectIdPartido.add(partido.getId()));
		
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public List<Partido> getSelectPartido() {
		return selectPartido;
	}

	public void setSelectPartido(List<Partido> selectPartido) {
		this.selectPartido = selectPartido;
	}

	public List<Long> getSelectIdPartido() {
		return selectIdPartido;
	}

	public void setSelectIdPartido(List<Long> selectIdPartido) {
		this.selectIdPartido = selectIdPartido;
	}

	public List<Participante> getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(List<Participante> equipo1) {
		this.equipo1 = equipo1;
	}

	public List<Participante> getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(List<Participante> equipo2) {
		this.equipo2 = equipo2;
	}

	public void mostrarEquipos() {
		equipo1 = HomeJugadores.getInstance().recuperarEquipo1(partido);
		equipo2 = HomeJugadores.getInstance().recuperarEquipo1(partido);
		
		
	}

}
