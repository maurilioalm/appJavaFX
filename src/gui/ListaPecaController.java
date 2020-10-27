package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.entidades.Peca;

public class ListaPecaController extends OrdemDeServicoController implements Initializable {

	@FXML
	private TableView<Peca> tblPecas;
	@FXML
	private TableColumn<Peca, String> clDescricao;
	@FXML
	private TableColumn<Peca, Double> clPreco;
	@FXML
	private TableColumn<Peca, String> clCodigo;

	@FXML
	private TextField textCodigo;

	@FXML
	private Button bVoltar;
	@FXML
	private Button bSelecionar;
	@FXML
	private Button bAtualizar;
	@FXML
	private Button bCadastrar;

	@FXML
	public void bCadastrarAcao() {
		Main.mudarTela(3);
	}

	@FXML
	public void bVolarAcao() {
		Main.mudarTela(5);
	}

	@FXML
	public void bAtualizarAcao() {
		System.out.println(Main.listaPecas());
		tblPecas.getItems().setAll(Main.listaPecas());
	}

	@FXML
	public void bSelecionarrAcao() {
		Peca peca = Main.localizarPeca(textCodigo.getText());
		super.addPeca(peca);
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("Peca");
		alerta.setHeaderText("Peca selecionada");
		alerta.setContentText("Nome: " + peca.getDescricao() + "\nAtualize a OS para verificar");
		alerta.show();
		Main.mudarTela(5);

	}

	public void refreshTable() {
		tblPecas.getItems().setAll(Main.listaPecas());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		clDescricao.setCellValueFactory(new PropertyValueFactory<Peca, String>("descricao"));
		clPreco.setCellValueFactory(new PropertyValueFactory<Peca, Double>("preco"));
		clCodigo.setCellValueFactory(new PropertyValueFactory<Peca, String>("codigo"));

	}

}
