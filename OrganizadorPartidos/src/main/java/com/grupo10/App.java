package com.grupo10;

import java.util.Date;

import Modalidades.*;

public class App {

	public static void main(String[] args) {
		Administrador fer = new Administrador();
		Partido partidoHoy = fer.CrearPartido(new Date());
		
		Jugador martin = new Jugador();
		
		//martin solo va a jugar si hay 9 jugadores confirmados
		martin.InscribirmeAPartido(partidoHoy, new Condicional() {
	    	@Override
	    	public boolean isPuedeJugar(Partido partido) {
	    		return partido.calcularConfirmados() == 9;
	    	}
	    });
	    
	}

}
