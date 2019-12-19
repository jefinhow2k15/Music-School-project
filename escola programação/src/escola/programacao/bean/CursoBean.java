package escola.programacao.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import escola.programacao.dao.CursoDAO;
import escola.programacao.modelo.Curso;
import escola.programacao.modelo.TipoCurso;


@ManagedBean
@SessionScoped 
public class CursoBean {

	private static final String X = null;
	private Curso curso;
	private List<TipoCurso> tipos = Arrays.asList(TipoCurso.values());
	private List<Curso> cursos = new ArrayList<Curso>();
	private List<Curso> cursosAccordion = new ArrayList<Curso>();

	
	public CursoBean() {
		cursos = new CursoDAO().listarTodos();
		cursosAccordion = CursoDAO.listarCursosAccordion();
		curso = new Curso();
		criarLinhasModelo();
	}
	
	public List<Curso> getCursosAccordion() {
		return cursosAccordion;
	}

	public void setCursosAccordion(List<Curso> cursosAccordion) {
		this.cursosAccordion = cursosAccordion;
	}

	public String salvar() {
		new CursoDAO().salvar(curso);
		cursos = new CursoDAO().listarTodos();
		curso = new Curso();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo Com Sucesso"));
		return "curso-lista?faces-redirect=true";
	}
	
	public String editar(Curso curso) {
		this.curso = curso;
		return "curso-formulario?faces-redirect=true";
	}
	
	public void excluir(Curso curso) {
		new CursoDAO().excluir(curso);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Curso Excluído"));
		cursos = new CursoDAO().listarTodos();
	}
	
	private LineChartModel lineModel;
	
	LineChartModel model = new LineChartModel();
	LineChartSeries seriel = new LineChartSeries();
	
	public LineChartModel getLineModel() {
		return lineModel;
	}
	
	
	public void init() {
		criarLinhasModelo();
	}
	
	private LineChartModel iniciarModeloLinear() {
		seriel.setLabel("Linha 1");
		
		for(int i = 0; i < cursos.size(); i++) {
			int intRandom = (int)(Math.random() * cursos.size());
			seriel.getData().put(i, intRandom);
		}
		 
		model.addSeries(seriel);
		
		return model;
	}
	
	public void criarLinhasModelo() {
		model = iniciarModeloLinear();
		model.setTitle("linear");
		model.setLegendPosition("e");
		Axis yAxis = model.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(cursos.size());
		yAxis.setTickFormat("%d");
		yAxis.setLabel("Unidade");
		
	}
	
	
	
	private Map<? extends org.primefaces.model.chart.AxisType, ? extends Axis> AxisType(String x2, CategoryAxis categoryAxis) {
		// TODO Auto-generated method stub
		return null;
	}

	private LineChartModel iniciarModeloCategoria() {
		LineChartModel model = new LineChartModel();
		
		return model;
	}

	public LineChartModel getModel() {
		return model;
	}

	public void setModel(LineChartModel model) {
		this.model = model;
	}

	public LineChartSeries getSeriel() {
		return seriel;
	}

	public void setSeriel(LineChartSeries seriel) {
		this.seriel = seriel;
	}

	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public Curso getCurso() {
		return curso;
	}

	public List<TipoCurso> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoCurso> tipos) {
		this.tipos = tipos;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
}
