package com.grupo10.ui;

import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;

@Observable
public class HomeViewModel {

	public void generarEquipos(WindowOwner owner) {
		new GenerarEquiposView(owner).open();
	}

	public void busquedaJugadores(WindowOwner owner) {
		new BusquedaJugadoresView(owner).open();
	}

	public void verEquipos(WindowOwner owner) {
		new VerEquiposView(owner).open();
	}
}
