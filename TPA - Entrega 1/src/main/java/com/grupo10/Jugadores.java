package com.grupo10;

public class Jugadores {
	
	public int prioridad;
	public String nombre;
	public Inscripciones tipoInscripcion;
	public Partido partidoActual;
	
	public void inscribirmeA(Partido unPartido)
	{
		this.tipoInscripcion.agregarAlista(this,unPartido);
	}
	
	public Jugadores(String n, Inscripciones i, Partido p)
	{
		nombre = n;
		tipoInscripcion = i;
		partidoActual = p;
	}
	
	//ESTE METODO ESTA BIEN PUESTO ACA? MMM..
	public boolean compararPartidos(Partido unPartido)
	{
		if(partidoActual == unPartido)
			return true;
		return false;
	}

}
