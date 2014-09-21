package com.grupo10.ui;

import com.uqbar.commons.collections.Transformer;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;

import com.grupo10.juego.Infraccion;
import com.grupo10.juego.Participante;

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
			.bindContentsToTransformer(new Transformer<Infraccion, String>() {
				@Override
				public String transform(Infraccion infraccion) {
					return new DateToStringTransformer().convertirFechaAString(infraccion.getDate());
				}
			});
		
		new Column<Infraccion>(table)
			.setTitle("Motivo")
			.bindContentsToProperty("motivo");
	}
}
