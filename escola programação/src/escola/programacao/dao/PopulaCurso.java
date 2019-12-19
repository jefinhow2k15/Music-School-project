package escola.programacao.dao;
	
	

	import javax.persistence.EntityManager;

	import escola.programacao.modelo.Curso;
	import escola.programacao.modelo.TipoCurso;

	public class PopulaCurso {

		public static void main(String[] args) {
			
			EntityManager em = Util.getEntityManager();
			em.getTransaction().begin();
			
			Curso java = geraCurso("Java", getDescricao(), 4, TipoCurso.LOGICA);
			Curso c = geraCurso("C", getDescricao(), 4, TipoCurso.LOGICA);
			Curso typescript = geraCurso("TypeScript", getDescricao(), 4, TipoCurso.LOGICA);
			Curso cplusplus = geraCurso("C++", getDescricao(), 4, TipoCurso.LOGICA);
			Curso pearl = geraCurso("Pearl", getDescricao(), 4, TipoCurso.LOGICA);
			Curso javascript = geraCurso("JavaScript", getDescricao(), 4, TipoCurso.ALGORITMO);
			Curso html = geraCurso("HTML", getDescricao(), 5, TipoCurso.ALGORITMO);
			Curso css = geraCurso("CSS", getDescricao(), 5, TipoCurso.PROGRAMACAO);
			Curso php = geraCurso("PHP", getDescricao(), 6, TipoCurso.PROGRAMACAO);
			Curso python = geraCurso("Python", getDescricao(), 6, TipoCurso.PROGRAMACAO);
			Curso delphi = geraCurso("Delphi", getDescricao(), 6, TipoCurso.PROGRAMACAO);
			Curso nodejs = geraCurso("NodeJS", getDescricao(), 6, TipoCurso.ALGORITMO);
			
			em.persist(java);
			em.persist(c);
			em.persist(typescript);
			em.persist(cplusplus);
			em.persist(pearl);
			em.persist(javascript);
			em.persist(html);
			em.persist(css);
			em.persist(php);
			em.persist(python);
			em.persist(delphi);
			em.persist(nodejs);
			
			
			em.getTransaction().commit();
			em.close();
		}
		
		private static String getDescricao() {
			return "Exemplo de Descrição";
		}

		public static Curso geraCurso(String nome, String descricao, double duracao, TipoCurso tipo){
			Curso curso = new Curso();
			curso.setNome(nome);
			curso.setDescricao(descricao);
			curso.setDuracao(duracao);
			curso.setTipo(tipo);
			return curso;
		}
		
}
