package com.grupo10;

import java.util.ArrayList;
import java.util.List;

public class Partido {
	
	public static int cantidadJugadoresXpartido = 10;
	public List<Jugadores> jugadores = new ArrayList<Jugadores>();
	//estaba como timestamp
	public int dia;
	public Jugadores equipo1,equipo2;
	public Inscripciones inscripciones;	

	public Partido(int d)
	{
		dia = d;
	}
	
	public void agregarJugador(Jugadores unJugador)
	{
		jugadores.add(unJugador);
	}
	
	public void actualizarPrioridadJugadores()
	{
		int i;
		for(i=0;i<jugadores.size();i++)
		{
			jugadores.get(i).prioridad++;
		}
	}
	
	public void cerrarInscripcionPartido()
	{
		this.concatenoListaFinalConEstandares();
		if (jugadores.size() < cantidadJugadoresXpartido)
		{
			System.out.println("No hay suficientes jugadores para el partido");
		}else{
			actualizarPrioridadJugadores();
			System.out.println("Estan todos los jugadores");
		}
	}

	
	public void concatenoListaFinalConEstandares()
	{
		List<Jugadores> listaParcial = new ArrayList<Jugadores>();
		listaParcial.addAll(inscripciones.getListaEstandarDe(this));
		if (listaParcial.size() >= cantidadJugadoresXpartido)
			jugadores = listaParcial.subList(0, cantidadJugadoresXpartido);
		concatenoListaEstandarConSolidarios();
	}
	
	
	public void concatenoListaEstandarConSolidarios()
	{
		List<Jugadores> listaParcial = new ArrayList<Jugadores>();
		listaParcial.addAll(inscripciones.getListaEstandarDe(this));
		listaParcial.addAll(inscripciones.getListaSolidariosDe(this));
		if (listaParcial.size() >= cantidadJugadoresXpartido)
			jugadores = listaParcial.subList(0, cantidadJugadoresXpartido);
		concatenoListaEstandarSolidariosConCondionales();
	}
	
	public void concatenoListaEstandarSolidariosConCondionales()
	{
		List<Jugadores> listaParcial = new ArrayList<Jugadores>();
		listaParcial.addAll(inscripciones.getListaEstandarDe(this));
		listaParcial.addAll(inscripciones.getListaSolidariosDe(this));
		listaParcial.addAll(inscripciones.getListaCondicionalesDe(this));
		if(listaParcial.size() >= cantidadJugadoresXpartido)
			jugadores = listaParcial.subList(0, cantidadJugadoresXpartido);
	}
	
	

}
