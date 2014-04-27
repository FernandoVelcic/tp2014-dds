package com.grupo10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.grupo10.Modalidad.*;

public class Partido {
	List<Participante> participantes = new ArrayList<Participante>();	
	
	public boolean inscribirJugador(Jugador jugador, Modalidad modalidad){
		if(calcularConfirmados() > 10)
			return false;
			
		participantes.add(new Participante(jugador, modalidad));
		return true;
	}
	
	public Stream<Participante> obtenerConfirmados(){
		return participantes.stream().filter(p -> p.isConfirmado());
	}
	
	public int calcularConfirmados(){
		return (int)obtenerConfirmados().count();
	}
	
	
}
