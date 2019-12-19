package escola.programacao.modelo;

public enum TipoCurso {

	PROGRAMACAO("Programação"),
	LOGICA("Lógica"),
	ALGORITMO("Algorítmo");

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
