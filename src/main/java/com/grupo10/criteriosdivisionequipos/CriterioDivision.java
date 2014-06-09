package com.grupo10.criteriosdivisionequipos;


import java.util.List;

import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;

public interface CriterioDivision {
	
	public void dividirEquipos(List<Participante> jugadores, Partido partido);
	
}
