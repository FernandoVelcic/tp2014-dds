package com.grupo10.ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import com.grupo10.juego.Participante;


public class JugadorView extends Window<JugadorViewModel> {
	private Participante jugador;
	
	public JugadorView(WindowOwner owner, Participante jugador) {
		super(owner, new JugadorViewModel());
		this.jugador = jugador;
	}

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Informacion del jugador: " + jugador.getNombre());
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("Nombre");
		new Label(mainPanel).setText("Apodo");
		new Label(mainPanel).setText("Handicap");
		new Label(mainPanel).setText("Promedio del ultimo partido");
		new Label(mainPanel).setText("Promedio de todos los partidos que jugo");
		new Label(mainPanel).setText("Fecha de nacimiento");
		new Label(mainPanel).setText("Amigos");
		new Label(mainPanel).setText("Infracciones");
		new Label(mainPanel).setText("Cantidad de partidos que jugo");
		
		new Button(mainPanel)
			.setCaption("Volver")
			.onClick(() -> this.close());
	}

}
