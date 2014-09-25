package com.grupo10.criteriosordenequipos;

import java.util.ArrayList;
import java.util.List;
import com.grupo10.juego.Participante;

public class MixCriterios implements CriterioOrden 
{

	private List<CriterioOrden> mix = new ArrayList<CriterioOrden>();

	public void add(CriterioOrden criterio){
		if (criterio != null) {
			mix.add(criterio);
		}
	}
	
	public double calcularValor(Participante participante) {
		return mix.stream().mapToDouble(c -> c.calcularValor(participante)).average().getAsDouble();		
	}

	public List<CriterioOrden> getMix() {
		return mix;
	}

	public void setMix(List<CriterioOrden> mix) {
		this.mix = mix;
	}
	
	
}
