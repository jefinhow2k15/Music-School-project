package escola.programacao.modelo;

public enum TipoCurso {

	PROGRAMACAO("Programa��o"),
	LOGICA("L�gica"),
	ALGORITMO("Algor�tmo");

	private String label;
	
	private TipoCurso(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
