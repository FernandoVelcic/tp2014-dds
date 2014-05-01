package com.grupo10;

import java.util.List;

public class Estandar extends Inscripciones {
	public int cantidadMaximaJugadores;
	
	
	//A este constructor le tendria que pasar el valor de la variable de clase de Partido.
	//En vez de usar la variable de clase de partido, tendria que usar este atributo, asi saco los warnings
	public Estandar(int cantidad)
	{
		cantidadMaximaJugadores = cantidad;
	}
	
	public void agregarAlista(Jugadores unJugador, Partido unPartido)
	{
	
		//Mientras mi lista de jugadores estandares sea menor a 10 yo lo voy a agregar!!
		//No me importa que en las demas listas haya solidarios o condicionales!
		//Es un Estandar! El juega!! Tiene mayor prioridad
		if ( this.cantidadDeJugadoresEstandaresEn(unPartido) < unPartido.cantidadJugadoresXpartido)
		{
			listaEstandar.add(unJugador);
		}else{
			//Tomar la menor prioridad de la lista y compararla con el que llega.
			//Si el que llega tiene mayor prioridad! Lo incluyo!! y saco al de menor prioridad.
		}
	}
	
	public List<Jugadores> getLista()
	{
		return listaEstandar;
	}
	

}
