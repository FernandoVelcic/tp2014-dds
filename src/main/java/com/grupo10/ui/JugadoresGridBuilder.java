package com.grupo10.ui;

import com.uqbar.commons.collections.Transformer;

import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;

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
		
		new Column<Participante>(table)
			.setTitle("Fecha Nacimiento")
			.setFixedSize(150)
			.bindContentsToTransformer(new Transformer<Participante, String>() {
				@Override
				public String transform(Participante participante) {
					return new DateToStringTransformer().convertirFechaAString(participante.getFechaNacimiento());
				}
			});
	}
}
