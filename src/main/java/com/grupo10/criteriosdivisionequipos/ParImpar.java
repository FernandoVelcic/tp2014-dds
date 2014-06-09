package com.grupo10.criteriosdivisionequipos;


import java.util.List;
import java.util.stream.Collectors;

import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;

public class ParImpar implements CriterioDivision {

	@Override
	public void dividirEquipos(List<Participante> jugadores, Partido partido) {
		partido.equipo1 = jugadores.stream().filter(j -> jugadores.indexOf(j) % 2 == 0).collect(Collectors.toList());
		partido.equipo2 = jugadores.stream().filter(j -> jugadores.indexOf(j) % 2 == 1).collect(Collectors.toList());		
	}

	
}
