package com.grupo10.ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import com.grupo10.juego.Participante;


public class JugadorView extends Window<JugadorViewModel> {
	
	public JugadorView(WindowOwner owner, Participante jugador) {
		super(owner, new JugadorViewModel(jugador));
	}

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Informacion del jugador: " + getModelObject().getNombre());
		mainPanel.setLayout(new ColumnLayout(2));
		
		new Label(mainPanel).setText("Nombre:");
		new Label(mainPanel).setText(getModelObject().getNombre());
		
		new Label(mainPanel).setText("Apodo:");
		new Label(mainPanel).setText(getModelObject().getApodo());
		
		new Label(mainPanel).setText("Handicap:");
		new Label(mainPanel);
		
		new Label(mainPanel).setText("Promedio del ultimo partido:");
		new Label(mainPanel);
		
		new Label(mainPanel).setText("Promedio de todos los partidos que jugo:");
		new Label(mainPanel);
		
		new Label(mainPanel).setText("Fecha de nacimiento:");
		new Label(mainPanel);
		
		new Label(mainPanel).setText("Amigos:");
		new Label(mainPanel).setText("Infracciones:");
		//Lista o cantidad?
		new List(mainPanel);
		new List(mainPanel);
		
		new Label(mainPanel).setText("Cantidad de partidos que jugo:");
		new Label(mainPanel);
		
		new Button(mainPanel)
			.setCaption("Volver")
			.onClick(() -> this.close());
	}

}
