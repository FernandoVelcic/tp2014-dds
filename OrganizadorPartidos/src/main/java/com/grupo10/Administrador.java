package com.grupo10;

import java.util.Date;

public class Administrador {
	public Partido CrearPartido(Date datetime) {
		return new Partido(datetime);
	}
	
	public void GenerarEquiposTentativos(Partido partido)
	{
		partido.GenerarEquipos();
	}
	
	public void ConfirmarEquipos(Partido partido)
	{
		partido.ConfirmarEquipos();
	}
}
