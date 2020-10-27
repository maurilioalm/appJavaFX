package gui;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import negocio.entidades.Cliente;
import negocio.entidades.Colaborador;
import negocio.entidades.OrdemServico;
import negocio.entidades.Peca;
import repositorios.RepositorioCliente;
import repositorios.RepositorioColaborador;
import repositorios.RepositorioOrdemServico;
import repositorios.RepositorioPecas;

public class Main extends Application {

	private static Stage stage;
	private static Scene telaInicial;
	private static Scene telaCadastrarColaborador;
	private static Scene telaCadastrarPeca;
	private static Scene telaCadastrarCliente;
	private static Scene telaOrdemDeServico;
	private static Scene telaAdicionarServico;
	private static Scene telaListaCliente;
	private static Scene telaListaPeca;

	private static RepositorioPecas repoPecas = new RepositorioPecas();
	private static RepositorioColaborador repoColaborador = new RepositorioColaborador();
	private static RepositorioCliente repoCliente = new RepositorioCliente();
	private static RepositorioOrdemServico repoOs = new RepositorioOrdemServico();
	private static int controle;

	@Override
	public void start(Stage primeiroStage) {
		try {
			stage = primeiroStage;

			Parent parentTelaInicial = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
			telaInicial = new Scene(parentTelaInicial);

			Parent parenttelaCadastrarColaborador = FXMLLoader
					.load(getClass().getResource("TelaCadastrarColaborador.fxml"));
			telaCadastrarColaborador = new Scene(parenttelaCadastrarColaborador);

			Parent parenttelaCadastrarPeca = FXMLLoader.load(getClass().getResource("TelaCadastrarPeca.fxml"));
			telaCadastrarPeca = new Scene(parenttelaCadastrarPeca);

			Parent parenttelaCadastrarCliente = FXMLLoader.load(getClass().getResource("TelaCadastrarCliente.fxml"));
			telaCadastrarCliente = new Scene(parenttelaCadastrarCliente);

			Parent parenttelaOrdemDeServico = FXMLLoader.load(getClass().getResource("TelaOrdemDeServico.fxml"));
			telaOrdemDeServico = new Scene(parenttelaOrdemDeServico);

			Parent parenTtelaAdicionarServico = FXMLLoader.load(getClass().getResource("TelaAdicionarServico.fxml"));
			telaAdicionarServico = new Scene(parenTtelaAdicionarServico);

			Parent parentTelaListaCliente = FXMLLoader.load(getClass().getResource("TelaListaCliente.fxml"));
			telaListaCliente = new Scene(parentTelaListaCliente);

			Parent parentTelaListaPeca = FXMLLoader.load(getClass().getResource("TelaListaPeca.fxml"));
			telaListaPeca = new Scene(parentTelaListaPeca);

			primeiroStage.setScene(telaInicial);
			primeiroStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void mudarTela(int n) {
		switch (n) {
		case 1:{
			if (controle == 0) {
			stage.setScene(telaInicial);
			break;
			}else if(controle == 1) {
				mudarTela(5);
				break;
			}else if(controle == 2) {
				mudarTela(7);
				break;
			}else if(controle == 3) {
				mudarTela(8);
				break;
			}
		}
		case 2:
			stage.setScene(telaCadastrarColaborador);
			break;
		case 3:
			stage.setScene(telaCadastrarPeca);
			break;
		case 4:
			stage.setScene(telaCadastrarCliente);
			break;
		case 5:
				stage.setScene(telaOrdemDeServico);
			break;
		case 6:
			stage.setScene(telaAdicionarServico);
			break;
		case 7:
			stage.setScene(telaListaCliente);
			break;
		case 8:
			stage.setScene(telaListaPeca);
			break;
		}

	}
	public static void setControle(int n) {
		controle = n;
	}

	public static void salvarPecas(Peca peca) {
		repoPecas.inserir(peca);
	}

	public static void salvarColaborador(Colaborador colaborador) {
		repoColaborador.inserir(colaborador);
	}

	public static void salvarCliente(Cliente cliente) {
		repoCliente.inserir(cliente);
	}

	public static List<Peca> listaPecas() {
		return repoPecas.listarPecas();
	}

	public static Peca localizarPeca(String codigo) {
		return repoPecas.localizar(codigo);
	}

	public static Cliente localizarCliente(String cpf) {
		return repoCliente.localizar(cpf);
	}

	public static List<Cliente> listaCliente() {
		return repoCliente.localizarTodos();
	}

	public static String nomeClientes() {
		for (Cliente cliente : repoCliente.localizarTodos()) {
			return cliente.getNome();
		}
		return null;
	}

	public static void listaColaborador() {
		repoColaborador.listaColaborador();
	}

	public static boolean autenticacao(String nome, String matricula) {
		if (repoColaborador.altenticar(nome, matricula)) {
			return true;
		}
		return false;
	}

	public static boolean adicionarOs(OrdemServico ordemServico) {
		if(repoOs.inserir(ordemServico)){
			System.out.println("MAIN - Adicionada ao repositorio");
			return true;
		}
		System.out.println("Não Adicionada ao repositorio");
		return false;
	}
	public static void listarTodasOrdensRepo() {
		System.out.println(repoOs.listarTodasOrdensRepo());
	}

	public static Colaborador localizarColaborador(String matricula) {
		return repoColaborador.localizar(matricula);

	}
	public static OrdemServico buscaOS(Integer numOS) {
		return repoOs.localizar(numOS);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
