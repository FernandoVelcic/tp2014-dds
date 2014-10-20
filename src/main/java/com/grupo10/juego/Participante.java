package com.grupo10.juego;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.uqbar.commons.utils.Observable;

import com.grupo10.excepciones.CalificacionException;
import com.grupo10.modalidades.Modalidad;

@Entity
@Observable
public class Participante implements Observador {
	@Id @GeneratedValue
	private Long id;
	
	@Transient
	public List<Participante> amigos = new ArrayList<Participante>();
	@Transient
	public List<Infraccion> infracciones = new ArrayList<Infraccion>();
	
	@Transient
	public List<String> notificaciones = new ArrayList<String>();
	@Transient
	public List<Calificacion> calificaciones = new ArrayList<Calificacion>();
	
	public int cantidadPartidosJugados = 0;
	public int handicap;
	public String nombre;
	public String apodo;
	public LocalDate fechaNacimiento;
	@Transient
	public Modalidad modalidad;
	@ManyToOne
	public Partido partidoActualAjugar;
	
	public Participante(String nombre, String apodo, LocalDate fechaNacimiento, int handicap, List<Calificacion> calificaciones, List<Infraccion> infracciones, Modalidad modalidad) {
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
	
	public Double getPromedio() {
		return calificaciones.stream().mapToDouble(c -> c.puntaje).average().orElse(0);
	}
	
	public Double getPromedioActual() {
		return calificaciones.stream().filter(c -> c.partidoJugado == partidoActualAjugar).mapToDouble(c -> c.puntaje).average().orElse(0);
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public List<Infraccion> getInfracciones() {
		return infracciones;
	}

	public void setInfracciones(List<Infraccion> infracciones) {
		this.infracciones = infracciones;
	}
	
	public List<Participante> getAmigos() {
		return amigos;
	}
	
	public int getCantidadPartidosJugados() {
		return cantidadPartidosJugados;
	}

	public void setCantidadPartidosJugados(int cantidadPartidosJugados) {
		this.cantidadPartidosJugados = cantidadPartidosJugados;
	}

}
