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
		if (inscripciones.getListaEstandarDe(this).size() == cantidadJugadoresXpartido)
			jugadores = inscripciones.getListaEstandarDe(this);
		this.concatenoConLasOtrasListas();
	}

	public void concatenoConLasOtrasListas()
	{
		int cuantosJugadoresFaltan = cantidadJugadoresXpartido - inscripciones.getListaEstandarDe(this).size();
		List<Jugadores> listaParcialJugadores = inscripciones.getListaSolidariosDe(this).subList(0, cuantosJugadoresFaltan - 1);
		jugadores.addAll(listaParcialJugadores);
		
		if (cantidadJugadoresXpartido < jugadores.size())
		{
			
		}
	}
	
	

}
