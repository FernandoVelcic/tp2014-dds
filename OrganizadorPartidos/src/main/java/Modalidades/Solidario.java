package Modalidades;

import com.grupo10.Partido;

public class Solidario implements Modalidad {
	@Override
	public int getPrioridad() {
		return 2;
	}

	@Override
	public boolean isPuedeJugar(Partido partido) {
		return false;
	}

}
