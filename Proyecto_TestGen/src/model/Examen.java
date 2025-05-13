package model;

import java.util.List;

public class Examen {
	//Atributos
	private List<Pregunta> preguntas;						//Preguntas del examen
	private List<Pregunta.OpcionesAleatorias> pregrandom;	//Preguntas aleatorizadas
	private List<Integer> respuestasUser;					//Respuestas del examinado
	
	//Constructor
	public Examen(List<Pregunta> _preguntas, int cantidadPreguntas) {
		if(_preguntas.size() < cantidadPreguntas)
			throw new IllegalArgumentException("ERROR. No hay suficientes preguntas. No puedo crear un examen de " + cantidadPreguntas + " preguntas con " + _preguntas.size() + " preguntas guardadas.");
	}
}
