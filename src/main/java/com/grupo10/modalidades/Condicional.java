package com.grupo10.modalidades;

import com.grupo10.juego.Partido;

public class Condicional implements Modalidad {
	@Override
	public Integer getPrioridad() {
		return Prioridad.CONDICIONAL.ordinal();
	}
	
	@Override
	public boolean isPuedeJugar(Partido partido) {
		return false;
	}

}
