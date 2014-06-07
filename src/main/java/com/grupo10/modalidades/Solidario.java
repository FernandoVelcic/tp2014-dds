package com.grupo10.modalidades;

import com.grupo10.juego.Partido;

public class Solidario implements Modalidad {
	@Override
	public Integer getPrioridad() {
		return Prioridad.SOLIDARIO.ordinal();
	}

	@Override
	public boolean isPuedeJugar(Partido partido) {
		return true;
	}

}
