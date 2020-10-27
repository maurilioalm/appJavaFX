package repositorios;

import java.util.ArrayList;
import java.util.List;

import negocio.entidades.Colaborador;

public class RepositorioColaborador implements IRepositorio<Colaborador> {

	private List<Colaborador> colaboradores = new ArrayList<Colaborador>();

	@Override
	public Colaborador localizar(String matricula) {
		Colaborador obj = null;
		for (Colaborador colaborador : colaboradores) {
			if (colaborador.getMatricula().equals(matricula)){
				obj = colaborador;
			}
		}
		return obj;
	}

	@Override
	public List<Colaborador> localizarTodos() {
		return colaboradores;
	}

	@Override
	public boolean inserir(Colaborador colaborador) {
		if (colaboradores.contains(colaborador)) {
			return false;
		} else {
			colaboradores.add(colaborador);
			return true;
		}
	}

	@Override
	public boolean deletar(String cpf) {
		for (Colaborador colaborador : colaboradores) {
			if (colaborador.getCpf() == cpf) {
				colaboradores.remove(colaborador);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean atualizar(String cpf, Colaborador colaborador) {
		for (Colaborador aux : colaboradores) {
			if (aux.getCpf() == cpf) {
				updateColaborador(aux, colaborador);
				return true;
			}
		}
		return false;
	}

	private void updateColaborador(Colaborador aux, Colaborador colaborador) {
		aux.setNome(colaborador.getNome());
		aux.setRg(colaborador.getRg());
		aux.setMatricula(colaborador.getMatricula());

	}

	public void listaColaborador() {
		for (Colaborador colaborador : colaboradores) {
			System.out.println(colaborador);
		}
	}

	public boolean altenticar(String nome, String matricula) {
		for (Colaborador colaborador : colaboradores) {
			if (nome.equals(colaborador.getNome()) && matricula.equals(colaborador.getMatricula())) {
				System.out.println("Repo - Colaborador" + colaborador);
				return true;
			}
		}
		return false;
	}
}
