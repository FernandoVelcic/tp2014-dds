package com.grupo10.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import com.grupo10.juego.Participante;

@Observable
public class CriteriosBusqueda {
	
	private String nombre;
	private String apodo;
	private String fecha;
	private Integer handicapDesde;
	private Integer handicapHasta;
	private Double promedioDesde;
	private Double promedioHasta;
	private boolean tieneInfracciones;
	private boolean noTieneInfracciones;

	public CriteriosBusqueda(){
		inicializarValores();
	}
	
	public List<Participante> searchJugadores(List<Participante> participantes) {
		return participantes.stream().filter(participante -> coincideValores(participante)).collect(Collectors.toList());
	}

	private boolean coincideValores(Participante participante) {
		return
				nombreComienzaCon(participante) && apodoContiene(participante) &&
				(fecha == null || participante.getFechaNacimiento().isBefore(LocalDate.parse(this.fecha))) &&
				(participanteTieneInfracciones(participante) ||
				participanteNoTieneInfracciones(participante)) &&
				(handicapDesde == null || esMenorOIgualQue(this.handicapDesde.doubleValue(), participante.getHandicap().doubleValue())) &&
				(handicapHasta == null || esMayorOIgualQue(this.handicapHasta.doubleValue(), participante.getHandicap().doubleValue())) &&
				(promedioDesde == null || esMenorOIgualQue(this.promedioDesde.doubleValue(), participante.getPromedio())) &&
				(promedioHasta == null || esMayorOIgualQue(this.promedioHasta.doubleValue(), participante.getPromedio()));		
	}
	
	private void inicializarValores(){
		this.apodo = "";
	}
	
	private boolean participanteTieneInfracciones(Participante participante){
		return this.tieneInfracciones == (participante.getInfracciones().size() > 0);
	}
	
	private boolean participanteNoTieneInfracciones(Participante participante){
		return this.noTieneInfracciones == (participante.getInfracciones().size() == 0);
	}
	
	private boolean esMenorOIgualQue(Double valorIngresado, Double valorReal){
		return valorIngresado <= valorReal;
	}
	
	private boolean esMayorOIgualQue(Double valorIngresado, Double valorReal){
		return valorIngresado >= valorReal;
	}
	
	private boolean nombreComienzaCon(Participante participante){
		return this.nombre == null || participante.getNombre().toLowerCase().startsWith(this.nombre.toLowerCase());
	}
	
	private boolean apodoContiene(Participante participante){
		return participante.getApodo().toLowerCase().contains(this.apodo.toLowerCase());
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

	public Double getPromedioDesde() {
		return promedioDesde;
	}

	public void setPromedioDesde(Double promedioDesde) {
		this.promedioDesde = promedioDesde;
	}

	public Double getPromedioHasta() {
		return promedioHasta;
	}

	public void setPromedioHasta(Double promedioHasta) {
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