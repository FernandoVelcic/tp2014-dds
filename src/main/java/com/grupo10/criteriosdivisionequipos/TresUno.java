package com.grupo10.criteriosdivisionequipos;


import java.util.Arrays;
import java.util.List;

import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;

public class TresUno implements CriterioDivision {

	private List <Integer> numerosEquipo1 = Arrays.asList(1,4,5,8,9);
	private List <Integer> numerosEquipo2 = Arrays.asList(2,3,6,7,10);
	
	@Override
	public void dividirEquipos(List<Participante> jugadores, Partido partido) {
		numerosEquipo1.forEach(n -> partido.equipo1.add(jugadores.get(n)));
		numerosEquipo2.forEach(n -> partido.equipo2.add(jugadores.get(n)));
	}

}
