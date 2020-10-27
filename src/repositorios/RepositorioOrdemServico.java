package repositorios;

import java.util.ArrayList;
import java.util.List;

import negocio.entidades.OrdemServico;

public class RepositorioOrdemServico {

	public RepositorioOrdemServico() {
	}

	private List<OrdemServico> ordensServico = new ArrayList<OrdemServico>();

	public OrdemServico localizar(Integer numOS) {
		for (OrdemServico os : ordensServico) {
			System.out.println("Entrou no localizar imprimindo OS:" + os);
			System.out.println(numOS);
			System.out.println(os.getNumOS());
			if (numOS.equals(os.getNumOS())) {
				System.out.println("Entrou no IF");
				return os;
			}
		}
		return null;
	}

	public boolean inserir(OrdemServico os) {
		if(ordensServico.add(os)) {
			System.out.println("Adicionada ao Reposito: " + ordensServico);
			
			return true;
		}
		return false;
	/*	if (ordensServico.contains(ordemServico)) {
			return false;
		} else {
			ordensServico.add(ordemServico);
			System.out.println("Repo OS - Inserida no Repositorio");
			System.out.println(ordemServico.getNumOS());
			return true;
		}*/
	}
	public List<OrdemServico> listarTodasOrdensRepo(){
		return ordensServico;
	}

	public void listaOrdemServico() {
		for (OrdemServico ordemServico : ordensServico) {
			System.out.println(ordemServico);
		}
	}

}
