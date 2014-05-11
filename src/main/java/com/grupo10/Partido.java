package com.grupo10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import Modalidades.*;

public class Partido {
	private List<Participante> participantes = new ArrayList<Participante>();
	private Date diaYhora;

	private Equipo equipo1;
	private Equipo equipo2;

	public Partido(Date diaYhora) {
		this.diaYhora = diaYhora;
	}

	public boolean inscribirJugador(Jugador jugador, Modalidad modalidad) {
		if (calcularConfirmados() >= 10)
			return false;

		participantes.add(new Participante(jugador, modalidad));

		return true;
	}

	public void GenerarEquipos() {
		ordenarPorModalidad();
		
		//Obtener los primeros 10
		//TODO Validar que sean los primeros 10 que pueden cumplir la condicion
		List<Participante> jugadores = new ArrayList<Participante>(participantes.subList(0, 10));
		// TODO Criterio para llenar equipo1 y equipo2
	}

	public void ConfirmarEquipos() {
		// TODO Auto-generated method stub
	}
	
	public int calcularConfirmados() {
		return (int) obtenerConfirmados().count();
	}

	private Stream<Participante> obtenerConfirmados() {
		return participantes.stream().filter(p -> p.getPrioridadModalidad() == 0);
	}
	
	private void ordenarPorModalidad()
	{
		Collections.sort(participantes, new Comparator<Participante>() {
	        @Override
	        public int compare(Participante participante1, Participante participante2)
	        {
	            return participante1.getPrioridadModalidad() - participante2.getPrioridadModalidad();
	        }}
		);
	}
}
