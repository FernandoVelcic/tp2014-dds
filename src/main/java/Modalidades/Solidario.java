package Modalidades;

import com.grupo10.Partido;

public class Solidario implements Modalidad {
	@Override
	public Integer getPrioridad() {
		return Prioridad.SOLIDARIO.ordinal();
	}

	@Override
	public boolean isPuedeJugar(Partido partido) {
		return false;
	}

}
