package EntregaUno;

import java.util.List;

public class Condicional extends Inscripciones{
	public int cantidadMaximaJugadores;

	public Condicional(int cantidad)
	{
		cantidadMaximaJugadores = cantidad;
	}

	public void agregarAlista(Jugadores unJugador, Partido unPartido)
	{
		if(laSumaEntreListaEstandarJugadoresYlistaCondicionalesEsIgual(unPartido)){
			//me fijo quien entro primero de los condicionales y lo saco
		}else{
			listaCondicionales.add(unJugador);
		}
	}
	
	public boolean laSumaEntreListaEstandarJugadoresYlistaCondicionalesEsIgual(Partido unPartido)
	{
		if(cantidadDeJugadoresEstandaresEn(unPartido)+cantidadDeJugadoresCondicionalesEn(unPartido) == unPartido.cantidadJugadoresXpartido)
			return true;
		return false;
	}
	
	public List<Jugadores> getLista()
	{
		return listaCondicionales;
	}
}
