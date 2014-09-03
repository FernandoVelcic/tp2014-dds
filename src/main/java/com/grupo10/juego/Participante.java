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
	
	
	String nombre;
	String apodo;
	Date fechaNacimiento;
	public int handicap;

	Modalidad modalidad;
	Partido partidoActualAjugar;
	
	
	
	public Participante(String nombre, String apodo, Date fechaNacimiento, int handicap, List<Calificacion> calificaciones, List<Infraccion> infracciones, Modalidad modalidad) {
		this.nombre = nombre;
		this.apodo = apodo;
		this.fechaNacimiento = fechaNacimiento;
		this.handicap = handicap;
		this.calificaciones = calificaciones;
		this.infracciones = infracciones;
		this.modalidad = modalidad;
	}
	
	public Participante() {
		// TODO Auto-generated constructor stub
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	
	public Partido getPartidoActual() {
		return partidoActualAjugar;
	}
	
		
	public void setModalidad(Modalidad modalidad) {
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

	public void notificarPartidoConfirmado(){

	}

	public void notificarFaltanJugadores(){
		
	}
	
	public void notificarRechazo(String motivo){
		this.notificaciones.add("Rechazaron tu solicitud por: " + motivo);
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApodo() {
		return apodo;
	}
	
	public Integer getHandicap() {
		return handicap;
	}
	
	public double getPromedio() {
		return calificaciones.stream().mapToDouble(c -> c.puntaje).average().orElse(0);
	}
	
	public double getPromedioActual() {
		return calificaciones.stream().filter(c -> c.partidoJugado == partidoActualAjugar).mapToDouble(c -> c.puntaje).average().orElse(0);
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public List<Infraccion> getInfracciones() {
		return infracciones;
	}

	public void setInfracciones(List<Infraccion> infracciones) {
		this.infracciones = infracciones;
	}

}
