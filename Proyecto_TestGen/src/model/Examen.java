package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Examen {
	//Constantes
	private static final int CERO = 0;
	private static final int NORESPONDIDO = -1;
	private static final int CANTIDADOPCIONES = 4;
	//Atributos
	private List<Pregunta> preguntas;						//Preguntas del examen
	private List<Pregunta.OpcionesAleatorias> pregrandom;	//Preguntas aleatorizadas
	private List<Integer> respuestasUser;					//Respuestas del examinado
	
	//Constructor
	public Examen(List<Pregunta> _preguntas, int cantidadPreguntas) {
		//Comprueba si me esta pidiendo hacer un examen de mas preguntas de las que tenemos registradas
		if(_preguntas.size() < cantidadPreguntas)
			throw new IllegalArgumentException("ERROR. No hay suficientes preguntas. No puedo crear un examen de " + cantidadPreguntas + " preguntas con " + _preguntas.size() + " preguntas guardadas.");
		
		//Crea una copia de las preguntas
		List<Pregunta> copia = new ArrayList<Pregunta>(_preguntas);
		//Las reordena
		Collections.shuffle(copia);
		//Selecciona las cantidadPreguntas primeras preguntas
		this.preguntas = copia.subList(CERO, cantidadPreguntas);
		
		//Inicializa la lista de preguntas aleatorizadas
		this.pregrandom = new ArrayList<>();
		//Anhade las preguntas aleatorizadas
		for (Pregunta p : this.preguntas) {
			this.pregrandom.add(p.generarOpcionesAleatorias());
		}
		
		//Inicializa todas las respuestas del examinado a -1
		this.respuestasUser = new ArrayList<>(Collections.nCopies(cantidadPreguntas, NORESPONDIDO));
	}
	
	//Metodos Get y Set
	public Pregunta getPregunta(int index) {
		return this.preguntas.get(index);
	}
	
	public List<Pregunta> getPreguntas() {
		return new ArrayList<Pregunta>(this.preguntas);
	}
	
	public Pregunta.OpcionesAleatorias getOpcionesAleatorias(int index) {
        return this.pregrandom.get(index);
    }
	
	public List<Pregunta.OpcionesAleatorias> getAllOpcionesAleatorias() {
		return new ArrayList<Pregunta.OpcionesAleatorias>(this.pregrandom);
	}
	
	public void responder(int indexPregunta, int opcionElegida) {
        this.respuestasUser.set(indexPregunta, opcionElegida);
    }
	
	public Integer getRespuestaUsuario(int index) {
        return this.respuestasUser.get(index);
    }
	
	public int getCantidadPreguntas() {
        return this.preguntas.size();
    }
	
	//Metodos
	//Metodo corregirExamen(). Devuelve el numero de respuestas correctas del examen
	public int corregirExamen() {
		//Variables auxiliares
		int correctas = CERO;			//Contador de respuestas correctas
		int elegida = NORESPONDIDO;		//Indice de la respuesta elegida
		int correcta = NORESPONDIDO;	//Indice de la respuesta correcta
		
		//Recorre las preguntas
		for(int i = CERO; i < this.getCantidadPreguntas(); i++) {
			//Obtiene la respuesta elegida por el examinado
			elegida = this.getRespuestaUsuario(i);
			//Obtiene la respuesta correcta de la pregunta
			correcta = this.getAllOpcionesAleatorias().get(i).getIndiceCorrecta();
			//Suma 1 al contador de las correctas si la respuesta elegida es la correcta
			if (elegida == correcta) correctas++;
		}
		
		//Devuelve el contador de respuestas correctas
		return correctas;
	}
	
	//Metodo generarResultados(). 
	public List<Resultado> generarResultados() {
		//Lista a guardar los resultados
		List<Resultado> resultados = new ArrayList<>();
		//Variables auxiliares
		Pregunta p = null;
		Pregunta.OpcionesAleatorias oa = null;
		int elegida = NORESPONDIDO;
		int correcta = NORESPONDIDO;
		String opcionUsuario = null;
		String opcionCorrecta = null;
		boolean acierto = false;
		
		//Recorre las preguntas
		for(int i = CERO; i < this.getPreguntas().size(); i++) {
			//Obtiene la siguiente pregunta
			p = this.getPreguntas().get(i);
			//Aleatoriza las respuestas de la pregunta actual
			oa = p.generarOpcionesAleatorias();
			//Si el usuario ha respondido, la respuesta elegida tendra un valor de las opciones.
			//Si no, se pone "No respondida" 
			opcionUsuario = elegida >= CERO && elegida < CANTIDADOPCIONES ? oa.getOpciones().get(elegida) : "No respondida";
			//Se obtiene el valor de la respuesta correcta
			opcionCorrecta = oa.getOpciones().get(correcta);
			//Se comprueba si es un acierto
			acierto = elegida == correcta;
			
			//Se anhade el resultado obtenido
			resultados.add(new Resultado(p.getEnunciado(), opcionCorrecta, opcionUsuario, acierto));
		}
		//Devuelve los resultados obtenidos
		return resultados;
	}
}
