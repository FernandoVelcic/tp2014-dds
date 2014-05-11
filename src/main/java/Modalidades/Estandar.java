package Modalidades;

import com.grupo10.Partido;

public class Estandar implements Modalidad {
	@Override
	public int getPrioridad() {
		return 0;
	}

	@Override
	public boolean isPuedeJugar(Partido partido) {
		return true;
	}

}
