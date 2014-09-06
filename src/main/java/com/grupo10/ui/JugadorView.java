package com.grupo10.ui;

import org.eclipse.core.internal.databinding.conversion.DateToStringConverter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import com.grupo10.juego.Participante;
import com.uqbar.commons.collections.Transformer;


public class JugadorView extends Window<JugadorViewModel> {
	
	public JugadorView(WindowOwner owner, Participante jugador) {
		super(owner, new JugadorViewModel(jugador));
	}

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Informacion del jugador: " + getModelObject().jugador.getNombre());
		
		Panel infoPanel = new Panel(mainPanel);		
		infoPanel.setLayout(new ColumnLayout(2));
		
		new Label(infoPanel).setText("Nombre:");
		new Label(infoPanel).bindValueToProperty("jugador.nombre");
		
		new Label(infoPanel).setText("Apodo:");
		new Label(infoPanel).bindValueToProperty("jugador.apodo");
		
		new Label(infoPanel).setText("Handicap:");
		new Label(infoPanel).bindValueToProperty("jugador.handicap");
		
		new Label(infoPanel).setText("Promedio del ultimo partido:");
		new Label(infoPanel).bindValueToProperty("jugador.promedioActual");
		
		new Label(infoPanel).setText("Promedio de todos los partidos que jugo:");
		new Label(infoPanel).bindValueToProperty("jugador.promedio");
		
		new Label(infoPanel).setText("Fecha de nacimiento:");
		new Label(infoPanel).bindValueToProperty("fechaNacimiento");
		
		new Label(infoPanel).setText("Cantidad de partidos que jugo:");
		new Label(infoPanel);

		new Label(mainPanel).setText("Amigos:");
		new JugadoresGrid().createResultsGrid(this, mainPanel, "jugador.amigos");
		
		new Label(mainPanel).setText("Infracciones:");
		
		
		new Button(mainPanel)
			.setCaption("Volver")
			.onClick(() -> this.close());
	}

}
