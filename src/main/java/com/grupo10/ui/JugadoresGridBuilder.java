package com.grupo10.ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;

import com.grupo10.juego.Participante;

public class JugadoresGridBuilder {
	public void createResultsGrid(Panel mainPanel, String propertyName, boolean bindProperty) {
		Table<Participante> table = new Table<Participante>(mainPanel, Participante.class);
		table.setHeigth(200);
		table.setWidth(600);

		table.bindItemsToProperty(propertyName);
		if(bindProperty)
			table.bindValueToProperty("participanteSeleccionado");

		this.describeResultsGrid(table);
	}
	
	protected void describeResultsGrid(Table<Participante> table) {
		new Column<Participante>(table)
			.setTitle("Nombre")
			.setFixedSize(150)
			.bindContentsToProperty("nombre")
			.bindBackground("handicap", new HandicapMayorA8X());

		new Column<Participante>(table)
			.setTitle("Apodo")
			.setFixedSize(100)
			.bindContentsToProperty("apodo");
		
		new Column<Participante>(table)
			.setTitle("Handicap")
			.setFixedSize(100)
			.bindContentsToProperty("handicap");
		
		new Column<Participante>(table)
			.setTitle("Promedio")
			.setFixedSize(100)
			.bindContentsToProperty("promedio");
		/*
		new Column<Participante>(table)
			.setTitle("Fecha Nacimiento")
			.setFixedSize(150)
			.bindContentsToProperty("fechaNacimiento");*/
	}
}
