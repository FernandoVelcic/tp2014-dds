package com.grupo10.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import com.grupo10.juego.Participante;

@Observable
public class CriteriosBusqueda {
	
	public String nombre;
	public String apodo;
	public String fecha;
	public Integer handicapDesde;
	public Integer handicapHasta;
	public Integer promedioDesde;
	public Integer promedioHasta;
	public boolean tieneInfracciones;
	public boolean noTieneInfracciones;

	
	public List<Participante> searchJugadores(List<Participante> participantes) {
		return participantes.stream().filter(participante -> coincideValores(participante)).collect(Collectors.toList());
	}

	public boolean coincideValores(Participante participante) {
		return
				nombreComienzaCon(participante) && apodoContiene(participante) &&
				fechaEsMenorA(fecha, participante.getFechaNacimiento()) &&
				(participanteTieneInfracciones(participante) || participanteNoTieneInfracciones(participante)) &&
				isBetween(handicapDesde, handicapHasta, participante.getHandicap().doubleValue()) &&
				isBetween(promedioDesde, promedioHasta, participante.getPromedio());
	}
	
	private boolean participanteTieneInfracciones(Participante participante){
		return this.tieneInfracciones == (participante.getInfracciones().size() > 0);
	}
	
	private boolean participanteNoTieneInfracciones(Participante participante){
		return this.noTieneInfracciones == (participante.getInfracciones().size() == 0);
	}
	
	public boolean fechaEsMenorA(String fecha1, LocalDate fecha2) {
		return fecha1 == null || fecha2.isBefore(LocalDate.parse(fecha1));
	}
	
	private boolean isBetween(Integer desde, Integer hasta, Double valor) {
		if(desde != null && desde > valor) {
			return false;
		}
		
		if(hasta != null && valor > hasta) {
			return false;
		}
		
		return true;
	}
	
	public boolean nombreComienzaCon(Participante participante){
		return this.nombre == null || participante.getNombre().toLowerCase().startsWith(this.nombre.toLowerCase());
	}
	
	public boolean apodoContiene(Participante participante){
		return this.apodo == null || participante.getApodo().toLowerCase().contains(this.apodo.toLowerCase());
	}
	
	public void clear() {
		this.nombre = "";
		this.apodo = "";
		this.fecha = "";
		this.handicapDesde = null;
		this.handicapHasta = null;
		this.promedioDesde = null;
		this.promedioHasta = null;
		this.tieneInfracciones = false;
		this.noTieneInfracciones = false;
	}
	
	/***Getters & Setters***/
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getFechaString() {
		return fecha;
	}

	public void setFechaString(String fechaString) {
		this.fecha = fechaString;
	}

	public Integer getHandicapDesde() {
		return handicapDesde;
	}

	public void setHandicapDesde(Integer handicapDesde) {
		this.handicapDesde = handicapDesde;
	}

	public Integer getHandicapHasta() {
		return handicapHasta;
	}

	public void setHandicapHasta(Integer handicapHasta) {
		this.handicapHasta = handicapHasta;
	}

	public Integer getPromedioDesde() {
		return promedioDesde;
	}

	public void setPromedioDesde(Integer promedioDesde) {
		this.promedioDesde = promedioDesde;
	}

	public Integer getPromedioHasta() {
		return promedioHasta;
	}

	public void setPromedioHasta(Integer promedioHasta) {
		this.promedioHasta = promedioHasta;
	}

	public boolean isTieneInfracciones() {
		return tieneInfracciones;
	}

	public void setTieneInfracciones(boolean tieneInfracciones) {
		this.tieneInfracciones = tieneInfracciones;
	}

	public boolean isNoTieneInfracciones() {
		return noTieneInfracciones;
	}

	public void setNoTieneInfracciones(boolean noTieneInfracciones) {
		this.noTieneInfracciones = noTieneInfracciones;
	}
}