package com.disenodesistemas.tp3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.*;
import java.util.Iterator;

public class Parcial {

	public Collection <Pregunta> preguntas;
	TipoCalculoNota tipoCorreccion;
	
	
	public Parcial(TipoCalculoNota tCorreccion)
	{
		this.preguntas = new ArrayList <Pregunta>();
		tipoCorreccion = tCorreccion;
	}
	public void agregarPregunta(Pregunta pregunta)
	{
		preguntas.add(pregunta);
	}
	public int sumaPreguntasCorrectas()
	{
		int suma = 0;
		Collection <Pregunta> preguntasCorrectas;
		preguntasCorrectas = preguntas.stream().filter(pregunta -> pregunta.esCorrecta).collect(Collectors.toCollection(ArrayList::new));
		Iterator <Pregunta> itPC = preguntasCorrectas.iterator();
		while (itPC.hasNext())
		{
			Pregunta pregunta = itPC.next();
			suma += pregunta.pesoEspecifico;
		}
		return suma;
	}
	public int sumaPreguntasTotales()
	{
		int suma = 0;
		Iterator <Pregunta> itPT = preguntas.iterator();
		while (itPT.hasNext())
		{
			Pregunta pregunta = itPT.next();
			suma += pregunta.pesoEspecifico;
		}
		return suma;
	}
	
	public float getNota()
	{
		return tipoCorreccion.calcularNota(this);
	}
	
}