package com.grupo10.modalidades;

import com.grupo10.juego.Partido;

public class Condicional implements Modalidad {
	
	boolean condicion;
	
	public Condicional(boolean condicion){
		this.condicion = condicion;
	}

	@Override
	public Integer getPrioridad() {
		return Prioridad.CONDICIONAL.ordinal();
	}
	
	@Override
	public boolean isPuedeJugar(Partido partido) {
		return condicion;
	}

}
