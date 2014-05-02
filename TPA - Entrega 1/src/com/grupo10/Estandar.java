package com.grupo10;

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
			compararPriodidades(unPartido);
		}
			
	}
	
	public void compararPriodidades(Partido unPartido)
	{
		//Aca tendria que el jugador con menor prioridad que esta anotado en ese partido, la comparo con la prioridad del jugador
		//que esta entrando, y si esta ultima es mayor saco al jugador que estaba en la lista. Y agrego al que esta por entrar.
		
		//getListaEstandarDe(unPartido).sort((j1,j2) -> j1.prioridad >= j2.prioridad);
				
	}
}
