package com.grupo10.modalidades;

import com.grupo10.juego.Partido;

public class Estandar implements Modalidad {
	@Override
	public Integer getPrioridad() {
		return Prioridad.ESTANDAR.ordinal();
	}

	@Override
	public boolean isPuedeJugar(Partido partido) {
		return true;
	}

}
