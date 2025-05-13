package model;

public class Resultado {
	//Atributos
	private String enunciado;
	private String opcionCorecta;
	private String opcionUsuario;
	private boolean esCorrecta;
	
	//Constructor
	public Resultado(String _enunciado, String _opcionCorrecta, String _opcionUsuario, boolean _esCorrecta) {
		this.enunciado = _enunciado;
		this.opcionCorecta = _opcionCorrecta;
		this.opcionUsuario = _opcionUsuario;
		this.esCorrecta = _esCorrecta;
	}

	//Metodos Get y Set
	public String getEnunciado() {
		return this.enunciado;
	}

	public String getOpcionCorecta() {
		return this.opcionCorecta;
	}

	public String getOpcionUsuario() {
		return this.opcionUsuario;
	}

	public boolean esCorrecta() {
		return this.esCorrecta;
	}
}
