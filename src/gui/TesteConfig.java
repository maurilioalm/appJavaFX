package gui;

import negocio.entidades.Colaborador;
import repositorios.RepositorioColaborador;

public class TesteConfig {

	public TesteConfig() {
	}

	public static void teste() {
		Colaborador colaborador = new Colaborador("maurilio", "987654321", "987654321", "1234");
		RepositorioColaborador rColaborador = new RepositorioColaborador();
		rColaborador.inserir(colaborador);
		
	}
}
