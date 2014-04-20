package com.disenodesistemas.tp3.criterios;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import com.disenodesistemas.tp3.Parcial;
import com.disenodesistemas.tp3.TipoCalculoNota;

public class CriteriosNotaMasAlta implements TipoCalculoNota {

	public Collection <TipoCalculoNota> tipoCalculoNota;
		
	public CriteriosNotaMasAlta(Collection <TipoCalculoNota> tipoCalculoNota)
	{
		this.tipoCalculoNota = tipoCalculoNota;
	}
		
	@Override
	public float calcularNota(Parcial parcial) 
	{
		return Collections.max(tipoCalculoNota.stream().map(tipo -> tipo.calcularNota(parcial)).collect(Collectors.toList()));	
	}
}
