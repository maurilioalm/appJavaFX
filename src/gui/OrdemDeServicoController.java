package gui;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import negocio.entidades.Cliente;
import negocio.entidades.Colaborador;
import negocio.entidades.OrdemServico;
import negocio.entidades.Peca;
import negocio.entidades.Servico;
import negocio.entidades.enums.StatusServico;

public class OrdemDeServicoController implements Initializable {

	private static OrdemServico os;
	private static Colaborador co;

	public OrdemDeServicoController() {
	}

	@FXML
	public Label mostrarColaborador;
	@FXML
	public Label mostrarServico;
	@FXML
	public Label mostrarCliente;
	@FXML
	public Label mostrarDataEntrada;
	@FXML
	public Label mostrarPecas;
	@FXML
	public Label mostrarPrecoTotal;
	@FXML
	public Label mostrarDataSaida;
	@FXML
	public Label mostrarNumOS;
	@FXML
	private TextField textDesconto;
	@FXML
	private TextField textAdiantamento;
	@FXML
	private TextField textBuscarOS;

	@FXML
	private Button bVoltar;
	@FXML
	private Button bMostrarColaborador;
	@FXML
	private Button bAddCliente;
	@FXML
	private Button bAddServico;
	@FXML
	private Button bAddPecas;
	@FXML
	private Button bAddEmitirOS;
	@FXML
	private Button bBuscarOS;
	@FXML
	private RadioButton bAberto;
	@FXML
	private RadioButton bEncaminhado;
	@FXML
	private RadioButton bConcluido;
	@FXML
	private RadioButton bCancelado;
	@FXML
	private RadioButton rbAvista;
	@FXML
	private RadioButton rbCartao;
	@FXML
	private RadioButton rbDebito;

	@FXML
	public void bEmitirOsAcao() {

		if (os.getCliente() != null && os.getServico() != null && os.getStatusServico() != null) {
			Alert alerta = new Alert(Alert.AlertType.INFORMATION);
			alerta.setTitle("Processo realizado com sucesso");
			alerta.setHeaderText("Emissão da Ordem de Servico realizada");
			alerta.setContentText("Status da OS: " + os.getStatusServico());
			alerta.show();
			Main.adicionarOs(os);
			novaOS(os);
			System.out.println("OS emitada");
			Main.listarTodasOrdensRepo();
			criarColaboradorOrdemServico(os.getColaborador().getMatricula());

		} else {
			Alert alerta = new Alert(Alert.AlertType.WARNING);
			alerta.setTitle("ERRO");
			alerta.setHeaderText("Emissão não realizada");
			alerta.setContentText("Preencha os dados antes");
			alerta.show();
		}
	}

	@FXML
	public void bBuscarOSAcao() {
		if (textBuscarOS.getText() != null && !textBuscarOS.getText().isEmpty()) {
			Integer numOS = (Integer.parseInt(textBuscarOS.getText()));
			System.out.println("Buscando");
			os = Main.buscaOS(numOS);
			System.out.println("OS trazida do repositorio" + os);
		}
		else {
			criarColaboradorOrdemServico(os.getColaborador().getMatricula());
		}
		// bAtualizarDados();
	}

	@FXML
	public void rbAvistaAcao() {
		System.out.println("Pagamento a vista");
		os.setTipoPagamento("A VISTA");
	}

	@FXML
	public void rbCartaoAcao() {
		System.out.println("Pagamento no Credito");
		os.setTipoPagamento("CREDITO");

	}

	@FXML
	public void rbDebitoAcao() {
		System.out.println("Pagamento no Debito");
		os.setTipoPagamento("DEBITO");
	}

	@FXML
	public void bAbertoAcao() {
		System.out.println("Aberto");
		os.setStatusServico(StatusServico.ABERTO);

	}

	@FXML
	public void bEncaminhadoAcao() {
		System.out.println("Encaminhado");
		os.setStatusServico(StatusServico.ENCAMINHADO);
	}

	@FXML
	public void bConcluidoAcao() {
		System.out.println("Concluido");
		os.setStatusServico(StatusServico.CONCLUIDO);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy  hh:mm a");
		mostrarDataSaida.setText("Data de saida: " + dtf.format(os.getDataSaida().now()));
	}

	@FXML
	public void bCandeladoAcao() {
		System.out.println("Cancelado");
		os.setStatusServico(StatusServico.CANCELADO);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy  hh:mm a");
		mostrarDataSaida.setText("Data de saida: " + dtf.format(os.getDataSaida().now()));
	}

	@FXML
	public void bVolarAcao() {
		Main.setControle(0);
		Main.mudarTela(1);
	}

	@FXML
	public void bAtualizarDados() {
		if (mostrarColaborador != null) {
			mostrarColaborador.setText("Responsável: " + co.getNome());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy  hh:mm a");
			mostrarDataEntrada.setText("Data de entrada: " + dtf.format(os.getDataEntrada()));
			mostrarNumOS.setText("Numero da OS: " + os.getNumOS());
		}
		if (os.getServico() != null) {
			mostrarServico.setText("Serviço: " + os.getServico().getTipoServico() + "\nDescrição: "
					+ os.getServico().getDescricaoServico() + "\nPreco do Servico: R$ " + os.getServico().getPreco());
			System.out.println(os);
		}
		if (os.getCliente() != null) {
			mostrarCliente.setText("Nome: " + os.getCliente().getNome() + " CPF: " + os.getCliente().getCpf()
					+ " Telefone: " + os.getCliente().getTelefone() + " Email: " + os.getCliente().getEmail());
		}
		if (os.getPecas() != null && !os.getPecas().isEmpty()) {
			mostrarPecas.setText("Codigo: " + os.localizarPeca(os.getPecas()).getCodigo() + " Descricao: "
					+ os.localizarPeca(os.getPecas()).getDescricao() + "   Preco: R$"
					+ String.valueOf(os.localizarPeca(os.getPecas()).getPreco()));
		}
		if (os.getPecas() != null && !os.getPecas().isEmpty() && os.getServico() == null) {
			os.setDesconto(Double.parseDouble(textDesconto.getText()));
			os.setAdiantamento(Double.parseDouble(textAdiantamento.getText()));
			mostrarPrecoTotal.setText("Preco Total: R$ " + String.valueOf(os.localizarPeca(os.getPecas()).getPreco()));
		} else if (os.getServico() != null && (os.getPecas() == null || os.getPecas().isEmpty())) {
			mostrarPrecoTotal.setText("Preco Total: R$ " + os.getServico().getPreco() + " (Somente o Servico)");
		} else if (os.getServico() != null && (os.getPecas() != null && !os.getPecas().isEmpty())) {
			os.setDesconto(Double.parseDouble(textDesconto.getText()));
			os.setAdiantamento(Double.parseDouble(textAdiantamento.getText()));
			mostrarPrecoTotal.setText("Preco Total: R$ "
					+ (os.getServico().getPreco() + os.localizarPeca(os.getPecas()).getPreco() - os.getDesconto()
							- os.getAdiantamento())
					+ " = R$: " + String.valueOf(os.localizarPeca(os.getPecas()).getPreco()) + " (Pecas) + R$: "
					+ os.getServico().getPreco() + " (Servico) \n" + "Desconto R$: " + String.valueOf(os.getDesconto())
					+ " Adiantamento R$: " + String.valueOf(os.getAdiantamento()));
		}

	}

	@FXML
	public void bAddClienteAcao() {
		Main.setControle(2);
		Main.mudarTela(7);
	}

	@FXML
	public void bTelaGerarServicoAcao() {
		Main.mudarTela(6);
	}

	@FXML
	public void bTelaListaPecaAcao() {
		Main.setControle(3);
		Main.mudarTela(8);
	}

	public void addServico(Servico servico) {
		os.setServico(servico);
	}

	public void addCliente(Cliente cliente) {
		os.setCliente(cliente);
	}

	public void addPeca(Peca peca) {
		os.setPecas(peca);
	}

	public void criarColaboradorOrdemServico(String matricula) {
		OrdemServico ordemServico = new OrdemServico();
		Colaborador colaborador = new Colaborador();
		colaborador = Main.localizarColaborador(matricula);
		co = colaborador;
		ordemServico.setColaborador(colaborador);
		os = ordemServico;
	}

	public String nomeDoColaborador(Colaborador colaborador) {
		return colaborador.getNome();
	}

	public void novaOS(OrdemServico os) {
		System.out.println("Nova OS entrada");
		/*
		 * os.setDataEntrada(null); os.setDataEntrada(); os.setNumOS(os.positivo());
		 * os.setCliente(null); os.setAdiantamento(0.0); os.setDesconto(0.0);
		 * os.setServico(null); os.removePecas(); os.setStatusServico(null);
		 */
		System.out.println("Dados Nova OS" + os);
		mostrarDataEntrada.setText("Data_EntradaOS");
		mostrarCliente.setText("Nome_do_Cliente");
		mostrarServico.setText("Descricao_do_Servico");
		mostrarPecas.setText("Não houve pecas");
		textAdiantamento.setText("0");
		textDesconto.setText("0");
		mostrarPrecoTotal.setText("Valor_Total_OS");
		bAberto.setText(null);
		bEncaminhado.setText(null);
		bConcluido.setText(null);
		bCancelado.setText(null);
		System.out.println("Nova OS saida");

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Colaborador colaborador = new Colaborador();
		colaborador.setNome("a");
		colaborador.setMatricula("a");
		colaborador.setCpf("123");
		Colaborador colaborador1 = new Colaborador();
		colaborador1.setNome("Maurilio");
		colaborador1.setMatricula("123456");
		Main.salvarColaborador(colaborador1);
		Main.salvarColaborador(colaborador);

		Cliente cliente0 = new Cliente("Mario do Carmo", "139,123,412", "123456", "(81) 99699-4432", "Rua 10, Recife",
				"Maria@gmail.com");
		Cliente cliente1 = new Cliente("João Alves", "139,123,412", "3210", "(81) 99699-4432", "Rua 10, Recife",
				"joaogmail.com");
		Cliente cliente2 = new Cliente("Ana Silva", "139,123,412", "a", "(81) 99699-4432", "Rua 10, Recife",
				"ana@gmail.com");
		Main.salvarCliente(cliente0);
		Main.salvarCliente(cliente1);
		Main.salvarCliente(cliente2);

		Peca peca0 = new Peca("1234", "HD 2TB WesterDigital", 250.99, 10);
		Peca peca1 = new Peca("4321", "FONTE DE ALIMENTACAO 500W", 380.00, 10);
		Peca peca2 = new Peca("a", "TELA NOTEBOOK IPS", 600.00, 10);
		Main.salvarPecas(peca0);
		Main.salvarPecas(peca1);
		Main.salvarPecas(peca2);

	}

}