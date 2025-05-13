package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Pregunta {
	private static final int CANTIDADOPCIONES = 4;	//Constante para marcar cuantas opciones habra
	private String enunciado;						//Enunciado de la pregunta
	private List<String> opciones;					//Las 4 opciones posibles
	private int indiceCorrecta;						//Indice de la opcion correcta

	//Constructor
	public Pregunta(String _enunciado, List<String> _opciones, int _indiceCorrecta) {
		if (_opciones.size() != CANTIDADOPCIONES)
			throw new IllegalArgumentException("ERROR. Deben haber 4 opciones.");
		this.enunciado = _enunciado;
		this.opciones = new ArrayList<String> (_opciones);
		this.indiceCorrecta = _indiceCorrecta;
	}
	
	//Metodos Get y Set
	public String getEnunciado() {
		return this.enunciado;
	}

	public void setEnunciado(String _enunciado) {
		this.enunciado = _enunciado;
	}

	public List<String> getOpciones() {
		return this.opciones;
	}

	public void setOpciones(List<String> _opciones) {
		this.opciones = new ArrayList<String> (_opciones);
	}

	public int getIndiceCorrecta() {
		return this.indiceCorrecta;
	}

	public void setIndiceCorrecta(int _indiceCorrecta) {
		this.indiceCorrecta = _indiceCorrecta;
	}
	
	//Metodo para obtener la cadena con la respuesta correcta
	public String getOpcionCorrecta() {
		return this.opciones.get(this.indiceCorrecta);
	}
	
	//Metodos de clase
	//Generar las respuestas en orden aleatorio, manteniendo el indice de la opcion correcta
	public OpcionesAleatorias generarOpcionesAleatorias() {
		List<String> copia = new ArrayList<String>(this.opciones);
		Collections.shuffle(copia);
		int nuevaCorrecta = copia.indexOf(getOpcionCorrecta());
		return new OpcionesAleatorias(copia, nuevaCorrecta);
	}
	
	//Clase auxiliar para devolver opciones aleatorias y tener identificada la opcion correcta
	public static class OpcionesAleatorias {
		public List<String> opciones;
		public int indiceCorrecta;
		
		public OpcionesAleatorias(List<String> _opciones, int _indiceCorrecta) {
			this.opciones = new ArrayList<String>(_opciones);
			this.indiceCorrecta = _indiceCorrecta;
		}
	}
}
