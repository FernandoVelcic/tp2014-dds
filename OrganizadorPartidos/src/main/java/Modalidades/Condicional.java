package Modalidades;

import com.grupo10.Partido;

public class Condicional implements Modalidad {

	public Condicional() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPrioridad() {
		return 1;
	}
	
	@Override
	public boolean isPuedeJugar(Partido partido) {
		return false;
	}

}
