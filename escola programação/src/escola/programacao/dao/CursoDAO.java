package escola.programacao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import escola.programacao.modelo.Curso;

public class CursoDAO {

	public void salvar(Curso curso) {
		EntityManager entityManager = Util.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(curso);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Curso> listarTodos() {
		EntityManager entityManager = Util.getEntityManager();

		return entityManager.createQuery("from Curso").getResultList();

	}

	public void excluir(Curso curso) {
		EntityManager entityManager = Util.getEntityManager();

		entityManager.getTransaction().begin();

		curso = entityManager.merge(curso);

		entityManager.remove(curso);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

	@SuppressWarnings("unchecked")
	public static List<Curso> listarCursosAccordion() {
		EntityManager entityManager = Util.getEntityManager();

		return entityManager.createQuery("from Curso where nome in ('java',"+
				 "'c', 'python', 'html')").getResultList();
		
	}

}
