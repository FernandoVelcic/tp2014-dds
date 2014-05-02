package com.grupo10;

import java.util.Date;

public class Administrador {
	Partido CrearPartido(Date datetime) {
		return new Partido(datetime);
	}
	
	void GenerarEquiposTentativos(Partido partido)
	{
		partido.GenerarEquipos();
	}
	
	void ConfirmarEquipos(Partido partido)
	{
		partido.ConfirmarEquipos();
	}
}
