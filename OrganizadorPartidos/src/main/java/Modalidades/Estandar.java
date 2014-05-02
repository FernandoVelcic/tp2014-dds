package Modalidades;

import com.grupo10.Partido;

public class Estandar implements Modalidad {

	public Estandar() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPrioridad() {
		return 0;
	}

	@Override
	public boolean isPuedeJugar(Partido partido) {
		return true;
	}

}
