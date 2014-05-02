package Modalidades;

import com.grupo10.Partido;

public class Solidario implements Modalidad {

	public Solidario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPrioridad() {
		return 2;
	}

	@Override
	public boolean isPuedeJugar(Partido partido) {
		return false;
	}

}
