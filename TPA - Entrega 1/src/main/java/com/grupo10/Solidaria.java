package com.grupo10;

import java.util.List;

public class Solidaria extends Inscripciones {
	public int cantidadMaximaJugadores;	
	
	public Solidaria(int cantidad)
	{
		//ver si puedo usar este atributo en vez del estatico!! asi me saco los warnings!
		cantidadMaximaJugadores = cantidad;
	}
	
	public void agregarAlista(Jugadores unJugador, Partido unPartido)
	{
		if(laSumaEntreListaJugadoresYlistaSolidariaEsIgual(unPartido)){
				//Me fijo quien entro primero en la lista de solidarios y lo saco.
		}else{
			listaSolidaria.add(unJugador);
		}	
	}
	
	public boolean laSumaEntreListaJugadoresYlistaSolidariaEsIgual(Partido unPartido)
	{
		if(cantidadDeJugadoresEstandaresEn(unPartido)+cantidadDeJugadoresSolidariosEn(unPartido) == unPartido.cantidadJugadoresXpartido)
			return true;
		return false;			
	}
	
	public List<Jugadores> getLista()
	{
		return listaSolidaria;
	}
}
