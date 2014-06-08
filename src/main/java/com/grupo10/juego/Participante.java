package com.grupo10.juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


import com.grupo10.excepciones.CalificacionException;
import com.grupo10.modalidades.Modalidad;


public class Participante implements Observador {
	public List<Participante> amigos = new ArrayList<Participante>();
	public List<Infraccion> infracciones = new ArrayList<Infraccion>();
	public List<String> notificaciones = new ArrayList<String>();
	public List<Calificacion> calificaciones = new ArrayList<Calificacion>();
	
	String nombre;
	Date fechaNacimiento;
	Modalidad modalidad;
	Partido partidoActualAjugar;
	
	public List<Calificacion> getCalificaciones()
	{
		return calificaciones;
	}
	
	public Partido getPartidoActual()
	{
		return partidoActualAjugar;
	}
	
		
	public void setModalidad(Modalidad modalidad){
		this.modalidad = modalidad;
	}
	
	public int getPrioridadModalidad() {
		return modalidad.getPrioridad();
	}
	
	public boolean getPuedeJugar(Partido partido) {
		return modalidad.isPuedeJugar(partido);
	}
	
	public void agregarAmigo(Participante participante){
		amigos.add(participante);
	}
	
	public void hacerInfraccion(String motivo){
		infracciones.add(new Infraccion(motivo));
	}
	
	public void notificarAamigos(){
		amigos.forEach(amigo -> amigo.notificaciones.add(this +" se inscribió"));
	}
	
	public void calificar(Participante jugador, Calificacion calificacion) throws Exception
	{
		if ((jugador.equals(this)) || (this.partidoActualAjugar != jugador.partidoActualAjugar)) throw new CalificacionException("No se puede calificar");
		else jugador.calificaciones.add(calificacion);
	}

	@Override
	public void notificarPartidoConfirmado(){

	}

	@Override
	public void notificarFaltanJugadores(){
		
	}
	
	@Override
	public void notificarRechazo(String motivo){
		this.notificaciones.add("Rechazaron tu solicitud por: " + motivo);
	}
}
