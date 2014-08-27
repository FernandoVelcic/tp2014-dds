package com.grupo10.juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.uqbar.commons.utils.Observable;

import com.grupo10.excepciones.CalificacionException;
import com.grupo10.modalidades.Modalidad;

@Observable
public class Participante implements Observador {
	public List<Participante> amigos = new ArrayList<Participante>();
	public List<Infraccion> infracciones = new ArrayList<Infraccion>();
	public List<String> notificaciones = new ArrayList<String>();
	public List<Calificacion> calificaciones = new ArrayList<Calificacion>();
	public int handicap;
	
	String nombre;
	Date fechaNacimiento;
	Modalidad modalidad;
	Partido partidoActualAjugar;
	String apodo;
	
	public Participante(String nombre, String apodo, Date fechaNacimiento, int handicap, List<Calificacion> calificaciones, List<Infraccion> infracciones) {
		this.nombre = nombre;
		this.apodo = apodo;
		this.fechaNacimiento = fechaNacimiento;
		this.handicap = handicap;
		this.calificaciones = calificaciones;
		this.infracciones = infracciones;
	}
	
	public Participante() {
		// TODO Auto-generated constructor stub
	}

	public List<Calificacion> getCalificaciones()
	{
		return calificaciones;
	}
	
	public List<Integer> getNotaCalificaciones()
	{
		List<Integer> puntajes = new ArrayList<Integer>();
		calificaciones.forEach(c -> puntajes.add(c.puntaje));
		return puntajes;
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
	
	public String getNombre() {
		return nombre;
	}

	public String getApodo() {
		return apodo;
	}
}
