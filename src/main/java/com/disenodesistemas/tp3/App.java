package com.disenodesistemas.tp3;

import java.util.ArrayList;
import java.util.Collection;
import com.disenodesistemas.tp3.criterios.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	NPuntos nPuntos = new NPuntos(2);
        Regla3Simple regla3simple = new Regla3Simple();
        ConversionPorPuntos convPuntos = new ConversionPorPuntos();
        Collection <TipoCalculoNota> conjCriterios = new ArrayList <TipoCalculoNota>();
        conjCriterios.add(nPuntos);
        conjCriterios.add(regla3simple);
        conjCriterios.add(convPuntos);
        CriteriosNotaMasAlta critNotaAlta = new CriteriosNotaMasAlta(conjCriterios);
        CriteriosPorPromedio critPromedio = new CriteriosPorPromedio(conjCriterios);
        
        Parcial parcialNPuntos = new Parcial(nPuntos);
        Parcial parcialRegla3Simple = new Parcial(regla3simple);
        Parcial parcialConvPuntos = new Parcial(convPuntos);
        Parcial parcialNotaAlta = new Parcial(critNotaAlta);
        Parcial parcialPromedio = new Parcial(critPromedio);
        
        Pregunta pregunta1 = new Pregunta(5, true);
        Pregunta pregunta2 = new Pregunta(2, true);
        Pregunta pregunta3 = new Pregunta(4, true);
        Pregunta pregunta4 = new Pregunta(7, false);
        Pregunta pregunta5 = new Pregunta(8, false);
        
        parcialNPuntos.agregarPregunta(pregunta1);
        parcialRegla3Simple.agregarPregunta(pregunta1);
        parcialConvPuntos.agregarPregunta(pregunta1);
        parcialNotaAlta.agregarPregunta(pregunta1);
        parcialPromedio.agregarPregunta(pregunta1);
        parcialNPuntos.agregarPregunta(pregunta2);
        parcialRegla3Simple.agregarPregunta(pregunta2);
        parcialConvPuntos.agregarPregunta(pregunta2);
        parcialNotaAlta.agregarPregunta(pregunta2);
        parcialPromedio.agregarPregunta(pregunta2);
        parcialNPuntos.agregarPregunta(pregunta3);
        parcialRegla3Simple.agregarPregunta(pregunta3);
        parcialConvPuntos.agregarPregunta(pregunta3);
        parcialNotaAlta.agregarPregunta(pregunta3);
        parcialPromedio.agregarPregunta(pregunta3);
        parcialNPuntos.agregarPregunta(pregunta4);
        parcialRegla3Simple.agregarPregunta(pregunta4);
        parcialConvPuntos.agregarPregunta(pregunta4);
        parcialNotaAlta.agregarPregunta(pregunta4);
        parcialPromedio.agregarPregunta(pregunta4);
        parcialNPuntos.agregarPregunta(pregunta5);
        parcialRegla3Simple.agregarPregunta(pregunta5);
        parcialConvPuntos.agregarPregunta(pregunta5);
        parcialNotaAlta.agregarPregunta(pregunta5);
        parcialPromedio.agregarPregunta(pregunta5);
        
        System.out.println("La nota para parcialNPuntos es: " + parcialNPuntos.nota());
        System.out.println("La nota para parcialRegla3Simple es: " + parcialRegla3Simple.nota());
        System.out.println("La nota para parcialConvPuntos es: " + parcialConvPuntos.nota());
        System.out.println("La nota para parcialNotaAlta es: " + parcialNotaAlta.nota());
        System.out.println("La nota para parcialPromedio es: " + parcialPromedio.nota());
    }
}
