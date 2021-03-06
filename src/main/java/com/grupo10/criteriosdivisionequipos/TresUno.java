package com.grupo10.criteriosdivisionequipos;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;

public class TresUno implements CriterioDivision {

	private List <Integer> numerosEquipo1 = Arrays.asList(0,3,4,7,8);
	private List <Integer> numerosEquipo2 = Arrays.asList(1,2,5,6,9);
	
	@Override
	public void dividirEquipos(List<Participante> jugadores, Partido partido) {
		partido.equipo1 = new ArrayList<>();
		partido.equipo2 = new ArrayList<>();
		numerosEquipo1.forEach(n -> partido.equipo1.add(jugadores.get(n)));
		numerosEquipo2.forEach(n -> partido.equipo2.add(jugadores.get(n)));
	}

}
