package com.grupo10.modalidades;

import com.grupo10.juego.Partido;

public interface Modalidad {
	public abstract Integer getPrioridad();
	public abstract boolean isPuedeJugar(Partido partido); 
}
