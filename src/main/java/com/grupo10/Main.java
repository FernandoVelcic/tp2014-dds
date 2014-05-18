package com.grupo10;

import java.util.Collections;
import java.util.Date;

import Modalidades.Condicional;
import Modalidades.Estandar;
import Modalidades.Modalidad;
import Modalidades.Solidario;

public class Main {

	public static void main(String[] args) {
		Partido partido;
		Administrador alberto;
		Jugador martin;
		Jugador carlos;
		Jugador susana;
		Modalidad estandar;
		Modalidad condicional;
		Modalidad solidario;
		estandar = new Estandar();
		Jugador carlaJ = new Jugador(); 
		Participante carlaP = new Participante(carlaJ, estandar);
		Jugador carlosJ = new Jugador(); 
		Participante carlosP = new Participante(carlosJ, estandar);
		alberto = new Administrador();
		martin = new Jugador();
		carlos = new Jugador();
		susana = new Jugador();
		partido = new Partido(new Date(), alberto);
		
		condicional = new Condicional();
		solidario = new Solidario();
		
		partido.inscribirJugador(susana, condicional);
		partido.inscribirJugador(carlaJ, condicional);
		partido.generarJugadores();
		System.out.println("estan: " + partido.jugadores.contains(carlaJ.participante));
		System.out.println("los jugadores son: " + partido.jugadores);
		System.out.println("numero de jugadores:" + partido.jugadores.size());
			Collections.reverse(partido.jugadores);
			System.out.println("Collections.reverse: " + partido.jugadores);
		}

	}
