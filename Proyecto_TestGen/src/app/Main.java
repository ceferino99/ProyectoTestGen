package app;

import java.util.List;

import model.Examen;
import model.Pregunta;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> op1 = List.of("Barcelona","Madrid","Valencia","Murcia");
		List<String> op2 = List.of("1","2","3","4");
		Pregunta p1 = new Pregunta("¿Cual es la capital de España?", op1, 1);
		Pregunta p2 = new Pregunta("¿Cuánto es 2+2?", op2, 3);
		List<Pregunta> preguntas = List.of(p1,p2);
		Examen e = new Examen(preguntas, 2);
		Pregunta.OpcionesAleatorias oprandom = p1.generarOpcionesAleatorias();
		System.out.println("Pregunta: " + p1.getEnunciado());
		for(int i = 0; i < oprandom.getOpciones().size(); i++) {
			System.out.println((char)('A'+i) + ") " + oprandom.getOpciones().get(i));
		}
		System.out.println("La respuesta correcta es: " + (char)('A'+oprandom.getIndiceCorrecta()) + ") " + oprandom.getOpciones().get(oprandom.getIndiceCorrecta()));
	}

}
