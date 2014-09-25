package com.grupo10.ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import com.grupo10.juego.Infraccion;

public class InfraccionesGridBuilder {
	public void createResultsGrid(Panel mainPanel, String propertyName) {
		Table<Infraccion> table = new Table<Infraccion>(mainPanel, Infraccion.class);
		table.setHeigth(200);
		table.setWidth(600);

		table.bindItemsToProperty(propertyName);

		this.describeResultsGrid(table);
	}
	
	protected void describeResultsGrid(Table<Infraccion> table) {
		new Column<Infraccion>(table)
			.setTitle("Fecha")
			.setFixedSize(150)
			.bindContentsToProperty("date");
		
		new Column<Infraccion>(table)
			.setTitle("Motivo")
			.bindContentsToProperty("motivo");
	}
}
