package com.grupo10;

import java.util.ArrayList;
import java.util.List;

import com.grupo10.Modalidad.*;

public class Partido {
	List<Jugador> jugadores = new ArrayList<Jugador>();
	List<Jugador> participantes = new ArrayList<Jugador>();
	
	public void inscribirJugador(Jugador jugador, Modalidad modalidad){
		jugadores.add(jugador);
	}
	
	public void generarListaParticipantes(){
		
	}
	
	
}
