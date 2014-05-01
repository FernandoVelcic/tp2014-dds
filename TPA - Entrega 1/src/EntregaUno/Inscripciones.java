package EntregaUno;

import java.util.List;
import java.util.stream.Stream;

//TENGO QUE CREAR UN METODO PARA FILTRAR LAS LISTAS ASI NO REPITO TANTO EL CÓDIGO.

public abstract class Inscripciones {
	public List<Jugadores> listaEstandar;
	public List<Jugadores> listaSolidaria; 
	public List<Jugadores> listaCondicionales;
	
	public void agregarAlista(Jugadores unJugador, Partido unPartido)
	{
		
	}
	
	public int cantidadDeJugadoresEstandaresEn(Partido unPartido)
	{
		Stream<Jugadores> jugadoresEnPartido = listaEstandar.stream().filter(jugador -> jugador.compararPartidos(unPartido));
		return (int)jugadoresEnPartido.count();
	}
	
	public int cantidadDeJugadoresSolidariosEn(Partido unPartido)
	{
		Stream<Jugadores> jugadoresEnPartido = listaSolidaria.stream().filter(jugador -> jugador.compararPartidos(unPartido));
		return (int)jugadoresEnPartido.count();
	}
	
	public int cantidadDeJugadoresCondicionalesEn(Partido unPartido)
	{
		Stream<Jugadores> jugadoresEnPartido = listaCondicionales.stream().filter(jugador -> jugador.compararPartidos(unPartido));
		return (int)jugadoresEnPartido.count();
	}
	
	public List<Jugadores> getListaEstandarDe(Partido unPartido)
	{
		Stream<Jugadores> jugadoresEnPartido = listaEstandar.stream().filter(jugador -> jugador.compararPartidos(unPartido));
		return (List<Jugadores>) jugadoresEnPartido;
	}
	
	public List<Jugadores> getListaSolidariosDe(Partido unPartido)
	{
		Stream<Jugadores> jugadoresEnPartido = listaSolidaria.stream().filter(jugador -> jugador.compararPartidos(unPartido));
		return (List<Jugadores>) jugadoresEnPartido;
	}
	
	public List<Jugadores> getListaCondicionalesDe(Partido unPartido)
	{
		Stream<Jugadores> jugadoresEnPartido = listaCondicionales.stream().filter(jugador -> jugador.compararPartidos(unPartido));
		return (List<Jugadores>) jugadoresEnPartido;
	}
	

}
