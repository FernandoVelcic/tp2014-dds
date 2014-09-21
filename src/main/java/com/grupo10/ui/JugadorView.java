package com.grupo10.ui;

import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import com.grupo10.juego.Participante;


public class JugadorView extends Window<Participante> {
	public JugadorView(WindowOwner owner, Participante participante) {
		super(owner, participante);
	}

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Informacion del jugador: " + getModelObject().getNombre());
		
		Panel infoPanel = new Panel(mainPanel);		
		infoPanel.setLayout(new ColumnLayout(2));
		
		new Label(infoPanel).setText("Nombre:");
		new Label(infoPanel).bindValueToProperty("nombre");
		
		new Label(infoPanel).setText("Apodo:");
		new Label(infoPanel).bindValueToProperty("apodo");
		
		new Label(infoPanel).setText("Handicap:");
		new Label(infoPanel).bindValueToProperty("handicap");
		
		new Label(infoPanel).setText("Promedio del ultimo partido:");
		new Label(infoPanel).bindValueToProperty("promedioActual");
		
		new Label(infoPanel).setText("Promedio de todos los partidos que jugo:");
		new Label(infoPanel).bindValueToProperty("promedio");
		
		new Label(infoPanel).setText("Fecha de nacimiento:");
		new Label(infoPanel).bindValueToProperty("fechaNacimiento");
		
		new Label(infoPanel).setText("Cantidad de partidos que jugo:");
		new Label(infoPanel).bindValueToProperty("cantidadPartidosJugados");

		new Label(mainPanel).setText("Amigos:");
		new JugadoresGridBuilder().createResultsGrid(mainPanel, "amigos", false);
		
		new Label(mainPanel).setText("Infracciones:");
		new InfraccionesGridBuilder().createResultsGrid( mainPanel, "infracciones");
		
		new Button(mainPanel)
			.setCaption("Volver")
			.onClick(() -> this.close());
		
	}

}
