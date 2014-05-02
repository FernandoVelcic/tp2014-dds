package com.grupo10;

import java.util.List;
import java.util.stream.Stream;

//TENGO QUE CREAR UN METODO PARA FILTRAR LAS LISTAS ASI NO REPITO TANTO EL C�DIGO.

public abstract class Inscripciones {
	public List<Jugadores> listaEstandar;
	public List<Jugadores> listaSolidaria; 
	public List<Jugadores> listaCondicionales;
	
	public void agregarAlista(Jugadores unJugador, Partido unPartido)
	{
		
	}
	
	public int cantidadDeJugadoresEstandaresEn(Partido unPartido)
	{
		return (int)filtrarJugadoresEnPartido(listaEstandar,unPartido).stream().count();
	}
	
	public int cantidadDeJugadoresSolidariosEn(Partido unPartido)
	{
		return (int)filtrarJugadoresEnPartido(listaSolidaria,unPartido).stream().count();
	}
	
	public int cantidadDeJugadoresCondicionalesEn(Partido unPartido)
	{
		return (int)filtrarJugadoresEnPartido(listaCondicionales,unPartido).stream().count();
	}
	
	public List<Jugadores> getListaEstandarDe(Partido unPartido)
	{
		return filtrarJugadoresEnPartido(listaEstandar,unPartido);
	}
	
	public List<Jugadores> getListaSolidariosDe(Partido unPartido)
	{
		return filtrarJugadoresEnPartido(listaSolidaria,unPartido);
	}
	
	public List<Jugadores> getListaCondicionalesDe(Partido unPartido)
	{
		return filtrarJugadoresEnPartido(listaCondicionales,unPartido);
	}
	
	public List<Jugadores> filtrarJugadoresEnPartido(List<Jugadores> lista, Partido unPartido)
	{
		Stream<Jugadores> jugadoresEnPartido = lista.stream().filter(jugador -> jugador.compararPartidos(unPartido));
		return (List<Jugadores>) jugadoresEnPartido;
	}
	

}